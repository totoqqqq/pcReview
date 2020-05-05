package projectPcPartReview;

import javax.swing.JOptionPane;

public class singPartIntegrity {
	singPartIntegrity(String[] strs,int location){
		@SuppressWarnings("unused")
		int check=0;
		String partname=singlePartWindow.singlePartListText[location].getText()
				.substring(singlePartWindow.partComboNorth.getSelectedItem().toString().length()+1, 
						singlePartWindow.singlePartListText[location].getText().toString().indexOf("\t", singlePartWindow.partComboNorth.getSelectedItem().toString().length()+1));
		if(singlePartWindow.partComboSouth.getSelectedItem().equals("CPU")){
			if(strs[0].length()>50) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"CPU의 부품명이 너무 깁니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[0].equals(partname)==false) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"불러온 CPU의 부품명을 바꿀 순 없습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[1].length()>10) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"CPU의 메이커명이 너무 깁니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[2].length()>2) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"CPU의 코어수가 너무 많습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[3].length()>4||Float.parseFloat(strs[3])>10) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"CPU의 GHz가 너무 높습니다.\n(10Ghz 미만 소수점 둘째자리 까지만 입력하세요.)","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[4].length()>10) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"칩셋명이 너무 깁니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[5].length()>3) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"CPU의 TDP가 너무 높습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else {
				try {
					check=Integer.parseInt(strs[2]);
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(singlePartUI.spw,"코어수는 숫자를 입력해야 됩니다.","update error",JOptionPane.WARNING_MESSAGE,null);
					return;
				}
				try {
					@SuppressWarnings("unused")
					float checkf=Float.parseFloat(strs[3]);;
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(singlePartUI.spw,"GHZ는 숫자를 입력해야 됩니다.","update error",JOptionPane.WARNING_MESSAGE,null);
					return;
				}
				try {
					check=Integer.parseInt(strs[5]);
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(singlePartUI.spw,"TDP는 숫자를 입력해야 됩니다.","update error",JOptionPane.WARNING_MESSAGE,null);
					return;
				}
				new updateImportSinglePart(strs);
			}
		}
	}
	singPartIntegrity(String[] strs) {
	@SuppressWarnings("unused")
		int check=0;
			if(singlePartWindow.partComboSouth.getSelectedItem().equals("CPU")){
				if(strs[0].length()>50) {
					JOptionPane.showMessageDialog(singlePartUI.spw,"CPU의 부품명이 너무 깁니다.","insert error",JOptionPane.WARNING_MESSAGE,null);
					return;
				}
				else if(strs[1].length()>10) {
					JOptionPane.showMessageDialog(singlePartUI.spw,"CPU의 메이커명이 너무 깁니다.","insert error",JOptionPane.WARNING_MESSAGE,null);
					return;
				}
				else if(strs[2].length()>2) {
					JOptionPane.showMessageDialog(singlePartUI.spw,"CPU의 코어수가 너무 많습니다.","insert error",JOptionPane.WARNING_MESSAGE,null);
					return;
				}
				else if(strs[3].length()>4||Float.parseFloat(strs[3])>10) {
					JOptionPane.showMessageDialog(singlePartUI.spw,"CPU의 GHz가 너무 높습니다.\n(10Ghz 미만 소수점 둘째자리 까지만 입력하세요.)","insert error",JOptionPane.WARNING_MESSAGE,null);
					return;
				}
				else if(strs[4].length()>10) {
					JOptionPane.showMessageDialog(singlePartUI.spw,"칩셋명이 너무 깁니다.","insert error",JOptionPane.WARNING_MESSAGE,null);
					return;
				}
				else if(strs[5].length()>3) {
					JOptionPane.showMessageDialog(singlePartUI.spw,"CPU의 TDP가 너무 높습니다.","insert error",JOptionPane.WARNING_MESSAGE,null);
					return;
				}
				else {
					try {
						check=Integer.parseInt(strs[2]);
					}
					catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(singlePartUI.spw,"코어수는 숫자를 입력해야 됩니다.","insert error",JOptionPane.WARNING_MESSAGE,null);
						return;
					}
					try {
						@SuppressWarnings("unused")
						float checkf=Float.parseFloat(strs[3]);;
					}
					catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(singlePartUI.spw,"GHZ는 숫자를 입력해야 됩니다.","insert error",JOptionPane.WARNING_MESSAGE,null);
						return;
					}
					try {
						check=Integer.parseInt(strs[5]);
					}
					catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(singlePartUI.spw,"TDP는 숫자를 입력해야 됩니다.","insert error",JOptionPane.WARNING_MESSAGE,null);
						return;
					}
					new inputSinglePart(strs);
				}
			}
		else if(strs.length==4) {		
		}
	}
}