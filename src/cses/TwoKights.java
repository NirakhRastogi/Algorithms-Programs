package cses;

import java.util.Scanner;

public class TwoKights {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int n = 1; n <= t; n++) {
            long total = ((long) n * n) * ((long) n * n - 1) / 2;
            long obs = 4L * (n - 1) * (n - 2);
            System.out.println(total - obs);
        }

        sc.close();
    }

}
