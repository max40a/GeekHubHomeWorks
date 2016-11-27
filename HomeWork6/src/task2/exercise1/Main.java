package task2.exercise1;

import task2.exercise1.objects.MyWord;
import task2.exercise1.objects.MyNumber;
import task2.exercise1.sorters.*;

public class Main {
    public static void main(String[] args) {
        ArraySorter bubbleSorter = new BubbleSorter();
        ArraySorter insertionSorter = new InsertionSorter();
        ArraySorter selectionSorter = new SelectionSorter();

        MyNumber[] numbers = new MyNumber[5];
        numbers[0] = new MyNumber(5);
        numbers[1] = new MyNumber(23);
        numbers[2] = new MyNumber(2);
        numbers[3] = new MyNumber(-12);
        numbers[4] = new MyNumber(2);

        System.out.println("Not sort arrays : ");
        for (MyNumber number : numbers) {
            System.out.println(number.getValue());
        }

        System.out.println("\nAfter bubble sorted : ");
        MyNumber[] bubbleSortedNumbersArray = (MyNumber[]) bubbleSorter.sort(numbers, Direction.ASK);
        for (MyNumber number : bubbleSortedNumbersArray) {
            System.out.println(number.getValue());
        }

        System.out.println("\nAfter insertion sorted : ");
       MyNumber[] insertionSortedNumbersArray = (MyNumber[]) insertionSorter.sort(numbers, Direction.ASK);
       for (MyNumber number : insertionSortedNumbersArray) {
           System.out.println(number.getValue());
       }

        System.out.println("\nAfter selection sorted : ");
        MyNumber[] selectionSortedNumbersArray = (MyNumber[]) selectionSorter.sort(numbers, Direction.ASK);
        for (MyNumber number : selectionSortedNumbersArray) {
            System.out.println(number.getValue());
        }

        MyWord[] words = new MyWord[5];
        words[0] = new MyWord("cccc");
        words[1] = new MyWord("bbbb");
        words[2] = new MyWord("aaaaaaa");
        words[3] = new MyWord("xxxxxxxxx");
        words[4] = new MyWord("aaaaaaaaaaa");

        System.out.println("\n\nNot sort arrays : ");
        for (MyWord word : words) {
            System.out.println(word.getWords());
        }

        System.out.println("\nAfter bubble sorted : ");
        MyWord[] bubbleSortedWordsArray = (MyWord[]) bubbleSorter.sort(words, Direction.DESC);
        for (MyWord word : bubbleSortedWordsArray) {
            System.out.println(word.getWords());
        }

        System.out.println("\nAfter insertion sorted : ");
        MyWord[] insertionSortedWordsArray = (MyWord[]) insertionSorter.sort(words, Direction.DESC);
        for (MyWord word : insertionSortedWordsArray) {
            System.out.println(word.getWords());
        }

        System.out.println("\nAfter selection sorted : ");
        MyWord[] selectionSortedWordsArray = (MyWord[]) selectionSorter.sort(words, Direction.DESC);
        for(MyWord w : selectionSortedWordsArray) {
            System.out.println(w.getWords());
        }
    }
}