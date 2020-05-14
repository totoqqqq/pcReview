package projectPcPartReview;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class objFontAndSize{
	//setSize : J~ 객체의 font설정과, 객체의 크기를 설정하는 기능
	//addSetSize : JPanel에 객체를 add 하면서 objFontAndSize.setSize의 기능을 수행
	//button은 배경 회색으로 세팅. 필요시 코드 수정 혹은 오버라이딩 할것.
	//combobox는 배경 흰색으로 세팅. 필요시 코드 수정 혹은 오버라이딩 할것.
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
	void addMenuItem(JMenu JMenu, JMenuItem JMenuItem, Font fontSet, ActionListener ActionListener) {
		JMenu.add(JMenuItem);
		JMenuItem.setFont(fontSet);
		JMenuItem.addActionListener(ActionListener);
	}
	void addSetBorder(JPanel JPanel,JPanel addonJPanel,String BorderlayoutWhere) {
		JPanel.add(addonJPanel, BorderlayoutWhere);
		addonJPanel.setBackground(Color.WHITE);
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
		JTextField.setBorder(BorderFactory.createLineBorder(new Color(153,204,255)));
	}
	void addSetSize(JPanel JPanel,JPasswordField JPasswordField,Font fontSet,int weight, int height) {
		JPanel.add(JPasswordField);
		JPasswordField.setText(null);
		JPasswordField.setFont(fontSet);
		JPasswordField.setPreferredSize(new Dimension(weight,height));
		JPasswordField.setBorder(BorderFactory.createLineBorder(new Color(153,204,255)));
	}
	void addSetColor(JPanel JPanel,JPanel addonJPanel,Color Color) {
		JPanel.add(addonJPanel);
		addonJPanel.setBackground(Color);
	}
	void addSetColor(JPanel JPanel,JPanel addonJPanel) {
		JPanel.add(addonJPanel);
		addonJPanel.setBackground(Color.WHITE);
	}
}