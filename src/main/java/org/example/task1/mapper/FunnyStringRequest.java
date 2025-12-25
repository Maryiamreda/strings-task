package org.example.task1.mapper;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import org.example.task1.enums.Operations;

import java.util.List;

@Getter
@Setter
public class FunnyStringRequest {
    private String boringString;
    private List<Integer> startRanges;
    private List<Integer> endRanges;
    private List<Operations> operationsList;
}
