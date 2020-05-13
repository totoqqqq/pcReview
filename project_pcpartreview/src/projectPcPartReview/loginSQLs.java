package projectPcPartReview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
class loginSQL {
	Connection con=null;
	PreparedStatement ps=null;
	static ResultSet rs=null;
	static int level=0;
	static String userName="";
	loginSQL(){
		try {
//			String url="jdbc:oracle:thin:@localhost:1521:orcl",user="system",pass="oracle";
//			집에선 orcl / 학원에선 xe
			String url="jdbc:oracle:thin:@localhost:1521:xe",user="system",pass="oracle";
			con=DriverManager.getConnection(url, user, pass);
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(loginUI.loginW,"Error_SCO_01","Connection error",JOptionPane.WARNING_MESSAGE,null);
			//SQL Connection Oracle error
		}
	}
}
class loginUser extends loginSQL{
	loginUser(String userID,String userPass){
		try {
			ps=con.prepareStatement("select * from member where id=? and pass=?",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ps.setString(1, userID);
			ps.setString(2, userPass);
			rs=ps.executeQuery();
			if(rs.next()==false) {
				JOptionPane.showMessageDialog(loginUI.loginW,"입력한 아이디와 암호가 맞는지 확인해 주세요.","login error",JOptionPane.INFORMATION_MESSAGE,null);
				return;
			}
			else {
				rs.first();
				level=rs.getInt(3);
				userName=rs.getString(1);
				loginUI.loginW.setVisible(false);
				new singlePartUI(level);
			}
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(loginUI.loginW,"Error_MTS_01","login error",JOptionPane.WARNING_MESSAGE,null);
			return;
			//SQL member table search error
		}
	}
}