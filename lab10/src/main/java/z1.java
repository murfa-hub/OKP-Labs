interface Useful {
    void use();
    String getPurpose();
}

interface Repairable {
    void repair();
    boolean isBroken();
}
class Hammer implements Useful, Repairable {
    private String name;
    private double weight;
    private boolean broken;

    public Hammer(String name, double weight, boolean broken) {
        this.name = name;
        this.weight = weight;
        this.broken = broken;
    }

    @Override
    public void use() {
        if (broken) {
            System.out.println(name + " сломан, нельзя использовать!");
        } else {
            System.out.println("Используем " + name + ": Забиваем гвозди!");
        }
    }

    @Override
    public String getPurpose() {
        return "Забивание гвоздей";
    }

    @Override
    public void repair() {
        if (broken) {
            broken = false;
            System.out.println(name + " успешно отремонтирован.");
        } else {
            System.out.println(name + " не нуждается в ремонте.");
        }
    }

    @Override
    public boolean isBroken() {
        return broken;
    }
}

class Screwdriver implements Useful, Repairable {
    private String name;
    private int size;
    private boolean broken;

    public Screwdriver(String name, int size, boolean broken) {
        this.name = name;
        this.size = size;
        this.broken = broken;
    }

    @Override
    public void use() {
        if (broken) {
            System.out.println(name + " сломана, нельзя использовать!");
        } else {
            System.out.println("Используем " + name + " (размер " + size + "): Закручиваем шурупы!");
        }
    }

    @Override
    public String getPurpose() {
        return "Закручивание шурупов";
    }

    @Override
    public void repair() {
        if (broken) {
            broken = false;
            System.out.println(name + " успешно отремонтирована.");
        } else {
            System.out.println(name + " не нуждается в ремонте.");
        }
    }

    @Override
    public boolean isBroken() {
        return broken;
    }
}
public class z1 {
    public static void main(String[] args) {
        Useful[] tools = new Useful[5];
        tools[0] = new Hammer("Молоток-гвоздодер", 1.5, false);
        tools[1] = new Hammer("Кувалда", 3.0, false);
        tools[2] = new Hammer("Молоток столярный", 0.8, true);
        tools[3] = new Screwdriver("Отвертка крестовая", 2, false);
        tools[4] = new Screwdriver("Отвертка шлицевая", 3, false);
        for (int i = 0; i < tools.length; i++) {
            System.out.println("Назначение: " + tools[i].getPurpose());
            tools[i].use();

            if (tools[i] instanceof Repairable) {
                Repairable repairableTool = (Repairable) tools[i];
                System.out.println("Сломан? " + (repairableTool.isBroken() ? "Да" : "Нет"));
                if (repairableTool.isBroken()) {
                    repairableTool.repair();
                    System.out.print("После ремонта: ");
                    tools[i].use();
                }
            }
            System.out.println();
        }
    }
}
