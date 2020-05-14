package projectPcPartReview;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

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
			JOptionPane.showMessageDialog(pcEstimateUI.pew,"Error_STS_05","search error",JOptionPane.WARNING_MESSAGE,null);
			return;
			//SQL partinfo table search error
		}		
	}
}
class pcEsimateDialogReview extends loginSQL{
	pcEsimateDialogReview(String id){
		try {
			ps=con.prepareStatement("select inputdates,updatedates,name from pcestimate where id='"+id+"' order by updatedates",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=ps.executeQuery();
			if(rs.next()==false) {
				return;
			}
			rs.last();
			int count=rs.getRow();
			rs.first();
			String[] viewName=new String[count];
			for(int i=0;i<count;i++) {
				viewName[i]="저장 일 : "+rs.getString(1)+"  수정 일 : "+rs.getString(2)+"  저장 명 : "+rs.getString(3);
				rs.next();
			}
			pcEstimateWindow.reviewsave=new JComboBox<String>(viewName);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
class pcEstimateInput extends loginSQL{
	pcEstimateInput(String name){
		try {
			ps=con.prepareStatement("insert into pcestimate values(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,userName);
			ps.setString(2,name);
			ps.setString(3, new SimpleDateFormat("yyyy.MM.dd hh:mm:ss").format(System.currentTimeMillis()).toString());
			ps.setString(4, new SimpleDateFormat("yyyy.MM.dd hh:mm:ss").format(System.currentTimeMillis()).toString());
			for(int i=0;i<pcEstimateWindow.partList.length;i++) {
				ps.setString(i+5, pcEstimateWindow.partList[i].getSelectedItem().toString());
			}
			int check=ps.executeUpdate();
			if(check==1)
				JOptionPane.showMessageDialog(pcEstimateUI.pew,"견적이 저장되었습니다.","견적 저장",JOptionPane.INFORMATION_MESSAGE,null);
			else
				JOptionPane.showMessageDialog(pcEstimateUI.pew,"Error_STI_05","insert error",JOptionPane.WARNING_MESSAGE,null);
				//SQL pcEstimate table error
		} 
		catch (SQLException e) {
			JOptionPane.showMessageDialog(pcEstimateUI.pew,"저장할 이름을 적어주세요.","견적 저장",JOptionPane.WARNING_MESSAGE,null);
		}
	}
}
class pcEstimateUpdate extends loginSQL{
	pcEstimateUpdate(String name){
		try {
			if(name.equals(""))
				name=rs.getString(3);
			ps=con.prepareStatement("update pcestimate set name=?,updatedate=?,cpu=?,mb=?,gpu=?,ram=?.ssd=?,hdd=? where id='"+userName+"' and inputdates='"+rs.getString(1)+"'");
			ps.setString(1,name);
			ps.setString(2,new SimpleDateFormat("yyyy.MM.dd hh:mm:ss").format(System.currentTimeMillis()).toString());
			for(int i=0;i<pcEstimateWindow.partList.length;i++) {
				ps.setString(i+3, pcEstimateWindow.partList[i].getSelectedItem().toString());
			}
			int check=ps.executeUpdate();
			if(check==1)
				JOptionPane.showMessageDialog(pcEstimateUI.pew,"견적이 갱신되었습니다.","견적 갱신",JOptionPane.INFORMATION_MESSAGE,null);
			else
				JOptionPane.showMessageDialog(pcEstimateUI.pew,"Error_STU_05","insert error",JOptionPane.WARNING_MESSAGE,null);
				//SQL pcEstimate table error
		} 
		catch (SQLException e) {
			
		}
	}
}
class pcEstimateImport extends loginSQL{
	pcEstimateImport(String inputDates){
		try {
			ps=con.prepareStatement("select * from pcestimate where id='"+userName+"' and inputdates='"+inputDates+"'",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=ps.executeQuery();
			rs.first();
			for(int i=0;i<pcEstimateWindow.partList.length;i++) {
				pcEstimateWindow.partList[i].setSelectedItem(rs.getString(i+5));
				pcEstimateWindow.savemode=false;
			}
		} 
		catch (SQLException e) {
	
			e.printStackTrace();
		}	
	}
}