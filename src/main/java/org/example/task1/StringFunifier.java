package org.example.task1;

import java.util.ArrayList;
import java.util.List;

public class StringFunifier {
    private String boringString;
    private List<Integer> start = new ArrayList<>();
    private List<Integer> end = new ArrayList<>();

    StringFunifier(String boringString, String start, String end) {
        this.boringString = boringString;
        setStart(start);
        setEnd(end);
    }

    public void setStart(String line) {
        String[] stringArray = line.split("\\s*,\\s*");
        for (String s : stringArray) {
            start.add(Integer.valueOf(s));
        }
    }
    public void setEnd(String line) {
        String[] stringArray = line.split("\\s*,\\s*");
        for (String s : stringArray) {
            end.add(Integer.valueOf(s));
        }
    }
    public String getFunnyString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < boringString.length();) {
            if (start.contains(i)) {
                int index = start.indexOf(i);
                int y = end.get(index) + 1;
                String sReverse = boringString.substring(i, y);
                sb.append("(")
                        .append(reverse(sReverse))
                        .append(")");
                i = y ;
            }
          else {
                sb.append(boringString.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }

    private String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
