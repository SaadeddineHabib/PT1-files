package ex7;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ui {
    private Scanner sc = new Scanner(System.in);

    private DirectoryManager directoryManager = new DirectoryManager();

    private String menu() {
        return "\n\n### MENU ###\n\n" +
                "1. Obtenir directori\n" +
                "2. Mostrar arxius\n" +
                "3. Mostrar arxius per mida (ordre descendent)\n" +
                "4. Mostrar arxius per data de modificació\n" +
                "5. Mostrar arxius en ordre alfabètic\n" +
                "\n0. Sortir\n" +
                "\nSeleccione una opció: ";
    }

    private int getControlledIntegerInput(String textToDisplay) {
        int intInput;
        while (true) {
            try {
                System.out.print(textToDisplay);
                intInput = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error! Introdueix un numero valid.");
                sc.nextLine();
            }
        }
        return intInput;
    }

    public void runProgram() {
        int opcio = getControlledIntegerInput(menu());
        while (opcio != 0) {
            switch (opcio) {
                case 1:
                    getDirectory();
                    break;
                case 2:
                    directoryManager.showFiles();
                    break;
                case 3:
                    directoryManager.showFilesByLengthOrderDesc();
                    break;
                case 4:
                    directoryManager.showFilesByLastModifiedDateOrder();
                    break;
                case 5:
                    directoryManager.showFilesByAlphabeticalOrder();
                    break;
            }
            opcio = getControlledIntegerInput(menu());
        }
    }


    private void getDirectory() {
        System.out.print("Introdueix la ruta del directori: ");
        String directoryPath = sc.next();
        if (directoryManager.getDirectoryFiles(directoryPath)) {
            System.out.println();
            System.out.println("S'ha trobat el directori correctament!");
        }
    }


}
