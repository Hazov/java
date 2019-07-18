package Lesson_2.homework;

import java.util.stream.Stream;

public class MainHomeWork {

    public static void main(String[] args) {
        String[][] arr = new String[4][4];
        try {
            AmountOfQuadMatrix(arr);
        } catch (MyArraySizeException e) {
            System.out.println("НЕПОДХОДЯЩИЙ РАЗМЕРОМ МАССИВ!");
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

    }

    public static long AmountOfQuadMatrix(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int quad = 16;
        int size = Stream.of(arr).mapToInt(m -> m.length).sum();
        if(size != quad)  throw new MyArraySizeException();
        long result = 0;
        int o;

        for(int i = 0; i < Math.sqrt(quad); i++){
            for (int j = 0; j < Math.sqrt(quad); j++){
                try {
                    o = Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("В ячейке [" + i + "][" + j + "] - неверные данные");
                }
                result += o;
            }
        }
        return result;
    }

}

