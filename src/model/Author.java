package model;

public class Author {

    private int id;
    private String name;
    private int rating;

    public Author(int id, String name,int rating){
        setId(id);
        setName(name);
        setRating(rating);
    }

    public int getId() {return id; }
    public String getName(){return name; }
    public int getRating(){ return rating; }

    public void setId(int id){
        if (id<= 0){
           throw new IllegalArgumentException("Author ID cannot be negative!");
        }
        this.id = id;
    }
    public void setName(String name){
        if (name==null|| name.isBlank()){
            throw new IllegalArgumentException("Author name cannot be empty");
        }
        this.name = name;
    }
    public void setRating(int rating){
        if (rating < 0 || rating > 10){
            throw new IllegalArgumentException("rating must be between 0 and 10");
        }
        this.rating = rating;
    }

}
