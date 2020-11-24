package cses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class TwoSets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = n * (n + 1) / 2;
        if (sum % 2 != 0) {
            System.out.println("NO");
            return;
        }

        int desiredSum = sum / 2;

        List<Integer> set1 = findSet1(desiredSum, new ArrayList<Integer>(), 1, n);

        if (set1 == null) {
            System.out.println("NO");
            return;
        }

        System.out.println("YES");

        System.out.println(set1.size());
        for (int i : set1) {
            System.out.print(i + " ");
        }

        System.out.println();

        System.out.println(n - set1.size());

        IntStream.range(1, n).filter(i -> !set1.contains(i)).forEach(i -> System.out.print(i + " "));

        sc.close();
    }

    private static List<Integer> findSet1(int desiredSum, ArrayList<Integer> integers, int k, int n) {
        if (desiredSum < 0)
            return null;
        if (desiredSum == 0) {
            return integers;
        }

        if (k > n) {
            return null;
        }

        while (k <= n) {
            integers.add(k);
            List<Integer> output = findSet1(desiredSum - k, integers, k + 1, n);
            if (output != null) return output;
            integers.remove((Integer) k);
            k++;
        }

        return null;
    }
}
