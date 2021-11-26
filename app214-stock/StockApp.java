
/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Student Name
 * @version 0.1
 */
public class StockApp
{
    private InputReader reader;
    
    private StockList stock;
    
    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        reader = new InputReader();
        
        stock = new StockList();
        StockDemo demo = new StockDemo(stock);
    }

    /**
     *  Display a list of menu choices and execute
     *  the user's choice.
     */
    public void run()
    {
        boolean finished = false;
        
        while(!finished)
        {
            printHeading();
            printMenuChoices();
           
            String choice = reader.getString("Please enter your choice > ");
            
            finished = executeChoice(choice.toLowerCase());
        }
    }
    
    private boolean executeChoice(String choice)
    {
        if(choice.equals("quit"))
        {
            return true;
        }
        else if(choice.equals("print"))
        {
            stock.print();
        }
        else if(choice.equals("add"))
        {
            addProduct();
        }
        else if(choice.equals("remove"))
        {
            remove();
        }
        else if(choice.equals("buy"))
        {
            buy();
        }
        else if(choice.equals("sell"))
        {
            sell();
        }
        else if(choice.equals("search"))
        {
            
        }
        else if(choice.equals("low stock"))
        {
            stockLow();
        }
        else if(choice.equals("restock"))
        {
            
        }
        
        return false;
    }
   
    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    Add:        Add a new product");
        System.out.println("    Remove:     Remove an old product");
        System.out.println("    Print:      Print all products");
        System.out.println("    Buy:        Buy stock");
        System.out.println("    Sell:       Sell stock");
        System.out.println("    Search:     Search stock");
        System.out.println("    Low Stock:  Find items with low stock");
        System.out.println("    Restock:    Find items that have been restocked");
        System.out.println("    Quit:       Quit the program");
        System.out.println();        
    }
    
    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println("********************************");
        System.out.println("  App21-04: Stock Application ");
        System.out.println("      by Student Name");
        System.out.println("********************************");
    }
    
    /**
     * Constructor used to add a new product if the product ID is unused
     */
    private void addProduct()
    {
        System.out.println("Adding a new product");
        System.out.println();
        
        int id = reader.getInt("Please enter a product ID > ");
        String name = reader.getString("Please enter the product name > ");
        
        Product checkProduct = stock.findProduct(id);
        
        if(checkProduct != null) 
        {
            System.out.println("ERROR: Item already exists");
        }
        else
        {
            Product product = new Product(id, name);
            stock.add(product);
            System.out.println("Item successfully added");
        }
        
        stock.print();
    }
    
    /**
     * Constructor used to remove a product if the product ID entered can be found
     */
    private void remove()
    {
        System.out.println("Remove a product");
        System.out.println();
        
        int id = reader.getInt("Please enter a product ID to remove > ");
        
        String name = reader.getString("Please enter a product name to remove > ");
        
        Product product = stock.findProduct(id);
        
        if(product != null) 
        {
            stock.removeProduct(id);
        }
        else
        {
            System.out.println("ERROR: Couldn't find item");
        }
        stock.print();
    }
    
    /**
     * Constructor used to purchase an entered amount of any product, provided
     * the product ID can be found
     */
    private void buy()
    {
        System.out.println("Purchase a product");
        System.out.println();
        
        int id = reader.getInt("Please enter a product ID to purchase > ");
        
        int amount = reader.getInt("Please enter an amount to purchase > ");
        
        Product product = stock.findProduct(id);
        
        if(product != null) 
        {
            stock.buyProduct(id, amount);
        }
        else
        {
            System.out.println("ERROR: Couldn't find item");
        }
        stock.print();
    }
    
    /**
     * Constructor used to sell an entered amount of any product, provided
     * the product ID can be found and there is stock to sell
     */
    private void sell()
    {
        System.out.println("Sell a product");
        System.out.println();
        
        int id = reader.getInt("Please enter a product ID to sell > ");
        
        int amount = reader.getInt("Please enter an amount to sell > ");
        
        Product product = stock.findProduct(id);
        
        if(product != null) 
        {
            stock.sellProduct(id, amount);
        }
        else
        {
            System.out.println("ERROR: Couldn't find item");
        }
        stock.print();
    }
    
    /**
     * Calls the lowStock constructor in StockList with an entered amount, and
     * finds products with stock less than the entered amount
     */
    private void stockLow()
    {
        int amount = reader.getInt("Please enter a stock amount > ");
        stock.lowStock(amount);
    }
}
    