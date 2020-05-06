package projectPcPartReview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
class reset{
	reset(){
		for(int i=0;i<singlePartWindow.singlePartListText.length;i++) {
			singlePartWindow.singlePartListText[i].setText(null);
			singlePartWindow.singlePartListCheck[i].setSelected(false);
			singlePartWindow.singlePartListCheck[i].setEnabled(true);
			singlePartWindow.singlePartSearchTextSouth.setText(null);
			singlePartWindow.partComboSouth.setEnabled(true);
		}
	}
}
class spSearch implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		new reset();
		new searchSinglePart();
	}
}
class spIUD implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==singlePartWindow.singlePartSave) {
			for(int i=0;i<singlePartWindow.singlePartListCheck.length;i++) {
				if(singlePartWindow.singlePartListCheck[i].isSelected()==true) {
					new updateSinglePart(i);
					return;
				}
			}
			new insertSinglePart();
		}
		else if(e.getSource()==singlePartWindow.singlePartLoad) {
			int checkCount=0,setListLocation=0;
			for(int i=0;i<singlePartWindow.singlePartListCheck.length;i++) {
				if(singlePartWindow.singlePartListCheck[i].isSelected()==true) { 
					checkCount++;
					setListLocation=i;
				}
			}
			if(checkCount>1) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"두개 이상의 정보를 동시에 불러 올 수 없습니다.","load error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(checkCount==0) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"불러 올 정보를 체크 해주세요","load error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(checkCount==1&&singlePartWindow.singlePartListText[setListLocation].getText().length()!=0) {
				new importSinglePart(setListLocation);
			}
			else {
				JOptionPane.showMessageDialog(singlePartUI.spw,"검색 하고 불러 올 정보를 선택 한 후에 불러오기 눌러 주세요.","load error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
		}
		else if(e.getSource()==singlePartWindow.singlePartDelete) {
			int checkCount=0;
			Boolean[] setListLocation=new Boolean[singlePartWindow.singlePartListCheck.length];
			for(int i=0;i<setListLocation.length;i++) {
				if(singlePartWindow.singlePartListCheck[i].isSelected()==true) {
					setListLocation[i]=true;
					checkCount++;
				}
				else
					setListLocation[i]=false;
			}
			if(checkCount==0) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"삭제 할 정보를 체크 해주세요","load error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}	
			new deleteSinglePart(setListLocation,checkCount);
		}
	}
}
class viewMovePage implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		String Page=singlePartWindow.singlePartViewPage.getText().toString(),nowPage=null,allPage=null;
		int pageSeparator=Page.indexOf("/");
		nowPage=Page.substring(0, pageSeparator);
		allPage=Page.substring(pageSeparator+1, Page.length());
		if((JButton)e.getSource()==singlePartWindow.singlePartViewRight){
			if(Integer.parseInt(nowPage)<Integer.parseInt(allPage)) {
				nowPage=String.valueOf((Integer.parseInt(nowPage)+1));
				singlePartWindow.singlePartViewPage.setText(nowPage+"/"+allPage);
				new viewRsdataSinglePart(rsdataSinglePart.views,Integer.parseInt(nowPage)-1);
			}
			else {
				JOptionPane.showMessageDialog(singlePartUI.spw,"검색값의 마지막 페이지 입니다.","search error",JOptionPane.INFORMATION_MESSAGE,null);
			}
		}
		if((JButton)e.getSource()==singlePartWindow.singlePartViewLeft){
			if(Integer.parseInt(nowPage)>1) {
				nowPage=String.valueOf((Integer.parseInt(nowPage)-1));
				singlePartWindow.singlePartViewPage.setText(nowPage+"/"+allPage);
				new viewRsdataSinglePart(rsdataSinglePart.views,Integer.parseInt(nowPage)-1);
			}
			else {
				JOptionPane.showMessageDialog(singlePartUI.spw,"검색값의 처음 페이지 입니다.","search error",JOptionPane.INFORMATION_MESSAGE,null);
			}
		}
	}
}
class viewSort extends loginSQL implements ActionListener {
	String sorts(String order, int sortNumber){
		String orders="";
		if(singlePartWindow.columnNameCPUSort[sortNumber]==false) {
			orders=order+" desc";
			for(int i=0;i<singlePartWindow.columnNameCPUSort.length;i++)
				singlePartWindow.columnNameCPUSort[i]=false;
			singlePartWindow.columnNameCPUSort[sortNumber]=true;
		}
		else {
			orders=order+" asc";
			for(int i=0;i<singlePartWindow.columnNameCPUSort.length;i++)
				singlePartWindow.columnNameCPUSort[i]=false;
		}	
		return orders;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String orderBy="",ordersqls="";
		if((JButton)e.getSource()==singlePartWindow.columnCPU[0])
			orderBy=sorts("partname",0);
		else if((JButton)e.getSource()==singlePartWindow.columnCPU[1]) 
			orderBy=sorts("partname",1);
		else if((JButton)e.getSource()==singlePartWindow.columnCPU[2]) 
			orderBy=sorts("maker",2);
		else if((JButton)e.getSource()==singlePartWindow.columnCPU[3]) 
			orderBy=sorts("core",3);
		else if((JButton)e.getSource()==singlePartWindow.columnCPU[4]) 
			orderBy=sorts("ghz",4);
		else if((JButton)e.getSource()==singlePartWindow.columnCPU[5]) 
			orderBy=sorts("chipset",5);
		else if((JButton)e.getSource()==singlePartWindow.columnCPU[6]) 
			orderBy=sorts("tdp",6);	
		try {
			try {
				if(searchSinglePart.ordertext[1].equals("")&&searchSinglePart.ordertext[1].length()==0) {
					ordersqls="select * from "+searchSinglePart.ordertext[0]+" order by "+orderBy;
					ps=con.prepareStatement(ordersqls,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				}
				else {
					ordersqls="select * from "+searchSinglePart.ordertext[0]+" where PARTNAME like '%'||?||'%' order by "+orderBy;
					ps=con.prepareStatement(ordersqls,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
					ps.setString(1, searchSinglePart.ordertext[1]);
				}
			}
			catch(NullPointerException g){
				return;
			}
			rs=ps.executeQuery();
			new rsdataSinglePart(rs,searchSinglePart.ordertext[0]);
		}
		catch(SQLException f){
			if(rs==null)
				return;
			JOptionPane.showMessageDialog(singlePartUI.spw,"Error_STS_03","search error",JOptionPane.WARNING_MESSAGE,null);
			//SQL singlePart table search error Sort
		}
	}
}