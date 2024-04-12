package ex6;


import java.io.File;
import java.nio.file.FileSystems;


public class Ex6 {

    public static String getAutomaticPath (String path){
        String separador = FileSystems.getDefault().getSeparator();
        String sistemaOperativo = System.getProperty("os.name");

        System.out.println(separador);

        if (sistemaOperativo.toLowerCase().contains("linux")) {
            path = path.replace("\\", separador);
        } else if (sistemaOperativo.toLowerCase().contains("windows")) {
            path = path.replace("/", separador);
        }
        return path;
    }
    public static void main(String[] args) {
        String path = "src\\ex6\\arxius";

        path = getAutomaticPath(path);
        String separador = FileSystems.getDefault().getSeparator();

        System.out.println(path);

        try {
            File directoryArxiuNou = new File(path + separador + "arxiusNou");
            File diretory = new File(path);
            File[] directoryFiles = diretory.listFiles();
            directoryArxiuNou.mkdir();
            for (File file : directoryFiles) {
                if (file.isFile()) {
                    if (file.getName().endsWith(".txt")) {
                        File newDirectory = new File(directoryArxiuNou + separador +
                                file.getName().substring(0, file.getName().indexOf(".")));
                        System.out.println(newDirectory);
                        System.out.println(newDirectory.mkdir());
                    }
                }
                if (file.isDirectory()) {
                    System.out.println(file.toPath());
                    File newDirectories = new File(directoryArxiuNou + separador + file.getName() + ".txt");
                    System.out.println(newDirectories);
                    System.out.println(newDirectories.createNewFile());
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
