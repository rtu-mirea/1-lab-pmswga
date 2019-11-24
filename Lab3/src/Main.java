
import Controller.*;
import Model.Totalizator.Parlay;
import Model.Totalizator.Totalizator;
import Model.Users.User;
import Model.Users.UserType;
import View.*;

import java.util.ArrayList;
import java.util.Scanner;

class Main {

    static private Totalizator totalizator = new Totalizator();
    static private User currentUser = null;

    static private void fillUserList() {
        totalizator.getUsersBase().addUser(new User("admin", "admin", "admin", UserType.USER_ADMIN));
        totalizator.getUsersBase().addUser(new User("Sergey", "pmswga", "pass", UserType.USER_CLIENT));
        totalizator.getUsersBase().addUser(new User("Ivan", "walkman", "pass1", UserType.USER_CLIENT));
        totalizator.getUsersBase().addUser(new User("Aleen", "john wick", "pass2", UserType.USER_CLIENT));
        totalizator.getUsersBase().addUser(new User("Yuri", "cool boy", "pass3", UserType.USER_CLIENT));
        totalizator.getUsersBase().addUser(new User("Aleksandr", "man", "pass4", UserType.USER_CLIENT));
    }

    static private void userListInterface() {
        UserListView userListView = new UserListView(Main.totalizator.getUsersBase());
        userListView.view();
    }

    static private void parlayListInterface() {
        ParlayListView parlayListView = null;

        if (currentUser.isClient()) {
            parlayListView = new ParlayListView(totalizator.getParlaysBase().getParlaysByUser(currentUser.getLogin()));
            parlayListView.view();
        } else if (currentUser.isAdmin()) {
            for (User user : totalizator.getUsersBase().getUsers()) {

                ArrayList<Parlay> parlays = totalizator.getParlaysBase().getParlaysByUser(user.getLogin());

                if (!parlays.isEmpty()) {
                    System.out.println("Parlays of user: " + user.getLogin());
                    parlayListView = new ParlayListView(parlays);
                    parlayListView.view();
                } else {
                    System.out.println("Parlays list is empty for user: " + user.getLogin());
                }

            }
        }
    }

    static private void horsesListInterface() {
        HorseListView horseListView = new HorseListView(totalizator.getHorseBase().getHorses());
        horseListView.view();
    }

    static private void enterInterface() {
        LoginController loginController = new LoginController();
        loginController.view();

        if (totalizator.getUsersBase().enter(loginController.getLogin(), loginController.getPassword())) {
            currentUser = totalizator.getUsersBase().getUser(loginController.getLogin());
            System.out.println("You are entered! Welcome, " + currentUser.getName());
        } else {
            System.out.println("You are not entered!");
        }
    }

    static private void registerInterface() {
        RegisterController registerController = new RegisterController();
        registerController.view();

        totalizator.getUsersBase().addUser(registerController.getRegisteredUser());

        System.out.println("User registered successfully!");
    }

    static private void aboutRaceInterface() {
        AboutRaceView aboutRaceView = new AboutRaceView(totalizator);
        aboutRaceView.view();
    }

    static private void addParlayInterface() {
        if (!totalizator.getHorseBase().getHorses().isEmpty()) {
            AddParlayController addParlayController = new AddParlayController(totalizator.getHorseBase().getHorses());
            addParlayController.view();

            totalizator.getParlaysBase().addParlay(currentUser.getLogin(), addParlayController.getAddedParlay());

            System.out.println("Parlay added successfully!");
        } else {
            System.out.println("Sorry, better luck next time");
        }
    }

    static private void setCoefficientInterface() {
        SetCoefficientController setCoefficientController = new SetCoefficientController();
        setCoefficientController.view();

        totalizator.setCoefficient(setCoefficientController.getCoefficient());

        System.out.println("Play coefficient set successfully!");
    }

    static private void addHorseInterface() {
        AddHorseController addHorseController = new AddHorseController();
        addHorseController.view();

        totalizator.getHorseBase().addHorse(addHorseController.getAddedHorse());

        System.out.println("Horse added successfully!");
    }

    static private void winnerListInterface() {
        System.out.println("Win horse is " + totalizator.getWinHorse().getName());

        WinnerListView winnerListView = new WinnerListView(totalizator.getWinners());
        winnerListView.view();
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
                System.out.println("2. Set coefficient");
                System.out.println("3. Add horse");
                System.out.println("4. List of parlays");
                System.out.println("5. List of horses");
                System.out.println("6. List of users");
                System.out.println("7. Logout");
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
                        Main.aboutRaceInterface();
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
                        if (totalizator.getCoefficient() != 0 && !totalizator.getHorseBase().getHorses().isEmpty()) {
                            totalizator.generateResults();
                            totalizator.calculateMoney();
                            totalizator.clearParlays();
                            Main.winnerListInterface();
                        } else {
                            System.out.println("You can't start race, because the horses list is empty and play coefficient equal 0 ");
                        }
                    } break;
                    case 2: {
                        Main.setCoefficientInterface();
                    } break;
                    case 3: {
                        Main.addHorseInterface();
                    } break;
                    case 4: {
                        Main.parlayListInterface();
                    } break;
                    case 5: {
                        Main.horsesListInterface();
                    } break;
                    case 6: {
                        Main.userListInterface();
                    } break;
                    case 7: {
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
