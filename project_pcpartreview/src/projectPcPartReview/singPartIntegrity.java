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
				JOptionPane.showMessageDialog(singlePartUI.spw,"CPU�� ��ǰ���� �ʹ� ��ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[0].equals(partname)==false) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"�ҷ��� CPU�� ��ǰ���� �ٲ� �� �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[1].length()>10) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"CPU�� ����Ŀ���� �ʹ� ��ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[2].length()>2) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"CPU�� �ھ���� �ʹ� �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[3].length()>4||Float.parseFloat(strs[3])>10) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"CPU�� GHz�� �ʹ� �����ϴ�.\n(10Ghz �̸� �Ҽ��� ��°�ڸ� ������ �Է��ϼ���.)","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[4].length()>10) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"Ĩ�¸��� �ʹ� ��ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[5].length()>3) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"CPU�� TDP�� �ʹ� �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else {
				try {
					check=Integer.parseInt(strs[2]);
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(singlePartUI.spw,"�ھ���� ���ڸ� �Է��ؾ� �˴ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
					return;
				}
				try {
					@SuppressWarnings("unused")
					float checkf=Float.parseFloat(strs[3]);;
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(singlePartUI.spw,"GHZ�� ���ڸ� �Է��ؾ� �˴ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
					return;
				}
				try {
					check=Integer.parseInt(strs[5]);
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(singlePartUI.spw,"TDP�� ���ڸ� �Է��ؾ� �˴ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
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
					JOptionPane.showMessageDialog(singlePartUI.spw,"CPU�� ��ǰ���� �ʹ� ��ϴ�.","insert error",JOptionPane.WARNING_MESSAGE,null);
					return;
				}
				else if(strs[1].length()>10) {
					JOptionPane.showMessageDialog(singlePartUI.spw,"CPU�� ����Ŀ���� �ʹ� ��ϴ�.","insert error",JOptionPane.WARNING_MESSAGE,null);
					return;
				}
				else if(strs[2].length()>2) {
					JOptionPane.showMessageDialog(singlePartUI.spw,"CPU�� �ھ���� �ʹ� �����ϴ�.","insert error",JOptionPane.WARNING_MESSAGE,null);
					return;
				}
				else if(strs[3].length()>4||Float.parseFloat(strs[3])>10) {
					JOptionPane.showMessageDialog(singlePartUI.spw,"CPU�� GHz�� �ʹ� �����ϴ�.\n(10Ghz �̸� �Ҽ��� ��°�ڸ� ������ �Է��ϼ���.)","insert error",JOptionPane.WARNING_MESSAGE,null);
					return;
				}
				else if(strs[4].length()>10) {
					JOptionPane.showMessageDialog(singlePartUI.spw,"Ĩ�¸��� �ʹ� ��ϴ�.","insert error",JOptionPane.WARNING_MESSAGE,null);
					return;
				}
				else if(strs[5].length()>3) {
					JOptionPane.showMessageDialog(singlePartUI.spw,"CPU�� TDP�� �ʹ� �����ϴ�.","insert error",JOptionPane.WARNING_MESSAGE,null);
					return;
				}
				else {
					try {
						check=Integer.parseInt(strs[2]);
					}
					catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(singlePartUI.spw,"�ھ���� ���ڸ� �Է��ؾ� �˴ϴ�.","insert error",JOptionPane.WARNING_MESSAGE,null);
						return;
					}
					try {
						@SuppressWarnings("unused")
						float checkf=Float.parseFloat(strs[3]);;
					}
					catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(singlePartUI.spw,"GHZ�� ���ڸ� �Է��ؾ� �˴ϴ�.","insert error",JOptionPane.WARNING_MESSAGE,null);
						return;
					}
					try {
						check=Integer.parseInt(strs[5]);
					}
					catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(singlePartUI.spw,"TDP�� ���ڸ� �Է��ؾ� �˴ϴ�.","insert error",JOptionPane.WARNING_MESSAGE,null);
						return;
					}
					new inputSinglePart(strs);
				}
			}
		else if(strs.length==4) {		
		}
	}
}