package manager;

import animals.Animals;

public class AnimalCounter {
    public void showAnimalCount() {
        System.out.println("Общее количество животных: " + Animals.getAnimalCount());
    }
}
