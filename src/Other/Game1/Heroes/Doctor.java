package Other.Game1.Heroes;


public class Doctor extends Healer {


    public Doctor(int health, String name, int addHealth) {
        super(health, name, addHealth);
    }

    @Override
    public String toString() {
        return "ДОКТОР " + super.toString();
    }
}
