package commands.impl;

import commands.Command;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class L implements Command {
    @Override
    public Long execute(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            long lines = 0;
            while (reader.readLine() != null) {
                lines += 1;
            }
            return lines;
        } catch (IOException e) {
            System.out.println("ERROR!! Got an exception!! "+e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}
