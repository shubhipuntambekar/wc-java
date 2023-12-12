package commands.impl;

import commands.Command;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class M implements Command {
    @Override
    public Long execute(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            long chars = 0;
            while (reader.read() != -1) {
                chars += 1;
            }
            return chars;
        } catch (IOException e) {
            System.out.println("ERROR!! Got an exception!! "+e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}
