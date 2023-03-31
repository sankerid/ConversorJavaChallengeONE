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
public class CurrencyPanel extends JPanel {
	
	private JTextField inputCurrency, outputCurrency;
	private JSeparator separator, separator_1;
	private JLabel txtTitle, arrowIcon, txtSubtitle, currencyIcon;
	private JComboBox comboBoxCurrency, comboBoxCurrency2;

	public CurrencyPanel() {
		setBounds(235, 0, 544, 386);
		setLayout(null);
		setVisible(false);
		
		txtTitle = new JLabel("Conversor de divisas");
		txtTitle.setFont(new Font("Monospaced", Font.BOLD, 24));
		txtTitle.setBounds(180, 61, 289, 33);
		add(txtTitle);
		
		separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(180, 94, 277, 2);
		add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setBounds(180, 61, 277, 2);
		add(separator_1);
		
		comboBoxCurrency = new JComboBox();
		comboBoxCurrency.setBackground(new Color(0, 0, 0));
		comboBoxCurrency.setForeground(new Color(255, 255, 255));
		comboBoxCurrency.setBounds(77, 189, 193, 33);
		add(comboBoxCurrency);
		
		inputCurrency = new JTextField();
		inputCurrency.setFont(new Font("Monospaced", Font.BOLD, 12));
		inputCurrency.setBounds(319, 188, 154, 33);
		add(inputCurrency);
		inputCurrency.setColumns(10);
		
		arrowIcon = new JLabel();
		arrowIcon.setIcon(new ImageIcon("C:\\Users\\JAPM_\\eclipse-workspace\\ConversorJavaChallengeONE\\src\\main\\java\\img\\arrowIcon.png"));
		arrowIcon.setBounds(278, 233, 35, 39);
		add(arrowIcon);
		
		comboBoxCurrency2 = new JComboBox();
		comboBoxCurrency2.setForeground(Color.WHITE);
		comboBoxCurrency2.setBackground(Color.BLACK);
		comboBoxCurrency2.setBounds(77, 308, 193, 33);
		add(comboBoxCurrency2);
		
		outputCurrency = new JTextField();
		outputCurrency.setFont(new Font("Monospaced", Font.BOLD, 12));
		outputCurrency.setColumns(10);
		outputCurrency.setBounds(319, 307, 154, 33);
		add(outputCurrency);
		
		txtSubtitle = new JLabel("Cambiar de:");
		txtSubtitle.setFont(new Font("Monospaced", Font.BOLD, 16));
		txtSubtitle.setBounds(231, 164, 118, 14);
		add(txtSubtitle);
		
		txtSubtitle = new JLabel("Cambiar a:");
		txtSubtitle.setFont(new Font("Monospaced", Font.BOLD, 16));
		txtSubtitle.setBounds(231, 283, 108, 14);
		add(txtSubtitle);
		
		currencyIcon = new JLabel();
		currencyIcon.setHorizontalAlignment(SwingConstants.CENTER);
		currencyIcon.setIcon(new ImageIcon("C:\\Users\\JAPM_\\eclipse-workspace\\ConversorJavaChallengeONE\\src\\main\\java\\img\\currencyIcon.png"));
		currencyIcon.setBounds(62, 22, 108, 109);
		add(currencyIcon);
	}

}
