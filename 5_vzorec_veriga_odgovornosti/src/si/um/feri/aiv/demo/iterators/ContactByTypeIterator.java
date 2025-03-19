package si.um.feri.aiv.demo.iterators;

import si.um.feri.aiv.demo.vao.Contact;
import java.util.Iterator;
import java.util.List;

public class ContactByTypeIterator implements Iterator<Contact> {
    private final Iterator<Contact> iterator;
    private Contact nextContact;
    private final String type;

    public ContactByTypeIterator(List<Contact> contacts, String type) {
        this.iterator = contacts.iterator();
        this.type = type;
        advance();
    }

    private void advance() {
        while (iterator.hasNext()) {
            Contact potential = iterator.next();
            if (potential.getType().equalsIgnoreCase(type)) {
                nextContact = potential;
                return;
            }
        }
        nextContact = null;
    }

    @Override
    public boolean hasNext() {
        return nextContact != null;
    }

    @Override
    public Contact next() {
        Contact current = nextContact;
        advance();
        return current;
    }
}
