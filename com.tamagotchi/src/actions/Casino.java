package actions;

import model.Animal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Casino {

    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public void doAction(final Animal animal) {
        final int money = animal.getMoney();

        if (animal.getAge() < 8) {
            System.out.println("In the casino you can from 8 years old");
            return;
        }

        if (money == 0) {
            System.out.println("Not enough money");
            return;
        }

        do {
            System.out.printf("Your money : %d%n", animal.getMoney());
            System.out.println("Enter amount. In the Case of a Win, the money will double, in the event of a loss, it will go to the casino.");
            System.out.println("Please 0 po exit");
            final int i = bufferedReader.lines().mapToInt(Integer::parseInt).findFirst().orElse(0);

            if (i == 0) {
                return;
            }

            if (i > 0 && i <= money) {
                final Random random = new Random();
                final boolean isYourChose = random.nextBoolean();
                if (isYourChose) {
                    animal.addMoney(i * 2);
                    System.out.println("You win");
                } else {
                    animal.addMoney(-i);
                    System.out.println("You lose");
                }
            } else {
                System.out.println("Not enough money");
            }

        } while (true);

    }

}
