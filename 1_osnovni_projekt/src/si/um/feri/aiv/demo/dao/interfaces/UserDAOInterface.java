package si.um.feri.aiv.demo.dao.interfaces;

import si.um.feri.aiv.demo.vao.User;

import java.util.List;
import java.util.Optional;

public interface UserDAOInterface {
    void insertUser(User user);
    List<User> getAllUsers();
    Optional<User> getUserByEmail(String email);
    void updateUser(String email, String newName);
    void deleteUser(String email);
}