package ricemill.controller;

import ricemill.model.Inventory;
import ricemill.repository.InventoryRepository;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InventoryUpdateServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(InventoryUpdateServlet.class.getName());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Inventory Update");
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        try{
            InventoryRepository inventoryRepository = new InventoryRepository();
            Inventory inventory = inventoryRepository.searchInventory(id);

            System.out.println(inventory.getId());

            req.setAttribute("inventory", inventory);

        } catch (NamingException var9) {
            logger.log(Level.SEVERE, "Naming exception occurred while accessing InventoryRepository");
            logger.log(Level.SEVERE, var9.getMessage());
        } catch (SQLException var10) {
            logger.log(Level.SEVERE, "SQL exception occurred while accessing InventoryRepository");
            logger.log(Level.SEVERE, var10.getMessage());
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("../../views/inventory/updateInventory.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int product_id = Integer.parseInt(req.getParameter("product_id"));
        String status = req.getParameter("status");
        int min_stock = Integer.parseInt(req.getParameter("min_stock"));
        int max_stock = Integer.parseInt(req.getParameter("max_stock"));
        int available_stock = Integer.parseInt(req.getParameter("available_stock"));
        Date last_update = null;
        boolean isValid = true;

        if(id<=0){
            req.setAttribute("idError", "Invalid ID");
            isValid = false;
        }

        if(product_id<=0){
            req.setAttribute("product_idError", "Invalid Product ID");
            isValid = false;
        }
        if(status == null || status.isEmpty()){
            req.setAttribute("statusError", "Please fill up Status");
            isValid = false;
        }
        if(min_stock<=0){
            req.setAttribute("min_stockError", "Invalid Min Stock");
            isValid = false;
        }
        if(max_stock<=0){
            req.setAttribute("max_stockError", "Invalid Max Stock");
            isValid = false;
        }
        if(available_stock<=0){
            req.setAttribute("available_stockError", "Invalid Available Stock");
            isValid = false;
        }

        if(isValid){
            try{
                InventoryRepository inventoryRepository = new InventoryRepository();
                Inventory inventory = new Inventory(id,product_id,status,min_stock,max_stock,available_stock,last_update);
                boolean res = inventoryRepository.updateInventory(inventory);
                req.setAttribute("inventory",inventory);
                if(!res){
                    req.setAttribute("errorMsg", "Inventory Updated Successfully");
                }
                else{
                    req.setAttribute("errorMsg", "Inventory Update Failed");
                }
            }
            catch (NamingException var9) {
                logger.log(Level.SEVERE, "Naming exception occurred while accessing ProductRepository");
                logger.log(Level.SEVERE, var9.getMessage());
            } catch (SQLException var10) {
                logger.log(Level.SEVERE, "SQL exception occurred while accessing ProductRepository");
                logger.log(Level.SEVERE, var10.getMessage());
            }
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("../../views/inventory/updateInventory.jsp");
        requestDispatcher.forward(req,resp);




    }
}
