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
			String name=JOptionPane.showInputDialog(pcEstimateUI.pew, "������ �̸��� �Է��ϼ���","���� ����",JOptionPane.INFORMATION_MESSAGE);
			new pcEstimateInput(name);
		}
	}
}
