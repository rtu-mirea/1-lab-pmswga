package Tasks.Task2;

import java.io.*;

public class ContactListFile {

    ContactList contactList;

    File file;
    private String filename;
    DataInputStream in;
    DataOutputStream out;

    public ContactListFile(ContactList contactList, String filename) throws IOException {
        file = new File(".", filename);

        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public void save() throws IOException {
        out = new DataOutputStream(new FileOutputStream(filename));


        out.close();
    }

    public void load() {

    }

}
