class Car {
    private String brand;
    private String engine;
    private int horsepower;

    public Car(String brand, String engine, int horsepower) {
        this.brand = brand;
        this.engine = engine;
        this.horsepower = horsepower;
    }
    public void start() {
        System.out.println("Автомобиль " + brand + " заводится стандартным ключом");
    }
    public void start(int keyCode) {
        System.out.println("Автомобиль " + brand + " заводится кодом: " + keyCode);
    }
    public void start(String mode) {
        System.out.println("Автомобиль " + brand + " заводится в режиме: " + mode);
    }
    public String getEfficiency() {
        return "Средняя эффективность";
    }
    public String getBrand() { return brand; }
    public String getEngine() { return engine; }
    public int getHorsepower() { return horsepower; }
}
class SportsCar extends Car {
    private int maxSpeed;

    public SportsCar(String brand, String engine, int horsepower, int maxSpeed) {
        super(brand, engine, horsepower);
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String getEfficiency() {
        return "Низкая эффективность";
    }
}
class SUV extends Car {
    private boolean fourWheelDrive;

    public SUV(String brand, String engine, int horsepower, boolean fourWheelDrive) {
        super(brand, engine, horsepower);
        this.fourWheelDrive = fourWheelDrive;
    }

    @Override
    public String getEfficiency() {
        return "Средняя эффективность";
    }
}
public class z1 {
    public static void main(String[] args) {
        Car simpleCar = new Car("Lada", "Бензин", 100);
        simpleCar.start();
        simpleCar.start(1234);
        simpleCar.start("Спорт");
        System.out.println();
        Car[] cars = new Car[3];
        cars[0] = new Car("Lada", "Бензин", 100);
        cars[1] = new SportsCar("Ferrari", "V12", 700, 320);
        cars[2] = new SUV("Toyota", "Дизель", 250, true);
        for (Car c : cars) {
            System.out.println("Автомобиль " + c.getBrand() + ": " + c.getEfficiency());
        }
        System.out.println();
    }
}
