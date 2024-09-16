package Lesson_3.PhoneNumbers;

import java.util.ArrayList;

public class MainNumbers {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook
                .add("Вася", "111-111", "112-211", "121-121")
                .add("Петя", "233-333")
                .add("Коля", "777-777", "999-999", "777-777");
        phoneBook.get("Коля");
    }

}
