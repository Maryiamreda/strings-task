package org.example;

import org.example.task1.StringFunifier;
import org.example.task1.StringTransformer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       StringTransformer s =new StringTransformer();
       count(s);
        System.out.println(s.x);
    }
    static  void count(StringTransformer s){
       s.x=8;
    }
}