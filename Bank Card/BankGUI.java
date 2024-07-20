
/**
 * @author (Saman Gautam)
 * @version (version 1.1)
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.border.*;

public class BankGUI
{
    //components of GUI for main frame
    JFrame frame_Main; //the main window of GUI
    JPanel panel_Main;
    JLabel heading,headingLogo,option;
    JButton debit, credit;
    
    //components of GUI for Debit Card
    JFrame frame_Debit;
    JPanel panel_Debit;
    JLabel debit_Head,balance,bank_Account,card_Id,issuerBank,clientName,pinNum,withdrawlDate,withdrawAmount;
    JTextField box_Balance,box_bankAccount,box_CardId,box_IssuerBank,box_ClientName,box_PinNum,box_WithdrawlDate,box_WithdrawAmount;
    JComboBox<String> combo_Day,combo_Month,combo_Year;
    JButton btn_Add, btn_Clear, btn_Debit_Display, btn_Withdraw, btn_GoBack;
    
    //components of GUI for Credit Card
    JFrame frame_Credit;
    JPanel panel_Credit;
    JLabel heading_Credit,creditCardId,creditIssuerBank,creditBankAccount,creditBalanceAmount,cvcNum,interestRate,expiryDate,gracePeriod,creditLimit;
    JTextField box_CreditClientName,box_CreditCardId,box_CreditIssuerBank,box_CreditBankAccount,box_CreditBalanceAmount,box_CvcNum,box_InterestRate,box_ExpiryDate,box_GracePeriod,box_CreditLimit;
    JButton btn_CreditAdd,btn_CreditSet,btn_CreditCancel,btn_CreditDisplay,btn_CreditClear,btn_CreditGoBack;
    JComboBox<String> combo_ExpiryDay,combo_ExpiryMonth,combo_ExpiryYear;
    
    ArrayList<BankCard> arrayBankCard = new ArrayList<BankCard>();       //Arraylist for GUI
    
    //GUI constuction for main frame
    public BankGUI()
    {
        frame_Main = new JFrame("Bank GUI"); //creating frame of the GUI
        
        //changing the logo in frame
        Image logoImage = new ImageIcon("blue.jpg").getImage();
        frame_Main.setIconImage(logoImage); //Set the logo for the JFrame
        
        //adding panel in the GUI
        panel_Main = new JPanel();
        frame_Main.add(panel_Main);
        panel_Main.setLayout(null);
        panel_Main.setBackground(new Color(235, 243, 255));
    
        //adding components inside the panel
        heading = new JLabel(" National Bank of England");
        panel_Main.add(heading);
        heading.setBounds(190,10,540,40);
        heading.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        
        // Sub Heading for GUI
        option = new JLabel("Choose a card type to continue:");
        panel_Main.add(option);
        option.setBounds(180,80,400,30);
        option.setFont(new Font("Arial", Font.BOLD, 24));
        
        //debit card buttons of the GUI
        debit = new JButton("Debit Card");
        panel_Main.add(debit);
        debit.setBounds(110, 180, 200, 50);
        debit.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        debit.setBackground(Color.BLACK);
        debit.setForeground(Color.WHITE);
    
        //adding event handling in Debit button
        debit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent clicked_debit_button) 
            {
                DebitCard();
                frame_Main.dispose();
            }
        });
        
        //Creating hover effect
        debit.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent hover) {
                debit.setBackground(Color.WHITE);
                debit.setForeground(Color.BLUE);
            }
            
            public void mouseExited(MouseEvent hover) {
                debit.setBackground(Color.BLACK);
                debit.setForeground(Color.WHITE);
            }
        });
        
        //credit card buttons of the GUI
        credit = new JButton("Credit Card");
        panel_Main.add(credit);
        credit.setBounds(370, 180, 200, 50);
        credit.setFont(new Font("Comic Sans MS", Font.BOLD, 16)); 
        credit.setBackground(Color.BLACK);
        credit.setForeground(Color.WHITE);
        
        //adding event handling in Credit Button
        credit.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent clicked_credit_button)
           {
               CreditCard();
               frame_Main.dispose();
           }
        });
        
        credit.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent hover) {
                credit.setBackground(Color.WHITE);
                credit.setForeground(Color.BLUE);
            }
            
            public void mouseExited(MouseEvent hover) {
                credit.setBackground(Color.BLACK);
                credit.setForeground(Color.WHITE);
            }
        });
        
        //modifying frame
        frame_Main.setSize(700,400);
        frame_Main.setVisible(true);
        frame_Main.setResizable(false);
        frame_Main.setLocationRelativeTo(null); 
        frame_Main.setDefaultCloseOperation(frame_Main.EXIT_ON_CLOSE);
    }
    

    //GUI construction for Debit Card
    public void DebitCard()
    {
        frame_Debit = new JFrame("Debit Card"); //creating frame of GUI
        
        //changing the logo in frame
        Image logoImage = new ImageIcon("blue.jpg").getImage();
        frame_Debit.setIconImage(logoImage); //Set the logo for the JFrame
        
        //adding panel i GUI
        panel_Debit = new JPanel();
        frame_Debit.add(panel_Debit);
        panel_Debit.setLayout(null);
        panel_Debit.setBackground(new Color(214, 237, 205));
        panel_Debit.setBorder(new CompoundBorder(BorderFactory.createLineBorder(new Color(0,0,0), 8), BorderFactory.createLineBorder(new Color(80,80,80),8)));
        
        //heading of debit card
        debit_Head = new JLabel("Debit Card");
        panel_Debit.add(debit_Head);
        debit_Head.setBounds(380,19,250,40);
        debit_Head.setFont(new Font("Arial", Font.BOLD,24));
        debit_Head.setForeground(new Color(23, 105, 47));
        
        //border for textboxes
        Border border = BorderFactory.createLineBorder(new Color(0,0,0), 1);
        
        //attributes of debit card
        balance = new JLabel("Balance Amount:");  //balance 
        panel_Debit.add(balance);
        balance.setBounds(60,90,150,30);
        balance.setFont(new Font("Arial", Font.BOLD,16));
        
        box_Balance = new JTextField();
        panel_Debit.add(box_Balance);
        box_Balance.setBounds(220,90,195,30);
        box_Balance.setFont(new Font("Arial", Font.PLAIN,14));
        box_Balance.setBorder(border);
        
        bank_Account = new JLabel("Bank Account:"); //Bank Account
        panel_Debit.add(bank_Account);
        bank_Account.setBounds(60,150,120,30);
        bank_Account.setFont(new Font("Arial", Font.BOLD,16));
        
        box_bankAccount = new JTextField();
        panel_Debit.add(box_bankAccount);
        box_bankAccount.setBounds(220,150,195,30);
        box_bankAccount.setFont(new Font("Arial", Font.PLAIN,14));
        box_bankAccount.setBorder(border);
        
        clientName = new JLabel("Client Name:");    //Client Name
        panel_Debit.add(clientName);
        clientName.setBounds(480,150,120,30);
        clientName.setFont(new Font("Arial", Font.BOLD,16));
        
        box_ClientName = new JTextField();
        panel_Debit.add(box_ClientName);
        box_ClientName.setBounds(620,150,195,30);
        box_ClientName.setFont(new Font("Arial", Font.PLAIN,14));
        box_ClientName.setBorder(border);
        
        issuerBank = new JLabel("Issuer Bank:");    //Issuer Bank
        panel_Debit.add(issuerBank);
        issuerBank.setBounds(480,90,120,30);
        issuerBank.setFont(new Font("Arial", Font.BOLD, 16));
        
        box_IssuerBank = new JTextField();
        panel_Debit.add(box_IssuerBank);
        box_IssuerBank.setBounds(620,90,195,30);
        box_IssuerBank.setFont(new Font("Arial", Font.PLAIN,14));
        box_IssuerBank.setBorder(border);
        
        card_Id = new JLabel("Card ID:");      //Card ID
        panel_Debit.add(card_Id);
        card_Id.setBounds(60,250,120,30);
        card_Id.setFont(new Font("Arial", Font.BOLD, 16));
        
        box_CardId = new JTextField();
        panel_Debit.add(box_CardId);
        box_CardId.setBounds(220,250,195,30);
        box_CardId.setFont(new Font("Arial", Font.PLAIN,14));
        box_CardId.setBorder(border);
        
        pinNum = new JLabel("PIN Num:");       //Pin Num
        panel_Debit.add(pinNum);
        pinNum.setBounds(60,330,100,30);
        pinNum.setFont(new Font("Arial", Font.BOLD, 16));
        
        box_PinNum = new JTextField();
        panel_Debit.add(box_PinNum);
        box_PinNum.setBounds(220,320,195,30);
        box_PinNum.setFont(new Font("Arial", Font.PLAIN,14));
        box_PinNum.setBorder(border);
        
        withdrawAmount = new JLabel("Withdraw Amount:");    //Withdraw Amount
        panel_Debit.add(withdrawAmount);
        withdrawAmount.setBounds(60,410,150,30);
        withdrawAmount.setFont(new Font("Arial", Font.BOLD,16));
        
        box_WithdrawAmount = new JTextField();
        panel_Debit.add(box_WithdrawAmount);
        box_WithdrawAmount.setBounds(220,410,195,30);
        box_WithdrawAmount.setBorder(border);
        
        //JComboBox for withdrawl date
        withdrawlDate = new JLabel("Withdrawl Date:");
        panel_Debit.add(withdrawlDate);
        withdrawlDate.setBounds(480,360,150,30);
        withdrawlDate.setFont(new Font("Arial", Font.BOLD, 16));
        
        //creating array for day, month and year
        String[] day = new String[31];
        String[] month = new String[] {"Jan","Feb","March","April","May","June","July","Aug","Sept","Oct","Nov","Dec"};
        String[] year = new String[]{"2023"};
        
        
        /**
         * This set of loops are used to get numbers which is required for the combobox Day
         */
        for(int i = 31; i>=1; i--){
            day[i-1] = String.valueOf(i);
        }
        
        //Combobox for withdraw date
        combo_Day = new JComboBox<String>(day);
        panel_Debit.add(combo_Day);
        combo_Day.setBounds(620,360,50,35);
        combo_Day.setFont(new Font("Arial", Font.PLAIN,14));
        
        combo_Month = new JComboBox<String>(month);
        panel_Debit.add(combo_Month);
        combo_Month.setBounds(685,360,70,35);
        combo_Month.setFont(new Font("Arial", Font.PLAIN,14));
        
        combo_Year = new JComboBox<String>(year);
        panel_Debit.add(combo_Year);
        combo_Year.setBounds(770,360,70,35);
        combo_Year.setFont(new Font("Arial", Font.PLAIN,14));
        
        //Go Back button for Debit Card
        btn_GoBack = new JButton("Go Back <<");
        panel_Debit.add(btn_GoBack);
        btn_GoBack.setBounds(60,480,100,35);
        btn_GoBack.setFont(new Font("Arial", Font.BOLD, 14));
        btn_GoBack.setBackground(new Color(163, 163, 163));
        btn_GoBack.setForeground(Color.BLACK);
        btn_GoBack.setBorder(border);
        
            //hover effect for Go Back button
            btn_GoBack.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent hover) {
                btn_GoBack.setBackground(Color.WHITE);
                btn_GoBack.setForeground(Color.BLUE);
            }
            
            public void mouseExited(MouseEvent hover) {
                btn_GoBack.setBackground(new Color(163, 163, 163));
                btn_GoBack.setForeground(Color.BLACK);
            }
        });
        
        //adding event handling in Go Back button
        btn_GoBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent clicked_GoBack_button) 
            {
                new BankGUI();
                frame_Debit.dispose();
            }
        });
        
        //Withdraw Button for Debit Card
        btn_Withdraw = new JButton("Withdraw");
        panel_Debit.add(btn_Withdraw);
        btn_Withdraw.setBounds(315,480,100,35); 
        btn_Withdraw.setFont(new Font("Arial", Font.BOLD, 14));
        btn_Withdraw.setBackground(new Color(163, 163, 163));
        btn_Withdraw.setForeground(Color.BLACK);
        btn_Withdraw.setBorder(border);
        
            //hover effect for Withdraw button
            btn_Withdraw.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent hover_Withdraw) {
                btn_Withdraw.setBackground(Color.WHITE);
                btn_Withdraw.setForeground(Color.BLUE);
            }
            
            public void mouseExited(MouseEvent hover_Withdraw) {
                btn_Withdraw.setBackground(new Color(163, 163, 163));
                btn_Withdraw.setForeground(Color.BLACK);
            }
        });
        
        //withdrawing money from bank account
             btn_Withdraw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent withdraw) {
                // checking if user is leaving any field empty before withdrawing
                if (box_WithdrawAmount.getText().isEmpty() || box_PinNum.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame_Debit, "Please fill the required field to withdraw money", "Empty Field", JOptionPane.ERROR_MESSAGE);
                } 
                else {
                    if (Integer.parseInt(box_WithdrawAmount.getText()) < 0 || Integer.parseInt(box_PinNum.getText()) < 0) {
                        JOptionPane.showMessageDialog(frame_Debit, "You cannot give values less than zero", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    } 
                    else {
                        try {
                            // values for method "Withdraw"
                            int withdrawlAmount = Integer.parseInt(box_WithdrawAmount.getText());
                            String day = (String) combo_Day.getSelectedItem();
                            String month = (String) combo_Month.getSelectedItem();
                            String year = (String) combo_Year.getSelectedItem();
                            String dateofWithdrawl = day + "/" + month + "/" + year;
                            int input_Pin = Integer.parseInt(box_PinNum.getText());
                            boolean card_Found = false;
        
                            //method to withdraw
                            for (BankCard withdraw_money : arrayBankCard) {
                                if (withdraw_money instanceof DebitCard) {
                                    DebitCard debitCard = (DebitCard) withdraw_money; // downcasting of BankCard into DebitCard
                                    if (Integer.parseInt(box_CardId.getText()) == debitCard.getCardID()) {
                                        card_Found = true;
                                        if (Integer.parseInt(box_PinNum.getText()) == debitCard.getPin_Num()) {
                                            if (Integer.parseInt(box_WithdrawAmount.getText()) <= debitCard.getBalanceAmount()) {
                                            debitCard.Withdraw(withdrawlAmount, dateofWithdrawl, input_Pin); // method called from Debit Card class for withdrawing money
                                                JOptionPane.showMessageDialog(frame_Debit, withdrawlAmount + " Withdrawn Successfully" + "\n" + "Date: "
                                                + dateofWithdrawl + "\n" + "Pin Num: " + input_Pin, "Money Withdraw", JOptionPane.INFORMATION_MESSAGE);
                                            } 
                                            else {
                                                JOptionPane.showMessageDialog(frame_Debit, "Insufficient Balance", "Balance Insufficient", JOptionPane.ERROR_MESSAGE);
                                            }
                                        } 
                                        else{
                                            JOptionPane.showMessageDialog(frame_Debit, "Pin Number does not match", "Invalid Pin", JOptionPane.ERROR_MESSAGE);
                                        }
                                        break;
                                    }
                                }
                            }
                            //throws a message if card ID is not found
                            if (card_Found == false) {
                                JOptionPane.showMessageDialog(frame_Debit, "Card ID does not match", "Card ID Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame_Debit, "Please enter valid data in required field", "Input Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });
        
        //Button to add Debit Card in Array List
        btn_Add = new JButton("Add");
        panel_Debit.add(btn_Add);
        btn_Add.setBounds(490,250,100,35);
        btn_Add.setFont(new Font("Arial", Font.BOLD, 14));
        btn_Add.setBackground(new Color(163, 163, 163));
        btn_Add.setForeground(Color.BLACK);
        btn_Add.setBorder(border);
        
            //hover effect for Add button
            btn_Add.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent hover_Add) {
                btn_Add.setBackground(Color.WHITE);
                btn_Add.setForeground(Color.BLUE);
            }
            
            public void mouseExited(MouseEvent hover_Withdraw) {
                btn_Add.setBackground(new Color(163, 163, 163));
                btn_Add.setForeground(Color.BLACK);
            }
        });
        
        /**
         * When "Add Button" is clicked in Debit Card GUI then it add all the elements in the arraylist "BankCard" creating an object of Debit Card
         * A dialogue box is poped up when the values are added in arraylist successfully
         */
        btn_Add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent add_object)
            {
                //Checks if a user kept any text field empty
                if(box_Balance.getText().isEmpty() || box_bankAccount.getText().isEmpty() || box_IssuerBank.getText().isEmpty() || box_CardId.getText().isEmpty() || box_ClientName.getText().isEmpty() || box_PinNum.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(frame_Main,"You cannot keep a field empty!!!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    try{
                        if(Integer.parseInt(box_Balance.getText())<0 || Integer.parseInt(box_CardId.getText())<0 || Integer.parseInt(box_PinNum.getText())<0){
                            JOptionPane.showMessageDialog(frame_Debit,"You cannot give values less than zero", "Card ID Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else if(box_bankAccount.getText().matches(".*\\d.*")) {
                            JOptionPane.showMessageDialog(frame_Debit,"Bank account cannot have numbers", "Input Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else if(box_IssuerBank.getText().matches(".*\\d.*")) {
                            JOptionPane.showMessageDialog(frame_Debit,"Issuer bank cannot have numbers", "Input Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else if(box_ClientName.getText().matches(".*\\d.*")) {
                            JOptionPane.showMessageDialog(frame_Debit,"Client name cannot have numbers", "Input Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            //values to add in array list
                            int balanceAmount = Integer.parseInt(box_Balance.getText());
                            String bankAccount = box_bankAccount.getText();
                            String issuerBank = box_IssuerBank.getText();
                            int cardId = Integer.parseInt(box_CardId.getText());
                            String clientName = box_ClientName.getText();
                            int pin_Num = Integer.parseInt(box_PinNum.getText());
        
                            // Check if card with same ID already exists in the list
                            boolean cardExists = false;
                            for (BankCard card: arrayBankCard) {
                                if (card instanceof DebitCard) {
                                    DebitCard debitCard = (DebitCard) card;
                                    if(debitCard.getCardID() == cardId) {
                                        cardExists = true;
                                        break;
                                    }
                                }
                            }
                            //throws a message if user try to add same card ID in array list
                            if (cardExists == true) {
                                JOptionPane.showMessageDialog(frame_Debit, "Card ID already exits", "Card ID Error", JOptionPane.ERROR_MESSAGE);
                            } 
                            else{
                                DebitCard objDebitCard = new DebitCard(balanceAmount,cardId,bankAccount,issuerBank,clientName,pin_Num);
                                arrayBankCard.add(objDebitCard);
                                JOptionPane.showMessageDialog(frame_Debit, "Values Stored in Array List", "SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);
                                clear_Texts();
                            }
                        }
                    }
                    //exception handling for NumberFormatException
                    catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(frame_Debit, "Invalid input. Please enter correct value in respective boxes", "Error", JOptionPane.ERROR_MESSAGE); 
                    }
                } 
            }
        });
        
        //Display Button for Debit Card
        btn_Debit_Display = new JButton("Display");
        panel_Debit.add(btn_Debit_Display);
        btn_Debit_Display.setBounds(650,250,100,35);
        btn_Debit_Display.setFont(new Font("Arial", Font.BOLD, 14));
        btn_Debit_Display.setBackground(new Color(163, 163, 163));
        btn_Debit_Display.setForeground(Color.BLACK);
        btn_Debit_Display.setBorder(border);
        
            //hover effect for Display button
            btn_Debit_Display.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent hover_Display) {
                btn_Debit_Display.setBackground(Color.WHITE);
                btn_Debit_Display.setForeground(Color.BLUE);
            }
            
            public void mouseExited(MouseEvent hover_Display) {
                btn_Debit_Display.setBackground(new Color(163, 163, 163));
                btn_Debit_Display.setForeground(Color.BLACK);
            }
        });
        
        /**
         * Displaying the arraylist in Debit Card
         * When display button is clicked then all the values that are stored in the array list are displayed
         */
        
        btn_Debit_Display.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent display_object)
            {
                //checks if an array list is empty
                if(arrayBankCard.isEmpty()){
                    JOptionPane.showMessageDialog(frame_Debit,"No Debit Card Found", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    //display all the elements in the array list
                for(BankCard display: arrayBankCard){
                    if(display instanceof DebitCard){
                        DebitCard debitCard = (DebitCard) display;          //Downcasting BankCard into DebitCard using its variable display
                        System.out.println("==================================");
                        System.out.println("Debit Card Information: ");
                        System.out.println("\n" + "Card ID: "+ debitCard.getCardID()+ "\n" + "Client Name: " + debitCard.getClientName()+"\n" + "Balance Amount: "+ debitCard.getBalanceAmount()+"\n" 
                        + "Issuer Bank: " + debitCard.getIssuerBank()+"\n" + "Bank Account: " + debitCard.getBankAccount()+"\n" + "Pin Num: " + debitCard.getPin_Num());
                        System.out.println("==================================");
                        System.out.println("\n");
                        }
                    }
                }
            }
        });

        //Clear Button for Debit Card
        btn_Clear = new JButton("Clear");
        panel_Debit.add(btn_Clear);
        btn_Clear.setBounds(490,480,100,35); 
        btn_Clear.setFont(new Font("Arial", Font.BOLD, 14));
        btn_Clear.setBackground(new Color(163, 163, 163));
        btn_Clear.setForeground(Color.BLACK);
        btn_Clear.setBorder(border);
        
         //hover effect for Clear button
            btn_Clear.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent hover_Clear) {
                btn_Clear.setBackground(Color.WHITE);
                btn_Clear.setForeground(Color.BLUE);
            }
            
            public void mouseExited(MouseEvent hover_Display) {
                btn_Clear.setBackground(new Color(163, 163, 163));
                btn_Clear.setForeground(Color.BLACK);
            }
        });
        
        //Clearing the textboxes
        btn_Clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent clear_Textfields) 
            {
                clear_Texts();
            }
        });
        
        //modifying frame
        frame_Debit.setVisible(true);
        frame_Debit.setSize(900,600);
        frame_Debit.setResizable(false);
        frame_Debit.setDefaultCloseOperation(frame_Debit.EXIT_ON_CLOSE);
        frame_Debit.setLocationRelativeTo(null);
    }
    
    
    //Method to clear text in debit card
    public void clear_Texts()
    {
        try{
            box_Balance.setText("");
            box_bankAccount.setText("");
            box_IssuerBank.setText("");
            box_CardId.setText("");
            box_ClientName.setText("");
            box_PinNum.setText("");
            box_WithdrawAmount.setText("");
        }
        catch(NullPointerException ex){
            JOptionPane.showMessageDialog(frame_Debit,"Error clearing the text fields","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //GUI construction for Credit Card
    public void CreditCard()
    {
        frame_Credit = new JFrame("Credit Card"); //Frame of the GUI
        
        //changing the logo in frame
        Image logoImage = new ImageIcon("blue.jpg").getImage();
        frame_Credit.setIconImage(logoImage); //Set the logo for the JFrame  
        
        //panel of GUI
        panel_Credit = new JPanel();
        frame_Credit.add(panel_Credit);
        panel_Credit.setLayout(null);
        panel_Credit.setBackground(new Color(214, 237, 205));
        panel_Credit.setBorder(new CompoundBorder(BorderFactory.createLineBorder(new Color(0,0,0), 8), BorderFactory.createLineBorder(new Color(80,80,80),8)));
        
        //border for textboxes
        Border border = BorderFactory.createLineBorder(new Color(0,0,0), 1);
        
        heading_Credit = new JLabel("Credit Card"); //heading of the GUI
        panel_Credit.add(heading_Credit);
        heading_Credit.setBounds(390,15,250,40);
        heading_Credit.setFont(new Font("Arial", Font.BOLD, 24));
        heading_Credit.setForeground(new Color(23, 105, 47));
        
        //Client Name
        clientName = new JLabel("Client Name:");    
        panel_Credit.add(clientName);
        clientName.setBounds(480,130,120,30);
        clientName.setFont(new Font("Arial", Font.BOLD,16));
        
        box_CreditClientName = new JTextField();
        panel_Credit.add(box_CreditClientName);
        box_CreditClientName.setBounds(620,130,195,30);
        box_CreditClientName.setFont(new Font("Arial", Font.PLAIN,14));
        box_CreditClientName.setBorder(border);
        
        //Card ID
        creditCardId = new JLabel("Card ID:");
        panel_Credit.add(creditCardId);
        creditCardId.setBounds(60,325,100,30);
        creditCardId.setFont(new Font("Arial", Font.BOLD,16));
        
        box_CreditCardId = new JTextField();
        panel_Credit.add(box_CreditCardId);
        box_CreditCardId.setBounds(220,325,195,30);
        box_CreditCardId.setFont(new Font("Arial", Font.PLAIN,14));
        box_CreditCardId.setBorder(border);
        
        //Issuer Bank
        creditIssuerBank = new JLabel("Issuer Bank:");
        panel_Credit.add(creditIssuerBank);
        creditIssuerBank.setBounds(60,190,120,30);
        creditIssuerBank.setFont(new Font("Arial", Font.BOLD,16));
        
        box_CreditIssuerBank = new JTextField();
        panel_Credit.add(box_CreditIssuerBank);
        box_CreditIssuerBank.setBounds(220,190,195,30);
        box_CreditIssuerBank.setFont(new Font("Arial", Font.PLAIN,14));
        box_CreditIssuerBank.setBorder(border);
        
        //Bank Account
        creditBankAccount = new JLabel("Bank Account:");
        panel_Credit.add(creditBankAccount);
        creditBankAccount.setBounds(60,130,120,30);
        creditBankAccount.setFont(new Font("Arial", Font.BOLD,16));
        
        box_CreditBankAccount = new JTextField();
        panel_Credit.add(box_CreditBankAccount);
        box_CreditBankAccount.setBounds(220,130,195,30);
        box_CreditBankAccount.setFont(new Font("Arial", Font.PLAIN,14));
        box_CreditBankAccount.setBorder(border);
        
        //Balance Amount
        creditBalanceAmount = new JLabel("Balance Amount:");
        panel_Credit.add(creditBalanceAmount);
        creditBalanceAmount.setBounds(60,70,150,30);
        creditBalanceAmount.setFont(new Font("Arial", Font.BOLD,16));
        
        box_CreditBalanceAmount = new JTextField();
        panel_Credit.add(box_CreditBalanceAmount);
        box_CreditBalanceAmount.setBounds(220,70,195,30);
        box_CreditBalanceAmount.setFont(new Font("Arial", Font.PLAIN,14));
        box_CreditBalanceAmount.setBorder(border);
        
        //CVC Num
        cvcNum = new JLabel("CVC Num:");
        panel_Credit.add(cvcNum);
        cvcNum.setBounds(480,70,90,30);
        cvcNum.setFont(new Font("Arial", Font.BOLD,16));
        
        box_CvcNum = new JTextField();
        panel_Credit.add(box_CvcNum);
        box_CvcNum.setBounds(620,70,195,30);
        box_CvcNum.setFont(new Font("Arial", Font.PLAIN,14));
        box_CvcNum.setBorder(border);
        
        //Interest Rate
        interestRate = new JLabel("Interest Rate:");
        panel_Credit.add(interestRate);
        interestRate.setBounds(480,190,120,30);
        interestRate.setFont(new Font("Arial", Font.BOLD,16));
        
        box_InterestRate = new JTextField();
        panel_Credit.add(box_InterestRate);
        box_InterestRate.setBounds(620,190,195,30);
        box_InterestRate.setFont(new Font("Arial", Font.PLAIN,14));
        box_InterestRate.setBorder(border);
        
        //Grace Period
        gracePeriod = new JLabel("Garce Period:");
        panel_Credit.add(gracePeriod);
        gracePeriod.setBounds(480,390,120,30);
        gracePeriod.setFont(new Font("Arial", Font.BOLD,16));
        
        box_GracePeriod = new JTextField();
        panel_Credit.add(box_GracePeriod);
        box_GracePeriod.setBounds(620,390,195,30);
        box_GracePeriod.setFont(new Font("Arial", Font.PLAIN,14));
        box_GracePeriod.setBorder(border);

        //Credit Limit
        creditLimit = new JLabel("Credit Limit:");
        panel_Credit.add(creditLimit);
        creditLimit.setBounds(60,390,130,30);
        creditLimit.setFont(new Font("Arial", Font.BOLD,16));
        
        box_CreditLimit = new JTextField();
        panel_Credit.add(box_CreditLimit);
        box_CreditLimit.setBounds(220,390,195,30);
        box_CreditLimit.setFont(new Font("Arial", Font.PLAIN,14));
        box_CreditLimit.setBorder(border);
        
        //Expiry Date
        expiryDate = new JLabel("Expiry Date:");
        panel_Credit.add(expiryDate);
        expiryDate.setBounds(280,260,120,30);
        expiryDate.setFont(new Font("Arial", Font.BOLD,16));
        
        //creating array for day, month and year
        String[] day = new String[31];
        String[] month = new String[] {"Jan","Feb","March","April","May","June","July","Aug","Sept","Oct","Nov","Dec"};
        String[] year = new String[16];
        
        
        /**
         * This set of loops are used to get numbers which is required for the combobox Day and Year
         */
        for(int i = 31; i>=1; i--){
            day[i-1] = String.valueOf(i);
        }
        
        for(int i= 2038; i>=2023; i--){
            year[i-2023] = String.valueOf(i);
        }
        
        //Combo Boxes for Expiry Date
        combo_ExpiryDay = new JComboBox<String>(day);
        panel_Credit.add(combo_ExpiryDay);
        combo_ExpiryDay.setBounds(410,260,50,35);
        combo_ExpiryDay.setFont(new Font("Arial", Font.PLAIN,14));
        
        combo_ExpiryMonth = new JComboBox<String>(month);
        panel_Credit.add(combo_ExpiryMonth);
        combo_ExpiryMonth.setBounds(475,260,70,35);
        combo_ExpiryMonth.setFont(new Font("Arial", Font.PLAIN,14));
        
        combo_ExpiryYear = new JComboBox<String>(year);
        panel_Credit.add(combo_ExpiryYear);
        combo_ExpiryYear.setBounds(560,260,70,35);
        combo_ExpiryYear.setFont(new Font("Arial", Font.PLAIN,14));
        
        //Go Back button
        btn_CreditGoBack = new JButton("Go Back <<");
        panel_Credit.add(btn_CreditGoBack);
        btn_CreditGoBack.setBounds(60,460,100,35);
        btn_CreditGoBack.setFont(new Font("Arial", Font.BOLD, 14));
        btn_CreditGoBack.setBackground(new Color(163, 163, 163));
        btn_CreditGoBack.setForeground(Color.BLACK);
        btn_CreditGoBack.setBorder(border);
        
        //adding event handling in Go Back button
        btn_CreditGoBack.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent clicked_goBack_Button)
           {
               new BankGUI();
               frame_Credit.dispose();
           }
        });
        
        //Hover effects for back button
        btn_CreditGoBack.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent hover_Back) {
                btn_CreditGoBack.setBackground(Color.WHITE);
                btn_CreditGoBack.setForeground(Color.BLUE);
            }
            
            public void mouseExited(MouseEvent exit_Back) {
                btn_CreditGoBack.setBackground(new Color(163, 163, 163));
                btn_CreditGoBack.setForeground(Color.BLACK);
            }
        });
        
        //Adds the CreditCard in array list
        btn_CreditAdd = new JButton("Add");
        panel_Credit.add(btn_CreditAdd);
        btn_CreditAdd.setBounds(480,322,100,35);
        btn_CreditAdd.setFont(new Font("Arial", Font.BOLD, 14));
        btn_CreditAdd.setBackground(new Color(163, 163, 163));
        btn_CreditAdd.setForeground(Color.BLACK);
        btn_CreditAdd.setBorder(border);
        
        btn_CreditAdd.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent hover_Add) {
                btn_CreditAdd.setBackground(Color.WHITE);
                btn_CreditAdd.setForeground(Color.BLUE);
            }
            
            public void mouseExited(MouseEvent exit_Add) {
                btn_CreditAdd.setBackground(new Color(163, 163, 163));
                btn_CreditAdd.setForeground(Color.BLACK);
            }
        });
        
        /**
         * When "Add Button" is clicked in Debit Card GUI then it add all the elements in the arraylist "BankCard" creating an object of Debit Card
         * A dialogue box is poped up when the values are added in arraylist successfully
         */
        btn_CreditAdd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent add_object_credit)
            {
                //Checks if a user kept any text field empty
                if(box_CreditBalanceAmount.getText().isEmpty() || box_CreditBankAccount.getText().isEmpty() || box_CreditIssuerBank.getText().isEmpty() || 
                box_CreditCardId.getText().isEmpty() || box_CreditClientName.getText().isEmpty() || box_CvcNum.getText().isEmpty() || box_InterestRate.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(frame_Main,"You cannot keep a field empty!!!", "Empty Field", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    try{
                        //checks if user gave any negative value
                        if(Integer.parseInt(box_CreditBalanceAmount.getText())<=0 || Integer.parseInt(box_CreditCardId.getText())<=0 || 
                        Integer.parseInt(box_CvcNum.getText())<=0 || Double.parseDouble(box_InterestRate.getText())<=0){
                            JOptionPane.showMessageDialog(frame_Credit, "You cannot give values less than zero", "Input Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else if(box_CreditBankAccount.getText().matches(".*\\d.*")) {
                            JOptionPane.showMessageDialog(frame_Debit,"Bank account cannot have numbers", "Input Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else if(box_CreditIssuerBank.getText().matches(".*\\d.*")) {
                            JOptionPane.showMessageDialog(frame_Debit,"Issuer bank cannot have numbers", "Input Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else if(box_CreditClientName.getText().matches(".*\\d.*")) {
                            JOptionPane.showMessageDialog(frame_Debit,"Client name cannot have numbers", "Input Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            int balanceAmount = Integer.parseInt(box_CreditBalanceAmount.getText());
                            String bankAccount = box_CreditBankAccount.getText();
                            String issuerBank = box_CreditIssuerBank.getText();
                            int cardId = Integer.parseInt(box_CreditCardId.getText());
                            String clientName = box_CreditClientName.getText();
                            int cvc_Num = Integer.parseInt(box_CvcNum.getText());
                            double interest_Rate = Double.parseDouble(box_InterestRate.getText());
                            String day = (String) combo_ExpiryDay.getSelectedItem();
                            String month = (String) combo_ExpiryMonth.getSelectedItem();
                            String year = (String) combo_ExpiryYear.getSelectedItem();
                            String expiry_Date = day + "/" + month + "/" + year; // combining the selected day, month, year into a single string
                                
                            // Check if card with same ID already exists in the list
                            boolean card_Exists = false;
                            for (BankCard card: arrayBankCard) {
                                if (card instanceof CreditCard) {
                                    CreditCard creditCard = (CreditCard) card;
                                    if(creditCard.getCardID() == cardId) {
                                        card_Exists = true;
                                        break;
                                    }
                                }
                            }
                            
                            //throws a message if user tries to add same card ID in array list
                            if (card_Exists == true) {
                                JOptionPane.showMessageDialog(frame_Credit, "Card ID already exists", "Card ID Error", JOptionPane.ERROR_MESSAGE);
                            } 
                            else{
                                CreditCard objCreditCard = new CreditCard(cardId,issuerBank,bankAccount,clientName,balanceAmount,cvc_Num,interest_Rate,expiry_Date);
                                arrayBankCard.add(objCreditCard);
                                JOptionPane.showMessageDialog(frame_Credit, "Values Stored in Array List", "Credit Card Arraylist", JOptionPane.INFORMATION_MESSAGE);
                                credit_Clear();
                            }
                        }
                    }
                    //exception handling for NumberFormatException
                    catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(frame_Debit, "Please do not enter alphabets in integer boxes", "Input Error", JOptionPane.ERROR_MESSAGE); 
                    }
                }
            }
        });
        
        // Display Button
        btn_CreditDisplay = new JButton("Display");
        panel_Credit.add(btn_CreditDisplay);
        btn_CreditDisplay.setBounds(620,322,100,35);
        btn_CreditDisplay.setFont(new Font("Arial", Font.BOLD, 14));
        btn_CreditDisplay.setBackground(new Color(163, 163, 163));
        btn_CreditDisplay.setForeground(Color.BLACK);
        btn_CreditDisplay.setBorder(border);
        
        //hover effect for display button
        btn_CreditDisplay.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent hover_Display) {
                btn_CreditDisplay.setBackground(Color.WHITE);
                btn_CreditDisplay.setForeground(Color.BLUE);
            }
            
            public void mouseExited(MouseEvent exit_Display) {
                btn_CreditDisplay.setBackground(new Color(163, 163, 163));
                btn_CreditDisplay.setForeground(Color.BLACK);
            }
        });
        
        /**
         * Displaying the arraylist in Credit Card
         * When display button is clicked then all the values that are stored in the array list are displayed
         */
        btn_CreditDisplay.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent display_object)
            {
                //checks if an array list is empty
                if(arrayBankCard.isEmpty()){
                    JOptionPane.showMessageDialog(frame_Credit,"No Credit Card Found", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    //display all the elements in the array list
                    for(BankCard display: arrayBankCard){
                        if(display instanceof CreditCard){
                            CreditCard creditCard = (CreditCard) display;          //Downcasting BankCard into Credit Card
                            System.out.println("==================================");
                            System.out.println("Credit Card Information: ");
                            System.out.println("Card ID: " + creditCard.getCardID() +"\n" + "Client Name: "+ creditCard.getClientName()+"\n" 
                            + "Balance Amount: " + creditCard.getBalanceAmount() + "\n" + "Bank Account: "+ creditCard.getBankAccount()+"\n" 
                            + "Issuer Bank: " + creditCard.getIssuerBank()+"\n" + "Cvc Num: " + creditCard.getCvc_Num()+"\n"  
                            + "Interest Rate: " + creditCard.getInterest_Rate() + "\n" 
                            + "Expiry Date: " + creditCard.getExpiry_Date() + "\n" + "Credit Limit: " + creditCard.getCreditLimit() + "\n" 
                            + "GracePeriod: " + creditCard.getGrace_Period() );
                            System.out.println("==================================");
                            System.out.println("\n");
                            }
                    }
                }
            }
        });
        
        // Button to set credit limit
        btn_CreditSet = new JButton("Set Credit");
        panel_Credit.add(btn_CreditSet);
        btn_CreditSet.setBounds(300,460,130,35);
        btn_CreditSet.setFont(new Font("Arial", Font.BOLD, 14));
        btn_CreditSet.setBackground(new Color(163, 163, 163));
        btn_CreditSet.setForeground(Color.BLACK);
        btn_CreditSet.setBorder(border);
        
        //hover effect for credit set button
        btn_CreditSet.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent hover_Set) {
                btn_CreditSet.setBackground(Color.WHITE);
                btn_CreditSet.setForeground(Color.BLUE);
            }
            
            public void mouseExited(MouseEvent exit_Set) {
                btn_CreditSet.setBackground(new Color(163, 163, 163));
                btn_CreditSet.setForeground(Color.BLACK);
            }
        });
        
        //Setting credit limit 
            btn_CreditSet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent set_creditlimit) {
                // checking if there exist arrayList for Credit Card
                if (arrayBankCard.isEmpty()) {
                    JOptionPane.showMessageDialog(frame_Credit, "No Credit Card Found", "Error", JOptionPane.ERROR_MESSAGE);
                } 
                else{
                    if (box_CreditLimit.getText().isEmpty() || box_GracePeriod.getText().isEmpty()
                            || box_CreditCardId.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(frame_Credit, "Please fill the required boxes to set Credit Limit", "Error", JOptionPane.ERROR_MESSAGE);
                    } 
                    //method to set credit limit
                    else {
                        try {
                            double newCreditLimit = Double.parseDouble(box_CreditLimit.getText());
                            int newGracePeriod = Integer.parseInt(box_GracePeriod.getText());
                            boolean card_Found = false;
                            for (BankCard setlimit : arrayBankCard) {
                                if (setlimit instanceof CreditCard) {
                                    CreditCard creditCard = (CreditCard) setlimit;
                                    if (Integer.parseInt(box_CreditCardId.getText()) == creditCard.getCardID()) {
                                        if (newCreditLimit > 0 && newGracePeriod > 0) {
                                            creditCard.setCreditLimit(newCreditLimit, newGracePeriod);
                                            if (creditCard.getIsGranted() == true){
                                                JOptionPane.showMessageDialog(frame_Credit, "Credit limit updated successfully!","Credit Limit" + "\n" + "Credit Limit: " 
                                                + newCreditLimit + "\n"+ "Grace Period: " + newGracePeriod,
                                                JOptionPane.INFORMATION_MESSAGE);
                                            } 
                                            else{
                                                JOptionPane.showMessageDialog(frame_Credit,"Balance too low!! We cannot provide that much credit limit", "Credit Limit",
                                                        JOptionPane.ERROR_MESSAGE);
                                            }
                                        } 
                                        else {
                                            JOptionPane.showMessageDialog(frame_Credit,"You cannot enter value lower than zero for Credit Limit or Grace Period","Credit Limit Error", JOptionPane.ERROR_MESSAGE);
                                        }
                                        card_Found = true;
                                        break;
                                    }
                                }
                            }
                            //throws an error if given card ID does not matches to card ID added in arraylist
                            if (card_Found == false) {
                                JOptionPane.showMessageDialog(frame_Credit, "Card ID Invalid!! Credit not Granted!", "Credit Limit", JOptionPane.ERROR_MESSAGE);
                            }
                        } 
                        catch (NumberFormatException creditlimitexception) {
                            JOptionPane.showMessageDialog(frame_Credit, "Please enter a valid data", "Credit Limit Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });
        
        // Cancel Button
        btn_CreditCancel = new JButton("Cancel Credit");
        panel_Credit.add(btn_CreditCancel);
        btn_CreditCancel.setBounds(475,460,130,35);
        btn_CreditCancel.setFont(new Font("Arial", Font.BOLD, 14));
        btn_CreditCancel.setBackground(new Color(163, 163, 163));
        btn_CreditCancel.setForeground(Color.BLACK);
        btn_CreditCancel.setBorder(border);
        
        //hover effect for cancel button
        btn_CreditCancel.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent hover_Cancel) {
                btn_CreditCancel.setBackground(Color.WHITE);
                btn_CreditCancel.setForeground(Color.BLUE);
            }
            
            public void mouseExited(MouseEvent exit_Cancel) {
                btn_CreditCancel.setBackground(new Color(163, 163, 163));
                btn_CreditCancel.setForeground(Color.BLACK);
            }
        });
        
        //Cancels credit limit after clicking the button
             btn_CreditCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent cancel_Credit) {
                if (arrayBankCard.isEmpty()) {
                    JOptionPane.showMessageDialog(frame_Credit, "No Credit Card Found", "Cancel Credit Error", JOptionPane.ERROR_MESSAGE);
                } 
                else{
                    if (box_CreditCardId.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(frame_Credit, "Please insert the Card ID to cancel Credit", "Card ID Error", JOptionPane.ERROR_MESSAGE);
                    } 
                    else {
                        try {
                            boolean card_Found = false;
                            for (BankCard cancel : arrayBankCard) {
                                if (cancel instanceof CreditCard) {
                                    CreditCard creditCard = (CreditCard) cancel;
                                    if (creditCard.getCardID() == Integer.parseInt(box_CreditCardId.getText())){
                                        if (creditCard.getCreditLimit() == 0){
                                            JOptionPane.showMessageDialog(frame_Credit, "No Credit Limit Found", "Credit Limit Error", JOptionPane.ERROR_MESSAGE);
                                        }
                                        else{
                                            creditCard.cancelCreditCard();
                                            JOptionPane.showMessageDialog(frame_Credit, "Credit Limit Cancelled", "Credit Cancel", JOptionPane.INFORMATION_MESSAGE);
                                        }
                                        card_Found = true;
                                        break;
                                    }
                                }
                            }
                            if (card_Found == false) {
                                JOptionPane.showMessageDialog(frame_Credit, "Please check your Card ID before cancelling credit limit", "Credit Limit", JOptionPane.ERROR_MESSAGE);
                            }
                        } 
                        catch (NumberFormatException cancelexception) {
                            JOptionPane.showMessageDialog(frame_Credit, "Please enter a valid data", "Credit Cancel Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });
        
        // Clear Button
        btn_CreditClear = new JButton("Clear");
        panel_Credit.add(btn_CreditClear);
        btn_CreditClear.setBounds(665,460,100,35);
        btn_CreditClear.setFont(new Font("Arial", Font.BOLD, 14));
        btn_CreditClear.setBackground(new Color(163, 163, 163));
        btn_CreditClear.setForeground(Color.BLACK);
        btn_CreditClear.setBorder(border);
        
        //hover effect for Clear Button
        btn_CreditClear.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent hover_Clear) {
                btn_CreditClear.setBackground(Color.WHITE);
                btn_CreditClear.setForeground(Color.BLUE);
            }
            
            public void mouseExited(MouseEvent exit_Clear) {
                btn_CreditClear.setBackground(new Color(163, 163, 163));
                btn_CreditClear.setForeground(Color.BLACK);
            }
        });

        //clearing the values in textbox
        btn_CreditClear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent clear_Textfields) 
            {
                credit_Clear();
            }
        });
        
        //modifying frame
        frame_Credit.setVisible(true);
        frame_Credit.setSize(900,600);
        frame_Credit.setDefaultCloseOperation(frame_Credit.EXIT_ON_CLOSE);
        frame_Credit.setResizable(false);
        frame_Credit.setLocationRelativeTo(null);
    }
    
    public void credit_Clear()
    {
        try{
        box_CreditBalanceAmount.setText("");
        box_CreditBankAccount.setText("");
        box_CreditIssuerBank.setText("");
        box_CreditCardId.setText("");
        box_CreditClientName.setText("");
        box_InterestRate.setText("");
        box_CvcNum.setText("");
        box_CreditLimit.setText("");
        box_GracePeriod.setText("");
        }
        catch(NullPointerException ex){
            JOptionPane.showMessageDialog(frame_Credit,"Error clearing the text fields","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //main method to create instance of BankGUI
    public static void main(String[] args)
    {
        new BankGUI();
    }
}