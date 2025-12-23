package org.example.task1.factory;

import org.example.task1.StringTransformer;

import java.sql.SQLException;

public class TransformerFactory  {
    private static StringTransformer stringTransformer;
    static public StringTransformer createTransFormer() {
        if (stringTransformer == null) {
            stringTransformer = new StringTransformer();
        }
        return stringTransformer;
    }

}
