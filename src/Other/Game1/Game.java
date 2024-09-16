package Other.Game1;

import Other.Game1.Battle.BattleController;
import Other.Game1.Battle.Team;
import Other.Game1.Heroes.Assassin;
import Other.Game1.Heroes.Doctor;
import Other.Game1.Heroes.Warrior;




class Game {
    public static void main(String[] args) {


        Team team1 = new Team("№1");
        team1
                .addHero(new Assassin(150, "Акали", 70))
                .addHero(new Warrior(250, "Тигрил", 50))
                .addHero(new Doctor(120, "Жанна", 60));


        Team team2 = new Team("№2");
        team2
                .addHero(new Warrior(290, "Минотавр", 60))
                .addHero(new Assassin(160, "Джинкс", 90))
                .addHero(new Doctor(110, "Зои", 80));

        Team team3 = new Team("№3");
        team3
                .addHero(new Warrior(290, "Петька", 60))
                .addHero(new Assassin(160, "Василий Иваныч", 90))
                .addHero(new Doctor(110, "Анька", 80));

        BattleController battleController = new BattleController(team1, team2, team3);      //BattleController(...)
        battleController.battle();



    }
}