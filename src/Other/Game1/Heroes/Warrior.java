package Other.Game1.Heroes;


import Other.Game1.ColorConsole;

public class Warrior extends Fighter {

    public Warrior(int health, String type, int damage) {
        super(health, type, damage);
        this.criticalHit = 0;
    }
    @Override
    public String toString() {
        return "ВОИН " + super.toString();
    }
}