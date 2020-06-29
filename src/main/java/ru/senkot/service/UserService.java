package ru.senkot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.senkot.entities.User;
import ru.senkot.model.UserDAO;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public void insertUser(User user) {
        userDAO.insertUser(user);
    }

    public boolean updateUser(User user) throws SQLException {
        return userDAO.updateUser(user);
    }

    public User selectUser(int id) throws SQLException {
        return userDAO.selectUser(id);
    }

    @Bean("selectAllUser")
    @Scope("prototype")
    public List<User> selectAllUser() throws SQLException {
        return userDAO.selectAllUser();
    }

    public boolean deleteUser(int id) throws SQLException {
        return userDAO.deleteUser(id);
    }
}
