package projectPcPartReview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;

class pcEsimateDialog extends JDialog{
	private static final long serialVersionUID = 1L;
	JPanel pcEsimateDialogMain=new JPanel(new BorderLayout()),pEDMNorth=new JPanel(new FlowLayout(FlowLayout.CENTER)),
			pEDMCenter=new JPanel(new GridLayout(1,2)),pEDMCenterLeft=new JPanel(new FlowLayout(FlowLayout.CENTER)),
			pEDMCenterRight=new JPanel(new FlowLayout(FlowLayout.CENTER));
	JButton esimateLoad=new JButton("불러오기"),esimateDelete=new JButton("삭제");
	Font defaultKor=setFonts.defaultK,titleKor=setFonts.title,button=setFonts.button,message=setFonts.massage,
			messageButton=setFonts.massageButton;
	objFontAndSize objfs=new objFontAndSize();
	JLabel title=new JLabel("견적 불러오기");
	String[] pcColumns={"저장일자","저장 이름"};
	String[][] pcTables={{" "},{" "}};
	JTable pcEsimateView=new JTable(pcTables,pcColumns);
	pcEsimateDialog(){
		super(pcEstimateUI.pew,"저장된 견적정보 확인",true);
		pcEsimateDialogMainNorth();
		pcEsimateDialogMainCenter();
		mainDialogOption();
	}
	void pcEsimateDialogMainNorth() {
		pEDMNorth.add(title);
		pEDMNorth.setBackground(Color.WHITE);
		pEDMNorth.setBorder(BorderFactory.createEmptyBorder(30,0,30,0));
		title.setFont(titleKor);
		title.setForeground(new Color(86,162,255));
	}
	void pcEsimateDialogMainCenter() {
		objfs.addSetSize(pEDMCenter, pEDMCenterLeft);
		objfs.addSetSize(pEDMCenter, pEDMCenterRight);
		pEDMCenterLeft.add(pcEsimateView);
		objfs.addSetSize(pEDMCenterRight, esimateLoad, button, 80, 30);
		objfs.addSetSize(pEDMCenterRight, esimateDelete, button, 80, 30);
	}
	void mainDialogOption(){
		add(pcEsimateDialogMain);
		pcEsimateDialogMain.add(pEDMNorth,BorderLayout.NORTH);
		pcEsimateDialogMain.add(pEDMCenter,BorderLayout.CENTER);
		setIconImage(new ImageIcon(getClass().getResource("../resource/windowTitle.png")).getImage());
		setSize(320,500);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
class pcEstimateWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	JPanel pcEstimateMain=new JPanel(new BorderLayout()),pcEstimateMainNorth=new JPanel(new FlowLayout(FlowLayout.CENTER)),
			pcEstimateMainCenter=new JPanel(new GridLayout(1,6)),pcEstimateMainCenterRow=new JPanel(new FlowLayout(FlowLayout.CENTER)),
			pcEstimateMainSouth=new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel[] pcEstimateMCList=new JPanel[6];
	static JButton save=new JButton("견적 저장"),check=new JButton("호환성 확인"),load=new JButton("견적 불러오기"), print=new JButton("견적 인쇄");
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
		super("PC견적");
		pcEstimateWindowMainNorthOption();
		pcEstimateWindowMainCenterOption();
		pcEstimateWindowMainSouthOption();
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
	@SuppressWarnings("unused")
	void pcEstimateWindowMainSouthOption() {
		pcEstimateAction pel=null;
		pcEstimateMainSouth.setBackground(Color.WHITE);
		pcEstimateMainSouth.setBorder(BorderFactory.createEmptyBorder(0,0,40,0));
		objfs.addSetSize(pcEstimateMainSouth, check, defaultKor, 120, 30);
		objfs.addSetSize(pcEstimateMainSouth, save, defaultKor, 120, 30);
		save.addActionListener(pel=new pcEstimateAction());
		objfs.addSetSize(pcEstimateMainSouth, load, defaultKor, 120, 30);
		load.addActionListener(pel=new pcEstimateAction());
		objfs.addSetSize(pcEstimateMainSouth, print, defaultKor, 120, 30);
	}
	void mainWindowOption(){
		add(pcEstimateMain);
		pcEstimateMain.add(pcEstimateMainNorth,BorderLayout.NORTH);
		pcEstimateMain.add(pcEstimateMainCenter,BorderLayout.CENTER);
		pcEstimateMain.add(pcEstimateMainSouth,BorderLayout.SOUTH);
		UIManager.put("OptionPane.messageFont",message);
		UIManager.put("OptionPane.buttonFont",messageButton);
		setIconImage(new ImageIcon(getClass().getResource("../resource/windowTitle.png")).getImage());
		setSize(640,530);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
public class pcEstimateUI {
	static pcEstimateWindow pew=null;
	static pcEsimateDialog ped=null;
	public static void main(String[] args) {
		pew=new pcEstimateWindow();
	}
}