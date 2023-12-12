package commands.impl;

import commands.Command;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C implements Command {
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
}
