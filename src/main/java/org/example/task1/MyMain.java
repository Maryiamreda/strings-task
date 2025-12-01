package org.example.task1;
import java.util.Scanner;


public class MyMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringFunifier funifier = new StringFunifier();
        String s = sc.nextLine();
        funifier.setBoringString(s);
        funifier.setStart(sc.nextLine());
        funifier.setEnd(sc.nextLine());
        funifier.getFunnyString();
    }
}

