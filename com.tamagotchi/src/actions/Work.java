package actions;

import model.Animal;

import java.util.Random;

public class Work {
    private final Random random = new Random();
    private int workCount;

    public void doAction(Animal animal) {
        if (animal.getAge() < 5 || animal.getHappy() < 20) {
            System.out.println("Error!");
            return;
        }

        double index = 1 * animal.unHungryRet() * animal.isUnHappyRet() * animal.isSicRet();
        animal.addMoney(random.nextInt(20 - 5) + 5);
        animal.addHungry(- 4.0d * index);
        animal.addHappy(- 2.0d * index);

        if (++workCount == 6) {
            workCount = 0;
            animal.addAge(1);
        }
        animal.sick();
    }
}

