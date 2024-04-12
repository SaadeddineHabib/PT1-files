import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        try {
            System.out.print("Introdueix el directori: ");
            File directory = new File(sc.next());

            File[] directoryList;

            directoryList = directory.listFiles();

            for (File file : directoryList) {
                if (file.getName().contains("exercici")) {
                    System.out.printf("El arxiu %s el seu contigut es: ", file.getName());
                    for (int i = 0; i < Files.readAllLines(Path.of(file.getPath())).size(); i++) {
                        System.out.println(Files.readAllLines(Path.of(file.getPath())).get(i));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
