package Other.Game1.Battle;
import Other.Game1.ColorConsole;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BattleController {
    private ArrayList<Team> teams;

    private Random random = new Random();
    public BattleController(Team... teams){
        this.teams = new ArrayList<>();
        Collections.addAll(this.teams, teams);
    }


    /* Метод отрабатывает пока в живых не останется только одна команда.
     * Все команды ходят по очереди, против рандомной команды. Ход - stepBattleWith().
     * Команда удаляется, если в ней больше не осталось игроков.
     * В конце на печать выводиться победитель*/
    public void battle(){
        System.out.println("Участвуют " + teams.size() + " команды:\n");
        for (Team team: teams) {
            System.out.println("Команда " + team);
        }
        System.out.println("---------------");
        while (teams.size() > 1) {
            for (int indexOfTeam1 = 0; indexOfTeam1 < teams.size(); indexOfTeam1++) {
                int indexOfTeam2 = indexOfTeam1;
                while(indexOfTeam1 == indexOfTeam2) indexOfTeam2 = random.nextInt(teams.size());

                teams.get(indexOfTeam1).stepBattleWith(teams.get(indexOfTeam2));
                if(teams.get(indexOfTeam2).heroes.size() == 0){
                    System.out.println(ColorConsole.toColorString
                            (teams.get(indexOfTeam2).colorText,("\nКоманда " + teams.get(indexOfTeam2)
                                    + ColorConsole.toColorString(ColorConsole.RED, " УНИЧТОЖЕНА!\n"))));
                    teams.remove(indexOfTeam2);

                }
            }
        }
        System.out.println("---------------");
        System.out.println("Победитель " + getWinner());

    }
    private Team getWinner(){
        return teams.get(0);

    }

    private String printWinner(){
        return "---------------\n" + "Победитель " + getWinner() + "\n" + this;
    }



}
