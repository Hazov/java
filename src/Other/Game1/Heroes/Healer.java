package Other.Game1.Heroes;

import Other.Game1.ColorConsole;

public abstract class Healer extends Hero {
    int addHealth;

    public Healer(int health, String name, int addHealth) {
        super(health, name);
        this.addHealth = addHealth;
    }


    public void healing(Hero hero) {
        hero.health+=addHealth;
        if(hero.health > hero.maxHealth)
            hero.health = hero.maxHealth;
        System.out.println(name + ColorConsole.toColorString(ColorConsole.GREEN, " подлечил ") + hero.name
                + " на " + ColorConsole.toColorString(ColorConsole.GREEN, String.valueOf(addHealth)) +
                " =====> " + hero.info());
    }


}
