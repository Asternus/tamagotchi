package actions;

import model.Animal;

import java.util.Random;
import java.util.Scanner;

public class Store {
    public void doAction(Animal animal) {

        Scanner scanner = new Scanner(System.in);
        if (animal.getMoney() >= 50) {
            int temp;
            do {
                System.out.println(new StringBuilder()
                        .append("Enter gift number\n")
                        .append("  1. Costs 50 coins (Burger)\n")
                        .append("  2. Costs 100 coins (Soap)\n")
                        .append("  3. Costs 150 coins (Medicine)").toString());
                int s = scanner.nextInt();
                temp = s;
                switch (s) {
                    case (1): {
                        animal.presents(s);
                        animal.addMoney(-50);
                        animal.addHappy(20.0d);
                        break;
                    }
                    case (2): {
                        animal.presents(s);
                        animal.addMoney(-100);
                        animal.addHappy(25.0d);
                        break;
                    }
                    case (3): {
                        animal.presents(s);
                        animal.addMoney(-150);
                        animal.addHappy(30.0d);
                        break;
                    }
                }
            } while ((temp != 1) && (temp != 2) && (temp != 3));
        } else {
            System.out.println("Error, you don't have much money");
        }
    }
}
