package inventorycheck;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
public class InventoryCheck
{
    ArrayList<InventoryItem> inventory = new ArrayList();
    JButton button1 = new JButton("Add Directory");
    JButton button2 = new JButton("Remove Directory");
    JButton button3 = new JButton("Increase Quantity");
    JButton button4 = new JButton("Decrease Quantity");
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
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        GridBagConstraints c = new GridBagConstraints();


        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 10, 10);
        panel.add(button1, c);
        //Add Directory
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(inventory.isEmpty()){
                    inventory.add(new InventoryItem("", 0, 0));
                    inventory.get(0).erase();
                }
               
                JFrame frame1 = new JFrame("Add Directory");
                frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame1.setSize(900,200);
                JPanel panel1 = new JPanel();
                panel1.setLayout(new GridBagLayout());
                GridBagConstraints a = new GridBagConstraints();
                a.gridx = 0;
                a.gridy = 0;
                JTextField nameT = new JTextField(20);
                JTextField quantityT = new JTextField(20);
                JTextField minT = new JTextField(20);
                //JButton buttonAD = new JButton("Enter");
                //a.gridx = 4;
                //a.gridy = 4;
                frame1.add(panel1);
                panel1.add(new JLabel("Name"),a);
                a.gridx = 1;
                a.gridy = 0;
                panel1.add(nameT,a);
                a.gridx = 0;
                a.gridy = 1;
                panel1.add(new JLabel("Quantity"),a);
                a.gridx = 1;
                a.gridy = 1;
                panel1.add(quantityT,a);
                a.gridx = 0;
                a.gridy = 2;
                panel1.add(new JLabel("Minimum"),a);
                a.gridx = 1;
                a.gridy = 2;
                panel1.add(minT,a);
                a.gridx = 1;
                a.gridy = 3;
                JButton buttonAD = new JButton("Enter");
                panel1.add(buttonAD,a);
                a.gridx = 1;
                a.gridy = 4;
                JButton buttonDone = new JButton("Done");
                panel1.add(buttonDone,a);
                frame1.setVisible(true);
                buttonAD.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            if(Integer.parseInt(quantityT.getText()) < 0 || Integer.parseInt(minT.getText()) < 0)
                                throw new NullPointerException();
                            String nameIn = nameT.getText();
                            if(nameIn.length()==0)
                                throw new ArithmeticException("a");
                            int quantityIn = Integer.parseInt(quantityT.getText());
                            int minIn = Integer.parseInt(minT.getText());
                            inventory.add(new InventoryItem(nameIn, quantityIn, minIn));
                            nameT.setText("");
                            quantityT.setText("");
                            minT.setText("");
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
                            JLabel errorLabel = new JLabel("You must enter a number into quantity and minimum.");
                            errorLabel.setForeground(Color.red);
                            errorPanel.add(errorLabel);
                        } catch (ArithmeticException e1) {
                            nameT.setText("");
                            quantityT.setText("");
                            minT.setText("");
                            JFrame errorFrame = new JFrame("InventoryCheck");
                            errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            errorFrame.setSize(450, 75);
                            errorFrame.setVisible(true);
                            JPanel errorPanel = new JPanel();
                            errorFrame.add(errorPanel);
                            JLabel errorLabel = new JLabel("You must enter a name for the item");
                            errorLabel.setForeground(Color.red);
                            errorLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
                            errorPanel.add(errorLabel);
                        } catch (NullPointerException e1) {
                            nameT.setText("");
                            quantityT.setText("");
                            minT.setText("");
                            JFrame errorFrame = new JFrame("InventoryCheck");
                            errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            errorFrame.setSize(450, 75);
                            errorFrame.setVisible(true);
                            JPanel errorPanel = new JPanel();
                            errorFrame.add(errorPanel);
                            JLabel errorLabel = new JLabel("You must enter number that are greater than or equal to 0.");
                            errorLabel.setForeground(Color.red);
                            errorLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
                            errorPanel.add(errorLabel);
                        }
                    }
                });
                buttonDone.addActionListener(new ActionListener() {
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
                        String text = removeDT.getText();
                        try{
                            if(!inventory.get(Integer.parseInt(text)).doesExist())
                                throw new IndexOutOfBoundsException();
                            inventory.get(Integer.parseInt(text)).erase();
                            JFrame frameRD = new JFrame("InventoryCheck");
                            frameRD.setSize(200, 100);
                            frameRD.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            JPanel panelRD = new JPanel();
                            panelRD.add(new JLabel("Item Successfully Removed"));
                            frameRD.add(panelRD);
                            frame2.dispose();
                            frameRD.setVisible(true);
                        } catch (NumberFormatException e2) {
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
                        } catch (IndexOutOfBoundsException e1) {
                            removeDT.setText("");
                            JFrame frameRDE = new JFrame("InventoryCheck");
                            frameRDE.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frameRDE.setSize(250, 100);
                            JPanel panelRDE = new JPanel();
                            JLabel labelRDE = new JLabel("There is no item number " + text);
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
        //Increase Quantity
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame3 = new JFrame("Increase Quantity");
                JPanel panel3 = new JPanel();
                panel3.setLayout(new GridBagLayout());
                GridBagConstraints b = new GridBagConstraints();
                frame3.setSize(500, 250);
                frame3.add(panel3);
                frame3.getContentPane().add(panel3,BorderLayout.NORTH);
                b.gridx = 0;
                b.gridy = 0;
                panel3.add(new JLabel("Item Number"),b);
                JTextField itemNumber = new JTextField(10);
                b.gridx = 1;
                b.gridy = 0;
                panel3.add(itemNumber,b);
                b.gridx = 0;
                b.gridy = 1;
                panel3.add(new JLabel("Quantity To Add"),b);
                JTextField qAdd = new JTextField(10);
                b.gridx = 1;
                b.gridy = 1;
                panel3.add(qAdd,b);
                JButton buttonAdd = new JButton("Enter");
                b.gridx = 1;
                b.gridy = 2;
                panel3.add(buttonAdd,b);
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
                            if(itemNumber.getText().length() == 0 || qAdd.getText().length() == 0)
                                throw new ArithmeticException();
                            if(!inventory.get(Integer.parseInt(itemNumber.getText())).doesExist())
                                throw new NullPointerException();
                            inventory.get(Integer.parseInt(itemNumber.getText())).addItem(Integer.parseInt(qAdd.getText()));
                            addIP.add(new JLabel("Item Quantity Successfully Increased"));
                            buttonA.setText("Add Another");

                        } catch (NumberFormatException e1) {

                            addIP.add(new JLabel("You can only enter integers into the boxes."));
                            buttonA.setText("Try again");

                        } catch (NullPointerException e1){
                            addIP.add(new JLabel("There is no item number " + itemNumber.getText()));
                            buttonA.setText("Try again");
                        } catch (ArithmeticException e1 ){
                            addIP.add(new JLabel("You must enter a number in the boxes."));
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
        //Decrease Quantity
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame4 = new JFrame("Decrease Quantity");
                JPanel panel4 = new JPanel();
                panel4.setLayout(new GridBagLayout());
                GridBagConstraints d = new GridBagConstraints();
                frame4.setSize(500, 250);
                frame4.add(panel4);
                frame4.getContentPane().add(panel4, BorderLayout.NORTH);
                d.gridx = 0;
                d.gridy = 0;
                panel4.add(new JLabel("Item Number"),d);
                d.gridx = 1;
                d.gridy = 0;
                JTextField itemNumberR = new JTextField(10);
                panel4.add(itemNumberR,d);
                d.gridx = 0;
                d.gridy = 1;
                panel4.add(new JLabel("Quantity To Remove"),d);
                d.gridx = 1;
                d.gridy = 1;
                JTextField qRemove = new JTextField(10);
                panel4.add(qRemove,d);
                d.gridx = 1;
                d.gridy = 2;
                JButton buttonR = new JButton("Enter");
                panel4.add(buttonR,d);
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
                        JButton buttonRD = new JButton();
                        try{
                            if(itemNumberR.getText().length() == 0 || qRemove.getText().length() == 0)
                                throw new ArithmeticException();
                            if(!inventory.get(Integer.parseInt(itemNumberR.getText())).doesExist())
                                throw new NullPointerException();
                            inventory.get(Integer.parseInt(itemNumberR.getText())).removeItem(Integer.parseInt(qRemove.getText()));
                            removeIP.add(new JLabel("Item Quantity Successfully Decreased"));
                            buttonRD.setText("Remove Another");

                        } catch (NumberFormatException e1) {

                            removeIP.add(new JLabel("You can only enter integers into the boxes."));
                            buttonRD.setText("Try again");

                        } catch (NullPointerException e1){
                            removeIP.add(new JLabel("There is no item number " + itemNumberR.getText()));
                            buttonRD.setText("Try again");
                        } catch (ArithmeticException e1 ){
                            removeIP.add(new JLabel("You must enter a number in the boxes."));
                            buttonRD.setText("Try again");
                        } catch (ItemException e1) {
                            removeIP.add(new JLabel("You cannot remove more items than you have."));
                            buttonRD.setText("Try again");
                        }
                        removeIP.add(buttonRD);
                        itemNumberR.setText("");
                        qRemove.setText("");
                        JButton buttonRDone = new JButton("Done");
                        removeIP.add(buttonRDone);
                        frame4.setVisible(false);
                        buttonRD.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                removeIF.dispose();
                                frame4.setVisible(true);
                            }
                        });
                        buttonRDone.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                removeIF.dispose();
                                frame4.dispose();
                            }
                        });
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
                JFrame frame5 = new JFrame("Order");
                frame5.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame5.setSize(600,600);
                JPanel panel5 = new JPanel(new GridLayout(5,5,10,10));
                //JLabel order = new JLabel("Order");
                //order.setHorizontalAlignment(JLabel.CENTER);
                //order.setVerticalAlignment(JLabel.TOP);
                EmptyBorder Panelborder = new EmptyBorder(5,5,5,5);
                panel5.setBorder(Panelborder);
                EmptyBorder border = new EmptyBorder(1,3,1,2);
                LineBorder line = new LineBorder(Color.BLUE,2,true);
                CompoundBorder compound = new CompoundBorder(line, border);
                //JLabel order = new JLabel("Order");
                //order.setHorizontalAlignment(JLabel.CENTER);
                //order.setVerticalAlignment(JLabel.TOP);
                //panel5.add(order);
                frame5.add(panel5);
                //JScrollPane pane = new JScrollPane();
                //pane.add(panel5);
                //frame5.add(pane);
                ArrayList<InventoryItem> temp = new ArrayList();
                int x = 1;
                for(int i=0;i<inventory.size();i++)
                {
                    if(inventory.get(i).doesExist() && inventory.get(i).checkMin())
                    {
                        JLabel item = new JLabel(x + ") " + inventory.get(i).getName());
                        item.setBorder(compound);
                        panel5.add(item);
                        item.setHorizontalAlignment(JLabel.CENTER);
                        item.setVerticalAlignment(JLabel.CENTER);
                        //label.setFont(new Font("Serif",Font.LAYOUT_LEFT_TO_RIGHT,12));
                        x++;
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
                JFrame frame6 = new JFrame("Search");
                frame6.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                JTextField itemNumberT = new JTextField(10);
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
                        JFrame frameS = new JFrame("Search");
                        frameS.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        frameS.setSize(500, 100);
                        JPanel panelS = new JPanel();
                        frameS.add(panelS);
                        try {
                            if (!inventory.get(Integer.parseInt(itemNumberT.getText())).doesExist())
                                throw new IndexOutOfBoundsException();
                            panelS.add(new JLabel("Item: " + itemNumberT.getText() + ":"));
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
                        } catch (IndexOutOfBoundsException e1) {
                            itemNumberT.setText("");
                            panelS.add(new JLabel("There is no item number " + itemNumberT.getText()));
                            frameS.setVisible(true);
                        } catch (ArithmeticException e2) {
                            itemNumberT.setText("");
                            panelS.add(new JLabel("There is no item number " + itemNumberT.getText()));
                            frameS.setVisible(true);
                        } catch (NumberFormatException e3) {
                            itemNumberT.setText("");
                            panelS.add(new JLabel("You must enter a number."));
                            frameS.setVisible(true);
                        }
                    }
                });
            }
        });
    }
}
