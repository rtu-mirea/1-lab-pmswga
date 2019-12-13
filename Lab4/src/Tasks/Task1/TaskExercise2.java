package Tasks.Task1;
import java.io.File;
import java.io.IOException;

public class TaskExercise2 {

    private File file;

    public TaskExercise2() {

    }

    public void checkFile(String filename) {
        file = new File(".", filename);

        if (file.isFile()) {
            System.out.println("Filename: " + file.getName());
            System.out.println("Parent dir: " + file.getParentFile());
            System.out.println("Absolute path: " + file.getAbsolutePath());
            System.out.println("Size: " + file.length() + " bytes");
        } else {
            System.out.println("Is not file");
        }
    }

    public void checkFolder(String dir) {
        file = new File("out", dir);

        if (file.isDirectory()) {
            System.out.println("Folder name: " + file.getName());
        } else {
            System.out.println("Is not directory");
        }
    }

    public boolean checkMyFile1() {
        file = new File(".", "MyFile1.txt");

        return file.exists();
    }



}
