package si.um.feri.aiv.demo.dao;

import si.um.feri.aiv.demo.dao.interfaces.UserDAOInterface;
import si.um.feri.aiv.demo.vao.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UserDAO implements UserDAOInterface {
    private static volatile UserDAO instance;  // Volatile za varno večnitno inicializacijo
    private final List<User> users = Collections.synchronizedList(new ArrayList<>());

    private UserDAO() {}  // Zasebni konstruktor preprečuje več instanc

    public static UserDAO getInstance() {
        if (instance == null) { // Prvi check (brez zaklepanja)
            synchronized (UserDAO.class) { // Zaklep le pri prvem klicu
                if (instance == null) { // Drugi check (z zaklepanjem)
                    instance = new UserDAO();
                }
            }
        }
        return instance;
    }

    @Override
    public void insertUser(User user) {
        synchronized (users) {  // Zaklepanje pri pisanju v seznam
            users.add(user);
        }
    }

    @Override
    public List<User> getAllUsers() {
        synchronized (users) {  // Zaklepanje pri iteraciji seznama
            return new ArrayList<>(users);  // Preprečuje `ConcurrentModificationException`
        }
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        synchronized (users) {  // Zaklepanje pri iskanju uporabnika
            return users.stream().filter(user -> user.getEmail().equals(email)).findFirst();
        }
    }

    @Override
    public void updateUser(String email, String newName) {
        synchronized (users) {  // Zaklepanje pri posodobitvi uporabnika
            getUserByEmail(email).ifPresent(user -> user.setName(newName));
        }
    }

    @Override
    public void deleteUser(String email) {
        synchronized (users) {  // Zaklepanje pri brisanju uporabnika
            users.removeIf(user -> user.getEmail().equals(email));
        }
    }
}
