import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Main implements ActionListener {
    JFrame frame = new JFrame("Automated Teller Machine");
    JFrame cuponFiscal = new JFrame("Cupon Fiscal");

    JPanel cuponPanel = new JPanel(new BorderLayout());
    JPanel buttonsPanel = new JPanel();
    JPanel topButtonsPanel = new JPanel();
    JPanel [] soundButtonPanel = new JPanel[4];
    JPanel scannerPanel = new JPanel(new BorderLayout());
    JPanel leftScannerPanel = new JPanel();
    JPanel rightScannerPanel = new JPanel();
    JPanel topScannerPanel = new JPanel();
    JPanel bottomScannerPanel = new JPanel();
    JPanel cardPanel = new JPanel();
    JPanel cardPanel1 = new JPanel();
    JPanel cardItself = new JPanel();
    JPanel cardLine = new JPanel();

    JButton[] pinButtons = new JButton[10];
    JButton[] moneyButtonsLeftScanner = new JButton[4];
    JButton[] moneyButtonsRightScanner = new JButton[4];
    JButton[] topScannerButtons = new JButton[4];
    JButton[] bottomScannerButtons = new JButton[4];
    JButton cardButton = new JButton("Insert Card");
    JButton zeroButton = new JButton("0");
    JButton delete_Button = new JButton("Delete");

    JLabel [] label = new JLabel [23];
    JLabel [] scannerText = new JLabel [6];

    boolean general;
    boolean ok;
    boolean balance;
    boolean language;
    boolean cancel;
    boolean deposit;
    boolean transaction;
    boolean deleted = true;
    boolean afterTransaction;
    boolean afterDeposit;
    boolean checkBalance;
    boolean checkDeposit;
    boolean notCreative;
    boolean finish;
    boolean changedLanguage;
    boolean shqip;
    boolean spanjollisht;
    boolean anglisht;

    int PIN;
    int moneyBalance = (int)(Math.random() * 1000);
    int moneyBalance2;
    int value10;
    int value20;
    int value50;
    int value100;
    int value200;
    int value500;
    int vali10;
    int vali20;
    int vali50;
    int vali100;
    int vali200;
    int vali500;
    int transactionValue;
    int depositValue;
    int finalTransactionValue;
    int finalDepositValue;
    int firstValueBalance;

    String str = "";
    String hi = "";

    GregorianCalendar c = new GregorianCalendar();

    Main() {

        /*************************************


         BUTTONS
         |
         |
         v

         **************************************/

        for (int i = 0; i < 6; i++) {
            scannerText[i] = new JLabel();
        }

        for (int i = 0; i < 10; i++) {
            pinButtons[i] = new JButton(String.valueOf(i));
            pinButtons[i].addActionListener(this);
            pinButtons[i].setFocusable(false);
        }


        moneyButtonsLeftScanner[1] = new JButton("10 €");
        moneyButtonsLeftScanner[2] = new JButton("20 €");
        moneyButtonsLeftScanner[3] = new JButton("50 €");

        moneyButtonsRightScanner[1] = new JButton("100 €");
        moneyButtonsRightScanner[2] = new JButton("200 €");
        moneyButtonsRightScanner[3] = new JButton("500 €");

        topScannerButtons[1] = new JButton("Deposit");
        topScannerButtons[2] = new JButton("Transaction");
        topScannerButtons[3] = new JButton("Balance");

        bottomScannerButtons[1] = new JButton("Language");
        bottomScannerButtons[2] = new JButton("OK");
        bottomScannerButtons[3] = new JButton("Cancel");



        for (int i = 1; i < 4; i++) {
            moneyButtonsLeftScanner[i].addActionListener(this);
            moneyButtonsLeftScanner[i].setFocusable(false);
            moneyButtonsRightScanner[i].addActionListener(this);
            moneyButtonsRightScanner[i].setFocusable(false);
            topScannerButtons[i].addActionListener(this);
            topScannerButtons[i].setFocusable(false);
            bottomScannerButtons[i].addActionListener(this);
            bottomScannerButtons[i].setFocusable(false);
        }


        zeroButton.setBounds(501, 415, 47, 30);
        zeroButton.setFocusable(false);
        zeroButton.addActionListener(this);
        delete_Button.setBounds(552, 415, 98, 30);
        delete_Button.setFocusable(false);
        delete_Button.addActionListener(this);
        cardButton.setBounds(500, 455, 150, 50);
        cardButton.addActionListener(this);
        cardButton.setFocusable(false);



        /*************************************



         PANELS AND LABELS
         |
         |
         v

         **************************************/

        for (int i = 0; i < 4; i++) {
            soundButtonPanel[i] = new JPanel();
        }


        buttonsPanel.setBounds(500, 300, 150, 150);
        buttonsPanel.setLayout(new GridLayout(4, 4, 5, 5));
        buttonsPanel.setBackground(Color.gray);
        topButtonsPanel.setBounds(500, 200, 150, 100);
        topButtonsPanel.setBackground(new Color(70, 115, 122));
        topButtonsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        soundButtonPanel[0].setBounds(545, 230, 60, 2);
        soundButtonPanel[0].setBackground(Color.black);
        soundButtonPanel[1].setBounds(530, 240, 90, 2);
        soundButtonPanel[1].setBackground(Color.black);
        soundButtonPanel[2].setBounds(530, 250, 90, 2);
        soundButtonPanel[2].setBackground(Color.black);
        soundButtonPanel[3].setBounds(545, 260, 60, 2);
        soundButtonPanel[3].setBackground(Color.black);
        cardPanel.setBounds(500, 100, 150, 50);
        cardPanel.setBackground(Color.black);
        cardPanel1.setBounds(500, 120, 150, 10);
        cardPanel1.setBackground(Color.green);
        cardItself.setBounds(550, 80, 50, 100);
        cardItself.setBackground(Color.gray);
        cardLine.setBounds(555, 80, 5, 100);
        cardLine.setBackground(Color.blue);


        scannerPanel.setBounds(100, 255, 300, 200);
        scannerPanel.setBackground(Color.black);
        scannerText[0].setText("Please insert your card");
        scannerText[0].setForeground(Color.green);
        scannerText[0].setFont(new Font("Arial", Font.BOLD, 20));
        scannerText[0].setHorizontalAlignment(JLabel.CENTER);
        scannerText[1].setText("");
        scannerText[1].setForeground(Color.green);
        scannerText[1].setFont(new Font("Arial", Font.BOLD, 20));
        scannerText[1].setBounds(0, 150, 300, 20);
        scannerText[1].setHorizontalAlignment(JLabel.CENTER);
        leftScannerPanel.setBounds(35, 255, 65, 200);
        leftScannerPanel.setLayout(new GridLayout(3, 1, 5, 5));
        leftScannerPanel.setBackground(new Color(25, 100, 120));
        rightScannerPanel.setBounds(400, 255, 65, 200);
        rightScannerPanel.setLayout(new GridLayout(3, 1, 5, 5));
        rightScannerPanel.setBackground(new Color(25, 100, 120));
        topScannerPanel.setBounds(35, 200, 430, 50);
        topScannerPanel.setLayout(new GridLayout(1, 3, 5, 5));
        topScannerPanel.setBackground(new Color(25, 100, 120));
        bottomScannerPanel.setBounds(35, 460, 430, 50);
        bottomScannerPanel.setLayout(new GridLayout(1, 3, 5, 5));
        bottomScannerPanel.setBackground(new Color(25, 100, 120));

        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);


        for (int i = 1; i < 4; i++) {
            leftScannerPanel.add(moneyButtonsLeftScanner[i]);
            rightScannerPanel.add(moneyButtonsRightScanner[i]);
            topScannerPanel.add(topScannerButtons[i]);
            bottomScannerPanel.add(bottomScannerButtons[i]);
        }


        for (int i = 5; i >= 0; i--) {
            scannerPanel.add(scannerText[i]);
        }


        for (int i = 1; i < 10; i++) {
            buttonsPanel.add(pinButtons[i]);
        }

        frame.add(bottomScannerPanel);
        frame.add(cardLine);
        frame.add(cardItself);
        cardLine.setVisible(false);
        cardItself.setVisible(false);


        /*************************************



         CUPON FISCAL COMPONENTS
         |
         |
         v

         **************************************/

        cuponPanel.setBounds(0, 0, 400, 600);
        cuponPanel.setBackground(Color.white);

        for (int i = 1; i < 23; i++){
            label[i] = new JLabel();
        }


        label[1].setText("*****************************************************************");
        label[1].setFont(new Font("Calibri", Font.BOLD, 10));
        label[1].setBounds(0, 20, 400, 20);
        label[1].setHorizontalAlignment(JLabel.CENTER);

        label[2].setText("ATM TRANSACTION");
        label[2].setFont(new Font("Calibri", Font.BOLD, 19));
        label[2].setBounds(0, 50, 400, 20);
        label[2].setHorizontalAlignment(JLabel.CENTER);


        label[3].setText("RECORD");
        label[3].setFont(new Font("Calibri", Font.BOLD, 19));
        label[3].setBounds(0, 80, 400, 20);
        label[3].setHorizontalAlignment(JLabel.CENTER);

        label[4].setText("*****************************************************************");
        label[4].setFont(new Font("Calibri", Font.BOLD, 10));
        label[4].setBounds(0, 110, 400, 20);
        label[4].setHorizontalAlignment(JLabel.CENTER);

        label[5].setText("DATE :");
        label[5].setFont(new Font("Calibri", Font.BOLD, 16));
        label[5].setBounds(60, 140, 400, 20);

        label[6].setText("TIME :");
        label[6].setFont(new Font("Calibri", Font.BOLD, 16));
        label[6].setBounds(60, 170, 400, 20);

        label[7].setText("LOCATION :                            Prishtinë");
        label[7].setFont(new Font("Calibri", Font.BOLD, 16));
        label[7].setBounds(60, 200, 400, 20);

        label[8].setText("*****************************************************************");
        label[8].setFont(new Font("Calibri", Font.BOLD, 10));
        label[8].setBounds(0, 230, 400, 20);
        label[8].setHorizontalAlignment(JLabel.CENTER);

        label[9].setText("RECEIPT NO. :");
        label[9].setFont(new Font("Calibri", Font.BOLD, 16));
        label[9].setBounds(60, 260, 400, 20);

        label[10].setText("TRANSACTION :");
        label[10].setFont(new Font("Calibri", Font.BOLD, 16));
        label[10].setBounds(60, 290, 400, 20);

        label[11].setText("DEPOSIT :");
        label[11].setFont(new Font("Calibri", Font.BOLD, 16));
        label[11].setBounds(60, 320, 400, 20);

        label[12].setText("CURRENT BAL. :");
        label[12].setFont(new Font("Calibri", Font.BOLD, 16));
        label[12].setBounds(60, 350, 400, 20);

        label[13].setText("THANK YOU!");
        label[13].setFont(new Font("Calibri", Font.BOLD, 23));
        label[13].setHorizontalAlignment(JLabel.CENTER);
        label[13].setBounds(0, 440, 400, 20);

        label[14].setText(c.get(Calendar.DAY_OF_MONTH) + "/" +  (c.get(Calendar.MONTH) + 1) + "/" +  c.get(Calendar.YEAR));
        label[14].setFont(new Font("Calibri", Font.BOLD, 16));
        label[14].setBounds(250, 140, 400, 20);
        label[14].setHorizontalAlignment(JLabel.LEFT);

        label[16].setText("");
        label[16].setFont(new Font("Calibri", Font.BOLD, 16));
        label[16].setBounds(250, 290, 400, 20);

        label[17].setText("");
        label[17].setFont(new Font("Calibri", Font.BOLD, 16));
        label[17].setBounds(250, 320, 400, 20);

        label[18].setText("");
        label[18].setFont(new Font("Calibri", Font.BOLD, 16));
        label[18].setBounds(250, 260, 400, 20);

        label[19].setText("");
        label[19].setBounds(250, 350, 400, 20);
        label[19].setFont(new Font("Calibri", Font.BOLD, 16));

        label[20].setText("");
        label[20].setBounds(250, 290, 400, 200);
        label[20].setFont(new Font("Calibri", Font.BOLD, 16));

        label[21].setText("INITIAL BAL. :");
        label[21].setFont(new Font("Calibri", Font.BOLD, 16));
        label[21].setBounds(60, 380, 400, 20);

        label[22].setText("");




        for (int i = 1; i < 23; i++){
            cuponPanel.add(label[i]);
        }



        for (int i = 0; i < 4; i++) {
            frame.add(soundButtonPanel[i]);
        }

        cuponFiscal.setSize(410, 600);
        cuponFiscal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cuponFiscal.setLayout(null);
        cuponFiscal.add(cuponPanel);

        frame.add(cardPanel1);
        frame.add(cardPanel);
        frame.add(topButtonsPanel);
        frame.add(scannerPanel);
        frame.add(leftScannerPanel);
        frame.add(rightScannerPanel);
        frame.add(topScannerPanel);
        frame.add(zeroButton);
        frame.add(delete_Button);
        frame.add(buttonsPanel);
        frame.add(cardButton);
        frame.getContentPane().setBackground(new Color(25, 100, 120));
        frame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {


        /*************************************



         CARD BUTTON (FINISH BUTTON)
         |
         |
         v

         **************************************/



        if (e.getSource() == cardButton) {
            general = true;
            cardLine.setVisible(general);
            cardItself.setVisible(general);

            scannerText[0].setText("Write down your PIN: ");

            if(!finish) {
                cardButton.setEnabled(false);
            }
            else {
                general = false;

                int numer = JOptionPane.showConfirmDialog(null, "Are you sure you want to finish program?", "", JOptionPane.YES_NO_OPTION);
                if (numer == 0) {
                    scannerText[0].setText("Thank You!");
                    cardButton.setEnabled(false);
                    scannerText[0].setVerticalAlignment(JLabel.CENTER);
                    scannerText[0].setHorizontalAlignment(JLabel.CENTER);
                    for (int i = 1; i < 6; i++) {
                        scannerText[i].setText("");
                    }

                    cardLine.setVisible(false);
                    cardItself.setVisible(false);

                    general = false;
                    ok = false;
                    balance = false;
                    language = false;
                    cancel = false;
                    deposit = false;
                    transaction = false;
                    deleted = true;
                    afterTransaction = false;
                    afterDeposit = false;
                    checkBalance = false;
                    checkDeposit = false;
                    notCreative = false;
                    finish = false;
                    changedLanguage = false;
                    shqip = false;
                    spanjollisht = false;
                    anglisht = false;
                    //Dritarja per kuponin fiskal

                    GregorianCalendar o = new GregorianCalendar();

                    label[15].setText(o.get(Calendar.HOUR_OF_DAY) + ":" +  o.get(Calendar.MINUTE));
                    label[15].setFont(new Font("Calibri", Font.BOLD, 16));
                    label[15].setBounds(250, 170, 400, 20);
                    label[16].setText("" + finalTransactionValue + "€");
                    label[17].setText("" + finalDepositValue + "€");
                    label[18].setText(hi);
                    label[19].setText("" + moneyBalance + "€");
                    label[20].setText("" + firstValueBalance + "€");

                    cuponFiscal.setVisible(true);
                }
            }
        }



        /*************************************



         PIN BUTTONS
         |
         |
         v

         **************************************/



        for(int i = 0; i < 10; i++) {

            if (e.getSource() == pinButtons[i]) {
                if (general) {
                    if (scannerText[1].getText() == "Invalid PIN") {
                        scannerText[1].setText("");
                    }
                    scannerText[1].setText(scannerText[1].getText().concat(String.valueOf(i)));
                    str = scannerText[1].getText();

                }

                if (changedLanguage) {
                    if (i == 1) {
                        shqip = true;
                        anglisht = false;
                        spanjollisht = false;
                        scannerText[0].setText("");
                        scannerText[1].setText("<html>Gjuha u ndërrua me sukses në gjuhën shqipe. </html>");
                        scannerText[1].setBounds(0, 60, 300, 80);
                        scannerText[2].setText("");
                        scannerText[3].setText("");
                        scannerText[4].setText("");
                        scannerText[5].setText("");


                    }


                    if (i == 2) {
                        anglisht = true;
                        shqip = false;
                        spanjollisht = false;
                        scannerText[0].setText("");
                        scannerText[1].setText("<html>Language changed successfully to english.</html>");
                        scannerText[1].setBounds(0, 60, 300, 80);
                        scannerText[2].setText("");
                        scannerText[3].setText("");
                        scannerText[4].setText("");
                        scannerText[5].setText("");

                    }

                    if (i == 3) {
                        spanjollisht = true;
                        anglisht = false;
                        shqip = false;
                        scannerText[0].setText("");
                        scannerText[1].setText("<html>El idioma se cambió con éxito al español. </html>");
                        scannerText[1].setBounds(0, 60, 300, 80);
                        scannerText[2].setText("");
                        scannerText[3].setText("");
                        scannerText[4].setText("");
                        scannerText[5].setText("");
                    }
                }
            }
        }


        // Zero Button

        if(e.getSource() == zeroButton) {
            if (general) {
                if (scannerText[1].getText() == "Invalid PIN") {
                    scannerText[1].setText("");
                }
                scannerText[1].setText(scannerText[1].getText().concat(String.valueOf(0)));
                str = scannerText[1].getText();
            }
        }


        //Delete Button

        if (e.getSource() == delete_Button) {
            if (deleted && (scannerText[1].getText() != "Invalid PIN")) {
                String temp = scannerText[1].getText();
                scannerText[1].setText("");

                for (int i = 0; i < temp.length() - 1; i++) {
                    scannerText[1].setText(scannerText[1].getText() + str.charAt(i));
                    hi = scannerText[1].getText();

                }
            }
        }


        /*************************************


         OK BUTTON
         |
         |
         v

         **************************************/


        if (e.getSource() == bottomScannerButtons[2]) {

            if (checkBalance) {

                if (transactionValue > moneyBalance) {
                    scannerText[2].setText("<html>Insufficient funds please try again: </html> ");
                    scannerText[5].setText("");

                    if (shqip) {
                        scannerText[2].setText("<html>Nuk ka fonde të mjaftueshme, ju lutemi të provoni përsëri: </html> ");
                    }

                    if (spanjollisht) {
                        scannerText[2].setText("<html>Fondos insuficientes, inténtelo de nuevo : </html> ");
                    }

                    if (anglisht) {
                        scannerText[2].setText("<html>Insufficient funds please try again: </html> ");
                    }
                }

                else {
                    moneyBalance = moneyBalance - transactionValue;
                    scannerText[2].setText("<html>Transaction ended successfully, your balance now is: </html> ");
                    scannerText[2].setBounds(5, 40, 300, 65);
                    scannerText[4].setText("" + moneyBalance);
                    finalTransactionValue = finalTransactionValue + transactionValue;



                    if (shqip) {
                        scannerText[2].setText("<html>Transaksioni ka përfunduar me sukses, bilanci juaj tani është: </html> ");
                    }

                    if (spanjollisht) {
                        scannerText[2].setText("<html>La transacción finalizó correctamente, su saldo ahora es: </html> ");
                    }

                    if (anglisht) {
                        scannerText[2].setText("<html>Transaction ended successfully, your balance now is: </html> ");
                    }
                }
            }

            if (checkDeposit) {
                moneyBalance = moneyBalance + depositValue;
                scannerText[2].setText("<html>Deposit ended successfully, your balance now is: </html> ");
                scannerText[2].setBounds(5, 40, 300, 65);
                scannerText[4].setText("" + moneyBalance);
                finalDepositValue = finalDepositValue + depositValue;


                if (shqip) {
                    scannerText[2].setText("<html>Depozita përfundoj me sukses, bilanci juaj tani është: </html> ");
                }

                if (spanjollisht) {
                    scannerText[2].setText("<html>El depósito finalizó correctamente, su saldo ahora es: </html> ");
                }

                if (anglisht) {
                    scannerText[2].setText("<html>Deposit ended successfully, your balance now is: </html> ");
                }
            }



            if (general) {

                hi = scannerText[1].getText();

                if (hi.length() <= 3 || hi.length() >= 5) {
                    scannerText[1].setText("Invalid PIN");
                    scannerText[0].setText("Try again: ");

                }
                else {
                    PIN = Integer.parseInt(scannerText[1].getText());
                    scannerText[0].setText("Valid PIN");
                    scannerText[0].setVerticalAlignment(JLabel.TOP);
                    scannerText[1].setText("What do you want to do? :");
                    scannerText[1].setBounds(0, 30, 300, 20);
                    scannerText[2].setBounds(5, 60, 300, 20);
                    scannerText[2].setForeground(Color.green);
                    scannerText[2].setFont((new Font("Arial", Font.BOLD, 20)));
                    scannerText[2].setText("1. Check balance");
                    scannerText[3].setBounds(5, 90, 300, 20);
                    scannerText[3].setText("2. Deposit money");
                    scannerText[3].setFont((new Font("Arial", Font.BOLD, 20)));
                    scannerText[3].setForeground(Color.green);
                    scannerText[4].setBounds(5,120, 300, 20);
                    scannerText[4].setText("3. Transact money");
                    scannerText[4].setFont((new Font("Arial", Font.BOLD, 20)));
                    scannerText[4].setForeground(Color.green);
                    scannerText[5].setBounds(5,150, 300, 20);
                    scannerText[5].setText("4. Change language");
                    scannerText[5].setFont((new Font("Arial", Font.BOLD, 20)));
                    scannerText[5].setForeground(Color.green);
                    general = false;
                    balance = true;
                    transaction = true;
                    deposit = true;
                    language = true;
                    deleted = false;
                }
            }

            value10 = 0;
            value20 = 0;
            value50 = 0;
            value100 = 0;
            value200 = 0;
            value500 = 0;

            vali10 = 0;
            vali20 = 0;
            vali50 = 0;
            vali100 = 0;
            vali200 = 0;
            vali500 = 0;

        }



        /*************************************



         BALANCE
         |
         |
         v

         **************************************/



        firstValueBalance = moneyBalance + finalTransactionValue - finalDepositValue;
        if (e.getSource() == topScannerButtons[3]) {
            value10 = 0;
            value20 = 0;
            value50 = 0;
            value100 = 0;
            value200 = 0;
            value500 = 0;

            vali10 = 0;
            vali20 = 0;
            vali50 = 0;
            vali100 = 0;
            vali200 = 0;
            vali500 = 0;



            if (balance) {
                finish = true;
                if (finish) {
                    cardButton.setEnabled(true);
                    cardButton.setText("Finish");
                }
                int temp = moneyBalance;
                scannerText[0].setText("BALANCE");
                scannerText[1].setText("");
                scannerText[2].setText("");
                scannerText[3].setText("<html>Your balance now is " + temp + " €.</html>");
                scannerText[4].setText("");
                scannerText[5].setText("");
                moneyBalance = temp;


                afterTransaction = false;
                afterDeposit = false;

                checkBalance = false;
                checkDeposit = false;


                if (shqip) {
                    scannerText[0].setText("BILANCI");
                    scannerText[3].setText("<html>Bilanci juaj është " + temp + " €.</html>");
                }

                if (spanjollisht) {
                    scannerText[0].setText("BALANC");
                    scannerText[3].setText("<html>Tu saldo ahora es " + temp + " €.</html>");
                }

                if (anglisht) {
                    scannerText[0].setText("BALANCE");
                    scannerText[3].setText("<html>Your balance now is " + temp + " €.</html>");
                }
            }
        }




        /*************************************



         TRANSACTION
         |
         |
         v

         **************************************/




        if (e.getSource() == topScannerButtons[2]) {
            notCreative = false;

            if (transaction) {
                finish = true;
                if (finish) {
                    cardButton.setEnabled(true);
                    cardButton.setText("Finish");
                }
                cancel = true;
                value10 = 0;
                value20 = 0;
                value50 = 0;
                value100 = 0;
                value200 = 0;
                value500 = 0;

                scannerText[0].setText("TRANSACTION");
                scannerText[1].setText("");
                scannerText[2].setText("<html>Please enter the withdrawal value:</html> ");
                scannerText[2].setBounds(5, 60, 300, 45);
                scannerText[3].setText("");
                scannerText[4].setText("");
                scannerText[5].setText("");

                afterTransaction = true;
                afterDeposit = false;

                if (shqip) {
                    scannerText[0].setText("TRANSAKSIONI");
                    scannerText[2].setText("<html>Ju lutemi të shënoni sasinë e tërheqjes:</html> ");
                }

                if (spanjollisht) {
                    scannerText[0].setText("TRANSACCIÓN");
                    scannerText[2].setText("<html>Ingrese el valor de retiro:</html> ");
                }

                if (anglisht) {
                    scannerText[0].setText("TRANSACTION");
                    scannerText[2].setText("<html>Please enter the withdrawal value: </html> ");
                }
            }
        }



        /*************************************



         DEPOSIT
         |
         |
         v

         **************************************/



        if (e.getSource() == topScannerButtons[1]) {
            notCreative = false;

            if (deposit) {
                finish = true;
                if (finish) {
                    cardButton.setEnabled(true);
                    cardButton.setText("Finish");
                }

                cancel = true;
                deposit = true;
                vali10 = 0;
                vali20 = 0;
                vali50 = 0;
                vali100 = 0;
                vali200 = 0;
                vali500 = 0;

                scannerText[0].setText("DEPOSIT");
                scannerText[1].setText("");
                scannerText[2].setText("<html>Choose the amount of money to depose:</html> ");
                scannerText[2].setBounds(5, 60, 300, 40);
                scannerText[3].setText("");
                scannerText[4].setText("");
                scannerText[5].setText("");
                afterDeposit = true;


                if (shqip) {
                    scannerText[0].setText("DEPOZITA");
                    scannerText[2].setText("<html>Zgjidhni sasinë e parave qe do të depozitoni: </html> ");
                }

                if (spanjollisht) {
                    scannerText[0].setText("DEPOSITAR");
                    scannerText[2].setText("<html>Elija la cantidad de dinero a depositar: </html> ");
                }

                if (anglisht) {
                    scannerText[0].setText("DEPOSIT");
                    scannerText[2].setText("<html>Choose the amount of money to depose: </html> ");
                }
            }
        }


        if (afterTransaction && cancel) {
            scannerText[4].setHorizontalAlignment(JLabel.CENTER);

            if (e.getSource() == moneyButtonsLeftScanner[1]) {
                scannerText[4].setText("" + (value500 + value200 + value100 + value50 + value20 + value10 + 10));
                value10 = value10 + 10;
            }

            if (e.getSource() == moneyButtonsLeftScanner[2]) {
                scannerText[4].setText("" + (value500 + value200 + value100 + value50 + value20 + value10 + 20));
                value20 = value20 + 20;
            }

            if (e.getSource() == moneyButtonsLeftScanner[3]) {
                scannerText[4].setText("" + (value500 + value200 + value100 + value50 + value20 + value10 + 50));
                value50 = value50 + 50;
            }

            if (e.getSource() == moneyButtonsRightScanner[1]) {
                scannerText[4].setText("" + (value500 + value200 + value100 + value50 + value20 + value10 + 100));
                value100 = value100 + 100;
            }

            if (e.getSource() == moneyButtonsRightScanner[2]) {
                scannerText[4].setText("" + (value500 + value200 + value100 + value50 + value20 + value10 + 200));
                value200 = value200 + 200;
            }

            if (e.getSource() == moneyButtonsRightScanner[3]) {
                scannerText[4].setText("" + (value500 + value200 + value100 + value50 + value20 + value10 + 500));
                value500 = value500 + 500;
            }



            if (cancel) {
                if (e.getSource() == bottomScannerButtons[3]) {
                    scannerText[4].setText("0");
                    value10 = 0;
                    value20 = 0;
                    value50 = 0;
                    value100 = 0;
                    value200 = 0;
                    value500 = 0;

                }
            }
        }


        if (afterDeposit && cancel) {

            scannerText[4].setHorizontalAlignment(JLabel.CENTER);

            if (e.getSource() == moneyButtonsLeftScanner[1]) {
                scannerText[4].setText("" + (vali500 + vali200 + vali100 + vali50 + vali20 + vali10 + 10));
                vali10 = vali10 + 10;
            }


            if (e.getSource() == moneyButtonsLeftScanner[2]) {
                scannerText[4].setText("" + (vali500 + vali200 + vali100 + vali50 + vali20 + vali10 + 20));
                vali20 = vali20 + 20;
            }

            if (e.getSource() == moneyButtonsLeftScanner[3]) {
                scannerText[4].setText("" + (vali500 + vali200 + vali100 + vali50 + vali20 + vali10 + 50));
                vali50 = vali50 + 50;
            }

            if (e.getSource() == moneyButtonsRightScanner[1]) {
                scannerText[4].setText("" + (vali500 + vali200 + vali100 + vali50 + vali20 + vali10 + 100));
                vali100 = vali100 + 100;
            }

            if (e.getSource() == moneyButtonsRightScanner[2]) {
                scannerText[4].setText("" + (vali500 + vali200 + vali100 + vali50 + vali20 + vali10 + 200));
                vali200 = vali200 + 200;
            }

            if (e.getSource() == moneyButtonsRightScanner[3]) {
                scannerText[4].setText("" + (vali500 + vali200 + vali100 + vali50 + vali20 + vali10 + 500));
                vali500 = vali500 + 500;
            }



            if (cancel) {
                if (e.getSource() == bottomScannerButtons[3]) {
                    scannerText[4].setText("0");
                    vali10 = 0;
                    vali20 = 0;
                    vali50 = 0;
                    vali100 = 0;
                    vali200 = 0;
                    vali500 = 0;
                }
            }
        }


        if (afterTransaction && !notCreative) {
            transactionValue = value10 + value20 + value50 + value100 +  value200 + value500;
            checkBalance = true;
            checkDeposit = false;
        }

        if (afterDeposit && !notCreative) {
            depositValue = vali10 + vali20 + vali50 + vali100 +  vali200 + vali500;
            checkDeposit = true;
            checkBalance = false;
        }


        /*************************************

         LANGUAGES
         |
         |
         v

         **************************************/



        if (e.getSource() == bottomScannerButtons[1]) {
            if (language) {

                finish = true;
                if (finish) {
                    cardButton.setEnabled(true);
                    cardButton.setText("Finish");
                }

                notCreative = true;
                checkDeposit = false;
                checkBalance = false;

                cancel = false;
                scannerText[0].setText("LANGUAGES");
                scannerText[1].setText("<html>Which language would you like to choose: </html>");
                scannerText[1].setBounds(5, 20, 300, 60);
                scannerText[2].setText("");
                scannerText[3].setBounds(5, 90, 300, 20);
                scannerText[3].setForeground(Color.green);
                scannerText[4].setBounds(5,120, 300, 25);
                scannerText[4].setForeground(Color.green);
                scannerText[5].setBounds(5,150, 300, 20);
                scannerText[5].setForeground(Color.green);
                scannerText[4].setHorizontalAlignment(JLabel.LEFT);
                scannerText[3].setText("1. Shqip");
                scannerText[4].setText("2. English");
                scannerText[5].setText("3. Espanol");
                changedLanguage = true;
            }
        }
    }


    public static void main(String[] args) {
        new Main();
    }
}
