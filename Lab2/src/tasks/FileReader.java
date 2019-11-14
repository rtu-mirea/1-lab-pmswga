package tasks;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class FileReader {

    static public String getText(String filename) {
        File file = new File(".", filename);
        String text = "";

        try {
            if (file.exists()) {
                if (file.canRead()) {
                    List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);

                    for (String line : lines) {
                        text = text.concat(line);
                    }
                }
            } else {
                System.out.println("File doesn't exists");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return text;
    }

}
