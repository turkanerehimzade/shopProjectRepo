package org.example.util;

import org.example.files.CommonFile;
import org.example.files.MapFile;
import org.example.files.MebelFile;
import org.example.files.SellFile;
import org.example.models.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class DatabaseUtil {
    public static void addListM(MeishetEshyalar meishetEshyalar) throws IOException, ClassNotFoundException {
        Database.listM.add(Database.lastIndexM++,meishetEshyalar);
        CommonFile.writeIntoFile(Database.listM,MeishetEshyalar.location);

    }
    public static void addListE(ElektronikEshyalar elektronikEshyalar) throws IOException, ClassNotFoundException {
        Database.listE.add(Database.lastIndexE++,elektronikEshyalar);
        CommonFile.writeIntoFile(Database.listE,ElektronikEshyalar.location);
    }
    public static void addListMebel(Mebel mebel) throws IOException, ClassNotFoundException {
        Database.listMebel.add(Database.lastIndexMebel++,mebel);
        CommonFile.writeIntoFile(Database.listMebel,MebelFile.location);
    }
    public static void addSell(Sell sell) throws IOException, ClassNotFoundException {
        Database.listSell.add(Database.lastIndexSell++,sell);
        CommonFile.writeIntoFile(Database.listSell, SellFile.location);}
    public static void addMap() throws IOException, ClassNotFoundException {
        Database.listM=  CommonFile.readFile(MeishetEshyalar.location);
        Database.listMebel= CommonFile.readFile(Mebel.location);
        Database.listE= CommonFile.readFile(ElektronikEshyalar.location);
        Database.map.put(1, Collections.singletonList(Database.listM));
        Database.map.put(2, Collections.singletonList(Database.listE));
        Database.map.put(3, Collections.singletonList(Database.listMebel));
        MapFile.writeIntoFile(Database.map,MapFile.location);
//        Database.map=MapFile.readFile(MapFile.location);
//        System.out.println(Database.map);
    }
    public static void printSell() throws IOException, ClassNotFoundException {
        Database.listSell=CommonFile.readFile(SellFile.location);
        System.out.println(Database.listSell);
    }
}
