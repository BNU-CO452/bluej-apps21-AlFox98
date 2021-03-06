import java.util.Random;

/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @modified Alastair Fox
 * @version 2016.02.29
 */
public class StockDemo
{
    // The stock manager.
    private StockList stock;
    
    private Random generator = new Random();

    /**
     * Create a StockManager and populate it with at least
     * 10 sample products.
     */
    public StockDemo(StockList stock)
    {
        this.stock = stock;
        
        // Add at least 10 products, they must be unique to you
        // Make sure the ids are sequential numbers
        
        stock.add(new Product(101, "McLaren 720S"));
        stock.add(new Product(102, "Ferrari SF90 Stradale"));
        stock.add(new Product(103, "Ferrari F8 Tributo"));
        stock.add(new Product(104, "Lamborhini Huracan Evo"));
        stock.add(new Product(105, "Ford GT"));
        stock.add(new Product(106, "Lamborghini Aventador SVJ"));
        stock.add(new Product(107, "Noble M600"));
        stock.add(new Product(108, "Aston Martin Vanquish"));
        stock.add(new Product(109, "BMW M1"));
        stock.add(new Product(110, "McLaren F1"));
    }
    
    /**
     * Provide a demonstration of how the ProductList meets all
     * the user requirements by making a delivery of each product 
     * buying it in various amounts and then selling each
     * product by various amounts. Make sure all the requirements
     * have been demonstrated.
     */
    public void runDemo()
    {
        // Show details of all of the products before delivery.
        
        stock.print();

        buyProducts();
        stock.print();        

        //sellProducts();
        stock.print();
    }
    
    private void buyProducts()
    {
        Product product;
        int quantity = 1;
        for(int id = 101; id <= 110; id++)
        {
            product = stock.findProduct(id);
            if(product == null)
            {
                System.out.println("Product " + id + " not found");
            }
            else
            {
                quantity = generator.nextInt(20);
                stock.buyProduct(id, quantity);
            }
        }
    }

    //private void sellProducts()
    //{
    //    Product product;
    //    for(int id = 101; id <= 110; id++)
    //    {
    //        product = stock.findProduct(id);
    //        if(product == null)
    //        {
    //            System.out.println("Product " + id + " not found");
    //        }
    //        else
    //        {
    //            stock.sellProduct(id);
    //        }
    //    }
    //}    
}