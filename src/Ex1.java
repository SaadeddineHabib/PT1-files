import java.io.File;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            File[] directoryList;
            System.out.print("Introdueix el directori: ");
            File directory = new File(sc.next());

            directoryList = directory.listFiles();

            File arxiuGran = directoryList[0];
            for (File file : directoryList) {
                if (file.length() > arxiuGran.length()) {
                    arxiuGran =  file;
                }
            }

            System.out.printf("El arxiu mes gran es %s amb %s Bytes en el directori %s", arxiuGran.getName(), arxiuGran.length(), directory.getName());
        } catch (NullPointerException e) {
            System.out.println(e);
        }


    }

}