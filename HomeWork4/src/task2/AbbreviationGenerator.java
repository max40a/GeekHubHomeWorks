package task2;

public class AbbreviationGenerator {

    private static final int MAX_WORD_LENGTH = 10;

    public static String squeezeWord(String word) {
        if (word.length() <= MAX_WORD_LENGTH) {
            return word;
        }

        StringBuilder abbr = new StringBuilder();
        abbr.append(word.charAt(0));
        abbr.append(word.length() - 2);
        abbr.append(word.charAt(word.length() - 1));

        return abbr.toString();
    }
}