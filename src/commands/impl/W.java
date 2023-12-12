package commands.impl;

import commands.Command;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class W implements Command {
    @Override
    public Long execute(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            long wordCount = 0;
            String line;
            while ( (line = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                wordCount += tokenizer.countTokens();
            }
            return wordCount;
        } catch (IOException e) {
            System.out.println("ERROR!! Got an exception!! "+e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}
