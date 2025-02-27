package si.um.feri.aiv.demo.dao.interfaces;

import si.um.feri.aiv.demo.vao.Contact;
import si.um.feri.aiv.demo.vao.User;

import java.util.List;
import java.util.Optional;

public interface ContactDAOInterface {
    void insertContact(Contact contact);
    List<Contact> getContactsByUser(User user);
    Optional<Contact> getContactByPhoneNumber(String phoneNumber);
    void updateContact(String phoneNumber, String newType);
    void deleteContact(String phoneNumber);
}
