package ricemill.controller;

import ricemill.model.Product;
import ricemill.repository.ProductRepository;

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

public class ProductDeleteServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(ProductDeleteServlet.class.getName());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Product Delete");
        int id = Integer.parseInt(req.getParameter("id"));
        try{
            ProductRepository productRepository = new ProductRepository();
            boolean res = productRepository.deleteProduct(id);

        } catch (NamingException var9) {
            logger.log(Level.SEVERE, "Naming exception occurred while accessing ProductRepository");
            logger.log(Level.SEVERE, var9.getMessage());
        } catch (SQLException var10) {
            logger.log(Level.SEVERE, "SQL exception occurred while accessing ProductRepository");
            logger.log(Level.SEVERE, var10.getMessage());
        }

        resp.sendRedirect( req.getContextPath() + "/app/product/show");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
