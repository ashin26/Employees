package EmployeeStats;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Iterator;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*  Class:	<b>EmployeeGUI</b>
*  File:	EmployeeGUI.java
* <pre>
*  Description:	This application displays elementary statistics abouy employees
* gross pay.
*  @author:	Aigerim Shintemirova
*  Environment:	PC, Windows 8, jdk1.7, NetBeans 8.0
*  Date:	4/23/2014
*  @version	1.0
*  @see       	javax.swing.JFrame
*  @see         java.awt.print.PrinterException
*  @see         java.awt.Toolkit;
*  @see         java.util.Date;
*  @see         java.util.ArrayList;
*  @see         java.io.BufferedReader
*  @see         java.io.FileReader
* </pre>
*  History Log:	Created on April 1, 2014, 1:12:19 AM
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class EmployeeGUI extends javax.swing.JFrame 
{
    //Formating output for currencies--could use DecimalFormat class too
    private final NumberFormat dollars = NumberFormat.getCurrencyInstance();
    
    // Need a DefaultListModel for adding objrct to a JList
    DefaultListModel listModel = new DefaultListModel();
    
    private static Employee myEmployee;
    //File name variable
    private final String fileName = "src/EmployeeStats/employeeStats.txt";    
    // ArrayList contains Employees read from the external file
    private final ArrayList<Employee> employees = new ArrayList<Employee>();   
    
    /**
     * Default constructor--creates new form EmployeeGUI
     * Creates new form Employees Pay Statistics centered, 
     * with Display Gross Pay button as default
     * The employees are read from an external text file, employeeStats.txt, into
     * an ArrayList of Employee type
     */
    public EmployeeGUI() 
    {
        initComponents();       //build the GUI
        this.setLocationRelativeTo(null);       //center form
        //Set form's icon        
        this.setIconImage(Toolkit.getDefaultToolkit()
                .getImage("src/EmployeeStats/fish.jpg"));
        //set rollButton as default
        this.getRootPane().setDefaultButton(displayJButton);
        printJMenuItem.setEnabled(false);
        //Read Employees from external file and store in the ArrayList
        readFromFile(fileName);
        displayEmployee();
    }
    
    /**
     * Method: displayEmployee
     * Reads names from external comma-delimited file, employeeStats,
     * and populates JComboBox 
     * @parem void
     * @return void
     * pre-condition: Uses the ArrayList employees.
     * post-condition: employees ArrayList is displayed 
     */
    private void displayEmployee()
    {
        employeeJComboBox.removeAllItems();
        int location = employeeJComboBox.getSelectedIndex();
        String[] namesArray = new String[employees.size()];
        for(int i = 0; i < employees.size(); i++)
        {
            namesArray[i] = employees.get(i).getName();
            employeeJComboBox.addItem(namesArray[i]);
        }
        if(location < 0)
        {
            employeeJComboBox.setSelectedIndex(0);
        }
        else
        {
            employeeJComboBox.setSelectedIndex(location);
        }
    }
    
    /**
     * Method: readFromFile
     * Reads employees from a text file that is comma delimited and
     * creates an instance of the Employee class with the data read.
     * Then the newly created employee is added to the employee database.
     * Uses an object from the ReadFile class to read record.
     * @param file: String
     * @return void
     * pre-condition: a valid file name, employeeStats.txt is expected
     * for input with comma separated text fields (but no spaces) for
     * employee name, hours worked, and pay rate
     * post-condition: a new Employee is created with the read fields
     * and added to the ArrayList
     * @see ReadFile
     * @see Member
     */
    void readFromFile(String file)
    {
        try
        {
            employees.clear();
            FileReader inputFile = new FileReader(fileName);
            BufferedReader input = new BufferedReader(inputFile);
            String line = input.readLine();
            
            while(line != null)
            {
                Employee worker = new Employee();
                StringTokenizer stringParser = new StringTokenizer(line, ",");
                while(stringParser.hasMoreElements())
                {
                    worker.setName(stringParser.nextElement().toString());
                    worker.setHours(Integer.parseInt(stringParser.nextElement().toString()));
                    worker.setRate(Float.parseFloat(stringParser.nextElement().toString()));
                }
                employees.add(worker);
                line = input.readLine();
            }
            inputFile.close();
        }
        catch(FileNotFoundException e)
        {
            e.getStackTrace();
        }
        catch(IOException e)
        {
            e.getStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    /**
     * Method: clearAll
     * Clear and set JTextFields visible
     * @parem void
     * @return void
     * pre-condition: JTextFields with certain information
     * post-condition: empty JTextFields
     */    
    private void clearAll()
    {
        //Clear and set JTextFields visible
        listModel.clear();
        employeeJComboBox.setSelectedIndex(0);
        enablePrint(false);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        infoJPanel = new javax.swing.JPanel();
        titleJLabel = new javax.swing.JLabel();
        logoJLabel = new javax.swing.JLabel();
        employeeInfoJPanel = new javax.swing.JPanel();
        employeeJComboBox = new javax.swing.JComboBox();
        displayJButton = new javax.swing.JButton();
        quitJButton = new javax.swing.JButton();
        selectJLabel = new javax.swing.JLabel();
        statsJPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        employeeJList = new javax.swing.JList();
        employeeJMenuBar = new javax.swing.JMenuBar();
        fileJMenu = new javax.swing.JMenu();
        clearJMenuItem = new javax.swing.JMenuItem();
        printJMenuItem = new javax.swing.JMenuItem();
        quitJMenuItem = new javax.swing.JMenuItem();
        employeeDataJMenu = new javax.swing.JMenu();
        newJMenuItem = new javax.swing.JMenuItem();
        editJMenuItem = new javax.swing.JMenuItem();
        deleteJMenuItem = new javax.swing.JMenuItem();
        searchJMenuItem = new javax.swing.JMenuItem();
        statsJMenu = new javax.swing.JMenu();
        meanJMenuItem = new javax.swing.JMenuItem();
        medianJMenuItem = new javax.swing.JMenuItem();
        standardJMenuItem = new javax.swing.JMenuItem();
        allJMenuItem = new javax.swing.JMenuItem();
        editJMenu = new javax.swing.JMenu();
        aboutJMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Employees Gross Pay Statistics");
        setResizable(false);

        titleJLabel.setFont(new java.awt.Font("Tempus Sans ITC", 3, 18)); // NOI18N
        titleJLabel.setForeground(new java.awt.Color(153, 0, 204));
        titleJLabel.setText("Employees Gross Pay Statistics");
        titleJLabel.setPreferredSize(new java.awt.Dimension(506, 194));

        logoJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EmployeeStats/fish.jpg"))); // NOI18N

        javax.swing.GroupLayout infoJPanelLayout = new javax.swing.GroupLayout(infoJPanel);
        infoJPanel.setLayout(infoJPanelLayout);
        infoJPanelLayout.setHorizontalGroup(
            infoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        infoJPanelLayout.setVerticalGroup(
            infoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoJPanelLayout.createSequentialGroup()
                .addComponent(titleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 45, Short.MAX_VALUE))
            .addComponent(logoJLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        getContentPane().add(infoJPanel, java.awt.BorderLayout.NORTH);

        employeeJComboBox.setToolTipText("List of the employees");
        employeeJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeJComboBoxActionPerformed(evt);
            }
        });

        displayJButton.setMnemonic('D');
        displayJButton.setText("Display Gross Pay");
        displayJButton.setToolTipText("Display Gross Pay for an employee");
        displayJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayJButtonActionPerformed(evt);
            }
        });

        quitJButton.setMnemonic('Q');
        quitJButton.setText("Quit");
        quitJButton.setToolTipText("Close the application");
        quitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitJButtonActionPerformed(evt);
            }
        });

        selectJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        selectJLabel.setText("Select Employee");

        javax.swing.GroupLayout employeeInfoJPanelLayout = new javax.swing.GroupLayout(employeeInfoJPanel);
        employeeInfoJPanel.setLayout(employeeInfoJPanelLayout);
        employeeInfoJPanelLayout.setHorizontalGroup(
            employeeInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, employeeInfoJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(employeeInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(quitJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(displayJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(employeeJComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, employeeInfoJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(selectJLabel)
                .addGap(28, 28, 28))
        );
        employeeInfoJPanelLayout.setVerticalGroup(
            employeeInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeeInfoJPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(selectJLabel)
                .addGap(18, 18, 18)
                .addComponent(employeeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(displayJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(quitJButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(employeeInfoJPanel, java.awt.BorderLayout.WEST);

        jScrollPane1.setViewportView(employeeJList);

        javax.swing.GroupLayout statsJPanelLayout = new javax.swing.GroupLayout(statsJPanel);
        statsJPanel.setLayout(statsJPanelLayout);
        statsJPanelLayout.setHorizontalGroup(
            statsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
        );
        statsJPanelLayout.setVerticalGroup(
            statsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statsJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(statsJPanel, java.awt.BorderLayout.CENTER);

        fileJMenu.setText("File");

        clearJMenuItem.setMnemonic('C');
        clearJMenuItem.setText("Clear");
        clearJMenuItem.setToolTipText("Clear the entire board.");
        clearJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(clearJMenuItem);

        printJMenuItem.setMnemonic('P');
        printJMenuItem.setText("Print");
        printJMenuItem.setToolTipText("Prints the result");
        printJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(printJMenuItem);

        quitJMenuItem.setMnemonic('Q');
        quitJMenuItem.setText("Quit");
        quitJMenuItem.setToolTipText("Click to exit the GUI.");
        quitJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(quitJMenuItem);

        employeeJMenuBar.add(fileJMenu);

        employeeDataJMenu.setMnemonic('E');
        employeeDataJMenu.setText("Employee Data");

        newJMenuItem.setMnemonic('N');
        newJMenuItem.setText("New Employee");
        newJMenuItem.setToolTipText("Add new employee to data base");
        newJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newJMenuItemActionPerformed(evt);
            }
        });
        employeeDataJMenu.add(newJMenuItem);

        editJMenuItem.setMnemonic('E');
        editJMenuItem.setText("Edit Employee");
        editJMenuItem.setToolTipText("Edit existing employee data");
        editJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editJMenuItemActionPerformed(evt);
            }
        });
        employeeDataJMenu.add(editJMenuItem);

        deleteJMenuItem.setMnemonic('D');
        deleteJMenuItem.setText("Delete Employee");
        deleteJMenuItem.setToolTipText("Delete selected employee");
        deleteJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJMenuItemActionPerformed(evt);
            }
        });
        employeeDataJMenu.add(deleteJMenuItem);

        searchJMenuItem.setMnemonic('S');
        searchJMenuItem.setText("Search Employee");
        searchJMenuItem.setToolTipText("Search employee by name");
        searchJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchJMenuItemActionPerformed(evt);
            }
        });
        employeeDataJMenu.add(searchJMenuItem);

        employeeJMenuBar.add(employeeDataJMenu);

        statsJMenu.setMnemonic('S');
        statsJMenu.setText("Statistics");

        meanJMenuItem.setMnemonic('M');
        meanJMenuItem.setText("Mean");
        meanJMenuItem.setToolTipText("Displays the mean income of all the employees");
        meanJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meanJMenuItemActionPerformed(evt);
            }
        });
        statsJMenu.add(meanJMenuItem);

        medianJMenuItem.setMnemonic('d');
        medianJMenuItem.setText("Median");
        medianJMenuItem.setToolTipText("Displays median income of all employees");
        medianJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medianJMenuItemActionPerformed(evt);
            }
        });
        statsJMenu.add(medianJMenuItem);

        standardJMenuItem.setMnemonic('S');
        standardJMenuItem.setText("Standard Deviation");
        standardJMenuItem.setToolTipText("Displays the standard deviation of the employees");
        standardJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                standardJMenuItemActionPerformed(evt);
            }
        });
        statsJMenu.add(standardJMenuItem);

        allJMenuItem.setMnemonic('T');
        allJMenuItem.setText("All Three");
        allJMenuItem.setToolTipText("");
        allJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allJMenuItemActionPerformed(evt);
            }
        });
        statsJMenu.add(allJMenuItem);

        employeeJMenuBar.add(statsJMenu);

        editJMenu.setMnemonic('H');
        editJMenu.setText("Help");

        aboutJMenuItem.setText("About");
        aboutJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutJMenuItemActionPerformed(evt);
            }
        });
        editJMenu.add(aboutJMenuItem);

        employeeJMenuBar.add(editJMenu);

        setJMenuBar(employeeJMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Event handler: quitJButtonActionPerformed
     * @param evt 
     * Closes the application
     */
    private void quitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitJButtonActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_quitJButtonActionPerformed
    /**
     * Event handler: meanJMenuItemActionPerformed
     * @param evt 
     * Calls calculateMean() to calculate mean of the incomes of all the employees
     * and displayResults() to show the output
     * @see: calculateMean()
     * @see: displayResults()
     */
    private void meanJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meanJMenuItemActionPerformed
        // Call calculateMean() to calculate mean and 
        // displayResults() to show output
        float mean = calculateMean();
        String first = "Mean gross pay for all";
        String second = "employees = " + dollars.format(mean);
        displayResults(first, second);
        printJMenuItem.setEnabled(true);
    }//GEN-LAST:event_meanJMenuItemActionPerformed

    /**
     * Method: calculateMean()
     * Calculates mean of the income of the employees
     * @return float
     * pre-condition: Uses the ArrayList employees.
     * post-condition: calculated mean of income of employees in the ArrayList
     */
    private float calculateMean()
    {        
        int numberEmployees = employees.size();
        float total = 0, meanGrossPay = 0;
        // Create an array of all gross pays
        float[] allGrossPay = new float[numberEmployees];
        
        // Call method to return an array of float containing all gross pays
        allGrossPay = calculateAllGrossPay();
        // Find total gross pay
        for (int i = 0; i < numberEmployees; i++)
        {
            total += allGrossPay[i];
        }
        // Find mean and return it
        if (numberEmployees > 0)
        {
            meanGrossPay = total/numberEmployees;
            
        }
        return meanGrossPay;
    }
    /**
     * Event handler: medianJMenuItemActionPerformed
     * @param evt 
     * Calls calculateMedian() to calculate median and 
     * displayResults() to show output
     * @see: calculateMedian()
     * @see: displayResults()
     */
    private void medianJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medianJMenuItemActionPerformed
        // TODO add your handling code here:
         // The median is the 50th percentile 
        // Call calculateMedian() to calculate median and 
        // displayResults() to show output
        float median = calculateMedian();
        String first = "Median gross pay for all";
        String second = "employees = " + dollars.format(median);
        displayResults(first, second);
        printJMenuItem.setEnabled(true);
    }//GEN-LAST:event_medianJMenuItemActionPerformed
    /**
     * Event handler: standardJMenuItemActionPerformed
     * @param evt 
     * Calls standardDeviation() to calculate standard deviation and 
     * displayResults() to show output
     * @see: standardDeviation()
     * @see: displayResults()
     */
    private void standardJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_standardJMenuItemActionPerformed
        float stdev = standardDeviation();
        if(stdev >= 1)
        {
        String first = "Standard deviation gross pay";
        String second = "for all employees = " + dollars.format(stdev);
        displayResults(first, second);
        printJMenuItem.setEnabled(true);
        }
        else
        {
            displayResults("More than one employee required to estimate Standard Deviation.",
                    "Add more employees.");
            standardJMenuItem.setEnabled(false);
            printJMenuItem.setEnabled(true);
        }
    }//GEN-LAST:event_standardJMenuItemActionPerformed
    /**
     * Method: displayResults()
     * Displays results into JList
     * @return void
     * @param firstLine
     * @param secondLine
     */ 
     private void displayResults(String firstLine, String secondLine)
    {
        listModel.clear();
        listModel.addElement(firstLine);
        listModel.addElement(secondLine);
        // Add the list model to the JList
        employeeJList.setModel(listModel);
    }
    
     /**
     * Event handler: allJMenuItemActionPerformed
     * @param evt 
     * @return void
     * Displays all three statistical measures: mean, median, 
     * and standard deviation
     * @see: calculateMean()
     * @see: calculateMedian()
     * @see: standardDeviation
     */
    private void allJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allJMenuItemActionPerformed
        // TODO add your handling code here:
        // Show all three statistical measures
        float mean = calculateMean();
        float median = calculateMedian();
        float stdev = standardDeviation();
        listModel.clear();
        listModel.addElement("Mean gross pay for all");
        listModel.addElement("employees = " + dollars.format(mean));           
        listModel.addElement("Median gross pay for all");
        listModel.addElement("employees = " + dollars.format(median));        
        listModel.addElement("Standard deviation gross pay");
        listModel.addElement("for all employees = " + dollars.format(stdev));                 
        // Add the list model to the JList
        employeeJList.setModel(listModel);
        printJMenuItem.setEnabled(true);
    }//GEN-LAST:event_allJMenuItemActionPerformed
    /**
     * Event handler: displayJButtonActionPerformed
     * @param evt 
     * @return void
     * Calculates and displays the gross pay information
     * for a selected employee in the JList
     */
    private void displayJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayJButtonActionPerformed
        // TODO add your handling code here:
            
        boolean found = false;
        float grossPay;     
        listModel.clear();              // Clean JList
        String nameAndGrossPay;         // Contains name and gross pay
        String empName = employeeJComboBox.getSelectedItem().toString();
        
        // Find the employee in the array list
        Iterator<Employee> emp = employees.iterator();
        
        while(emp.hasNext() && !found)
        {
            myEmployee = emp.next();        //get employee from array list
            if (empName.equals(myEmployee.getName()))   //if names match
            {
                // Calculate gross pay
                grossPay = myEmployee.getHours() * myEmployee.getRate();
                found = true;
                
                //Display name and gross pay in JList
                nameAndGrossPay = myEmployee.getName() + " = " + 
                      dollars.format(grossPay);
                
                listModel.addElement("Gross Pay for Employee");
                listModel.addElement(nameAndGrossPay);
                
            }
        }
        // Add the list model to the JList
        employeeJList.setModel(listModel);    
        enablePrint(true);
    }//GEN-LAST:event_displayJButtonActionPerformed
     /**
     * Event handler: newJMenuItemActionPerformed
     * @param evt 
     * @return void
     * Displays a separate AddEmployee JDialog that adds a new employee to the 
     * ArrayList and JComboBox
     * @see AddEmployee
     */
    private void newJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newJMenuItemActionPerformed
        // TODO add your handling code here:
        //Event handler for Adding a new employee                    
        try
        {
            //Create and display a new AddDialog
            boolean empExists = false;
            AddEmployee addEmployee = new AddEmployee(this, true);
            addEmployee.setVisible(true);
            Employee newEmployee = addEmployee.getEmployee();
            String employeeName = newEmployee.getName();
            empExists = findEmployee(employeeName) != null;
            if(newEmployee != null && empExists == false)
            {                
                employees.add(newEmployee);
                displayEmployee();
                saveEmployee();
            }
            else
            {
                String first = employeeName + " already exists.";
                String second = "No update was made.";
                displayResults(first, second);
                employeeJList.setVisible(true);
                employeeJList.setSelectedIndex(0);
            }
        }
        catch(NullPointerException nullex)
        {
            JOptionPane.showMessageDialog(null, "Employee not added", "Input error",
                    JOptionPane.WARNING_MESSAGE);
            employeeJList.setVisible(true);
            employeeJList.setSelectedIndex(0);        
        }
    }//GEN-LAST:event_newJMenuItemActionPerformed
    
    private void employeeJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeJComboBoxActionPerformed
    /**
     * Event handler: aboutJMenuItemActionPerformed
     * @param evt 
     * @return void
     * Displays a separate About form that describes the purpose of the 
     * application
     * @see About
     */
    private void aboutJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutJMenuItemActionPerformed
        // TODO add your handling code here:
        // Show the About form
        About myAbout = new About(this, true);
        myAbout.setVisible(true);
    }//GEN-LAST:event_aboutJMenuItemActionPerformed
    /**
     * Event handler: editJMenuItemActionPerformed
     * @param evt 
     * @return void
     * Displays a separate EditEmployee form, which allows to edit 
     * information about an existing employee
     * @see EditEmployee
     */
    private void editJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editJMenuItemActionPerformed
        // TODO add your handling code here:
        //Clear and set JTextFields visible--not a good a good implementation
        int index = employeeJComboBox.getSelectedIndex();
        try
        {
            String employeeName = employeeJComboBox.getSelectedItem().toString();

            //Create a temp city to populate fields of form
            Employee employeeToEdit = new Employee(findEmployee(employeeName));
            
            //pass city info to EdiCity constructor and view Edit form
            EditEmployee editedEmployee = new EditEmployee(this, true, employeeToEdit);
            editedEmployee.setVisible(true);
            if(editedEmployee.getEmployee() != null)
            {
                employees.remove(index);
                employees.add(index, editedEmployee.getEmployee());
                saveEmployee();
                displayEmployee();
            }
        }
        catch(NullPointerException nullex)
        {
            JOptionPane.showMessageDialog(null, "Employee not edited", "Input error",
                    JOptionPane.WARNING_MESSAGE);
            //clearAll();
            employeeJList.setVisible(true);
            employeeJList.setSelectedIndex(0);
        }

    }//GEN-LAST:event_editJMenuItemActionPerformed
    /**
     * Event handler: deleteJMenuItemActionPerformed
     * @param evt 
     * @return void
     * Deletes an employee from JComboBox as well as from the ArrayList
     */
    private void deleteJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteJMenuItemActionPerformed
        // TODO add your handling code here:
        int index = employeeJComboBox.getSelectedIndex();
        employeeJComboBox.removeItemAt(index);
        employees.remove(index);
        saveEmployee();
        clearAll();
    }//GEN-LAST:event_deleteJMenuItemActionPerformed
    /**
     * Event handler: clearJMenuItemActionPerformed
     * @param evt 
     * @return void
     * Empties the JList
     */
    private void clearJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearJMenuItemActionPerformed
        // TODO add your handling code here:
        listModel.clear();
        printJMenuItem.setEnabled(false);
    }//GEN-LAST:event_clearJMenuItemActionPerformed
    /**
     * Event handler: printJMenuItemActionPerformed
     * @param evt 
     * @return void
     * Prints the GUI
     * @see PrintUtilities
     */
    private void printJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printJMenuItemActionPerformed
        // TODO add your handling code here:
            PrintUtilities.printComponent(this);
    }//GEN-LAST:event_printJMenuItemActionPerformed
    /**
     * Event handler: quitJMenuItemActionPerformed
     * @param evt 
     * @return void
     * Close the GUI from JMenu
     */
    private void quitJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitJMenuItemActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_quitJMenuItemActionPerformed
     /**
     * Event handler: searchJMenuItemActionPerformed
     * @param evt 
     * @return void
     * Exhibits the search of an employee by name in the ArrayList and JComboBox
     * If not found, displays an error message
     * @see searchEmployee()
     */
    private void searchJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchJMenuItemActionPerformed
        try
        {
            // Get data on new employee--a separate form is better 
            String name = JOptionPane.showInputDialog("Name of Employee:");            
            boolean empExists = true;
            Employee emp = null;
            // Search for employee in employeesArrayList and if not found
            // write employee to external file and store in the ArrayList
            emp = searchEmployee(name);
            if(emp != myEmployee)
                empExists = false;
            else if(emp.equals(""))
                empExists = false;
            
            if(empExists)
            {
                employeeJComboBox.setSelectedItem(emp.getName());
                listModel.clear();              // Clean JList
                String nameAndGrossPay;         // Contains name and gross pay         
                // Calculate gross pay
                double grossPay = emp.getHours() * emp.getRate();
                                //Display name and gross pay in JList
                nameAndGrossPay = emp.getName() + " = " + 
                      dollars.format(grossPay);
                                listModel.addElement("Gross Pay for Employee");
                listModel.addElement(nameAndGrossPay);
                // Add the list model to the JList
                employeeJList.setModel(listModel);    
                enablePrint(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Employee Not Found", "Error!",
                  JOptionPane.WARNING_MESSAGE); 
                clearAll();
            }
        }
        catch (NullPointerException ex) 
        {
            JOptionPane.showMessageDialog(null, "Employee Not Found", "Error!",
                  JOptionPane.WARNING_MESSAGE); 
        }
    }//GEN-LAST:event_searchJMenuItemActionPerformed
 
/**
     * Method: enablePrint()
     * Enables or disables printJMenuItem accordingly to the content of JList
     * @return boolean
     * @param found
     */ 
private boolean enablePrint(boolean found)
    {
        if(found)
        {
            printJMenuItem.setEnabled(true);
        }
        else
        {
            printJMenuItem.setEnabled(false);
        }
        
        return found;
    }
                
    /**
     * Method: matchString()
     * Checks if name entered during search already exists in the database
     * @return boolean
     * @param s: String
     * @param key: String
     */     
private boolean matchString(String s, String key)
    {
        if (s.equals(key)) return true;
        int min = s.length()<key.length()?s.length():key.length();
        for (int i=0;i<min; ++i)
        {
            
            if(key.charAt(i) == '*')
                return true;
            if(s.charAt(i) != key.charAt(i) && key.charAt(i) != '?')
                return false;
        }
        for (int i=s.length();i<key.length();i++)
        {
            if (key.charAt(i)!='*') 
                return false;
        }
        return true;
    }
    
    /**
     * Method: searchEmployee()
     * Searches for an employee name in the database and simultaneously 
     * compares the entered name to existing ones using matchString()
     * @return Employee
     * @param empName: String
     * @see matchString()
     */     
    private Employee searchEmployee(String empName)
    {
        empName = empName.toLowerCase();
        Employee found = null;
        // Find the employee in the array list
        Iterator<Employee> emp = employees.iterator();
        while(emp.hasNext() && found == null)
        {
            myEmployee = emp.next();        //get employee from array list
            String fullName = myEmployee.getName().toLowerCase();
            String[] FirstLast = fullName.split(" ");
            
            if (
                    matchString(fullName,empName) ||
                    matchString(FirstLast[0],empName) ||
                    matchString(FirstLast[1],empName)
                )
                found = myEmployee;
        }                
        return found;
    }
    
    /**
     * Method: calculateMedian()
     * Calculates median of income of the employees in the database 
     * by creating an array
     * @return float
     */
    private float calculateMedian()
    {
        int numberEmployees = employees.size();
        int position = 0;   //kindex of where median is located
        float median = 0;
        
        // Create an array of all gross pays
        float[] allGrossPay = new float[numberEmployees];
        allGrossPay = calculateAllGrossPay();
        
        //Sort the array
        Arrays.sort(allGrossPay);
        // For even number of entries median is the mean of the two middle points
        if (numberEmployees % 2 == 0)     
        {
            median = (allGrossPay[numberEmployees/2] + 
                    allGrossPay[numberEmployees/2 - 1])/2;
        }
        else
        {
            median = allGrossPay[numberEmployees/2];
        }        
        return median;
    }
     /**
     * Method: calculateAllGrossPay()
     * Creates an array of all gross pay of the employees
     * @return float
     * @see calculateMedian()
     * @see calculateMean()
     * @see standardDeviation()
     */   
    private float[] calculateAllGrossPay()
    {
        int numberEmployees = employees.size();
        float[] allGrossPay = new float[numberEmployees];
        int position = 0;
        Iterator<Employee> emp = employees.iterator();
        while(emp.hasNext())
        {
            myEmployee = emp.next();
            allGrossPay[position] = myEmployee.getHours() * myEmployee.getRate();
            position++;
        }
        return allGrossPay;
    }
    
    /**
     * Method: standardDeviation()
     * Calculates standard deviation of all employees gross pay
     * @return float
     * @see calculateAllGrossPay()
     */   
    private float standardDeviation()
    {
        // Calculate standard deviation based on math formula
        int numberEmployees = employees.size();
        float stdev = 0f, sumSquares = 0f, 
              meanGrossPay = calculateMean();
        
        // Call method to return an array of float containing all gross pays
        float[] allGrossPay = calculateAllGrossPay();
                              
        // Find sum of squares
        for (int i = 0; i < numberEmployees; i++)
        {
            sumSquares += Math.pow((allGrossPay[i] - meanGrossPay), 2);            
        }
        // Calculate standard deviation
        if (numberEmployees > 1)
        {
            stdev = (float) Math.sqrt(sumSquares/(numberEmployees - 1));
        }
        return stdev;
    }
    /**
     * Method: findEmployee()
     * Looks for an employee in the ArrayList
     * @return Employee
     * @param employeeName: String
     * @see calculateAllGrossPay()
     */   
    private Employee findEmployee(String employeeName)
    {
        int index = -1;
        //nameJRadioButtonMenuItem.doClick();
        for(int i = 0; i < employees.size(); i++)
        {
            if(employeeName.equals(employees.get(i).getName()))
                index = i;
        }
        if(index >= 0)
            return employees.get(index);
        else
            return null;
    }
    /**
     * Method: saveEmployee()
     * Saves information about an employee in the ArrayList
     * @return void
     */ 
    private void saveEmployee()
    {
        Employee tempEmployee = new Employee();
        String line = "";
        try
        {
            PrintWriter out = new PrintWriter(fileName);
            for(int i = 0; i < employees.size(); i++)
            {
                tempEmployee = (Employee) employees.get(i);
                line = tempEmployee.getName() + "," + tempEmployee.getHours() + "," +
                        tempEmployee.getRate();
                out.println(line);
            }
            out.close();   
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {
        //show a splash screen before loading the form
        Splash mySplash = new Splash(4000);
        mySplash.showSplash();
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new EmployeeGUI().setVisible(true);                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutJMenuItem;
    private javax.swing.JMenuItem allJMenuItem;
    private javax.swing.JMenuItem clearJMenuItem;
    private javax.swing.JMenuItem deleteJMenuItem;
    private javax.swing.JButton displayJButton;
    private javax.swing.JMenu editJMenu;
    private javax.swing.JMenuItem editJMenuItem;
    private javax.swing.JMenu employeeDataJMenu;
    private javax.swing.JPanel employeeInfoJPanel;
    private javax.swing.JComboBox employeeJComboBox;
    private javax.swing.JList employeeJList;
    private javax.swing.JMenuBar employeeJMenuBar;
    private javax.swing.JMenu fileJMenu;
    private javax.swing.JPanel infoJPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logoJLabel;
    private javax.swing.JMenuItem meanJMenuItem;
    private javax.swing.JMenuItem medianJMenuItem;
    private javax.swing.JMenuItem newJMenuItem;
    private javax.swing.JMenuItem printJMenuItem;
    private javax.swing.JButton quitJButton;
    private javax.swing.JMenuItem quitJMenuItem;
    private javax.swing.JMenuItem searchJMenuItem;
    private javax.swing.JLabel selectJLabel;
    private javax.swing.JMenuItem standardJMenuItem;
    private javax.swing.JMenu statsJMenu;
    private javax.swing.JPanel statsJPanel;
    private javax.swing.JLabel titleJLabel;
    // End of variables declaration//GEN-END:variables
}