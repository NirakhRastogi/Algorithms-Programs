package cses;

import java.util.Scanner;

public class WeirdAlgorithim {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long ll = sc.nextLong();
        System.out.print(ll + (ll == 1 ? "" : " "));
        while (ll != 1) {
            if (ll % 2 == 0) {
                ll = ll / 2;
            } else if (ll % 2 == 1) {
                ll = ll * 3 + 1;
            }
            System.out.print(ll + (ll == 1 ? "" : " "));
        }
        sc.close();
    }

}
