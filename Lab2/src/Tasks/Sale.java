package Tasks;

public class Sale {
    private String productName;
    private Integer price;

    public Sale(String productName, Integer price) {
        this.productName = productName;
        this.price = price;
    }

    public void setProductName(String newProductName) {
        this.productName = newProductName;
    }

    public String getProductName() {
        return this.productName;
    }

    public Integer getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "Product: " + this.productName + ", " + price + " RUB";
    }
}