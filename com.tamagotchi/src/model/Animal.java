package model;

import com.sun.org.apache.bcel.internal.generic.SWITCH;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Animal {

    private final String name;
    private final AnimalType type;
    private int age;
    private double hungry;
    private int money;
    private double clear;
    private double happy;
    private boolean sick;
    private boolean unHappy;
    private boolean unHungry;
    private List<Present> present;
    private final Random random = new Random();

    public void setPresent(List<Present> present) {
        this.present = present;
    }

    public boolean isUnHappy() {
        return unHappy;
    }

    public void setUnHappy(boolean unHappy) {
        this.unHappy = unHappy;
    }

    public boolean isUnHungry() {
        return unHungry;
    }

    public void setUnHungry(boolean unHungry) {
        this.unHungry = unHungry;
    }

    public List<Present> getPresent() {
        return present;
    }

    public Animal(String name, AnimalType type) {
        this.name = name;
        this.type = type;
        this.age = 1;
        this.hungry = 100.0d;
        this.money = 0;
        this.clear = 100.0d;
        this.happy = 50.0d;
        this.unHungry = false;
        this.unHappy = false;
        this.sick = false;
        this.present = new ArrayList<>();
    }

    public void presents(final String chose) {
        switch (chose) {
            case "1": {
                final Present gift1 = new Present("Burger", 50 , BonusType.SATIETY);
                present.add(gift1);
                break;
            }
            case "2": {
                final Present gift2 = new Present("Soap", 50 , BonusType.PURITY);
                present.add(gift2);
                break;
            }
            case "3": {
                final Present gift2 = new Present("Medicine", 50 , BonusType.CURE);
                present.add(gift2);
                break;
            }
            default:
                break;
        }
    }

    public double isUnHappyRet() {
        if (unHappy) {
            return 1.2d;
        } else {
            return 1d;
        }
    }

    public double unHungryRet() {
        if (unHungry) {
            return 1.5d;
        } else {
            return 1d;
        }
    }

    public double isSicRet() {
        if (sick) {
            return 2d;
        } else {
            return 1d;
        }
    }

    public void setInfo() {
        if (hungry < 50) {
            setUnHungry(true);
        }
        if (hungry > 50) {
            setUnHungry(false);
        }
        if (happy < 20) {
            setUnHappy(true);
        }
        if (happy > 20) {
            setUnHappy(false);
        }
    }

    public boolean isSick() {
        return sick;
    }

    public void setSick(boolean sick) {
        this.sick = sick;
    }

    public String getName() {
        return name;
    }

    public AnimalType getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void addAge(int age) {
        this.age += age;
    }

    public double getHungry() {
        return hungry;
    }

    public void setHungry(double hungry) {
        this.hungry = hungry;
    }

    public void addHungry(double hungry) {
        this.hungry += hungry;
        setInfo();
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void addMoney(int money) {
        this.money += money;
        setInfo();
    }

    public double getClear() {
        return clear;
    }

    public void setClear(double clear) {
        this.clear = clear;
    }

    public void addClear(double clear) {
        this.clear += clear;
        setInfo();
    }

    public double getHappy() {
        return happy;
    }

    public void setHappy(double happy) {
        this.happy = happy;
    }

    public void addHappy(double happy) {
        this.happy += happy;
        setInfo();
    }

    public void sick() {
        final int randomNumber = random.nextInt(100);
        if (clear < 50) {
            if (randomNumber <= 30) {
                sick = true;
            }
        } else {
            if (randomNumber <= 10) {
                sick = true;
            }
        }
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", age=" + age +
                ", hungry=" + hungry +
                ", money=" + money +
                ", clear=" + clear +
                ", happy=" + happy +
                ", sick=" + (sick ? "SICK" : "HEALTHY") +
                ", unHungry=" + (unHungry ? "HUNGER" : "NORM") +
                ", unHappy=" + (unHappy ? "UNHAPPY" : "HAPPY") +
                ", presents=" + present +
                '}';
    }
}
