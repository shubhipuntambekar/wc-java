import commands.impl.C;
import commands.impl.L;
import commands.impl.M;
import commands.impl.W;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No args provided");
        } else {
            String command = null;
            String fileName = null;
            for (String arg : args) {
                if (arg.startsWith("-")) command = arg;
                else fileName = arg;
            }
            if (Objects.equals(command, "-c")) {
                // calculates number of bytes in the file
                C c = new C();
                if (fileName != null)
                    System.out.println(c.execute(fileName) + " " + fileName);
                else
                    System.out.println(c.execute());

            } else if (Objects.equals(command, "-l")) {
                // calculates number of lines in the file
                L l = new L();
                if (fileName != null)
                    System.out.println(l.execute(fileName) + " " + fileName);
                else
                    System.out.println(l.execute());

            } else if (Objects.equals(command, "-w")) {
                // calculates number of words in the file
                W w = new W();
                if (fileName != null)
                    System.out.println(w.execute(fileName) + " " + fileName);
                else
                    System.out.println(w.execute());

            } else if (Objects.equals(command, "-m")) {
                // calculates number of characters in the file
                M m = new M();
                if (fileName != null)
                    System.out.println(m.execute(fileName) + " " + fileName);
                else
                    System.out.println(m.execute());

            } else {
                // calculates -c -l -w
                C c = new C();
                L l = new L();
                W w = new W();
                if (fileName != null)
                    System.out.println(c.execute(fileName) + " " + l.execute(fileName) + " " + w.execute(fileName) + " " +fileName);
                else
                    System.out.println(c.execute() + " " + l.execute() + " " + w.execute());
            }
        }
    }
}