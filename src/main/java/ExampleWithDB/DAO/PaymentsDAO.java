package ExampleWithDB.DAO;

import ExampleWithDB.Models.ConnectionUtils;
import ExampleWithDB.shop.Payments;
import ExampleWithDB.shop.Subscribes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PaymentsDAO extends BaseDAO<Payments>{
    static String INSERT = "INSERT INTO payments (id_subscribe, sum) VALUE(?,?)";
    static String READ_ALL = "SELECT * FROM payments";
    static String UPDATE = "UPDATE payments SET id_subscribe = ?, sum = ?";
    static String DELETE = "DELETE FROM payments WHERE id = ?";
    private final Connection dbConnection = ConnectionUtils.openConnection();
    private PreparedStatement preparedStatement;

    public PaymentsDAO() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    }

    @Override
    public void create(Payments payments) {
        try {
            preparedStatement = dbConnection.prepareStatement(INSERT);
            preparedStatement.setInt(1, payments.getIdSubscribe());
            preparedStatement.setInt(2, payments.getSum());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public List<Payments> readAll() {
        List<Payments> paymentsList = new ArrayList<>();
        try {
            preparedStatement = dbConnection.prepareStatement(READ_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Payments payments = new Payments();
                payments.setId(resultSet.getInt("id"));
                payments.setIdSubscribe( resultSet.getInt("id_subscribe"));
                payments.setSum(resultSet.getInt("sum"));
                payments.setDate( resultSet.getDate("date"));


                paymentsList.add(payments);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return paymentsList;
    }


    @Override
    public void update(Payments payments) {
        try {
            preparedStatement = dbConnection.prepareStatement(UPDATE);
            preparedStatement.setInt(1, payments.getIdSubscribe());
            preparedStatement.setInt(2, payments.getSum());

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

