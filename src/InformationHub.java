import java.util.ArrayList;
import java.util.Collections;

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
    public static int getMoney(){
        return money;
    }
    public static int getBet(){
        return bet;
    }
    public static void addMoney(){
        money+=bet;
    }
    public static void loseMoney(){
        money-=bet;
    }
    public static void setBet(int b){
        bet=b;
    }
    public static void refresh(){
        
    }
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
    public Integer[] dealCard(){
        cardNumber++;
        return deck.get(cardNumber);
    }
}