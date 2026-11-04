package org.example;

class Fish extends Animal {
    private String fins;

    public Fish(String name, int id, String habitat, String fins) {
        super(name, id, habitat);
        this.fins = fins;
    }

    public String getFins() { return fins; }
    public void setFins(String fins) { this.fins = fins; }

    @Override
    public String toString() {
        return "Fish{" + super.toString() + ", fins='" + fins + "'}";
    }
}
