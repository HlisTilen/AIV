package si.um.feri.aiv.demo1;

import si.um.feri.aiv.demo1.dao.ContactDAO;
import si.um.feri.aiv.demo1.dao.UserDAO;
import si.um.feri.aiv.demo1.vao.Contact;
import si.um.feri.aiv.demo1.vao.User;

public class Main2NoSingletonExplain {
    public static void main(String[] args) {
        // First instance of DAOs
        UserDAO userDAO1 = new UserDAO();
        ContactDAO contactDAO1 = new ContactDAO();

        // Second instance of DAOs (Separate instances)
        UserDAO userDAO2 = new UserDAO();
        ContactDAO contactDAO2 = new ContactDAO();

        // Adding users using userDAO1
        User user1 = new User("Tilen", "tilen@example.com");
        User user2 = new User("Ana", "ana@example.com");
        userDAO1.insertUser(user1);
        userDAO1.insertUser(user2);

        // Adding contacts using contactDAO1
        Contact contact1 = new Contact("+386 41 123 456", "mobile", user1);
        Contact contact2 = new Contact("+386 2 654 321", "home", user1);
        Contact contact3 = new Contact("+386 3 789 101", "work", user2);
        contactDAO1.insertContact(contact1);
        contactDAO1.insertContact(contact2);
        contactDAO1.insertContact(contact3);

        user1.addContact(contact1);
        user1.addContact(contact2);
        user2.addContact(contact3);

        // Print all users using the first DAO instance
        System.out.println("\nVsi uporabniki (userDAO1):");
        userDAO1.getAllUsers().forEach(System.out::println);

        // Try to fetch users using the second DAO instance
        System.out.println("\nVsi uporabniki (userDAO2 - should be empty if Singleton is not used):");
        userDAO2.getAllUsers().forEach(System.out::println);  // This will be empty!

        // Try to fetch contacts using the second DAO instance
        System.out.println("\nKontakti uporabnika 1 (contactDAO2 - should be empty if Singleton is not used):");
        contactDAO2.getContactsByUser(user1).forEach(System.out::println);  // This will be empty!

        // Deleting user using the second DAO instance (does nothing if Singleton is not used)
        System.out.println("\nBrisanje uporabnika 1 z userDAO2...");
        userDAO2.deleteUser("tilen@example.com");

        // Print users again using the first DAO instance
        System.out.println("\nVsi uporabniki po poskusu brisanja (userDAO1 should still have data):");
        userDAO1.getAllUsers().forEach(System.out::println);  // User is still here if Singleton is not used!

        // Print users again using the second DAO instance
        System.out.println("\nVsi uporabniki po poskusu brisanja (userDAO2 - should still be empty):");
        userDAO2.getAllUsers().forEach(System.out::println);  // Still empty if Singleton is not used
    }
}

