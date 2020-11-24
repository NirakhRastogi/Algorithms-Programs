package programming;

public class Palindrome {
    public static void main(String[] args) {
        int x = 1221;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        char[] _x = Integer.toString(x).toCharArray();
        for (int i = 0; i < _x.length / 2; i++) {
            if (_x[i] != _x[_x.length - i - 1]) return false;
        }
        return true;
    }

}
