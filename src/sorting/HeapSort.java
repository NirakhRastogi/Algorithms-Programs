package sorting;

import java.util.Arrays;

public class HeapSort {
    // -1 for ascending, 1 for descending
    public static void main(String[] args) {
        int[] x = new int[]{1, 5, 4, 7, 9, 7, 6, -1, -5};
        System.out.println(Arrays.toString(x));
        heapSort(x, -1);

        System.out.println(Arrays.toString(x));
    }

    private static void heapSort(int[] x, int direction) {
        int l = x.length;
        for (int i = 0; i < l; i++) {
            heapifyBottom(x, i, direction);
        }

        for (int i = 0; i < l; i++) {
            heapifyTop(x, i, l - i - 1, direction);
            i++;
        }

    }

    private static void heapifyTop(int[] x, int start, int end, int direction) {

        if (start > end)
            return;

        int leftChild = 2 * start + 1;
        int rightChild = 2 * start + 2;

        int maxIndex = start;

        if (leftChild <= end && Math.signum(x[leftChild] - x[start]) == direction) {
            maxIndex = leftChild;
        }

        if (rightChild <= end && Math.signum(x[rightChild] - x[maxIndex]) == direction) {
            maxIndex = rightChild;
        }

        if (maxIndex != start) {
            swap(x, start, maxIndex);
        }

        heapifyTop(x, leftChild, end, direction);
        heapifyTop(x, rightChild, end, direction);

    }

    private static void heapifyBottom(int[] x, int index, int direction) {

        if (index <= 0) return;

        int parent = index % 2 == 0 ? index / 2 : (index - 1) / 2;

        if (Math.signum(x[parent] - x[index]) == -1 * direction) {
            swap(x, parent, index);
        }
        heapifyBottom(x, parent, direction);
    }

    private static void swap(int[] x, int parent, int index) {
        x[parent] = x[parent] + x[index];
        x[index] = x[parent] - x[index];
        x[parent] = x[parent] - x[index];
    }
}
