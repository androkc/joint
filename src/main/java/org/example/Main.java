package org.example;


import org.example.utils.FileReaderGZIUtils;

import java.util.*;

public class Main {
    private final static String PATH = "https://github.com/PeacockTeam/new-job/releases/download/v1.0/lng-4.txt.gz";

    public static void main(String[] args) {
        FileReaderGZIUtils fileReaderGZIUtils = new FileReaderGZIUtils();
        List<List<String>> listLists = fileReaderGZIUtils.readFile(PATH);
        fileReaderGZIUtils.forEach(listLists);

        DisjointSet disjointSet = new DisjointSet();
        Map<Integer, List<List<String>>> listSetMap = disjointSet.find(listLists);
        for (Map.Entry<Integer, List<List<String>>> group: listSetMap.entrySet()) {
            System.out.println("Group: "+ group.getKey());
            System.out.println(group.getValue());
            System.out.println("-------------");
        }


    }

}