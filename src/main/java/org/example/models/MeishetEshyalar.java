package org.example.models;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.MeishetDest;
import org.example.enums.Status;
import org.example.files.CommonFile;
import org.example.files.MeishetFile;
import org.example.util.DatabaseUtil;
import org.example.util.EshyaUtil;
import org.example.util.SellUtil;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLOutput;
import java.util.*;

@Getter
@Setter
//@ToString
public class MeishetEshyalar extends Eshya implements Shop, Serializable {
    public static final Long serialVersionUID = 1L;
    private MeishetDest meishetDest;
    private int neferSayi;
    public static String location = "C:\\Users\\User\\IdeaProjects\\meishetEshyalari.txt";

    public MeishetEshyalar(String unikalNomre, String marka, int say, MeishetDest meishetDest, int qiymet, int neferSayi, Status status) {
        super(unikalNomre, marka, say, qiymet, status);
        this.meishetDest = meishetDest;
        this.neferSayi = neferSayi;
    }

    public MeishetEshyalar() {

    }


    @Override
    public void create() throws IOException, ClassNotFoundException {

        Database.listM = CommonFile.checkFile(MeishetEshyalar.location);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mehsulun unikal nomresini daxil edin:");
        String unikalNomre = EshyaUtil.checkUnikalNomre();
        System.out.println("Mehsulun markasini daxil edin:");
        String marka = scanner.nextLine();
        System.out.println("Mehsulun sayini daxil edin:");
        int say = scanner.nextInt();
        System.out.println("Mehsulun novunu(1-Qab desti ,2-Qazan desti) daxil edin:");
        int nov = scanner.nextInt();
        MeishetDest meishetDest = MeishetDest.getByValue(nov);
        System.out.println("Mehsulun qiymetini daxil edin:");
        int qiymet = scanner.nextInt();
        System.out.println("Neche neferlik dest oldugunu daxil edin:");
        int neferSayi = scanner.nextInt();
        MeishetEshyalar meishetEshyalar = new MeishetEshyalar(unikalNomre, marka, say, meishetDest, qiymet, neferSayi, getStatus());
        System.out.println("~~~Mehsul ugurla elave edildi~~~");
        DatabaseUtil.addListM(meishetEshyalar);
    }

    @Override
    public void delete(String unikalNomre) throws IOException, ClassNotFoundException {
        for (MeishetEshyalar meishetEshyalar : Database.listM) {
            if (unikalNomre.equals(meishetEshyalar.getUnikalNomre())) {
                meishetEshyalar.setStatus(Status.getByValue(2));
                CommonFile.writeIntoFile(Database.listM, MeishetEshyalar.location);
                System.out.println("Mehsul silindi..");
//                Database.listM=CommonFile.readFile(MeishetEshyalar.location);
//                System.out.println(Database.listM);
            }
        }
    }

    @Override
    public void sell(String unikalNomre) throws IOException, ClassNotFoundException {
        for (MeishetEshyalar meishetEshyalar : Database.listM) {
            if (unikalNomre.equals(meishetEshyalar.getUnikalNomre())) {
                if (meishetEshyalar.getStatus() != Status.getByValue(2)) {
                    meishetEshyalar.setSay(meishetEshyalar.getSay() - 1);
                    System.out.println("Mehsul satildi...");
                    CommonFile.writeIntoFile(Database.listM, MeishetFile.location);
                    SellUtil.sellInfoM(meishetEshyalar);
                }else{
                    System.out.println("Mehsul deaktivdir...");
                }
            }
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MeishetEshyalar.class.getSimpleName() + "[", "]")
                .add(super.toString() + "meishetDest=" + meishetDest + " ," + "kateqoriya=" + neferSayi + " neferlik")
                .toString();
    }
}
