package Other.Game1.Battle;


import Other.Game1.Heroes.Fighter;
import Other.Game1.Heroes.Healer;
import Other.Game1.Heroes.Hero;


import java.util.ArrayList;
import java.util.Random;

public class TeamForABattle {
    static int count;
    private String name;
    protected ArrayList<Hero> heroes;

    String colorText;

    public TeamForABattle(String name){
        this.heroes = new ArrayList<>();
        this.name = name;

    }

    public TeamForABattle addHero(Hero hero){
        heroes.add(hero);
        return this;
    }

    /*Один ход героя. Берутся два рандомных героя.  */
    public void stepBattleWith(TeamForABattle otherTeam) {
        Random random = new Random();
        Hero hero = heroes.get(random.nextInt(heroes.size()));

        if (hero instanceof Fighter) {
            Hero opponent = otherTeam.heroes.get(random.nextInt(otherTeam.heroes.size()));
            ((Fighter) hero).hit(opponent);
            if (opponent.getHealth() <= 0) {
                otherTeam.heroes.remove(opponent);
            }
        } else if (hero instanceof Healer) {
            Hero heroToHealing = heroes.get(random.nextInt(heroes.size()));
            if (heroToHealing.getHealth() >= heroToHealing.getMaxHealth() || heroToHealing == hero) {
                int minHealth = 0;
                for (int i = 0; i < heroes.size(); i++) {
                    if(heroes.get(i) != hero){
                        int difference  = heroes.get(i).getMaxHealth() - heroes.get(i).getHealth();
                        if (difference != 0) {
                            if (difference < minHealth || minHealth == 0) {
                                minHealth = heroes.get(i).getHealth();
                                heroToHealing = heroes.get(i);
                            }
                        }
                    }
                }
                if(minHealth != 0){
                    ((Healer) hero).healing(heroToHealing);
                } else {
                    System.out.println("Доктору " + hero.getName() + " некого лечить!");
                }
            }

        }
    }

    @Override
    public String toString() {
        String result = "команда " + name + "\n";
        for (Hero hero : heroes) {
            result += hero.toString() + "\n";
        }
        return result;
    }
}
