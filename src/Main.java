
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws Exception {

//        while (true) { //Для выхода из цикла введи неверное выражение
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));
//        }

    }

    public static String calc(String input) throws Exception {

        Pattern pattern = Pattern.compile("\\s*\\d+\\s*[\\+\\-\\*\\/]\\s*\\d+\\s*");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            input = input.replaceAll(" ", "");

            String[] numbersInString = input.split("[\\+\\-\\*\\/]");

            if (numbersInString.length != 2)
                throw new Exception("Неверный формат выражения!");

            int a = Integer.parseInt(numbersInString[0]);
            int b = Integer.parseInt(numbersInString[1]);

            if (a < 1 || a > 10 || b < 1 || b > 10)
                throw new Exception("Числа должны входить в диапозон от 1 до 10");

            Integer result = 0;

            if (input.contains("+")) result = a + b;
            else if (input.contains("-")) result = a - b;
            else if (input.contains("/")) result = a / b;
            else if (input.contains("*")) result = a * b;
            else throw new Exception("Не найден арифметический оператор");
            return result.toString();
        } else throw new Exception("Неверный формат выражения");
    }
}