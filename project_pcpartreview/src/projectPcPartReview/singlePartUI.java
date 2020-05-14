package projectPcPartReview;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
class singlePartWindow extends JFrame{
	//테스트 버전
	private static final long serialVersionUID = 1L;
	static JPanel singlePartMain=new JPanel(new BorderLayout()),singlePartMainNorth=new JPanel(new GridLayout(2,1)),
			singlePartMainCenter=new JPanel(new GridLayout(7,1)),singlePartMainSouth=new JPanel(new GridLayout(2,1)),
			singlePartMainNorthTop=new JPanel(new FlowLayout(FlowLayout.CENTER)),singlePartMainNorthBot=new JPanel(new FlowLayout(FlowLayout.CENTER)),
			singlePartMainSouthTop=new JPanel(new FlowLayout(FlowLayout.CENTER)),singlePartMainSouthBot=new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel[] singlePartMainCenterList=new JPanel[7];
	static String[] partList={"CPU","MB","GPU","RAM","SSD","HDD"},
			columnNameCPU={"부품종류","부품명","제조사","코어수","GHz","칩셋","TDP"},
			columnNameMB={"부품종류","부품명","제조사","메모리용량","PCI-E슬롯","칩셋","ATX"},
			columnNameGPU={"부품종류","부품명","제조사","VRAM","Mhz","팬","TDP"},
			columnNameRAM={"부품종류","부품명","제조사","DDR","GB","Mhz","램타이밍"},
			columnNameSSD={"부품종류","부품명","제조사","xLC","규격","표기GB","실제GB"},
			columnNameHDD={"부품종류","부품명","제조사","RPM","캐시","표기GB","실제GB"};
	static JComboBox<String> partComboNorth=new JComboBox<String>(partList)
			,partComboSouth=new JComboBox<String>(partList);
	static JButton[] columnTable=new JButton[columnNameCPU.length];
	static JButton singlePartSearch=new JButton("검색"),singlePartSave=new JButton("저장하기"),
			singlePartLoad=new JButton("불러오기"),singlePartDelete=new JButton("삭제하기"),
			singlePartViewLeft=new JButton(),singlePartViewRight=new JButton();
	static JCheckBox[] singlePartListCheck=new JCheckBox[6];
	static JTextField[][] singlePartListText=new JTextField[6][7];
	static JTextField singlePartSearchTextNorth=new JTextField(),singlePartSearchTextSouth=new JTextField(),
			singlePartViewPage=new JTextField(5);
	static JLabel singlePartTitle=new JLabel();
	static boolean[] columnNameCPUSort=new boolean[columnNameCPU.length];
	JMenuBar singlePartMenu=new JMenuBar();
	static JMenu singlePartMenuSystem=new JMenu("시스템"),singlePartMenuSetting=new JMenu("설정");
	static JMenuItem settingResetDB=new JMenuItem("초기화(R)",KeyEvent.VK_R),systemLogout=new JMenuItem("로그아웃(T)",KeyEvent.VK_T),
			systemExit=new JMenuItem("종료(X)",KeyEvent.VK_X), systemEstimate=new JMenuItem("PC견적(E)",KeyEvent.VK_E);
	Font defaultKor=setFonts.defaultK,titleKor=setFonts.title,button=setFonts.button,message=setFonts.massage,
			messageButton=setFonts.massageButton;
	objFontAndSize objfs=new objFontAndSize();
	singlePartWindow(){
		super("PC부품 비교 평가 시스템");
		singlePartMainPanelOption();
		singlePartMainNorthOption();
		singlePartMainCenterOption();
		singlePartMainSouthOption();
		mainWindowOption();
	}
	void singlePartMainNorthOption(){
		singlePartMainNorth.setBorder(BorderFactory.createEmptyBorder(20,0,10,0));
		singlePartMainNorth.setBackground(new Color(255,255,255));
		singlePartMainNorthTop.add(singlePartTitle);
		singlePartMainNorthBot.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
		singlePartMainNorthBot.add(partComboNorth);
		singlePartMainNorthObjectOption();
	}
	@SuppressWarnings("unused")
	void singlePartMainNorthObjectOption() {
		singlePartculmnsAction spa=null;
		spSearch sp=null;
		objfs.setSize(partComboNorth,defaultKor,80,30);
		partComboNorth.addItemListener(spa=new singlePartculmnsAction());
		objfs.addSetSize(singlePartMainNorthBot,singlePartSearchTextNorth,defaultKor,580,30);
		singlePartSearchTextNorth.setToolTipText(partComboNorth.getSelectedItem().toString()+"명을 전체 혹은 일부 입력해주세요");
		objfs.addSetSize(singlePartMainNorthBot,singlePartSearch,button,80,30);
		singlePartSearch.setIcon(new ImageIcon(getClass().getResource("../resource/search.png")));
		singlePartSearch.addActionListener(sp=new spSearch());
	}
	@SuppressWarnings("unused")
	void singlePartMainCenterOption(){
		viewSort vs=null;
		int count=0;
		singlePartMainCenterList[0].setBorder(BorderFactory.createEmptyBorder(0,25,0,0));
		for(String name:columnNameCPU) {
			if(count==1) 
				objfs.addSetSize(singlePartMainCenterList[0],columnTable[count]=new JButton(name),button,400,30);
			else if(count==singlePartListText[0].length-1)
				objfs.addSetSize(singlePartMainCenterList[0],columnTable[count]=new JButton(name),button,510/6,30);
			else
				objfs.addSetSize(singlePartMainCenterList[0],columnTable[count]=new JButton(name),button,450/6,30);
			columnNameCPUSort[count]=false;
			columnTable[count].addActionListener(vs=new viewSort());
			count++;
		}
		for(int i=1;i<=singlePartListText.length;i++) {
			singlePartMainCenterList[i].add(singlePartListCheck[i-1]=new JCheckBox());
			singlePartListCheck[i-1].setToolTipText("수정시에는 하나만 체크 후 '불러오기', 삭제시에는 삭제 할 데이터 전부 체크 후 '삭제' 눌러주세요");
			singlePartListCheck[i-1].setBackground(Color.WHITE);
			for(int j=0;j<singlePartListText[0].length;j++) {
				if(j==1)
					objfs.addSetSize(singlePartMainCenterList[i],singlePartListText[i-1][j]=new JTextField(),defaultKor,400,30);
				else if(j==singlePartListText[0].length-1)
					objfs.addSetSize(singlePartMainCenterList[i],singlePartListText[i-1][j]=new JTextField(),defaultKor,510/6,30);
				else
					objfs.addSetSize(singlePartMainCenterList[i],singlePartListText[i-1][j]=new JTextField(),defaultKor,450/6,30);
				singlePartListText[i-1][j].setEnabled(false);
				singlePartListText[i-1][j].setHorizontalAlignment(JTextField.CENTER);
				singlePartListText[i-1][j].setDisabledTextColor(Color.BLACK);
			}
		}
	}
	@SuppressWarnings("unused")
	void singlePartMainSouthOption() {
		spIUD siud=null;
		viewMovePage vmp=null;
		singlePartMainSouthTop.add(partComboSouth);
		singlePartMainSouthTop.setBorder(BorderFactory.createEmptyBorder(0,30,30,0));
		objfs.setSize(partComboSouth,defaultKor,80,30);
		objfs.addSetSize(singlePartMainSouthTop,singlePartSearchTextSouth,defaultKor,370,31);
		singlePartSearchTextSouth.setToolTipText(columnNameCPU[0]+"/"+columnNameCPU[1]+"/"+columnNameCPU[2]+"/"+columnNameCPU[3]+"/"+columnNameCPU[4]+"/"+columnNameCPU[5]+" 항목을 /으로 구분하여 입력해주세요.");
		objfs.addSetSize(singlePartMainSouthTop,singlePartLoad,button,110,30);
		singlePartLoad.addActionListener(siud=new spIUD());
		singlePartLoad.setIcon(new ImageIcon(getClass().getResource("../resource/load.png")));
		objfs.addSetSize(singlePartMainSouthTop,singlePartSave,button,110,30);
		singlePartSave.addActionListener(siud=new spIUD());
		singlePartSave.setIcon(new ImageIcon(getClass().getResource("../resource/save.png")));
		objfs.addSetSize(singlePartMainSouthTop,singlePartDelete,button,110,30);
		singlePartDelete.addActionListener(siud=new spIUD());
		singlePartDelete.setIcon(new ImageIcon(getClass().getResource("../resource/delete.png")));
		objfs.addSetSize(singlePartMainSouthBot,singlePartViewLeft,button,60,30);
		singlePartViewLeft.setIcon(new ImageIcon(getClass().getResource("../resource/previous.png")));
		singlePartViewLeft.setContentAreaFilled(false);
		singlePartViewLeft.addActionListener(vmp=new viewMovePage());
		objfs.addSetSize(singlePartMainSouthBot,singlePartViewPage,new Font("굴림",Font.BOLD,20),60,30);
		singlePartViewPage.setEnabled(false);
		singlePartViewPage.setText("1/1");
		singlePartViewPage.setBorder(BorderFactory.createEmptyBorder());
		singlePartViewPage.setHorizontalAlignment(JTextField.CENTER);
		singlePartViewPage.setDisabledTextColor(Color.BLACK);
		objfs.addSetSize(singlePartMainSouthBot,singlePartViewRight,button,60,30);
		singlePartViewRight.setIcon(new ImageIcon(getClass().getResource("../resource/next.png")));
		singlePartViewRight.setContentAreaFilled(false);
		singlePartViewRight.addActionListener(new viewMovePage());
	}
	void singlePartMainPanelOption(){
		singlePartMenuSystem spmsy=new singlePartMenuSystem();
		singPartMenuSetting spmst=new singPartMenuSetting();
		add(singlePartMain);
		objfs.addSetBorder(singlePartMain, singlePartMainNorth, BorderLayout.NORTH);
		objfs.addSetBorder(singlePartMain, singlePartMainCenter, BorderLayout.CENTER);
		objfs.addSetBorder(singlePartMain, singlePartMainSouth, BorderLayout.SOUTH);
		objfs.addSetColor(singlePartMainNorth,singlePartMainNorthTop);
		objfs.addSetColor(singlePartMainNorth,singlePartMainNorthBot);
		for(int i=0;i<singlePartMainCenterList.length;i++)
			objfs.addSetColor(singlePartMainCenter, singlePartMainCenterList[i]=new JPanel(new FlowLayout(FlowLayout.CENTER)), Color.WHITE);
		objfs.addSetColor(singlePartMainSouth,singlePartMainSouthTop);
		objfs.addSetColor(singlePartMainSouth,singlePartMainSouthBot);
		setJMenuBar(singlePartMenu);
		singlePartMenu.setBackground(new Color(255,255,255));
		singlePartMenu.setForeground(new Color(255,255,255));
		singlePartMenu.setBorder(BorderFactory.createLineBorder(new Color(255,255,255),0));
		singlePartMenu.add(singlePartMenuSystem);
		singlePartMenu.add(singlePartMenuSetting);
		singlePartMenuSystem.setFont(defaultKor);
		singlePartMenuSetting.setFont(defaultKor);
		objfs.addMenuItem(singlePartMenuSystem, systemEstimate, defaultKor, spmsy);
		singlePartMenuSystem.addSeparator();
		objfs.addMenuItem(singlePartMenuSystem, systemLogout, defaultKor, spmsy);
		objfs.addMenuItem(singlePartMenuSystem, systemExit, defaultKor, spmsy);
		objfs.addMenuItem(singlePartMenuSetting, settingResetDB, defaultKor, spmst);
	}
	void mainWindowOption(){
		UIManager.put("OptionPane.messageFont",message);
		UIManager.put("OptionPane.buttonFont",messageButton);
		setIconImage(new ImageIcon(getClass().getResource("../resource/windowTitle.png")).getImage());
		setSize(960,600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
class singlePartUI {
	static singlePartWindow spw=new singlePartWindow();
	int userlevel=0;
	singlePartUI(int level) {
		userlevel=level;
		if(userlevel>=0&&userlevel<9) {
			singlePartWindow.partComboSouth.setEnabled(false);
			singlePartWindow.singlePartSearchTextSouth.setEnabled(false);
			singlePartWindow.singlePartLoad.setEnabled(false);
			singlePartWindow.singlePartSave.setEnabled(false);
			singlePartWindow.singlePartDelete.setEnabled(false);
			singlePartWindow.singlePartTitle.setIcon(new ImageIcon(getClass().getResource("../resource/singlePartGuestTitle.png")));
			singlePartWindow.singlePartMenuSetting.setVisible(false);
		}
		else if(userlevel==9) {
			singlePartWindow.partComboSouth.setEnabled(true);
			singlePartWindow.singlePartSearchTextSouth.setEnabled(true);
			singlePartWindow.singlePartLoad.setEnabled(true);
			singlePartWindow.singlePartSave.setEnabled(true);
			singlePartWindow.singlePartDelete.setEnabled(true);
			singlePartWindow.singlePartTitle.setIcon(new ImageIcon(getClass().getResource("../resource/singlePartAdminTitle.png")));
			singlePartWindow.singlePartMenuSetting.setVisible(true);
		}
		else {
			System.exit(0);
		}
		singlePartUI.spw.setVisible(true);
	}
}