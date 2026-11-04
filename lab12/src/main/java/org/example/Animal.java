package org.example;

class Animal {
    private String name;
    private int id;
    private String habitat;

    public Animal(String name, int id, String habitat) {
        this.name = name;
        this.id = id;
        this.habitat = habitat;
    }

    public String getName() { return name; }
    public int getId() { return id; }
    public String getHabitat() { return habitat; }

    public void setName(String name) { this.name = name; }
    public void setId(int id) { this.id = id; }
    public void setHabitat(String habitat) { this.habitat = habitat; }

    @Override
    public String toString() {
        return "name='" + name + "', id=" + id + ", habitat='" + habitat + "'";
    }
}
