abstract class Pet {
    private String name;
    private int age;
    private String owner;

    public Pet(String name, int age, String owner) {
        this.name = name;
        this.age = age;
        this.owner = owner;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getOwner() { return owner; }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) this.name = name;
        else System.out.println("Кличка не может быть пустой");
    }

    public void setAge(int age) {
        if (age >= 0) this.age = age;
        else System.out.println("Возраст не может быть отрицательным");
    }

    public void setOwner(String owner) {
        if (owner != null && !owner.isEmpty()) this.owner = owner;
        else System.out.println("Хозяин не может быть пустым");
    }

    public abstract void feed();
    public abstract String getSpecialNeeds();

    public void displayInfo() {
        System.out.println("Кличка: " + name);
        System.out.println("Возраст: " + age + " лет");
        System.out.println("Хозяин: " + owner);
    }
}

class DogPet extends Pet {
    private String breed;

    public DogPet(String name, int age, String owner, String breed) {
        super(name, age, owner);
        this.breed = breed;
    }

    public String getBreed() { return breed; }

    public void setBreed(String breed) {
        if (breed != null && !breed.isEmpty()) this.breed = breed;
        else System.out.println("Порода не может быть пустой");
    }

    @Override
    public void feed() {
        System.out.println("Кормится 2 раза в день");
    }

    @Override
    public String getSpecialNeeds() {
        return "Нуждается в прогулках";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Порода: " + breed);
        System.out.println("Тип: Собака");
    }
}

class CatPet extends Pet {
    private String color;

    public CatPet(String name, int age, String owner, String color) {
        super(name, age, owner);
        this.color = color;
    }

    public String getColor() { return color; }

    public void setColor(String color) {
        if (color != null && !color.isEmpty()) this.color = color;
        else System.out.println("Цвет не может быть пустым");
    }

    @Override
    public void feed() {
        System.out.println("Кормится 3 раза в день");
    }

    @Override
    public String getSpecialNeeds() {
        return "Нуждается в лотке";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Цвет: " + color);
        System.out.println("Тип: Кошка");
    }
}
public class z1 {
    public static void main(String[] args) {
        Pet[] pets = new Pet[5];
        pets[0] = new DogPet("Шарик", 3, "Иванов", "Овчарка");
        pets[1] = new DogPet("Бобик", 5, "Петров", "Лабрадор");
        pets[2] = new CatPet("Мурка", 2, "Сидорова", "Белый");
        pets[3] = new CatPet("Барсик", 4, "Кузнецов", "Рыжий");
        pets[4] = new CatPet("Пушок", 1, "Смирнова", "Серый");
        for (Pet pet : pets) {
            pet.displayInfo();
            pet.feed();
            System.out.println("Особые потребности: " + pet.getSpecialNeeds());
            System.out.println();
        }
        //Pet pet = new Pet("X", 1, "Y");
    }
}
