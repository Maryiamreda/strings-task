package org.example.task1;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
@Getter
@Setter
public class StringFunfierEntity {
    //pojo (Plain Old Java Objects)
    String fName;
    String boringString;
    String funnyString;
    List<Integer> startRange;
    List<Integer>  endRange;
    List<Operations>  operations;
}
