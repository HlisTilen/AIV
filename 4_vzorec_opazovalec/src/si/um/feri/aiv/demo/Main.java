package si.um.feri.aiv.demo;

import si.um.feri.aiv.demo.observers.ContactAddedNotifier;
import si.um.feri.aiv.demo.observers.ContactRemovedNotifier;
import si.um.feri.aiv.demo.service.UserService;
import si.um.feri.aiv.demo.service.ContactService;
import si.um.feri.aiv.demo.iterators.*;
import si.um.feri.aiv.demo.vao.Contact;
import si.um.feri.aiv.demo.vao.User;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Tilen", "tilen@example.com");
        User user2 = new User("Ana", "ana@example.com");

        user1.addObserver(new ContactAddedNotifier());
        user2.addObserver(new ContactAddedNotifier());
        user1.addObserver(new ContactRemovedNotifier());
        user2.addObserver(new ContactRemovedNotifier());

        Contact contact1 = new Contact("+386 31 123 456", "mobile", user1);
        Contact contact2 = new Contact("+386 41 654 321", "home", user1);
        Contact contact3 = new Contact("+386 51 987 654", "work", user2);

        user1.addContact(contact1);
        user1.addContact(contact2);
        user2.addContact(contact3);

        user1.removeContact(contact1);
    }
}
