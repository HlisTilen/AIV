package si.um.feri.aiv.demo;

import si.um.feri.aiv.demo.service.UserService;
import si.um.feri.aiv.demo.dao.ContactDAO;
import si.um.feri.aiv.demo.vao.User;
import si.um.feri.aiv.demo.vao.Contact;

public class Main {
    public static void main(String[] args) {
        // Uporabljamo Service Layer za User, DAO za Contact
        UserService userService = new UserService();
        ContactDAO contactDAO = new ContactDAO();

        // Dodajanje uporabnikov prek UserService
        userService.createUser("Tilen", "tilen@example.com");
        userService.createUser("Ana", "ana@example.com");

        // Pridobitev uporabnikov za nadaljnjo uporabo
        User user1 = userService.getUserByEmail("tilen@example.com").orElse(null);
        User user2 = userService.getUserByEmail("ana@example.com").orElse(null);

        if (user1 != null && user2 != null) {
            // Dodajanje kontaktov uporabnikom prek neposrednega DAO klica
            Contact contact1 = new Contact("+386 41 123 456", "mobile", user1);
            Contact contact2 = new Contact("+386 2 654 321", "home", user1);
            Contact contact3 = new Contact("+386 3 789 101", "work", user2);

            contactDAO.insertContact(contact1);
            contactDAO.insertContact(contact2);
            contactDAO.insertContact(contact3);

            user1.addContact(contact1);
            user1.addContact(contact2);
            user2.addContact(contact3);
        }

        // Prikaz vseh uporabnikov prek UserService
        System.out.println("\nVsi uporabniki:");
        userService.getAllUsers().forEach(System.out::println);

        // Posodobitev uporabnika 1 prek UserService
        userService.updateUser("tilen@example.com", "Tilen Novak");
        System.out.println("\nVsi uporabniki po posodobitvi:");
        userService.getAllUsers().forEach(System.out::println);

        // Prikaz kontaktov uporabnika 1 prek neposrednega DAO klica
        System.out.println("\nKontakti uporabnika 1:");
        if (user1 != null) {
            contactDAO.getContactsByUser(user1).forEach(System.out::println);
        }

        // Brisanje uporabnika 1
        System.out.println("\nBrisanje uporabnika 1...");
        userService.deleteUser("tilen@example.com");

        // Prikaz vseh uporabnikov po brisanju
        System.out.println("\nVsi uporabniki po brisanju:");
        userService.getAllUsers().forEach(System.out::println);
    }
}
