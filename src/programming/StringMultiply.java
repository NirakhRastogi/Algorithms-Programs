package programming;

public class StringMultiply {
    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "456";

        System.out.println(multiply(s1, s2));

    }

    public static String multiply(String num1, String num2) {


        if (num1.equals("0") || num2.equals("0")) return "0";

        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();

        int count = 0;

        char[] output;
        char[] _output = null;


        for (int i = n2.length - 1; i >= 0; i--) {
            output = multiplySingle(n1, n2[i], count);
            count++;

            if (_output == null) {
                _output = output;
            } else {
                _output = addString(_output, output);
            }

        }


        StringBuilder sb = new StringBuilder("");
        boolean find = false;
        assert _output != null;
        for (char c : _output) {
            if ((Character.getNumericValue(c) >= 0 && c != '0') || find) {
                sb.append(c);
                find = true;
            }
        }
        return sb.toString();
    }

    public static char[] addString(char[] n1, char[] n2) {
        int l1 = n1.length;
        int l2 = n2.length;

        char[] add = new char[Math.max(l1, l2) + 1];

        int value = 0;
        int carry = 0;
        for (int i = 0; i < Math.min(l1, l2); i++) {
            int added = getNumericValue(n1[l1 - i - 1]) + getNumericValue(n2[l2 - i - 1]) + carry;
            value = added % 10;
            carry = added / 10;
            add[add.length - i - 1] = Character.forDigit(value, 10);
        }

        if (l1 < l2) {
            for (int i = l1; i < l2; i++) {
                int added = getNumericValue(n2[l2 - i - 1]) + carry;
                value = added % 10;
                carry = added / 10;
                add[add.length - i - 1] = Character.forDigit(value, 10);
            }
        } else {
            for (int i = l2; i < l1; i++) {
                int added = getNumericValue(n1[l1 - i - 1]) + carry;
                value = added % 10;
                carry = added / 10;
                add[add.length - i - 1] = Character.forDigit(value, 10);
            }
        }

        return add;

    }


    private static char[] multiplySingle(char[] n1, char c, int count) {

        char[] output = new char[n1.length + count + 1];

        for (int i = 0; i < count; i++) {
            output[output.length - i - 1] = '0';
        }

        int carry = 0;
        int value = 0;
        for (int j = n1.length - 1; j >= 0; j--) {
            char _c = n1[j];
            int multiplied = getNumericValue(_c) * getNumericValue(c) + carry;
            value = multiplied % 10;
            carry = multiplied / 10;
            output[j + 1] = Character.forDigit(value, 10);
        }

        output[0] = Character.forDigit(carry, 10);

        return output;

    }


    private static int getNumericValue(char a) {
        return Math.max(Character.getNumericValue(a), 0);
    }

}
