package org.example.util;

import org.example.models.Mebel;
import org.example.models.Shop;

import java.io.IOException;

public class MebelUtil {
    static Shop shop=new Mebel();
    public static void foo() throws IOException, ClassNotFoundException {
        shop.create();
    }
}
