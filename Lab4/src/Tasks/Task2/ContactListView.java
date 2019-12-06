package Tasks.Task2;

import java.util.ArrayList;

public class ContactListView {

    private ContactList contactList;

    public ContactListView(ContactList contactList) {
        this.contactList = contactList;
    }

    public void viewMatchesContactsBySecondName(String secondName) {
        ArrayList<ContactRecord> matchList = contactList.matchContactsBySecondName(secondName);

        System.out.println();
        System.out.println("[Match contacts list]");
        if (matchList.size() > 0) {
            int i = 1;
            for (ContactRecord record : matchList) {
                System.out.print(i + ": ");
                System.out.println(record);

                i++;
            }
        } else {
            System.out.println("Match contact list is empty");
        }
    }

    public void viewContacts() {
        System.out.println();
        System.out.println("[Contact list]");
        if (contactList.getCount() > 0) {
            int i = 1;
            for (ContactRecord record : contactList.getRecords()) {
                System.out.print(i + ": ");
                System.out.println(record);

                i++;
            }
        } else {
            System.out.println("Contact list is empty");
        }
    }

}
