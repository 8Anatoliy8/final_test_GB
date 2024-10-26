package manager;

import animals.Animals;

import java.util.Comparator;
import java.util.List;

public class AnimalSorter {
    public void listAnimalsByBirthDate(List<Animals> animals) {
        animals.sort(Comparator.comparing(Animals::getBirthDate));
        for (Animals animal : animals) {
            System.out.println(animal.getName() + " - Дата рождения: " + animal.getBirthDate());
        }
    }
}
