package si.um.feri.aiv.demo.observers;

import si.um.feri.aiv.demo.vao.Contact;
import si.um.feri.aiv.demo.vao.User;

public interface ContactObserver {
    void update(User user, Contact contact, String action);
}
