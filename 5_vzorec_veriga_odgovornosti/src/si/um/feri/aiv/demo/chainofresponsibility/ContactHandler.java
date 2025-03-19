package si.um.feri.aiv.demo.chainofresponsibility;

import si.um.feri.aiv.demo.vao.Contact;
import si.um.feri.aiv.demo.vao.User;

public interface ContactHandler {
    void setNextHandler(ContactHandler next);
    void handleRequest(User user, Contact contact);
}
