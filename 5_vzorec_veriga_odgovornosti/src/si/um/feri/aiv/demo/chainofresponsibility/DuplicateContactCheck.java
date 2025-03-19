package si.um.feri.aiv.demo.chainofresponsibility;

import si.um.feri.aiv.demo.vao.Contact;
import si.um.feri.aiv.demo.vao.User;

public class DuplicateContactCheck implements ContactHandler {
    private ContactHandler next;

    @Override
    public void setNextHandler(ContactHandler next) {
        this.next = next;
    }

    @Override
    public void handleRequest(User user, Contact contact) {
        if (user.getContacts().stream().anyMatch(c -> c.getPhoneNumber().equals(contact.getPhoneNumber()))) {
            System.out.println("Contact with phone number " + contact.getPhoneNumber() + " already exists for this user.");
            return;
        }
        if (next != null) next.handleRequest(user, contact);
    }
}
