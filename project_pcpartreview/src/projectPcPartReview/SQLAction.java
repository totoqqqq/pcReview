package projectPcPartReview;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.StringUtils;
class loginSQL {
	String tablePartName[]= {"cpu","mb","gpu","ram","ssd","hdd"};
	Connection con=null;
	PreparedStatement ps=null;
	static ResultSet rs=null;
	static int level=0;
	loginSQL(){
		try {
//			String url="jdbc:oracle:thin:@localhost:1521:orcl",user="system",pass="oracle";
//			집에선 orcl / 학원에선 xe
			String url="jdbc:oracle:thin:@localhost:1521:xe",user="system",pass="oracle";
			con=DriverManager.getConnection(url, user, pass);
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(singlePartUI.spw,"Error_SCO_01","Connection error",JOptionPane.WARNING_MESSAGE,null);
			//SQL Connection Oracle error
		}
	}
}
class searchSinglePart extends loginSQL{
	static String[] ordertext=new String[2];
	String ordersql="";
	searchSinglePart(){
		ordertext[0]=singlePartWindow.partComboNorth.getSelectedItem().toString();
		ordertext[1]=singlePartWindow.singlePartSearchTextNorth.getText().toString();
		try {
			if(ordertext[1].equals("")&&ordertext[1].length()==0) {
				ordersql="select * from "+ordertext[0]+" order by PARTNAME";
				ps=con.prepareStatement(ordersql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			}
			else {
				ordersql="select * from "+ordertext[0]+" where PARTNAME like '%'||?||'%' order by PARTNAME";
				ps=con.prepareStatement(ordersql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ps.setString(1, ordertext[1]);
			}
			rs=ps.executeQuery();
			new rsdataSinglePart(rs,ordertext[0]);
		}
		catch(SQLException|NullPointerException e) {
			JOptionPane.showMessageDialog(singlePartUI.spw,"Error_STS_01","search error",JOptionPane.WARNING_MESSAGE,null);
			return;
			//SQL singlePart table search error
		}
	}
}
class rsdataSinglePart{
	static String[][] views=null;
	rsdataSinglePart(ResultSet rs,String str){
		int count=0,setPage=0;
		try {
			if(rs.next()==false) {
				JOptionPane.showMessageDialog(singlePartUI.spw, "검색결과가 없습니다.", "검색 결과 0개", JOptionPane.INFORMATION_MESSAGE, null);
				return;
			}
			else {
				rs.last();
				views=new String[6][(rs.getRow()%6 == 0 ? rs.getRow()/6 : (rs.getRow()/6)+1)];
				singlePartWindow.singlePartViewPage.setText("1/"+(rs.getRow()%6 == 0 ? rs.getRow()/6 : (rs.getRow()/6)+1));
				rs.first();
				for(int i = 0;i<views.length;i++) {
					for(int j=0;j<views[0].length;j++) {
						views[i][j]="";
					}
				}
				do{
					views[count][setPage]=str+"\t"+rs.getString(1)+"\t"+rs.getString(2)+"\t("+rs.getInt(3)+")\t("+
							rs.getFloat(4)+")\t"+rs.getString(5)+"\t("+rs.getInt(6)+")";
					count++;
					if(count==6) {
						count=0;
						setPage++;
					}
				}while(rs.next()==true);
				new viewRsdataSinglePart(views,0);
			}
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(singlePartUI.spw,"Error_STS_02","search error",JOptionPane.WARNING_MESSAGE,null);
			//SQL singlePart table's result compared error
		}
	}
}
class viewRsdataSinglePart extends loginSQL{
	viewRsdataSinglePart(String[][] rsdata, int page){
		for(int i=0;i<rsdata.length;i++)
			singlePartWindow.singlePartListText[i].setText(rsdata[i][page]);
		for(int i=0;i<singlePartWindow.singlePartListCheck.length;i++) {
			String list=singlePartWindow.singlePartListText[i].getText().trim();
			if(list.length()==1)
				singlePartWindow.singlePartListText[i].setText(null);
		}
	}
}
class insertSinglePart extends loginSQL{
	insertSinglePart(){
		String insert=singlePartWindow.singlePartSearchTextSouth.getText();
		String[] inserts=new String[6];
		if(StringUtils.countMatches(insert,"/")!=5) {
			JOptionPane.showMessageDialog(singlePartUI.spw,"규격에 맞게 입력해주세요.","insert error",JOptionPane.WARNING_MESSAGE,null);
			return;
		}
		for(int i=0;i<inserts.length;i++) {
			if(i<inserts.length-1) {
				inserts[i]=insert.substring(0,insert.indexOf("/"));
				insert=insert.substring(insert.indexOf("/")+1,insert.length());
			}
			else
				inserts[i]=insert;
		}
		new singPartIntegrity(inserts);
	}
}
class inputSinglePart extends loginSQL{
	inputSinglePart(String[] input){
		try {
			if(singlePartWindow.partComboSouth.getSelectedItem().equals("CPU")) {	
				ps=con.prepareStatement("insert into "+singlePartWindow.partComboSouth.getSelectedItem()+" values(?,?,?,?,?,?)");
				ps.setString(1, input[0]);
				ps.setString(2, input[1]);
				ps.setInt(3, Integer.parseInt(input[2]));
				ps.setFloat(4, (float)Math.round(Float.parseFloat(input[3])*100)/100);
				ps.setString(5, input[4]);
				ps.setInt(6, Integer.parseInt(input[5]));
			}
			else {
				//CPU 말고 다른 부품 인풋 기능 넣을떄 추가 else if(~
			}
			int check=ps.executeUpdate();
			if(check==1) {
				JOptionPane.showMessageDialog(singlePartUI.spw,singlePartWindow.partComboSouth.getSelectedItem()+" 정보가 추가되었습니다.","정보 추가",JOptionPane.INFORMATION_MESSAGE,null);
				new searchSinglePart();
				singlePartWindow.partComboSouth.setEnabled(true);
			}
			else
				JOptionPane.showMessageDialog(singlePartUI.spw, "Error_STI_02","insert error",JOptionPane.WARNING_MESSAGE,null);
				//SQL singPart table's executeUpdate error
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(singlePartUI.spw,"Error_STI_01","insert error",JOptionPane.WARNING_MESSAGE,null);
			//SQL singlePart table's connection row error
		}
	}	
}
class updateImportSinglePart extends loginSQL{
	updateImportSinglePart(String[] input){
		try {
			if(singlePartWindow.partComboSouth.getSelectedItem().equals("CPU")) {	
				ps=con.prepareStatement("update "+singlePartWindow.partComboSouth.getSelectedItem()+
						" set maker=?,core=?,ghz=?,chipset=?,tdp=? where partname=?");
				ps.setString(6, input[0]);
				ps.setString(1, input[1]);
				ps.setInt(2, Integer.parseInt(input[2]));
				ps.setFloat(3, (float)Math.round(Float.parseFloat(input[3])*100)/100);
				ps.setString(4, input[4]);
				ps.setInt(5, Integer.parseInt(input[5]));
			}
			else {
				//CPU 말고 다른 부품 인풋 기능 넣을떄 추가 else if(~
			}
			int check=ps.executeUpdate();
			new searchSinglePart();
			if(check==1) {
				JOptionPane.showMessageDialog(singlePartUI.spw,singlePartWindow.partComboSouth.getSelectedItem()+" 정보가 갱신되었습니다.","정보 갱신",JOptionPane.INFORMATION_MESSAGE,null);
				singlePartWindow.partComboSouth.setEnabled(true);
			}
			else
				JOptionPane.showMessageDialog(singlePartUI.spw, "Error_STU_02","update error",JOptionPane.WARNING_MESSAGE,null);
				//SQL singPart table's executeUpdate error
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(singlePartUI.spw,"Error_STU_01","update error",JOptionPane.WARNING_MESSAGE,null);
			//SQL singlePart table's update connection error
		}
	}	
}
class importSinglePart{
	importSinglePart(int rsLocation){
		for(int i=0;i<singlePartWindow.singlePartListCheck.length;i++) 
			singlePartWindow.singlePartListCheck[i].setEnabled(false);
		singlePartWindow.partComboSouth.setSelectedItem(singlePartWindow.singlePartListText[rsLocation].getText().toString().substring(0,singlePartWindow.partComboNorth.getSelectedItem().toString().length()));
		singlePartWindow.singlePartSearchTextSouth.setText(singlePartWindow.singlePartListText[rsLocation].getText().toString().replace("\t","/").replace("(","").replace(")","").substring(singlePartWindow.partComboNorth.getSelectedItem().toString().length()+1));
		singlePartWindow.partComboSouth.setEnabled(false);
	}
}
class updateSinglePart{
	updateSinglePart(int rsLocation){
		String insert=singlePartWindow.singlePartSearchTextSouth.getText();
		String[] inserts=new String[6];
		if(StringUtils.countMatches(insert,"/")!=5) {
			JOptionPane.showMessageDialog(singlePartUI.spw,"규격에 맞게 입력해주세요.","update error",JOptionPane.WARNING_MESSAGE,null);
			return;
		}
		for(int i=0;i<inserts.length;i++) {
			if(i<inserts.length-1) {
				inserts[i]=insert.substring(0,insert.indexOf("/"));
				insert=insert.substring(insert.indexOf("/")+1,insert.length());
			}
			else
				inserts[i]=insert;
		}
		new singPartIntegrity(inserts, rsLocation);
	}
}
class deleteSinglePart extends loginSQL{
	deleteSinglePart(Boolean[] setListLocation,int checknum){
		String[] delPartName=new String[checknum];
		int count=0;
		try {
			for(int i=0;i<singlePartWindow.singlePartListCheck.length;i++) {
				if(setListLocation[i]==true) {
					delPartName[count]=singlePartWindow.singlePartListText[i].getText()
							.substring(singlePartWindow.partComboNorth.getSelectedItem().toString().length()+1, 
									singlePartWindow.singlePartListText[i].getText().toString().indexOf("\t", singlePartWindow.partComboNorth.getSelectedItem().toString().length()+1));
					count++;
				}
			}
		}
		catch(StringIndexOutOfBoundsException f){
			JOptionPane.showMessageDialog(singlePartUI.spw,"삭제 할 빈칸이 아닌 곳의 데이터를 선택해주세요.","delete error",JOptionPane.WARNING_MESSAGE,null);
			return;
		}
		try {
			for(int i=0;i<delPartName.length;i++) {
				ps=con.prepareStatement("delete "+singlePartWindow.partComboSouth.getSelectedItem()+" where partname=?");
				ps.setString(1, delPartName[i]);
				ps.executeQuery();
			}
			JOptionPane.showMessageDialog(singlePartUI.spw,singlePartWindow.partComboSouth.getSelectedItem()+" 정보가 "+count+"건 삭제되었습니다.","정보 갱신",JOptionPane.INFORMATION_MESSAGE,null);
			new reset();
			new searchSinglePart();
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(singlePartUI.spw,"Error_STD_01","delete error",JOptionPane.WARNING_MESSAGE,null);
			//SQL singlePart table's delete row error
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
				loginUI.loginW.dispose();
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
public class SQLAction{
	public static void main(String[] args) {
	}
}