package Tasks.Task1;

import java.io.File;
import java.io.IOException;

public class Exercise1 {

    private File file;

    public Exercise1() {

    }

    public boolean createMyFile1() {
        try {
            file = new File(".", "MyFile1.txt");
            return file.createNewFile();
        } catch (IOException e) {
            return false;
        }
    }

    public boolean createMyFile2() {
        try {
            file = new File("C:\\", "MyFile2.txt");
            return file.createNewFile();
        } catch (IOException e) {
            return false;
        }
    }

    public boolean createMyFile3() {
        try {
            file = new File("out", "MyFile3.txt");
            return file.createNewFile();
        } catch (IOException e) {
            return false;
        }
    }

    public boolean createFolder() {
        file = new File("out", "MyFolder");
        return file.mkdir();
    }


}
