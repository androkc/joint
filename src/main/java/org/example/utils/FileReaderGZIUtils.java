package org.example.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class FileReaderGZIUtils {
    public List<List<String>> readFile(String path) {
        try (BufferedReader reader =
                     new BufferedReader(new InputStreamReader
                             (new GZIPInputStream(new URL(path).openStream())));
        ) {
            List<List<String>> stringList = new ArrayList<>();
            String line;

            while ((line =  reader.readLine()) != null) {
                List<String> strings = Arrays.stream(line.split(";")).toList();
                stringList.add(strings);
            }

            return stringList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void forEach(List<List<String>> listList){
        for (List<String> e: listList) {
            for (String r:e) {
                System.out.print(r+" ");
            }
            System.out.println();
        }
    }
}
