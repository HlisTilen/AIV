package si.um.feri.aiv.demo.observers;

import si.um.feri.aiv.demo.vao.Contact;
import si.um.feri.aiv.demo.vao.User;

public class ContactAddedNotifier implements ContactObserver {
    @Override
    public void update(User user, Contact contact, String action) {
        if ("added".equals(action)) {
            System.out.println("Notification: " + user.getName() + " added a new contact: " + contact);
        }
    }
}
