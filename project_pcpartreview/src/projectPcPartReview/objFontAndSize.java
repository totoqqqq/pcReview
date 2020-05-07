package projectPcPartReview;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class objFontAndSize{
	//setSize : J~ ��ü�� font������, ��ü�� ũ�⸦ �����ϴ� ���
	//addSetSize : JPanel�� ��ü�� add �ϸ鼭 objFontAndSize.setSize�� ����� ����
	//button�� ��� ȸ������ ����. �ʿ�� �ڵ� ���� Ȥ�� �������̵� �Ұ�.
	//combobox�� ��� ������� ����. �ʿ�� �ڵ� ���� Ȥ�� �������̵� �Ұ�.
	void setSize(@SuppressWarnings("rawtypes") JComboBox JComboBox,Font fontSet,int weight, int height){
		JComboBox.setFont(fontSet);
		JComboBox.setPreferredSize(new Dimension(weight,height));
		JComboBox.setBackground(Color.WHITE);
	}
	void setSize(JTextField JTextField,Font fontSet,int weight, int height){
		JTextField.setText(null);
		JTextField.setFont(fontSet);
		JTextField.setPreferredSize(new Dimension(weight,height));
	}
	void setSize(JButton JButton,Font fontSet,int weight, int height){
		JButton.setFont(fontSet);
		JButton.setPreferredSize(new Dimension(weight,height));
		JButton.setBackground(Color.LIGHT_GRAY);
		JButton.setBorderPainted(false);
	}
	void addSetSize(JPanel JPanel,JButton JButton,Font fontSet,int weight, int height) {
		JPanel.add(JButton);
		JButton.setFont(fontSet);
		JButton.setPreferredSize(new Dimension(weight,height));
		JButton.setBackground(new Color(153,204,255));
		JButton.setBorderPainted(false);
		JButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
	}
	void addSetSize(JPanel JPanel,JTextField JTextField,Font fontSet,int weight, int height) {
		JPanel.add(JTextField);
		JTextField.setText(null);
		JTextField.setFont(fontSet);
		JTextField.setPreferredSize(new Dimension(weight,height));
	}
	void addSetSize(JPanel JPanel,JPasswordField JPasswordField,Font fontSet,int weight, int height) {
		JPanel.add(JPasswordField);
		JPasswordField.setText(null);
		JPasswordField.setFont(fontSet);
		JPasswordField.setPreferredSize(new Dimension(weight,height));
	}
	void addSetSize(JPanel JPanel,JPanel addonJPanel,Color Color) {
		JPanel.add(addonJPanel);
		addonJPanel.setBackground(Color);
	}
	void addSetSize(JPanel JPanel,JPanel addonJPanel) {
		JPanel.add(addonJPanel);
		addonJPanel.setBackground(Color.WHITE);
	}
}