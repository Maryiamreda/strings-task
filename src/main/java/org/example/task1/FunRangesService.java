package org.example.task1;

import org.example.task1.entity.FunRanges;
import org.example.task1.entity.Ranges;

import java.sql.SQLException;
import java.util.List;

import static org.example.task1.DependencyInjector.getDependency;

public class FunRangesService  {
    private static final StringFunifier sf;
    private static final DBController db;

    static {
        try {
            sf = getDependency(StringFunifier.class);
            db = getDependency(DBController.class);

        } catch (SQLException e) {
            throw new Error(e.getSQLState());
        }
    }


    public String execute(String boringString, List<Integer> startRanges, List<Integer> endRanges) {
     String funnyRange=   sf.getFunRanges(boringString, startRanges, endRanges);
        FunRanges funRanges = new FunRanges();
        funRanges.setBoring_string(boringString);
        funRanges.setFunny_string(funnyRange);
        int id = db.insert(funRanges);
        Ranges range = new Ranges();
        for (int i = 0; i < startRanges.size(); i++) {
            range.setStart_range(startRanges.get(i));
            range.setEnd_range(endRanges.get(i));
            range.setBoring_string(id);
            db.insert(range);
        }
        return funnyRange;
    }
}
