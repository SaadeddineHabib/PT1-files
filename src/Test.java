import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        System.out.print("Enter a path: ");
//        String path = sc.next();

        String path = "hola/que/tal";

        char[] array = path.toCharArray();

        System.out.println(Arrays.toString(array));
    }
}
