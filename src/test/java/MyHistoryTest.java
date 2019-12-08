/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testovani;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 2016-e-dana
 */
public class MyHistoryTest {

    public MyHistoryTest() {
    }

    @Test
    public void initTest() throws IOException {
        Path p = Files.createTempFile(null, null);
        MyHistory h = new MyHistory(p.toString());
        h.addLine("ahoj");
        h.addLine("ahoj");

        assertEquals("ahoj", h.toString());

    }

    @Test
    public void initTest1() throws IOException {
        Path p = Files.createTempFile(null, null);
        ArrayList<String> arr = new ArrayList();
        arr.add("ahoj");
        arr.add("nazdar");
        Files.write(p, arr);

        MyHistory h = new MyHistory(p.toString());
        h.read();
        assertEquals("ahoj\nnazdar", h.toString());
    }

    @Test
    public void readTest() throws IOException {
        MyHistory h = new MyHistory("C:/Users/Marek/Documents/NetBeansProjects/test.txt");
        h.addLine("ahoj");
        h.addLine("nazdar");
        h.save();
        h.read();

        assertEquals("ahoj\nnazdar", h.toString());

    }

    @Test
    public void saveTest() throws IOException {
        //   Path p = Files.createTempFile(null, null);

        Path path = Files.createTempFile("sample-file", ".txt");
        // File file = path.toFile();
        Files.write(path, "ahoj2".getBytes(StandardCharsets.UTF_8));

        MyHistory h = new MyHistory(path.toString());
        h.addLine("ahoj4");
        h.addLine("ahoj5");
        h.save();
        h.read();
        assertEquals("ahoj4\nahoj5", h.toString());

    }

    @Test
    public void addLineTest() throws IOException {
        //   Path p = Files.createTempFile(null, null);

        Path path = Files.createTempFile("sample-file", ".txt");
        //     File file = path.toFile();
        Files.write(path, "ahoj2".getBytes(StandardCharsets.UTF_8));

        MyHistory h = new MyHistory(path.toString());
        h.addLine("cau");
        h.addLine("cau");
        assertEquals("cau", h.toString());

    }

}
