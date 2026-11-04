package org.example;

class Mammal extends Animal {
    private String fur;

    public Mammal(String name, int id, String habitat, String fur) {
        super(name, id, habitat);
        this.fur = fur;
    }

    public String getFur() { return fur; }
    public void setFur(String fur) { this.fur = fur; }

    @Override
    public String toString() {
        return "Mammal{" + super.toString() + ", fur='" + fur + "'}";
    }
}
