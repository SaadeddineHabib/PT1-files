package ex5;

import java.io.File;

public class Ex5 {

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void deleteNameNumberFiles(File[] directoryFiles) {
        for (File file : directoryFiles) {
            if (isNumeric(String.valueOf(file.getName().toCharArray()[0]))) {
                file.delete();
                System.out.println(file.getName());
            }
        }
    }


    public static void main(String[] args) {
        String pathLinux = "src/ex5/arxius";
        String pathWindows = "src\\ex5\\arxius";

        try {
            File diretory = new File(pathWindows);
            File[] directoryFiles = diretory.listFiles();
            deleteNameNumberFiles(directoryFiles);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
