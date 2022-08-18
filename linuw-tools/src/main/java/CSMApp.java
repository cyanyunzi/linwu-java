public class CSMApp {
    private static  int o = 0;

    static {
        try {
            o = 1 / 0;
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println();
        }
    }

    public void test(){
        System.out.println(1);
    }

    public static void main(String[] args) {
        CSMApp csmApp = new CSMApp();
        System.out.println("第1次调用");
        csmApp.test();
        System.out.println("第2次调用");
        csmApp.test();
    }
}
