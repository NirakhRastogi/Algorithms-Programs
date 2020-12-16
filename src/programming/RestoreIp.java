package programming;

import java.util.ArrayList;
import java.util.List;

public class RestoreIp {

    static List<String> validIps = new ArrayList<>();

    public static void main(String[] args) {
        String ip = "0000";

        helper(ip, 0, ip.length());

        System.out.println(validIps);

    }

    private static void helper(String ip, int index, int l) {

        String[] splitIp = ip.split("\\.");

        if (splitIp.length > 4) {
            return;
        }

        if (splitIp.length == 4 && ip.contains(".") && isValidIp(splitIp)) {
            validIps.add(ip);
            return;
        }

        for (int i = index + 1; i < index + 4; i++) {
            if (i < l) {
                String _ip = ip.substring(0, i) + "." + ip.substring(i);
                helper(_ip, i + 1, l + 1);
            }
        }

    }

    private static boolean isValidIp(String[] splitIp) {

        for (String _s : splitIp) {

            if (_s.length() > 1 && _s.startsWith("0")) return false;

            long l = Long.parseLong(_s);
            if (l > 255) return false;
        }

        return true;

    }
}
