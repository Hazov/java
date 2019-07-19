package Other.Game1.Heroes;
import java.util.Random;

public class Assasin extends Hero {

    int cricitalHit;
    Random random = new Random();

    public Assasin(int heal, String name, int damage, int addHeal) {
        super(heal, name, damage, addHeal);
        this.cricitalHit = random.nextInt(20);
    }

    @Override
    public void hit(Hero hero) {
        if (hero != this) {
            if(health < 0) {
                System.out.println("Герой погиб и бить не может!");
            } else {
                if(random.nextInt(10) == 5){
                    hero.causeDamage(damage + cricitalHit);
                    System.out.println(this.name + " нанес КРИТИЧЕСКИЙ урон " + hero.name);
                } else {
                    hero.causeDamage(cricitalHit);
                    System.out.println(this.name + " нанес урон " + hero.name);
                }         
            }

        }
    }

    @Override
    public void healing(Hero hero) {
        System.out.println("Убийцы не умеют лечить!");
    }
}