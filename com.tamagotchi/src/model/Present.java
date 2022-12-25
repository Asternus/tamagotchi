package model;

import java.util.Objects;

public class Present {

    private String name;

    private double bonus;

    private BonusType bonusType;

    public Present(final String name, final int bonus, final BonusType bonusType) {
        this.name = name;
        this.bonus = bonus;
        this.bonusType = bonusType;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(final double bonus) {
        this.bonus = bonus;
    }

    public BonusType getBonusType() {
        return bonusType;
    }

    public void setBonusType(final BonusType bonusType) {
        this.bonusType = bonusType;
    }

    @Override
    public String toString() {
        return "Present{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Present present = (Present) o;
        return Objects.equals(name, present.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
