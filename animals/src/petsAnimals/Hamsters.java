package petsAnimals;

import java.util.Date;

public class Hamsters extends Pets{
    private String favoriteFood;

    public Hamsters(String name, Date birthDate, String favoriteFood) {
        super(name, birthDate);
        this.favoriteFood = favoriteFood;
    }

    @Override
    public void makeSound() {
        System.out.println("Shhh...");
    }
}
