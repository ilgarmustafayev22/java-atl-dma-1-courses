package az.atlacademy.module01.lesson31;

import java.io.*;

public class FileApp {

    public static final String RESOURCE = "src/main/java/az/atlacademy/module01/lesson31/resource/";
    public static final File FILE_PATH = new File(RESOURCE + "helle.txt");

    public static void main(String[] args) {


        try {
            FileWriter fw = new FileWriter(FILE_PATH);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Hello World!");
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            FileReader fr = new FileReader(FILE_PATH);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}