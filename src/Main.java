import model.*;

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

        //polymorphism
        song.play();
        Podcast.play();

        song.displayInfo();
        Podcast.displayInfo();
    }
}