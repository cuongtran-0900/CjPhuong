package MODEL;

public class Product {
    private String productID;
    private String productName;
    private int productPrice;
    private boolean productStatus;

    public Product() {}

    public Product(String productID, String productName, int productPrice, boolean productStatus) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStatus = productStatus;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productStatus=" + productStatus +
                '}';
    }
}