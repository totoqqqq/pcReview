package projectPcPartReview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

class loginWindow extends JFrame{
	//테스트 버전
	private static final long serialVersionUID = 1L;
	JPanel loginMain = new JPanel(new BorderLayout()),loginMainNorth=new JPanel(new FlowLayout(FlowLayout.CENTER)),
			loginMainCenter=new JPanel(new FlowLayout(FlowLayout.CENTER)),loginMCLeft=new JPanel(new GridLayout(2,1))
			,loginMCCenter=new JPanel(new GridLayout (2,1)),loginMCLeftTop=new JPanel(new FlowLayout(FlowLayout.CENTER))
			,loginMCLeftBot=new JPanel(new FlowLayout(FlowLayout.CENTER)),loginMCCenterTop=new JPanel(new FlowLayout(FlowLayout.CENTER))
			,loginMCCenterBot=new JPanel(new FlowLayout(FlowLayout.CENTER)),loginMCRight=new JPanel(new FlowLayout(FlowLayout.CENTER));
	JLabel loginTitle = new JLabel(),loginIDLabel = new JLabel(),loginPassLabel = new JLabel();
	static JTextField loginIDText=new JTextField();
	static JPasswordField loginPassText=new JPasswordField();
	JButton loginButton=new JButton(new ImageIcon(getClass().getResource("../resource/login.png")));
	objFontAndSize objfs=new objFontAndSize();
	Font defaultKor=setFonts.defaultK,titleKor=setFonts.title,button=setFonts.button,message=setFonts.massage,
			messageButton=setFonts.massageButton;
	loginWindow() {
		super("PC 비교 평가 시스템");
		new setFonts();
		loginMainPanelOption();
		loginMainNorthOption();
		loginMainCenterOption();
		loginMainPanelOption();
		mainOption();
	}
	void loginMainPanelOption(){
		add(loginMain);
		loginMain.add(loginMainNorth, BorderLayout.NORTH);
		loginMainNorth.setBackground(Color.WHITE);
		loginMain.add(loginMainCenter, BorderLayout.CENTER);
		loginMainCenter.setBackground(Color.WHITE);
	}
	void loginMainNorthOption(){
		loginMainNorth.add(loginTitle);
		loginTitle.setToolTipText("PC 비교 평가 시스템 회원 로그인");
		loginTitle.setIcon(new ImageIcon(getClass().getResource("../resource/loginTitle.png")));
		loginTitle.setBorder(BorderFactory.createEmptyBorder(5,0,0,0));
		loginTitle.setFont(titleKor);
	}
	void loginMainCenterOption() {
		objfs.addSetSize(loginMainCenter, loginMCLeft);
		objfs.addSetSize(loginMainCenter, loginMCCenter);
		objfs.addSetSize(loginMainCenter, loginMCRight);
		objfs.addSetSize(loginMCLeft, loginMCLeftTop);
		objfs.addSetSize(loginMCLeft, loginMCLeftBot);
		objfs.addSetSize(loginMCCenter, loginMCCenterTop);
		objfs.addSetSize(loginMCCenter, loginMCCenterBot);
		loginMainCenterObjectOption();
	}
	void loginMainCenterObjectOption() {
		loginMCLeftTop.add(loginIDLabel);
		loginIDLabel.setIcon(new ImageIcon(getClass().getResource("../resource/id.png")));
		loginIDLabel.setToolTipText("ID를 입력하세요.");
		loginMCLeftBot.add(loginPassLabel);
		loginPassLabel.setIcon(new ImageIcon(getClass().getResource("../resource/password.png")));
		loginPassLabel.setToolTipText("Password를 입력하세요.");
		objfs.addSetSize(loginMCCenterTop, loginIDText, defaultKor, 140, 30);
		loginIDText.setToolTipText("ID를 입력하세요.");
		objfs.addSetSize(loginMCCenterBot, loginPassText, defaultKor, 140, 30);
		loginPassText.setToolTipText("Password를 입력하세요.");
		loginPassText.addKeyListener(new loginEnterAction());
		objfs.addSetSize(loginMCRight, loginButton, button, 70, 70);
		loginButton.setMargin(new Insets(10,0,10,0));
		loginButton.addActionListener(new loginAction());
		loginButton.setToolTipText("로그인");
	}
	void mainOption(){
		UIManager.put("OptionPane.messageFont",message);
		UIManager.put("OptionPane.buttonFont",messageButton);
		setSize(320,190);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}

public class loginUI {
	static loginWindow loginW=new loginWindow();
	loginUI(){
		loginW=new loginWindow();
	}
	public static void main(String[] args) {
	}
}