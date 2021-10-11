import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IO {

    public static void writeFile(String url, List<Product> products){
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(url);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Product> readToFile(String url){
        List<Product> products = new ArrayList<>();
        FileInputStream fis;
        try {
            fis = new FileInputStream(url);
            ObjectInputStream ois = new ObjectInputStream(fis);
            products = (List<Product>) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }

}
