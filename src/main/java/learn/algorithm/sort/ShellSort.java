package learn.algorithm.sort;

/**
 * Created by Administrator on 2020/4/6.
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] mergeArray = new int[]{17, 34, 12, 2, 33, 5, 67, 18, 4, 22};
        shellsort(mergeArray);
        for (int a : mergeArray) {
            System.out.println(a);
        }


    }

    static void shellsort(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < array.length; i++) {
                int j = i;
                int temp = array[j];
                while (j - gap >=0 && array[j - gap] > temp) {
                    array[j] = array[j - gap];
                    j = j - gap;
                }
                array[j] = temp;

            }
        }
    }
}
