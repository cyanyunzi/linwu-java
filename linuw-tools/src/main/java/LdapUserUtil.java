//import com.sun.org.slf4j.internal.Logger;
//import com.sun.org.slf4j.internal.LoggerFactory;
//
//import javax.naming.NamingEnumeration;
//import javax.naming.directory.Attribute;
//import javax.naming.directory.DirContext;
//import javax.naming.directory.SearchControls;
//import javax.naming.directory.SearchResult;
//import java.util.ArrayList;
//import java.util.List;
//
//public class LdapUserUtil {
//
//
//    private static Logger LOGGER = LoggerFactory.getLogger(LdapUserUtil.class);
//     LdapUtil ldapUtil;
//    /**
//     * AD用户名密码登录验证
//     * @param userId
//     * @param password
//     * @param dc
//     * @param dn
//     * @return
//     * @throws CustomException
//     */
//    public Boolean vailidateUserLogin(String userId, String password, DirContext dc, String dn) throws CustomException{
//        if (dc == null) {
//            dc = ldapUtil.initSSL();
//            if(dc==null){
//                return false;
//            }
//        }
//        if(dn==null){
//            dn = getUserDN(dc, userId);
//        }
//        if (StringUtils.isBlank(dn)) {
//            return false;
//        } else {
//            DirContext dcValid = ldapUtil.init(dn, password);
//            Boolean isValid = false;
//            if (dcValid != null) {
//                isValid = true;
//            }
//            ldapUtil.close(dcValid);
//            return isValid;
//        }
//    }
//
//    /**
//     * 获取AD所有用户
//     *
//     * @param dc
//     * @param account
//     * @param attribute
//     * @return
//     */
//    public List<String> getADUser(DirContext dc) {
//        List<String> list = new ArrayList<String>();
//        SearchControls searchCtls = new SearchControls();
//        searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);
//        String searchFilter = "(&(objectclass=user))";
//        String returnedAtts[] = { "distinguishedName" }; // 定制返回属性
//        searchCtls.setReturningAttributes(returnedAtts); // 设置返回属性集
//        try {
//            NamingEnumeration<SearchResult> answer = dc.search("OU=重庆小康控股有限公司,DC=yuan,DC=com", searchFilter, searchCtls);
//            while (answer.hasMoreElements()) {
//                SearchResult sr = (SearchResult) answer.next();
//                Attribute attr = sr.getAttributes().get("distinguishedName");
//                if (attr != null) {
//                    String dn = attr.get().toString();
//                    System.out.println(dn);
//                    list.add(dn);
//                }
//            }
//        } catch (Exception e) {
//            LOGGER.error(" 获取AD所有用户==》失败");
//            LOGGER.error(e.getMessage());
//            e.printStackTrace();
//        }
//        return list;
//    }
//}
