package ExampleWithDB.DAO;

import ExampleWithDB.Models.ConnectionUtils;
import ExampleWithDB.shop.Magazines;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MagazinesDAO extends BaseDAO<Magazines> {
    static String INSERT = "INSERT INTO magazines (name_of_magazine, description, price) VALUE(?,?,?)";
    static String READ_ALL = "SELECT * FROM magazines";
    static String UPDATE = "UPDATE magazines SET name_of_magazine = ?, description = ?, price = ?";
    static String DELETE = "DELETE FROM magazines WHERE id = ?";
    private final Connection dbConnection = ConnectionUtils.openConnection();
    private PreparedStatement preparedStatement;

    public MagazinesDAO() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    }

    @Override
    public void create(Magazines magazines) {
        try {
            preparedStatement = dbConnection.prepareStatement(INSERT);
            preparedStatement.setString(1, magazines.getNameOfMagazine());
            preparedStatement.setString(2, magazines.getDescription());
            preparedStatement.setInt(3, magazines.getPrice());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public List<Magazines> readAll() {
        List<Magazines> magazinesList = new ArrayList<>();
        try {
            preparedStatement = dbConnection.prepareStatement(READ_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Magazines magazines = new Magazines();
                magazines.setId(resultSet.getInt("id"));
                magazines.setNameOfMagazine(resultSet.getString("name_of_magazine"));
                magazines.setDescription(resultSet.getString("description"));
                magazines.setPrice(resultSet.getInt("price"));


                magazinesList.add(magazines);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return magazinesList;
    }


    @Override
    public void update(Magazines magazines) {
        try {
            preparedStatement = dbConnection.prepareStatement(UPDATE);
            preparedStatement.setString(1, magazines.getNameOfMagazine());
            preparedStatement.setString(2, magazines.getDescription());
            preparedStatement.setInt(3, magazines.getPrice());

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
}
