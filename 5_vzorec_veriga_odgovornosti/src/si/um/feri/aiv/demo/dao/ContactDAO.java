package si.um.feri.aiv.demo.dao;

import si.um.feri.aiv.demo.dao.interfaces.ContactDAOInterface;
import si.um.feri.aiv.demo.vao.Contact;
import si.um.feri.aiv.demo.vao.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ContactDAO implements ContactDAOInterface {
    private static volatile ContactDAO instance;
    private final List<Contact> contacts = Collections.synchronizedList(new ArrayList<>());

    private ContactDAO() {}  // Private constructor (Singleton)

    public static ContactDAO getInstance() {
        if (instance == null) {
            synchronized (ContactDAO.class) {
                if (instance == null) {
                    instance = new ContactDAO();
                }
            }
        }
        return instance;
    }

    @Override
    public void insertContact(Contact contact) {
        synchronized (contacts) {
            contacts.add(contact);
        }
    }

    @Override
    public List<Contact> getContactsByUser(User user) {
        synchronized (contacts) {
            return contacts.stream().filter(contact -> contact.getUser().equals(user)).toList();
        }
    }

    @Override
    public Optional<Contact> getContactByPhoneNumber(String phoneNumber) {
        synchronized (contacts) {
            return contacts.stream().filter(contact -> contact.getPhoneNumber().equals(phoneNumber)).findFirst();
        }
    }

    @Override
    public void updateContact(String phoneNumber, String newType) {
        synchronized (contacts) {
            getContactByPhoneNumber(phoneNumber).ifPresent(contact -> contact.setType(newType));
        }
    }

    @Override
    public void deleteContact(String phoneNumber) {
        synchronized (contacts) {
            contacts.removeIf(contact -> contact.getPhoneNumber().equals(phoneNumber));
        }
    }
}
