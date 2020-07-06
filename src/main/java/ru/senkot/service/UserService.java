package ru.senkot.service;

import org.springframework.stereotype.Service;
import ru.senkot.entities.User;
import ru.senkot.DAO.UserDAO;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {

    private UserDAO userDAO = new UserDAO();

    public void insertUser(User user) {
        userDAO.insertUser(user);
    }

    public boolean updateUser(User user) throws SQLException {
        return userDAO.updateUser(user);
    }

    public User selectUser(int id) throws SQLException {
        return userDAO.selectUser(id);
    }

    @Transactional
    public List<User> selectAllUser() {
        return userDAO.selectAllUser();
    }

    public boolean deleteUser(int id) throws SQLException {
        return userDAO.deleteUser(id);
    }
}
