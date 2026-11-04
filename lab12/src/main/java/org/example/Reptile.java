package org.example;

class Reptile extends Animal {
    private String scales;

    public Reptile(String name, int id, String habitat, String scales) {
        super(name, id, habitat);
        this.scales = scales;
    }

    public String getScales() { return scales; }
    public void setScales(String scales) { this.scales = scales; }

    @Override
    public String toString() {
        return "Reptile{" + super.toString() + ", scales='" + scales + "'}";
    }
}
