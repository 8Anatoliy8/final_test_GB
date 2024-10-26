package petsAnimals;

import java.util.Date;

public class Dogs extends Pets {
    private String breed;

    public Dogs(String name, Date birthDate, String breed) {
        super(name, birthDate);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Gaf!");
    }
}
