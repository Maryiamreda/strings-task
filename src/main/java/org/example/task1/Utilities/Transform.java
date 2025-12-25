package org.example.task1.Utilities;

import org.example.task1.enums.Operations;

import java.util.ArrayList;
import java.util.List;

public class Transform {
    public static List<Operations> stringsToEnum(String operations) {
        List<Operations> operationsList = new ArrayList<>();
        for (String s : operations.split("\\s*,\\s*")) {
            operationsList.add(Operations.valueOf(s));
        }
        return operationsList;
    }
    public static List<Integer> transferStringToList(String indices) {
        List<Integer> myList = new ArrayList<>();
        for (String s : indices.split("\\s*,\\s*")) {
            myList.add(Integer.valueOf(s));
        }
        return myList;
    }
}
