import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к папке. \nФормат для ввода - C:\\Users\\username\\folderName");
        String path = scanner.nextLine();
        System.out.println("Введите путь назначения");
        String newPath = scanner.nextLine();
        Files.copy(Paths.get(path), Paths.get(newPath));


    }

    private static void folderCopy(String path, String newPath) throws IOException {
        Files.copy(Paths.get(path), Paths.get(newPath));
    }
}
