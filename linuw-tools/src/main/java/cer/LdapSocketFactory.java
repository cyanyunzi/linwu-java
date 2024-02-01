package cer;

import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyStore;

public class LdapSocketFactory extends SocketFactory {

    private static String certFileName = "/Library/Java/JavaVirtualMachines/zulu-8.jdk/Contents/Home/jre/lib/security/cacerts";


    private SSLSocketFactory factory;

    public LdapSocketFactory() {
        try {
            InputStream certStream = new FileInputStream(certFileName);
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(certStream, "changeit".toCharArray());
//            keyStore.deleteEntry("test1");
            System.out.println(keyStore.size());

            TrustManagerFactory trustManagerFactory = TrustManagerFactory
                    .getInstance("SunX509", "SunJSSE");
            trustManagerFactory.init(keyStore);

            SSLContext sslcontext = SSLContext.getInstance("TLS");
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            for (int i = 0; i < trustManagers.length; i++) {
                TrustManager trustManager = trustManagers[i];
                System.out.println(1);
            }
            sslcontext.init(null, trustManagers, new java.security.SecureRandom());
            factory = (SSLSocketFactory) sslcontext.getSocketFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SocketFactory getDefault() {
        return new LdapSocketFactory();
    }


    public Socket createSocket(Socket socket, String s, int i, boolean flag) throws IOException {
        return factory.createSocket(socket, s, i, flag);
    }

    public Socket createSocket(InetAddress inaddr, int i, InetAddress inaddr1, int j) throws IOException {
        return factory.createSocket(inaddr, i, inaddr1, j);
    }

    public Socket createSocket(InetAddress inaddr, int i) throws IOException {
        return factory.createSocket(inaddr, i);
    }

    public Socket createSocket(String s, int i, InetAddress inaddr, int j) throws IOException {
        return factory.createSocket(s, i, inaddr, j);
    }

    public Socket createSocket(String s, int i) throws IOException {
        return factory.createSocket(s, i);
    }

    public String[] getDefaultCipherSuites() {
        return factory.getSupportedCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return factory.getSupportedCipherSuites();
    }

}
