package ExampleWithDB.Servlets;

import ExampleWithDB.DAO.UsersDAO;
import ExampleWithDB.shop.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
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
        try{
            usersDAO = new UsersDAO();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String login = req.getParameter("login");

        String password = req.getParameter("password");



        if ( login.isEmpty() || password.isEmpty()){
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }else{
            Users users = usersDAO.getUserByEmail(login);
            if (users != null && users.getPassword().equals(password)) {
                req.setAttribute("login", login);
                req.getRequestDispatcher("cabinet.jsp").forward(req, resp);
            } else {
                req.setAttribute("errorMessage", "Incorrect login or password");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        }
    }
}
