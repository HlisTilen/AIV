package si.um.feri.aiv.demo.dao;

import si.um.feri.aiv.demo.dao.interfaces.ContactDAOInterface;
import si.um.feri.aiv.demo.vao.Contact;
import si.um.feri.aiv.demo.vao.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContactDAO implements ContactDAOInterface {
    private List<Contact> contacts = new ArrayList<>();

    @Override
    public void insertContact(Contact contact) {
        contacts.add(contact);
    }

    @Override
    public List<Contact> getContactsByUser(User user) {
        // old way
        // List<Contact> contactsByUser = new ArrayList<>();
        // for (Contact contact : contacts) {
        //     if (contact.getUser().equals(user)) {
        //         contactsByUser.add(contact);
        //     }
        // }
        // return contactsByUser;

        return contacts.stream().filter(contact -> contact.getUser().equals(user)).toList();
    }

    @Override
    public Optional<Contact> getContactByPhoneNumber(String phoneNumber) {
        // old way
        // for (Contact contact : contacts) {
        //     if (contact.getPhoneNumber().equals(phoneNumber)) {
        //         return Optional.of(contact);
        //     }
        // }
        // return Optional.empty();

        return contacts.stream().filter(contact -> contact.getPhoneNumber().equals(phoneNumber)).findFirst();
    }

    @Override
    public void updateContact(String phoneNumber, String newType) {
        // old way
        // for (Contact contact : contacts) {
        //     if (contact.getPhoneNumber().equals(phoneNumber)) {
        //         contact.setType(newType);
        //     }
        // }

        getContactByPhoneNumber(phoneNumber).ifPresent(contact -> contact.setType(newType));
    }

    @Override
    public void deleteContact(String phoneNumber) {
        // old way
        // for (Contact contact : contacts) {
        //     if (contact.getPhoneNumber().equals(phoneNumber)) {
        //         contacts.remove(contact);
        //     }
        // }

        contacts.removeIf(contact -> contact.getPhoneNumber().equals(phoneNumber));
    }
}
