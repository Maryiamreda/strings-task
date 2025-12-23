package org.example.task1;

import org.example.task1.entity.FunRanges;
import org.example.task1.entity.Funifier;
import org.example.task1.entity.Operation;
import org.example.task1.entity.Ranges;

import java.sql.SQLException;
import java.util.List;

import static org.example.task1.DependencyInjector.getDependency;

public class DBHandler {
    private static final DBController db;

    static {
        try {
            db = getDependency(DBController.class);
        } catch (SQLException e) {
            throw new Error(e.getSQLState());
        }
    }
    public static void InsertFunnyString(String boringString,String funnyString, List<Integer> startRanges, List<Integer> endRanges,List<Operations> operationsList){
        Funifier funifier = new Funifier();
        funifier.setBoring_string(boringString);
        funifier.setFunny_string(funnyString);
        int id = db.insert(funifier);
        Operation op = new Operation();
        for (int i = 0; i < startRanges.size(); i++) {
            op.setStart_range(startRanges.get(i));
            op.setEnd_range(endRanges.get(i));
            op.setOperation_name(operationsList.get(i));
            op.setBoring_string(id);
            db.insert(op);
        }
    }
    public static void InsertFunnyRange(String boringString,String funnyString, List<Integer> startRanges, List<Integer> endRanges){
        FunRanges funRanges = new FunRanges();
        funRanges.setBoring_string(boringString);
        funRanges.setFunny_string(funnyString);
        int id = db.insert(funRanges);
        Ranges range = new Ranges();
        for (int i = 0; i < startRanges.size(); i++) {
            range.setStart_range(startRanges.get(i));
            range.setEnd_range(endRanges.get(i));
            range.setBoring_string(id);
            db.insert(range);
        }
    }
}
