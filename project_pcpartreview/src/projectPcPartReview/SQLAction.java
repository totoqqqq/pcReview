package projectPcPartReview;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
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
				ordersql="select * from partinfo where parttype='"+ordertext[0]+"' order by PARTNAME";
				ps=con.prepareStatement(ordersql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			}
			else {
				ordersql="select * from partinfo where parttype='"+ordertext[0]+"' and PARTNAME like '%'||?||'%' order by PARTNAME";
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
	searchSinglePart(String partName){
		ordertext[0]=partName;
		ordertext[1]=singlePartWindow.singlePartSearchTextNorth.getText().toString();
		try {
			if(ordertext[1].equals("")&&ordertext[1].length()==0) {
				ordersql="select * from partinfo where parttype='"+ordertext[0]+"' order by PARTNAME";
				ps=con.prepareStatement(ordersql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			}
			else {
				ordersql="select * from partinfo where parttype='"+ordertext[0]+"' and PARTNAME like '%'||?||'%' order by PARTNAME";
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
	static String[][][] views=null;
	rsdataSinglePart(ResultSet rs,String str){
		int count=0,setPage=0;
		try {
			if(rs.next()==false) {
				JOptionPane.showMessageDialog(singlePartUI.spw, "검색결과가 없습니다.", "검색 결과 0개", JOptionPane.INFORMATION_MESSAGE, null);
				return;
			}
			else {
				rs.last();
				views=new String[6][7][(rs.getRow()%6 == 0 ? rs.getRow()/6 : (rs.getRow()/6)+1)];
				singlePartWindow.singlePartViewPage.setText("1/"+(rs.getRow()%6 == 0 ? rs.getRow()/6 : (rs.getRow()/6)+1));
				rs.first();
				for(int i = 0;i<views.length;i++) {
					for(int j=0;j<views[0].length;j++) {
						for(int k=0;k<views[0][0].length;k++)
						views[i][j][k]="";
					}
				}
				do{
					views[count][0][setPage]=rs.getString(1);
					views[count][1][setPage]=rs.getString(2);
					views[count][2][setPage]=rs.getString(3);
					views[count][3][setPage]=rs.getString(4);
					views[count][4][setPage]=rs.getString(5);
					views[count][5][setPage]=rs.getString(6);
					views[count][6][setPage]=rs.getString(7);
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
	viewRsdataSinglePart(String[][][] rsdata, int page){
		for(int i=0;i<rsdata.length;i++) {
			for(int j=0;j<rsdata[0].length;j++)
			singlePartWindow.singlePartListText[i][j].setText(rsdata[i][j][page]);
		}
		for(int i=0;i<singlePartWindow.singlePartListCheck.length;i++) {
			for(int j=0;j<rsdata[0].length;j++) {
			String list=singlePartWindow.singlePartListText[i][j].getText();
			if(list.length()==0)
				singlePartWindow.singlePartListText[i][j].setText("");
			}
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
	inputSinglePart(String[] strs){
		try {
			ps=con.prepareStatement("insert into partinfo values(?,?,?,?,?,?,?)");
			ps.setString(1, singlePartWindow.partComboSouth.getSelectedItem().toString());
			ps.setString(2, strs[0]);
			ps.setString(3, strs[1]);
			ps.setString(4, strs[2]);
			ps.setString(5, strs[3]);
			ps.setString(6, strs[4]);
			ps.setString(7, strs[5]);
			int check=ps.executeUpdate();
			if(check==1) {
				JOptionPane.showMessageDialog(singlePartUI.spw,singlePartWindow.partComboSouth.getSelectedItem()+" 정보가 추가되었습니다.","정보 추가",JOptionPane.INFORMATION_MESSAGE,null);
				singlePartWindow.partComboSouth.setEnabled(true);
				singlePartWindow.partComboNorth.setSelectedItem(singlePartWindow.partComboSouth.getSelectedItem());
			}
			else
				JOptionPane.showMessageDialog(singlePartUI.spw, "Error_STI_02","insert error",JOptionPane.WARNING_MESSAGE,null);
				//SQL singPart table's executeUpdate error
			new searchSinglePart(singlePartWindow.partComboSouth.getSelectedItem().toString());
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(singlePartUI.spw,"Error_STI_01","insert error",JOptionPane.WARNING_MESSAGE,null);
			//SQL singlePart table's connection row error
		}
	}	
}
class updateImportSinglePart extends loginSQL{
	updateImportSinglePart(String[] strs, int Location){
		try {
			ps=con.prepareStatement("update partinfo set maker=?,info1=?,info2=?,info3=?,info4=? where parttype='"+singlePartWindow.partComboSouth.getSelectedItem().toString()+"' and partname=?");
			ps.setString(6, strs[0]);
			ps.setString(1, strs[1]);
			ps.setString(2, strs[2]);
			ps.setString(3, strs[3]);
			ps.setString(4, strs[4]);
			ps.setString(5, strs[5]);
			int check=ps.executeUpdate();
			if(check==1) {
				JOptionPane.showMessageDialog(singlePartUI.spw,singlePartWindow.partComboSouth.getSelectedItem()+" 정보가 갱신되었습니다.","정보 갱신",JOptionPane.INFORMATION_MESSAGE,null);
				singlePartWindow.partComboSouth.setEnabled(true);
				for(int i=0;i<singlePartWindow.singlePartListCheck.length;i++) {
					singlePartWindow.singlePartListCheck[i].setSelected(false);
					singlePartWindow.singlePartListCheck[i].setEnabled(true);
				}
				singlePartWindow.partComboNorth.setSelectedItem(singlePartWindow.partComboSouth.getSelectedItem());
			}
			else
				JOptionPane.showMessageDialog(singlePartUI.spw, "Error_STU_02","update error",JOptionPane.WARNING_MESSAGE,null);
				//SQL singPart table's executeUpdate error
			new searchSinglePart(singlePartWindow.partComboSouth.getSelectedItem().toString());
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(singlePartUI.spw,"Error_STU_01","update error",JOptionPane.WARNING_MESSAGE,null);
			//SQL singlePart table's update connection error
		}
	}	
}
class importSinglePart{
	importSinglePart(int rsLocation){
		String southText="";
		for(int i=0;i<singlePartWindow.singlePartListCheck.length;i++) 
			singlePartWindow.singlePartListCheck[i].setEnabled(false);
		singlePartWindow.partComboSouth.setSelectedItem(singlePartWindow.singlePartListText[rsLocation][0].getText().toString().substring(0,singlePartWindow.partComboNorth.getSelectedItem().toString().length()));
		for(int i=1;i<singlePartWindow.singlePartListText[0].length;i++) {
			southText+=singlePartWindow.singlePartListText[rsLocation][i].getText();
			if(i<singlePartWindow.singlePartListText[0].length-1)
				southText+="/";
		}
		singlePartWindow.singlePartSearchTextSouth.setText(southText);
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
					delPartName[count]=singlePartWindow.singlePartListText[i][1].getText();
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
				ps=con.prepareStatement("delete partinfo where parttype='"+singlePartWindow.partComboNorth.getSelectedItem()+"' and partname=?");
				ps.setString(1, delPartName[i]);
				ps.executeQuery();
			}
			JOptionPane.showMessageDialog(singlePartUI.spw,singlePartWindow.partComboNorth.getSelectedItem()+" 정보가 "+count+"건 삭제되었습니다.","정보 갱신",JOptionPane.INFORMATION_MESSAGE,null);
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
class partNameImport extends loginSQL{
	partNameImport(int index){
		try {
			String[] partList={"CPU","MB","GPU","RAM","SSD","HDD"};
			ps=con.prepareStatement("select partname from partinfo where parttype='"+partList[index]+"' order by partname",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=ps.executeQuery();
			rs.last();
			int count=rs.getRow();
			String[] strs=new String[count];
			rs.first();
			for(int i=0;i<strs.length;i++) {
				strs[i]=rs.getString(1);
				rs.next();
			}
			pcEstimateWindow.partList[index]=new JComboBox<String>(strs);			
		} 
		catch (SQLException e) {
			JOptionPane.showMessageDialog(pcEstimateUI.pew,"Error_STS_05","login error",JOptionPane.WARNING_MESSAGE,null);
			return;
			//SQL partinfo table search error
		}		
	}
}
public class SQLAction{
	public static void main(String[] args) {
		
	}
}