package manager;



import animals.Animals;
import packAnimals.Camels;
import packAnimals.Donkey;
import packAnimals.Horses;
import petsAnimals.Cats;
import petsAnimals.Dogs;
import petsAnimals.Hamsters;
import petsAnimals.Pets;

import java.util.Date;
import java.util.Scanner;

public class Menu {
    private AnimalRegistry registry;
    private CommandManager commandManager;
    private AnimalCounter counter;
    private AnimalSorter sorter;
    private Scanner scanner;

    public Menu() {
        this.registry = new AnimalRegistry();
        this.commandManager = new CommandManager();
        this.counter = new AnimalCounter();
        this.sorter = new AnimalSorter();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить новое животное");
            System.out.println("2. Вывести список команд животного");
            System.out.println("3. Обучить животное новой команде");
            System.out.println("4. Вывести список животных по дате рождения");
            System.out.println("5. Показать общее количество животных");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addAnimal();
                    break;
                case 2:
                    listCommands();
                    break;
                case 3:
                    teachCommand();
                    break;
                case 4:
                    sorter.listAnimalsByBirthDate(registry.getAnimals());
                    break;
                case 5:
                    counter.showAnimalCount();
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
            }
        }
    }

    private void addAnimal() {
        System.out.print("Введите тип животного (собака/кошка/хомяк/лошадь/верблюд/осел): ");
        String type = scanner.nextLine();
        System.out.print("Имя: ");
        String name = scanner.nextLine();
        Date birthDate = new Date(); // Можно добавить парсинг даты от пользователя для точности
        Animals animal = null;

        switch (type.toLowerCase()) {
            case "собака":
                System.out.print("Порода собаки: ");
                String dogBreed = scanner.nextLine();
                animal = new Dogs(name, birthDate, dogBreed);
                break;
            case "кошка":
                System.out.print("Цвет кошки: ");
                String catColor = scanner.nextLine();
                animal = new Cats(name, birthDate, catColor);
                break;
            case "хомяк":
                System.out.print("Любимая еда хомяка: ");
                String hamsterColor = scanner.nextLine();
                animal = new Hamsters(name, birthDate, hamsterColor);
                break;
            case "лошадь":
                System.out.print("Грузоподъемность лошади (кг): ");
                double horsLoadCapacity = scanner.nextDouble();
                System.out.print("Количество галлопов за минуту: ");
                int gallop = scanner.nextInt();
                scanner.nextLine();
                animal = new Horses(name, birthDate, horsLoadCapacity, gallop);
                break;
            case "верблюд":
                System.out.print("Грузоподъемность лошади (кг): ");
                double camelLoadCapacity = scanner.nextDouble();
                System.out.print("Количество горбов у верблюда: ");
                int humpsCount = scanner.nextInt();
                scanner.nextLine();
                animal = new Camels(name, birthDate, camelLoadCapacity, humpsCount);
                break;
            case "осел":
                System.out.print("Грузоподъемность осла (кг): ");
                double donkeyLoadCapacity = scanner.nextDouble();
                System.out.println("Как кричит ваш осел?  ");
                String bray = scanner.nextLine();
                scanner.nextLine();
                animal = new Donkey(name, birthDate, donkeyLoadCapacity, bray);
                break;
            default:
                System.out.println("Неизвестный тип животного.");
                return;
        }

        registry.addAnimal(animal);
    }

    private void listCommands() {
        System.out.print("Введите имя животного для отображения команд: ");
        String searchName = scanner.nextLine();
        for (Animals a : registry.getAnimals()) {
            if (a.getName().equalsIgnoreCase(searchName) && a instanceof Pets) {
                commandManager.listCommands((Pets) a);
                return;
            }
        }
        System.out.println("Животное не найдено или не обучаемое.");
    }

    private void teachCommand() {
        System.out.print("Введите имя животного для обучения: ");
        String searchName = scanner.nextLine();
        System.out.print("Введите команду для обучения: ");
        String command = scanner.nextLine();
        for (Animals a : registry.getAnimals()) {
            if (a.getName().equalsIgnoreCase(searchName) && a instanceof Pets) {
                commandManager.teachNewCommand((Pets) a, command);
                return;
            }
        }
        System.out.println("Животное не найдено или не обучаемое.");
    }
}
