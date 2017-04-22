package inventorycheck;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InventoryCheck
{
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
        //Add Directory
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame1 = new JFrame("Add Directory");
                frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame1.setSize(900,200);
                JPanel panel1 = new JPanel();
                JTextField nameT = new JTextField(20);
                JTextField quantityT = new JTextField(10);
                JTextField minT = new JTextField(10);
                JButton buttonAD = new JButton("Enter");
                //panel1.add(new JLabel("Add Directory"));
                frame1.add(panel1);
                panel1.add(new JLabel("Name"));
                panel1.add(nameT);
                panel1.add(new JLabel("Quantity"));
                panel1.add(quantityT);
                panel1.add(new JLabel("Minimum"));
                panel1.add(minT);
                panel1.add(buttonAD);
                JButton buttonADDone = new JButton("Done");
                panel1.add(buttonADDone);
                frame1.setVisible(true);
                buttonAD.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            String nameIn = nameT.getText();
                            int quantityIn = Integer.parseInt(quantityT.getText());
                            int minIn = Integer.parseInt(minT.getText());
                            inventory.add(new InventoryItem(nameIn, quantityIn, minIn));
                            nameT.setText("");
                            quantityT.setText("");
                            minT.setText("");
                            //frame1.dispose();
                        } catch (NumberFormatException e1) {
                            nameT.setText("");
                            quantityT.setText("");
                            minT.setText("");
                            JFrame errorFrame = new JFrame("InventoryCheck");
                            errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            errorFrame.setSize(450, 75);
                            errorFrame.setVisible(true);
                            JPanel errorPanel = new JPanel();
                            errorFrame.add(errorPanel);
                            JLabel errorLabel = new JLabel("You must enter integers into quantity and minimum.");
                            errorLabel.setForeground(Color.red);
                            errorPanel.add(errorLabel);
                        }
                    }
                });
                buttonADDone.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame1.dispose();
                    }
                });

            }
        });


        c.gridx = 0;
        c.gridy = 1;
        panel.add(button2, c);
        //Remove Directory
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame2 = new JFrame("Remove Directory");
                frame2.setSize(500,100);
                JPanel panel2 = new JPanel();
                frame2.add(panel2);
                panel2.add(new JLabel("Enter Item Number"));
                JTextField removeDT = new JTextField(10);
                panel2.add(removeDT);
                JButton buttonRD = new JButton("Enter");
                panel2.add(buttonRD);
                frame2.setVisible(true);
                buttonRD.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            inventory.get(Integer.parseInt(removeDT.getText())).erase();
                            JFrame frameRD = new JFrame("InventoryCheck");
                            frameRD.setSize(200, 100);
                            frameRD.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            JPanel panelRD = new JPanel();
                            panelRD.add(new JLabel("Item Successfully Removed"));
                            frameRD.add(panelRD);
                            frame2.dispose();
                            frameRD.setVisible(true);
                        }catch (NumberFormatException e2) {
                            removeDT.setText("");
                            JFrame frameRDE = new JFrame("InventoryCheck");
                            frameRDE.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frameRDE.setSize(250, 100);
                            JPanel panelRDE = new JPanel();
                            JLabel labelRDE = new JLabel("Item number must be an integer.");
                            labelRDE.setForeground(Color.red);
                            panelRDE.add(labelRDE);
                            frameRDE.add(panelRDE);
                            frameRDE.setVisible(true);
                        }
                    }
                });



            }
        });


        c.gridx = 0;
        c.gridy = 2;
        panel.add(button3, c);
        //Add Item
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame3 = new JFrame("Add Item");
                JPanel panel3 = new JPanel();
                frame3.setSize(500, 100);
                frame3.add(panel3);
                panel3.add(new JLabel("Item Number:"));
                JTextField itemNumber = new JTextField(10);
                panel3.add(itemNumber);
                panel3.add(new JLabel("Quantity To Add"));
                JTextField qAdd = new JTextField(10);
                panel3.add(qAdd);
                JButton buttonAdd = new JButton("Enter");
                panel3.add(buttonAdd);
                frame3.setVisible(true);
                buttonAdd.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame addIF = new JFrame("InventoryCheck");
                        addIF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        addIF.setSize(500, 100);
                        JPanel addIP = new JPanel();
                        addIF.add(addIP);
                        addIF.setVisible(true);
                        JButton buttonA = new JButton();
                        try{

                            inventory.get(Integer.parseInt(itemNumber.getText())).addItem(Integer.parseInt(qAdd.getText()));
                            addIP.add(new JLabel("Item Quantity Successfully Increased"));
                            buttonA.setText("Add Another");

                        } catch (NumberFormatException e1) {

                            addIP.add(new JLabel("You can only enter integers into the boxes."));
                            buttonA.setText("Try again");

                        }
                        addIP.add(buttonA);
                        itemNumber.setText("");
                        qAdd.setText("");
                        JButton buttonADone = new JButton("Done");
                        addIP.add(buttonADone);
                        frame3.setVisible(false);
                        buttonA.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                addIF.dispose();
                                frame3.setVisible(true);
                            }
                        });
                        buttonADone.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                addIF.dispose();
                                frame3.dispose();
                            }
                        });

                    }
                });


            }
        });


        c.gridx = 0;
        c.gridy = 3;
        panel.add(button4, c);
        //Remove Item
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame4 = new JFrame("Remove Item");
                JPanel panel4 = new JPanel();
                frame4.setSize(500, 100);
                frame4.add(panel4);
                panel4.add(new JLabel("Item Number:"));
                JTextField itemNumberR = new JTextField(10);
                panel4.add(itemNumberR);
                panel4.add(new JLabel("Quantity To Remove"));
                JTextField qRemove = new JTextField(10);
                panel4.add(qRemove);
                JButton buttonR = new JButton("Enter");
                panel4.add(buttonR);
                frame4.setVisible(true);
                buttonR.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame removeIF = new JFrame("InventoryCheck");
                        removeIF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        removeIF.setSize(500, 100);
                        JPanel removeIP = new JPanel();
                        removeIF.add(removeIP);
                        removeIF.setVisible(true);
                        try{

                            inventory.get(Integer.parseInt(itemNumberR.getText())).removeItem(Integer.parseInt(qRemove.getText()));
                            removeIP.add(new JLabel("Item Quantity Successfully Decreased"));

                        } catch (NumberFormatException e1) {

                            removeIP.add(new JLabel("You can only enter integers into the boxes."));

                        } catch (ItemException e1) {
                            removeIP.add(new JLabel("You cannot remove more items than you have."));
                        }
                        itemNumberR.setText("");
                        qRemove.setText("");
                    }
                });

            }
        });


        c.gridx = 0;
        c.gridy = 4;
        panel.add(button5, c);
        //Order
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame5 = new JFrame("InventoryCheck");
                frame5.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame5.setSize(600,600);
                JPanel panel5 = new JPanel();
                panel5.add(new JLabel("Order"));
                frame5.add(panel5);
                //JScrollPane pane = new JScrollPane();
                //pane.add(panel5);
                //frame5.add(pane);
                ArrayList<InventoryItem> temp = new ArrayList();
                for(int i=0;i<inventory.size();i++)
                {
                    if(inventory.get(i).doesExist() && inventory.get(i).checkMin())
                    {
                        panel5.add(new JLabel(inventory.get(i).getName()));
                    }
                }
                frame5.setVisible(true);
            }
        });


        c.gridx = 0;
        c.gridy = 5;
        panel.add(button6, c);
        //Search
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame6 = new JFrame("InventoryCheck");
                frame6.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                JTextField itemNumberT = new JTextField(10);
                //JLabel label6 = new JLabel("Search");
                frame6.setVisible(true);
                frame6.setSize(500,100);
                JPanel panel6 = new JPanel();
                panel6.add(new JLabel("Search"));
                frame6.add(panel6);
                panel6.add(new JLabel("Item Number"));
                panel6.add(itemNumberT);
                JButton buttonS = new JButton("Search");
                panel6.add(buttonS);
                buttonS.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame frameS = new JFrame("InventoryCheck");
                        frameS.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        frameS.setSize(500, 100);
                        JPanel panelS = new JPanel();
                        panelS.add(new JLabel("Item " + itemNumberT.getText() + ":"));
                        panelS.add(new JLabel("Name: " + inventory.get(Integer.parseInt(itemNumberT.getText())).getName()));
                        panelS.add(new JLabel("Quantity: " + inventory.get(Integer.parseInt(itemNumberT.getText())).getAmount()));
                        panelS.add(new JLabel("Minimum: " + inventory.get(Integer.parseInt(itemNumberT.getText())).getMinimum()));
                        frameS.add(panelS);
                        JButton buttonSA = new JButton("Search Again");
                        panelS.add(buttonSA);
                        frameS.setVisible(true);
                        frame6.dispose();
                        buttonSA.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                itemNumberT.setText("");
                                frameS.dispose();
                                frame6.setVisible(true);
                            }
                        });

                    }
                });
            }
        });
    }
}
