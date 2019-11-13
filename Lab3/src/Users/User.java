package Users;

public class User {
    private String name;
    private String login;
    private String password;
    private UserType type;

    public User(String name, String login, String password, UserType type) {
        this.name     = name;
        this.login    = login;
        this.password = password;
        this.type     = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return this.login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public UserType getType() {
        return this.type;
    }

    public boolean isAdmin() {
        return this.type == UserType.USER_ADMIN;
    }

    public boolean isClient() {
        return this.type == UserType.USER_CLIENT;
    }

}
