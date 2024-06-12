package org.example.models;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.MebelDest;
import org.example.enums.Status;
import org.example.files.CommonFile;
import org.example.files.MebelFile;
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
public class Mebel extends Eshya implements Shop, Serializable {
    public static final Long serialVersionUID = 1L;
    private MebelDest mebelDest;
    public static String location = "C:\\Users\\User\\IdeaProjects\\mebel.txt";

    public Mebel(String unikalNomre, String marka, int say, MebelDest mebelDest, int qiymet, Status status) {
        super(unikalNomre, marka, say, qiymet, status);
        this.mebelDest = mebelDest;
    }

    public Mebel() {

    }

    @Override
    public void create() throws IOException, ClassNotFoundException {
        Database.listMebel = CommonFile.checkFile(Mebel.location);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mehsulun unikal nomresini daxil edin:");
        String unikalNomre = EshyaUtil.checkUnikalNomre();
        System.out.println("Mehsulun markasini daxil edin:");
        String marka = scanner.nextLine();
        System.out.println("Mehsulun sayini daxil edin:");
        int say = scanner.nextInt();
        System.out.println("Mehsulun novunu(1-Yataq desti,2-Qonaq desti) daxil edin:");
        int nov = scanner.nextInt();
        MebelDest mebelDest = MebelDest.getByValue(nov);
        System.out.println("Mehsulun qiymetini daxil edin:");
        int qiymet = scanner.nextInt();
        Mebel mebel = new Mebel(unikalNomre, marka, say, mebelDest, qiymet, getStatus());
        System.out.println("~~~Mehsul ugurla elave edildi~~~");
        DatabaseUtil.addListMebel(mebel);

    }

    @Override
    public void delete(String unikalNomre) throws IOException {
        for (Mebel mebel : Database.listMebel) {
            if (unikalNomre.equals(mebel.getUnikalNomre())) {
                mebel.setStatus(Status.getByValue(2));
                CommonFile.writeIntoFile(Database.listMebel, MebelFile.location);
                System.out.println("Mehsul silindi...");
            }
        }
    }

    @Override
    public void sell(String unikalNomre) throws IOException, ClassNotFoundException {
        for (Mebel mebel : Database.listMebel) {
            if (unikalNomre.equals(mebel.getUnikalNomre())) {
                if (mebel.getStatus() != Status.getByValue(2)) {
                    mebel.setSay(mebel.getSay() - 1);
                    System.out.println("Mehsul satildi...");
                    CommonFile.writeIntoFile(Database.listMebel, MebelFile.location);
                    SellUtil.sellInfoMebel(mebel);
                }else{
                    System.out.println("Mehsul deaktivdir...");
                }
            }
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Mebel.class.getSimpleName() + "[", "]")
                .add(super.toString() + "mebelDest=" + mebelDest)
                .toString();
    }
}
