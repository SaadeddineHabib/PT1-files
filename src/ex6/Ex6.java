package ex6;

import java.io.File;
import java.nio.file.FileSystems;

public class Ex6 {
    public static void main(String[] args) {
        String path = "src\\ex6\\arxius";
        String separador = FileSystems.getDefault().getSeparator();
        String sistemaOperativo = System.getProperty("os.name");

        if (sistemaOperativo.toLowerCase().contains("linux")) {
            path = path.replace("/", separador);
        } else if (sistemaOperativo.toLowerCase().contains("windows")) {
            path = path.replace("\\", separador);
        }

        System.out.println(path);

        try {
            File diretory = new File(path);
            File[] directoryFiles = diretory.listFiles();
            for (File file : directoryFiles) {
                if (file.isFile()) {
                    if (file.getName().endsWith(".txt")) {
                        File newDirectory = new File(path + "\\" +
                                file.getName().substring(0, file.getName().indexOf(".")));
                        System.out.println(newDirectory);
                        System.out.println(newDirectory.mkdir());
                    }
                }
                if (file.isDirectory()) {
                    System.out.println(file.toPath());
                    File newDirectories = new File(path + "\\" + file.getName() + ".txt");
                    System.out.println(newDirectories);
                    System.out.println(newDirectories.createNewFile());
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
