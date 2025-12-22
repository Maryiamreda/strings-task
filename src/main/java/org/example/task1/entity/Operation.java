package org.example.task1.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.example.task1.Operations;

@Getter
@Setter
public class Operation {

    private int boring_string;
    private int start_range;
    private int end_range;
    private Operations operation_name;

}
