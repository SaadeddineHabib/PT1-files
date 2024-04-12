package ex7;

public class TestFileManager {
    public static void main(String[] args) {
        DirectoryManager directoryManager = new DirectoryManager();

        directoryManager.getDirectoryFiles(".");

        System.out.println(directoryManager);

        System.out.println();

        directoryManager.showFilesByAlphabeticalOrder();

        System.out.println();

        directoryManager.showFilesByLastModifiedDateOrder();

        System.out.println();

        directoryManager.showFilesByLengthOrderDesc();


    }
}
