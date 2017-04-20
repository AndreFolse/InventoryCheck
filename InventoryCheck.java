package inventorycheck;
import java.util.*;
import java.awt.EventQueue; 
import java.awt.FlowLayout; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JLabel;
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
        frame.setSize(1000, 1000);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridBagLayout());
        frame.add(panel);
        frame.getContentPane().add(panel, BorderLayout.WEST);
        GridBagConstraints c = new GridBagConstraints();

        JButton button1 = new JButton("Add Directory ");
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(40, 40, 40, 40);
        panel.add(button1, c);
        button1.addActionListener(this);

        JButton button2 = new JButton("Remove Directory");
        c.gridx = 0;
        c.gridy = 1;
        panel.add(button2, c);
        button2.addActionListener(this);

        JButton button3 = new JButton("Add Item");
        c.gridx = 0;
        c.gridy = 2;
        panel.add(button3, c);
        button3.addActionListener(this);

        JButton button4 = new JButton("Remove Item");
        c.gridx = 0;
        c.gridy = 3;
        panel.add(button4, c);
        button4.addActionListener(this);

        JButton button5 = new JButton("Set Minimum");
        c.gridx = 0;
        c.gridy = 4;
        panel.add(button5, c);
        button5.addActionListener(this);
        
        JButton button6 = new JButton("Order");
        c.gridx = 0;
        c.gridy = 5;
        panel.add(button6, c);
        button6.addActionListener(this);
        
        JButton button7 = new JButton("Search");
        c.gridx = 0;
        c.gridy = 6;
        panel.add(button7, c);
        button7.addActionListener(this);
    }
    

    public void actionPerformed(ActionEvent e) {
        JFrame frame2 = new JFrame("InventoryCheck");
        frame2.setVisible(true);
        frame2.setSize(600, 600);
        JLabel label = new JLabel("InventoryCheck");
        JPanel panel = new JPanel();
        frame2.add(panel);
        panel.add(label);
    }
}
