package projectPcPartReview;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;

class singPartStorkUI extends JFrame{
	private static final long serialVersionUID = 1L;
	Font defaultKor=setFonts.defaultK,titleKor=setFonts.title,button=setFonts.button,message=setFonts.massage,
			messageButton=setFonts.massageButton;
	objFontAndSize objfs=new objFontAndSize();
	singPartStorkUI(){
		super("何前 犁绊 包府");
		
		mainWindowOption();
	}
	void mainWindowOption() {
		UIManager.put("OptionPane.messageFont",message);
		UIManager.put("OptionPane.buttonFont",messageButton);
		setIconImage(new ImageIcon(getClass().getResource("../resource/windowTitle.png")).getImage());
		setSize(640,600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
public class singlePartStorkUI {
	static singPartStorkUI psu=null;
	public static void main(String[] args) {
		psu=new singPartStorkUI();
	}
}
