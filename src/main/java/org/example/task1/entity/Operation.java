package org.example.task1.entity;

import lombok.Getter;
import lombok.Setter;
import org.example.task1.enums.Operations;

@Getter
@Setter
public class Operation {
    private Long id;
    private int boring_string;
    private int start_range;
    private int end_range;
    private Operations operation_name;
}
