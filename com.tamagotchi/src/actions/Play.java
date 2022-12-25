package actions;

import model.Animal;

import java.util.Random;

public class Play {
    private final Random random = new Random();
    private int playCount;

    public void doAction(Animal animal) {

        double index = 1 * animal.unHungryRet() * animal.isUnHappyRet() * animal.isSicRet();
        animal.addHappy(6);
        animal.addMoney(random.nextInt(10) + 1);
        animal.addHungry(-3.0d * index);

        if (++playCount == 5) {
            playCount = 0;
            animal.addAge(1);
        }
        animal.sick();
    }
}
