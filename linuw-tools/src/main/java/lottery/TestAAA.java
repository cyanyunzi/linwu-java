package lottery;

import java.util.Random;

public class TestAAA {
    public static void main(String[] args) {
        int x = new Random()
                .nextInt(2);
        if(x%2==0){
            System.out.println("run");
        }
    }
}
