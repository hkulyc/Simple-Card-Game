import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This is the model of CardGame, it can construct the GUI and also
 * contains the game information itself needs.
 * 
 * @author Liu Yuchen
 * @version 1.2
 */
public class CardGame{
    InformationHub informationHub;
    boolean Restart=false;
    JMenuBar menuBar;
    JMenu Control;
    JMenu Help;
    JMenuItem Exit;
    JMenuItem Rule;
    JMenuItem author;
    JFrame mainFrame;
    JPanel MainPanel,DealerPanel,PlayerPanel,RpCardBtnPanel,ButtonPanel,InfoPanel;
    JLabel label1,label2,label3,label4,label5,label6;
    JLabel labelBet;
    JLabel labelMessage,labelMoney;
    JTextField betInputField;
    Button buttonCard1,buttonCard2,buttonCard3,buttonStart,buttonResult;
    
    /**
     * This is the constructor for CardGame class. It initializes all the buttons and panels showed.
     * Whenever a new CardGame is created, an informationHub for it will also be created.
     */
    public CardGame(){
        menuBar=new JMenuBar();
        Control=new JMenu("Control");
        Help=new JMenu("Help");
        Exit=new JMenuItem("Exit");
        Rule=new JMenuItem("Rule");
        author=new JMenuItem("Author");
        mainFrame=new JFrame("Card Game");
        buttonCard1=new Button("Replace Card 1");
        buttonCard2=new Button("Replace Card 2");
        buttonCard3=new Button("Replace Card 3");
        buttonStart=new Button("Start");
        buttonResult=new Button("Result");
        MainPanel=new JPanel();
        DealerPanel=new JPanel();
        PlayerPanel=new JPanel();
        RpCardBtnPanel=new JPanel();
        ButtonPanel=new JPanel();
        InfoPanel=new JPanel();
        informationHub=new InformationHub(); 
    }

    /**
     * This method configures the layout of the main panel that hold all the 
     * subpanels of the frame as well as the frame itself. 
     */
    void frameDesign(){
        MainPanel=new JPanel();
        MainPanel.setLayout(new GridLayout(5,1));
        mainFrame.getContentPane().add(MainPanel); 
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400,700);     
    }

    /**
     * This method should always be called at last, in order to make the frame visible.
     */
    void frameVisible(){
        mainFrame.setVisible(true);
    }

    /**
     * This method configures the panel that holds the cards of the dealer.
     */
    void DealerPanelDesign(){
        ImageIcon image1=new ImageIcon("Images/card_back.gif");
        label1=new JLabel();
        label1.setIcon(image1);
        DealerPanel.add(label1);
        ImageIcon image2=new ImageIcon("Images/card_back.gif");
        label2=new JLabel();
        label2.setIcon(image2);
        DealerPanel.add(label2);
        ImageIcon image3=new ImageIcon("Images/card_back.gif");
        label3=new JLabel();
        label3.setIcon(image3);
        DealerPanel.add(label3);
        DealerPanel.setBackground(Color.GREEN.darker());
        MainPanel.add(DealerPanel);
    }

    /**
     * This method configures the panel that holds the cards of the player.
     */
    void PlayerPanelDesign(){
        ImageIcon image1=new ImageIcon("Images/card_back.gif");
        label4=new JLabel();
        label4.setIcon(image1);
        PlayerPanel.add(label4);
        ImageIcon image2=new ImageIcon("Images/card_back.gif");
        label5=new JLabel();
        label5.setIcon(image2);
        PlayerPanel.add(label5);
        ImageIcon image3=new ImageIcon("Images/card_back.gif");
        label6=new JLabel();
        label6.setIcon(image3);
        PlayerPanel.add(label6);
        PlayerPanel.setBackground(Color.GREEN.darker());
        MainPanel.add(PlayerPanel);
    }

    /**
     * This method configures the panel that holds the three buttons which 
     * are used to replace the cards.
     */
    void RpCardBtnPanelDesign(){
        buttonCard1.addActionListener(new Card1Listener());
        buttonCard2.addActionListener(new Card2Listener());
        buttonCard3.addActionListener(new Card3Listener());
        RpCardBtnPanel.add(buttonCard1);
        RpCardBtnPanel.add(buttonCard2);
        RpCardBtnPanel.add(buttonCard3);
        RpCardBtnPanel.setBackground(Color.GREEN.darker());
        MainPanel.add(RpCardBtnPanel);
    }

    /**
     * This method configures the panel that holds the textField and also
     * the start and result button.
     */
    void ButtonPanelDesign(){
        betInputField=new JTextField(10);
        labelBet=new JLabel("Bet: $");
        ButtonPanel.add(labelBet);
        ButtonPanel.add(betInputField);
        buttonStart.setBackground(Color.GREEN);
        buttonStart.addActionListener(new startListener());
        ButtonPanel.add(buttonStart);
        buttonResult.addActionListener(new resultListener());
        ButtonPanel.add(buttonResult);
        MainPanel.add(ButtonPanel);
    }

    /**
     * This method configures the panel the shows information in the form of text.
     */
    void InfoPanelDesign(){
        labelMessage=new JLabel("Please place your bet! ");
        labelMoney=new JLabel("Amount of money you have: $"+InformationHub.getMoney());
        InfoPanel.add(labelMessage);
        InfoPanel.add(labelMoney);
        MainPanel.add(InfoPanel);
    }

    /**
     * This method configures the menu of the GUI.
     */
    void menuBarConfiguration(){
        Exit.addActionListener(new ExitListener());
        Rule.addActionListener(new RuleListener());
        author.addActionListener(new authorListener());
        Control.add(Exit);
        Help.add(Rule);
        Help.add(author);
        menuBar.add(Control);
        menuBar.add(Help);
        mainFrame.setJMenuBar(menuBar);
    }

    class ExitListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }

    class RuleListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null, "J, Q, K are regarded as special cards.\nRule 1: The one with more special cards wins.\nRule 2: If both have the same number of special cards, add the face values of the other card(s) and take the remainder after dividing the sum by 10. The one with a bigger remainder wins. (Note: Ace = 1).\nRule 3: The dealer wins if both rule 1 and rule 2 cannot distinguish the winner.", "Rule", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    class authorListener implements ActionListener{
        
        /**
         * This method implement a new feature which is pumping out a webpage of my GitHub homepage.
         */
    	@Override
        public void actionPerformed(ActionEvent E) {
            try { 
                String url = "https://github.com/hkulyc"; 
                java.net.URI uri = java.net.URI.create(url); 
                java.awt.Desktop dp = java.awt.Desktop.getDesktop(); 
                if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
                dp.browse(uri);
                } 
            } catch (java.lang.NullPointerException e) {  
                e.printStackTrace(); 
            } catch (java.io.IOException e) {  
                e.printStackTrace(); 
            } 
        }
    }

    class Card1Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(informationHub.ifReplaced1==false&&informationHub.ifStart==true){
                informationHub.playerCards.set(0,informationHub.dealCard());
                label4.setIcon(new ImageIcon("Images/card_"+informationHub.playerCards.get(0)[0]+informationHub.playerCards.get(0)[1]+".gif"));
                informationHub.ifReplaced1=true;
                buttonCard1.setBackground(Color.GRAY);
                if(informationHub.ifHaveRelpaced==true){
                    buttonCard1.setBackground(Color.GRAY);
                    buttonCard2.setBackground(Color.GRAY);
                    buttonCard3.setBackground(Color.GRAY);
                    informationHub.ifReplaced1=true;
                    informationHub.ifReplaced2=true;
                    informationHub.ifReplaced3=true;
                }
                informationHub.ifHaveRelpaced=true;
            }        
        }
    }

    class Card2Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(informationHub.ifReplaced2==false&&informationHub.ifStart==true){
                informationHub.playerCards.set(1,informationHub.dealCard());
                label5.setIcon(new ImageIcon("Images/card_"+informationHub.playerCards.get(1)[0]+informationHub.playerCards.get(1)[1]+".gif"));
                informationHub.ifReplaced2=true;
                buttonCard2.setBackground(Color.GRAY);
                if(informationHub.ifHaveRelpaced==true){
                    buttonCard1.setBackground(Color.GRAY);
                    buttonCard2.setBackground(Color.GRAY);
                    buttonCard3.setBackground(Color.GRAY);
                    informationHub.ifReplaced1=true;
                    informationHub.ifReplaced2=true;
                    informationHub.ifReplaced3=true;
                }
                informationHub.ifHaveRelpaced=true;
            }
        }
    }

    class Card3Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(informationHub.ifReplaced3==false&&informationHub.ifStart==true){
                informationHub.playerCards.set(2,informationHub.dealCard());
                label6.setIcon(new ImageIcon("Images/card_"+informationHub.playerCards.get(2)[0]+informationHub.playerCards.get(2)[1]+".gif"));
                informationHub.ifReplaced3=true;
                buttonCard3.setBackground(Color.GRAY);
                if(informationHub.ifHaveRelpaced==true){
                    buttonCard1.setBackground(Color.GRAY);
                    buttonCard2.setBackground(Color.GRAY);
                    buttonCard3.setBackground(Color.GRAY);
                    informationHub.ifReplaced1=true;
                    informationHub.ifReplaced2=true;
                    informationHub.ifReplaced3=true;
                }
                informationHub.ifHaveRelpaced=true;
            }        
        }
    }

    class startListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(informationHub.ifStart==false&&betDealing()==true){
                for(int i=0;i<3;i++)
                informationHub.dealerCards.add(informationHub.dealCard());
                for(int i=0;i<3;i++)
                informationHub.playerCards.add(informationHub.dealCard());
                playerCardsDisplay();
                labelMessage.setText("Your current bet is: $"+InformationHub.getBet()+" ");
            }
        }
        private void playerCardsDisplay(){
            label4.setIcon(new ImageIcon("Images/card_"+informationHub.playerCards.get(0)[0]+informationHub.playerCards.get(0)[1]+".gif"));
            label5.setIcon(new ImageIcon("Images/card_"+informationHub.playerCards.get(1)[0]+informationHub.playerCards.get(1)[1]+".gif"));
            label6.setIcon(new ImageIcon("Images/card_"+informationHub.playerCards.get(2)[0]+informationHub.playerCards.get(2)[1]+".gif"));
        }
        private boolean betDealing(){
            try{
                int bet=Integer.parseInt((betInputField.getText()));
                if(bet<=0){
                    betInputField.setText("");
                    JOptionPane.showMessageDialog(null, "WARNING: The bet you place must be a positive integer!", "Input Warning", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(bet>InformationHub.getMoney()){
                    betInputField.setText("");
                    JOptionPane.showMessageDialog(null, "WARNING: You only have $"+InformationHub.getMoney()+"!", "Insufficient Balance", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    InformationHub.setBet(bet);
                    informationHub.ifStart=true;
                    buttonStart.setBackground(Color.GRAY);
                    buttonCard1.setBackground(Color.GREEN);
                    buttonCard2.setBackground(Color.GREEN);
                    buttonCard3.setBackground(Color.GREEN);
                    buttonResult.setBackground(Color.GREEN);
                    return true;
                }
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "WARNING: The bet you place must be a positive integer!", "Input Warning", JOptionPane.INFORMATION_MESSAGE);
                betInputField.setText("");
            }
            return false;
        }
    }

    class resultListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(informationHub.ifStart==true){
                if(determineOutcome()==true){
                    InformationHub.addMoney();
                    dealerCardsDisplay();
                    labelMoney.setText("Amount of money you have: $"+InformationHub.getMoney());
                    JOptionPane.showMessageDialog(null, "Congratulations! You win this round!","Congratulations", JOptionPane.INFORMATION_MESSAGE);
                    restart();
                }
                else if(determineOutcome()==false){
                    InformationHub.loseMoney();
                    dealerCardsDisplay();                   
                    labelMoney.setText("Amount of money you have: $"+InformationHub.getMoney());
                    JOptionPane.showMessageDialog(null, "Sorry! The Dealer wins this round!","Apologies", JOptionPane.INFORMATION_MESSAGE);
                    restart();
                    if(InformationHub.getMoney()<=0){
	                    labelMessage.setText("You have no more money! ");
	                    labelMoney.setText("Please start a new game!");
	                    buttonCard1.setBackground(Color.GRAY);
	                    buttonCard2.setBackground(Color.GRAY);
	                    buttonCard3.setBackground(Color.GRAY);
	                    buttonStart.setBackground(Color.GRAY);
	                    buttonResult.setBackground(Color.GRAY);
	                    informationHub.ifStart=false;
                        buttonStart.setEnabled(false);
                        buttonResult.setEnabled(false);	                    JOptionPane.showMessageDialog(null, "Game Over!\nYou have no more money!\nPlease start a new game!","Apologies", JOptionPane.INFORMATION_MESSAGE);
	                }
                }        
            }
        }
        private boolean determineOutcome(){
            int dealerSpecialCards=0;
            int dealerSum=0;
            int playerSum=0;
            int playerSpecialCards=0;
            for(int i=0;i<3;i++){
                if(informationHub.dealerCards.get(i)[1]>10)
                    dealerSpecialCards++;
                else
                    dealerSum+=informationHub.dealerCards.get(i)[1];
                if(informationHub.playerCards.get(i)[1]>10)
                    playerSpecialCards++;
                else
                    playerSum+=informationHub.playerCards.get(i)[1];     
            }
            if(dealerSpecialCards>playerSpecialCards)
            return false;
            else if(dealerSpecialCards<playerSpecialCards)
            return true;
            else{
                if(dealerSum%10 > playerSum%10)
                return false;
                else if(dealerSum%10 < playerSum%10)
                return true;
                else return false;
            }
        }
        private void dealerCardsDisplay(){
            label1.setIcon(new ImageIcon("Images/card_"+informationHub.dealerCards.get(0)[0]+informationHub.dealerCards.get(0)[1]+".gif"));
            label2.setIcon(new ImageIcon("Images/card_"+informationHub.dealerCards.get(1)[0]+informationHub.dealerCards.get(1)[1]+".gif"));
            label3.setIcon(new ImageIcon("Images/card_"+informationHub.dealerCards.get(2)[0]+informationHub.dealerCards.get(2)[1]+".gif"));
        }
        private void restart(){
            informationHub=new InformationHub();
            betInputField.setText("");
            buttonCard1.setBackground(Color.GRAY);
            buttonCard2.setBackground(Color.GRAY);
            buttonCard3.setBackground(Color.GRAY);
            buttonStart.setBackground(Color.GREEN);
            buttonResult.setBackground(Color.GRAY);
            label1.setIcon(new ImageIcon("Images/card_back.gif"));
            label2.setIcon(new ImageIcon("Images/card_back.gif"));
            label3.setIcon(new ImageIcon("Images/card_back.gif"));
            label4.setIcon(new ImageIcon("Images/card_back.gif"));
            label5.setIcon(new ImageIcon("Images/card_back.gif"));
            label6.setIcon(new ImageIcon("Images/card_back.gif"));
            labelMessage.setText("Please place your bet! ");
        }
    }
}