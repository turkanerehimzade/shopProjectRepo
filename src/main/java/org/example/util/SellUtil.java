package org.example.util;

import org.example.models.*;

import java.io.IOException;
import java.time.LocalDateTime;

public class SellUtil {

    public static void sellInfoM(MeishetEshyalar meishetEshyalar) throws IOException, ClassNotFoundException {
        LocalDateTime localDateTime=LocalDateTime.now();
        Sell sell=new Sell(localDateTime,meishetEshyalar.getMeishetDest(), meishetEshyalar.getMarka(), meishetEshyalar.getQiymet());
        DatabaseUtil.addSell(sell);
    }
    public static void sellInfoE(ElektronikEshyalar elektronikEshyalar) throws IOException, ClassNotFoundException {
        LocalDateTime localDateTime=LocalDateTime.now();
        Sell sell=new Sell(localDateTime,elektronikEshyalar.getElektronikDest(), elektronikEshyalar.getMarka(), elektronikEshyalar.getQiymet());
        DatabaseUtil.addSell(sell);
    }

    public static void sellInfoMebel(Mebel mebel) throws IOException, ClassNotFoundException {
        LocalDateTime localDateTime=LocalDateTime.now();
        Sell sell=new Sell(localDateTime,mebel.getMebelDest(), mebel.getMarka(), mebel.getQiymet());
        DatabaseUtil.addSell(sell);
    }

}
