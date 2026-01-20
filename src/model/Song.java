package model;

public class Song extends Media {

    private String genre;

    public Song(int id, String name, int duration, Author author, String genre){
        super(id,name,duration,author);
        this.genre = genre;
    }

    @Override
    public void play(){
        System.out.println("Playing song: "+name);
    }

    @Override
    public String getMediaType(){
        return "Song";
    }

    public String getGenre(){
        return genre;
    }


}
