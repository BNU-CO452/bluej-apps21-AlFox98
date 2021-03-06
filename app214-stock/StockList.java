import java.util.ArrayList;
import java.util.Random;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author Alastair Fox      
 * @version 12/11/2021
 */
public class StockList
{
    // A list of the products.
    private ArrayList<Product> stock;
    
    private Random generator = new Random();

    /**
     * Initialise the stock manager.
     */
    public StockList()
    {
        stock = new ArrayList<Product>();
    }

    /**
     * Add a product to the list.
     * @param item The product item to be added.
     */
    public void add(Product item)
    {
        stock.add(item);
    }
    
    /**
     * A method to buy a single quantity of the product
     */
    public void buyProduct(int productID)
    {
        buyProduct(productID, 1);
    }
    
    
    /**
     * Buy a quantity of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void buyProduct(int productID, int amount)
    {
        Product product = findProduct(productID);
        
        if(product == null)
        {
            System.out.println(product + " not found.");
        }
        else
        {
            product.increaseQuantity(amount);
            System.out.println("Bought " + amount + " " + product);
        }
    }
    
    /**
     * Find a product to match the product id,
     * if not found return null
     */
    public Product findProduct(int productID)
    {
        for(Product product : stock)
        {
            if(product.getID() == productID)
                return product;
        }
        return null;
    }
    
    
    /**
     * Sell one of the given product.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int productID, int amount)
    {
        Product product = findProduct(productID);
        
        if(product != null) 
        {
            if(product.getQuantity() > 0 && product.getQuantity() >= amount)
            {
                product.decreaseQuantity(amount);
                System.out.println("Sold " + amount + " of " + product);
                // printout message
            }
            else
            {
                System.out.println("Not enough " + product + " stock to sell.");
                // printout message
            }
        }
        else
        {
            System.out.println("Couldn't find product: " + product);
            // printout message
        }
    }    

    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int productID)
    {
        return 0;
    }

    /**
     * Print details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void printProduct(int productID)
    {
        Product product = findProduct(productID);
        
        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }
    
    /**
     * Print out each product in the stock
     * in the order they are in the stock list
     */
    public void print()
    {
        printHeading();
        
        for(Product product : stock)
        {
            System.out.println(product);
        }

        System.out.println();
    }
    
    public void printHeading()
    {
        System.out.println();
        System.out.println(" Al's Stock List");
        System.out.println(" ====================");
        System.out.println();
    }
    
    /**
     * Constructor used to remove a product from the stock list
     */
    public void removeProduct(int productID)
    {
        Product removed = findProduct(productID);
        
        stock.remove(removed);
        System.out.println("Removed entry with ID: " + (removed) + " from the stock list.");
    }
    
    /**
     * Constructor used to display which products are below a certain number of stock
     */
    public void lowStock(int amount)
    {
        for (Product product : stock)
        {
            if (product.getQuantity()<amount)
                System.out.println(product);
        }
    }
}