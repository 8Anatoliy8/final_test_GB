package manager;

import animals.Animals;

import java.util.ArrayList;
import java.util.List;

public class AnimalRegistry {
    private List<Animals> animals;

    public AnimalRegistry() {
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animals animal) {
        animals.add(animal);
        System.out.println(animal.getName() + " добавлено в реестр.");
    }

    public List<Animals> getAnimals() {
        return animals;
    }
}
