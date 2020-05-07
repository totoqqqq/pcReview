package projectPcPartReview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

class pcEstimateWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	JPanel pcEstimateMain=new JPanel(new BorderLayout()),pcEstimateMainNorth=new JPanel(new FlowLayout(FlowLayout.CENTER)),
			pcEstimateMainCenter=new JPanel(new GridLayout(1,2)),pcEstimateMainCenterLeft=new JPanel(new FlowLayout(FlowLayout.CENTER)),
			pcEstimateMainCenterRight=new JPanel(new GridLayout(6,1));
	JPanel[] pcEstimateMCRightList=new JPanel[6];
	@SuppressWarnings("rawtypes")
	static JComboBox[] Partlist=new JComboBox[6];
	String[] tableName={"CPU","MB","GPU","RAM","HDD","SSD"};
	JLabel title=new JLabel(new ImageIcon(getClass().getResource("../resource/pcEstimateTitle.png")));
	Font defaultKor=setFonts.defaultK,titleKor=setFonts.title,button=setFonts.button,message=setFonts.massage,
			messageButton=setFonts.massageButton;
	objFontAndSize objfs=new objFontAndSize();
	static int userlevel=0;
	pcEstimateWindow(){
		super("PC°ßÀû");
		pcEstimateWindowMainNorthOption();
		pcEstimateWindowMainCenterOption();
		mainWindowOption();
	}
	void pcEstimateWindowMainNorthOption() {
		pcEstimateMainNorth.add(title);
		pcEstimateMainNorth.setBackground(Color.WHITE);
		pcEstimateMainNorth.setBorder(BorderFactory.createEmptyBorder(40,0,0,0));
	}
	void pcEstimateWindowMainCenterOption() {
		objfs.addSetSize(pcEstimateMainCenter, pcEstimateMainCenterLeft);
		objfs.addSetSize(pcEstimateMainCenter, pcEstimateMainCenterRight);
		for(int i=0;i<pcEstimateMCRightList.length;i++) {
			objfs.addSetSize(pcEstimateMainCenterRight, pcEstimateMCRightList[i]=new JPanel(new FlowLayout(FlowLayout.CENTER)));
			pcEstimateMCRightList[i].add(Partlist[i]=new JComboBox<String>());
		}
	}
	void mainWindowOption(){
		add(pcEstimateMain);
		pcEstimateMain.add(pcEstimateMainNorth,BorderLayout.NORTH);
		pcEstimateMain.add(pcEstimateMainCenter,BorderLayout.CENTER);
		UIManager.put("OptionPane.messageFont",message);
		UIManager.put("OptionPane.buttonFont",messageButton);
		setSize(640,600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
public class pcEstimateUI {
	static pcEstimateWindow pew=new pcEstimateWindow();
	public static void main(String[] args) {
	}
}