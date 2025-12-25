package org.example.task1.mapper;
import org.example.task1.entity.Funifier;
import org.example.task1.entity.Operation;
import org.example.task1.enums.Operations;

import java.util.List;

public class FunnyStringMapper {

    public static Funifier toFunifierEntity(String boringString, String funnyString) {
        Funifier funifier = new Funifier();
        funifier.setBoring_string(boringString);
        funifier.setFunny_string(funnyString);
        return funifier;
    }
    public static FunnyStringRequest toRequest(String boringString,
                                               List<Integer> startRanges,
                                               List<Integer> endRanges,
                                               List<Operations> operationsList) {
        FunnyStringRequest funnyStringRequest=new FunnyStringRequest();
        funnyStringRequest.setBoringString(boringString);
        funnyStringRequest.setStartRanges(startRanges);
        funnyStringRequest.setEndRanges(endRanges);
        funnyStringRequest.setOperationsList(operationsList);

        return funnyStringRequest;
    }

//    public static Operation toOperationEntity(Long funifierId, FunnyStringRequest.OperationRequest request) {
//        Operation operation = new Operation();
//        operation.setBoring_string(funifierId.intValue());
//        operation.setStart_range(request.getStartRange());
//        operation.setEnd_range(request.getEndRange());
//        operation.setOperation_name(request.getOperation());
//        return operation;
//    }
}