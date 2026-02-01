package model;

import model.interfaces.Validatable;
import model.interfaces.Playable;

public abstract class Media extends BaseEntity implements Playable, Validatable {

    protected int duration;
    protected Author author;
    protected Category category;

    protected Media(int id, String name, int duration, Author author, Category category) {
        super(id, name);
        setDuration(duration);
        this.author = author;
        this.category = category;
    }

    public abstract void play();
    public abstract String getMediaType();

    public int getDuration() { return duration; }
    public void setDuration(int duration) {
        if (duration <= 0) throw new IllegalArgumentException("Duration must be positive");
        this.duration = duration;
    }

    public Author getAuthor() { return author; }
    public Category getCategory() { return category; }

    @Override
    public boolean isValid() {
        return super.isValid() && duration > 0 && author != null;
    }

    @Override
    public String getEntityType() {
        return getMediaType();
    }
}
