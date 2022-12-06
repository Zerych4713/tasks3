import java.util.ArrayList;

public class Tasks3 {

    public static void main(String[] args) {

        // Task 1

        PrintHelper.printTask(1);
        int answer1 = solutions(1, 0, -1);
        System.out.println(answer1);
        PrintHelper.blank();

        // Task 2

        PrintHelper.printTask(2);
        int answer2 = findZip("all zip files are zipped");
        System.out.println(answer2);
        PrintHelper.blank();

        // Task 3

        PrintHelper.printTask(3);
        boolean answer3 = checkPerfect(496);
        System.out.println(answer3);
        PrintHelper.blank();

        // Task 4

        PrintHelper.printTask(4);
        String answer4 = flipEndChars("Cat, dog, and mouse.");
        System.out.println(answer4);
        PrintHelper.blank();

        // Task 5

        PrintHelper.printTask(5);
        boolean answer5 = isValidHexCode("#12abCF");
        System.out.println(answer5);
        PrintHelper.blank();

        // Task 6

        PrintHelper.printTask(6);
        int[] arr1 = new int[]{1, 2, 3, 3, 1, 2};
        int[] arr2 = new int[]{4, 5, 6, 4};
        boolean answer6 = same(arr1, arr2);
        System.out.println(answer6);
        PrintHelper.blank();

        // Task 7

        PrintHelper.printTask(7);
        boolean answer7 = isKaprekar(297);
        System.out.println(answer7);
        PrintHelper.blank();

        // Task 8

        PrintHelper.printTask(8);
        int answer8 = longestZero("__00___000_00000__00");
        System.out.println(answer8);
        PrintHelper.blank();

        // Task 9
        PrintHelper.printTask(9);
        int answer9 = nextPrime(24);
        System.out.println(answer9);
        PrintHelper.blank();

        // Task 10

        PrintHelper.printTask(10);
        boolean answer10 = rightTriangle(145, 100, 105);
        System.out.println(answer10);
        PrintHelper.blank();

    }

    // число решений уравнения
    // Task 1
    public static int solutions(int a, int b, int c) {
        double D = b * b - 4 * a * c;
        if (D == 0) {
            return 1;
        } else if (D < 0){
            return 0;
        } else {
            return 2;
        }
    }

    // возврат позиции второго вхождения "zip" в строку
    // Task 2
    public static int findZip(String str) {
        int N = 2;

        String slider = "";
        int number_of_zips = 0;

        for (int slider_at = 0; slider_at < str.length()-2; slider_at++) {
            slider = str.substring(slider_at, slider_at + 3);
            if (slider.equals("zip")) {
                number_of_zips += 1;
                if (number_of_zips == N) {
                    return slider_at;
                }
            }
        }

        return -1;
    }

    // совершенное число
    // Task 3
    public static boolean checkPerfect(int number) {
        int sum = 0;

        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        return (sum == number);
    }

    // замена первого и последнего символа строки с условиями
    // Task 4
    public static String flipEndChars(String str) {

        if (str.length() < 2) {
            return "Incompatible";
        }

        if (str.substring(0, 1).equals(str.substring(str.length()-1))) {
            return "Two's a pair";
        }

        return str.substring(str.length()-1) + str.substring(1, str.length()-1) + str.substring(0, 1);
    }

    // допустимый шестнадцатиричный код
    // Task 5
    public static boolean isValidHexCode(String str) {
        if (str.length() != 7) {return false;}

        if (str.charAt(0) != "#".charAt(0)) {return false;}

        String possible_chars = "0123456789ABCDEFabcdef";
        char[] possible_chars_arr = possible_chars.toCharArray();
        boolean is_possible_char;

        for (int i = 1; i < str.length(); i++) {
            is_possible_char = false;
            for (int j = 0; j < possible_chars_arr.length; j++) {
                if (str.charAt(i) == possible_chars_arr[j]) {is_possible_char = true;}
            }
            if (!is_possible_char) {return false;}
        }

        return true;
    }

    // одинаковое количество уникальных элементов
    // Task 6
    public static boolean same(int[] arr1, int[] arr2) {
        return unique_count(arr1) == unique_count(arr2);
    }

    // число уникальных элементов
    public static int unique_count(int[] arr) {
        ArrayList<Integer> unique = new ArrayList<>(0);

        for (int i = 0; i < arr.length; i++) {
            if (!unique.contains(arr[i])) {
                unique.add(arr[i]);
            }
        }

        return unique.size();
    }

    // число Капрекара
    // Task 7
    public static boolean isKaprekar(int n) {
        int N = n * n;

        String str_N = Integer.toString(N);

        if (str_N.length() % 2 > 0) {
            str_N = "0" + str_N;
        }

        int n1 = Integer.parseInt(str_N.substring(0, str_N.length() / 2));
        int n2 = Integer.parseInt(str_N.substring(str_N.length() / 2));

        return n1 + n2 == n;
    }

    // самая длинная последовательность нулей в двоичной строке
    // Task 8
    public static int longestZero(String str) {
        char[] str_chars = str.toCharArray();
        int max = 0;
        int current = 0;

        for (int i = 0; i < str_chars.length; i++) {
            if (str_chars[i] == "0".charAt(0)) {
                current += 1;
            } else {
                if (current > max) {
                    max = current;
                }
                current = 0;
            }
        }

        if (current > max) {max = current;}

        return max;
    }

    // возврат следующего простого числа
    // Task 9
    public static int nextPrime(int number) {

        boolean flag = true;

        while (true) {
            flag = true;

            for (int j = 2; j < number; j++) {
                if (number % j == 0) {
                    flag = false;
                    number += 1;
                }
            }
            if (flag) {
                return number;
            }
        }
    }

    // ребра прямоугольного треугольника
    // Task 10
    public static boolean rightTriangle(int a, int b, int c) {
        return (a*a == b*b + c*c) || (b*b == a*a + c*c) || (c*c == a*a + b*b);
    }

}
