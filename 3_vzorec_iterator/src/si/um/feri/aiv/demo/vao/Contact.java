package si.um.feri.aiv.demo.vao;

public class Contact {

    private String phoneNumber;
    private String type;
    private User user; // Referenca na uporabnika

    public Contact(String phoneNumber, String type, User user) {
        this.phoneNumber = phoneNumber;
        this.type = type;
        this.user = user;
    }

    public String getPhoneNumber() { return phoneNumber; }
    public String getType() { return type; }
    public User getUser() { return user; }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Contact{phoneNumber='" + phoneNumber + "', type='" + type + "', user=" + user.getEmail() + "}";
    }
}
