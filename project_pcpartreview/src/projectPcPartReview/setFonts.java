package projectPcPartReview;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JOptionPane;

public class setFonts {
	static Font title=new Font("�������",Font.BOLD,16)
			, defaultK=new Font("�������",Font.PLAIN,16)
			, button=new Font("�������",Font.BOLD,14)
			, massage=new Font("�������",Font.PLAIN,14)
			, massageButton=new Font("�������",Font.PLAIN,12);
	setFonts(){
		GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Font[] systemFonts=e.getAllFonts();
		String ftCheck="";
		for(Font font:systemFonts) {
			ftCheck=font.toString().substring(font.toString().indexOf("=")+1,font.toString().indexOf(","));
			if(ftCheck.equals("�������"))
				return;
		}
		title=new Font("����",Font.BOLD,20);
		defaultK=new Font("����",Font.PLAIN,20);
		button=new Font("����",Font.BOLD,16);
		massage=new Font("����",Font.PLAIN,16);
		massageButton=new Font("����",Font.PLAIN,14);
		JOptionPane.showMessageDialog(loginUI.loginW,"�� ���α׷��� ������� ����ȭ �Ǿ��ֽ��ϴ�.","font check",JOptionPane.WARNING_MESSAGE,null);
	}
}