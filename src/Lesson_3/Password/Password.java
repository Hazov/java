package Lesson_3.Password;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    public static boolean isValid(String str){
        Pattern pattern = Pattern.compile
                ("^(?=^.{8,20}$)(?=.*\\d)(?![\\\\|/])(?=.*[A-Za-zА-Яа-я])(?=.*[!@#$%^&*();:?]).*$");
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }
}
