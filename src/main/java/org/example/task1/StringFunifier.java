package org.example.task1;
import java.util.*;
public class StringFunifier {
    private final StringTransformer stringTransformer;

    public StringFunifier(StringTransformer stringTransformer)  {

        this.stringTransformer = stringTransformer;
    }
    public String getFunnyString(String boringString, List<Integer> startRanges, List<Integer> endRanges, List<Operations> operationsList)  {
        StringBuilder sb = new StringBuilder();
        int rangeIndex = 0;
        for (int i = 0; i < boringString.length(); ) {  //O(n)
            if (rangeIndex >= startRanges.size()) {
                sb.append(boringString, i, boringString.length());
                break;
            }
            String noEditsSubString = boringString.substring(i, startRanges.get(rangeIndex));
            sb.append(noEditsSubString);
            String operationSubString = boringString.substring(startRanges.get(rangeIndex), endRanges.get(rangeIndex) + 1);
            String editedSubstring = stringTransformer.tranformString(operationsList.get(rangeIndex), operationSubString);

            sb.append("(").append(editedSubstring).append(")");
            i = endRanges.get(rangeIndex) + 1;
            rangeIndex++;
        }
        return sb.toString();
    }

    public String getFunRanges(String boringString, List<Integer> startRanges, List<Integer> endRanges) {
        StringBuilder sb = new StringBuilder();
        int rangeIndex = 0;
        for (int i = 0; i < boringString.length(); ) {
            if (rangeIndex < startRanges.size() && startRanges.get(rangeIndex) == i) {  //O(1)
                int endRange = endRanges.get(rangeIndex) + 1;
                String sReverse = boringString.substring(i, endRange);
                sb.append("(").append(sReverse).append(")");
                i = endRange;
                continue;
            }
            sb.append(boringString.charAt(i));
            i++;
        }
        return sb.toString();
    }
}
