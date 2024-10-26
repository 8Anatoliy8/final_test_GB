package packAnimals;

import animals.Animals;

import java.util.Date;

public abstract class PackAnimals extends Animals {
    protected double loadCapacity;

    public PackAnimals(String name, Date birthDate, double loadCapacity) {
        super(name, birthDate);
        this.loadCapacity = loadCapacity;
    }
}
