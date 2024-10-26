package animals;

import java.util.Date;

public abstract class Animals {
    protected String name;
    protected Date birthDate;
    private static int animalCount = 0;

    public Animals(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        animalCount++;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public abstract void makeSound();
    public String getName() {
        return name;
    }
    public Date getBirthDate() {
        return birthDate;
    }
}
