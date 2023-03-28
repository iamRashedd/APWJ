package ricemill.model;


import java.util.Date;

public class Inventory {
    private int id;
    private int product_id;
    private String status;
    private int min_stock;
    private int max_stock;
    private int available_stock;
    private Date last_update;

    public Inventory(){

    }
    public Inventory(int id, int product_id, String status, int min_stock, int max_stock, int available_stock, Date last_update) {
        this.id = id;
        this.product_id = product_id;
        this.status = status;
        this.min_stock = min_stock;
        this.max_stock = max_stock;
        this.available_stock = available_stock;
        this.last_update = last_update;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getMin_stock() {
        return min_stock;
    }

    public void setMin_stock(int min_stock) {
        this.min_stock = min_stock;
    }

    public int getMax_stock() {
        return max_stock;
    }

    public void setMax_stock(int max_stock) {
        this.max_stock = max_stock;
    }

    public int getAvailable_stock() {
        return available_stock;
    }

    public void setAvailable_stock(int available_stock) {
        this.available_stock = available_stock;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }
}
