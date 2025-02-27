package si.um.feri.aiv.demo1;

import si.um.feri.aiv.demo1.dao.ContactDAO;
import si.um.feri.aiv.demo1.dao.UserDAO;
import si.um.feri.aiv.demo1.vao.Contact;
import si.um.feri.aiv.demo1.vao.User;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        ContactDAO contactDAO = new ContactDAO();

        // Dodajanje uporabnikov
        User user1 = new User("Tilen", "tilen@example.com");
        User user2 = new User("Ana", "ana@example.com");
        userDAO.insertUser(user1);
        userDAO.insertUser(user2);

        // Dodajanje kontaktov uporabnikom
        Contact contact1 = new Contact("+386 41 123 456", "mobile", user1);
        Contact contact2 = new Contact("+386 2 654 321", "home", user1);
        Contact contact3 = new Contact("+386 3 789 101", "work", user2);
        contactDAO.insertContact(contact1);
        contactDAO.insertContact(contact2);
        contactDAO.insertContact(contact3);

        user1.addContact(contact1);
        user1.addContact(contact2);
        user2.addContact(contact3);

        // Prikaz vseh uporabnikov
        System.out.println("\nVsi uporabniki:");
        userDAO.getAllUsers().forEach(System.out::println);

        // Posodabljanje uporabnika 1
        userDAO.updateUser("tilen@example.com", "Tilen Novak");
        System.out.println("\nVsi uporabniki po posodobitvi:");
        userDAO.getAllUsers().forEach(System.out::println);

        // Prikaz kontaktov uporabnika 1
        System.out.println("\nKontakti uporabnika 1:");
        contactDAO.getContactsByUser(user1).forEach(System.out::println);

        // Brisanje uporabnika 1 in njegovih kontaktov
        System.out.println("\nBrisanje uporabnika 1...");
        userDAO.deleteUser("tilen@example.com");

        System.out.println("\nVsi uporabniki po brisanju:");
        userDAO.getAllUsers().forEach(System.out::println);
    }
}