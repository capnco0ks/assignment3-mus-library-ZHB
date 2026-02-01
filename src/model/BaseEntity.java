package model;

import model.interfaces.Validatable;
import model.interfaces.Printable;

public abstract class BaseEntity implements Validatable, Printable {

    private int id;
    private String name;

    protected BaseEntity(int id, String name) {
        setId(id);
        setName(name);
    }

    public abstract String getEntityType();

    @Override
    public void printInfo() {
        System.out.println(
                "Type: " + getEntityType() +
                        ", ID: " + id +
                        ", Name: " + name
        );
    }

    @Override
    public boolean isValid() {
        return name != null && !name.isBlank();
    }

    public int getId() { return id; }
    public void setId(int id) {
        if (id <= 0) throw new IllegalArgumentException("ID must be positive");
        this.id = id;
    }

    public String getName() { return name; }
    public void setName(String name) {
        if (Validatable.isNullOrEmpty(name)) throw new IllegalArgumentException("Name cannot be empty");
        this.name = name;
    }
}
