package org.example.task1.factory;

import org.example.task1.StringFunifier;
import org.example.task1.Helpers.StringTransformer;

public class FunfierFactory implements Factory<StringFunifier> {
    private static StringFunifier stringFunifier;
    public  StringFunifier createInstance(){
        if (stringFunifier==null){
            StringTransformer stringTransformer = TransformerFactory.createTransFormer();
            stringFunifier=new StringFunifier(stringTransformer);
        }
         return stringFunifier;
    }
}
