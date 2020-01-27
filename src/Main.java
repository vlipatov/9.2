import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к папке. \nФормат для ввода - C:\\Users\\username\\folderName");
        String path = scanner.nextLine();
        System.out.println("Введите путь назначения");
        String newPath = scanner.nextLine();
        folderCopy(path, newPath);

    }

    private static void folderCopy(String path, String newPath) throws IOException {

        Path source = Paths.get(path);
        Path destination = Paths.get(newPath);
//        Files.createDirectory(destination);
        File folder = new File(path);
        File[] files = folder.listFiles();

        try {
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Папка скопирована!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
