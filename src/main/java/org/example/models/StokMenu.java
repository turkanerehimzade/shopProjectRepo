package org.example.models;
import org.example.util.StokMenuUtil;
import java.io.IOException;

public class StokMenu {
    public static void menu() throws IOException, ClassNotFoundException {
        while (true) {
            System.err.println("<<<---STOK--->>>");
            System.err.println("* * * * * * * * * * * * * * * * * * * * * * * * * * *");
            String menu = "1.Stok-a mehsul elave etmek\n" +
                    "2.Stok-dan mehsul silmek\n" +
                    "3.Stok-daki butun mehsullari gormek";
            System.err.println(menu);
            System.err.println("* * * * * * * * * * * * * * * * * * * * * * * * * * *");
            StokMenuUtil.stok();
        }
    }
}
