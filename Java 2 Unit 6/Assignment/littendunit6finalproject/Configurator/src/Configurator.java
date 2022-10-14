/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 431 - Java Programming Principles II
    Mr. Terrell Hebert
    May 7, 2022
*/

/*
    This program creates a GUI application called a Configurator.
    it allows the user to complete the configuration of a computer
    system and produce a sales prices for the system based on the
    configuration selected.  The application allows the user to select
    components from combo boxes, radio buttons and check boxes.  It allows
    the user to use a calulate button to fine the tax, shipping and handling,
    and total price of their configuration.  It has a clear button to allow
    the user to clear all entries and begin over.  It calculates the subtotal
    based on what components are currently selected.  It has an order button,
    that when clicked shows the user the current components, prices of
    components, and totals.  If the user selects yes, the order is processed
    and the user is given a random order number.  If the user selects no,
    they are returned to the GUI to make changes or print or exit.  When the
    user selects the exit button or closes the frame, the application exits.
    If the user selects the print button, the current configuration, prices,
    and totals are printed/displayed to the user as a summary of the
    configuration
 */

// Required import statements
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Configurator extends JFrame {
    private JRadioButton radioButtonIntel;          // User selects Intel
    private JRadioButton radioButtonAMD;            // User selects AMD
    private JLabel pickBaseModelLabel;              // Tells user to select a radio button
    private JPanel panel;                           // Holding panel
    private JLabel baseModelLabel;                  // Tells user the below is specs for base model
    private JLabel cpuLabel;                        // Tells user the textField is for base model CPU
    private JLabel ramLabel;                        // Tells user the textField is for base model RAM
    private JLabel hardDriveLabel;                  // Tells user the textField is for base model hard drive
    private JLabel secondaryStorageLabel;           // Tells user the textField is for base model secondary storage
    private JLabel audioLabel;                      // Tells user the textField is for base model audio
    private JLabel osLabel;                         // Tells user the textField is for base model operating system
    private JLabel speakerLabel;                    // Tells user the textField is for base model speaker
    private JLabel keyboardLabel;                   // Tells user the textField is for base model keyboard
    private JLabel mouseLabel;                      // Displays base model cpu
    private JTextField cpuTextField;                // Displays base model cpu
    private JTextField ramTextField;                // Displays base model ram
    private JTextField hardDriveTextField;          // Displays base model hard drive
    private JTextField secondaryStorageTextField;   // Displays base model cpu secondary storage
    private JTextField audioTextField;              // Displays base model audio
    private JTextField osTextField;                 // Displays base model operating system
    private JTextField speakerTextField;            // Displays base model speakers
    private JTextField keyboardTextField;           // Displays base model keyboard
    private JTextField mouseTextField;              // Displays base model mouse
    private JLabel userIntelCpuLabel;                    // Tells user the comboBox/textField is for cpu selection
    private JLabel userRamLabel;                    // Tells user the comboBox/textField is for ram selection
    private JLabel userHardDriveLabel;              // Tells user the comboBox/textField is for hard drive selection
    private JLabel userSecondaryStorageLabel;    // Tells user the comboBox/textField is for secondary storage selection
    private JLabel userOsLabel;                  // Tells user the comboBox/textField is for operating system selection
    private JLabel userSelectionLabel;              // Tells user the below is their selected components
    private JComboBox intelCpuComboBox;                  // To select cpu
    private JComboBox ramComboBox;                  // To select ram
    private JComboBox hardDriveComboBox;            // To select hard drive
    private JComboBox secondaryStorageComboBox;     // To select secondary storage
    private JLabel costLabel;                       // Tells user the below is their selected components costs
    private JTextField intelCpuCostTextField;            // Tells user the additional cost for select component
    private JTextField ramCostTextField;            // Tells user the additional cost for select component
    private JTextField hardDriveCostTextField;      // Tells user the additional cost for select component
    private JTextField secondaryStorageCostTextField;   // Tells user the additional cost for select component
    private JTextField osCostTextField;             // Tells user the additional cost for select component
    private JTextField totalBeforeShipTextField;        // Tells user the additional cost for select component
    private JTextField baseModelCostTextField;      // Tells user the base model cost
    private JLabel baseModelCostLabel;              // Tells user the textField is for base model cost
    private JLabel subTotalLabel;                   // Tells user the textField is for subtotal cost
    private JTextField subTotalTextField;           // Tells user the subtotal
    private JLabel taxLabel;                        // Tells user the textField is for tax cost
    private JTextField taxTextField;                // Tells user the tax cost
    private JLabel totalBeforeShipLabel;                      // Tells user the textField is for total cost
    private JButton clearButton;                    // Lets user clear all selections and start over
    private JButton orderButton;                    // Lets user "order"
    private JButton calculateTaxShippingTotalButton;                // Lets user calculate total
    private JTextField amdGraphicsTextField;        // holds amd graphics base
    private JComboBox gpuComboBox;                  // To select gpu
    private JRadioButton osRadioButton1;            // To select os
    private JRadioButton osRadioButton2;            // To select os
    private JRadioButton osRadioButton3;            // To select os
    private JCheckBox appPackageCheckBox1;          // To select application package
    private JCheckBox appPackageCheckBox4;          // To select application package
    private JCheckBox appPackageCheckBox3;          // To select application package
    private JCheckBox appPackageCheckBox2;          // To select application package
    private JLabel amdGraphicsLabel;                // Tell user what the textField is for
    private JLabel userGPULabel;                    // Tell user what the textField is for
    private JTextField gpuCostTextField;            // Holds cost for selected gpu
    private JLabel appPackageLabel;                 // Tell user what the checkboxes are for
    private JTextField appPackageCostTextField;     // Holds cost for select app package
    private JLabel userAmdCpuLabel;                 // Tell user what combobox is for
    private JComboBox amdCpuComboBox;               // To select amd cpu
    private JTextField amdCpuCostTextField;         // Holds cost for amd cpu
    private JTextField shippingHandlingTextField;   // Holds cost for shipping and handling
    private JLabel shippingHandlingLabel;           // Tells user what textField is for
    private JTextField totalTextField;              // Holds total cost
    private JLabel totalLabel;                      // Tells user what the textField is for
    private JButton exitButton;                     // To exit the application
    private JButton printButton;                    // To print a summary of the configuration

    /*
        Constructor
     */

    public Configurator() {
        // Decimal formatter
        DecimalFormat df = new DecimalFormat("0.00");

        // group base choice radio buttons
        ButtonGroup baseRadioButtonGroup = new ButtonGroup();
        baseRadioButtonGroup.add(radioButtonAMD);
        baseRadioButtonGroup.add(radioButtonIntel);

        // group os choice radio buttons
        ButtonGroup osRadioButtonGroup = new ButtonGroup();
        osRadioButtonGroup.add(osRadioButton1);
        osRadioButtonGroup.add(osRadioButton2);
        osRadioButtonGroup.add(osRadioButton3);

        // group app package check boxes
        ButtonGroup appPackageButtonGroup = new ButtonGroup();
        appPackageButtonGroup.add(appPackageCheckBox1);
        appPackageButtonGroup.add(appPackageCheckBox2);
        appPackageButtonGroup.add(appPackageCheckBox3);
        appPackageButtonGroup.add(appPackageCheckBox4);

        // add action listeners to the radio buttons
        radioButtonIntel.addActionListener(new RadioButtonListener());
        radioButtonAMD.addActionListener(new RadioButtonListener());

        // set all cost text fields to 0 initially
        double intelInitialCpuCost = 0;
        intelCpuCostTextField.setText("" + df.format(intelInitialCpuCost));
        double amdInitialCpuCost = 0;
        amdCpuCostTextField.setText("" + df.format(amdInitialCpuCost));
        double ramInitialCost = 0;
        ramCostTextField.setText("" + df.format(ramInitialCost));
        double hardDriveInitialCost = 0;
        hardDriveCostTextField.setText("" + df.format(hardDriveInitialCost));
        double gpuInitialCost = 0;
        gpuCostTextField.setText("" + df.format(gpuInitialCost));
        double secondaryStorageInitialCost = 0;
        secondaryStorageCostTextField.setText("" + df.format(secondaryStorageInitialCost));
        double osInitialCost = 0;
        osCostTextField.setText("" + df.format(osInitialCost));
        double appPackageInitialCost = 0;
        appPackageCostTextField.setText("" + df.format(appPackageInitialCost));
        double baseModelInitialCosts = 0;
        baseModelCostTextField.setText("" + df.format(baseModelInitialCosts));
        double initialSubtotalCost = 0;
        subTotalTextField.setText("" + df.format(initialSubtotalCost));
        double initialTaxCost = 0;
        taxTextField.setText("" + df.format(initialTaxCost));
        double initialShipCost = 0;
        shippingHandlingTextField.setText("" + df.format(initialShipCost));
        double initialTotalBeforeShipCost = 0;
        totalBeforeShipTextField.setText("" + df.format(initialTotalBeforeShipCost));
        double initialTotalCost = 0;
        totalTextField.setText("" + df.format(initialTotalCost));

        // create action listener to calculate tax, shipping/handling and total
        calculateTaxShippingTotalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final double TAX = 0.078;       // tax rate
                final double SHIP = 0.025;      // ship and handle rate
                double taxCost;                 // tax cost
                double shipCost;                // ship and handle cost
                double subtotalCost;            // subtotal cost
                double totalBeforeShipCost;     // total cost before shipping
                double totalCost;               // total cost after shipping

                // calculate tax
                subtotalCost = Double.parseDouble(subTotalTextField.getText());
                taxCost = subtotalCost * TAX;

                // calculate total before shipping
                totalBeforeShipCost = taxCost + subtotalCost;

                // calculate ship and handle
                shipCost = totalBeforeShipCost * SHIP;

                // calculate total
                totalCost = totalBeforeShipCost + shipCost;

                // display tax/ship/total in respective text fields
                taxTextField.setText("" + df.format(taxCost));
                totalBeforeShipTextField.setText("" + df.format(totalBeforeShipCost));
                shippingHandlingTextField.setText("" + df.format(shipCost));
                totalTextField.setText("" + df.format(totalCost));

            }
        });

        // create action listener to clear all entries and begin over
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // set base model radio buttons to not selected
                baseRadioButtonGroup.clearSelection();

                // set os radio buttons to not selected
                osRadioButtonGroup.clearSelection();

                // set app package check boxes to not selected
                appPackageButtonGroup.clearSelection();

                // set base model components text fields to blank
                cpuTextField.setText("");
                ramTextField.setText("");
                hardDriveTextField.setText("");
                amdGraphicsTextField.setText("");
                secondaryStorageTextField.setText("");
                audioTextField.setText("");
                osTextField.setText("");
                speakerTextField.setText("");
                keyboardTextField.setText("");
                mouseTextField.setText("");

                // set cost text fields back to 0.00
                double intelClearCpuCost = 0;
                intelCpuCostTextField.setText("" + df.format(intelClearCpuCost));
                double amdClearCpuCost = 0;
                amdCpuCostTextField.setText("" + df.format(amdClearCpuCost));
                double ramClearCost = 0;
                ramCostTextField.setText("" + df.format(ramClearCost));
                double hardDriveClearCost = 0;
                hardDriveCostTextField.setText("" + df.format(hardDriveClearCost));
                double gpuClearCost = 0;
                gpuCostTextField.setText("" + df.format(gpuClearCost));
                double secondaryStorageClearCost = 0;
                secondaryStorageCostTextField.setText("" + df.format(secondaryStorageClearCost));
                double osClearCost = 0;
                osCostTextField.setText("" + df.format(osClearCost));
                double appPackageClearCost = 0;
                appPackageCostTextField.setText("" + df.format(appPackageClearCost));
                double baseModelClearCosts = 0;
                baseModelCostTextField.setText("" + df.format(baseModelClearCosts));
                double clearSubtotalCost = 0;
                subTotalTextField.setText("" + df.format(clearSubtotalCost));
                double clearTaxCost = 0;
                taxTextField.setText("" + df.format(clearTaxCost));
                double clearShipCost = 0;
                shippingHandlingTextField.setText("" + df.format(clearShipCost));
                double clearTotalBeforeShipCost = 0;
                totalBeforeShipTextField.setText("" + df.format(clearTotalBeforeShipCost));
                double clearTotalCost = 0;
                totalTextField.setText("" + df.format(clearTotalCost));

                // set combo boxes to original (0 sub)
                intelCpuComboBox.setSelectedIndex(0);
                amdCpuComboBox.setSelectedIndex(0);
                ramComboBox.setSelectedIndex(0);
                hardDriveComboBox.setSelectedIndex(0);
                gpuComboBox.setSelectedIndex(0);
                secondaryStorageComboBox.setSelectedIndex(0);
            }
        });

        // create exit button action listener to close the application
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Order confirmation, dialog, and print


    }

    // RadioButtonListener inner class
    private class RadioButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Decimal formatter
            DecimalFormat df = new DecimalFormat("0.00");

            // Determine which radio button was clicked
            if (radioButtonIntel.isSelected()) {
                // Create a read-only text field for base cpu
                cpuTextField.setEditable(false);
                cpuTextField.setText("Intel Celeron processor G1610");

                // Create a read-only text field for base ram
                ramTextField.setEditable(false);
                ramTextField.setText("Memory-4GB Dual Channel DDR3 1600MHz-1 DIMMs");

                // Create a read-only text field for base hard drive
                hardDriveTextField.setEditable(false);
                hardDriveTextField.setText("125GB 7200RPM SATA 3.0Gb/s Hard Drive");

                // Create a read-only text field for base AMD Graphics
                amdGraphicsTextField.setEditable(false);
                amdGraphicsTextField.setText("");

                // Create a read-only text field for base secondary storage
                secondaryStorageTextField.setEditable(false);
                secondaryStorageTextField.setText("CD-ROM Drive");

                // Create a read-only text field for base audio
                audioTextField.setEditable(false);
                audioTextField.setText("Integrated Audio");

                // Create a read-only text field for base operating system
                osTextField.setEditable(false);
                osTextField.setText("Microsoft Windows 8.1 OS");

                // Create a read-only text field for base speaker
                speakerTextField.setEditable(false);
                speakerTextField.setText("2 Piece Powered Speaker Set");

                // Create a read-only text field for base keyboard
                keyboardTextField.setEditable(false);
                keyboardTextField.setText("USB Wired Entry Keyboard");

                // Create a read-only text field for base mouse
                mouseTextField.setEditable(false);
                mouseTextField.setText("USB Optical Mouse");

                // Create a read-only text field for base model cost
                baseModelCostTextField.setEditable(false);
                double baseModelCost = 499;      // The price to add to baseModelCostTextField
                baseModelCostTextField.setText("" + df.format(baseModelCost));


                // Create action listener for intelCpuComboBox for intelCpuCostTextField to use
                intelCpuComboBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Get selected combobox item
                        String cpuSelection = (String) intelCpuComboBox.getSelectedItem();

                        // set amdCpuCostTextField to 0
                        double amdCpuCost = 0;
                        amdCpuCostTextField.setText("" + df.format(amdCpuCost));

                        // if statement to disable amdCpuComboBox
                        if (radioButtonIntel.isSelected()) {
                            amdCpuComboBox.setEnabled(false);
                        } else {
                            amdCpuComboBox.setEnabled(true);
                        }

                        // If statement to determine price of selected item in intelCpuComboBox
                        if (Objects.equals(cpuSelection, "Select one below:")) {
                            double addIntelCpuCost = 0;      // The price to add to intelCpuCostTextField
                            intelCpuCostTextField.setText("" + df.format(addIntelCpuCost));
                        } else if (Objects.equals(cpuSelection, "Intel Celeron processor G1610 (Base Model)")) {
                            double addIntelCpuCost = 0;      // The price to add to intelCpuCostTextField
                            intelCpuCostTextField.setText("" + df.format(addIntelCpuCost));
                        } else if (Objects.equals(cpuSelection, "G1620 2.70GHz")) {
                            double addIntelCpuCost = 50;     // The price to add to intelCpuCostTextField
                            intelCpuCostTextField.setText("" + df.format(addIntelCpuCost));
                        } else if (Objects.equals(cpuSelection, "G1630 2.80GHz")) {
                            double addIntelCpuCost = 90;     // The price to add to intelCpuCostTextField
                            intelCpuCostTextField.setText("" + df.format(addIntelCpuCost));
                        } else if (Objects.equals(cpuSelection, "G1820 2.70GHz")) {
                            double addIntelCpuCost = 105;    // The price to add to intelCpuCostTextField
                            intelCpuCostTextField.setText("" + df.format(addIntelCpuCost));
                        } else if (Objects.equals(cpuSelection, "G1830 2.80GHz")) {
                            double addIntelCpuCost = 130;    // The price to add to intelCpuCostTextField
                            intelCpuCostTextField.setText("" + df.format(addIntelCpuCost));
                        }
                    }
                });

                // Create action listener for ramComboBox for ramCostTextField to use
                ramComboBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Get selected combobox item
                        String ramSelection = (String) ramComboBox.getSelectedItem();

                        // If statement to determine price of selected item in ramComboBox
                        if (Objects.equals(ramSelection, "Select one below:")) {
                            double addRamCost = 0;      // The price to add to ramCostTextField
                            ramCostTextField.setText("" + df.format(addRamCost));
                        } else if (Objects.equals(ramSelection, "4GB (Base Model)")) {
                            double addRamCost = 0;      // The price to add to ramCostTextField
                            ramCostTextField.setText("" + df.format(addRamCost));
                        } else if (Objects.equals(ramSelection, "6GB")) {
                            double addRamCost = 28;     // The price to add to ramCostTextField
                            ramCostTextField.setText("" + df.format(addRamCost));
                        } else if (Objects.equals(ramSelection, "8GB")) {
                            double addRamCost = 58;     // The price to add to ramCostTextField
                            ramCostTextField.setText("" + df.format(addRamCost));
                        } else if (Objects.equals(ramSelection, "12GB")) {
                            double addRamCost = 108;    // The price to add to ramCostTextField
                            ramCostTextField.setText("" + df.format(addRamCost));
                        } else if (Objects.equals(ramSelection, "16GB")) {
                            double addRamCost = 176;    // The price to add to ramCostTextField
                            ramCostTextField.setText("" + df.format(addRamCost));
                        }
                    }
                });

                // Create action listener for hardDriveComboBox for hardDriveCostTextField to use
                hardDriveComboBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Get selected combobox item
                        String hardDriveSelection = (String) hardDriveComboBox.getSelectedItem();

                        // If statement to determine price of selected item in hardDriveComboBox
                        if (Objects.equals(hardDriveSelection, "Select one below:")) {
                            double addHardDriveCost = 0;      // The price to add to hardDriveCostTextField
                            hardDriveCostTextField.setText("" + df.format(addHardDriveCost));
                        } else if (Objects.equals(hardDriveSelection, "125GB (Base Model)")) {
                            double addHardDriveCost = 0;      // The price to add to hardDriveCostTextField
                            hardDriveCostTextField.setText("" + df.format(addHardDriveCost));
                        } else if (Objects.equals(hardDriveSelection, "250GB")) {
                            double addHardDriveCost = 27;     // The price to add to hardDriveCostTextField
                            hardDriveCostTextField.setText("" + df.format(addHardDriveCost));
                        } else if (Objects.equals(hardDriveSelection, "500GB")) {
                            double addHardDriveCost = 50;     // The price to add to hardDriveCostTextField
                            hardDriveCostTextField.setText("" + df.format(addHardDriveCost));
                        } else if (Objects.equals(hardDriveSelection, "1TB")) {
                            double addHardDriveCost = 89;    // The price to add to hardDriveCostTextField
                            hardDriveCostTextField.setText("" + df.format(addHardDriveCost));
                        }
                    }
                });

                // Create action listener for gpuComboBox for gpuCostTextField to use
                gpuComboBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Get selected combobox item
                        String gpuSelection = (String) gpuComboBox.getSelectedItem();

                        // If statement to determine price of selected item in gpuComboBox
                        if (Objects.equals(gpuSelection, "Select one below:")) {
                            double addGpuCost = 0;      // The price to add to gpuCostTextField
                            gpuCostTextField.setText("" + df.format(addGpuCost));
                        } else if (Objects.equals(gpuSelection, "NVIDA GeForce G310 512MB DDR3")) {
                            double addGpuCost = 80;      // The price to add to gpuCostTextField
                            gpuCostTextField.setText("" + df.format(addGpuCost));
                        } else if (Objects.equals(gpuSelection, "NVIDA GeForce GT620 1GB DDR3")) {
                            double addGpuCost = 169;     // The price to add to gpuCostTextField
                            gpuCostTextField.setText("" + df.format(addGpuCost));
                        } else if (Objects.equals(gpuSelection, "NVIDA GeForce GT640 1GB GDDR5")) {
                            double addGpuCost = 490;     // The price to add to gpuCostTextField
                            gpuCostTextField.setText("" + df.format(addGpuCost));
                        }
                    }
                });

                // Create action listener for secondaryStorageComboBox for secondaryStorageCostTextField to use
                secondaryStorageComboBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Get selected combobox item
                        String secondaryStorageSelection = (String) secondaryStorageComboBox.getSelectedItem();

                        // If statement to determine price of selected item in secondaryStorageComboBox
                        if (Objects.equals(secondaryStorageSelection, "Select one below:")) {
                            double addSecondaryStorageCost = 0;      // The price to add to secondaryStorageCostTextField
                            secondaryStorageCostTextField.setText("" + df.format(addSecondaryStorageCost));
                        } else if (Objects.equals(secondaryStorageSelection, "CD-ROM")) {
                            double addSecondaryStorageCost = 0;      // The price to add to secondaryStorageCostTextField
                            secondaryStorageCostTextField.setText("" + df.format(addSecondaryStorageCost));
                        } else if (Objects.equals(secondaryStorageSelection, "DVD Drive")) {
                            double addSecondaryStorageCost = 17;     // The price to add to secondaryStorageCostTextField
                            secondaryStorageCostTextField.setText("" + df.format(addSecondaryStorageCost));
                        } else if (Objects.equals(secondaryStorageSelection, "Combo DVD or CDRW")) {
                            double addSecondaryStorageCost = 40;     // The price to add to secondaryStorageCostTextField
                            secondaryStorageCostTextField.setText("" + df.format(addSecondaryStorageCost));
                        } else if (Objects.equals(secondaryStorageSelection, "DVD and CDRW")) {
                            double addSecondaryStorageCost = 79;     // The price to add to secondaryStorageCostTextField
                            secondaryStorageCostTextField.setText("" + df.format(addSecondaryStorageCost));
                        }

                    }
                });

                // create action listener to set osCostTextField cost if osRadioButton1 is selected
                osRadioButton1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == osRadioButton1) {
                            double addOsCost = 0;           // The price to add to the osCostTextField
                            osCostTextField.setText("" + df.format(addOsCost));
                        }
                    }
                });

                // create action listener to set osCostTextField cost if osRadioButton2 is selected
                osRadioButton2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == osRadioButton2) {
                            double addOsCost = 59;           // The price to add to the osCostTextField
                            osCostTextField.setText("" + df.format(addOsCost));
                        }
                    }
                });

                // create action listener to set osCostTextField cost if osRadioButton3 is selected
                osRadioButton3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == osRadioButton3) {
                            double addOsCost = -89;           // The price to add to the osCostTextField
                            osCostTextField.setText("" + df.format(addOsCost));
                        }
                    }
                });


                // create action listener to set appPackageCostTextField cost if appPackageCheckBox1 is selected
                appPackageCheckBox1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == appPackageCheckBox1) {
                            double addAppPackageCost = 139;           // The price to add to the appPackageCostTextField
                            appPackageCostTextField.setText("" + df.format(addAppPackageCost));
                        }
                    }
                });

                // create action listener to set appPackageCostTextField cost if appPackageCheckBox2 is selected
                appPackageCheckBox2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == appPackageCheckBox2) {
                            double addAppPackageCost = 219;           // The price to add to the appPackageCostTextField
                            appPackageCostTextField.setText("" + df.format(addAppPackageCost));
                        }
                    }
                });

                // create action listener to set appPackageCostTextField cost if appPackageCheckBox3 is selected
                appPackageCheckBox3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == appPackageCheckBox3) {
                            double addAppPackageCost = 399;           // The price to add to the appPackageCostTextField
                            appPackageCostTextField.setText("" + df.format(addAppPackageCost));
                        }
                    }
                });

                // create action listener to set appPackageCostTextField cost if appPackageCheckBox4 is selected
                appPackageCheckBox4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == appPackageCheckBox4) {
                            double addAppPackageCost = 499;           // The price to add to the appPackageCostTextField
                            appPackageCostTextField.setText("" + df.format(addAppPackageCost));
                        }
                    }
                });

                // create MouseMotionListener to update subtotal with the running total inside
                panel.addMouseMotionListener(new MouseMotionAdapter() {
                    @Override
                    public void mouseMoved(MouseEvent e) {
                        super.mouseMoved(e);

                        // keep running total of costs
                        // create a list of double type
                        List<Double> list = new ArrayList<Double>();

                        // create fields to add to list
                        double intelCpuCost = Double.parseDouble(intelCpuCostTextField.getText());
                        double amdCpuCost = Double.parseDouble(amdCpuCostTextField.getText());
                        double ramCost = Double.parseDouble(ramCostTextField.getText());
                        double hardDriveCost = Double.parseDouble(hardDriveCostTextField.getText());
                        double gpuCost = Double.parseDouble(gpuCostTextField.getText());
                        double secondaryStorageCost = Double.parseDouble(secondaryStorageCostTextField.getText());
                        double osCost = Double.parseDouble(osCostTextField.getText());
                        double appPackageCost = Double.parseDouble(appPackageCostTextField.getText());
                        double baseModelCosts = Double.parseDouble(baseModelCostTextField.getText());

                        // create subtotal accumulator
                        double subtotal = 0;

                        // add to list
                        list.add(intelCpuCost);
                        list.add(amdCpuCost);
                        list.add(ramCost);
                        list.add(hardDriveCost);
                        list.add(gpuCost);
                        list.add(secondaryStorageCost);
                        list.add(osCost);
                        list.add(appPackageCost);
                        list.add(baseModelCosts);

                        // for loop to go through arraylist and calculate subtotal
                        for (int i = 0; i < list.size(); i++) {
                            subtotal += list.get(i);
                        }

                        // add subtotal to subTotalTextField
                        subTotalTextField.setText("" + df.format(subtotal));
                    }
                });

                // create action listener to display order information to user
                orderButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String osSelection = null;           // holds text of osRadioButton for display
                        String appPackageSelection = null;   // holds text of appPackageCheckBox for display

                        // if statement to determine which osRadioButton is selected and get its text
                        if (osRadioButton1.isSelected()) {
                            osSelection = osRadioButton1.getText();
                        } else if (osRadioButton2.isSelected()) {
                            osSelection = osRadioButton2.getText();
                        } else if (osRadioButton3.isSelected()) {
                            osSelection = osRadioButton3.getText();
                        }

                        // if statement to determine which appPackageCheckBox is selected and get its text
                        if (appPackageCheckBox1.isSelected()) {
                            osSelection = appPackageCheckBox1.getText();
                        } else if (appPackageCheckBox2.isSelected()) {
                            osSelection = appPackageCheckBox2.getText();
                        } else if (appPackageCheckBox3.isSelected()) {
                            osSelection = appPackageCheckBox3.getText();
                        } else if (appPackageCheckBox4.isSelected()) {
                            osSelection = appPackageCheckBox4.getText();
                        }

                        // get the selected components and their prices
                        String cpu = (String) intelCpuComboBox.getSelectedItem()
                                + " $" + intelCpuCostTextField.getText();
                        String ram = (String) "\n" + ramComboBox.getSelectedItem()
                                + " $" + ramCostTextField.getText();
                        String hardDrive = (String) "\n" + hardDriveComboBox.getSelectedItem()
                                + " $" + hardDriveCostTextField.getText();
                        String gpu = (String) "\n" + gpuComboBox.getSelectedItem()
                                + " $" + gpuCostTextField.getText();
                        String secondaryStorage = (String) "\n" + secondaryStorageComboBox.getSelectedItem()
                                + " $" + secondaryStorageCostTextField.getText();
                        String os = (String) "\n" + osSelection
                                + " $" + osCostTextField.getText();
                        String appPackage = (String) "\n" + appPackageSelection
                                + " $" + appPackageCostTextField.getText();
                        String audio = (String) "\n" + audioTextField.getText()
                                + " $0.00";
                        String speaker = (String) "\n" + speakerTextField.getText()
                                + " $0.00";
                        String keyboard = (String) "\n" + keyboardTextField.getText()
                                + " $0.00";
                        String mouse = (String) "\n" + mouseTextField.getText()
                                + " $0.00";

                        // get the subtotal, tax, total before ship, shipping, and total costs
                        String subtotalString = (String) "\n\nSubtotal: $" + subTotalTextField.getText();
                        String taxString = (String) "\nTax: $" + taxTextField.getText();
                        String totalBeforeShipString = (String) "\nTotal before Shipping: $" + totalBeforeShipTextField.getText();
                        String shipString = (String) "\nShipping and Handling: $" + shippingHandlingTextField.getText();
                        String totalString = (String) "\nTotal: $" + totalTextField.getText();

                        // display all details to the user
                        // display current configuration with prices and totals
                        int result = JOptionPane.showConfirmDialog(null,
                                cpu + ram + hardDrive
                                        + gpu + secondaryStorage
                                        + os + appPackage
                                        + audio + speaker
                                        + keyboard + mouse
                                        + subtotalString + taxString
                                        + totalBeforeShipString + shipString
                                        + totalString, "Order Confirmation", JOptionPane.YES_NO_OPTION);

                        // generate a random order number for if the user confirms their order
                        int number;
                        Random randomNumber = new Random();
                        number = randomNumber.nextInt(100000);

                        // when user presses yes, display a box that says your order has been processed
                        if (result == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null,
                                    "Your order has been processed!"
                                            + "\nOrder Number: " + number, "Order Processed", JOptionPane.INFORMATION_MESSAGE);
                            System.exit(0);
                        }
                    }
                });

                // create print button action listener to print summary of configuration
                printButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String osSelection = null;           // holds text of osRadioButton for display
                        String appPackageSelection = null;   // holds text of appPackageCheckBox for display

                        // if statement to determine which osRadioButton is selected and get its text
                        if (osRadioButton1.isSelected()) {
                            osSelection = osRadioButton1.getText();
                        } else if (osRadioButton2.isSelected()) {
                            osSelection = osRadioButton2.getText();
                        } else if (osRadioButton3.isSelected()) {
                            osSelection = osRadioButton3.getText();
                        }

                        // if statement to determine which appPackageCheckBox is selected and get its text
                        if (appPackageCheckBox1.isSelected()) {
                            osSelection = appPackageCheckBox1.getText();
                        } else if (appPackageCheckBox2.isSelected()) {
                            osSelection = appPackageCheckBox2.getText();
                        } else if (appPackageCheckBox3.isSelected()) {
                            osSelection = appPackageCheckBox3.getText();
                        } else if (appPackageCheckBox4.isSelected()) {
                            osSelection = appPackageCheckBox4.getText();
                        }

                        // get the selected components and their prices
                        String cpu = (String) intelCpuComboBox.getSelectedItem()
                                + " $" + intelCpuCostTextField.getText();
                        String ram = (String) "\n" + ramComboBox.getSelectedItem()
                                + " $" + ramCostTextField.getText();
                        String hardDrive = (String) "\n" + hardDriveComboBox.getSelectedItem()
                                + " $" + hardDriveCostTextField.getText();
                        String gpu = (String) "\n" + gpuComboBox.getSelectedItem()
                                + " $" + gpuCostTextField.getText();
                        String secondaryStorage = (String) "\n" + secondaryStorageComboBox.getSelectedItem()
                                + " $" + secondaryStorageCostTextField.getText();
                        String os = (String) "\n" + osSelection
                                + " $" + osCostTextField.getText();
                        String appPackage = (String) "\n" + appPackageSelection
                                + " $" + appPackageCostTextField.getText();
                        String audio = (String) "\n" + audioTextField.getText()
                                + " $0.00";
                        String speaker = (String) "\n" + speakerTextField.getText()
                                + " $0.00";
                        String keyboard = (String) "\n" + keyboardTextField.getText()
                                + " $0.00";
                        String mouse = (String) "\n" + mouseTextField.getText()
                                + " $0.00";

                        // get the subtotal, tax, total before ship, shipping, and total costs
                        String subtotalString = (String) "\n\nSubtotal: $" + subTotalTextField.getText();
                        String taxString = (String) "\nTax: $" + taxTextField.getText();
                        String totalBeforeShipString = (String) "\nTotal before Shipping: $" + totalBeforeShipTextField.getText();
                        String shipString = (String) "\nShipping and Handling: $" + shippingHandlingTextField.getText();
                        String totalString = (String) "\nTotal: $" + totalTextField.getText();

                        // display current configuration with prices and totals for user it see
                        JOptionPane.showMessageDialog(null,
                                cpu + ram + hardDrive
                                        + gpu + secondaryStorage
                                        + os + appPackage
                                        + audio + speaker
                                        + keyboard + mouse
                                        + subtotalString + taxString
                                        + totalBeforeShipString + shipString
                                        + totalString, "Configuration Summary", JOptionPane.INFORMATION_MESSAGE);
                    }
                });
            } // end of if
            else if (radioButtonAMD.isSelected()) {
                // Create a read-only text field for base cpu
                cpuTextField.setEditable(false);
                cpuTextField.setText("AMD FX-2100 for Desktops");

                // Create a read-only text field for base ram
                ramTextField.setEditable(false);
                ramTextField.setText("4GB Memory");

                // Create a read-only text field for base hard drive
                hardDriveTextField.setEditable(false);
                hardDriveTextField.setText("125GB Hard Drive");

                // Create a read-only text field for base hard drive
                amdGraphicsTextField.setEditable(false);
                amdGraphicsTextField.setText("Integrated 3D Graphics");

                // Create a read-only text field for base secondary storage
                secondaryStorageTextField.setEditable(false);
                secondaryStorageTextField.setText("CD-ROM Drive");

                // Create a read-only text field for base audio
                audioTextField.setEditable(false);
                audioTextField.setText("Integrated Audio");

                // Create a read-only text field for base operating system
                osTextField.setEditable(false);
                osTextField.setText("Microsoft Windows 8.1 OS");

                // Create a read-only text field for base speaker
                speakerTextField.setEditable(false);
                speakerTextField.setText("2 Piece Powered Speaker Set");

                // Create a read-only text field for base keyboard
                keyboardTextField.setEditable(false);
                keyboardTextField.setText("USB Wired Entry Keyboard");

                // Create a read-only text field for base mouse
                mouseTextField.setEditable(false);
                mouseTextField.setText("USB Optical Mouse");

                // Create a read-only text field for base model cost
                baseModelCostTextField.setEditable(false);
                double baseModelCost = 599;      // The price to add to baseModelCostTextField
                baseModelCostTextField.setText("" + df.format(baseModelCost));

                // Create action listener for amdCpuComboBox for amdCpuCostTextField to use
                amdCpuComboBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Get selected combobox item
                        String cpuSelection1 = (String) amdCpuComboBox.getSelectedItem();

                        // set intelCpuCostTextField to 0
                        double intelCpuCost = 0;
                        intelCpuCostTextField.setText("" + df.format(intelCpuCost));

                        // if statement to disable amdCpuComboBox
                        if (radioButtonAMD.isSelected()) {
                            intelCpuComboBox.setEnabled(false);
                        } else {
                            intelCpuComboBox.setEnabled(true);
                        }

                        // If statement to determine price of selected item in amdCpuComboBox
                        if (Objects.equals(cpuSelection1, "Select one below:")) {
                            double addAmdCpuCost = 0;      // The price to add to amdCpuCostTextField
                            amdCpuCostTextField.setText("" + df.format(addAmdCpuCost));
                        } else if (Objects.equals(cpuSelection1, "AMD FX-2100 for Desktops (Base Model)")) {
                            double addAmdCpuCost = 0;      // The price to add to amdCpuCostTextField
                            amdCpuCostTextField.setText("" + df.format(addAmdCpuCost));
                        } else if (Objects.equals(cpuSelection1, "FX-8350")) {
                            double addAmdCpuCost = 25;      // The price to add to amdCpuCostTextField
                            amdCpuCostTextField.setText("" + df.format(addAmdCpuCost));
                        } else if (Objects.equals(cpuSelection1, "FX-9590")) {
                            double addAmdCpuCost = 90;      // The price to add to amdCpuCostTextField
                            amdCpuCostTextField.setText("" + df.format(addAmdCpuCost));
                        } else if (Objects.equals(cpuSelection1, "FX-4100")) {
                            double addAmdCpuCost = 187;      // The price to add to amdCpuCostTextField
                            amdCpuCostTextField.setText("" + df.format(addAmdCpuCost));
                        } else if (Objects.equals(cpuSelection1, "FX-4300")) {
                            double addAmdCpuCost = 280;    // The price to add to amdCpuCostTextField
                            amdCpuCostTextField.setText("" + df.format(addAmdCpuCost));
                        }
                    }
                });
                // Create action listener for ramComboBox for ramCostTextField to use
                ramComboBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Get selected combobox item
                        String ramSelection = (String) ramComboBox.getSelectedItem();

                        // If statement to determine price of selected item in ramComboBox
                        if (Objects.equals(ramSelection, "Select one below:")) {
                            double addRamCost = 0;      // The price to add to ramCostTextField
                            ramCostTextField.setText("" + df.format(addRamCost));
                        } else if (Objects.equals(ramSelection, "4GB (Base Model)")) {
                            double addRamCost = 0;      // The price to add to ramCostTextField
                            ramCostTextField.setText("" + df.format(addRamCost));
                        } else if (Objects.equals(ramSelection, "6GB")) {
                            double addRamCost = 28;     // The price to add to ramCostTextField
                            ramCostTextField.setText("" + df.format(addRamCost));
                        } else if (Objects.equals(ramSelection, "8GB")) {
                            double addRamCost = 58;     // The price to add to ramCostTextField
                            ramCostTextField.setText("" + df.format(addRamCost));
                        } else if (Objects.equals(ramSelection, "12GB")) {
                            double addRamCost = 108;    // The price to add to ramCostTextField
                            ramCostTextField.setText("" + df.format(addRamCost));
                        } else if (Objects.equals(ramSelection, "16GB")) {
                            double addRamCost = 176;    // The price to add to ramCostTextField
                            ramCostTextField.setText("" + df.format(addRamCost));
                        }
                    }
                });

                // Create action listener for hardDriveComboBox for hardDriveCostTextField to use
                hardDriveComboBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Get selected combobox item
                        String hardDriveSelection = (String) hardDriveComboBox.getSelectedItem();

                        // If statement to determine price of selected item in hardDriveComboBox
                        if (Objects.equals(hardDriveSelection, "Select one below:")) {
                            double addHardDriveCost = 0;      // The price to add to hardDriveCostTextField
                            hardDriveCostTextField.setText("" + df.format(addHardDriveCost));
                        } else if (Objects.equals(hardDriveSelection, "125GB (Base Model)")) {
                            double addHardDriveCost = 0;      // The price to add to hardDriveCostTextField
                            hardDriveCostTextField.setText("" + df.format(addHardDriveCost));
                        } else if (Objects.equals(hardDriveSelection, "250GB")) {
                            double addHardDriveCost = 27;     // The price to add to hardDriveCostTextField
                            hardDriveCostTextField.setText("" + df.format(addHardDriveCost));
                        } else if (Objects.equals(hardDriveSelection, "500GB")) {
                            double addHardDriveCost = 50;     // The price to add to hardDriveCostTextField
                            hardDriveCostTextField.setText("" + df.format(addHardDriveCost));
                        } else if (Objects.equals(hardDriveSelection, "1TB")) {
                            double addHardDriveCost = 89;    // The price to add to hardDriveCostTextField
                            hardDriveCostTextField.setText("" + df.format(addHardDriveCost));
                        }
                    }
                });

                // Create action listener for gpuComboBox for gpuCostTextField to use
                gpuComboBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Get selected combobox item
                        String gpuSelection = (String) gpuComboBox.getSelectedItem();

                        // If statement to determine price of selected item in gpuComboBox
                        if (Objects.equals(gpuSelection, "Select one below:")) {
                            double addGpuCost = 0;      // The price to add to gpuCostTextField
                            gpuCostTextField.setText("" + df.format(addGpuCost));
                        } else if (Objects.equals(gpuSelection, "NVIDA GeForce G310 512MB DDR3")) {
                            double addGpuCost = 80;      // The price to add to gpuCostTextField
                            gpuCostTextField.setText("" + df.format(addGpuCost));
                        } else if (Objects.equals(gpuSelection, "NVIDA GeForce GT620 1GB DDR3")) {
                            double addGpuCost = 169;     // The price to add to gpuCostTextField
                            gpuCostTextField.setText("" + df.format(addGpuCost));
                        } else if (Objects.equals(gpuSelection, "NVIDA GeForce GT640 1GB GDDR5")) {
                            double addGpuCost = 490;     // The price to add to gpuCostTextField
                            gpuCostTextField.setText("" + df.format(addGpuCost));
                        }
                    }
                });

                // Create action listener for secondaryStorageComboBox for secondaryStorageCostTextField to use
                secondaryStorageComboBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Get selected combobox item
                        String secondaryStorageSelection = (String) secondaryStorageComboBox.getSelectedItem();

                        // If statement to determine price of selected item in secondaryStorageComboBox
                        if (Objects.equals(secondaryStorageSelection, "Select one below:")) {
                            double addSecondaryStorageCost = 0;      // The price to add to secondaryStorageCostTextField
                            secondaryStorageCostTextField.setText("" + df.format(addSecondaryStorageCost));
                        } else if (Objects.equals(secondaryStorageSelection, "CD-ROM")) {
                            double addSecondaryStorageCost = 0;      // The price to add to secondaryStorageCostTextField
                            secondaryStorageCostTextField.setText("" + df.format(addSecondaryStorageCost));
                        } else if (Objects.equals(secondaryStorageSelection, "DVD Drive")) {
                            double addSecondaryStorageCost = 17;     // The price to add to secondaryStorageCostTextField
                            secondaryStorageCostTextField.setText("" + df.format(addSecondaryStorageCost));
                        } else if (Objects.equals(secondaryStorageSelection, "Combo DVD or CDRW")) {
                            double addSecondaryStorageCost = 40;     // The price to add to secondaryStorageCostTextField
                            secondaryStorageCostTextField.setText("" + df.format(addSecondaryStorageCost));
                        } else if (Objects.equals(secondaryStorageSelection, "DVD and CDRW")) {
                            double addSecondaryStorageCost = 79;     // The price to add to secondaryStorageCostTextField
                            secondaryStorageCostTextField.setText("" + df.format(addSecondaryStorageCost));
                        }

                    }
                });

                // create action listener to set osCostTextField cost if osRadioButton1 is selected
                osRadioButton1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == osRadioButton1) {
                            double addOsCost = 0;           // The price to add to the osCostTextField
                            osCostTextField.setText("" + df.format(addOsCost));
                        }
                    }
                });

                // create action listener to set osCostTextField cost if osRadioButton2 is selected
                osRadioButton2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == osRadioButton2) {
                            double addOsCost = 59;           // The price to add to the osCostTextField
                            osCostTextField.setText("" + df.format(addOsCost));
                        }
                    }
                });

                // create action listener to set osCostTextField cost if osRadioButton3 is selected
                osRadioButton3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == osRadioButton3) {
                            double addOsCost = -89;           // The price to add to the osCostTextField
                            osCostTextField.setText("" + df.format(addOsCost));
                        }
                    }
                });


                // create action listener to set appPackageCostTextField cost if appPackageCheckBox1 is selected
                appPackageCheckBox1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == appPackageCheckBox1) {
                            double addAppPackageCost = 139;           // The price to add to the appPackageCostTextField
                            appPackageCostTextField.setText("" + df.format(addAppPackageCost));
                        }
                    }
                });

                // create action listener to set appPackageCostTextField cost if appPackageCheckBox2 is selected
                appPackageCheckBox2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == appPackageCheckBox2) {
                            double addAppPackageCost = 219;           // The price to add to the appPackageCostTextField
                            appPackageCostTextField.setText("" + df.format(addAppPackageCost));
                        }
                    }
                });

                // create action listener to set appPackageCostTextField cost if appPackageCheckBox3 is selected
                appPackageCheckBox3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == appPackageCheckBox3) {
                            double addAppPackageCost = 399;           // The price to add to the appPackageCostTextField
                            appPackageCostTextField.setText("" + df.format(addAppPackageCost));
                        }
                    }
                });

                // create action listener to set appPackageCostTextField cost if appPackageCheckBox4 is selected
                appPackageCheckBox4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == appPackageCheckBox4) {
                            double addAppPackageCost = 499;           // The price to add to the appPackageCostTextField
                            appPackageCostTextField.setText("" + df.format(addAppPackageCost));
                        }
                    }
                });

                // create MouseMotionListener to update subtotal with the running total inside
                panel.addMouseMotionListener(new MouseMotionAdapter() {
                    @Override
                    public void mouseMoved(MouseEvent e) {
                        super.mouseMoved(e);

                        // keep running total of costs
                        // create a list of double type
                        List<Double> list = new ArrayList<Double>();

                        // create fields to add to list
                        double intelCpuCost = Double.parseDouble(intelCpuCostTextField.getText());
                        double amdCpuCost = Double.parseDouble(amdCpuCostTextField.getText());
                        double ramCost = Double.parseDouble(ramCostTextField.getText());
                        double hardDriveCost = Double.parseDouble(hardDriveCostTextField.getText());
                        double gpuCost = Double.parseDouble(gpuCostTextField.getText());
                        double secondaryStorageCost = Double.parseDouble(secondaryStorageCostTextField.getText());
                        double osCost = Double.parseDouble(osCostTextField.getText());
                        double appPackageCost = Double.parseDouble(appPackageCostTextField.getText());
                        double baseModelCosts = Double.parseDouble(baseModelCostTextField.getText());

                        // create subtotal accumulator
                        double subtotal = 0;

                        // add to list
                        list.add(intelCpuCost);
                        list.add(amdCpuCost);
                        list.add(ramCost);
                        list.add(hardDriveCost);
                        list.add(gpuCost);
                        list.add(secondaryStorageCost);
                        list.add(osCost);
                        list.add(appPackageCost);
                        list.add(baseModelCosts);

                        // for loop to go through arraylist and calculate subtotal
                        for (int i = 0; i < list.size(); i++) {
                            subtotal += list.get(i);
                        }

                        // add subtotal to subTotalTextField
                        subTotalTextField.setText("" + df.format(subtotal));
                    }
                });
                // create action listener to display order information to user
                orderButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String osSelection = null;           // holds text of osRadioButton for display
                        String appPackageSelection = null;   // holds text of appPackageCheckBox for display

                        // if statement to determine which osRadioButton is selected and get its text
                        if (osRadioButton1.isSelected()) {
                            osSelection = osRadioButton1.getText();
                        } else if (osRadioButton2.isSelected()) {
                            osSelection = osRadioButton2.getText();
                        } else if (osRadioButton3.isSelected()) {
                            osSelection = osRadioButton3.getText();
                        }

                        // if statement to determine which appPackageCheckBox is selected and get its text
                        if (appPackageCheckBox1.isSelected()) {
                            osSelection = appPackageCheckBox1.getText();
                        } else if (appPackageCheckBox2.isSelected()) {
                            osSelection = appPackageCheckBox2.getText();
                        } else if (appPackageCheckBox3.isSelected()) {
                            osSelection = appPackageCheckBox3.getText();
                        } else if (appPackageCheckBox4.isSelected()) {
                            osSelection = appPackageCheckBox4.getText();
                        }

                        // get the selected components and their prices
                        String cpu = (String) amdCpuComboBox.getSelectedItem()
                                + " $" + amdCpuCostTextField.getText();
                        String ram = (String) "\n" + ramComboBox.getSelectedItem()
                                + " $" + ramCostTextField.getText();
                        String hardDrive = (String) "\n" + hardDriveComboBox.getSelectedItem()
                                + " $" + hardDriveCostTextField.getText();
                        String gpu = (String) "\n" + gpuComboBox.getSelectedItem()
                                + " $" + gpuCostTextField.getText();
                        String secondaryStorage = (String) "\n" + secondaryStorageComboBox.getSelectedItem()
                                + " $" + secondaryStorageCostTextField.getText();
                        String os = (String) "\n" + osSelection
                                + " $" + osCostTextField.getText();
                        String appPackage = (String) "\n" + appPackageSelection
                                + " $" + appPackageCostTextField.getText();
                        String audio = (String) "\n" + audioTextField.getText()
                                + " $0.00";
                        String speaker = (String) "\n" + speakerTextField.getText()
                                + " $0.00";
                        String keyboard = (String) "\n" + keyboardTextField.getText()
                                + " $0.00";
                        String mouse = (String) "\n" + mouseTextField.getText()
                                + " $0.00";

                        // get the subtotal, tax, total before ship, shipping, and total costs
                        String subtotalString = (String) "\n\nSubtotal: $" + subTotalTextField.getText();
                        String taxString = (String) "\nTax: $" + taxTextField.getText();
                        String totalBeforeShipString = (String) "\nTotal before Shipping: $" + totalBeforeShipTextField.getText();
                        String shipString = (String) "\nShipping and Handling: $" + shippingHandlingTextField.getText();
                        String totalString = (String) "\nTotal: $" + totalTextField.getText();

                        // display all details to the user
                        // display current configuration with prices and totals
                        int result = JOptionPane.showConfirmDialog(null,
                                cpu + ram + hardDrive
                                        + gpu + secondaryStorage
                                        + os + appPackage
                                        + audio + speaker
                                        + keyboard + mouse
                                        + subtotalString + taxString
                                        + totalBeforeShipString + shipString
                                        + totalString, "Order Confirmation", JOptionPane.YES_NO_OPTION);

                        // generate a random order number for if the user confirms their order
                        int number;
                        Random randomNumber = new Random();
                        number = randomNumber.nextInt(100000);

                        // when user presses yes, display a box that says your order has been processed
                        if (result == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null,
                                    "Your order has been processed!"
                                            + "\nOrder Number: " + number, "Order Processed", JOptionPane.INFORMATION_MESSAGE);
                            System.exit(0);
                        }
                    }
                });

                // create print button action listener to print summary of configuration
                printButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String osSelection = null;           // holds text of osRadioButton for display
                        String appPackageSelection = null;   // holds text of appPackageCheckBox for display

                        // if statement to determine which osRadioButton is selected and get its text
                        if (osRadioButton1.isSelected()) {
                            osSelection = osRadioButton1.getText();
                        } else if (osRadioButton2.isSelected()) {
                            osSelection = osRadioButton2.getText();
                        } else if (osRadioButton3.isSelected()) {
                            osSelection = osRadioButton3.getText();
                        }

                        // if statement to determine which appPackageCheckBox is selected and get its text
                        if (appPackageCheckBox1.isSelected()) {
                            osSelection = appPackageCheckBox1.getText();
                        } else if (appPackageCheckBox2.isSelected()) {
                            osSelection = appPackageCheckBox2.getText();
                        } else if (appPackageCheckBox3.isSelected()) {
                            osSelection = appPackageCheckBox3.getText();
                        } else if (appPackageCheckBox4.isSelected()) {
                            osSelection = appPackageCheckBox4.getText();
                        }

                        // get the selected components and their prices
                        String cpu = (String) amdCpuComboBox.getSelectedItem()
                                + " $" + amdCpuCostTextField.getText();
                        String ram = (String) "\n" + ramComboBox.getSelectedItem()
                                + " $" + ramCostTextField.getText();
                        String hardDrive = (String) "\n" + hardDriveComboBox.getSelectedItem()
                                + " $" + hardDriveCostTextField.getText();
                        String gpu = (String) "\n" + gpuComboBox.getSelectedItem()
                                + " $" + gpuCostTextField.getText();
                        String secondaryStorage = (String) "\n" + secondaryStorageComboBox.getSelectedItem()
                                + " $" + secondaryStorageCostTextField.getText();
                        String os = (String) "\n" + osSelection
                                + " $" + osCostTextField.getText();
                        String appPackage = (String) "\n" + appPackageSelection
                                + " $" + appPackageCostTextField.getText();
                        String audio = (String) "\n" + audioTextField.getText()
                                + " $0.00";
                        String speaker = (String) "\n" + speakerTextField.getText()
                                + " $0.00";
                        String keyboard = (String) "\n" + keyboardTextField.getText()
                                + " $0.00";
                        String mouse = (String) "\n" + mouseTextField.getText()
                                + " $0.00";

                        // get the subtotal, tax, total before ship, shipping, and total costs
                        String subtotalString = (String) "\n\nSubtotal: $" + subTotalTextField.getText();
                        String taxString = (String) "\nTax: $" + taxTextField.getText();
                        String totalBeforeShipString = (String) "\nTotal before Shipping: $" + totalBeforeShipTextField.getText();
                        String shipString = (String) "\nShipping and Handling: $" + shippingHandlingTextField.getText();
                        String totalString = (String) "\nTotal: $" + totalTextField.getText();

                        // display current configuration with prices and totals for user it see
                        JOptionPane.showMessageDialog(null,
                                cpu + ram + hardDrive
                                        + gpu + secondaryStorage
                                        + os + appPackage
                                        + audio + speaker
                                        + keyboard + mouse
                                        + subtotalString + taxString
                                        + totalBeforeShipString + shipString
                                        + totalString, "Configuration Summary", JOptionPane.INFORMATION_MESSAGE);
                    }
                });
            } // end else if
        } //end action performed
    } // end radioButtonListener class


    /*
        Main method to run the GUI Form
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("PC Configurator");
        frame.setContentPane(new Configurator().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel = new JPanel();
        panel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(18, 8, new Insets(0, 0, 0, 0), -1, -1));
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        radioButtonIntel = new JRadioButton();
        radioButtonIntel.setSelected(false);
        radioButtonIntel.setText("Intel");
        panel.add(radioButtonIntel, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(239, 20), null, 0, false));
        radioButtonAMD = new JRadioButton();
        radioButtonAMD.setText("AMD");
        panel.add(radioButtonAMD, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(239, 20), null, 0, false));
        baseModelLabel = new JLabel();
        baseModelLabel.setText("Base Model Specs:");
        panel.add(baseModelLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(188, 30), null, 0, false));
        ramLabel = new JLabel();
        ramLabel.setText("RAM:");
        panel.add(ramLabel, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(188, 30), null, 0, false));
        hardDriveLabel = new JLabel();
        hardDriveLabel.setText("Hard Drive:");
        panel.add(hardDriveLabel, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(188, 30), null, 0, false));
        secondaryStorageLabel = new JLabel();
        secondaryStorageLabel.setText("Secondary Storage:");
        panel.add(secondaryStorageLabel, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(188, 30), null, 0, false));
        audioLabel = new JLabel();
        audioLabel.setText("Audio:");
        panel.add(audioLabel, new com.intellij.uiDesigner.core.GridConstraints(8, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(188, 30), null, 0, false));
        osLabel = new JLabel();
        osLabel.setText("OS:");
        panel.add(osLabel, new com.intellij.uiDesigner.core.GridConstraints(9, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(188, 30), null, 0, false));
        speakerLabel = new JLabel();
        speakerLabel.setText("Speaker:");
        panel.add(speakerLabel, new com.intellij.uiDesigner.core.GridConstraints(10, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(188, 30), null, 0, false));
        keyboardLabel = new JLabel();
        keyboardLabel.setText("Keyboard:");
        panel.add(keyboardLabel, new com.intellij.uiDesigner.core.GridConstraints(11, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(188, 30), null, 0, false));
        mouseLabel = new JLabel();
        mouseLabel.setText("Mouse:");
        panel.add(mouseLabel, new com.intellij.uiDesigner.core.GridConstraints(12, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(188, 30), null, 0, false));
        hardDriveTextField = new JTextField();
        hardDriveTextField.setEditable(false);
        panel.add(hardDriveTextField, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(239, 30), null, 0, false));
        secondaryStorageTextField = new JTextField();
        secondaryStorageTextField.setEditable(false);
        panel.add(secondaryStorageTextField, new com.intellij.uiDesigner.core.GridConstraints(7, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(239, 30), null, 0, false));
        audioTextField = new JTextField();
        audioTextField.setEditable(false);
        panel.add(audioTextField, new com.intellij.uiDesigner.core.GridConstraints(8, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(239, 30), null, 0, false));
        osTextField = new JTextField();
        osTextField.setEditable(false);
        panel.add(osTextField, new com.intellij.uiDesigner.core.GridConstraints(9, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(239, 30), null, 0, false));
        speakerTextField = new JTextField();
        speakerTextField.setEditable(false);
        panel.add(speakerTextField, new com.intellij.uiDesigner.core.GridConstraints(10, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(239, 30), null, 0, false));
        keyboardTextField = new JTextField();
        keyboardTextField.setEditable(false);
        panel.add(keyboardTextField, new com.intellij.uiDesigner.core.GridConstraints(11, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(239, 30), null, 0, false));
        mouseTextField = new JTextField();
        mouseTextField.setEditable(false);
        panel.add(mouseTextField, new com.intellij.uiDesigner.core.GridConstraints(12, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(239, 30), null, 0, false));
        userIntelCpuLabel = new JLabel();
        userIntelCpuLabel.setText("Intel CPU:");
        panel.add(userIntelCpuLabel, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(142, 16), null, 0, false));
        costLabel = new JLabel();
        costLabel.setText("Cost Addition:");
        panel.add(costLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 7, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        intelCpuCostTextField = new JTextField();
        intelCpuCostTextField.setEditable(false);
        panel.add(intelCpuCostTextField, new com.intellij.uiDesigner.core.GridConstraints(3, 7, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        pickBaseModelLabel = new JLabel();
        pickBaseModelLabel.setText("Select your base model Computer:");
        panel.add(pickBaseModelLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(188, 16), null, 0, false));
        ramTextField = new JTextField();
        ramTextField.setEditable(false);
        panel.add(ramTextField, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(300, 30), null, 0, false));
        cpuTextField = new JTextField();
        cpuTextField.setEditable(false);
        panel.add(cpuTextField, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(239, 30), null, 0, false));
        userSelectionLabel = new JLabel();
        userSelectionLabel.setText("Pick Your Components:");
        panel.add(userSelectionLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(142, 16), null, 0, false));
        amdGraphicsLabel = new JLabel();
        amdGraphicsLabel.setText("AMD Graphics:");
        panel.add(amdGraphicsLabel, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(188, 30), null, 0, false));
        amdGraphicsTextField = new JTextField();
        amdGraphicsTextField.setEditable(false);
        panel.add(amdGraphicsTextField, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(239, 30), null, 0, false));
        intelCpuComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("Select one below:");
        defaultComboBoxModel1.addElement("Intel Celeron processor G1610 (Base Model)");
        defaultComboBoxModel1.addElement("G1620 2.70GHz");
        defaultComboBoxModel1.addElement("G1630 2.80GHz");
        defaultComboBoxModel1.addElement("G1820 2.70GHz");
        defaultComboBoxModel1.addElement("G1830 2.80GHz");
        intelCpuComboBox.setModel(defaultComboBoxModel1);
        intelCpuComboBox.setName("");
        intelCpuComboBox.setOpaque(false);
        intelCpuComboBox.setPopupVisible(false);
        intelCpuComboBox.setVisible(true);
        panel.add(intelCpuComboBox, new com.intellij.uiDesigner.core.GridConstraints(3, 3, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cpuLabel = new JLabel();
        cpuLabel.setText("CPU:");
        panel.add(cpuLabel, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(188, 30), null, 0, false));
        baseModelCostLabel = new JLabel();
        baseModelCostLabel.setText("Base Model Cost:");
        panel.add(baseModelCostLabel, new com.intellij.uiDesigner.core.GridConstraints(14, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(188, 30), null, 0, false));
        baseModelCostTextField = new JTextField();
        baseModelCostTextField.setEditable(false);
        panel.add(baseModelCostTextField, new com.intellij.uiDesigner.core.GridConstraints(14, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(239, 30), null, 0, false));
        subTotalTextField = new JTextField();
        subTotalTextField.setEditable(false);
        panel.add(subTotalTextField, new com.intellij.uiDesigner.core.GridConstraints(12, 7, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        taxLabel = new JLabel();
        taxLabel.setText("Tax:");
        panel.add(taxLabel, new com.intellij.uiDesigner.core.GridConstraints(13, 6, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(128, 16), null, 0, false));
        subTotalLabel = new JLabel();
        subTotalLabel.setText("Subtotal:");
        panel.add(subTotalLabel, new com.intellij.uiDesigner.core.GridConstraints(12, 6, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(128, 16), null, 0, false));
        appPackageCheckBox4 = new JCheckBox();
        appPackageCheckBox4.setText("Graphics Package");
        panel.add(appPackageCheckBox4, new com.intellij.uiDesigner.core.GridConstraints(11, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        appPackageCheckBox2 = new JCheckBox();
        appPackageCheckBox2.setText("Microsoft Office Home and Business 2013");
        panel.add(appPackageCheckBox2, new com.intellij.uiDesigner.core.GridConstraints(11, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        appPackageCheckBox1 = new JCheckBox();
        appPackageCheckBox1.setSelected(false);
        appPackageCheckBox1.setText("Microsoft Office Home and Student 2013");
        panel.add(appPackageCheckBox1, new com.intellij.uiDesigner.core.GridConstraints(10, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        appPackageLabel = new JLabel();
        appPackageLabel.setText("Application Package:");
        panel.add(appPackageLabel, new com.intellij.uiDesigner.core.GridConstraints(10, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(142, 16), null, 0, false));
        userOsLabel = new JLabel();
        userOsLabel.setText("OS:");
        panel.add(userOsLabel, new com.intellij.uiDesigner.core.GridConstraints(9, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(142, 16), null, 0, false));
        osRadioButton1 = new JRadioButton();
        osRadioButton1.setSelected(false);
        osRadioButton1.setText("Windows 8.1 (Default)");
        panel.add(osRadioButton1, new com.intellij.uiDesigner.core.GridConstraints(9, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        appPackageCheckBox3 = new JCheckBox();
        appPackageCheckBox3.setText("Accounting Package");
        panel.add(appPackageCheckBox3, new com.intellij.uiDesigner.core.GridConstraints(10, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        osRadioButton2 = new JRadioButton();
        osRadioButton2.setText("Windows 8.1 Pro");
        panel.add(osRadioButton2, new com.intellij.uiDesigner.core.GridConstraints(9, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        osRadioButton3 = new JRadioButton();
        osRadioButton3.setText("Linux");
        panel.add(osRadioButton3, new com.intellij.uiDesigner.core.GridConstraints(9, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        appPackageCostTextField = new JTextField();
        appPackageCostTextField.setEditable(false);
        panel.add(appPackageCostTextField, new com.intellij.uiDesigner.core.GridConstraints(10, 7, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        osCostTextField = new JTextField();
        osCostTextField.setEditable(false);
        panel.add(osCostTextField, new com.intellij.uiDesigner.core.GridConstraints(9, 7, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        userSecondaryStorageLabel = new JLabel();
        userSecondaryStorageLabel.setText("Secondary Storage:");
        panel.add(userSecondaryStorageLabel, new com.intellij.uiDesigner.core.GridConstraints(8, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(142, 16), null, 0, false));
        secondaryStorageComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        defaultComboBoxModel2.addElement("Select one below:");
        defaultComboBoxModel2.addElement("CD-ROM");
        defaultComboBoxModel2.addElement("DVD Drive");
        defaultComboBoxModel2.addElement("Combo DVD or CDRW");
        defaultComboBoxModel2.addElement("DVD and CDRW");
        secondaryStorageComboBox.setModel(defaultComboBoxModel2);
        panel.add(secondaryStorageComboBox, new com.intellij.uiDesigner.core.GridConstraints(8, 3, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        gpuComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel3 = new DefaultComboBoxModel();
        defaultComboBoxModel3.addElement("Select one below:");
        defaultComboBoxModel3.addElement("NVIDA GeForce G310 512MB DDR3");
        defaultComboBoxModel3.addElement("NVIDA GeForce GT620 1GB DDR3");
        defaultComboBoxModel3.addElement("NVIDA GeForce GT640 1GB GDDR5");
        gpuComboBox.setModel(defaultComboBoxModel3);
        panel.add(gpuComboBox, new com.intellij.uiDesigner.core.GridConstraints(7, 3, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        hardDriveComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel4 = new DefaultComboBoxModel();
        defaultComboBoxModel4.addElement("Select one below:");
        defaultComboBoxModel4.addElement("125GB (Base Model)");
        defaultComboBoxModel4.addElement("250GB");
        defaultComboBoxModel4.addElement("500GB");
        defaultComboBoxModel4.addElement("1TB");
        hardDriveComboBox.setModel(defaultComboBoxModel4);
        panel.add(hardDriveComboBox, new com.intellij.uiDesigner.core.GridConstraints(6, 3, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ramComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel5 = new DefaultComboBoxModel();
        defaultComboBoxModel5.addElement("Select one below:");
        defaultComboBoxModel5.addElement("4GB (Base Model)");
        defaultComboBoxModel5.addElement("6GB");
        defaultComboBoxModel5.addElement("8GB");
        defaultComboBoxModel5.addElement("12GB");
        defaultComboBoxModel5.addElement("16GB");
        ramComboBox.setModel(defaultComboBoxModel5);
        panel.add(ramComboBox, new com.intellij.uiDesigner.core.GridConstraints(5, 3, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        userGPULabel = new JLabel();
        userGPULabel.setText("GPU:");
        panel.add(userGPULabel, new com.intellij.uiDesigner.core.GridConstraints(7, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(142, 16), null, 0, false));
        userHardDriveLabel = new JLabel();
        userHardDriveLabel.setText("Hard Drive:");
        panel.add(userHardDriveLabel, new com.intellij.uiDesigner.core.GridConstraints(6, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(142, 16), null, 0, false));
        userRamLabel = new JLabel();
        userRamLabel.setText("RAM:");
        panel.add(userRamLabel, new com.intellij.uiDesigner.core.GridConstraints(5, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(142, 16), null, 0, false));
        secondaryStorageCostTextField = new JTextField();
        secondaryStorageCostTextField.setEditable(false);
        panel.add(secondaryStorageCostTextField, new com.intellij.uiDesigner.core.GridConstraints(8, 7, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        gpuCostTextField = new JTextField();
        gpuCostTextField.setEditable(false);
        panel.add(gpuCostTextField, new com.intellij.uiDesigner.core.GridConstraints(7, 7, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        hardDriveCostTextField = new JTextField();
        hardDriveCostTextField.setEditable(false);
        panel.add(hardDriveCostTextField, new com.intellij.uiDesigner.core.GridConstraints(6, 7, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        ramCostTextField = new JTextField();
        ramCostTextField.setEditable(false);
        panel.add(ramCostTextField, new com.intellij.uiDesigner.core.GridConstraints(5, 7, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        userAmdCpuLabel = new JLabel();
        userAmdCpuLabel.setText("AMD CPU:");
        panel.add(userAmdCpuLabel, new com.intellij.uiDesigner.core.GridConstraints(4, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        amdCpuComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel6 = new DefaultComboBoxModel();
        defaultComboBoxModel6.addElement("Select one below:");
        defaultComboBoxModel6.addElement("AMD FX-2100 for Desktops (Base Model)");
        defaultComboBoxModel6.addElement("FX-8350");
        defaultComboBoxModel6.addElement("FX-9590");
        defaultComboBoxModel6.addElement("FX-4100");
        defaultComboBoxModel6.addElement("FX-4300");
        amdCpuComboBox.setModel(defaultComboBoxModel6);
        panel.add(amdCpuComboBox, new com.intellij.uiDesigner.core.GridConstraints(4, 3, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        amdCpuCostTextField = new JTextField();
        amdCpuCostTextField.setEditable(false);
        panel.add(amdCpuCostTextField, new com.intellij.uiDesigner.core.GridConstraints(4, 7, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        taxTextField = new JTextField();
        taxTextField.setEditable(false);
        panel.add(taxTextField, new com.intellij.uiDesigner.core.GridConstraints(13, 7, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        totalBeforeShipLabel = new JLabel();
        totalBeforeShipLabel.setText("Total (before shipping):");
        panel.add(totalBeforeShipLabel, new com.intellij.uiDesigner.core.GridConstraints(14, 6, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(128, 16), null, 0, false));
        totalBeforeShipTextField = new JTextField();
        totalBeforeShipTextField.setEditable(false);
        panel.add(totalBeforeShipTextField, new com.intellij.uiDesigner.core.GridConstraints(14, 7, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        shippingHandlingTextField = new JTextField();
        shippingHandlingTextField.setEditable(false);
        shippingHandlingTextField.setText("");
        panel.add(shippingHandlingTextField, new com.intellij.uiDesigner.core.GridConstraints(15, 7, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        shippingHandlingLabel = new JLabel();
        shippingHandlingLabel.setText("Shipping and Handling");
        panel.add(shippingHandlingLabel, new com.intellij.uiDesigner.core.GridConstraints(15, 6, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(128, 16), null, 0, false));
        calculateTaxShippingTotalButton = new JButton();
        calculateTaxShippingTotalButton.setText("Calculate");
        panel.add(calculateTaxShippingTotalButton, new com.intellij.uiDesigner.core.GridConstraints(17, 7, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        orderButton = new JButton();
        orderButton.setIcon(new ImageIcon(getClass().getResource("/orderButtonIcon2.png")));
        orderButton.setIconTextGap(10);
        orderButton.setInheritsPopupMenu(true);
        orderButton.setText("Order");
        panel.add(orderButton, new com.intellij.uiDesigner.core.GridConstraints(17, 6, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(128, 30), null, 0, false));
        totalLabel = new JLabel();
        totalLabel.setText("Total:");
        panel.add(totalLabel, new com.intellij.uiDesigner.core.GridConstraints(16, 6, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(128, 16), null, 0, false));
        clearButton = new JButton();
        clearButton.setText("Clear");
        panel.add(clearButton, new com.intellij.uiDesigner.core.GridConstraints(17, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        exitButton = new JButton();
        exitButton.setIcon(new ImageIcon(getClass().getResource("/exitButtonIcon2.png")));
        exitButton.setIconTextGap(10);
        exitButton.setText("Exit");
        panel.add(exitButton, new com.intellij.uiDesigner.core.GridConstraints(17, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        totalTextField = new JTextField();
        totalTextField.setEditable(false);
        panel.add(totalTextField, new com.intellij.uiDesigner.core.GridConstraints(16, 7, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        printButton = new JButton();
        printButton.setText("Print");
        panel.add(printButton, new com.intellij.uiDesigner.core.GridConstraints(17, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ramLabel.setLabelFor(ramTextField);
        hardDriveLabel.setLabelFor(hardDriveTextField);
        secondaryStorageLabel.setLabelFor(secondaryStorageTextField);
        audioLabel.setLabelFor(audioTextField);
        osLabel.setLabelFor(osTextField);
        speakerLabel.setLabelFor(speakerTextField);
        keyboardLabel.setLabelFor(keyboardTextField);
        mouseLabel.setLabelFor(mouseTextField);
        cpuLabel.setLabelFor(cpuTextField);
        baseModelCostLabel.setLabelFor(baseModelCostTextField);
        taxLabel.setLabelFor(taxTextField);
        subTotalLabel.setLabelFor(subTotalTextField);
        ButtonGroup buttonGroup;
        buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonIntel);
        buttonGroup.add(radioButtonAMD);
        buttonGroup = new ButtonGroup();
        buttonGroup.add(osRadioButton1);
        buttonGroup.add(osRadioButton2);
        buttonGroup.add(osRadioButton3);
        buttonGroup = new ButtonGroup();
        buttonGroup.add(appPackageCheckBox1);
        buttonGroup.add(appPackageCheckBox2);
        buttonGroup.add(appPackageCheckBox3);
        buttonGroup.add(appPackageCheckBox4);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel;
    }

}
