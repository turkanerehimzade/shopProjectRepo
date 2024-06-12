package org.example.util;

import java.io.IOException;
import java.util.Scanner;


public class StokMenuUtil {
    public static void stok() throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch (option) {
            case 1 -> EshyaUtil.createObject();
            case 2 -> EshyaUtil.delete();
            case 3 -> EshyaUtil.printMap();
        }
    }
}


