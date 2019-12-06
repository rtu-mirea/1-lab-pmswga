package Tasks.Task2;

import java.util.ArrayList;

public class ContactList {

    private ArrayList<ContactRecord> records;

    public ContactList() {
        records = new ArrayList<ContactRecord>();
    }

    public ArrayList<ContactRecord> getRecords() {
        return records;
    }

    public int getCount() {
        return records.size();
    }

    public void add(ContactRecord record) {
        records.add(record);
    }

    public ArrayList<ContactRecord> matchContactsBySecondName(String secondName) {
        ArrayList<ContactRecord> matchContacts = new ArrayList<ContactRecord>();

        if (!records.isEmpty()) {
            for (ContactRecord record : records) {
                if (record.getSecondName().equals(secondName)) {
                    matchContacts.add(record);
                }
            }
        }

        return matchContacts;
    }

    public boolean matchContactsByAddress(int first, int second) {
        if (first > 0 && first < records.size() && second > 0 && second < records.size()) {
            return records.get(first).getAddress().equals(records.get(second).getAddress());
        }

        return false;
    }

    public String getCallNumber(String secondName, String firstName) {
        if (!records.isEmpty()) {
            for (ContactRecord record : records) {
                if (record.getSecondName().equals(secondName) && record.getFirstName().equals(firstName)) {
                    return record.getCallNumber();
                }
            }
        }

        return "";
    }

}
