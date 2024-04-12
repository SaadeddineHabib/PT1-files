package ex7;

import java.io.File;
import java.nio.file.FileSystems;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

public class DirectoryManager {
    private String path;
    private File directory;
    private File[] files;

    public DirectoryManager() {
    }

    public static String getAutomaticPath(String path){
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

    public boolean getDirectoryFiles(String path) {
        this.path = getAutomaticPath(path);
        directory = creatControlledFile(path);
        if (directory == null) {
            System.out.println("El camí proporcionat és incorrecte");
        } else {
            if (directory.isDirectory()) {
                files = directory.listFiles();
                return true;
            } else {
                System.out.println("Error! El fitxer ha de ser un directori.");
            }
        }
        return false;
    }

    private File creatControlledFile(String path) {
        try {
            File directory = new File(path);
            return directory.exists() ? directory : null;
        } catch (NullPointerException e) {
            System.out.println(e);
        }

        return null;
    }

    public void showFiles() {
        if (files == null) {
            System.out.println();
            System.out.println("No es proporciona cap ruta de directori. Si us plau, introdueix un directori vàlid.");
        } else {
            System.out.println();
            System.out.println("#### SHOW FILES ####");
            for (File file : files) {
                String dash = "-";
                String print1 = String.format("El arxiu %s ubicat en %s ", file.getName(), file.getParent());
                String print2 = String.format("La seva ruta relativa es: %s", file);
                String print3 = String.format("El arxiu es de tipus: %s", file.isFile() ? "document" : "directori");
                System.out.println(print1);
                System.out.println(print2);
                System.out.println(print3);
                int loopLength = Math.max(print3.length(), Math.max(print1.length(), print2.length()));
                for (int i = 0; i < loopLength; i++) {
                    System.out.print(dash);
                }
                System.out.println();
                System.out.println();
            }
        }


    }


    public void showFilesByAlphabeticalOrder() {
        if (files == null) {
            System.out.println();
            System.out.println("No es proporciona cap ruta de directori. Si us plau, introdueix un directori vàlid.");
        } else {
            File[] files1 = directory.listFiles();
            Arrays.sort(files1, fileNameComparator);
            System.out.println();
            System.out.println("#### SHOW FILES IN ALPHABETICAL ORDER ####");
            for (File file : files1) {
                String dash = "-";
                String print1 = String.format("El arxiu %s ubicat en %s", file.getName(), file.getParent());
                String print2 = String.format("La seva ruta relativa es: %s", file);
                String print3 = String.format("El arxiu es de tipus: %s", file.isFile() ? "document" : "directori");
                System.out.println(print1);
                System.out.println(print2);
                System.out.println(print3);
                int loopLength = Math.max(print3.length(), Math.max(print1.length(), print2.length()));
                for (int i = 0; i < loopLength; i++) {
                    System.out.print(dash);
                }
                System.out.println();
                System.out.println();
            }
        }


    }

    public void showFilesByLastModifiedDateOrder() {

        if (files == null) {
            System.out.println();
            System.out.println("No es proporciona cap ruta de directori. Si us plau, introdueix un directori vàlid.");
        } else {
            File[] files1 = directory.listFiles();
            Arrays.sort(files1, fileLastDateModifeiedComparator);
            System.out.println();
            System.out.println("#### SHOW FILES BY DATE MODIFICATION ORDER ####");
            for (File file : files1) {
                long lastModified = file.lastModified();
                long now = System.currentTimeMillis();
                long difference = now - lastModified;
                long days = TimeUnit.MILLISECONDS.toDays(difference);
                difference -= TimeUnit.DAYS.toMillis(days);
                long hours = TimeUnit.MILLISECONDS.toHours(difference);
                difference -= TimeUnit.HOURS.toMillis(hours);
                long minutes = TimeUnit.MILLISECONDS.toMinutes(difference);
                difference -= TimeUnit.MINUTES.toMillis(minutes);
                long seconds = TimeUnit.MILLISECONDS.toSeconds(difference);
                String dash = "-";
                String print1 = String.format("El arxiu %s ubicat en %s la darrera vegada que es va modificar " +
                                "es %s dies, %s hores, %s minuts i %s segons",
                        file.getName(), file.getParent(), days, hours, minutes, seconds);
                String print2 = String.format("La seva ruta relativa es: %s", file);
                String print3 = String.format("El arxiu es de tipus: %s", file.isFile() ? "document" : "directori");
                System.out.println(print1);
                System.out.println(print2);
                System.out.println(print3);
                int loopLength = Math.max(print3.length(), Math.max(print1.length(), print2.length()));
                for (int i = 0; i < loopLength; i++) {
                    System.out.print(dash);
                }
                System.out.println();
                System.out.println();
            }
        }
    }

    public void showFilesByLengthOrderDesc() {
        if (files == null) {
            System.out.println();
            System.out.println("No es proporciona cap ruta de directori. Si us plau, introdueix un directori vàlid.");
        } else {
            File[] files1 = directory.listFiles();
            Arrays.sort(files1, fileLengthComparator);
            System.out.println();
            System.out.println("#### SHOW FILES BY SIZE IN DESCENDING ORDER ####");
            for (File file : files1) {
                String dash = "-";
                String print1 = String.format("El arxiu %s ubicat en %s te una mida de %s Bytes.", file.getName(), file.getParent(), file.length());
                String print2 = String.format("La seva ruta relativa es: %s", file);
                String print3 = String.format("El arxiu es de tipus: %s", file.isFile() ? "document" : "directori");
                System.out.println(print1);
                System.out.println(print2);
                System.out.println(print3);
                int loopLength = Math.max(print3.length(), Math.max(print1.length(), print2.length()));
                for (int i = 0; i < loopLength; i++) {
                    System.out.print(dash);
                }
                System.out.println();
                System.out.println();
            }


        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public static Comparator<File> fileNameComparator = (file, file1) -> {
        String fileName1 = file.getName();
        String fileName2 = file1.getName();
        return fileName1.compareTo(fileName2);
    };

    public static Comparator<File> fileLastDateModifeiedComparator = (file, file1) -> {

        long fileLastDateModified1 = file.lastModified();
        long fileLastDateModified2 = file1.lastModified();
        return Long.compare(fileLastDateModified2, fileLastDateModified1);
    };

    public static Comparator<File> fileLengthComparator = (file, file1) -> {

        long fileLength1 = file.length();
        long fileLength2 = file1.length();
        return (int) (fileLength2 - fileLength1);
    };

    @Override
    public String toString() {
        return "DirectoryManager{" +
                "path='" + path + '\'' +
                ", directory=" + directory +
                ", files=" + files +
                '}';
    }
}
