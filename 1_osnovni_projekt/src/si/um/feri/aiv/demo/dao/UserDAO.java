package si.um.feri.aiv.demo.dao;

import si.um.feri.aiv.demo.dao.interfaces.UserDAOInterface;
import si.um.feri.aiv.demo.vao.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAO implements UserDAOInterface {
    private List<User> users = new ArrayList<>();
    // večnitno varno
    // private List<User> users = Collections.synchronizedList(new ArrayList<User>());
    // private List<User> users = new CopyOnWriteArrayList<>();

    @Override
    public void insertUser(User user) {
        users.add(user);
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        // old way
        // for (User user : users) {
        //     if (user.getEmail().equals(email)) {
        //         return Optional.of(user);
        //     }
        // }
        // return Optional.empty();

        return users.stream().filter(user -> user.getEmail().equals(email)).findFirst();
    }

    @Override
    public void updateUser(String email, String newName) {
        // old way
        // for (User user : users) {
        //     if (user.getEmail().equals(email)) {
        //         user.setName(newName);
        //     }
        // }

        getUserByEmail(email).ifPresent(user -> user.setName(newName));
    }

    @Override
    public void deleteUser(String email) {
        // old way
        // for (User user : users) {
        //     if (user.getEmail().equals(email)) {
        //         users.remove(user);
        //     }
        // }

        users.removeIf(user -> user.getEmail().equals(email));
    }
}
