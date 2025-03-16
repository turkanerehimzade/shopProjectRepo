package org.example.files;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MapFile {
    public static String location="C:\\Users\\User\\IdeaProjects\\map.txt";
    public static void writeIntoFile(Map map, String location) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(location);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(map);
        objectOutputStream.close();
    }

    public static Map readFile(String location) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(location);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return (Map) objectInputStream.readObject();

    }
    public static Map checkFile(String location) throws IOException, ClassNotFoundException {
        File file = new File(location);
        if (!file.exists() || file.length() == 0) {
            return  new HashMap<>();
        }
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (Map) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
