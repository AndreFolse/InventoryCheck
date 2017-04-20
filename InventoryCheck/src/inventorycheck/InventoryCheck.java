package inventorycheck;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class InventoryCheck implements ActionListener {
    JButton button1 = new JButton("Add Directory ");
    JButton button2 = new JButton("Remove Directory ");
    JButton button3 = new JButton("Add Item");
    JButton button4 = new JButton("Remove Item");
    JButton button5 = new JButton("Order");
    JButton button6 = new JButton("Search");
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InventoryCheck().createGui();
            }
        });

    }

    public void createGui() {
        JFrame frame = new JFrame("InventoryCheck");
        frame.setSize(300, 350);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridBagLayout());
        frame.add(panel);
        frame.getContentPane().add(panel, BorderLayout.WEST);
        GridBagConstraints c = new GridBagConstraints();

        
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 10, 10);
        panel.add(button1, c);
        button1.addActionListener(this);

       
        c.gridx = 0;
        c.gridy = 1;
        panel.add(button2, c);
        button2.addActionListener(this);

        
        c.gridx = 0;
        c.gridy = 2;
        panel.add(button3, c);
        button3.addActionListener(this);

        
        c.gridx = 0;
        c.gridy = 3;
        panel.add(button4, c);
        button4.addActionListener(this);
        
        
        c.gridx = 0;
        c.gridy = 4;
        panel.add(button5, c);
        button5.addActionListener(this);
        
        
        c.gridx = 0;
        c.gridy = 5;
        panel.add(button6, c);
        button6.addActionListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame2 = new JFrame("InventoryCheck");
        JFrame frame3 = new JFrame("InventoryCheck");
        JFrame frame4 = new JFrame("InventoryCheck");
        JFrame frame5 = new JFrame("InventoryCheck");
        JFrame frame6 = new JFrame("InventoryCheck");
        JFrame frame7 = new JFrame("InventoryCheck");
        JLabel label1 = new JLabel("Add Directory");
        JLabel label2 = new JLabel("Remove Directory");
        JLabel label3 = new JLabel("Add Item");
        JLabel label4 = new JLabel("Remove Item");
        JLabel label5 = new JLabel("Order");
        JLabel label6 = new JLabel("Search");
        frame2.setVisible(true);
        frame2.setSize(600, 600);
        JPanel panel = new JPanel();
        if(button1.isEnabled())
        {
            frame2.add(panel);
            panel.add(label1);
        }
        else if(button2.isEnabled())
        {
            JPanel panel2 = new JPanel();
            frame3.add(panel2);
            panel2.add(label2);
        }
        else if(button3.isEnabled())
        {
            frame4.add(panel);
            panel.add(label3);
        }
        else if(button4.isEnabled())
        {
            frame5.add(panel);
            panel.add(label4);
        }
        else if(button5.isEnabled())
        {
            frame6.add(panel);
            panel.add(label5);
        }
        else
        {
            frame7.add(panel);
            panel.add(label6);
        }
        
    }
}