package Lesson_1.Marathon;

import java.util.Arrays;

public class Courses {

    Obstacle[] courses;

    Courses(int countOfCourses){
        courses = new Obstacle[countOfCourses];
        for (int i = 0; i < countOfCourses; i++) {
            int rand = 1 + (int) (Math.random() * 3);      //rand от 1 до 3
            courses[i] = rand==1? new Wall(2): rand==2? new Water(10) : new Cross(500);
        }
        System.out.println("Препятствия: " + Arrays.toString(courses));
    }

    public void doIt(Team team){
        for (Competitor competitor : team.competitors) {
            System.out.println();
            for (Obstacle obtacle : courses) {
                obtacle.doIt(competitor);
                if(!competitor.isOnDistance())
                    break;
            }
        }
    }
}
