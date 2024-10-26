package packAnimals;

import java.util.Date;

public class Horses extends PackAnimals {

    int gallop;

    public Horses(String name, Date birthDate, double loadCapacity, int gallop) {
        super(name, birthDate, loadCapacity);
        this.gallop = gallop;
    }

    @Override
    public void makeSound() {
        System.out.println("Igo-go!");
    }
}
