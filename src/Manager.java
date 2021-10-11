import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Manager {
    private final String PRODUCT = "product.obj";
    private List<Product> products;

    public Manager() {
        products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public List<Product> getProduct(String url){
        products.clear();
        products = IO.readToFile(url);
        return products;
    }
    public void addProduct(Product product){
        products.add(product);
        IO.writeFile(PRODUCT, products);
    }
    public Product findProduct(String url, String code) throws Exception{
        for (Product product: IO.readToFile(url)){
            if(product.getCode().equals(code)){
                return product;
            }
        }
        throw new FileNotFoundException();
    }

}
