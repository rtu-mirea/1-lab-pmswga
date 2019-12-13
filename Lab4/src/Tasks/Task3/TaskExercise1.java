package Tasks.Task3;

import java.io.*;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Scanner;

public class TaskExercise1 {

    File first;
    File second;

    public TaskExercise1 () throws IOException {
        first = new File(".", "T1.txt");
        second = new File(".", "T2.txt");

        if (!first.exists()) {

            if (!first.createNewFile()) {
                throw new IOException("File 1 does not created");
            }

            FileWriter writer = new FileWriter(first.getName());

            for (int i = 0; i < 255; i++) {
                writer.append((char)i);
            }

            writer.close();

        }

        if (!second.exists()) {
            if (!second.createNewFile()) {
                throw new IOException("File 2 does not created");
            }
        }


    }

    public void run() throws IOException {
        FileReader reader = new FileReader(first.getName());
        FileWriter writer = new FileWriter(second.getName());

        char []chars = new char[255];
        reader.read(chars, 0, 255);

        for (char aChar : chars) {
            writer.append(aChar);
        }

        reader.close();
        writer.close();
    }

}
