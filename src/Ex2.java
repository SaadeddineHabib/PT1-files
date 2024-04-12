import java.io.File;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File directory;

        try {
            if (args.length > 0) {
                String arguments = args[0];
                directory = new File(arguments);

            } else {
                System.out.print("Introdueix el directori: ");
                directory = new File(sc.next());
            }

            File[] directoryList;

            directoryList = directory.listFiles();

            File arxiuGran = directoryList[0];
            for (File file : directoryList) {
                if (file.length() > arxiuGran.length()) {
                    arxiuGran = file;
                }
            }

            System.out.printf("El arxiu mes gran es %s amb %s Bytes en el directori %s", arxiuGran.getName(), arxiuGran.length(), directory.getName());
        } catch (Exception e) {
            System.out.println(e);
        }


    }

}