import cer.DummySSLSocketFactory;
import cer.LdapSocketFactory;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.*;
import java.util.Hashtable;

public class LdapSyncUserUtil {
    static String keystore = "/Library/Java/JavaVirtualMachines/zulu-8.jdk/Contents/Home/jre/lib/security/cacerts";

//    static String url = "ldap://192.168.114.31:389";
    static String url = "ldap://192.168.114.31:636";
    //一般认证连接389端口即可，集团主AD服务器 10.0.0.1
    static String username = "cn=administrator,cn=Users,dc=demo,dc=com";
    static String pwd = "123asd$%^FGH";
//    static String username = "cn=cyanyunzi1,ou=venus,dc=demo,dc=com";
//    static String pwd = "Qing242620";


    public static LdapContext init() throws Exception {
        System.setProperty("com.sun.jndi.ldap.object.disableEndpointIdentification","true");
        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.PROVIDER_URL, url);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        //用户名称，cn,ou,dc 分别：用户，组，域
        env.put(Context.SECURITY_PRINCIPAL, username);
        env.put(Context.SECURITY_CREDENTIALS, pwd);
        env.put(Context.SECURITY_PROTOCOL, "ssl");//链接认证服务器
//        env.put("com.sun.jndi.ldap.connect.timeout", "1");
        String name = DummySSLSocketFactory.class.getName();
//        env.put("java.naming.ldap.factory.socket", name);
        env.put("java.naming.ldap.factory.socket", LdapSocketFactory.class.getName());
//
        LdapContext ldapCtx = new InitialLdapContext(env, null);
        return ldapCtx;
    }

    public static void main(String[] args) throws Exception {
        syncUser();
//        validLoginUser();
        System.out.println(1);

    }

    private static void validLoginUser() throws Exception {
        System.setProperty("com.sun.jndi.ldap.object.disableEndpointIdentification","true");
        InitialDirContext ctx = null;
        Hashtable<String, String> HashEnv = new Hashtable<String, String>();
        HashEnv.put(Context.PROVIDER_URL, url);// 默认端口389
        HashEnv.put(Context.SECURITY_AUTHENTICATION, "simple"); // LDAP访问安全级别(none,simple,strong)
        HashEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory"); // LDAP工厂类
        HashEnv.put(Context.SECURITY_PRINCIPAL, username); //AD的用户名
        HashEnv.put(Context.SECURITY_CREDENTIALS, pwd); //AD的密码
        HashEnv.put(Context.SECURITY_PROTOCOL, "ssl");//链接认证服务器



        try {
            ctx = new InitialDirContext(HashEnv);// 初始化上下文
        } catch (AuthenticationException e) {
            System.out.println("认证失败,账号或密码错误");//LDAP: error code 49 - 80090308
            throw new RuntimeException(e);
        } finally {
            if (ctx != null) {
                try {
                    ctx.close();
                } catch (NamingException e) {
                    System.out.println("关闭LDAP认证流失败");
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("认证成功");
    }

    private static void syncUser() throws Exception {
        LdapContext ldapCtx = init();
        int pageSize = 1;//程序单次查询最大条数

        //构建查询条件
        SearchControls searchCtls = new SearchControls();
        searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        ldapCtx.setRequestControls(new Control[]{new PagedResultsControl(pageSize, Control.CRITICAL)});
        String searchFilter = "objectClass=User";
        String name = "OU=venus,DC=demo,DC=com";
        ldapCtx.setRequestControls(new Control[]{new PagedResultsControl(pageSize, Control.CRITICAL)});

        byte[] cookie = null;//用于判断是否还有剩余数据（进行分页）

        int count = 0;
        int page = 1;
        do {

            System.out.println(String.format("当前页码:%s", page));
            NamingEnumeration<SearchResult> answer = ldapCtx.search(name, searchFilter, searchCtls);
            while (answer != null && answer.hasMore()) {
                SearchResult sr = answer.next();
                System.out.println(sr.getName());
                System.out.println(sr.getAttributes().get("name").get());
                count = count + 1;
            }

            //读取cookie，判断是否有未读取完
            Control[] controls = ldapCtx.getResponseControls();
            if (controls != null) {
                for (int i = 0; i < controls.length; i++) {
                    if (controls[i] instanceof PagedResultsResponseControl) {
                        PagedResultsResponseControl prrc = (PagedResultsResponseControl) controls[i];
                        cookie = prrc.getCookie();
                    }
                }
            }

            // 将cookie提供给LdapContext，让它在接下来的查询中进行换页
            ldapCtx.setRequestControls(new Control[]{new PagedResultsControl(pageSize, cookie, Control.CRITICAL)});
            page = page + 1;

        } while (cookie != null);

        System.out.println("总用户数:" + count);
    }
}
