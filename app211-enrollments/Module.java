/**
 * This class contains information regarding course modules.
 * This includes the module code, title and the amount of credit
 * awarded by the module. This class is to be used by the course class.
 *
 * @author Alastair Fox
 * @version 08/10/2021
 */
public class Module
{
    // the module code
    private String code;
    // the module title
    private String title;
    // the amount of credits a module awards
    public int credit;
    
    /**
     * Constructor used to create a module by assigning a code and a title.
     */
    public Module(String code, String title)
    {
        // initialise instance variables
        this.code = code;
        this.title = title;
        credit = 0;
    }

    /**
     * A single line method used to return the value of a variable
     */
    public String getCode()
    {
        return this.code;
    }
    
    public String getTitle()
    {
        return this.title;
    }
    
    public int getCredit()
    {
        return this.credit;
    }
    
    public void setCredit(int credit)
    {
        this.credit = credit;
    }
    
    /**
     * Print the details of the module, this includes the code,
     * the title and the credit
     */
    public void print()
    {
        //printHeading();
        
        System.out.println(" Module Code: " + code + " Module Title: " + title +
                           " Credit: " + credit);
        System.out.println();
    }
}
