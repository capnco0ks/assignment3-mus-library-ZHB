package model;

public class Song extends Media {

    private String genre;

    public Song(int id, String name, int duration, Author author, String genre, Category category) {
        super(id, name, duration, author, category);
        this.genre = genre;
    }

    @Override
    public void play() {
        System.out.println("Playing song: " + getName());
    }

    @Override
    public String getMediaType() {
        return "Song";
    }

    @Override
    public boolean isValid() {
        return getName() != null && !getName().isBlank() && getDuration() > 0 && getAuthor() != null;
    }

    public String getGenre() {
        return genre;
    }
}
