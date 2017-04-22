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
     * Whether or not an item exists
     */
    private boolean exists;
    /**
     * creates an empty item
     */
    public InventoryItem(String aName, int anAmount, int aMinimum)
    {
        name = aName;
        amount = anAmount;
        minimum = aMinimum;
        exists = true;
    }
    public String getName()
    {
        return name;
    }
    public int getAmount()
    {
        return amount;
    }
    public int getMinimum() {return minimum;}
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
    public void erase(){
        exists = false;
    }
    public boolean checkMin()
    {
        return minimum >= amount;
    }
    public boolean doesExist(){
        return exists;
    } 
}