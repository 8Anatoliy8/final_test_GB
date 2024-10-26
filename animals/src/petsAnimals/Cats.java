package petsAnimals;

import java.util.Date;

public class Cats extends Pets {
    private String color;

    public Cats(String name, Date birthDate, String color) {
        super(name, birthDate);
        this.color = color;
    }

    @Override
    public void makeSound() {
        System.out.println("Murr...");
    }
}
