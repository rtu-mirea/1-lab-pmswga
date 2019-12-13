package Tasks.Task2;

import java.io.*;

public class ContactListFile {

    private ContactList contactList;

    private File file;
    private String filename;
    private DataInputStream in;
    private DataOutputStream out;

    public ContactListFile(ContactList contactList, String filename) throws IOException {
        file = new File(".", filename);
        if (!file.exists()) {
            if (!file.createNewFile()) {
                throw new IOException("File cannot crated");
            }
        }

        this.filename = filename;
        this.contactList = contactList;
    }

    public void save() throws IOException {
        out = new DataOutputStream(new FileOutputStream(filename));

        for (ContactRecord record : contactList.getRecords()) {
            out.writeUTF(record.getSecondName());
            out.writeUTF(record.getFirstName());
            out.writeUTF(record.getCallNumber());
            out.writeUTF(record.getDateBirthday());
            out.writeUTF(record.getAddress());
        }

        out.close();
    }

    public void load() throws IOException {
        in = new DataInputStream(new FileInputStream(filename));

        while (in.available() > 0) {
            String secondName = in.readUTF();
            String firstName = in.readUTF();
            String callNumber = in.readUTF();
            String dateBirthday = in.readUTF();
            String address = in.readUTF();

            contactList.add(new ContactRecord(secondName, firstName, callNumber, dateBirthday, address));
        }

        in.close();
    }
}
