package ricemill.model;

public class Product {
    private int id;
    private String category;
    private String subcategory;
    private String name;
    private int price;

    public Product(){

    }

    public Product(int id, String category, String subcategory, String name, int price) {
        this.id = id;
        this.category = category;
        this.subcategory = subcategory;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
