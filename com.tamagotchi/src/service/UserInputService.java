package service;


import actions.Casino;
import actions.Food;
import actions.Health;
import actions.Play;
import actions.Store;
import actions.UsePresent;
import actions.Work;
import model.Animal;
import model.AnimalType;
import model.Present;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class UserInputService {
    private final Scanner SCANNER = new Scanner(System.in);
    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private final Food food = new Food();
    private final Work work = new Work();
    private final Play play = new Play();
    private final Health health = new Health();
    private final Store store = new Store();
    private final UsePresent usePresent = new UsePresent();

    private final Casino casino = new Casino();

    public Animal userInputAnimalTypeName() {
        System.out.println("Available character types: ");
        AnimalType[] values = AnimalType.values();
        StringBuilder animalTypeString = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            animalTypeString.append(i).append(")").append(values[i]).append("\n");
        }
        System.out.println(animalTypeString);
        int userInputAnimalType;
        do {
            System.out.println("Enter animal number");
            userInputAnimalType = SCANNER.nextInt();
        } while (userInputAnimalType < 0 || userInputAnimalType >= values.length);
        String userInputAnimalName;
        do {
            System.out.println("Enter the name of the animal");
            userInputAnimalName = SCANNER.next();
        } while (userInputAnimalName.length() < 3 || userInputAnimalName.length() > 20);

        return new Animal(userInputAnimalName, values[userInputAnimalType]);
    }

    public void doActions(Animal animal) {
        StringBuilder builder = new StringBuilder("\nSelect an action: \n");
        builder.append(0).append(") Exit\n");
        builder.append(1).append(") Feed\n");
        builder.append(2).append(") Work\n");
        builder.append(3).append(") Play\n");
        builder.append(4).append(") Cure\n");
        builder.append(5).append(") Shop\n");
        builder.append(6).append(") Inventory\n");
        builder.append(7).append(") Casino\n");

        do {
            if (animal.getHungry() < 0) {
                System.out.println("The pet is very hungry and ran away from you");
                System.exit(0);
            }

            System.out.print(animal);
            System.out.println(builder);

            final String s = bufferedReader.lines().findFirst().orElse("");

            switch (s) {
                case "0": {
                    System.exit(0);
                    break;
                }
                case "1": {
                    food.doAction(animal);
                    break;
                }
                case "2": {
                    work.doAction(animal);
                    break;
                }
                case "3": {
                    play.doAction(animal);
                    break;
                }
                case "4": {
                    health.doAction(animal);
                    break;
                }
                case "5": {
                    store.doAction(animal);
                    break;
                }
                case "6": {
                    final List<Present> present = animal.getPresent();

                    if (present.isEmpty()) {
                        System.out.println("Inventory empty");
                        break;
                    }

                    for (int i = 0; i < present.size(); i++) {
                        final Present present1 = present.get(i);
                        System.out.println("Chose present");
                        System.out.printf("%d name: %s bonus: %s value: %s%n", i + 1, present1.getName(), present1.getBonusType(), present1.getBonus());
                    }
                    System.out.println("Chose 0 to return");

                    final int i = bufferedReader.lines().mapToInt(Integer::parseInt).findFirst().orElse(0);

                    if (i == 0) {
                        break;
                    }

                    usePresent.doAction(animal, i - 1);
                    break;
                }
                case "7": {
                    casino.doAction(animal);
                    break;
                }
                default:
                    break;
            }
        } while (true);

    }
}
