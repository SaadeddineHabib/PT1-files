import java.io.File;
import java.nio.file.FileSystems;
import java.util.Scanner;

public class Ex2 {

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
        File directory;

        try {
            if (args.length > 0) {
                String arguments = args[0];
                directory = new File(getAutomaticPath(arguments));

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