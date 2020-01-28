import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к папке. \nФормат для ввода - C:\\Users\\username\\folderName");
        String source = scanner.nextLine();
        System.out.println("Введите путь назначения");
        String dest = scanner.nextLine();
        folderCopy(source, dest);
        System.out.println("Папка полностью скопирована.");
    }

    private static void folderCopy(String source, String destination) throws IOException {
        File sourceDir = new File(source);
        File[] listOfFiles = sourceDir.listFiles();
        Path destDir = Paths.get(destination);
        if (!destDir.toFile().isDirectory()) { // если по пути назначения нет папки, то создаем новую
            Files.createDirectory(destDir);
        }
        if (listOfFiles != null)
            for (File file : listOfFiles)
                if (file.isDirectory()) {
                folderCopy(file.getAbsolutePath(), destDir+"\\"+file.getName());
                } else Files.copy(file.toPath(), destDir.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);
    }
}
