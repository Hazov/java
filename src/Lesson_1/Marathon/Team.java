package Lesson_1.Marathon;


import java.util.Arrays;

public class Team {
    String name;

    Competitor[] competitors;

    public Team(String name){
        this.name = name;
        this.competitors = new Competitor[]{
                new Human("Nikolay"),new Dog("Tuzik"),
                new Cat("Barsik"), new Human("Inna")};
    }
    public void printTeamList(){
        System.out.println("\nСостав команды:");
        for (int i = 0; i < competitors.length; i++) {
            System.out.println(i+1 + ") " + competitors[i].toString());
        }
    }

    public void printWinners(){
        int count = 1;
        System.out.println("\nПобедители: ");
        for (int i = 0; i < competitors.length; i++) {
            if(competitors[i].isOnDistance()) {
                System.out.println(count + ") " + competitors[i].toString());
                count++;
            }
        }
    }
    public void showResults(){
        printTeamList();
        printWinners();
    }
}
