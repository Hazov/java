package Other.Game1.Heroes;

import Other.Game1.Battle.Team;
import Other.Game1.ColorConsole;

public abstract class Hero {


    Team team;

    protected int maxHealth;
    protected int health;
    protected String name;


    public Hero(int health, String name) {
        this.health = health;
        this.name = name;
        this.maxHealth = health;
        team = null;
    }


    public int getMaxHealth() {
        return maxHealth;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    void causeDamage(int damage) {
            health -= damage;
            if(health < 0){
                health = 0;
            }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }


    public String info() {
        String info = name + "[";
        info += this.health<=0?ColorConsole.toColorString(ColorConsole.RED, "УМЕР"):(getHealth() + " из " + getMaxHealth());
        info+="]";
       return info;
    }

    @Override
    public String toString() {
        if(team == null) return ColorConsole.toColorString(team.colorText, name);
        return name;
    }
}