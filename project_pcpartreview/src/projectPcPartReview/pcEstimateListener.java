package projectPcPartReview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

class pcEstimateAction extends loginSQL implements ActionListener {
	static pcEstimateDialog peds=null;
	static int mod=0;
	public void actionPerformed(ActionEvent e) {
		if((JButton)e.getSource()==pcEstimateWindow.load) {
			new pcEsimateDialogReview(userName);
			if(mod==0) {
			if(pcEstimaDialog.ped==null)
				pcEstimaDialog.create();
			else
				pcEstimaDialog.open();
			}
			else {
				mod=0;
				return;
			}
		}
		else if((JButton)e.getSource()==pcEstimateWindow.save) {
			if(pcEstimateWindow.savemode==true) {
				String name=JOptionPane.showInputDialog(pcEstimateUI.pew, "저장할 이름을 입력하세요","견적 저장",JOptionPane.INFORMATION_MESSAGE);
				new pcEstimateInput(name);
			}			
			else {
				String name=JOptionPane.showInputDialog(pcEstimateUI.pew, "저장할 이름을 입력하세요(미입력시 이름 유지)","견적 수정",JOptionPane.INFORMATION_MESSAGE);
				new pcEstimateUpdate(name);
			}
		}
	}
}
class pcEstiamateLoad implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		if(pcEstimateDialog.reviewsave.getSelectedItem()==null) {
			pcEstimaDialog.close();
			return;
		}
		String inputtime=pcEstimateDialog.reviewsave.getSelectedItem().toString().substring(pcEstimateDialog.reviewsave.getSelectedItem().toString().indexOf(":")+2,pcEstimateDialog.reviewsave.getSelectedItem().toString().indexOf("수")-2);
		new pcEstimateImport(inputtime);
		pcEstimaDialog.close();
	}
}
class pcEstiamateDelete implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		if(pcEstimateDialog.reviewsave.getSelectedItem()==null) {
			pcEstimaDialog.close();
			return;
		}
		String inputtime=pcEstimateDialog.reviewsave.getSelectedItem().toString().substring(pcEstimateDialog.reviewsave.getSelectedItem().toString().indexOf(":")+2,pcEstimateDialog.reviewsave.getSelectedItem().toString().indexOf("수")-2);
		if(inputtime==null) {
			pcEstimaDialog.close();
		}
		new pcEstimateDelete(inputtime);
		pcEstimaDialog.close();
	}
}
class pcEstiamateMenuSystem extends loginSQL implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		if((JMenuItem)e.getSource()==pcEstimateWindow.systemLogout) {
			loginWindow.loginIDText.setText("");
			loginWindow.loginPassText.setText("");
			loginWindow.loginIDText.requestFocus();
			loginUI.loginW.setLocationRelativeTo(null);
			loginUI.open();
			pcEstimateUI.close();
			return;
		}
		else if((JMenuItem)e.getSource()==pcEstimateWindow.systemExit)
			System.exit(0);
		else if((JMenuItem)e.getSource()==pcEstimateWindow.systemSinglePart)
			pcEstimateUI.close();
			new singlePartUI().open(level);
		return;
	}	
}