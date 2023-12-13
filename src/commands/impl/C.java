package commands.impl;

import commands.FilePathCommand;
import commands.StandardInputCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C implements FilePathCommand, StandardInputCommand {
    @Override
    public Long execute(String fileName) {
        try {
            Path path = Paths.get(fileName);
            return Files.size(path);
        } catch (IOException e) {
            System.out.println("ERROR!! Got an exception!! "+e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Long execute() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            return (long) content.toString().getBytes().length;
        } catch (IOException e) {
            System.out.println("ERROR!! Got an exception!! "+e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}
