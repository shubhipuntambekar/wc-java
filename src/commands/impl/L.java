package commands.impl;

import commands.FilePathCommand;
import commands.StandardInputCommand;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class L implements FilePathCommand, StandardInputCommand {
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

    @Override
    public Long execute() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            long lines = 0;
            while (reader.readLine() != null) {
                lines += 1;
            }
            return lines;
        } catch (IOException e) {
            System.out.println("ERROR!! Got an exception!! "+e.getMessage());
            throw new RuntimeException(e.getMessage());
        }    }
}
