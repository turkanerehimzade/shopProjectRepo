package org.example.models;
import org.example.util.SatishMenuUtil;
import java.io.IOException;

public class SatishMenu {
    public static void menu() throws IOException, ClassNotFoundException {
        while (true) {
            System.err.println("<<<---SATISH--->>>");
            System.err.println("* * * * * * * * * * * * * * * * * * * * * * * * * * *");
            String menu = "1.Istenilen mehsulun satishi\n" +
                        "2.Satishlarin melumatlari";
            System.err.println(menu);
            System.err.println("* * * * * * * * * * * * * * * * * * * * * * * * * * *");
            SatishMenuUtil.satish();
        }
    }
}