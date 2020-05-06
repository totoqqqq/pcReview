package projectPcPartReview;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
class singlePartWindow extends JFrame{
	//테스트 버전
	private static final long serialVersionUID = 1L;
	static JPanel singlePartMain=new JPanel(new BorderLayout()),singlePartMainNorth=new JPanel(new GridLayout(2,1)),
			singlePartMainCenter=new JPanel(new GridLayout(7,1)),singlePartMainSouth=new JPanel(new GridLayout(2,1)),
			singlePartMainNorthTop=new JPanel(new FlowLayout(FlowLayout.CENTER)),singlePartMainNorthBot=new JPanel(new FlowLayout(FlowLayout.CENTER)),
			singlePartMainSouthTop=new JPanel(new FlowLayout(FlowLayout.CENTER)),singlePartMainSouthBot=new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel[] singlePartMainCenterList=new JPanel[7];
	static String[] partList={"CPU","MB","GPU","RAM","SSD","HDD"},
			columnNameCPU={"부품종류","부품명","제조사","코어수","GHz","칩셋","TDP"};
	static JComboBox<String> partComboNorth=new JComboBox<String>(partList)
			,partComboSouth=new JComboBox<String>(partList);
	static JButton[] columnCPU=new JButton[columnNameCPU.length];
	static JButton singlePartSearch=new JButton("검색"),singlePartSave=new JButton("저장하기"),
			singlePartLoad=new JButton("불러오기"),singlePartDelete=new JButton("삭제하기"),
			singlePartViewLeft=new JButton(),singlePartViewRight=new JButton();
	static JCheckBox[] singlePartListCheck=new JCheckBox[6];
	static JTextField[] singlePartListText=new JTextField[6];
	static JTextField singlePartSearchTextNorth=new JTextField(),singlePartSearchTextSouth=new JTextField(),
			singlePartViewPage=new JTextField(5);
	static JLabel singlePartTitle=new JLabel();
	static boolean[] columnNameCPUSort=new boolean[columnNameCPU.length];
	Font defaultKor=setFonts.defaultK,titleKor=setFonts.title,button=setFonts.button;
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
		singlePartMainNorth.setBorder(BorderFactory.createEmptyBorder(40,0,20,0));;
		singlePartMainNorthTop.add(singlePartTitle);
		singlePartMainNorthBot.add(partComboNorth);
		singlePartTitle.setFont(titleKor);
		singlePartMainNorthObjectOption();
	}
	void singlePartMainNorthObjectOption() {
		objfs.setSize(partComboNorth,defaultKor,80,30);
		objfs.addSetSize(singlePartMainNorthBot,singlePartSearchTextNorth,defaultKor,580,31);
		singlePartSearchTextNorth.setToolTipText(partComboNorth.getSelectedItem().toString()+"명을 전체 혹은 일부 입력해주세요");
		objfs.addSetSize(singlePartMainNorthBot,singlePartSearch,button,80,30);
		singlePartSearch.setIcon(new ImageIcon(getClass().getResource("../resource/search.png")));
		singlePartSearch.addActionListener(new spSearch());
	}
	void singlePartMainCenterOption(){
		int count=0;
		singlePartMainCenterList[0].setBorder(BorderFactory.createEmptyBorder(0,25,0,0));
		for(String name:columnNameCPU) {
			objfs.addSetSize(singlePartMainCenterList[0],columnCPU[count]=new JButton(name),button,110,30);
			columnNameCPUSort[count]=false;
			columnCPU[count].addActionListener(new viewSort());
			count++;
		}
		for(int i=1;i<=singlePartListText.length;i++) {
			singlePartMainCenterList[i].add(singlePartListCheck[i-1]=new JCheckBox());
			singlePartListCheck[i-1].setToolTipText("수정시에는 하나만 체크 후 '불러오기', 삭제시에는 삭제 할 데이터 전부 체크 후 '삭제' 눌러주세요");
			objfs.addSetSize(singlePartMainCenterList[i],singlePartListText[i-1]=new JTextField(),defaultKor,800,30);
			singlePartListText[i-1].setEnabled(false);
			singlePartListText[i-1].setHorizontalAlignment(JTextField.CENTER);
			singlePartListText[i-1].setDisabledTextColor(Color.BLACK);
		}
	}
	void singlePartMainSouthOption() {
		singlePartMainSouthTop.add(partComboSouth);
		singlePartMainSouthTop.setBorder(BorderFactory.createEmptyBorder(0,30,30,0));
		objfs.setSize(partComboSouth,defaultKor,80,30);
		objfs.addSetSize(singlePartMainSouthTop,singlePartSearchTextSouth,defaultKor,370,31);
		singlePartSearchTextSouth.setToolTipText("부품명/제조사/코어수/GHZ/칩셋/TDP 항목을 /으로 구분하여 입력해주세요.");
		objfs.addSetSize(singlePartMainSouthTop,singlePartLoad,button,110,30);
		singlePartLoad.addActionListener(new spIUD());
		singlePartLoad.setIcon(new ImageIcon(getClass().getResource("../resource/load.png")));
		objfs.addSetSize(singlePartMainSouthTop,singlePartSave,button,110,30);
		singlePartSave.addActionListener(new spIUD());
		singlePartSave.setIcon(new ImageIcon(getClass().getResource("../resource/save.png")));
		objfs.addSetSize(singlePartMainSouthTop,singlePartDelete,button,110,30);
		singlePartDelete.addActionListener(new spIUD());
		singlePartDelete.setIcon(new ImageIcon(getClass().getResource("../resource/delete.png")));
		objfs.addSetSize(singlePartMainSouthBot,singlePartViewLeft,button,60,30);
		singlePartViewLeft.setIcon(new ImageIcon(getClass().getResource("../resource/previous.png")));
		singlePartViewLeft.setContentAreaFilled(false);
		singlePartViewLeft.addActionListener(new viewMovePage());
		objfs.addSetSize(singlePartMainSouthBot,singlePartViewPage,defaultKor,60,30);
		singlePartViewPage.setEnabled(false);
		singlePartViewPage.setText("1/1");
		singlePartViewPage.setHorizontalAlignment(JTextField.CENTER);
		singlePartViewPage.setDisabledTextColor(Color.BLACK);
		objfs.addSetSize(singlePartMainSouthBot,singlePartViewRight,button,60,30);
		singlePartViewRight.setIcon(new ImageIcon(getClass().getResource("../resource/next.png")));
		singlePartViewRight.setContentAreaFilled(false);
		singlePartViewRight.addActionListener(new viewMovePage());
	}
	void singlePartMainPanelOption(){
		add(singlePartMain);
		singlePartMain.add(singlePartMainNorth,BorderLayout.NORTH);
		singlePartMain.add(singlePartMainCenter,BorderLayout.CENTER);
		singlePartMain.add(singlePartMainSouth,BorderLayout.SOUTH);
		singlePartMainNorth.add(singlePartMainNorthTop);
		singlePartMainNorth.add(singlePartMainNorthBot);
		for(int i=0;i<singlePartMainCenterList.length;i++)
			singlePartMainCenter.add(singlePartMainCenterList[i]=new JPanel(new FlowLayout(FlowLayout.CENTER)));
		singlePartMainSouth.add(singlePartMainSouthTop);
		singlePartMainSouth.add(singlePartMainSouthBot);
	}
	void mainWindowOption(){
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
		if(userlevel==1) {
			singlePartWindow.partComboSouth.setEnabled(false);
			singlePartWindow.singlePartSearchTextSouth.setEnabled(false);
			singlePartWindow.singlePartLoad.setEnabled(false);
			singlePartWindow.singlePartSave.setEnabled(false);
			singlePartWindow.singlePartDelete.setEnabled(false);
			singlePartWindow.singlePartTitle.setText("단일 부품 비교(사용자)");
		}
		else if(userlevel==9) {
			singlePartWindow.partComboSouth.setEnabled(true);
			singlePartWindow.singlePartSearchTextSouth.setEnabled(true);
			singlePartWindow.singlePartLoad.setEnabled(true);
			singlePartWindow.singlePartSave.setEnabled(true);
			singlePartWindow.singlePartDelete.setEnabled(true);
			singlePartWindow.singlePartTitle.setText("단일 부품 비교(관리자)");
		}
	}
}