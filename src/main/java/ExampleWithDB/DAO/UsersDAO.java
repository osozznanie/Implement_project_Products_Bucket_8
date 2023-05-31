package ExampleWithDB.DAO;

import ExampleWithDB.Models.ConnectionUtils;
import ExampleWithDB.shop.Magazines;
import ExampleWithDB.shop.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO extends BaseDAO<Users>{
    static String INSERT = "INSERT INTO user (first_name, last_name, email, password) VALUE(?,?,?,?)";
    static String READ_ALL = "SELECT * FROM user";
    static String UPDATE = "UPDATE user SET first_name = ?, last_name = ?, email = ?, password = ?";
    static String DELETE = "DELETE FROM user WHERE id = ?";
    private final Connection dbConnection = ConnectionUtils.openConnection();
    private PreparedStatement preparedStatement;

    public UsersDAO() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    }

    @Override
    public void create(Users users) {
        try {
            preparedStatement = dbConnection.prepareStatement(INSERT);
            preparedStatement.setString(1, users.getFirstName());
            preparedStatement.setString(2, users.getLastName());
            preparedStatement.setString(3, users.getEmail());
            preparedStatement.setString(4, users.getPassword());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public List<Users> readAll() {
        List<Users> usersList = new ArrayList<>();
        try {
            preparedStatement = dbConnection.prepareStatement(READ_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Users users = new Users();
                users.setId(resultSet.getInt("id"));
                users.setFirstName(resultSet.getString("first_name"));
                users.setLastName(resultSet.getString("last_name"));
                users.setEmail(resultSet.getString("email"));
                users.setPassword(resultSet.getString("password"));


                usersList.add(users);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return usersList;
    }


    @Override
    public void update(Users users) {
        try {
            preparedStatement = dbConnection.prepareStatement(UPDATE);
            preparedStatement.setString(1, users.getFirstName());
            preparedStatement.setString(2, users.getLastName());
            preparedStatement.setString(3, users.getEmail());
            preparedStatement.setString(4, users.getPassword());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }

    @Override
    public void deleteById(int id) {
        try {
            preparedStatement = dbConnection.prepareStatement(DELETE);
            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Users getUserByEmail(String email) {
        String query = "SELECT * FROM user WHERE email = ?";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Users user = new Users();
                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
