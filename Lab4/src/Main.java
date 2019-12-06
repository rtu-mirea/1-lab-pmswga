import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import Tasks.Task1.*;
import Tasks.Task2.ContactList;
import Tasks.Task2.ContactListFile;
import Tasks.Task2.ContactListView;
import Tasks.Task2.ContactRecord;


class Main {

    static private Exercise1 exercise1;
    static private Exercise2 exercise2;
    static private Exercise3 exercise3;
    static private ContactList contactList;

    static private void showMenu() {
        System.out.println("1. Task 1/Exercise 1");
        System.out.println("2. Task 1/Exercise 2");
        System.out.println("3. Task 1/Exercise 3");
        System.out.println("4. Task 2");
        System.out.println("5. Task 3");
        System.out.println("6. Exit");
    }

    static private void showTask2Menu() {
        System.out.println("1. View contacts");
        System.out.println("2. View matches by second name");
        System.out.println("3. Get call number by second name and first name");
        System.out.println("4. Check two contacts on living in one place");
        System.out.println("5. Edit secondName");
        System.out.println("6. Save");
        System.out.println("7. Load");
        System.out.println("8. Exit");
    }

    static private void createContacts() {
        contactList.add(new ContactRecord("Басыров", "Сергей", "+79687997121", "07.07.1998", "Нагатинская стрит"));
        contactList.add(new ContactRecord("Сидоров", "Вадим", "+79167889516", "01.12.2000", "Таганская стрит 15"));
        contactList.add(new ContactRecord("Пантелеев", "Антон", "+79167643716", "18.06.1998", "Домодедово стрит 20"));
        contactList.add(new ContactRecord("Сидоров", "Иван", "+79646223950", "01.12.2000", "Нагатинская стрит"));
        contactList.add(new ContactRecord("Алиев", "Артём", "+79086140755", "09.05.1995", "Бокс стрит 9 и 3/4"));
    }

    static public void main(String []args) throws IOException {
        exercise1 = new Exercise1();
        exercise2 = new Exercise2();
        exercise3 = new Exercise3();

        contactList = new ContactList();
        Main.createContacts();
        ContactListView contactListView = new ContactListView(contactList);
        ContactListFile contactListFile = new ContactListFile(contactList, "database.data");



        Scanner input = new Scanner(System.in);

        Main.showMenu();

        while (input.hasNextInt()) {
            Main.showMenu();

            switch (input.nextInt()) {
                case 1: {
                    System.out.println();
                    System.out.println("MyFile 1 created? " + exercise1.createMyFile1());
                    System.out.println();
                    System.out.println("MyFile 2 created? " + exercise1.createMyFile2());
                    System.out.println();
                    System.out.println("MyFile 3 created? " + exercise1.createMyFile3());
                    System.out.println();
                    System.out.println("MyFolder created? " + exercise1.createFolder());
                } break;
                case 2: {
                    System.out.println();
                    exercise2.checkFile("out/MyFile3.txt");
                    System.out.println();
                    exercise2.checkFolder("MyFolder");
                    System.out.println();
                    System.out.println("MyFile 1 exists? " + exercise2.checkMyFile1());
                } break;
                case 3: {
                    System.out.println();
                    exercise3.createNewFolder("NewFolder");
                    System.out.println();
                    exercise3.viewFiles();
                    System.out.println();
                    exercise3.viewFolders();
                    System.out.println();
                    exercise3.removeAllCreatedObjects();
                    System.out.println("All created files and folders was removed");
                } break;
                case 4: {
                    Scanner prompt = new Scanner(System.in);
                    Scanner prompter = new Scanner(System.in);
                    boolean isExit = false;

                    Main.showTask2Menu();
                    while (prompt.hasNextInt() && !isExit) {
                        Main.showTask2Menu();
                        switch (prompt.nextInt()) {
                            case 1: {
                                contactListView.viewContacts();
                            } break;
                            case 2: {
                                String secondName;

                                System.out.print("Enter second name: ");
                                secondName = prompter.nextLine();

                                contactListView.viewMatchesContactsBySecondName(secondName);
                            } break;
                            case 3: {
                                String secondName, firstName, result;

                                System.out.print("Enter second name:");
                                secondName = prompter.nextLine();

                                System.out.print("Enter first name:");
                                firstName = prompter.nextLine();

                                result = contactList.getCallNumber(secondName, firstName);

                                if (!result.isEmpty()) {
                                    System.out.println("Founded call number: " + result);
                                } else {
                                    System.out.println("Call number not found");
                                }
                            } break;
                            case 4: {
                                int firstIdContact = 0, secondIdContact = 0;

                                contactListView.viewContacts();

                                System.out.println("Select first contact (by id):");
                                firstIdContact = prompter.nextInt();

                                System.out.println("Select second contact (by id):");
                                secondIdContact = prompter.nextInt();

                                if (contactList.matchContactsByAddress(firstIdContact-1, secondIdContact-1)) {
                                    System.out.println("Выбранные контакты проживают по одному адресу");
                                } else {
                                    System.out.println("Выбранные контакты не проживают по одному адресу");
                                }
                            } break;
                            case 5: {
                                String newSecondName;
                                int id = 0;

                                contactListView.viewContacts();

                                System.out.print("Enter id: ");
                                id = Integer.parseInt(prompter.nextLine());

                                System.out.print("Enter new second name: ");
                                newSecondName = prompter.nextLine();

                                if (id > 0 && id < contactList.getCount()) {
                                    contactList.getRecords().get(id-1).setSecondName(newSecondName);
                                    System.out.println("Second name change successfully");
                                } else {
                                    System.out.println("Error change");
                                }

                            } break;
                            case 6: {
                                contactListFile.save();


                            } break;
                            case 7: {

                            } break;
                            case 8: {
                                isExit = true;
                            } break;
                        }
                    }
                } break;
                case 5: {

                } break;
                case 7: {
                    input.close();
                    System.exit(0);
                } break;
            }
        }
    }

}
