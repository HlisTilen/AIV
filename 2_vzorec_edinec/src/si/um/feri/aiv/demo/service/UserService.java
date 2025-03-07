package si.um.feri.aiv.demo.service;

import si.um.feri.aiv.demo.dao.UserDAO;
import si.um.feri.aiv.demo.dao.interfaces.UserDAOInterface;
import si.um.feri.aiv.demo.vao.User;

import java.util.List;
import java.util.Optional;

public class UserService {
    private final UserDAOInterface userDAO = UserDAO.getInstance(); // Uporabimo Singleton preko vmesnika

    public void createUser(String name, String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("E-poštni naslov ne sme biti prazen!");
        }
        userDAO.insertUser(new User(name, email));
    }

    public List<User> getAllUsers() {
        // še kakšna validacija
        // if (users.isEmpty()) {...
        return userDAO.getAllUsers();
    }

    public Optional<User> getUserByEmail(String email) {
        //še kakšna validacija
        // if (email == null || email.isEmpty()) {...
        return userDAO.getUserByEmail(email);
    }

    public void updateUser(String email, String newName) {
        //še kakšna validacija
        // if (email == null || email.isEmpty()) {...
        userDAO.updateUser(email, newName);
    }

    public void deleteUser(String email) {
        //še kakšna validacija
        // if (email == null || email.isEmpty()) {...
        userDAO.deleteUser(email);
    }
}
