package model;

public abstract class BaseEntity {

    private int id;
    private String name;

    protected BaseEntity(int id, String name) {
        setId(id);
        setName(name);
    }

    public abstract String getEntityType();
    public abstract boolean isValid();

    public void printInfo() {
        System.out.println(
                "Type: " + getEntityType() +
                        ", ID: " + id +
                        ", Name: " + name
        );
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be positive");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }
}
