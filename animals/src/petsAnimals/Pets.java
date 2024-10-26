package petsAnimals;

import animals.Animals;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public abstract class Pets extends Animals {
    protected List<String> commands;

    public Pets(String name, Date birthDate) {
        super(name, birthDate);
        this.commands = new ArrayList<>();
    }

    public List<String> getCommands() {
        return commands;
    }

    public void addCommand(String command) {
        commands.add(command);
    }
}
