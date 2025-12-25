package org.example.task1;

import java.io.BufferedReader;
import java.io.IOException;

public interface Command<T> {
    String execute(T object);
    T handleInputs(BufferedReader in) throws IOException;
}
