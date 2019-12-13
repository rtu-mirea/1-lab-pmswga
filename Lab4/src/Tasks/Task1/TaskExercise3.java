package Tasks.Task1;
import java.io.File;
import java.util.Objects;

public class TaskExercise3 {

    private File file;

    public TaskExercise3() {

    }

    public boolean createNewFolder(String folder) {
        file = new File(".", folder);
        return file.mkdir();
    }

    public void viewFiles() {
        file = new File(".");

        System.out.println("File list:");
        for (String file : Objects.requireNonNull(file.list())) {
            System.out.println(file);
        }
    }

    public void viewFolders() {
        file = new File(".");
        int countFolder = 0;

        System.out.println("File list: ");
        for (File file : Objects.requireNonNull(file.listFiles())) {
            if (file.isDirectory()) {
                countFolder++;
            }

            System.out.println(file.getName());
        }

        System.out.println("Count of folders: " + countFolder);
    }

    public void removeAllCreatedObjects() {
        String []filenames = {"MyFile1.txt", "C:\\MyFile2.txt", "out/MyFile3.txt", "NewFolder", "out/MyFolder"};

        for (String filename : filenames) {
            file = new File(".", filename);
            if (!file.delete()) {
                System.out.println("File was not removed");
            }
        }

    }

}
