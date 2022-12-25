package actions;

import model.Animal;

public class Health {

    public void doAction(Animal animal) {

        if (animal.getMoney() < 50) {
            System.out.println("You don't have enough money");
        } else if (!animal.isSick() && !animal.isUnHungry() && !animal.isUnHappy()) {
            System.out.println("You are healthy");
        } else {
            if (animal.getHappy() < 100.0d) {
                animal.setHappy(100.0d);
            }

            if (animal.getHungry() < 100.0d) {
                animal.setHungry(100.0d);
            }

            if (animal.getClear() < 100.0d) {
                animal.setClear(100.0d);
            }

            animal.addMoney(-50);
            animal.setSick(false);
            animal.setUnHungry(false);
            animal.setUnHappy(false);
        }
    }
}
