package org.example.models;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.ElektronikDest;
import org.example.enums.Status;
import org.example.files.CommonFile;
import org.example.files.MeishetFile;
import org.example.util.DatabaseUtil;
import org.example.util.EshyaUtil;
import org.example.util.SellUtil;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;
import java.util.StringJoiner;

@Getter
@Setter
public class ElektronikEshyalar extends Eshya implements Shop, Serializable {
    public static final Long serialVersionUID = 1L;
    public static String location = "C:\\Users\\User\\IdeaProjects\\elektronikEshyalar.txt";

    private ElektronikDest elektronikDest;

    public ElektronikEshyalar(String unikalNomre, String marka, int say, ElektronikDest elektronikDest, int qiymet, Status status) {
        super(unikalNomre, marka, say, qiymet, status);
        this.elektronikDest = elektronikDest;
    }

    public ElektronikEshyalar() {

    }

    @Override
    public void create() throws IOException, ClassNotFoundException {
        Database.listE = CommonFile.checkFile(ElektronikEshyalar.location);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mehsulun unikal nomresini daxil edin:");
        String unikalNomre = EshyaUtil.checkUnikalNomre();
        System.out.println("Mehsulun markasini daxil edin:");
        String marka = scanner.nextLine();
        System.out.println("Mehsulun sayini daxil edin:");
        int say = scanner.nextInt();
        System.out.println("Mehsulun novunu(1-Paltaryuyan,2-Soyuducu) daxil edin:");
        int nov = scanner.nextInt();
        ElektronikDest elektronikDest = ElektronikDest.getByValue(nov);
        System.out.println("Mehsulun qiymetini daxil edin:");
        int qiymet = scanner.nextInt();
        ElektronikEshyalar elektronikEshyalar = new ElektronikEshyalar(unikalNomre, marka, say, elektronikDest, qiymet, getStatus());
        System.out.println("~~~Mehsul ugurla elave edildi~~~");
        DatabaseUtil.addListE(elektronikEshyalar);
    }

    @Override
    public void delete(String unikalNomre) throws IOException {
        for (ElektronikEshyalar elektronikEshyalar : Database.listE) {
            if (unikalNomre.equals(elektronikEshyalar.getUnikalNomre())) {
                elektronikEshyalar.setStatus(Status.getByValue(2));
                CommonFile.writeIntoFile(Database.listE, ElektronikEshyalar.location);
                System.out.println("Mehsul silindi...");
//                System.out.println(elektronikEshyalar);
            }
        }
    }

    @Override
    public void sell(String unikalNomre) throws IOException, ClassNotFoundException {
        for (ElektronikEshyalar elektronikEshyalar : Database.listE) {
            if (unikalNomre.equals(elektronikEshyalar.getUnikalNomre())) {
                if (elektronikEshyalar.getStatus() != Status.getByValue(2)) {
                    elektronikEshyalar.setSay(elektronikEshyalar.getSay() - 1);
                    System.out.println("Mehsul satildi...");
                    CommonFile.writeIntoFile(Database.listE, ElektronikEshyalar.location);
                    SellUtil.sellInfoE(elektronikEshyalar);
                }else{
                    System.out.println("Mehsul deaktivdir..");
                }
            }
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ElektronikEshyalar.class.getSimpleName() + "[", "]")
                .add(super.toString() + "elektronikDest=" + elektronikDest)
                .toString();
    }
}
