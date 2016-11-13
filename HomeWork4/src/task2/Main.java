package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final int MAX_LENGTH = 100;
    private static final int MIN_LENGTH = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> listWords = new ArrayList<>();
        int countInputWords;

        boolean wrongNumberInput;
        do {
            countInputWords = inputFirstNumber(scanner);
            wrongNumberInput = countInputWords == -1;
        } while (wrongNumberInput);

        boolean wrongWordInput;
        String word;
        int i = 0;
        while (i++ < countInputWords) {
            do {
                word = inputWord(scanner);
                wrongWordInput = !word.equals("-1");
            } while (!wrongWordInput);
            listWords.add(AbbreviationGenerator.squeezeWord(word));
        }

        System.out.println("\n==== Result: ====");
        listWords.forEach(System.out::println);
    }

    private static int inputFirstNumber(Scanner scanner) {
        System.out.print("Please, enter number: ");
        int result;
        try {
            result = Integer.parseInt(scanner.next());
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
            return -1;
        }

        if (result < MIN_LENGTH || result > MAX_LENGTH) {
            System.err.printf("The number should be in the range between %d and %d!!!\n", MIN_LENGTH, MAX_LENGTH);
            return -1;
        }

        return result;
    }

    private static String inputWord(Scanner scanner) {
        System.out.print("Please, enter word : ");
        String input = scanner.next();

        if (input.length() < MIN_LENGTH || input.length() > MAX_LENGTH) {
            System.err.printf("Word should have %d to %d characters!!!\n", MIN_LENGTH, MAX_LENGTH);
            return "-1";
        }

        Matcher matcherNumber = Pattern.compile("\\d+").matcher(input);
        Matcher matcherNonAlphabeticCharacter = Pattern.compile("\\W+").matcher(input);
        if (matcherNumber.find() || matcherNonAlphabeticCharacter.find()) {
            System.err.println("Allowed only Latin alphabetic characters!!!");
            return "-1";
        }

        return input;
    }
}