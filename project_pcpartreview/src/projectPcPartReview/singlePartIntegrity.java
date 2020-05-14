package projectPcPartReview;

import javax.swing.JOptionPane;

public class singlePartIntegrity {
	singlePartIntegrity(String[] strs,int location){
		int check=0;
		String[] partname=new String[6];
		for(int i=0;i<partname.length;i++) {
			partname[i]=singlePartWindow.singlePartListText[location][i+1].getText();
		}
		if(singlePartWindow.partComboSouth.getSelectedItem().equals("CPU")){
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
			if(strs[0].length()>60) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"CPU�� ��ǰ���� �ʹ� ��ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[0].equals(partname[0])==false) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"�ҷ��� CPU�� ��ǰ���� �ٲ� �� �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[1].length()>20) {
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
			else if(strs[4].length()>16) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"Ĩ�¸��� �ʹ� ��ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[5].length()>3) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"CPU�� TDP�� �ʹ� �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else {
				if(check>=0)
					new updateImportSinglePart(strs,location);
				else
					JOptionPane.showMessageDialog(singlePartUI.spw,"��ġ�� -��ġ�� ������ �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
			}
		}
		else if(singlePartWindow.partComboSouth.getSelectedItem().equals("MB")) {
			try {
				check=Integer.parseInt(strs[2]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"RAM������ ���ڸ� �Է��ؾ� �˴ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			if(strs[0].length()>60) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"���κ����� ��ǰ���� �ʹ� ��ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[0].equals(partname[0])==false) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"�ҷ��� ���κ����� ��ǰ���� �ٲ� �� �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[1].length()>20) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"���κ����� ����Ŀ���� �ʹ� ��ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[2].length()>2) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"���κ����� RAM���� ������ �ʹ� �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[3].length()>16) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"���κ����� �԰��� ���̰� �ʹ���ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[4].length()>16) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"Ĩ�¸��� �ʹ� ��ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[5].length()>5) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"���κ����� M-���� ���ζ� �ٸ��ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else {
				if(check>=0)
					new updateImportSinglePart(strs,location);
				else
					JOptionPane.showMessageDialog(singlePartUI.spw,"��ġ�� -��ġ�� ������ �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
			}
		}
		else if(singlePartWindow.partComboSouth.getSelectedItem().equals("GPU")) {
			try {
				check=Integer.parseInt(strs[2]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"VRAM�� ���ڸ� �Է��ؾ� �˴ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			try {
				check=Integer.parseInt(strs[3]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"Mhz�� ���ڸ� �Է��ؾ� �˴ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			try {
				check=Integer.parseInt(strs[4]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"���Ǽ��� ���ڸ� �Է��ؾ� �˴ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			if(strs[0].length()>60) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"GPU�� ��ǰ���� �ʹ� ��ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[0].equals(partname[0])==false) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"�ҷ��� GPU�� ��ǰ���� �ٲ� �� �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[1].length()>20) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"GPU�� ����Ŀ���� �ʹ� ��ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[2].length()>3||Float.parseFloat(strs[2])>100) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"GPU�� VRAM�� �ʹ� �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[3].length()>6||Float.parseFloat(strs[3])>100000) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"GPU�� Mhz�� �ʹ� �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[4].length()>2||Float.parseFloat(strs[4])>10) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"GPU�� ���� �ʹ� �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[5].length()>3) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"GPU�� TDP�� �ʹ� �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else {
				if(check>=0)
					new updateImportSinglePart(strs,location);
				else
					JOptionPane.showMessageDialog(singlePartUI.spw,"��ġ�� -��ġ�� ������ �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
			}
		}
		else if(singlePartWindow.partComboSouth.getSelectedItem().equals("RAM")) {
			try {
				check=Integer.parseInt(strs[3]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"GB�뷮�� ���ڸ� �Է��ؾ� �˴ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			try {
				check=Integer.parseInt(strs[4]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"HMZ�� ���ڸ� �Է��ؾ� �˴ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			if(strs[0].length()>60) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"RAM�� ��ǰ���� �ʹ� ��ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[0].equals(partname[0])==false) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"�ҷ��� RAM�� ��ǰ���� �ٲ� �� �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[1].length()>20) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"RAM�� ����Ŀ���� �ʹ� ��ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[2].length()>16) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"RAM�� �뷮 �԰��� �ʹ� ��ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[3].length()>4||Float.parseFloat(strs[3])>100) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"RAM�� GB�뷮�� �ʹ� �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[4].length()>5||Float.parseFloat(strs[4])>10000) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"RAM�� HMZ�� �ʹ� �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[5].length()>16) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"RAM�� ATX �����͸� �Է��ϼ���","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else {
				if(check>=0)
					new updateImportSinglePart(strs,location);
				else
					JOptionPane.showMessageDialog(singlePartUI.spw,"��ġ�� -��ġ�� ������ �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
			}
		}
		else if(singlePartWindow.partComboSouth.getSelectedItem().equals("SSD")) {
			try {
				check=Integer.parseInt(strs[4]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"ǥ��뷮�� ���ڸ� �Է��ؾ� �˴ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			try {
				check=Integer.parseInt(strs[5]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"�����뷮�� ���ڸ� �Է��ؾ� �˴ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			if(strs[0].length()>60) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"SSD�� ��ǰ���� �ʹ� ��ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[0].equals(partname[0])==false) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"�ҷ��� SSD�� ��ǰ���� �ٲ� �� �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[1].length()>20) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"SSD�� ����Ŀ���� �ʹ� ��ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[2].length()>16) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"SSD�� xLC�԰��� �ٸ��ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[3].length()>16) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"SSD�� �����԰��� �ٸ��ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[4].length()>5||Float.parseFloat(strs[4])>50000) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"SSD�� ǥ��뷮�� �ʹ� Ů�ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[5].length()>5||Float.parseFloat(strs[5])>50000) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"SSD�� �����뷮�� �ʹ� Ů�ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else {
				if(check>=0)
					new updateImportSinglePart(strs,location);
				else
					JOptionPane.showMessageDialog(singlePartUI.spw,"��ġ�� -��ġ�� ������ �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
			}
		}
		else if(singlePartWindow.partComboSouth.getSelectedItem().equals("HDD")) {
			try {
				check=Integer.parseInt(strs[4]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"ǥ��뷮�� ���ڸ� �Է��ؾ� �˴ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			try {
				check=Integer.parseInt(strs[5]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"�����뷮�� ���ڸ� �Է��ؾ� �˴ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			if(strs[0].length()>60) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"HDD�� ��ǰ���� �ʹ� ��ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[0].equals(partname[0])==false) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"�ҷ��� HDD�� ��ǰ���� �ٲ� �� �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[1].length()>20) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"HDD�� ����Ŀ���� �ʹ� ��ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[2].length()>5||Float.parseFloat(strs[2])>50000) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"HDD�� RPM�� �ʹ� �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[3].length()>3||Float.parseFloat(strs[3])>500) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"HDD�� ĳ�ð� �ʹ� �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[4].length()>5||Float.parseFloat(strs[4])>50000) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"HDD�� ǥ��뷮�� �ʹ� Ů�ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[5].length()>5||Float.parseFloat(strs[5])>50000) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"HDD�� �����뷮�� �ʹ� Ů�ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else {
				if(check>=0)
					new updateImportSinglePart(strs,location);
				else
					JOptionPane.showMessageDialog(singlePartUI.spw,"��ġ�� -��ġ�� ������ �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
			}
		}
	}
	singlePartIntegrity(String[] strs) {
		int check=0;
		if(singlePartWindow.partComboSouth.getSelectedItem().equals("CPU")){
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
			if(strs[0].length()>60) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"CPU�� ��ǰ���� �ʹ� ��ϴ�.","insert error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[1].length()>20) {
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
			else if(strs[4].length()>16) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"Ĩ�¸��� �ʹ� ��ϴ�.","insert error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[5].length()>3) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"CPU�� TDP�� �ʹ� �����ϴ�.","insert error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else {
				if(check>=0)
					new inputSinglePart(strs);
				else
					JOptionPane.showMessageDialog(singlePartUI.spw,"��ġ�� -��ġ�� ������ �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
			}
		}
		else if(singlePartWindow.partComboSouth.getSelectedItem().equals("MB")) {
			try {
				check=Integer.parseInt(strs[2]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"RAM������ ���ڸ� �Է��ؾ� �˴ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			if(strs[0].length()>60) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"���κ����� ��ǰ���� �ʹ� ��ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[1].length()>20) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"���κ����� ����Ŀ���� �ʹ� ��ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[2].length()>2) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"���κ����� RAM���� ������ �ʹ� �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[3].length()>16) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"���κ����� �԰��� ���̰� �ʹ���ϴ�.\n(10Ghz �̸� �Ҽ��� ��°�ڸ� ������ �Է��ϼ���.)","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[4].length()>16) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"Ĩ�¸��� �ʹ� ��ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[5].length()>5) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"���κ����� M-���� ���ζ� �ٸ��ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else {
				if(check>=0)
					new inputSinglePart(strs);
				else
					JOptionPane.showMessageDialog(singlePartUI.spw,"��ġ�� -��ġ�� ������ �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
			}		
		}
		else if(singlePartWindow.partComboSouth.getSelectedItem().equals("GPU")) {
			try {
				check=Integer.parseInt(strs[2]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"VRAM�� ���ڸ� �Է��ؾ� �˴ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			try {
				check=Integer.parseInt(strs[3]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"Mhz�� ���ڸ� �Է��ؾ� �˴ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			try {
				check=Integer.parseInt(strs[4]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"���Ǽ��� ���ڸ� �Է��ؾ� �˴ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			if(strs[0].length()>60) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"GPU�� ��ǰ���� �ʹ� ��ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[1].length()>20) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"GPU�� ����Ŀ���� �ʹ� ��ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[2].length()>3||Float.parseFloat(strs[2])>100) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"GPU�� VRAM�� �ʹ� �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[3].length()>6||Float.parseFloat(strs[3])>100000) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"GPU�� Mhz�� �ʹ� �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[4].length()>2||Float.parseFloat(strs[4])>10) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"GPU�� ���� �ʹ� �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[5].length()>3) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"GPU�� TDP�� �ʹ� �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else {
				if(check>=0)
					new inputSinglePart(strs);
				else
					JOptionPane.showMessageDialog(singlePartUI.spw,"��ġ�� -��ġ�� ������ �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
			}
		}
		else if(singlePartWindow.partComboSouth.getSelectedItem().equals("RAM")) {
			try {
				check=Integer.parseInt(strs[3]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"GB�뷮�� ���ڸ� �Է��ؾ� �˴ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			try {
				check=Integer.parseInt(strs[4]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"HMZ�� ���ڸ� �Է��ؾ� �˴ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			if(strs[0].length()>60) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"RAM�� ��ǰ���� �ʹ� ��ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[1].length()>20) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"RAM�� ����Ŀ���� �ʹ� ��ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[2].length()>16) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"RAM�� �뷮 �԰��� �ʹ� ��ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[3].length()>4||Float.parseFloat(strs[3])>100) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"RAM�� GB�뷮�� �ʹ� �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[4].length()>5||Float.parseFloat(strs[4])>10000) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"RAM�� HMZ�� �ʹ� �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[5].length()>16) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"RAM�� ATX �����͸� �Է��ϼ���","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else {
				if(check>=0)
					new inputSinglePart(strs);
				else
					JOptionPane.showMessageDialog(singlePartUI.spw,"��ġ�� -��ġ�� ������ �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
			}
		}
		else if(singlePartWindow.partComboSouth.getSelectedItem().equals("SSD")) {
			try {
				check=Integer.parseInt(strs[4]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"ǥ��뷮�� ���ڸ� �Է��ؾ� �˴ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			try {
				check=Integer.parseInt(strs[5]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"�����뷮�� ���ڸ� �Է��ؾ� �˴ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			if(strs[0].length()>60) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"SSD�� ��ǰ���� �ʹ� ��ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[1].length()>20) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"SSD�� ����Ŀ���� �ʹ� ��ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[2].length()>16) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"SSD�� xLC�԰��� �ٸ��ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[3].length()>16) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"SSD�� �����԰��� �ٸ��ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[4].length()>5||Float.parseFloat(strs[4])>50000) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"SSD�� ǥ��뷮�� �ʹ� Ů�ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[5].length()>5||Float.parseFloat(strs[5])>50000) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"SSD�� �����뷮�� �ʹ� Ů�ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else {
				if(check>=0)
					new inputSinglePart(strs);
				else
					JOptionPane.showMessageDialog(singlePartUI.spw,"��ġ�� -��ġ�� ������ �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
			}
		}
		else if(singlePartWindow.partComboSouth.getSelectedItem().equals("HDD")) {
			try {
				check=Integer.parseInt(strs[4]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"ǥ��뷮�� ���ڸ� �Է��ؾ� �˴ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			try {
				check=Integer.parseInt(strs[5]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"�����뷮�� ���ڸ� �Է��ؾ� �˴ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			if(strs[0].length()>60) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"HDD�� ��ǰ���� �ʹ� ��ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[1].length()>20) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"HDD�� ����Ŀ���� �ʹ� ��ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[2].length()>5||Float.parseFloat(strs[2])>50000) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"HDD�� RPM�� �ʹ� �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[3].length()>3||Float.parseFloat(strs[3])>500) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"HDD�� ĳ�ð� �ʹ� �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[4].length()>5||Float.parseFloat(strs[4])>50000) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"HDD�� ǥ��뷮�� �ʹ� Ů�ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[5].length()>5||Float.parseFloat(strs[5])>50000) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"HDD�� �����뷮�� �ʹ� Ů�ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else {
				if(check>=0)
					new inputSinglePart(strs);
				else
					JOptionPane.showMessageDialog(singlePartUI.spw,"��ġ�� -��ġ�� ������ �����ϴ�.","update error",JOptionPane.WARNING_MESSAGE,null);
			}
		}
	}
}