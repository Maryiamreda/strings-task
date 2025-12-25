package org.example.task1;
import org.example.task1.Helpers.StringTransformer;
import org.example.task1.mapper.FunnyStringRequest;

import java.util.*;
public class StringFunifier {
    private final StringTransformer stringTransformer;

    public StringFunifier(StringTransformer stringTransformer)  {
        this.stringTransformer = stringTransformer;
    }
    public String getFunnyString(FunnyStringRequest request)  {
        StringBuilder sb = new StringBuilder();
        String boringString=request.getBoringString();
        int rangeIndex = 0;
        for (int i = 0; i < boringString.length(); ) {  //O(n)
            if (rangeIndex >= request.getStartRanges().size()) {
                sb.append(boringString, i, boringString.length());
                break;
            }
            String noEditsSubString = boringString.substring(i, request.getStartRanges().get(rangeIndex));
            sb.append(noEditsSubString);
            String operationSubString = boringString.substring(request.getStartRanges().get(rangeIndex), request.getEndRanges().get(rangeIndex) + 1);
            String editedSubstring = stringTransformer.tranformString(request.getOperationsList().get(rangeIndex), operationSubString);

            sb.append("(").append(editedSubstring).append(")");
            i = request.getEndRanges().get(rangeIndex) + 1;
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
