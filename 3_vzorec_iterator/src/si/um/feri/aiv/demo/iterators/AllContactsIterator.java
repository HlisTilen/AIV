package si.um.feri.aiv.demo.iterators;

import si.um.feri.aiv.demo.vao.Contact;
import si.um.feri.aiv.demo.vao.User;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class AllContactsIterator implements Iterator<Contact> {
    private final Iterator<Contact> iterator;

    public AllContactsIterator(List<User> users) {
        List<Contact> vsiKontakti = new ArrayList<>();

        for (User user : users) {
            vsiKontakti.addAll(user.getContacts());
        }

        this.iterator = vsiKontakti.iterator();
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
