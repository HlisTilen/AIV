package si.um.feri.aiv.demo1.vao;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String email;
    private List<Contact> contacts;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.contacts = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public List<Contact> getContacts() { return contacts; }

     public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', email='" + email + "', contacts=" + contacts + "}";
    }
}
