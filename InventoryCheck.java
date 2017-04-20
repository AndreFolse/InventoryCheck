package inventorycheck;
import java.util.*;
import java.awt.EventQueue; 
import java.awt.FlowLayout; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JLabel;
public class InventoryCheck extends JFrame implements ActionListener
{
    ArrayList<InventoryItem> Inventory = new ArrayList();
    public InventoryDemo()
    {
        JButton addDirectory = new JButton("Add Directory");
        JButton removeDirectory = new JButton("Remove Directory");
        JButton addItem = new JButton("Add Item");
        JButton removeItem = new JButton("Remove Item");
        JButton setMinimum = new JButton("Set Minimum");
        JButton order = new JButton("Order");
        JFrame f = new JFrame("InventoryCheck");
        f.setLayout(new FlowLayout());
        f.setSize(1000,500);
        f.add(addDirectory);
        f.add(removeDirectory);
        f.add(addItem);
        f.add(removeItem);
        f.add(setMinimum);
        f.add(order);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
        addDirectory.addActionListener(this);
        setVisible(true);
    } 
    private static void createGUI()
    {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Inventory Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InventoryCheck pane = new InventoryCheck();
        frame.getRootPane().setDefaultButton();
        
    }
    public static void main(String[] args) 
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
        {
                public void run()
                {
                    createGUI();
                }
        }
        );
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}