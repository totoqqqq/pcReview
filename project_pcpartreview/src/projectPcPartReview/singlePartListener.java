package projectPcPartReview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
class reset{
	reset(){
		for(int i=0;i<singlePartWindow.singlePartListText.length;i++) {
			singlePartWindow.singlePartListCheck[i].setSelected(false);
			singlePartWindow.singlePartListCheck[i].setEnabled(true);
			for(int j=0;j<singlePartWindow.singlePartListText[0].length;j++)
				singlePartWindow.singlePartListText[i][j].setText(null);
		}
		singlePartWindow.singlePartSearchTextSouth.setText(null);
		singlePartWindow.partComboSouth.setEnabled(true);
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
			else if(checkCount==1&&singlePartWindow.singlePartListText[setListLocation][1].getText().length()!=0) {
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
					if(singlePartWindow.singlePartListText[i][1].getText().length()==0) {
						JOptionPane.showMessageDialog(singlePartUI.spw,"검색 하고 삭제할 정보를 선택 한 후에 삭제하기 눌러 주세요.","delete error",JOptionPane.WARNING_MESSAGE,null);
						return;
					}
					setListLocation[i]=true;
					checkCount++;
				}
				else
					setListLocation[i]=false;
			}
			if(checkCount==0) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"삭제 할 정보를 체크 해주세요","delete error",JOptionPane.WARNING_MESSAGE,null);
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
				for(int i=0;i<singlePartWindow.singlePartListCheck.length;i++) {
					if(singlePartWindow.singlePartListCheck[i].isSelected()==true) {
						singlePartWindow.singlePartListCheck[i].setSelected(false);
						singlePartWindow.singlePartSearchTextSouth.setText("");
						singlePartWindow.partComboSouth.setEnabled(true);
					}
				}
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
				for(int i=0;i<singlePartWindow.singlePartListCheck.length;i++) {
					if(singlePartWindow.singlePartListCheck[i].isSelected()==true) {
						singlePartWindow.singlePartListCheck[i].setSelected(false);
						singlePartWindow.singlePartSearchTextSouth.setText("");
						singlePartWindow.partComboSouth.setEnabled(true);
					}
				}
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
		if((JButton)e.getSource()==singlePartWindow.columnTable[0])
			orderBy=sorts("parttype",0);
		else if((JButton)e.getSource()==singlePartWindow.columnTable[1]) 
			orderBy=sorts("partname",1);
		else if((JButton)e.getSource()==singlePartWindow.columnTable[2]) 
			orderBy=sorts("maker",2);
		else if((JButton)e.getSource()==singlePartWindow.columnTable[3]) 
			orderBy=sorts("info1",3);
		else if((JButton)e.getSource()==singlePartWindow.columnTable[4]) 
			orderBy=sorts("info2",4);
		else if((JButton)e.getSource()==singlePartWindow.columnTable[5]) 
			orderBy=sorts("info3",5);
		else if((JButton)e.getSource()==singlePartWindow.columnTable[6]) 
			orderBy=sorts("info4",6);	
		try {
			try {
				if(searchSinglePart.ordertext[1].equals("")&&searchSinglePart.ordertext[1].length()==0) {
					ordersqls="select * from partinfo where parttype='"+searchSinglePart.ordertext[0]+"' order by "+orderBy;
					ps=con.prepareStatement(ordersqls,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				}
				else {
					ordersqls="select * from partinfo where parttype='"+searchSinglePart.ordertext[0]+"' and PARTNAME like '%'||?||'%' order by "+orderBy;
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
class singlePartculmnsAction implements ItemListener{
	@Override
	public void itemStateChanged(ItemEvent e) {
		@SuppressWarnings("rawtypes")
		JComboBox jcb=(JComboBox)e.getSource();
		String index=jcb.getSelectedItem().toString();
		if(index.equals("CPU")) {
			for(int i=0;i<singlePartWindow.columnNameCPU.length;i++)
				singlePartWindow.columnTable[i].setText(singlePartWindow.columnNameCPU[i]);
			singlePartWindow.singlePartSearchTextSouth.setToolTipText(singlePartWindow.columnNameCPU[1]+"/"+singlePartWindow.columnNameCPU[2]+"/"+singlePartWindow.columnNameCPU[3]+"/"
				+singlePartWindow.columnNameCPU[4]+"/"+singlePartWindow.columnNameCPU[5]+"/"+singlePartWindow.columnNameCPU[6]+" 항목을 /으로 구분하여 입력해주세요.");
		}
		else if(index.equals("MB")) {
			for(int i=0;i<singlePartWindow.columnNameMB.length;i++)
				singlePartWindow.columnTable[i].setText(singlePartWindow.columnNameMB[i]);
			singlePartWindow.singlePartSearchTextSouth.setToolTipText(singlePartWindow.columnNameMB[1]+"/"+singlePartWindow.columnNameMB[2]+"/"+singlePartWindow.columnNameMB[3]+"/"
					+singlePartWindow.columnNameMB[4]+"/"+singlePartWindow.columnNameMB[5]+"/"+singlePartWindow.columnNameMB[6]+" 항목을 /으로 구분하여 입력해주세요.");
		}
		else if(index.equals("GPU")) {
			for(int i=0;i<singlePartWindow.columnNameGPU.length;i++)
				singlePartWindow.columnTable[i].setText(singlePartWindow.columnNameGPU[i]);
			singlePartWindow.singlePartSearchTextSouth.setToolTipText(singlePartWindow.columnNameGPU[1]+"/"+singlePartWindow.columnNameGPU[2]+"/"+singlePartWindow.columnNameGPU[3]+"/"
					+singlePartWindow.columnNameGPU[4]+"/"+singlePartWindow.columnNameGPU[5]+"/"+singlePartWindow.columnNameGPU[6]+" 항목을 /으로 구분하여 입력해주세요.");
		}
		else if(index.equals("RAM")) {
			for(int i=0;i<singlePartWindow.columnNameRAM.length;i++)
				singlePartWindow.columnTable[i].setText(singlePartWindow.columnNameRAM[i]);
			singlePartWindow.singlePartSearchTextSouth.setToolTipText(singlePartWindow.columnNameRAM[1]+"/"+singlePartWindow.columnNameRAM[2]+"/"+singlePartWindow.columnNameRAM[3]+"/"
					+singlePartWindow.columnNameRAM[4]+"/"+singlePartWindow.columnNameRAM[5]+"/"+singlePartWindow.columnNameRAM[6]+" 항목을 /으로 구분하여 입력해주세요.");
		}
		else if(index.equals("HDD")) {
			for(int i=0;i<singlePartWindow.columnNameHDD.length;i++)
				singlePartWindow.columnTable[i].setText(singlePartWindow.columnNameHDD[i]);
			singlePartWindow.singlePartSearchTextSouth.setToolTipText(singlePartWindow.columnNameHDD[1]+"/"+singlePartWindow.columnNameHDD[2]+"/"+singlePartWindow.columnNameHDD[3]+"/"
					+singlePartWindow.columnNameHDD[4]+"/"+singlePartWindow.columnNameHDD[5]+"/"+singlePartWindow.columnNameHDD[6]+" 항목을 /으로 구분하여 입력해주세요.");
		}
		else if(index.equals("SSD")) {
			for(int i=0;i<singlePartWindow.columnNameSSD.length;i++)
				singlePartWindow.columnTable[i].setText(singlePartWindow.columnNameSSD[i]);
			singlePartWindow.singlePartSearchTextSouth.setToolTipText(singlePartWindow.columnNameSSD[1]+"/"+singlePartWindow.columnNameSSD[2]+"/"+singlePartWindow.columnNameSSD[3]+"/"
					+singlePartWindow.columnNameSSD[4]+"/"+singlePartWindow.columnNameSSD[5]+"/"+singlePartWindow.columnNameSSD[6]+" 항목을 /으로 구분하여 입력해주세요.");
		}
		singlePartWindow.singlePartSearchTextNorth.setText("");
		new reset();
	}	
}
class singlePartMenuSystem implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		if((JMenuItem)e.getSource()==singlePartWindow.systemLogout) {
			loginWindow.loginIDText.setText("");
			loginWindow.loginPassText.setText("");
			loginWindow.loginIDText.requestFocus();
			loginUI.loginW.setVisible(true);
			loginUI.loginW.setLocationRelativeTo(null);
			singlePartUI.spw.setVisible(false);
			return;
		}
		if((JMenuItem)e.getSource()==singlePartWindow.systemExit)
			System.exit(0);
		return;
	}	
}
class singPartMenuSetting implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		int select=JOptionPane.showConfirmDialog(singlePartUI.spw,"정말로 전체 데이터를 초기화 하시겠습니까?","데이터 베이스 초기화",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,null);
		if(select==0) {
			new defaultData();
			JOptionPane.showMessageDialog(singlePartUI.spw,"데이터 베이스 초기화를 완료했습니다.","데이터 베이스 초기화",JOptionPane.INFORMATION_MESSAGE,null);
		}
		else
			JOptionPane.showMessageDialog(singlePartUI.spw,"데이터 베이스 초기화를 취소했습니다.","데이터 베이스 초기화",JOptionPane.INFORMATION_MESSAGE,null);
		return;
	}
}