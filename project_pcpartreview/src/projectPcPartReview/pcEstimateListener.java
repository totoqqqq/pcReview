package projectPcPartReview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

class pcEstimateAction extends loginSQL implements ActionListener {
	static pcEstimateDialog peds=null;
	public void actionPerformed(ActionEvent e) {
		if((JButton)e.getSource()==pcEstimateWindow.load) {
			new pcEsimateDialogReview(userName);
			new pcEstimateDialog();
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
		String inputtime=pcEstimateWindow.reviewsave.getSelectedItem().toString().substring(pcEstimateWindow.reviewsave.getSelectedItem().toString().indexOf(":")+2,pcEstimateWindow.reviewsave.getSelectedItem().toString().indexOf("��")-2);
		new pcEstimateImport(inputtime);
		pcEstimaDialog.close();
	}
}
class pcEstiamateDelete implements ActionListener{
	@SuppressWarnings("rawtypes")
	public void actionPerformed(ActionEvent e) {
		String inputtime=pcEstimateWindow.reviewsave.getSelectedItem().toString().substring(pcEstimateWindow.reviewsave.getSelectedItem().toString().indexOf(":")+2,pcEstimateWindow.reviewsave.getSelectedItem().toString().indexOf("��")-2);
		new pcEstimateDelete(inputtime);
		pcEstimaDialog.close();
	}
}