package org.example.handler;

import org.example.parser.CsvParser;
import org.example.parser.JsonParser;
import org.example.parser.Parser;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class FileHandlerV1 implements FileHandler {

    private String[] args;

    public void setArgs(String[] args) {
        this.args = args;
    }

    public FileHandlerV1() {
    }

    public void convert() {
        List<String> paths = new ArrayList<>(Arrays.asList(args));

        for (String path : paths) {
            try {
                determineAndParse(path, getBuffered(path));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public BufferedReader getBuffered(String path) throws IOException {
        Path file = Paths.get(path);
        return Files.newBufferedReader(file, StandardCharsets.UTF_8);
    }

    public void determineAndParse(String path, BufferedReader bufferedReader) throws Exception {
        Parser parser;

        if (path.endsWith(".csv")) {
            parser = new CsvParser(path);
            parser.parse(bufferedReader);
        } else if (path.endsWith(".json")) {
            parser = new JsonParser(path);
            parser.parse(bufferedReader);
        } else throw new Exception("Not supported format");
    }

}
