import model.*;
import repository.AuthorRepository;
import utils.DataBaseConnection;

import java.sql.Connection;

public class Main {
    public static void main(String[] args){
        Author author = new Author(1,"MORGENSHTERN");
        Category music = new Category(1,"Music");
        Media song = new Song(
                1,"ICE",120, author,"Trap",music
        );
        Category interview = new Category(2,"Interviews");
        Media Podcast = new Podcast(
                2,"VPISKA Morgen",3600, author,1,interview
        );

        try (Connection conn = DataBaseConnection.getConnection()){
            System.out.println("succesfully");
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Author author1 = new Author(1,"MORGENSHTERN");
        AuthorRepository repo = new AuthorRepository();
        repo.create(author1);

        //polymorphism
        //song.play();
        //Podcast.play();
//
        //song.displayInfo();
        //Podcast.displayInfo();
    }
}