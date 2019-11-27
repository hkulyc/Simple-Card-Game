import java.awt.Color;
import javax.swing.JButton;

/**
 * This class is the subclass for JButton, which differently, has
 * default color gray.
 * 
 * @author Liu Yuchen
 * @version 1.1
 */
class Button extends JButton{
	private static final long serialVersionUID = 1L;

	/**
	 * This is the constructor for this class. It overrides the JButton constructor.
	 * Add a new feature that the button will by default be gray.
	 */
	public Button(String text) {
        super(text);
        setBackground(Color.GRAY);
    }
}