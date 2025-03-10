package si.um.feri.aiv.demo.iterators;

import si.um.feri.aiv.demo.vao.Contact;
import java.util.Iterator;
import java.util.List;

public class ContactIterator implements Iterator<Contact> {
    private final Iterator<Contact> iterator;

    public ContactIterator(List<Contact> contacts) {
        this.iterator = contacts.iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Contact next() {
        return iterator.next();
    }
}
