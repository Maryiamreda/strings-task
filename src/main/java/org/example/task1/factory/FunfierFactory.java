package org.example.task1.factory;

import org.example.task1.StringFunifier;
import org.example.task1.StringTransformer;

public class FunfierFactory {
    private static StringFunifier stringFunifier;
    public static StringFunifier createFunifier(){
        if (stringFunifier==null){
            StringTransformer stringTransformer = TransformerFactory.createTransFormer();
            stringFunifier=new StringFunifier(stringTransformer);
        }
         return stringFunifier;
    }
}
