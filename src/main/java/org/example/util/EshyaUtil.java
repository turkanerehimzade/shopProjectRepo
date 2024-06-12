package org.example.util;

import org.example.files.CommonFile;
import org.example.files.MapFile;
import org.example.models.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static org.example.models.Database.map;

import java.util.List;

public class EshyaUtil {
    public static void printMap() throws IOException, ClassNotFoundException {
       DatabaseUtil.addMap();
        for (Map.Entry<Integer, List<List>> entry : Database.map.entrySet()) {
            Integer key = entry.getKey();
            List<List> lists = entry.getValue();
            System.out.println("Bolme: " + key);
            for (int i = 0; i < lists.toArray().length; i++) {
                System.out.println(lists);
            }
        }
    }

    public static void createObject() throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mehsulun tipini daxil edin:");
        String type = scanner.nextLine();
        if (type.equalsIgnoreCase("Meishet eshya")) {
            MeishetEshyalarUtil.foo();
        } else if (type.equalsIgnoreCase("Elektronik eshya")) {
            ElektronikEshyalarUtil.foo();
        } else if (type.equalsIgnoreCase("Mebel")) {
            MebelUtil.foo();
        } else {
            System.out.println("Bele bir mehsul yoxdur...Xaish olunur tekrara daxil edin..");
            createObject();
        }
    }

    public static String checkUnikalNomre() throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String unikalNomre = scanner.nextLine();
        Database.listM = CommonFile.checkFile(MeishetEshyalar.location);
        Database.listMebel = CommonFile.checkFile(Mebel.location);
        Database.listE = CommonFile.checkFile(ElektronikEshyalar.location);
        for (MeishetEshyalar meishetEshyalar : Database.listM) {
            if (unikalNomre.equals(meishetEshyalar.getUnikalNomre())) {
                System.out.println("Bu unikal nomreye sahib mehsul var..Xaish olunur tekrar daxil edin..");
                return scanner.next();
            }
        }
        for (ElektronikEshyalar elektronikEshyalar : Database.listE) {
            if (unikalNomre.equals(elektronikEshyalar.getUnikalNomre())) {
                System.out.println("Bu unikal nomreye sahib mehsul var..Xaish olunur tekrar daxil edin..");
                return scanner.next();
            }
        }
        for (Mebel mebel : Database.listMebel) {
            if (unikalNomre.equals(mebel.getUnikalNomre())) {
                System.out.println("Bu unikal nomreye sahib mehsul var..Xaish olunur tekrar daxil edin..");
                return scanner.next();
            }
        }
        return unikalNomre;
    }

    public static void delete() throws IOException, ClassNotFoundException {
        Database.listM = CommonFile.checkFile(MeishetEshyalar.location);
        Database.listMebel = CommonFile.checkFile(Mebel.location);
        Database.listE = CommonFile.checkFile(ElektronikEshyalar.location);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Silmek istediyiniz mehsulun unikal nomresini daxil edin:");
        String unikalNomre = scanner.nextLine();
        for (MeishetEshyalar meishetEshyalar : Database.listM) {
            if (unikalNomre.equals(meishetEshyalar.getUnikalNomre())) {
                Shop shop = new MeishetEshyalar();
                shop.delete(unikalNomre);
                break;
            }
        }
        for (ElektronikEshyalar elektronikEshyalar : Database.listE) {
            if (unikalNomre.equals(elektronikEshyalar.getUnikalNomre())) {
                Shop shop = new ElektronikEshyalar();
                shop.delete(unikalNomre);
                break;
            }
        }
        for (Mebel mebel : Database.listMebel) {
            if (unikalNomre.equals(mebel.getUnikalNomre())) {
                Shop shop = new Mebel();
                shop.delete(unikalNomre);
                break;
            }
//                System.out.println("Daxil edilen unikal nomreye sahib mehsul yoxdur...");
        }
    }

    public static void sell() throws IOException, ClassNotFoundException {
        Database.listM = CommonFile.checkFile(MeishetEshyalar.location);
        Database.listMebel = CommonFile.checkFile(Mebel.location);
        Database.listE = CommonFile.checkFile(ElektronikEshyalar.location);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Satilan mehsulun unikal nomresini daxil edin:");
        String unikalNomre = scanner.nextLine();
            for (MeishetEshyalar meishetEshyalar : Database.listM) {
                if (unikalNomre.equals(meishetEshyalar.getUnikalNomre())) {
                    Shop shop = new MeishetEshyalar();
                    shop.sell(unikalNomre);
                    break;
                }
            }
            for (ElektronikEshyalar elektronikEshyalar : Database.listE) {
                if (unikalNomre.equals(elektronikEshyalar.getUnikalNomre())) {
                    Shop shop = new ElektronikEshyalar();
                    shop.sell(unikalNomre);
                    break;
                }
            }
            for (Mebel mebel : Database.listMebel) {
                if (unikalNomre.equals(mebel.getUnikalNomre())) {
                    Shop shop = new Mebel();
                    shop.sell(unikalNomre);
                    break;
                }
//                System.out.println("Daxil edilen unikal nomreye aid mehsul yoxdur...");
            }
    }
}
