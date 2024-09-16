package Lesson_3.countOfWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainCount {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("Переменные");
        words.add("Переменные");
        words.add("Массивы");
        words.add("Пакеты");
        words.add("Классы");
        words.add("Методы");
        words.add("Интерфейсы");
        words.add("Абстракция");
        words.add("Полиморфизм");
        words.add("Инкапсуляция");
        words.add("Дженерики");
        words.add("Потоки");
        words.add("Регулярки");
        words.add("Методы");
        words.add("Пакеты");
        words.add("Классы");
        words.add("Интерфейсы");
        words.add("Абстракция");
        words.add("Потоки");
        words.add("Переменные");
        Map<String, Integer> countMap = new HashMap<>();

        for (String w : words) {
            if(!countMap.containsKey(w)){
                countMap.put(w,1);
            } else {
                countMap.put(w,countMap.get(w)+1);
            }
        }
        for (Map.Entry m : countMap.entrySet()) {
            System.out.println(m);
        }
    }



}
