package org.example.parser;

import java.io.BufferedReader;
import java.io.IOException;

public interface Parser {
    void parse(BufferedReader bufferedReader) throws InterruptedException, IOException;
}
