package projectPcPartReview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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