package org.example.files;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CommonFile {
    public static void writeIntoFile(List list, String location) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(location);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(list);
        objectOutputStream.close();
    }

    public static List readFile(String location) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(location);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return (List) objectInputStream.readObject();

    }

    public static List checkFile(String location) throws IOException, ClassNotFoundException {
        File file = new File(location);
        if (!file.exists() || file.length() == 0) {
return new ArrayList<>();
        }
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (List) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (Throwable e) {
            e.printStackTrace();
        }

        return null;
    }
}
