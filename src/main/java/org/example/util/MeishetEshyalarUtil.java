package org.example.util;
import org.example.files.CommonFile;
import org.example.models.*;
import java.io.IOException;
import java.util.Scanner;

public class MeishetEshyalarUtil {
    static Shop shop = new MeishetEshyalar();

    public static void foo() throws IOException, ClassNotFoundException {
        shop.create();
    }
}
