package task2.exercise1.objects;

public class MyWord implements Comparable<MyWord> {

    private String words;

    public MyWord(String words) {
        this.words = words;
    }

    public String getWords() {
        return words;
    }

    @Override
    public int compareTo(MyWord o) {
        int len1 = words.length();
        int len2 = o.words.length();
        int limit = Math.min(len1, len2);
        int i = 0;
        while (i < limit) {
            char c1 = words.charAt(i);
            char c2 = o.words.charAt(i);
            if (c1 != c2) {
                return c1 - c2;
            }
            i++;
        }
        return len1 - len2;
    }
}