package 查找;

/**
 * 二分查找
 */
public class 二分查找APP {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 7, 10};
        System.out.println(search(arr, 10));
    }

    public static int search(int[] arr, int key) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;
        int middle;

        while (start <= end) {
            middle = (start + end) / 2;
            int middleVal = arr[middle];
            if (middleVal == key) {
                return middle;
            }
            if (middleVal < key) {
                start = middle + 1;
            }
            if (middleVal > key) {
                end = middle - 1;
            }
        }
        return -1;

    }

}
