package Model.Users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UsersBase {

    private Map<String, User> users;

    public UsersBase() {
        this.users = new HashMap<String, User>();
    }

    public void addUser(User user) {
        this.users.put(user.getLogin(), user);
    }

    public ArrayList<User> getUsers() {
        ArrayList<User> userList = new ArrayList<User>();

        for (String userName : this.users.keySet()) {
            userList.add(this.users.get(userName));
        }

        return userList;
    }

    public User getUser(String login) {
        return this.users.get(login);
    }

    public boolean enter(String login, String password) {
        User user = this.getUser(login);

        if (user != null) {
            return user.getPassword().equals(password);
        }

        return false;
    }

    public String[][] toStringArray() {
        String [][]array = new String[this.users.size()][4];

        int i = 0;
        for (String login : this.users.keySet()) {
            array[i][0] = Integer.toString(i + 1);
            array[i][1] = this.users.get(login).getName();
            array[i][2] = this.users.get(login).getLogin();
            array[i][3] = this.users.get(login).getType().toString();
            i++;
        }

        return array;
    }

}
