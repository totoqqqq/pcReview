package projectPcPartReview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class loginAction implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		String userID=loginWindow.loginIDText.getText(), userPassStr="";
		char[] userPass=loginWindow.loginPassText.getPassword();
		for(char c:userPass) 
			userPassStr+=Character.toString(c);
		new loginUser(userID,userPassStr);
	}
}

class loginEnterAction implements KeyListener{
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 자동 생성된 메소드 스텁
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			String userID=loginWindow.loginIDText.getText(), userPassStr="";
			char[] userPass=loginWindow.loginPassText.getPassword();
			for(char c:userPass) 
				userPassStr+=Character.toString(c);
			new loginUser(userID,userPassStr);
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {

	}
}