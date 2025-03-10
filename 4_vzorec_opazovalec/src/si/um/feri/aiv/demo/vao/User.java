package si.um.feri.aiv.demo.vao;

import si.um.feri.aiv.demo.observers.ContactObserver;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String email;
    private List<Contact> contacts;
    private List<ContactObserver> observers = new ArrayList<>();

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
        notifyObservers(contact, "added");
    }

    public void removeContact(Contact contact) {
        contacts.remove(contact);
        notifyObservers(contact, "removed");
    }

    public void addObserver(ContactObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ContactObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Contact contact, String action) {
        for (ContactObserver observer : observers) {
            observer.update(this, contact, action);
        }
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', email='" + email + "', contacts=" + contacts + "}";
    }
}
