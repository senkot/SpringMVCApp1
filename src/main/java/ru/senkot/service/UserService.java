package ru.senkot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.senkot.DAO.UserDAO;
import ru.senkot.entities.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    public void insertUser(User user) {
        userDAO.insertUser(user);
    }

    @Transactional
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Transactional
    public User selectUser(int id) {
        return userDAO.selectUser(id);
    }

    @Transactional
    public List<User> selectAllUser() {
        return userDAO.selectAllUser();
    }

    @Transactional
    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }
}
