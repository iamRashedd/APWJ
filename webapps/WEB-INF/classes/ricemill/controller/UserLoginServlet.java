package ricemill.controller;

import ricemill.model.User;
import ricemill.repository.UserRepository;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserLoginServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(UserLoginServlet.class.getName());


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Login");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("../views/user/loginUser.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        boolean flag = true;

        if (email == null || email.isEmpty()){
            req.setAttribute("emailError", "Please fill up the username");
            flag = false;
        }

        if (password == null || password.isEmpty()){
            req.setAttribute("passwordError", "Please fill up the password");
            flag = false;
        }
        if(flag) {
            try {
                UserRepository userRepository = new UserRepository();
                boolean isValid = userRepository.login(email, password);
                if (isValid) {
                    //User user = userRepository.searchUser(email);
                    HttpSession httpSession = req.getSession();
                    httpSession.setAttribute("email", email);
                    //httpSession.setAttribute("type", user.getType());
                    req.setAttribute("error", httpSession.getAttribute("email"));
                    resp.sendRedirect(req.getContextPath() + "/app/user/home");
                    return;
                }

                req.setAttribute("error", "Login Failed");
            } catch (NamingException var9) {
                logger.log(Level.SEVERE, "Naming exception occurred while accessing UserRepository");
                logger.log(Level.SEVERE, var9.getMessage());
            } catch (SQLException var10) {
                logger.log(Level.SEVERE, "SQL exception occurred while accessing UserRepository");
                logger.log(Level.SEVERE, var10.getMessage());
            }
        }



        req.setAttribute("email", email);
        req.setAttribute("password", password);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("../views/user/loginUser.jsp");
        requestDispatcher.forward(req,resp);



    }
}
