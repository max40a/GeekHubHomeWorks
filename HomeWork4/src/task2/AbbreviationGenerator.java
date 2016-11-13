package task2;

import java.util.ArrayList;
import java.util.List;

public class AbbreviationGenerator {

    public List<String> makeAbbreviation(List<String> list) {
        List<String> temp = new ArrayList<>();
        for (String s : list) {
            temp.add(squeezeWord(s));
        }
        return temp;
    }

    private String squeezeWord(String s) {
        if (s.length() <= 10) {
            return s;
        }

        StringBuilder builder = new StringBuilder();
        builder.append(s.charAt(0));
        builder.append(String.valueOf(s.length() - 2));
        builder.append(s.charAt(s.length() - 1));

        return builder.toString();
    }
}