package cses;

import java.util.Scanner;

public class Repetitions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] dna = sc.next().toCharArray();

        int max = 0;
        int counter = 0;
        for (int i = 0; i < dna.length - 1; i++) {
            if (dna[i] == dna[i + 1]) {
                counter++;
            } else {
                max = Math.max(counter + 1, max);
                counter = 0;
            }
        }

        max = Math.max(counter + 1, max);
        System.out.println(max);

        sc.close();
    }
}
