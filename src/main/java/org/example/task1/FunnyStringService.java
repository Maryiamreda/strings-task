package org.example.task1;
import org.example.task1.entity.Funifier;
import org.example.task1.entity.Operation;
import org.example.task1.mapper.FunnyStringRequest;

import java.sql.SQLException;

import static org.example.task1.DependencyInjector.getDependency;

import static org.example.task1.mapper.FunnyStringMapper.toFunifierEntity;

public class FunnyStringService {
    private static final StringFunifier sf;
    private static final DBController db;
    static {
        try {
            sf = getDependency(StringFunifier.class);
            db = getDependency(DBController.class);
//            SocketClientFunnyString=new SocketClientFunnyString();

        } catch (SQLException e) {
            throw new Error(e.getSQLState());
        }
    }
    public String execute(FunnyStringRequest request) {
        String funnyString = sf.getFunnyString(request);
        Funifier funifier = toFunifierEntity(request.getBoringString(), funnyString);
        int id = db.insert(funifier);
        Operation op = new Operation();
        for (int i = 0; i < request.getStartRanges().size(); i++) {
            op.setStart_range(request.getStartRanges().get(i));
            op.setEnd_range(request.getEndRanges().get(i));
            op.setOperation_name(request.getOperationsList().get(i));
            op.setBoring_string(id);
            db.insert(op);
        }
        return funnyString;
    }

}
