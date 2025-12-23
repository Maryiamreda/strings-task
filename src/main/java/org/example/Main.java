package org.example;

import org.example.task1.*;
import org.example.task1.entity.FunRanges;

import java.sql.SQLException;


import static org.example.task1.DependencyInjector.getDependency;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
      final DBController db = getDependency(DBController.class);
        FunRanges fr = new FunRanges();
        fr.setId(6);
        FunRanges result = (FunRanges) db.get(fr);
        System.out.println(result.getFunny_string());
    }
}