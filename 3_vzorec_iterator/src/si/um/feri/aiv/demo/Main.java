package si.um.feri.aiv.demo;

import si.um.feri.aiv.demo.service.UserService;
import si.um.feri.aiv.demo.service.ContactService;
import si.um.feri.aiv.demo.iterators.*;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        ContactService contactService = new ContactService();

        userService.createUser("Tilen", "tilen@example.com");
        userService.createUser("Ana", "ana@example.com");

        // Dodajanje kontaktov uporabnikom
        userService.getUserByEmail("tilen@example.com").ifPresent(user -> {
            contactService.addContact("+386 41 123 456", "mobile", user);
            contactService.addContact("+386 2 654 321", "home", user);
        });

        userService.getUserByEmail("ana@example.com").ifPresent(user -> {
            contactService.addContact("+386 3 789 101", "work", user);
            contactService.addContact("+386 41 654 987", "mobile", user);
        });

        // Iteracija skozi vse kontakte uporabnika 1
        System.out.println("\nVsi kontakti uporabnika 1:");
        userService.getUserByEmail("tilen@example.com").ifPresent(user -> {
            ContactIterator contactIterator = new ContactIterator(user.getContacts());
            while (contactIterator.hasNext()) {
                System.out.println(contactIterator.next());
            }
        });

        // Iteracija skozi vse mobilne kontakte uporabnika 1
        System.out.println("\nMobilni kontakti uporabnika 1:");
        userService.getUserByEmail("tilen@example.com").ifPresent(user -> {
            ContactByTypeIterator mobileContacts = new ContactByTypeIterator(user.getContacts(), "home");
            while (mobileContacts.hasNext()) {
                System.out.println(mobileContacts.next());
            }
        });

        // Iteracija skozi vse kontakte vseh uporabnikov
        System.out.println("\nVsi kontakti vseh uporabnikov:");
        AllContactsIterator allContacts = new AllContactsIterator(userService.getAllUsers());
        while (allContacts.hasNext()) {
            System.out.println(allContacts.next());
        }

    }
}
