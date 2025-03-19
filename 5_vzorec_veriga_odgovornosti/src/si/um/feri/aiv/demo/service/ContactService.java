package si.um.feri.aiv.demo.service;

import si.um.feri.aiv.demo.chainofresponsibility.ContactHandler;
import si.um.feri.aiv.demo.chainofresponsibility.DuplicateContactCheck;
import si.um.feri.aiv.demo.chainofresponsibility.MaxContactsCheck;
import si.um.feri.aiv.demo.chainofresponsibility.PhoneNumberValidationCheck;
import si.um.feri.aiv.demo.dao.ContactDAO;
import si.um.feri.aiv.demo.dao.interfaces.ContactDAOInterface;
import si.um.feri.aiv.demo.vao.Contact;
import si.um.feri.aiv.demo.vao.User;

import java.util.List;
import java.util.Optional;

public class ContactService {
    private final ContactDAOInterface contactDAO = ContactDAO.getInstance();

    public void addContact(String phoneNumber, String type, User user) {
        Contact contact = new Contact(phoneNumber, type, user);

        // Set up chain of responsibility in correct order
        ContactHandler phoneCheck = new PhoneNumberValidationCheck();
        ContactHandler duplicateCheck = new DuplicateContactCheck();
        ContactHandler maxContactsCheck = new MaxContactsCheck();

        phoneCheck.setNextHandler(duplicateCheck);
        duplicateCheck.setNextHandler(maxContactsCheck);

        // Start validation chain
        phoneCheck.handleRequest(user, contact);

        // If all checks pass, the last handler should have already added the contact
        if (!user.getContacts().contains(contact)) {
            return; // Stops execution if validation fails
        }

        contactDAO.insertContact(contact);
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
