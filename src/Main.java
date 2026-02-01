import model.*;
import service.AuthorService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Author authorForDemo = new Author(1, "Eminem", 9);
        Category categoryForDemo = new Category(1, "Hip-Hop");

        BaseEntity entity1 = authorForDemo;
        BaseEntity entity2 = new Song(
                2,
                "Superman",
                120,
                authorForDemo,
                "Rap",
                categoryForDemo
        );

        System.out.println("=== Polymorphism Demo ===");
        entity1.printInfo();
        entity2.printInfo();
        System.out.println("=========================");

        AuthorService authorService = new AuthorService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("---------");
            System.out.println("DB OPERATIONS");
            System.out.println("---------");
            System.out.println("Choose action w database:");
            System.out.println("1 - Create");
            System.out.println("2 - Read");
            System.out.println("3 - Update");
            System.out.println("4 - Delete");
            System.out.println("5 - EXIT");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter ID:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter rating (0-10): ");
                    int rating = sc.nextInt();
                    sc.nextLine();
                    authorService.create(new Author(id, name, rating));
                    System.out.println("Created successfully!");
                    break;
                case 2:
                    authorService.getAll()
                            .forEach(author -> System.out.println(
                                    author.getId() + " | " +
                                            author.getName() + " | " +
                                            author.getRating()
                            ));
                    break;
                case 3:
                    System.out.println("Enter ID to update: ");
                    int upId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter name to update: ");
                    String upName = sc.nextLine();
                    System.out.println("Enter new rating (0-10): ");
                    int newRating = sc.nextInt();
                    sc.nextLine();
                    authorService.update(upId, upName, newRating);
                    System.out.println("Updated!");
                    break;
                case 4:
                    System.out.println("Enter ID you want to delete: ");
                    int delId = sc.nextInt();
                    sc.nextLine();
                    authorService.delete(delId);
                    System.out.println("Deleted successfully.");
                    break;
                case 5:
                    System.out.println("Bye");
                    System.exit(0);
            }
        }
    }
}
