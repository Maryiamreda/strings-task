package org.example.task1.Utilities;

import org.example.task1.enums.Operations;
import org.example.task1.mapper.FunnyStringRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static org.example.task1.Utilities.Transform.stringsToEnum;
import static org.example.task1.Utilities.Transform.transferStringToList;
import static org.example.task1.mapper.FunnyStringMapper.toRequest;

public class InputHandler {
    public static FunnyStringRequest mapInputToFunnyStringRequest(Scanner scanner) {
        String boringString = scanner.nextLine();
        List<Integer> startRanges = transferStringToList(scanner.nextLine());
        List<Integer> endRanges = transferStringToList(scanner.nextLine());
        List<Operations> operationsList = stringsToEnum(scanner.nextLine());
        return toRequest(boringString, startRanges, endRanges, operationsList);
    }
    public static FunnyStringRequest mapInputToFunnyStringRequest(BufferedReader in) throws IOException {
        String boringString = in.readLine();
        List<Integer> startRanges = transferStringToList(in.readLine());
        List<Integer> endRanges = transferStringToList(in.readLine());
        List<Operations> operationsList = stringsToEnum(in.readLine());
        return toRequest(boringString,startRanges,endRanges,operationsList);
    }
}
