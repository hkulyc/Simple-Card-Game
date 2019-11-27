/**
 * This class contains the main function of the program.
 * 
 * @author Liu Yuchen
 * @version 1.1
 */
public class kernels{
    public static void main(String[] args){
        CardGame cardGame = new CardGame();
        cardGame.frameDesign();
        cardGame.menuBarConfiguration();
        cardGame.DealerPanelDesign();
        cardGame.PlayerPanelDesign();
        cardGame.RpCardBtnPanelDesign();  
        cardGame.ButtonPanelDesign();      
        cardGame.InfoPanelDesign();
        cardGame.frameVisible();
    }
}