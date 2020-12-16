package sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] x = new int[]{5, 4, 6, 8, 6, 4, 5, 7, -1, -2};

        System.out.println(Arrays.toString(x));
        quickSort(x, 0, x.length - 1);
        System.out.println(Arrays.toString(x));

    }

    private static void quickSort(int[] x, int start, int end) {

        if (end - start <= 0)
            return;

        int pivot = x[start + (end - start) / 2];

        int i = start;
        int j = end;
        while (i <= j) {
            while (x[i] < pivot) {
                i++;
            }
            while (x[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(x, i, j);
                i++;
                j--;
            }
        }

        quickSort(x, start, j);
        quickSort(x, i, end);

    }

    private static void swap(int[] x, int i, int j) {
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }

}
