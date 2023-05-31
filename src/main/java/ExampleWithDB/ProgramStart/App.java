package ExampleWithDB.ProgramStart;

import ExampleWithDB.DAO.MagazinesDAO;
import ExampleWithDB.DAO.PaymentsDAO;
import ExampleWithDB.DAO.SubscribesDAO;
import ExampleWithDB.DAO.UsersDAO;
import ExampleWithDB.shop.Magazines;
import ExampleWithDB.shop.Payments;
import ExampleWithDB.shop.Subscribes;
import ExampleWithDB.shop.Users;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class App {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, ParseException {
        UsersDAO usersDAO = new UsersDAO();
        MagazinesDAO magazinesDAO = new MagazinesDAO();
        PaymentsDAO paymentsDAO = new PaymentsDAO();
        SubscribesDAO subscribesDAO = new SubscribesDAO();

//    usersDAO.readAll().forEach(System.out::println);
//        magazinesDAO.readAll().forEach(System.out::println);
//        paymentsDAO.readAll().forEach(System.out::println);
//        subscribesDAO.readAll().forEach(System.out::println);















    }
}
