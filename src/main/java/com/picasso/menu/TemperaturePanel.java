package com.picasso.menu;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class TemperaturePanel extends JPanel {
	private JLabel txtTitle, tempIcon, arrowIcon, txtSubtitle;
	private JSeparator separator, separator_1;
	private JTextField inputTemperature, outputTemperature;
	private JComboBox comboBoxTemp, comboBoxTemp2;

	/**
	 * Create the panel.
	 */
	public TemperaturePanel() {
		setBounds(229, 0, 534, 386);
		setLayout(null);
		setVisible(false);
		
		txtTitle = new JLabel("Conversor de temperatura");
		txtTitle.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitle.setFont(new Font("Monospaced", Font.BOLD, 24));
		txtTitle.setBounds(119, 51, 351, 42);
		add(txtTitle);
		
		separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(129, 51, 341, 2);
		add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setBounds(129, 91, 341, 2);
		add(separator_1);
		
		tempIcon = new JLabel();
		tempIcon.setHorizontalAlignment(SwingConstants.CENTER);
		tempIcon.setIcon(new ImageIcon("C:\\Users\\JAPM_\\eclipse-workspace\\ConversorJavaChallengeONE\\src\\main\\java\\img\\temperatureIcon.png"));
		tempIcon.setBounds(61, 30, 65, 108);
		add(tempIcon);
		
		arrowIcon = new JLabel();
		arrowIcon.setIcon(new ImageIcon("C:\\Users\\JAPM_\\eclipse-workspace\\ConversorJavaChallengeONE\\src\\main\\java\\img\\arrowIcon.png"));
		arrowIcon.setBounds(263, 232, 35, 39);
		add(arrowIcon);
		
		txtSubtitle = new JLabel("Valor en:");
		txtSubtitle.setFont(new Font("Monospaced", Font.BOLD, 16));
		txtSubtitle.setBounds(236, 200, 100, 14);
		add(txtSubtitle);
		
		txtSubtitle = new JLabel("Cambiar a:");
		txtSubtitle.setFont(new Font("Monospaced", Font.BOLD, 16));
		txtSubtitle.setBounds(236, 289, 100, 14);
		add(txtSubtitle);
		
		comboBoxTemp = new JComboBox();
		comboBoxTemp.setBackground(new Color(0, 0, 0));
		comboBoxTemp.setForeground(new Color(255, 255, 255));
		comboBoxTemp.setBounds(338, 193, 130, 33);
		add(comboBoxTemp);
		
		inputTemperature = new JTextField();
		inputTemperature.setFont(new Font("Monospaced", Font.BOLD, 12));
		inputTemperature.setBounds(72, 192, 154, 33);
		add(inputTemperature);
		inputTemperature.setColumns(10);
		
		comboBoxTemp2 = new JComboBox();
		comboBoxTemp2.setForeground(Color.WHITE);
		comboBoxTemp2.setBackground(Color.BLACK);
		comboBoxTemp2.setBounds(338, 282, 130, 33);
		add(comboBoxTemp2);
		
		outputTemperature = new JTextField();
		outputTemperature.setFont(new Font("Monospaced", Font.BOLD, 12));
		outputTemperature.setColumns(10);
		outputTemperature.setBounds(72, 281, 154, 33);
		add(outputTemperature);			
		
		

	}

}
