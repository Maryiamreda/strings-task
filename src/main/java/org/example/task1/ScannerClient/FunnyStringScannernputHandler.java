package org.example.task1.ScannerClient;
import org.example.task1.enums.Operations;
import org.example.task1.mapper.FunnyStringRequest;
import java.util.List;
import java.util.Scanner;

import static org.example.task1.Utilities.Transform.stringsToEnum;
import static org.example.task1.Utilities.Transform.transferStringToList;
import static org.example.task1.mapper.FunnyStringMapper.toRequest;

public class FunnyStringScannernputHandler {
    public static FunnyStringRequest mapInputToFunnyStringRequest(Scanner scanner) {
        String boringString = scanner.nextLine();
        List<Integer> startRanges = transferStringToList(scanner.nextLine());
        List<Integer> endRanges = transferStringToList(scanner.nextLine());
        List<Operations> operationsList = stringsToEnum(scanner.nextLine());
        return toRequest(boringString, startRanges, endRanges, operationsList);
    }
}
