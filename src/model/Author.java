package model;

public class Author {

    private int id;
    private String name;

    public Author(int id, String name){
        setId(id);
        setName(name);
    }

    public int getId() {return id; }
    public String getName(){return name; }

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
    }

}
