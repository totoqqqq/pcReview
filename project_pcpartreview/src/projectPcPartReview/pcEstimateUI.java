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
import javax.swing.UIManager;

class pcEstimateDialog extends JFrame{
	private static final long serialVersionUID = 1L;
	JPanel pcEsimateDialogMain=new JPanel(new BorderLayout()),pEDMNorth=new JPanel(new FlowLayout(FlowLayout.CENTER)),
			pEDMCenter=new JPanel(new FlowLayout(FlowLayout.CENTER)),pEDMSouth=new JPanel(new FlowLayout(FlowLayout.CENTER));
	JButton esimateLoad=new JButton("불러오기"),esimateDelete=new JButton("삭제");
	Font defaultKor=setFonts.defaultK,titleKor=setFonts.title,button=setFonts.button,message=setFonts.massage,
			messageButton=setFonts.massageButton;
	objFontAndSize objfs=new objFontAndSize();
	JLabel title=new JLabel("견적 불러오기");	
	pcEstimateDialog(){
//		super(pcEstimateUI.pew,"저장된 견적정보 확인",true);
		super("저장된 견적 정보 확인");
		pcEsimateDialogMainNorth();
		pcEsimateDialogMainCenter();
		pcEsimateDialogMainSouth();
		mainDialogOption();
	}
	void pcEsimateDialogMainNorth() {
		pEDMNorth.add(title);
		pEDMNorth.setBackground(Color.WHITE);
		pEDMNorth.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));
		title.setFont(titleKor);
		title.setForeground(new Color(86,162,255));
	}
	void pcEsimateDialogMainCenter() {
		pEDMCenter.add(pcEstimateWindow.reviewsave);
		objfs.setSize(pcEstimateWindow.reviewsave,defaultKor,600,30);
	}
	void pcEsimateDialogMainSouth() {
		pcEstiamateLoad pel=new pcEstiamateLoad();
		pcEstiamateDelete ped=new pcEstiamateDelete();
		objfs.addSetSize(pEDMSouth, esimateLoad, button, 80, 30);
		esimateLoad.addActionListener(pel);
		objfs.addSetSize(pEDMSouth, esimateDelete, button, 80, 30);
		esimateDelete.addActionListener(ped);
		pEDMSouth.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));
	}
	void mainDialogOption(){
		add(pcEsimateDialogMain);
		objfs.addSetBorder(pcEsimateDialogMain,pEDMNorth,BorderLayout.NORTH);
		objfs.addSetBorder(pcEsimateDialogMain,pEDMCenter,BorderLayout.CENTER);
		objfs.addSetBorder(pcEsimateDialogMain,pEDMSouth,BorderLayout.SOUTH);
		setIconImage(new ImageIcon(getClass().getResource("../resource/windowTitle.png")).getImage());
		setSize(610,220);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
	static JComboBox<String> reviewsave=new JComboBox<String>();
	JLabel[] partListName=new JLabel[6];
	String[] tableName={"CPU","MB","GPU","RAM","SSD","HDD"};
	JLabel title=new JLabel(new ImageIcon(getClass().getResource("../resource/pcEstimateTitle.png")));
	Font defaultKor=setFonts.defaultK,titleKor=setFonts.title,button=setFonts.button,message=setFonts.massage,
			messageButton=setFonts.massageButton;
	objFontAndSize objfs=new objFontAndSize();
	static Boolean savemode=true;
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
		objfs.addSetColor(pcEstimateMainCenter, pcEstimateMainCenterRow);
		for(int i=0;i<pcEstimateMCList.length;i++) {
			objfs.addSetColor(pcEstimateMainCenterRow, pcEstimateMCList[i]=new JPanel(new FlowLayout(FlowLayout.CENTER)));
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
		objfs.addSetBorder(pcEstimateMain,pcEstimateMainNorth,BorderLayout.NORTH);
		objfs.addSetBorder(pcEstimateMain,pcEstimateMainCenter,BorderLayout.CENTER);
		objfs.addSetBorder(pcEstimateMain,pcEstimateMainSouth,BorderLayout.SOUTH);
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
class pcEstimateUI {
	static pcEstimateWindow pew=new pcEstimateWindow();

}
class pcEstimaDialog{
	static pcEstimateDialog ped=new pcEstimateDialog();
	static void close() {
		ped.setVisible(false);
	}
}