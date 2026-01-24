import model.*;
import repository.AuthorRepository;
import service.AuthorService;
import utils.DataBaseConnection;

import model.Author;
import repository.AuthorRepository;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        AuthorService authorService= new AuthorService();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("---------");
            System.out.println("DB OPERATIONS");
            System.out.println("---------");
            System.out.println("Choose action w database:");
            System.out.println("1 - Create");
            System.out.println("2 - Read");
            System.out.println("3 - Update");
            System.out.println("4 - Delete");
            System.out.println("5 - EXIT");

            int choise = sc.nextInt();
            sc.nextLine();

            switch (choise){
                case 1:
                    System.out.println("Enter ID:");
                    int id = sc.nextByte();
                    sc.nextLine();
                    System.out.println("Enter name: ");
                    String name = sc.nextLine();
                    authorService.create(new Author(id,name));
                    System.out.println("created succesfully");
                    break;
                case 2:
                    authorService.getAll().forEach(author -> System.out.println(author.getId() + " | "+author.getName()));
                    break;
                case 3:
                    System.out.println("Enter ID to update: ");
                    int upId = sc.nextByte();
                    sc.nextLine();
                    System.out.println("Enter name to update: ");
                    String upName = sc.nextLine();
                    authorService.update(upId,upName);
                    System.out.println("Updated!");
                    break;
                case 4:
                    System.out.println("Enter ID you want to delete: ");
                    int delId = sc.nextByte();
                    sc.nextLine();
                    authorService.delete(delId);
                    System.out.println("Deleted succesfully.");
                    break;
                case 5:
                    System.out.println("Bye");
                    System.exit(0);
            }
        }



        // DB OPERTAON ADDIN NEW AUTHOR
        //Author author1 = new Author(1,"MORGENSHTERN");
        //repo.create(author1);

         // AuthorRepository authorRepo = new AuthorRepository();
         // Author author2 = new Author(2,"Lil Wayne");
         // authorRepo.create(author2);
         // AuthorRepository repo = new AuthorRepository();

        //GET VALUES
        // authorService.getAll().forEach(a ->
        //         System.out.println(a.getId()+" "+a.getName())
        // );

        //UPDATE
        // authorService.update(2,"Lil Wayne (updated)");

        //DELETIN
        // authorService.delete(2);


        //POLYMORPH
        //song.play();
        //Podcast.play();

        //song.displayInfo();
        //Podcast.displayInfo();
    }
}