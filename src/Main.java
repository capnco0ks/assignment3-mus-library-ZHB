import model.Author;
import repository.AuthorRepository;
import repository.interfaces.CrudRepository;
import service.AuthorService;

import utils.ReflectionUtils;
import utils.SortingUtils;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CrudRepository<Author> authorRepo = new AuthorRepository();
        AuthorService authorService = new AuthorService(authorRepo);

        Scanner sc = new Scanner(System.in);

        List<Author> authors = authorService.getAll();
        SortingUtils.sortList(authors, (a1, a2) -> a2.getRating() - a1.getRating());
        if (!authors.isEmpty()) {
            ReflectionUtils.inspectClass(authors.get(0));
        }

        while (true) {
            System.out.println("---------");
            System.out.println("DB OPERATIONS");
            System.out.println("---------");
            System.out.println("Choose action:");
            System.out.println("1 - Create Author");
            System.out.println("2 - List Authors");
            System.out.println("3 - Update Author");
            System.out.println("4 - Delete Author");
            System.out.println("5 - EXIT");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter ID:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter name:");
                    String name = sc.nextLine();
                    System.out.println("Enter rating (0-10):");
                    int rating = sc.nextInt();
                    sc.nextLine();

                    Author author = new Author(id, name, rating);
                    author.validate();
                    authorService.create(author);
                    System.out.println("Author created successfully.");
                }
                case 2 -> {
                    authors = authorService.getAll();
                    SortingUtils.sortList(authors, (a1, a2) -> a2.getRating() - a1.getRating());
                    System.out.println("=== Authors List (sorted by rating desc) ===");
                    authors.forEach(Author::printInfo);
                    System.out.println("===========================================");
                }
                case 3 -> {
                    System.out.println("Enter ID to update:");
                    int upId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter new name:");
                    String newName = sc.nextLine();
                    System.out.println("Enter new rating (0-10):");
                    int newRating = sc.nextInt();
                    sc.nextLine();

                    authorService.update(upId, newName, newRating);
                    System.out.println("Author updated successfully.");
                }
                case 4 -> {
                    System.out.println("Enter ID to delete:");
                    int delId = sc.nextInt();
                    sc.nextLine();
                    authorService.delete(delId);
                    System.out.println("Author deleted successfully.");
                }
                case 5 -> {
                    System.out.println("Bye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice, try again.");
            }
        }
    }
}
