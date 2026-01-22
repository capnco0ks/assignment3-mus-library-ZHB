import model.*;
import repository.AuthorRepository;
import service.AuthorService;
import utils.DataBaseConnection;

import model.Author;
import repository.AuthorRepository;

import java.sql.Connection;

public class Main {
    public static void main(String[] args){

        AuthorService authorService= new AuthorService();

        Author author = new Author(1,"MORGENSHTERN");
        Category music = new Category(1,"Music");
        Media song = new Song(
                1,"ICE",120, author,"Trap",music
        );
        Category interview = new Category(2,"Interviews");
        Media Podcast = new Podcast(
                2,"VPISKA Morgen",3600, author,1,interview
        );



        // DB OPERTAON ADDIN NEW AUTHOR
        //Author author1 = new Author(1,"MORGENSHTERN");
        //repo.create(author1);

        //
        // AuthorRepository authorRepo = new AuthorRepository();
        // Author author2 = new Author(2,"Lil Wayne");
        // authorRepo.create(author2);
        // AuthorRepository repo = new AuthorRepository();

        // authorService.getAll().forEach(a ->
        //         System.out.println(a.getId()+" "+a.getName())
        // );


        //DELETIN
        // authorService.delete(2);


        //POLYMORPH
        //song.play();
        //Podcast.play();
//
        //song.displayInfo();
        //Podcast.displayInfo();
    }
}