
import Totalizator.HorseBase;
import Totalizator.Parlay;
import Totalizator.ParlaysBase;
import Users.*;
import Interface.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

class Main {

    static private UsersBase usersBase = new UsersBase();
    static private User currentUser = null;

    static private ParlaysBase parlaysBase = new ParlaysBase();
    static private HorseBase horseBase = new HorseBase();

    static private void fillUserList() {
        usersBase.addUser(new User("admin", "admin", "admin", UserType.USER_ADMIN));
        usersBase.addUser(new User("Sergey", "pmswga", "pass", UserType.USER_CLIENT));
        usersBase.addUser(new User("Ivan", "walkman", "pass1", UserType.USER_CLIENT));
        usersBase.addUser(new User("Aleen", "john wick", "pass2", UserType.USER_CLIENT));
        usersBase.addUser(new User("Yuri", "cool boy", "pass3", UserType.USER_CLIENT));
        usersBase.addUser(new User("Aleksandr", "man", "pass4", UserType.USER_CLIENT));
    }

    static private void userListInterface() {
        UserListInterface userListInterface = new UserListInterface(Main.usersBase);
        userListInterface.view();
    }

    static private void parlayListInterface() {
        ParlayListInterface parlayListInterface = null;

        if (currentUser.isClient()) {
            parlayListInterface = new ParlayListInterface(Main.parlaysBase.getParlaysByUser(currentUser.getLogin()));
            parlayListInterface.view();
        } else if (currentUser.isAdmin()) {
            for (User user : usersBase.getUsers()) {

                ArrayList<Parlay> parlays = Main.parlaysBase.getParlaysByUser(user.getLogin());

                if (!parlays.isEmpty()) {
                    System.out.println("Parlays of user: " + user.getLogin());
                    parlayListInterface = new ParlayListInterface(parlays);
                    parlayListInterface.view();
                } else {
                    System.out.println("Parlays list is empty for user: " + user.getLogin());
                }

            }
        }
    }

    static private void horsesListInterface() {
        HorseListInterface horseListInterface = new HorseListInterface(horseBase.getHorses());
        horseListInterface.view();
    }

    static private void enterInterface() {
        LoginInterface loginInterface = new LoginInterface();
        loginInterface.view();

        if (usersBase.enter(loginInterface.getLogin(), loginInterface.getPassword())) {
            currentUser = usersBase.getUser(loginInterface.getLogin());
            System.out.println("You are entered! Welcome, " + currentUser.getName());
        } else {
            // TODO: Реализовать интерфейс вывода ошибок
            System.out.println("You are not entered!");
        }
    }

    static private void registerInterface() {
        RegisterInterface registerInterface = new RegisterInterface();
        registerInterface.view();

        usersBase.addUser(registerInterface.getRegisteredUser());

        System.out.println("User registered successfully!");
    }

    static private void addParlayInterface() {
        AddParlayInterface addParlayInterface = new AddParlayInterface();
        addParlayInterface.view();

        parlaysBase.addParlay(currentUser.getLogin(), addParlayInterface.getAddedParlay());

        System.out.println("Parlay added successfully!");
    }

    static private void addHorseInterface() {
        AddHorseInterface addHorseInterface = new AddHorseInterface();
        addHorseInterface.view();

        horseBase.addHorse(addHorseInterface.getAddedHorse());

        System.out.println("Horse added successfully!");
    }

    static public void main(String args[]) {
        Main.fillUserList();

        Scanner input = new Scanner(System.in);

        int command = 0;
        while (true) {
            if (Main.currentUser == null) {
                System.out.println("1. Login");
                System.out.println("2. Register");
                System.out.println("3. Exit");
            } else if (Main.currentUser.isClient()) {
                System.out.println("[User: " + currentUser.getName() + "]");
                System.out.println("1. About race");
                System.out.println("2. Add parlay");
                System.out.println("3. List of parlays");
                System.out.println("4. List of horses");
                System.out.println("5. Logout");
            } else if (Main.currentUser.isAdmin()) {
                System.out.println("[User: " + currentUser.getName() + "]");
                System.out.println("1. Start race");
                System.out.println("2. Add horse");
                System.out.println("3. List of parlays");
                System.out.println("4. List of horses");
                System.out.println("5. List of users");
                System.out.println("6. Logout");
            }

            if (input.hasNextInt()) {
                command = input.nextInt();
            }

            if (Main.currentUser == null) {
                switch (command)
                {
                    case 1: {
                        Main.enterInterface();
                    } break;
                    case 2: {
                        Main.registerInterface();
                    } break;
                    case 3: {
                        System.out.println("Goodbye!");
                        input.close();
                        System.exit(0);
                    } break;
                    default: {
                        System.out.println("Incorrect input");
                    } break;
                }
            } else if (currentUser.isClient()) {
                switch (command)
                {
                    case 1: {
                        //TODO: about race
                    } break;
                    case 2: {
                        Main.addParlayInterface();
                    } break;
                    case 3: {
                        Main.parlayListInterface();
                    } break;
                    case 4: {
                        Main.horsesListInterface();
                    } break;
                    case 5: {
                        System.out.println("Goodbye, " + currentUser.getName() + "!");
                        currentUser = null;
                    } break;
                    default: {
                        System.out.println("Incorrect input");
                    } break;
                }
            } else if (currentUser.isAdmin()) {
                switch (command)
                {
                    case 1: {

                    } break;
                    case 2: {
                        Main.addHorseInterface();
                    } break;
                    case 3: {
                        Main.parlayListInterface();
                    } break;
                    case 4: {
                        Main.horsesListInterface();
                    } break;
                    case 5: {
                        Main.userListInterface();
                    } break;
                    case 6: {
                        System.out.println("Goodbye, " + currentUser.getName() + "!");
                        currentUser = null;
                    } break;
                    default: {
                        System.out.println("Incorrect input");
                    } break;
                }
            }

        }
    }

}
