package actions;

import model.Animal;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Store {
    public void doAction(Animal animal) {

        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        do {
            System.out.printf("Your money : %d%n", animal.getMoney());
            System.out.println(new StringBuilder()
                    .append("Enter gift number\n")
                    .append("  0. return\n")
                    .append("  1. Costs 50 coins (Burger) + 20 happy\n")
                    .append("  2. Costs 100 coins (Soap) + 25 happy\n")
                    .append("  3. Costs 150 coins (Medicine) + 30 happy"));
            s = bufferedReader.lines().findFirst().orElse("");
            switch (s) {
                case "0": {
                    break;
                }
                case "1": {
                    if (animal.getMoney() >= 50) {
                        animal.presents(s);
                        animal.addMoney(-50);
                        animal.addHappy(20.0d);
                    } else {
                        System.out.println("Not enough money");
                    }
                    break;
                }
                case "2": {
                    if (animal.getMoney() >= 100) {
                        animal.presents(s);
                        animal.addMoney(-100);
                        animal.addHappy(25.0d);
                    } else {
                        System.out.println("Not enough money");
                    }
                    break;
                }
                case "3": {
                    if (animal.getMoney() >= 150) {
                        animal.presents(s);
                        animal.addMoney(-150);
                        animal.addHappy(30.0d);
                    } else {
                        System.out.println("Not enough money");
                    }
                    break;
                }
                default:
                    break;
            }
        } while (!s.equals("0"));
    }
}

