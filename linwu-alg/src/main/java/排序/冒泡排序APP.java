package 排序;

import java.util.Arrays;

/**
 * 1. 内循环是把最大的值先排到右边
 * 2. 外循环只是内循环的步骤
 */
public class 冒泡排序APP {
    public static void main(String[] args) {
        int[] arr = {0, 4, 2, 3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int current = arr[i];
                int next = arr[j];
                if (current > next) {
                    arr[i] = next;
                    arr[j] = current;
                }
            }
        }
    }
}
