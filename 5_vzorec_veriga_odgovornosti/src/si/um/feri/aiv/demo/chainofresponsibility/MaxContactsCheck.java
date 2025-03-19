package si.um.feri.aiv.demo.chainofresponsibility;

import si.um.feri.aiv.demo.vao.Contact;
import si.um.feri.aiv.demo.vao.User;

public class MaxContactsCheck implements ContactHandler {
    private static final int MAX_CONTACTS = 3;
    private ContactHandler next;

    @Override
    public void setNextHandler(ContactHandler next) {
        this.next = next;
    }

    @Override
    public void handleRequest(User user, Contact contact) {
        if (user.getContacts().size() >= MAX_CONTACTS) {
            System.out.println("User " + user.getEmail() + " has reached the maximum number of contacts (" + MAX_CONTACTS + ").");
            return;
        }
        System.out.println("Contact " + contact.getPhoneNumber() + " passed all checks and is added!");
        user.addContact(contact);
    }
}
