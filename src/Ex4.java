import java.io.File;
import java.util.concurrent.TimeUnit;

public class Ex4 {

    public static void showFileInformation(File[] filesDirectory) {
        for (File file : filesDirectory) {
            System.out.printf("El nom del arxiu es: %s%n", file.getName());
            System.out.printf("El tamany del arxiu es: %s Bytes%n", file.length());
            System.out.printf("El arxiu es un fitxer?: %s%n", file.isFile());
            System.out.printf("El arxiu es un directory?: %s%n", file.isDirectory());
            System.out.printf("El arxiu esta ocult?: %s%n", file.isHidden());
            System.out.printf("El arxiu es pot executar?: %s%n", file.canExecute());
            System.out.printf("El arxiu es pot llegir?: %s%n", file.canRead());
            System.out.printf("El arxiu es pot escriure?: %s%n", file.canWrite());
            System.out.printf("La ruta relativa del arxiu : %s%n", file.getPath());
            System.out.printf("La ruta absouluta del arxiu : %s%n", file.getAbsolutePath());
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
            System.out.printf("Han passat %s dies, %s hores, %s minuts i %s segons des de la darrera modificació del fitxer.%n", days, hours, minutes, seconds);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String pathLinux = "./";
        String pathWindows = ".\\";

        try {
            File diretory = new File(pathWindows);
            File[] directoryFiles = diretory.listFiles();
            showFileInformation(directoryFiles);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
