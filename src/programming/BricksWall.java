package programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BricksWall {
    public static void main(String[] args) {
        List<List<Integer>> wall = Arrays.asList(
                Arrays.asList(1, 2, 2, 1),
                Arrays.asList(3, 1, 2),
                Arrays.asList(1, 3, 2),
                Arrays.asList(2, 4),
                Arrays.asList(3, 1, 2),
                Arrays.asList(1, 3, 1, 1)
        );

        System.out.println(leastBricks(wall));

    }

    public static int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (List<Integer> brickList : wall) {
            sum = 0;
            for (Integer brick : brickList.subList(0, brickList.size() - 1)) {
                sum += brick;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i : map.values()) {
            result = Math.max(result, i);
        }

        return result == Integer.MIN_VALUE ? wall.size() : wall.size() - result;
    }

}
