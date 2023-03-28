package ricemill.controller;

import ricemill.model.User;
import ricemill.repository.UserRepository;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserRegistrationServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(UserRegistrationServlet.class.getName());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Registration");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("../views/user/registerUser.jsp");
        requestDispatcher.forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirm_password");
        String address = req.getParameter("address");
        String name = req.getParameter("name");
        String type = "user";

        boolean isValid = true;

        if (email == null || email.isEmpty()) {
            req.setAttribute("emailError", "Please fill up the email");
            isValid = false;
        }

        if (name == null || name.isEmpty()){
            req.setAttribute("nameError", "Please fill up the name");
            isValid = false;
        } else if (name.length()<5) {
            req.setAttribute("nameError", "Name have to be more than 5 Letters");
            isValid = false;
        }

        if (address == null || address.isEmpty()){
            req.setAttribute("addressError", "Please fill up the Address");
            isValid = false;
        } else if (name.length()<5) {
            req.setAttribute("addressError", "Address have to be more than 5 Letters");
            isValid = false;
        }

        if (password == null || password.isEmpty()) {
            req.setAttribute("passwordError", "Please fill up the password");
            isValid = false;
        }

        if (confirmPassword == null || confirmPassword.isEmpty()) {
            req.setAttribute("confirmPassError", "Please fill up the confirm password");
            isValid = false;
        }

        if (!password.equals(confirmPassword)){
            req.setAttribute("confirmPassError", "Password did not match");
            isValid = false;
        }

        if(isValid){
            try{
                UserRepository userRepository = new UserRepository();
                User user = new User(email,password,name,address,type);
                boolean res = userRepository.register(user);
                if(!res){
                    req.setAttribute("errorMsg", "Registration Successful");
                }
                else{
                    req.setAttribute("errorMsg", "Registration failed");
                }

            }catch (NamingException var9) {
                logger.log(Level.SEVERE, "Naming exception occurred while accessing UserRepository");
                logger.log(Level.SEVERE, var9.getMessage());
            } catch (SQLException var10) {
                logger.log(Level.SEVERE, "SQL exception occurred while accessing UserRepository");
                logger.log(Level.SEVERE, var10.getMessage());
            }
        }

        req.setAttribute("email",email);

        req.setAttribute("address",address);
        req.setAttribute("name",name);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("../views/user/registerUser.jsp");
        requestDispatcher.forward(req, resp);


    }
}
