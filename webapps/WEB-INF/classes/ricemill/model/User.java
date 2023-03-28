package ricemill.model;

public class User {
    private String email;
    private String password;
    private String name;
    private String address;
    private String type = "user";
    private int is_enabled;

    public User(){

    }
    public User(String email, String password, String name, String address, String type) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.address = address;
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIs_enabled() {
        return is_enabled;
    }

    public void setIs_enabled(int is_enabled) {
        this.is_enabled = is_enabled;
    }
}
