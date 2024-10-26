package packAnimals;

import java.util.Date;

public class Donkey extends PackAnimals{
    String bray;

    public Donkey(String name, Date birthDate, double loadCapacity, String bray) {
        super(name, birthDate, loadCapacity);
        this.bray = bray;
    }

    @Override
    public void makeSound() {
        System.out.println("IA");
    }
}
