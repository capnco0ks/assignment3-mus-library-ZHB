package model;
import model.interfaces.Playable;
import model.interfaces.Validatable;


public abstract class Media implements Playable,Validatable {



    protected int id;
    protected String name;
    protected int duration;
    protected Author author;

    public Media(int id, String name, int duration, Author author){

        setId(id);
        setName(name);
        setDuration(duration);
        this.author = author;
    }

    public abstract void play();
    abstract String getMediaType();

    public void displayInfo(){
        System.out.println(
                "ID"+id+
                ", name: "+ name+
                ", duration: "+duration+
                ", Author: "+author.getName()
        );
    }
//validation
    public void setName(String name){
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Media name cannot be empty");
        }
    }

    public void setDuration(int duration) {
        if (duration <= 0 ){
            throw new IllegalArgumentException("duration must be positive!");
        }
        this.duration = duration;
    }

    public void setId(int id){
        if (id<=0){
            throw new IllegalArgumentException("ID must be positive");
        }
        this.id = id;
    }
    //getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getDuration() { return duration; }
    public Author getAuthor() { return author; }

    @Override
    public boolean isValid(){
        return name != null && !name.isBlank() && duration>0;
    }

}
