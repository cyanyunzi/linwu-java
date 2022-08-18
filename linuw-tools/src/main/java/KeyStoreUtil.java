import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.Enumeration;

public class KeyStoreUtil {
    private static String keystorePassword = "changeit";
    private static String keystorePath = "/Library/Java/JavaVirtualMachines/zulu-8.jdk/Contents/Home/jre/lib/security/cacerts";
    private static KeyStore keyStore;

    static {
        try {
            keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            FileInputStream fis = new FileInputStream(keystorePath);
            keyStore.load(fis, keystorePassword.toCharArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        getAliases();
//        delete("wintest");
    }

    private static void getAliases() throws KeyStoreException {
        Enumeration<String> aliases = keyStore.aliases();
        while (aliases.hasMoreElements()) {
            String aliase = aliases.nextElement();
            System.out.println("aliase:" + aliase);
        }
    }

    public static void delete(String aliase) throws KeyStoreException {
        keyStore.deleteEntry("aliase");
    }
}
