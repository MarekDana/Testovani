/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testovani;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 2016-e-dana
 */
public class MyHistory {

    private String name;
    ArrayList<String> arr;

    public MyHistory(String fileName) {
        // nacte fileName do List<String> radku po radce
        name = fileName;
    }

    public void read() {
        try {
            arr = (ArrayList<String>) Files.readAllLines(Paths.get(name));
        } catch (IOException ex) {
            System.out.println(ex.toString());
            System.out.println("Soubor nebyl nalezen: " + name);
        }

    }

    public void save() {
        try {
            for (int i = 0; i < arr.size(); i++) {
                for (int j = i + 1; j < arr.size(); j++) {
                    if (arr.get(i).equals(arr.get(j))) {
                        arr.remove(j);
                        j--;
                    }
                }
            }
            Files.write(Paths.get(name), arr);
        } catch (IOException ex) {
            System.out.println(ex.toString());
            System.out.println("Soubor nebyl nalezen: " + name);
        }
    }

    public void addLine(String str) {
        if (arr == null) {
            arr = new ArrayList<>();
        }
        if (arr.contains(str)) {
            System.out.println("Duplicitni radka nelze ulozit");
        } else {
            arr.add(str);
        }
    }

    public String toString() {
        // pokud soubor uz duplicitni prvky obsahuje je potreba
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(i).equals(arr.get(j))) {
                    arr.remove(j);
                    j--;
                }
            }
        }
        return String.join("\n", arr);
    }

    public static void main(String[] args) {
     /*   MyHistory h = new MyHistory("C:/Users/Marek/Documents/NetBeansProjects/a.txt");
        h.read();

        System.out.println(h.toString());*/

    }
}
