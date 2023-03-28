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
import java.util.logging.Level;
import java.util.logging.Logger;

public class InventoryShowServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(InventoryShowServlet.class.getName());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Inventory");
        try{
            InventoryRepository inventoryRepository = new InventoryRepository();
            ArrayList<Inventory> inventories = inventoryRepository.show();

            req.setAttribute("inventories", inventories);

        } catch (NamingException var9) {
            logger.log(Level.SEVERE, "Naming exception occurred while accessing InventoryRepository");
            logger.log(Level.SEVERE, var9.getMessage());
        } catch (SQLException var10) {
            logger.log(Level.SEVERE, "SQL exception occurred while accessing InventoryRepository");
            logger.log(Level.SEVERE, var10.getMessage());
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("../../views/inventory/showInventory.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
