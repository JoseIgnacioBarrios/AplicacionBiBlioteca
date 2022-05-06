package Biblioteca.Model;

public class Autor {
    int id;
    String name;

    public Autor(String name) {
        this.name = name;
    }

    public Autor(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public String toString() {
        return "Name: " + name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() { return this.id; }
}
