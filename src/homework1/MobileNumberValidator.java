package homework1;

import java.util.Scanner;

public class MobileNumberValidator {

    private final static int PREFIX_LENGTH = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] telephoneNumber;

        System.out.println("Please enter the telephone number : ");

        do {
            telephoneNumber = scanner.next().toCharArray();
            if (telephoneNumber[0] == '+') {
                telephoneNumber = trimPlus(telephoneNumber);
            }
        } while (!validator(telephoneNumber));

        int sum = sumArrays(telephoneNumber);
        int step = 1;
        System.out.println(step + "st round of calculation: sum is " + sum);
        while (sum >= 10) {
            sum = sumArrays(String.valueOf(sum).toCharArray());
            System.out.println(++step + "st round of calculation: sum is " + sum);
        }
        System.out.print("Final result is: ");
        printResult(sum);
    }

    private static char[] trimPlus(char[] chars) {
        char[] trunkString = new char[chars.length - 1];
        for (int i = 1; i < chars.length; i++) {
            trunkString[i - 1] = chars[i];
        }
        return trunkString;
    }

    private static void printResult(int i) {
        if (i <= 4) {
            switch (i) {
                case 1: System.out.println("One"); break;
                case 2: System.out.println("Two"); break;
                case 3: System.out.println("Three"); break;
                case 4: System.out.println("Four"); break;
            }
        } else {
            System.out.println(i);
        }
    }

    private static boolean validator(char[] chars) {
        boolean state = false;
        if (chars.length > 13 || chars.length < 10) {
            System.out.println("Phone number is incorrect. Please try again : ");
        } else {
            if (validationCharacters(chars) && equalsPrefix(foundPrefix(chars))) {
                System.out.println("Phone number is correct.");
                state = true;
            } else {
                System.out.println("Phone number is incorrect. Please try again : ");
            }
        }
        return state;
    }

    private static boolean validationCharacters(char[] chars) {
        boolean state = true;
        for (char c : chars) {
            state = equalsPermittedChar(c);
            if (!state) break;
        }
        return state;
    }

    private static boolean equalsPermittedChar(char c) {
        boolean state = false;
        char[] permittedCharacters = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        for (char permittedCharacter : permittedCharacters) {
            state = (c == permittedCharacter);
            if (state) break;
        }
        return state;
    }

    private static int sumArrays(char[] chars) {
        int sum = 0;
        for (char c : chars) {
            sum += Character.getNumericValue(c);
        }
        return sum;
    }

    private static boolean equalsPrefix(char[] chars) {
        boolean state = false;
        String[] permittedPrefix = {"050", "063", "067", "068", "073", "093", "096", "097", "098", "099"};
        String prefix = "";
        for (char c : chars) {
            prefix += c;
        }
        for (String s : permittedPrefix) {
            if (prefix.equals(s)) {
                state = true;
                break;
            }
        }
        return state;
    }

    private static char[] foundPrefix(char[] chars) {
        int start = foundZero(chars);
        if (start >= PREFIX_LENGTH) {
            return new char[]{'0'};
        }
        int finish = start + PREFIX_LENGTH;
        char[] prefix = new char[PREFIX_LENGTH];
        int j = 0;
        for (int i = start; i < finish; i++) {
            prefix[j++] = chars[i];
        }
        return prefix;
    }

    private static int foundZero(char[] chars) {
        int index = 0;
        for (Character string : chars) {
            if (string == '0') {
                break;
            }
            ++index;
        }
        return index;
    }
}