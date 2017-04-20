package inventorycheck;
 /**
 * creates and updates items in inventory
 */
public class InventoryItem 
{
    /**
     * item name
     */
    private String name;   
    /**
     * the amount of an item
     */
    private int amount;    
    /**
     * the minimum amount of a item allowed
     */
    private int minimum;   
    /**
     * the item number
     */
    private int itemNumber;        
    /**
     * creates an empty item
     */
    public InventoryItem()
    {
        name = "";
        amount = 0;
        minimum = 0;
    }    
    public InventoryItem(String aName, int anAmount, int aMinimum)
    {
        name = aName;
        amount = anAmount;
        minimum = aMinimum;
    }   
    public String getName()
    {
        return name;
    }   
    public int getAmount()
    {
        return amount;
    }  
    public int getNumber()
    {
        return itemNumber;
    } 
    public void addItem(int increment)
    {
        amount += increment;
    }
    public void removeItem(int increment) throws ItemException
    {
        if(increment > amount)
            throw new ItemException("You've tried to remove more items than are listed!");
        else
            amount -= increment;
    }
    public boolean checkMin(int number)
    {
        return number >= amount;
    } 
}