package cses;

import java.io.PrintStream;
import java.util.Scanner;

public class Permutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PrintStream printStream = new PrintStream(System.out);

        int n = sc.nextInt();

        if (n == 1) {
            System.out.println(n);
            return;
        }

        if (n == 2 || n == 3) {
            System.out.println("NO SOLUTION");
            return;
        }

        for (int i = 2; i <= n; i += 2) {
            printStream.print(i + " ");
        }

        for (int i = 1; i <= n; i += 2) {
            printStream.print(i + " ");
        }

        sc.close();
    }
}
