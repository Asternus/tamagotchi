package actions;

import model.Animal;

public class Health {

    public void doAction(Animal animal) {

        if (animal.getMoney() < 50) {
            System.out.println("You don't have enough money");
        } else {
            animal.setHappy(10.0d);
            animal.setHungry(70.0d);
            animal.setClear(80.0d);
            animal.addMoney(-50);
            animal.setSick(false);
            animal.setUnHungry(false);
        }
    }
}
