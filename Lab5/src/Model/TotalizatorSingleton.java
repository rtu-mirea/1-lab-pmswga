package Model;

import Model.Totalizator.Horse;
import Model.Totalizator.Totalizator;
import Model.Users.User;
import Model.Users.UserType;

public class TotalizatorSingleton {

    static private Totalizator totalizator = null;
    static private User currentUser = null;

    static private void fillHorseList() {
        totalizator.getHorseBase().addHorse(new Horse("Bolly"));
        totalizator.getHorseBase().addHorse(new Horse("Molly"));
        totalizator.getHorseBase().addHorse(new Horse("Dolly"));
        totalizator.getHorseBase().addHorse(new Horse("Folly"));
        totalizator.getHorseBase().addHorse(new Horse("Rolly"));
    }

    static private void fillUserList() {
        totalizator.getUsersBase().addUser(new User("admin", "admin", "admin", UserType.USER_ADMIN));
        totalizator.getUsersBase().addUser(new User("Sergey", "pmswga", "pass", UserType.USER_CLIENT));
        totalizator.getUsersBase().addUser(new User("Ivan", "walkman", "pass1", UserType.USER_CLIENT));
        totalizator.getUsersBase().addUser(new User("Aleen", "john wick", "pass2", UserType.USER_CLIENT));
        totalizator.getUsersBase().addUser(new User("Yuri", "cool boy", "pass3", UserType.USER_CLIENT));
        totalizator.getUsersBase().addUser(new User("Aleksandr", "man", "pass4", UserType.USER_CLIENT));
    }

    static public void setCurrentUser(User user) {
        TotalizatorSingleton.currentUser = user;
    }

    static public User getCurrentUser() {
        return TotalizatorSingleton.currentUser;
    }

    static public Totalizator get() {
        if (TotalizatorSingleton.totalizator == null) {
            totalizator = new Totalizator();
            totalizator.setCoefficient(3);
            fillUserList();
            fillHorseList();
        }

        return TotalizatorSingleton.totalizator;
     }

}
