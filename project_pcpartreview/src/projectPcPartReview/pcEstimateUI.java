package projectPcPartReview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;

class pcEstimateDialog extends JFrame{
	private static final long serialVersionUID = 1L;
	static JPanel pcEsimateDialogMain=new JPanel(new BorderLayout()),pEDMNorth=new JPanel(new FlowLayout(FlowLayout.CENTER)),
			pEDMCenter=new JPanel(new FlowLayout(FlowLayout.CENTER)),pEDMSouth=new JPanel(new FlowLayout(FlowLayout.CENTER));
	JButton esimateLoad=new JButton("불러오기"),esimateDelete=new JButton("삭제");
	Font defaultKor=setFonts.defaultK,titleKor=setFonts.title,button=setFonts.button,message=setFonts.massage,
			messageButton=setFonts.massageButton;
	objFontAndSize objfs=new objFontAndSize();
	JLabel title=new JLabel("견적 불러오기");	
	static JComboBox<String> reviewsave=new JComboBox<String>();
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
		pEDMCenter.add(reviewsave);
		objfs.setSize(reviewsave,defaultKor,600,30);
	}
	void pcEsimateDialogMainSouth() {
		pcEstiamateLoad pel=new pcEstiamateLoad();
		pcEstiamateDelete ped=new pcEstiamateDelete();
		objfs.addSetSize(pEDMSouth, esimateLoad, button, 120, 30);
		esimateLoad.setIcon(new ImageIcon(getClass().getResource("../resource/load.png")));
		esimateLoad.addActionListener(pel);
		objfs.addSetSize(pEDMSouth, esimateDelete, button, 120, 30);
		esimateDelete.setIcon(new ImageIcon(getClass().getResource("../resource/delete.png")));
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
	static JPanel pcEstimateMain=new JPanel(new BorderLayout()),pcEstimateMainNorth=new JPanel(new FlowLayout(FlowLayout.CENTER)),
			pcEstimateMainCenter=new JPanel(new GridLayout(1,6)),pcEstimateMainCenterRow=new JPanel(new FlowLayout(FlowLayout.CENTER)),
			pcEstimateMainSouth=new JPanel(new FlowLayout(FlowLayout.CENTER));
	static JPanel[] pcEstimateMCList=new JPanel[6];
	static JButton save=new JButton("견적 저장"),load=new JButton("견적 불러오기");
	@SuppressWarnings("rawtypes")
	static JComboBox[] partList=new JComboBox[6];
	static JLabel[] partListName=new JLabel[6];
	static String[] tableName={"CPU","MB","GPU","RAM","SSD","HDD"};
	JLabel title=new JLabel(new ImageIcon(getClass().getResource("../resource/pcEstimateTitle.png")));
	JMenuBar pcEstimateUIMenu=new JMenuBar();
	static JMenu pcEstimateUIMenuSystem=new JMenu("시스템");
	static JMenuItem systemLogout=new JMenuItem("로그아웃(T)",KeyEvent.VK_T),systemExit=new JMenuItem("종료(X)",KeyEvent.VK_X),
			systemSinglePart=new JMenuItem("부품 정보(S)",KeyEvent.VK_S);
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
		pcEstimateMainNorth.setBorder(BorderFactory.createEmptyBorder(20,0,30,0));
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
		pcEstimateMainSouth.setBorder(BorderFactory.createEmptyBorder(0,0,30,0));
		objfs.addSetSize(pcEstimateMainSouth, save, button, 150, 30);
		save.setIcon(new ImageIcon(getClass().getResource("../resource/save.png")));
		save.addActionListener(pel=new pcEstimateAction());
		objfs.addSetSize(pcEstimateMainSouth, load, button, 150, 30);
		load.addActionListener(pel=new pcEstimateAction());
		load.setIcon(new ImageIcon(getClass().getResource("../resource/load.png")));
	}
	void mainWindowOption(){
		pcEstiamateMenuSystem ems=new pcEstiamateMenuSystem();
		add(pcEstimateMain);
		objfs.addSetBorder(pcEstimateMain,pcEstimateMainNorth,BorderLayout.NORTH);
		objfs.addSetBorder(pcEstimateMain,pcEstimateMainCenter,BorderLayout.CENTER);
		objfs.addSetBorder(pcEstimateMain,pcEstimateMainSouth,BorderLayout.SOUTH);
		setJMenuBar(pcEstimateUIMenu);
		pcEstimateUIMenu.setBackground(new Color(255,255,255));
		pcEstimateUIMenu.setForeground(new Color(255,255,255));
		pcEstimateUIMenu.setBorder(BorderFactory.createLineBorder(new Color(255,255,255),0));
		pcEstimateUIMenu.add(pcEstimateUIMenuSystem);
		pcEstimateUIMenuSystem.setFont(defaultKor);
		objfs.addMenuItem(pcEstimateUIMenuSystem, systemSinglePart, defaultKor, ems);
		pcEstimateUIMenuSystem.addSeparator();
		objfs.addMenuItem(pcEstimateUIMenuSystem, systemLogout, defaultKor, ems);
		objfs.addMenuItem(pcEstimateUIMenuSystem, systemExit, defaultKor, ems);
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
	static pcEstimateWindow pew;
	static objFontAndSize objfs=new objFontAndSize();
	static Font defaultKor=setFonts.defaultK;
	static void close() {
		pew.setVisible(false);
	}
	static void create() {
		pew=new pcEstimateWindow();
	}
	static void open() {
		for(int i=0;i<pcEstimateWindow.pcEstimateMCList.length;i++) {
			pcEstimateWindow.pcEstimateMCList[i].remove(pcEstimateWindow.partList[i]);
			new partNameImport(i);
			pcEstimateWindow.pcEstimateMCList[i].add(pcEstimateWindow.partList[i]);
			objfs.setSize(pcEstimateWindow.partList[i],defaultKor,480,30);
		}
		pew.setLocationRelativeTo(null);
		pew.setVisible(true);
	}
}
class pcEstimaDialog{
	static pcEstimateDialog ped;
	static void close() {
		ped.setVisible(false);
	}
	static void create() {
		ped=new pcEstimateDialog();
	}
	static void open() {
		ped.setLocationRelativeTo(null);
		ped.setVisible(true);
	}
}