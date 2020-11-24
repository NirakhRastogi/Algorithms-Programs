package cses;

import java.util.Scanner;

public class MissingNumber {

    public static void main(String[] args) {
        long s = 0;
        Scanner sc = new Scanner(System.in);

        int l = sc.nextInt();

        for (int i = 0; i < l - 1; i++) {
            s += sc.nextInt();
        }

        System.out.println((l * (l + 1L)) / 2l - s);

        sc.close();

    }

}
