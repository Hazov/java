package Other.Game1.Battle;


import Other.Game1.ColorConsole;
import Other.Game1.Heroes.Fighter;
import Other.Game1.Heroes.Healer;
import Other.Game1.Heroes.Hero;


import java.util.ArrayList;
import java.util.Random;

public class Team {
    private static int count = 0;
    private String name;
    ArrayList<Hero> heroes;

    public String colorText;

    public Team(String name){
        this.heroes = new ArrayList<>();
        this.name = name;
        count++;
        this.colorText = count==1?ColorConsole.CYAN
                :count==2?ColorConsole.BLUE
                :count==3?ColorConsole.YELLOW
                :ColorConsole.ANSI_RESET;
    }

    public Team addHero(Hero hero){
        heroes.add(hero);
        hero.setTeam(this);
        hero.setName(ColorConsole.toColorString(colorText, hero.getName()));
        return this;
    }

    /*Один ход героя. Берутся два рандомных героя. Первый игрок взаимодействует со вторым (бьет/лечит).
     * Доктор не может лечить сам себя. Если рандомный персонаж здоров, то доктор его не лечит, а лечит самого раненого
     * из всех*/
    public void stepBattleWith(Team otherTeam) {
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
                    System.out.println(ColorConsole.toColorString(colorText, "Доктору ")
                            + hero.getName() + " некого лечить!");
                }
            }

        }
    }

    @Override
    public String toString() {
        return ColorConsole.toColorString(colorText,name);
    }
}
