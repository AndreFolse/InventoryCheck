package inventorycheck;
public class ItemException extends Exception 
{
    /**
     * Creates a new instance of <code>ItemException</code> without detail
     * message.
     */
    public ItemException() 
    {
        super();
    }
    /**
     * Constructs an instance of <code>ItemException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public ItemException(String msg) 
    {
        super(msg);
    }
}
