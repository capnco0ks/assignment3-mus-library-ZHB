package model;

public abstract class Media extends BaseEntity implements model.interfaces.Playable, model.interfaces.Validatable {

    protected Category category;
    protected int duration;
    protected Author author;

    protected Media(int id, String name, int duration, Author author, Category category) {
        super(id, name);
        setDuration(duration);
        this.author = author;
        this.category = category;
    }

    public abstract void play();
    public abstract String getMediaType();

    public void displayInfo() {
        System.out.println(
                "ID: " + getId() +
                        ", Name: " + getName() +
                        ", Duration: " + duration +
                        ", Author: " + (author != null ? author.getName() : "Unknown") +
                        ", Category: " + (category != null ? category.getName() : "None")
        );
    }

    public void setDuration(int duration) {
        if (duration <= 0) {
            throw new IllegalArgumentException("Duration must be positive");
        }
        this.duration = duration;
    }

    public int getDuration() { return duration; }
    public Author getAuthor() { return author; }
    public Category getCategory() { return category; }

    @Override
    public boolean isValid() {
        return getName() != null && !getName().isBlank() && duration > 0 && author != null;
    }

    @Override
    public String getEntityType() {
        return getMediaType();
    }
}
