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

        if (end - start <= 1)
            return;

        int pivot = start + (end - start) / 2;

        int i = start;
        int j = end;
        while (i < j) {
            if (x[i] < x[pivot]) {
                i++;
            }
            if (x[j] > x[pivot]) {
                j--;
            }
            if (x[i] >= x[pivot] && x[j] <= x[pivot]) {
                swap(x, i, j);
                i++;
                j--;
            }
        }

        quickSort(x, start, pivot - 1);
        quickSort(x, pivot + 1, end);

    }

    private static void swap(int[] x, int i, int j) {
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }

}
