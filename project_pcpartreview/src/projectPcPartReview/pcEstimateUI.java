package projectPcPartReview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
			pcEstimateMainCenter=new JPanel(new GridLayout(1,6)),pcEstimateMainCenterRow=new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel[] pcEstimateMCList=new JPanel[6];
	@SuppressWarnings("rawtypes")
	static JComboBox[] partList=new JComboBox[6];
	JLabel[] partListName=new JLabel[6];
	String[] tableName={"CPU","MB","GPU","RAM","SSD","HDD"},partname=null;
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
		pcEstimateMainNorth.setBorder(BorderFactory.createEmptyBorder(30,0,30,0));
	}
	void pcEstimateWindowMainCenterOption() {
		objfs.addSetSize(pcEstimateMainCenter, pcEstimateMainCenterRow);
		for(int i=0;i<pcEstimateMCList.length;i++) {
			objfs.addSetSize(pcEstimateMainCenterRow, pcEstimateMCList[i]=new JPanel(new FlowLayout(FlowLayout.CENTER)));
			pcEstimateMCList[i].add(partListName[i]=new JLabel(tableName[i]));
			partListName[i].setFont(defaultKor);
			partListName[i].setPreferredSize(new Dimension(60,20));
			new partNameImport(i);
			pcEstimateMCList[i].add(partList[i]);
			objfs.setSize(partList[i],defaultKor,480,30);
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