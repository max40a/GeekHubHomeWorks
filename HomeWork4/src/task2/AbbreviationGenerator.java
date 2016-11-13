package task2;

public class AbbreviationGenerator {

    public static String squeezeWord(String word) {
        if (word.length() <= 10) {
            return word;
        }

        StringBuilder abbr = new StringBuilder();
        abbr.append(word.charAt(0));
        abbr.append(String.valueOf(word.length() - 2));
        abbr.append(word.charAt(word.length() - 1));

        return abbr.toString();
    }
}