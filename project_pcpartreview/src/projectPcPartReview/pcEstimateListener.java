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
				String name=JOptionPane.showInputDialog(pcEstimateUI.pew, "������ �̸��� �Է��ϼ���","���� ����",JOptionPane.INFORMATION_MESSAGE);
				new pcEstimateInput(name);
			}			
			else {
				String name=JOptionPane.showInputDialog(pcEstimateUI.pew, "������ �̸��� �Է��ϼ���(���Է½� �̸� ����)","���� ����",JOptionPane.INFORMATION_MESSAGE);
				new pcEstimateUpdate(name);
			}
		}
	}
}
class pcEstiamateLoad implements ActionListener{
	@SuppressWarnings("rawtypes")
	public void actionPerformed(ActionEvent e) {
		JComboBox jcb=pcEstimateWindow.reviewsave;
		String inputtime=jcb.getSelectedItem().toString().substring(jcb.getSelectedItem().toString().indexOf(":")+2,jcb.getSelectedItem().toString().indexOf("��")-2);
		new pcEstimateImport(inputtime);
	}
}