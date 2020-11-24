package cses;

import java.util.Scanner;

public class IncreasingArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int[] n = new int[t];

        long r = 0;

        for (int i = 0; i < t; i++) {
            n[i] = sc.nextInt();
            if (i != 0 && n[i] < n[i - 1]) {
                r += Math.abs(n[i] - n[i - 1]);
                n[i] = n[i - 1];
            }
        }

        System.out.println(r);

        sc.close();
    }
}
