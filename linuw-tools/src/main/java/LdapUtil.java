//import com.sun.org.slf4j.internal.Logger;
//import com.sun.org.slf4j.internal.LoggerFactory;
//
//import javax.naming.Context;
//import javax.naming.directory.DirContext;
//import javax.naming.directory.InitialDirContext;
//import javax.naming.ldap.InitialLdapContext;
//import javax.naming.ldap.LdapContext;
//import java.util.Hashtable;
//
//public class LdapUtil {
//    private static Logger LOGGER = LoggerFactory.getLogger(LdapUtil.class);
//    String url = "ldap://10.0.0.1:389/";
//    //一般认证连接389端口即可，集团主AD服务器 10.0.0.1
//    String urls = "ldap://10.0.0.1:636/";
//    //如果需要往AD中写入信息需要连接636加密端口，连接636端口需要将AD证书导入JAVA证书信任库
//    String username = "cn=admin,ou=users,dc=yuan,dc=com";
//    // 连接AD的用户,此处账户需向集团AD管理员张武林申请。
//    String pwd ="xxx";
//    // pwd
//    /**
//     * 连接AD服务器或者登陆验证
//     */
//    public DirContext init() {
//        DirContext dc = null;
//        Hashtable<String, String> env = new Hashtable<String, String>();
//        env.put(Context.PROVIDER_URL, url);
//        env.put(Context.SECURITY_PRINCIPAL, username);
//        env.put(Context.SECURITY_CREDENTIALS, pwd);
//        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
//        env.put(Context.SECURITY_AUTHENTICATION, "simple");
//        try {
//            dc = new InitialDirContext(env);// 初始化上下文
//            System.out.println("认证成功");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("认证失败");
//        }
//        return dc;
//    }
//    public LdapContext initSSL() {
//        LdapContext dc = null;
//        System.setProperty("javax.net.ssl.trustStore", XXX);
////连接JAVA证书信任库
//        System.setProperty("javax.net.ssl.trustStorePassword", XXX);
//        Hashtable<String, String> env = new Hashtable<String, String>();
//        env.put(Context.PROVIDER_URL, urls);
//        env.put(Context.SECURITY_PRINCIPAL, username);
//        env.put(Context.SECURITY_CREDENTIALS, pwd);
//        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
//        env.put(Context.SECURITY_AUTHENTICATION, "simple");
//        env.put(Context.SECURITY_PROTOCOL, "ssl");
////标记为加密连接
//        try {
//            dc = new InitialLdapContext(env,null);// 初始化上下文
//            System.out.println("认证成功");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("认证失败");
//        }
//        return dc;
//    }
//}
//}
