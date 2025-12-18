package org.example.task1.factory;

import org.example.task1.StringTransformer;

public class TransformerFactory {
    private static StringTransformer stringTransformer;
    private TransformerFactory() {}
    static public StringTransformer createTransFormer() {
        if (stringTransformer == null) {
            stringTransformer = new StringTransformer();
        }
        return stringTransformer;
    }


}
