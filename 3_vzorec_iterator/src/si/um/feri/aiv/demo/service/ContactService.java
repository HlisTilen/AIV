package si.um.feri.aiv.demo.service;

import si.um.feri.aiv.demo.dao.ContactDAO;
import si.um.feri.aiv.demo.dao.interfaces.ContactDAOInterface;
import si.um.feri.aiv.demo.vao.Contact;
import si.um.feri.aiv.demo.vao.User;

import java.util.List;
import java.util.Optional;

public class ContactService {
    private final ContactDAOInterface contactDAO = ContactDAO.getInstance();

    public void addContact(String phoneNumber, String type, User user) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            throw new IllegalArgumentException("Telefonska številka ne sme biti prazna!");
        }
        Contact contact = new Contact(phoneNumber, type, user);
        contactDAO.insertContact(contact);

        user.addContact(contact);
    }

    public List<Contact> getContactsByUser(User user) {
        return contactDAO.getContactsByUser(user);
    }

    public Optional<Contact> getContactByPhoneNumber(String phoneNumber) {
        return contactDAO.getContactByPhoneNumber(phoneNumber);
    }

    public void updateContact(String phoneNumber, String newType) {
        contactDAO.updateContact(phoneNumber, newType);
    }

    public void deleteContact(String phoneNumber) {
        contactDAO.deleteContact(phoneNumber);
    }
}
