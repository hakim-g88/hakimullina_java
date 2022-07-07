import java.util.ArrayList;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        helloIfMoreThanSeven();
        theNameIsVyacheslav();
        multiplesOfThree();
    }

    // 1. Составить алгоритм: если введенное число больше 7, то вывести “Привет”.

    private static void helloIfMoreThanSeven() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите число.");
        double number;
        try {
            number = Double.parseDouble(input.nextLine());
            if (number > 7) {
                System.out.println("Привет");
            } else if (number <= 7) {
                System.out.println("");
            } else {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели не число.");
            helloIfMoreThanSeven();
        }
    }

    // 2. Составить алгоритм: если введенное имя совпадает с Вячеслав,
    // то вывести “Привет, Вячеслав”, если нет, то вывести "Нет такого имени".

    private static void theNameIsVyacheslav() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите имя.");
        String name = input.next();
        String modifiedName = name.substring(0,1).toUpperCase() +
                name.substring(1).toLowerCase();
        if (modifiedName.equals("Вячеслав")) {
            System.out.println("Привет, " + modifiedName);
        }
        else {
            System.out.println("Нет такого имени");
        }
    }

    // 3. Составить алгоритм: на входе есть числовой массив,
    // необходимо вывести элементы массива кратные 3.

    private static void multiplesOfThree() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите размер массива и нажмите Enter: ");
        String size = input.nextLine();
        if (size.matches("\\d+")) {
            System.out.println("Введите элементы массива - числа - через Enter: ");
            int sizeInt = Integer.parseInt(size);
            double[] array = new double[sizeInt];
            ArrayList<Double> result = new ArrayList<>();
            for (int i = 0; i < sizeInt; i++) {
                try {
                    System.out.println("Элемент №" + (i + 1) + ":");
                    array[i] = Double.parseDouble(input.nextLine());
                    if (i == sizeInt - 1) {
                        for (double l : array) {
                            if (l % 3 == 0) {
                                result.add(l);
                            }
                        }
                        System.out.println("Элементы массива кратные 3:");
                        System.out.println(result);
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Вы ввели не число.");
                    break;
                }
            }
        } else {
            System.out.println("Вы ввели некорретные данные. Введите целое положительное число");
            multiplesOfThree();
        }
    }

    /*
        4. Дана скобочная последовательность: [((())()(())]]
       - Можно ли считать эту последовательность правильной?
       - Если ответ на предыдущий вопрос “нет” - то что необходимо в ней изменить, чтоб она стала правильной?

    Ответ:
    Эту последовательность нельзя считать правильной.
    Чтобы она стала правильной, нужно:
    - или вторую с конца закрывающую квадратную скобку "]" заменить на обычную закрывающую скобку ")".
            [((())()(()))]
    - или вторую с начала открывающую скобку "(" заменить на квадратную открывающую скобку "[".
            [[(())()(())]]
     */
}
