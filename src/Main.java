import java.util.Scanner;

public class Main {
    static Manager manager = new Manager();
    public static void main(String[] args) {
        int choice = 0;
        while (true){
            Scanner s = new Scanner(System.in);
            System.out.println("1 Show all");
            System.out.println("2 find info");
            System.out.println("3 add product");
            System.out.println("0 exit");
            choice = s.nextInt();
            switch (choice){
                case 1:showAll();
                break;
                case 2:findInfo();
                break;
                case  3:
                    manager.addProduct(getNewProduct());
                    break;
                case 0: return;
            }
        }
    }
    public static void showAll(){
        Scanner s = new Scanner(System.in);
        System.out.println("Nhập file");
        String url = s.nextLine();
        for (Product product: manager.getProduct(url)){
            System.out.println(product);
        }

    }
    public static Product getNewProduct(){
        Scanner s = new Scanner(System.in);
        System.out.println("Nhập mã");
        String code = s.nextLine();
        System.out.println("Nhập tên");
        String name = s.nextLine();
        Product product = new Product(code, name);
        return product;
    }

    public static void findInfo(){
        Scanner s = new Scanner(System.in);
        System.out.println("Nhập code");
        String code = s.nextLine();
        try {
            Product product =manager.findProduct( code);
            System.out.println(product);
        } catch (Exception e) {
            System.out.println("Sản phẩm không tồn tại");;
        }
    }
}
