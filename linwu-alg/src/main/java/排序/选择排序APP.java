package 排序;

import java.util.Arrays;

/**
 * 1. 内循环只找比外循环小的
 */
public class 选择排序APP {
    public static void main(String[] args) {
        int[] arr = {0, 4, 2, 3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        OUTER:
        for (int i = 0; i < arr.length; i++) {
            int ourter = arr[i];
            INNER:
            for (int j = i; j < arr.length; j++) {
                int inner = arr[j];
                if (inner < ourter) {
                    arr[i] = inner;
                    arr[j] = ourter;
                    break INNER;
                }
            }
        }
    }
}
