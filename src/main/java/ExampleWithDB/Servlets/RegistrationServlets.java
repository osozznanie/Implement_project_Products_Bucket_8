package ExampleWithDB.Servlets;

import ExampleWithDB.DAO.UsersDAO;
import ExampleWithDB.shop.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/register")
public class RegistrationServlets extends HttpServlet {
    private UsersDAO usersDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("here");
        req.getRequestDispatcher("cabinet.jsp").forward(req, resp);

        resp.getWriter().append("Served at: ").append(req.getContextPath());
        req.getRequestDispatcher("register.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            usersDAO = new UsersDAO();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Users user = new Users(firstName, lastName, email, password);

        if (firstName.isEmpty()  || lastName.isEmpty() || email.isEmpty() || password.isEmpty()){
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }else{
            usersDAO.create(user);
            System.out.println(user);
            req.setAttribute("email", email);
            req.getRequestDispatcher("cabinet.jsp").forward(req, resp);
        }
    }
}
