package sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] x = new int[]{1, 2, 5, 4, 6, 8, 7, -1, -4};
        System.out.println(Arrays.toString(x));
        mergeSort(x, 0, x.length - 1);
        System.out.println(Arrays.toString(x));
    }

    private static void mergeSort(int[] x, int start, int end) {

        if (start < end) {
            int pivot = (start + end) / 2;

            mergeSort(x, start, pivot);
            mergeSort(x, pivot + 1, end);

            merge(x, start, pivot, end);
        }
    }

    private static void merge(int[] x, int start, int pivot, int end) {

        int i = start;
        int j = pivot + 1;

        int k = 0;
        int[] output = new int[x.length];
        while (i <= pivot && j <= end) {
            if (x[i] <= x[j]) {
                output[k] = x[i];
                i++;
            } else if (x[i] > x[j]) {
                output[k] = x[j];
                j++;
            }
            k++;
        }

        while (i <= pivot) {
            output[k] = x[i];
            i++;
            k++;
        }

        while (j <= end) {
            output[k] = x[j];
            k++;
            j++;
        }

        for (i = start; i <= end; i++) {
            x[i] = output[i - start];
        }

    }
}
