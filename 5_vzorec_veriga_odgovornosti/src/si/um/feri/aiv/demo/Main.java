package si.um.feri.aiv.demo;

import si.um.feri.aiv.demo.service.ContactService;
import si.um.feri.aiv.demo.service.UserService;
import si.um.feri.aiv.demo.vao.User;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        ContactService contactService = new ContactService();

        userService.createUser("Tilen", "tilen@example.com");
        User user = userService.getUserByEmail("tilen@example.com").orElse(null);

        if (user != null) {
            System.out.println("\nScenario 1: Adding a valid contact.");
            contactService.addContact("+386 41 123 456", "mobile", user);

            System.out.println("\nScenario 2: Adding the same contact again (should fail).");
            contactService.addContact("+386 41 123 456", "mobile", user);

            System.out.println("\nScenario 3: Adding a contact with invalid phone number.");
            contactService.addContact("041123456", "mobile", user);

            System.out.println("\nScenario 4: Exceeding max contact limit.");
            contactService.addContact("+386 41 654 321", "home", user);
            contactService.addContact("+386 41 987 654", "work", user);
            contactService.addContact("+386 41 333 222", "office", user);
            contactService.addContact("+386 41 888 999", "fax", user); // Should fail
        }
    }
}
