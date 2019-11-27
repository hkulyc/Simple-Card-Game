import java.util.ArrayList;
import java.util.Collections;

/**
 * This class contains the information(log of user, process of game, deck).
 * Every round of game should have one unique informationHub.
 * 
 * @author Liu Yuchen
 * @version 1.1
 */
public class InformationHub {
    public boolean ifStart=false;
    public boolean ifReplaced1=false;
    public boolean ifReplaced2=false;
    public boolean ifReplaced3=false;
    public boolean ifHaveRelpaced=false;
    public boolean ifLoseAll=false;
    private static int money=100;
    private static int bet;
    private ArrayList<Integer[]> deck;
    private int cardNumber;
    public ArrayList<Integer[]> dealerCards, playerCards;
    
    /**
     * This static method gives the value of money.
     * 
     * @return the number of money in the whole game
     */
    public static int getMoney(){
        return money;
    }
    
    /**
     * This static method gives the value of bet.
     * 
     * @return the number of bet now
     */
    public static int getBet(){
        return bet;
    }
    
    /**
     * This static method adds bet to money.
     */
    public static void addMoney(){
        money+=bet;
    }
    
    /**
     * This static method subtracts money by bet.
     */
    public static void loseMoney(){
        money-=bet;
    }
    
    /**
     * This static method changes the value of bet.
     * 
     * @param b the integer gives the value to bet
     */
    public static void setBet(int b){
        bet=b;
    }
    
    /**
     * This is the constructor for this class. Whenever it is called, the state variables 
     * for each round will be refreshed. Also, the deck will be shuffled agian.
     */
    public InformationHub(){
        ifStart=false;
        ifReplaced1=false;
        ifReplaced2=false;
        ifReplaced3=false;
        ifHaveRelpaced=false;
        ifLoseAll=false;
        deck=new ArrayList<Integer[]>();
        dealerCards=new ArrayList<Integer[]>();
        playerCards=new ArrayList<Integer[]>();
        for(int i=1;i<=13;i++){
            for(int j=1;j<=4;j++){
                Integer[] card={j,i};
                deck.add(card);
            }  
        }
        Collections.shuffle(deck);
        cardNumber=0;
    }
    
    /**
     * This method deals one card each time.
     * 
     * @return an Integer array with the first element representing suit, and the second element representing number. 
     */
    public Integer[] dealCard(){
        cardNumber++;
        return deck.get(cardNumber);
    }
}