package org.example.task1;
import java.util.ArrayList;
import java.util.List;
public class StringFunifier {
    private String boringString;
    private  List<Integer> start = new ArrayList<>();
    private  List<Integer> end = new ArrayList<>();
    StringFunifier(String boringString , String start , String end){
        this.boringString=boringString;
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
    public void getFunnyString() {
        for (int i = 0; i < boringString.length(); i++) {
            if (start.contains(i)) {
                int index = start.indexOf(i);
                int x = start.get(index);
                int y = end.get(index) + 1;
                String sReverse = boringString.substring(x, y);
                reverse(sReverse);
                i = y - 1;
                continue;
            }
            System.out.print(boringString.charAt(i));
        }
    }
    private void reverse(String s) {
        char[] ch = s.toCharArray();
        System.out.print("(");
        for (int i = ch.length - 1; i >= 0; i--) {
            System.out.print(ch[i]);
        }
        System.out.print(")");
    }
}
