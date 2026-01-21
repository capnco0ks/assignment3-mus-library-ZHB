package model;

public class Podcast extends Media {
    private int episodeNumber;

    public Podcast(int id, String name, int duration, Author author, int episodeNumber,Category category){
        super(id,name,duration,author,category);
        this.episodeNumber = episodeNumber;
    }

    @Override
    public void play(){
        System.out.println("Playin podcast episode number: "+episodeNumber);
    }
    @Override
    public String getMediaType(){
        return "Podcast";
    }

    @Override
    public boolean isValid() {
        return false;
    }
}
