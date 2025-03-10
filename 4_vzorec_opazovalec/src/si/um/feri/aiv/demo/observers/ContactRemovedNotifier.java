package si.um.feri.aiv.demo.observers;

import si.um.feri.aiv.demo.vao.Contact;
import si.um.feri.aiv.demo.vao.User;

public class ContactRemovedNotifier implements ContactObserver {
    @Override
    public void update(User user, Contact contact, String action) {
        if ("removed".equals(action)) {
            System.out.println("Notification: " + user.getName() + " removed a contact: " + contact);
        }
    }
}
