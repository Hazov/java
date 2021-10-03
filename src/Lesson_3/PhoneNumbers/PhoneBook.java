package Lesson_3.PhoneNumbers;

import java.util.*;

public class PhoneBook {
    TreeMap<String, HashSet<String>> phoneBook;

    public PhoneBook(){
        this.phoneBook = new TreeMap<>();
    }
    public PhoneBook add(String name, String... numbers){
        HashSet<String> numb = new HashSet<>(Arrays.asList(numbers));
        phoneBook.put(name,numb);
        return this;
    }
    public void get(String name){
        HashSet<String> numbers = phoneBook.get(name);
        for (String number : numbers) {
            System.out.println(number);
        }
    }
}
