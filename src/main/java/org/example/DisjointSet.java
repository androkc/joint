package org.example;

import lombok.Getter;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Getter
public class DisjointSet {

    public Map<Integer, List<List<String>>> find(List<List<String>> lists) {

        Map<List<String>, Integer> groups = new HashMap<>();
        AtomicInteger atomicInteger = new AtomicInteger(0);

        for (List<String> row : lists) {
            boolean grouped = false;

            for (List<String> groupKey : groups.keySet()) {
                if (hasUnion(groupKey, row)) {
                    groups.put(row, groups.get(groupKey));
                    grouped = true;
                    break;
                }
            }

            if (!grouped) {
                groups.put(row, atomicInteger.getAndIncrement());
            }
        }

        return groups.entrySet()
                .stream()
                .collect(Collectors.groupingBy(
                        Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())
                ));
    }

    private static boolean hasUnion(List<String> list1, List<String> list2) {

        for (int i = 0; i < Math.min(list1.size(), list2.size()); i++) {
            if (!list1.get(i).isEmpty() && !list2.get(i).isEmpty() && list1.get(i).equals(list2.get(i))) {
                return true;
            }
        }
        return false;
    }

}

