public class 标量替换APP {

    public static void main(String[] args) {
        //开启逃逸分析:  -XX:+DoEscapeAnalysis
        //关闭逃逸分析：-XX:-DoEscapeAnalysis
        //-XX：+PrintEscapeAnalysis

        //开启标量替换：-XX:+EliminateAllocations
        //关闭标量替换：-XX:-EliminateAllocations
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            m1();
        }
        new Object();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }

    private static void m1(){
        Model model = new Model(1);
        int a = model.a;
    }

    private static class Model{
        private int a;
        public Model(int a){
            this.a = a;
        }
    }


}
