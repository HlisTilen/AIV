package si.um.feri.aiv.demo.chainofresponsibility;

import si.um.feri.aiv.demo.vao.Contact;
import si.um.feri.aiv.demo.vao.User;

public class PhoneNumberValidationCheck implements ContactHandler {
    private ContactHandler next;

    @Override
    public void setNextHandler(ContactHandler next) {
        this.next = next;
    }

    @Override
    public void handleRequest(User user, Contact contact) {
        if (!contact.getPhoneNumber().matches("\\+\\d{3} \\d{2,3} \\d{3} \\d{3}")) {
            System.out.println("Invalid phone number format: " + contact.getPhoneNumber());
            return;
        }
        if (next != null) next.handleRequest(user, contact);
    }
}
