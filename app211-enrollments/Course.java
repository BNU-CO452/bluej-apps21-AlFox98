import java.util.*;

/**
 * This class contains information about an undergraduate course
 * at BNU together with a list of student who are enrolled
 *
 * @author Derek Peacock
 * @modified by Alastair Fox
 * @version 1.0 14/07/2021
 */
public class Course
{
    // A unique identifier e.g. BT1CTG1
    private String code;
    // The full title including qualification and subject
    private String title;
    
    private Module module;
    
    /**
     * Create a Course with a maximum number of enrolments. 
     * All other details are set to unknown values.
     */
    public Course(String code, String title)
    {
        this.code = code;
        this.title = title;
    }

    
    /**
     * Print the details of the course, including the
     * course code, the title and modules
     */
    public void print()
    {
        printHeading();
        
        System.out.println(" Course Code: " + code + " Course Title: " + title);
        System.out.println();
        
        module.print();
    }
    
    /**
     * Print out the details of the course to the terminal.
     */
    private void printHeading()
    {
        System.out.println(" --------------------------------");
        System.out.println("   App211: Course Details");
        System.out.println(" --------------------------------");
        System.out.println();
    }
    
    public void addModule(Module module)
    {
        this.module = module;
    }
}
