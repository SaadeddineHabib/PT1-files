package ex3;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Ex3 {

    public static String getAutomaticPath (String path){
        String separador = FileSystems.getDefault().getSeparator();
        String sistemaOperativo = System.getProperty("os.name");

        System.out.println(separador);

        if (sistemaOperativo.toLowerCase().contains("linux")) {
            System.out.println(path);
            path = path.replace("\\", separador);
            System.out.println(path);
            path = path.replace("C:", "");
            System.out.println(path);
        } else if (sistemaOperativo.toLowerCase().contains("windows")) {
            path = path.replace("/", separador);
        }
        return path;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        try {
            File directory = new File(getAutomaticPath("src/ex3"));

            File[] directoryList;

            directoryList = directory.listFiles();

            for (File file : directoryList) {
                if (file.getName().contains("exercici")) {
                    System.out.printf("El arxiu %s el seu contigut es: %n", file.getName());
                    for (int i = 0; i < Files.readAllLines(Path.of(file.getPath())).size(); i++) {
                        System.out.println(Files.readAllLines(Path.of(file.getPath())).get(i));
                    }
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
