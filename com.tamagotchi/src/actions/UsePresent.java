package actions;

import model.Animal;
import model.BonusType;
import model.Present;

public class UsePresent {
    public void doAction(final Animal animal, final int index) {
        final Present present = animal.getPresent().get(index);

        if (present.getBonusType() == BonusType.SATIETY) {
            animal.addHungry(present.getBonus());
        }

        if (present.getBonusType() == BonusType.PURITY) {
            animal.addClear(present.getBonus());
        }

        if (present.getBonusType() == BonusType.CURE) {
            animal.setSick(false);
        }

        animal.getPresent().remove(index);
    }
}
