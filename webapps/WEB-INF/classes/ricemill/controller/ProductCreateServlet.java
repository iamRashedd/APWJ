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

public class ProductCreateServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(ProductCreateServlet.class.getName());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Product Add");
        Product product = new Product(0,null,null,null,0);
        req.setAttribute("product", product);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("../../views/product/addProduct.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String category = req.getParameter("category");
        String subcategory = req.getParameter("subcategory");
        String name = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));

        boolean isValid = true;

        if(id < 2 || id>100){
            req.setAttribute("idError", "ID should be between 1-100");
            isValid = false;
        }
        if(category == null || category.isEmpty()){
            req.setAttribute("categoryError", "Invalid Category");
            isValid = false;
        }
        if(subcategory == null || subcategory.isEmpty()){
            req.setAttribute("subcategoryError", "Invalid subcategory");
            isValid = false;
        }
        if(name == null || name.isEmpty()){
            req.setAttribute("nameError", "Invalid name");
            isValid = false;
        }
        if(price < 2 || price>100){
            req.setAttribute("priceError", "Price should be between 1-100");
            isValid = false;
        }

        if(isValid){
            try{
                ProductRepository productRepository = new ProductRepository();
                Product product = new Product(id,category,subcategory,name,price);
                boolean res = productRepository.insertProduct(product);
                req.setAttribute("product",product);
                if (!res) {
                    req.setAttribute("errorMsg", "Product Added successfully...");
                }
                else {
                    req.setAttribute("errorMsg", "Product Add failed...");
                }

            }catch (NamingException var9) {
                logger.log(Level.SEVERE, "Naming exception occurred while accessing ProductRepository");
                logger.log(Level.SEVERE, var9.getMessage());
            } catch (SQLException var10) {
                logger.log(Level.SEVERE, "SQL exception occurred while accessing ProductRepository");
                logger.log(Level.SEVERE, var10.getMessage());
            }

        }

        req.setAttribute("id", id);
        req.setAttribute("category", category);
        req.setAttribute("subcategory", subcategory);
        req.setAttribute("name", name);
        req.setAttribute("price", price);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("../../views/product/addProduct.jsp");
        requestDispatcher.forward(req,resp);




    }
}
