package projectPcPartReview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

class pcEstimateAction extends loginSQL implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		if((JButton)e.getSource()==pcEstimateWindow.load) {
			new pcEsimateDialogReview(userName);
			new pcEstimaDialog();
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
	@SuppressWarnings("rawtypes")
	public void actionPerformed(ActionEvent e) {
		JComboBox jcb=pcEstimateWindow.reviewsave;
		String inputtime=jcb.getSelectedItem().toString().substring(jcb.getSelectedItem().toString().indexOf(":")+2,jcb.getSelectedItem().toString().indexOf("수")-2);
		new pcEstimateImport(inputtime);
	}
}