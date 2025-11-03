//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Задание 1. Задача 1. ");
        Box<Integer> box = new Box<>(3);

        printBox(box);

        System.out.println("\nЗадача 2.");
        while (true) {
            System.out.println("Введите число: ");
            if (scanner.hasNextInt()) {
                int a = scanner.nextInt();
                System.out.println("Введите число: ");
                int b = scanner.nextInt();
                ClassComparable a2 = new ClassComparable(a);
                ClassComparable b2 = new ClassComparable(b);
                System.out.println("Результат сравнения: " + a2.сравнить(b2));
                break;
            } else {
                System.out.println("Нужно ввести число!");
                scanner.next();
            }
        }

        System.out.println("\nЗадание 2. Задача 2.");

        Box<Integer> box1 = null;
        Box<Double> box2 = null;
        Box<Float> box3 = null;

        while (true) {
            System.out.println("Введите целое число: ");
            if (scanner.hasNextInt()) {
                int a = scanner.nextInt();
                box1 = new Box<>(a);
                break;
            } else {
                System.out.println("Нужно ввести целое число!");
                scanner.next();
            }
        }

        while (true) {
            System.out.println("Введите число типа double: ");
            if (scanner.hasNextDouble()) {
                double b = scanner.nextDouble();
                box2 = new Box<>(b);
                break;
            } else {
                System.out.println("Нужно ввести число типа double!");
                scanner.next();
            }
        }

        while (true) {
            System.out.println("Введите число типа float: ");
            if (scanner.hasNextFloat()) {
                float c = scanner.nextFloat();
                box3 = new Box<>(c);
                break;
            } else {
                System.out.println("Нужно ввести число типа float!");
                scanner.next();
            }
        }

        double max = MaxBox.findMax(box1, box2, box3);
        System.out.println("Максимальное значение: " + max);

        System.out.println("Задание 3. Задача 1.");
        List<String> strings = List.of("qwerty", "asdfg", "zx");

        List<Integer> lengths = Utils.mapList(strings, s -> s.length());
        System.out.println(lengths);

        List<Integer> numbers = List.of(1, -3, 7);

        List<Integer> absNumbers = Utils.mapList(numbers, n -> n < 0 ? -n : n);
        System.out.println(absNumbers);

        List<int[]> arrays = List.of(
                new int[]{1, 5, 3},
                new int[]{-2, 0, 4},
                new int[]{7, 2, 9}
        );

        List<Integer> maxValues = Utils.mapList(arrays, arr -> {
            int max1 = Integer.MIN_VALUE;
            for (int num : arr) {
                if (num > max1) max1 = num;
            }
            return max1;
        });

        System.out.println(maxValues);

        System.out.println("\nЗадача 2.");
        List<String> words = List.of("qwerty", "asdfg", "zx");
        List<String> longWords = Utils2.filterList(words, s -> s.length() >= 3);
        System.out.println(longWords);

        List<Integer> numbers2 = List.of(1, -3, 7);
        List<Integer> nonPositive = Utils2.filterList(numbers2, n -> n <= 0);
        System.out.println(nonPositive);

        List<int[]> arrays2 = List.of(
                new int[]{-1, -2},
                new int[]{9, -3},
                new int[]{2, -1}
        );
        List<int[]> noPositives = Utils2.filterList(arrays2, arr -> {
            for (int x : arr) {
                if (x > 0) return false;
            }
            return true;
        });

        for (int[] arr : noPositives) {
            System.out.print("[");
            for (int x : arr) System.out.print(x + " ");
            System.out.println("]");
        }

        System.out.println("\nЗадача 3.");
        List<String> words2 = List.of("qwerty", "asdfg", "zx");
        String combined = Utils3.reduceList(words2, (a, b) -> a + b, "");
        System.out.println(combined);

        List<Integer> numbers3 = List.of(1, -3, 7);
        int sum = Utils3.reduceList(numbers3, (a, b) -> a + b, 0);
        System.out.println(sum);

        List<List<Integer>> listOfLists = List.of(
                List.of(1, 2, 3),
                List.of(4, 5),
                List.of(6)
        );
        int totalElements = Utils3.reduceList(
                listOfLists,
                (a, b) -> {
                    a.addAll(b);
                    return a;
                },
                new java.util.ArrayList<>()
        ).size();
        System.out.println(totalElements);

        System.out.println("\nЗадача 4.");

        List<Integer> numbers4 = List.of(1, -3, 7, -5, 0);

        List<Integer> positives = Utils4.collectList(numbers4,
                ArrayList::new,
                (list, n) -> { if(n > 0) list.add(n); });

        List<Integer> negatives = Utils4.collectList(numbers4,
                ArrayList::new,
                (list, n) -> { if(n < 0) list.add(n); });

        System.out.println("Положительные: " + positives);
        System.out.println("Отрицательные: " + negatives);

        List<String> words4 = List.of("qwerty", "asdfg", "zx", "qw");

        Map<Integer, List<String>> byLength = Utils4.collectList(
                words4,
                HashMap::new,
                (map, word) -> map.computeIfAbsent(word.length(), k -> new ArrayList<>()).add(word)
        );
        System.out.println("Группировка по длине: " + byLength);

        List<String> wordsWithDuplicates = List.of("qwerty", "asdfg", "qwerty", "qw");
        Set<String> uniqueWords = Utils4.collectList(
                wordsWithDuplicates,
                HashSet::new,
                Set::add
        );
        System.out.println("Уникальные слова: " + uniqueWords);

    }

    public static void printBox(Box<Integer> box) {
        int item = box.get();
        System.out.println("Содержимое коробки: " + item);

        System.out.println(box);
    }
}
