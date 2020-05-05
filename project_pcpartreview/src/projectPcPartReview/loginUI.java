package projectPcPartReview;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class loginWindow extends JFrame{
	//테스트 버전
	private static final long serialVersionUID = 1L;
	JPanel loginMain = new JPanel(new BorderLayout()),loginMainNorth=new JPanel(new FlowLayout(FlowLayout.CENTER)),
			loginMainCenter=new JPanel(new FlowLayout(FlowLayout.CENTER)),loginMCLeft=new JPanel(new GridLayout(2,1))
			,loginMCCenter=new JPanel(new GridLayout (2,1)),loginMCLeftTop=new JPanel(new FlowLayout(FlowLayout.CENTER))
			,loginMCLeftBot=new JPanel(new FlowLayout(FlowLayout.CENTER)),loginMCCenterTop=new JPanel(new FlowLayout(FlowLayout.CENTER))
			,loginMCCenterBot=new JPanel(new FlowLayout(FlowLayout.CENTER)),loginMCRight=new JPanel(new FlowLayout(FlowLayout.CENTER));
	JLabel loginTitle = new JLabel("로그인 테스트"),loginIDLabel = new JLabel("아이디"),loginPassLabel = new JLabel("암호");
	static JTextField loginIDText=new JTextField();
	static JPasswordField loginPassText=new JPasswordField();
	JButton loginButton=new JButton("로그인");
	objFontAndSize objfs=new objFontAndSize();
	Font defaultKor=setFonts.defaultK,titleKor=setFonts.title,button=setFonts.button;
	
	loginWindow() {
		super("로그인 테스트");
		loginMainPanelOption();
		loginMainNorthOption();
		loginMainCenterOption();
		loginMainPanelOption();
		mainOption();
	}
	void loginMainPanelOption(){
		add(loginMain);
		loginMain.add(loginMainNorth, BorderLayout.NORTH);
		loginMain.add(loginMainCenter, BorderLayout.CENTER);
	}
	void loginMainNorthOption(){
		loginMainNorth.add(loginTitle);
		loginTitle.setBorder(BorderFactory.createEmptyBorder(5,0,0,0));
		loginTitle.setFont(titleKor);
	}
	void loginMainCenterOption() {
		loginMainCenter.add(loginMCLeft);
		loginMainCenter.add(loginMCCenter);
		loginMainCenter.add(loginMCRight);
		loginMCLeft.add(loginMCLeftTop);
		loginMCLeft.add(loginMCLeftBot);
		loginMCCenter.add(loginMCCenterTop);
		loginMCCenter.add(loginMCCenterBot);
		loginMainCenterObjectOption();
	}
	void loginMainCenterObjectOption() {
		loginMCLeftTop.add(loginIDLabel);
		loginIDLabel.setFont(defaultKor);
		loginMCLeftBot.add(loginPassLabel);
		loginPassLabel.setFont(defaultKor);
		objfs.addSetSize(loginMCCenterTop, loginIDText, defaultKor, 120, 30);
		objfs.addSetSize(loginMCCenterBot, loginPassText, defaultKor, 120, 30);
		objfs.addSetSize(loginMCRight, loginButton, button, 70, 70);
		loginButton.setMargin(new Insets(20,0,20,0));
		loginButton.addActionListener(new loginAction());
	}
	void mainOption(){
		setSize(320,170);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}

public class loginUI {
	static loginWindow loginW=new loginWindow();
	public static void main(String[] args) {
		
	}
}