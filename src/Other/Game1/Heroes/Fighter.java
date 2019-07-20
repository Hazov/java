package Other.Game1.Heroes;

public abstract class Warriors extends Hero{
    protected int damage;

    public Warriors(int health, String name, int damage) {
        super(health, name);
        this.damage = damage;
    }
}
