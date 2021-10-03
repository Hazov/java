package Other.Game1.Heroes;

import Other.Game1.ColorConsole;

import java.util.Random;

public abstract class Fighter extends Hero{
    private int damage;
    int criticalHit;
    private Random random = new Random();

    public Fighter(int health, String name, int damage) {
        super(health, name);
        this.damage = damage;
    }

    public void hit(Hero hero) {

        if (random.nextInt(10) == 5 && this.criticalHit != 0) {
            hero.causeDamage(damage + criticalHit);
            System.out.println(this.name + ColorConsole.toColorString(ColorConsole.RED, " нанес КРИТИЧЕСКИЙ урон ") +
                    " " + hero.name + " " +
                    ColorConsole.toColorString(ColorConsole.RED, String.valueOf(damage+criticalHit)) + " " +
                    " =====> " + hero.info());
        } else {
            hero.causeDamage(damage);
            System.out.println(this.name + ColorConsole.toColorString(ColorConsole.RED, " нанес урон ") + " " +
                    hero.name + " " + ColorConsole.toColorString(ColorConsole.RED, String.valueOf(damage)) + " " +
                    " =====> " + hero.info());
        }
    }


}
