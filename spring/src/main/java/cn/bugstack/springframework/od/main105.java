package cn.bugstack.springframework.od;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther: 李清依
 * @Date: 2022/11/14 14:08
 * @Description:
 */
public class main105 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        List<Integer> ids = toIntList(in.nextLine());
        List<Integer> scores = toIntList(in.nextLine());
        in.close();

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Integer id = ids.get(i);
            Integer score = scores.get(i);
            List<Integer> list = map.getOrDefault(id, new LinkedList<>());
            list.add(score);
            map.put(id, list);
        }
        StringBuilder builder = new StringBuilder();
        map.entrySet().stream()
                .filter(x -> x.getValue().size() >= 3)
                .sorted(((o1, o2) -> {
                            Integer sum1 = sum(o1.getValue());
                            Integer sum2 = sum(o2.getValue());
                            if (sum1.equals(sum2)) {
                                return o2.getKey() - o1.getKey();
                            } else {
                                return sum2 - sum1;
                            }

                        })
                )
                .map(Map.Entry::getKey)
                .forEach(x -> builder.append(x).append(","));
        System.out.println(builder.substring(0,builder.length()-1));
    }

    private static int sum(List<Integer> list) {
        list.sort(Integer::compareTo);
        int sum = 0;
        for (int i = list.size() - 3; i <=list.size()-1; i++) {
            sum += list.get(i);
        }
        return sum;
    }

    private static List<Integer> toIntList(String str) {
        return Arrays.stream(str.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
