package projectPcPartReview;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JOptionPane;

public class setFonts {
	static Font title=new Font("³ª´®°íµñ",Font.BOLD,16)
			, defaultK=new Font("³ª´®°íµñ",Font.PLAIN,16)
			, button=new Font("³ª´®°íµñ",Font.BOLD,14)
			, massage=new Font("³ª´®°íµñ",Font.PLAIN,14)
			, massageButton=new Font("³ª´®°íµñ",Font.PLAIN,12);
	setFonts(){
		GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Font[] systemFonts=e.getAllFonts();
		String ftCheck="";
		for(Font font:systemFonts) {
			ftCheck=font.toString().substring(font.toString().indexOf("=")+1,font.toString().indexOf(","));
			if(ftCheck.equals("³ª´®°íµñ"))
				return;
		}
		title=new Font("±¼¸²",Font.BOLD,20);
		defaultK=new Font("±¼¸²",Font.PLAIN,20);
		button=new Font("±¼¸²",Font.BOLD,16);
		massage=new Font("±¼¸²",Font.PLAIN,16);
		massageButton=new Font("±¼¸²",Font.PLAIN,14);
		JOptionPane.showMessageDialog(loginUI.loginW,"ÀÌ ÇÁ·Î±×·¥Àº ³ª´®°íµñ¿¡ ÃÖÀûÈ­ µÇ¾îÀÖ½À´Ï´Ù.","font check",JOptionPane.WARNING_MESSAGE,null);
	}
}