package ru.geekbrains.java2.lesson2;

import java.util.Arrays;

public class ExceptionTest {
//    Есть строка вида: "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
//    (другими словами матрица 4x4)
//            10 3 1 2
//            2 3 2 2
//            5 6 7 1
//            300 3 1 0
//    Написать метод, на вход которого подаётся такая строка,
//    метод должен преобразовать строку в  двумерный массив типа String[][];

    static class DimensionException extends RuntimeException {
        DimensionException(String message) {
            super (message);
        }
    }

    private static String[][] createMatrix(String s) {
        String[][] result;
        String[] temp = s.split("\n");
        if (temp.length != 4)
            throw new DimensionException("Wrong 1st dimension");
        result = new String[temp.length][];
        for (int i = 0; i < temp.length; i++) {
            result[i] = temp[i].split(" ");
            if (result[i].length != 4)
                throw new DimensionException(String.format("Wrong 2nd dimension of %d element",++i));
        }
        return result;
    }
//2. Преобразовать все элементы массива в числа типа int, просуммировать,
//   поделить полученную сумму на 2, и вернуть результат;
    static class NumberConvertException extends Exception {
        NumberConvertException(String message) {
            super(message);
        }
    }
    private static float processMatrix(String[][] m) throws NumberConvertException {
        float result = 0.0f;
        int temp;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                try {
                    temp = Integer.parseInt(m[i][j]);
                } catch (NumberFormatException e){
                    throw new NumberConvertException(String.format("Incorrect number %s",m[i][j]));
                }
                result += temp;
            }
        }
        result /= 2f;
        return result;
    }

//3. Ваши методы должны бросить исключения в случаях:
//    Если размер матрицы, полученной из строки, не равен 4x4;
//    Если в одной из ячеек полученной матрицы не число; (например символ или слово)
//4. В методе main необходимо вызвать полученные методы, обработать возможные исключения
//   и вывести результат расчета.
//5. * Написать собственные классы исключений для каждого из случаев

    public static void main(String[] args) {
        String s = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        //String s = "10 3 1 2\n2 3 3 2 2\n5 6 7 1\n300 3 1 0";
        //String s = "10 3 1 2\n2 x 2 2\n5 6 7 1\n300 3 1 0";

        String[][] m = new String[0][];
        float r = 0;

        try {
            m = createMatrix(s);
            r = processMatrix(m);
        } catch (DimensionException e) {
            System.out.printf("Error creating matrix: %s%n\n",e.getMessage());
        } catch (NumberConvertException e) {
            System.out.printf("Error processing matrix: %s\n",e.getMessage());
        }
        System.out.println("Matrix:\n" + Arrays.deepToString(m));
        System.out.println("Result is: " + r);
    }

}
