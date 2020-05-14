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
			if(strs[0].length()>60) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"CPU의 부품명이 너무 깁니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[0].equals(partname[0])==false) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"불러온 CPU의 부품명을 바꿀 순 없습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[1].length()>20) {
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
			else if(strs[4].length()>16) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"칩셋명이 너무 깁니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[5].length()>3) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"CPU의 TDP가 너무 높습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else {
				if(check>=0)
					new updateImportSinglePart(strs,location);
				else
					JOptionPane.showMessageDialog(singlePartUI.spw,"수치에 -수치는 넣을수 없습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
			}
		}
		else if(singlePartWindow.partComboSouth.getSelectedItem().equals("MB")) {
			try {
				check=Integer.parseInt(strs[2]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"RAM버스는 숫자를 입력해야 됩니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			if(strs[0].length()>60) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"메인보드의 부품명이 너무 깁니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[0].equals(partname[0])==false) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"불러온 메인보드의 부품명을 바꿀 순 없습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[1].length()>20) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"메인보드의 메이커명이 너무 깁니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[2].length()>2) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"메인보드의 RAM버스 갯수가 너무 많습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[3].length()>16) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"메인보드의 규격의 길이가 너무깁니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[4].length()>16) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"칩셋명이 너무 깁니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[5].length()>5) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"메인보드의 M-보드 여부랑 다릅니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else {
				if(check>=0)
					new updateImportSinglePart(strs,location);
				else
					JOptionPane.showMessageDialog(singlePartUI.spw,"수치에 -수치는 넣을수 없습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
			}
		}
		else if(singlePartWindow.partComboSouth.getSelectedItem().equals("GPU")) {
			try {
				check=Integer.parseInt(strs[2]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"VRAM은 숫자를 입력해야 됩니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			try {
				check=Integer.parseInt(strs[3]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"Mhz는 숫자를 입력해야 됩니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			try {
				check=Integer.parseInt(strs[4]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"팬의수는 숫자를 입력해야 됩니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			if(strs[0].length()>60) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"GPU의 부품명이 너무 깁니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[0].equals(partname[0])==false) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"불러온 GPU의 부품명을 바꿀 순 없습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[1].length()>20) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"GPU의 메이커명이 너무 깁니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[2].length()>3||Float.parseFloat(strs[2])>100) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"GPU의 VRAM가 너무 높습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[3].length()>6||Float.parseFloat(strs[3])>100000) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"GPU의 Mhz가 너무 높습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[4].length()>2||Float.parseFloat(strs[4])>10) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"GPU의 팬이 너무 많습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[5].length()>3) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"GPU의 TDP가 너무 높습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else {
				if(check>=0)
					new updateImportSinglePart(strs,location);
				else
					JOptionPane.showMessageDialog(singlePartUI.spw,"수치에 -수치는 넣을수 없습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
			}
		}
		else if(singlePartWindow.partComboSouth.getSelectedItem().equals("RAM")) {
			try {
				check=Integer.parseInt(strs[3]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"GB용량은 숫자를 입력해야 됩니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			try {
				check=Integer.parseInt(strs[4]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"HMZ는 숫자를 입력해야 됩니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			if(strs[0].length()>60) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"RAM의 부품명이 너무 깁니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[0].equals(partname[0])==false) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"불러온 RAM의 부품명을 바꿀 순 없습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[1].length()>20) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"RAM의 메이커명이 너무 깁니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[2].length()>16) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"RAM의 용량 규격이 너무 깁니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[3].length()>4||Float.parseFloat(strs[3])>100) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"RAM의 GB용량이 너무 높습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[4].length()>5||Float.parseFloat(strs[4])>10000) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"RAM의 HMZ이 너무 많습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[5].length()>16) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"RAM의 ATX 데이터만 입력하세요","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else {
				if(check>=0)
					new updateImportSinglePart(strs,location);
				else
					JOptionPane.showMessageDialog(singlePartUI.spw,"수치에 -수치는 넣을수 없습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
			}
		}
		else if(singlePartWindow.partComboSouth.getSelectedItem().equals("SSD")) {
			try {
				check=Integer.parseInt(strs[4]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"표기용량은 숫자를 입력해야 됩니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			try {
				check=Integer.parseInt(strs[5]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"실제용량은 숫자를 입력해야 됩니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			if(strs[0].length()>60) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"SSD의 부품명이 너무 깁니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[0].equals(partname[0])==false) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"불러온 SSD의 부품명을 바꿀 순 없습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[1].length()>20) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"SSD의 메이커명이 너무 깁니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[2].length()>16) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"SSD의 xLC규격이 다릅니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[3].length()>16) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"SSD의 장착규격이 다릅니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[4].length()>5||Float.parseFloat(strs[4])>50000) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"SSD의 표기용량이 너무 큽니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[5].length()>5||Float.parseFloat(strs[5])>50000) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"SSD의 실제용량이 너무 큽니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else {
				if(check>=0)
					new updateImportSinglePart(strs,location);
				else
					JOptionPane.showMessageDialog(singlePartUI.spw,"수치에 -수치는 넣을수 없습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
			}
		}
		else if(singlePartWindow.partComboSouth.getSelectedItem().equals("HDD")) {
			try {
				check=Integer.parseInt(strs[4]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"표기용량은 숫자를 입력해야 됩니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			try {
				check=Integer.parseInt(strs[5]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"실제용량은 숫자를 입력해야 됩니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			if(strs[0].length()>60) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"HDD의 부품명이 너무 깁니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[0].equals(partname[0])==false) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"불러온 HDD의 부품명을 바꿀 순 없습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[1].length()>20) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"HDD의 메이커명이 너무 깁니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[2].length()>5||Float.parseFloat(strs[2])>50000) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"HDD의 RPM이 너무 높습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[3].length()>3||Float.parseFloat(strs[3])>500) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"HDD의 캐시가 너무 높습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[4].length()>5||Float.parseFloat(strs[4])>50000) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"HDD의 표기용량이 너무 큽니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[5].length()>5||Float.parseFloat(strs[5])>50000) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"HDD의 실제용량이 너무 큽니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else {
				if(check>=0)
					new updateImportSinglePart(strs,location);
				else
					JOptionPane.showMessageDialog(singlePartUI.spw,"수치에 -수치는 넣을수 없습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
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
			if(strs[0].length()>60) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"CPU의 부품명이 너무 깁니다.","insert error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[1].length()>20) {
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
			else if(strs[4].length()>16) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"칩셋명이 너무 깁니다.","insert error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[5].length()>3) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"CPU의 TDP가 너무 높습니다.","insert error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else {
				if(check>=0)
					new inputSinglePart(strs);
				else
					JOptionPane.showMessageDialog(singlePartUI.spw,"수치에 -수치는 넣을수 없습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
			}
		}
		else if(singlePartWindow.partComboSouth.getSelectedItem().equals("MB")) {
			try {
				check=Integer.parseInt(strs[2]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"RAM버스는 숫자를 입력해야 됩니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			if(strs[0].length()>60) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"메인보드의 부품명이 너무 깁니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[1].length()>20) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"메인보드의 메이커명이 너무 깁니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[2].length()>2) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"메인보드의 RAM버스 갯수가 너무 많습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[3].length()>16) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"메인보드의 규격의 길이가 너무깁니다.\n(10Ghz 미만 소수점 둘째자리 까지만 입력하세요.)","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[4].length()>16) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"칩셋명이 너무 깁니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[5].length()>5) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"메인보드의 M-보드 여부랑 다릅니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else {
				if(check>=0)
					new inputSinglePart(strs);
				else
					JOptionPane.showMessageDialog(singlePartUI.spw,"수치에 -수치는 넣을수 없습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
			}		
		}
		else if(singlePartWindow.partComboSouth.getSelectedItem().equals("GPU")) {
			try {
				check=Integer.parseInt(strs[2]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"VRAM은 숫자를 입력해야 됩니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			try {
				check=Integer.parseInt(strs[3]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"Mhz는 숫자를 입력해야 됩니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			try {
				check=Integer.parseInt(strs[4]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"팬의수는 숫자를 입력해야 됩니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			if(strs[0].length()>60) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"GPU의 부품명이 너무 깁니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[1].length()>20) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"GPU의 메이커명이 너무 깁니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[2].length()>3||Float.parseFloat(strs[2])>100) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"GPU의 VRAM가 너무 높습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[3].length()>6||Float.parseFloat(strs[3])>100000) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"GPU의 Mhz가 너무 높습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[4].length()>2||Float.parseFloat(strs[4])>10) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"GPU의 팬이 너무 많습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[5].length()>3) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"GPU의 TDP가 너무 높습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else {
				if(check>=0)
					new inputSinglePart(strs);
				else
					JOptionPane.showMessageDialog(singlePartUI.spw,"수치에 -수치는 넣을수 없습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
			}
		}
		else if(singlePartWindow.partComboSouth.getSelectedItem().equals("RAM")) {
			try {
				check=Integer.parseInt(strs[3]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"GB용량은 숫자를 입력해야 됩니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			try {
				check=Integer.parseInt(strs[4]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"HMZ는 숫자를 입력해야 됩니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			if(strs[0].length()>60) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"RAM의 부품명이 너무 깁니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[1].length()>20) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"RAM의 메이커명이 너무 깁니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[2].length()>16) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"RAM의 용량 규격이 너무 깁니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[3].length()>4||Float.parseFloat(strs[3])>100) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"RAM의 GB용량이 너무 높습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[4].length()>5||Float.parseFloat(strs[4])>10000) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"RAM의 HMZ이 너무 많습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[5].length()>16) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"RAM의 ATX 데이터만 입력하세요","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else {
				if(check>=0)
					new inputSinglePart(strs);
				else
					JOptionPane.showMessageDialog(singlePartUI.spw,"수치에 -수치는 넣을수 없습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
			}
		}
		else if(singlePartWindow.partComboSouth.getSelectedItem().equals("SSD")) {
			try {
				check=Integer.parseInt(strs[4]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"표기용량은 숫자를 입력해야 됩니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			try {
				check=Integer.parseInt(strs[5]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"실제용량은 숫자를 입력해야 됩니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			if(strs[0].length()>60) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"SSD의 부품명이 너무 깁니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[1].length()>20) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"SSD의 메이커명이 너무 깁니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[2].length()>16) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"SSD의 xLC규격이 다릅니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[3].length()>16) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"SSD의 장착규격이 다릅니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[4].length()>5||Float.parseFloat(strs[4])>50000) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"SSD의 표기용량이 너무 큽니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[5].length()>5||Float.parseFloat(strs[5])>50000) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"SSD의 실제용량이 너무 큽니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else {
				if(check>=0)
					new inputSinglePart(strs);
				else
					JOptionPane.showMessageDialog(singlePartUI.spw,"수치에 -수치는 넣을수 없습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
			}
		}
		else if(singlePartWindow.partComboSouth.getSelectedItem().equals("HDD")) {
			try {
				check=Integer.parseInt(strs[4]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"표기용량은 숫자를 입력해야 됩니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			try {
				check=Integer.parseInt(strs[5]);
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"실제용량은 숫자를 입력해야 됩니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			if(strs[0].length()>60) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"HDD의 부품명이 너무 깁니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[1].length()>20) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"HDD의 메이커명이 너무 깁니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[2].length()>5||Float.parseFloat(strs[2])>50000) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"HDD의 RPM이 너무 높습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[3].length()>3||Float.parseFloat(strs[3])>500) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"HDD의 캐시가 너무 높습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[4].length()>5||Float.parseFloat(strs[4])>50000) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"HDD의 표기용량이 너무 큽니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else if(strs[5].length()>5||Float.parseFloat(strs[5])>50000) {
				JOptionPane.showMessageDialog(singlePartUI.spw,"HDD의 실제용량이 너무 큽니다.","update error",JOptionPane.WARNING_MESSAGE,null);
				return;
			}
			else {
				if(check>=0)
					new inputSinglePart(strs);
				else
					JOptionPane.showMessageDialog(singlePartUI.spw,"수치에 -수치는 넣을수 없습니다.","update error",JOptionPane.WARNING_MESSAGE,null);
			}
		}
	}
}