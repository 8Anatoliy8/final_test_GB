package packAnimals;

import animals.Animals;

import java.util.Date;

public class Camels extends PackAnimals {
    int humpCount;

    public Camels(String name, Date birthDate, double loadCapacity, int humpCount) {
        super(name, birthDate, loadCapacity);
        this.humpCount = humpCount;
    }


    @Override
    public void makeSound() {
        System.out.println("Aaaaaah...");
    }
}
