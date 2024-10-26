package manager;

import petsAnimals.Pets;

public class CommandManager {
    public void listCommands(Pets pet) {
        System.out.println("Команды животного: " + pet.getCommands());
    }

    public void teachNewCommand(Pets pet, String command) {
        pet.addCommand(command);
        System.out.println(pet.getName() + " обучено команде: " + command);
    }
}
