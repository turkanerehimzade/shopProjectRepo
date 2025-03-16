package org.example.util;

import org.example.files.CommonFile;
import org.example.files.SellFile;
import org.example.models.Database;

import java.io.IOException;
import java.util.Scanner;

public class SatishMenuUtil {
    public static void  satish() throws IOException, ClassNotFoundException {
        Scanner scanner=new Scanner(System.in);
        int option= scanner.nextInt();
        switch (option){
            case 1->EshyaUtil.sell();
            case 2->DatabaseUtil.printSell();
        }
    }
}
