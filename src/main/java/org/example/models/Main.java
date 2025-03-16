package org.example.models;

import org.example.files.MapFile;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static org.example.models.Database.map;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Stok or Satish?");
        String s = scanner.nextLine();
        if (s.equalsIgnoreCase("stok")) {
            StokMenu.menu();
        } else if (s.equalsIgnoreCase("satish")) {
            SatishMenu.menu();
        } else {
            System.out.println("Sechimlerde yoxdur...");
        }
    }
}