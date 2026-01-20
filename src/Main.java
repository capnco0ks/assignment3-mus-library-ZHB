import model.Author;
import model.Media;
import model.Podcast;
import model.Song;

public class Main {
    public static void main(String[] args){
        Author author = new Author(1,"MORGENSHTERN");
        Media song = new Song(
                1,"ICE",120,author,"Trap"
        );
        Media Podcast = new Podcast(
                2,"VPISKA Morgen",3600,author,1
        );

        //polymorphism
        song.play();
        
    }
}