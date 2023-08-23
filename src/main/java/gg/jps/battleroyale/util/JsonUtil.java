package gg.jps.battleroyale.util;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import gg.jps.battleroyale.kit.Kit;

import java.io.*;
import java.util.*;

public class JsonUtil {

    private static Gson gson = new Gson();

    public static <T> Optional<T> loadFromJsonFile(File folder, String fileName, Class<? super T> type) {
        if(!folder.exists()) folder.mkdirs();
        final T object;
        final File file = new File(folder, fileName + ".json");
        if (!file.exists()) return Optional.empty();

        try {
            object = gson.fromJson(new JsonReader(new FileReader(file)), type);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(object);
    }


    public static <T> Iterable<T> loadFromJsonFileAll(File folder, Class<? super T> type) {
        if(!folder.exists()) folder.mkdirs();
        final Set<T> iterator = new HashSet<>();
        for (File file : Optional.ofNullable(folder.listFiles()).orElse(new File[0])) {
            final String fileName = file.getName();
            final T object;

            try {
                object = gson.fromJson(new JsonReader(new FileReader(new File(folder, fileName))), type);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            iterator.add(object);
        }
        return iterator;
    }

    public static void saveJsonFile(File folder, String fileName, Object object) {
        if(!folder.exists()) folder.mkdirs();
        final File file = new File(folder,  fileName + ".json");
        if (file.exists()) return;

        try (Writer writer = new FileWriter(file)) {
            gson.toJson(object, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
