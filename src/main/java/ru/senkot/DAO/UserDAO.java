package ru.senkot.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.senkot.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
//
//    private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useUnicode=true&serverTimezone=UTC";
//    private String name = "root";
//    private String password = "123456";
//
//    private static final String INSERT_USER_SQL = "INSERT INTO users" + " (name, email, country) VALUES" + " (?, ?, ?);";
//    private static final String SELECT_USER_BY_ID = "SELECT id,name,email,country FROM users WHERE id = ?";
//    private static final String SELECT_ALL_USERS = "SELECT * FROM users";
//    private static final String DELETE_USERS_SQL = "DELETE FROM users WHERE id = ?";
//    private static final String UPDATE_USERS_SQL = "UPDATE users SET name = ?, email = ?, country = ? WHERE id = ?";
//
//    protected Connection getConnection() {
//        Connection connection = null;
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection(jdbcURL, name, password);
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//
//        return connection;
//    }

    public void insertUser(User user) {
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
//            preparedStatement.setString(1, user.getName());
//            preparedStatement.setString(2, user.getEmail());
//            preparedStatement.setString(3, user.getCountry());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

    public void updateUser(User user) {
//        boolean rowUpdated;
//        try (Connection connection = getConnection();
//             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL)) {
//            statement.setString(1, user.getName());
//            statement.setString(2, user.getEmail());
//            statement.setString(3, user.getCountry());
//            statement.setInt(4, user.getId());
//
//            rowUpdated = statement.executeUpdate() > 0;
//        }
//        return rowUpdated;

        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    public User selectUser(int id) {
//        User user = null;
//
//        try (Connection connection = getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
//            preparedStatement.setInt(1, id);
//            System.out.println(preparedStatement);
//
//            ResultSet rs = preparedStatement.executeQuery();
//
//            while (rs.next()) {
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                String country = rs.getString("country");
//                user = new User(name, email, country);
//            }
//        }
//
//        return user;

        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<User> selectAllUser() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User").list();
    }

    public void deleteUser(User user) {
//        boolean rowDeleted;
//        try (Connection connection = getConnection();
//                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL)) {
//            preparedStatement.setInt(1, id);
//            rowDeleted = preparedStatement.executeUpdate() > 0;
//        }
//        return rowDeleted;

        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
    }

}
