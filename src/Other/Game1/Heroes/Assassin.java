package Other.Game1.Heroes;
import java.util.Random;

public class Assasin extends Fighter {


    private Random random = new Random();

    public Assasin(int heal, String name, int damage) {
        super(heal, name, damage);
        this.criticalHit = random.nextInt(20);
    }

    @Override
    public String toString() {
        return "АССАССИН " + super.toString();
    }
}