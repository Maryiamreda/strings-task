package org.example.task1;
import java.util.Scanner;


public class MyMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String start=sc.nextLine();
        String end=sc.nextLine();
        StringFunifier funifier = new StringFunifier(s,start,end);
        funifier.getFunnyString();
    }
}

