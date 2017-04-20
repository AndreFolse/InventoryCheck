package inventorycheck;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InventoryCheck implements ActionListener {

    ArrayList<InventoryItem> inventory = new ArrayList();

    JButton button1 = new JButton("Add Directory ");
    JButton button2 = new JButton("Remove Directory ");
    JButton button3 = new JButton("Add Item");
    JButton button4 = new JButton("Remove Item");
    JButton button5 = new JButton("Order");
    JButton button6 = new JButton("Search");


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {new InventoryCheck().createGui();
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


    JFrame frame1 = new JFrame("InventoryCheck");

    @Override
    public void actionPerformed(ActionEvent e) {

        JLabel name = new JLabel("Name");
        JLabel quantity = new JLabel("Quantity");
        JLabel min = new JLabel("Minimum");
        JTextField nameT = new JTextField(25);
        JTextField quantityT = new JTextField(25);
        JTextField minT = new JTextField(25);
        JButton buttonAD = new JButton("Enter");


        if(e.getSource() == button1)
        {
            frame1.setVisible(false);
            JLabel label1 = new JLabel("Add Directory");
            frame1.setVisible(true);
            frame1.setSize(600,600);
            JPanel panel1 = new JPanel();
            panel1.add(label1);
            frame1.add(panel1);
            frame1.getContentPane().add(panel1, BorderLayout.WEST);
            GridBagConstraints c1 = new GridBagConstraints();
            c1.gridx = 0;
            c1.gridy = 0;
            c1.insets = new Insets(10, 10, 10, 10);


            c1.gridx = 0;
            c1.gridy = 0;
            panel1.add(name, c1);
            c1.gridx = 0;
            c1.gridy = 1;
            panel1.add(nameT, c1);

            c1.gridx = 0;
            c1.gridy = 2;
            panel1.add(quantity, c1);
            c1.gridx = 0;
            c1.gridy = 3;
            panel1.add(quantityT, c1);

            c1.gridx = 0;
            c1.gridy = 4;
            panel1.add(min, c1);
            c1.gridx = 0;
            c1.gridy = 5;
            panel1.add(minT, c1);

            c1.gridx = 0;
            c1.gridy = 6;
            panel1.add(buttonAD, c1);
            if()
                buttonAD.addActionListener(this);

        }
        else if(e.getSource() == button2)
        {
            JFrame frame2 = new JFrame("InventoryCheck");
            JLabel label2 = new JLabel("Remove Directory");
            frame2.setVisible(true);
            frame2.setSize(600,600);
            JPanel panel2 = new JPanel();
            panel2.add(label2);
            frame2.add(panel2);
            //panel2.add(label2);


            /*
            JPanel panel2 = new JPanel();
            frame3.add(panel2);
            panel2.add(label2);
            */
        }
        else if(e.getSource() == button3)
        {
            JFrame frame3 = new JFrame("InventoryCheck");
            JLabel label3 = new JLabel("Add Item");
            frame3.setVisible(true);
            frame3.setSize(600,600);
            JPanel panel3 = new JPanel();
            panel3.add(label3);
            frame3.add(panel3);
            //frame4.add(panel);
            //panel.add(label3);
        }
        else if(e.getSource() == button4)
        {
            JFrame frame4 = new JFrame("InventoryCheck");
            JLabel label4 = new JLabel("Remove Item");
            frame4.setVisible(true);
            frame4.setSize(600,600);
            JPanel panel4 = new JPanel();
            panel4.add(label4);
            frame4.add(panel4);
            //frame5.add(panel);
            //panel.add(label4);
        }
        else if(e.getSource() == button5)
        {
            JFrame frame5 = new JFrame("InventoryCheck");
            JLabel label5 = new JLabel("Order");
            frame5.setVisible(true);
            frame5.setSize(600,600);
            JPanel panel5 = new JPanel();
            panel5.add(label5);
            frame5.add(panel5);
            //frame6.add(panel);
            //panel.add(label5);
        }
        else if(e.getSource() == button6)
        {
            JFrame frame5 = new JFrame("InventoryCheck");
            JLabel label5 = new JLabel("Search");
            frame5.setVisible(true);
            frame5.setSize(600,600);
            JPanel panel5 = new JPanel();
            panel5.add(label5);
            frame5.add(panel5);
            //frame7.add(panel);
            //panel.add(label6);
        }

        else if(e.getSource() == buttonAD)
        {
            String nameIn = nameT.getText();
            int quantityIn = Integer.parseInt(quantityT.getText());
            int minIn = Integer.parseInt(minT.getText());
            inventory.add(new InventoryItem(nameIn, quantityIn, minIn));
            frame1.setVisible(false);
        }


    }
}
