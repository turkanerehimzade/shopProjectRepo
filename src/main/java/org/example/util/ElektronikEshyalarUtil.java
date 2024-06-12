package org.example.util;

import org.example.models.ElektronikEshyalar;
import org.example.models.Shop;

import java.io.IOException;

public class ElektronikEshyalarUtil {
    static Shop shop=new ElektronikEshyalar();
    public static void foo() throws IOException, ClassNotFoundException {
        shop.create();
    }
}
