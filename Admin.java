public class Admin {
    private String username;
    private int password;

    public Admin(String username, int password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String uname, int pwd) {
        return username.equals(uname) && password == pwd;
    }
}
