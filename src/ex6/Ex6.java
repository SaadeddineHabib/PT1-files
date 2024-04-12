package ex6;

import java.io.File;

public class Ex6 {
    public static void main(String[] args) {
        String pathLinux = "src/ex6/arxius";
        String pathWindows = "src\\ex6\\arxius";

        try {
            File diretory = new File(pathWindows);
            File recursosEducativos = new File(pathWindows + "\\recursosEducativos");
            recursosEducativos.mkdir();
            File[] directoryFiles = diretory.listFiles();
            for (File file : directoryFiles) {
                if (file.isFile()) {
                    File newDirectories = new File(recursosEducativos +
                            "\\Activitat_Almunes_" + file.getName());
                    System.out.println(newDirectories);
                    System.out.println(newDirectories.mkdir());
                }
                if (file.isDirectory()) {
                    File newDirectories = new File( recursosEducativos + "\\" + file.getName() + "_resums_apunts");
                    System.out.println(newDirectories);
                    System.out.println(newDirectories.createNewFile());
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
