package org.example.task1.Helpers;

import org.example.task1.enums.Operations;

import java.util.Arrays;

public class StringTransformer {
    public StringTransformer() {
    }

    private String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    private String upperCase(String s) {
        return s.toUpperCase();
    }

    private String lowerCase(String s) {
        return s.toLowerCase();
    }

    private String compression(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int count = 1;
            char c = s.charAt(i);
            while (i < s.length() - 1 && c == s.charAt(i + 1)) {
                count++;
                i++;
            }
            sb.append(c);
            sb.append(count);
        }
        return sb.toString();
    }

    private String sort(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    public String tranformString(Operations operation, String subString) {
        return switch (operation) {
            case REVERSE -> reverse(subString);
            case UPPERCASE -> upperCase(subString);
            case SORT -> sort(subString);
            case LOWERCASE -> lowerCase(subString);
            case COMPRESSION -> compression(subString);
        };
    }
}
