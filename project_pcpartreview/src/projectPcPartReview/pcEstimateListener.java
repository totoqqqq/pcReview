package projectPcPartReview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

class pcEstimateAction implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		if((JButton)e.getSource()==pcEstimateWindow.load) {
			new pcEsimateDialogReview(loginSQL.userName);
			pcEstimateUI.ped=new pcEsimateDialog();
		}
		else if((JButton)e.getSource()==pcEstimateWindow.save) {
			String name=JOptionPane.showInputDialog(pcEstimateUI.pew, "저장할 이름을 입력하세요","견적 저장",JOptionPane.INFORMATION_MESSAGE);
			new pcEstimateInput(name);
		}
	}
}
