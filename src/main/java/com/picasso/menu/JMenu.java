package com.picasso.menu;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class JMenu extends JFrame {

	private JPanel contentPane, navPanel, infoPanel, currencyPanel, temperaturePanel;
	private JTextField inputCurrency, outputCurrency;
	private JSeparator separator, separator_1;
	private JLabel arrowIcon, txtSubtitle, txtSubtitle2, txtTitle, tempIcon, currencyIcon;

	/**
	 * Create the frame.
	 */
	public JMenu() {
		Image icon = new ImageIcon(getClass().getResource("/img/programIcon.png")).getImage();
		setIconImage(icon);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 425);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//////////////////////////////////////////////////////////////
		
		navPanel = new JPanel();
		navPanel.setBackground(new Color(0, 0, 0));
		navPanel.setBounds(0, 0, 247, 386);
		navPanel.setLayout(null);
		contentPane.add(navPanel);
		
		JPanel btnTemp = new JPanel();
		btnTemp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				temperaturePanel.setVisible(true);
				currencyPanel.setVisible(false);
				infoPanel.setVisible(false);
			}
		});
		btnTemp.setBackground(new Color(63, 63, 63));
		btnTemp.setBounds(0, 195, 247, 43);
		navPanel.add(btnTemp);
		btnTemp.setLayout(null);
		
		JLabel txtBtnTemp = new JLabel("Conversor de temperatura");
		txtBtnTemp.setBounds(30, 11, 207, 21);
		txtBtnTemp.setFont(new Font("Monospaced", Font.BOLD, 14));
		txtBtnTemp.setForeground(new Color(255, 255, 255));
		btnTemp.add(txtBtnTemp);
		
		JLabel titleNav = new JLabel("Conversor Alura");
		titleNav.setFont(new Font("Monospaced", Font.BOLD, 20));
		titleNav.setForeground(new Color(255, 255, 255));
		titleNav.setBounds(28, 30, 197, 43);
		navPanel.add(titleNav);
		
		separator = new JSeparator();
		separator.setBounds(28, 70, 179, 2);
		navPanel.add(separator);
		
		JPanel btnCurrency = new JPanel();
		btnCurrency.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				currencyPanel.setVisible(true);
				infoPanel.setVisible(false);
				temperaturePanel.setVisible(false);
			}
		});
		btnCurrency.setLayout(null);
		btnCurrency.setBackground(new Color(63, 63, 63));
		btnCurrency.setBounds(0, 128, 247, 43);
		navPanel.add(btnCurrency);
		
		JLabel txtBtnCurrency = new JLabel("Conversor de divisas");
		txtBtnCurrency.setForeground(Color.WHITE);
		txtBtnCurrency.setFont(new Font("Monospaced", Font.BOLD, 14));
		txtBtnCurrency.setBounds(39, 11, 168, 21);
		btnCurrency.add(txtBtnCurrency);
		
		JPanel btnExit = new JPanel();
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnExit.setLayout(null);
		btnExit.setBackground(new Color(63, 63, 63));
		btnExit.setBounds(0, 267, 247, 43);
		navPanel.add(btnExit);
		
		JLabel txtBtnExit = new JLabel("Salir");
		txtBtnExit.setForeground(Color.WHITE);
		txtBtnExit.setFont(new Font("Monospaced", Font.BOLD, 14));
		txtBtnExit.setBounds(95, 11, 63, 21);
		btnExit.add(txtBtnExit);
		
		//////////////////////////////////////////////////////////////
		
		
		infoPanel = new JPanel();
		infoPanel.setBackground(new Color(255, 255, 255));
		infoPanel.setBounds(235, 0, 544, 386);
		infoPanel.setLayout(null);
		contentPane.add(infoPanel);
		
		txtTitle = new JLabel("Conversor Alura");
		txtTitle.setFont(new Font("Monospaced", Font.BOLD, 32));
		txtTitle.setBounds(134, 183, 301, 33);
		infoPanel.add(txtTitle);
		
		separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(134, 172, 279, 2);
		infoPanel.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setBounds(134, 237, 279, 2);
		infoPanel.add(separator_1);
		
		txtSubtitle = new JLabel("Hecho por Alberto Picasso Mtz");
		txtSubtitle.setHorizontalAlignment(SwingConstants.CENTER);
		txtSubtitle.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtSubtitle.setBounds(173, 279, 211, 14);
		infoPanel.add(txtSubtitle);
		
		currencyIcon = new JLabel();
		currencyIcon.setIcon(new ImageIcon("src/main/java/img/currencyIcon.png"));
		currencyIcon.setBounds(92, 39, 111, 111);
		infoPanel.add(currencyIcon);
		
		tempIcon = new JLabel();
		tempIcon.setHorizontalAlignment(SwingConstants.CENTER);
		tempIcon.setIcon(new ImageIcon("src/main/java/img/temperatureIcon.png"));
		tempIcon.setBounds(388, 39, 63, 111);
		infoPanel.add(tempIcon);
		
		JLabel lblGitIcon = new JLabel();
		lblGitIcon.setIcon(new ImageIcon("src/main/java/img/githubIcon.png"));
		lblGitIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblGitIcon.setBounds(235, 304, 32, 33);
		infoPanel.add(lblGitIcon);
		
		JLabel lblLinkIcon = new JLabel();
		lblLinkIcon.setIcon(new ImageIcon("src/main/java/img/linkedinIcon.png"));
		lblLinkIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblLinkIcon.setBounds(296, 307, 32, 30);
		infoPanel.add(lblLinkIcon);
		
		//////////////////////////////////////////////////////////////
		
		currencyPanel = new JPanel();
		currencyPanel.setBounds(235, 0, 544, 386);
		currencyPanel.setLayout(null);
		contentPane.add(currencyPanel);
		currencyPanel.setVisible(false);
		
		txtTitle = new JLabel("Conversor de divisas");
		txtTitle.setFont(new Font("Monospaced", Font.BOLD, 24));
		txtTitle.setBounds(188, 50, 289, 33);
		currencyPanel.add(txtTitle);
		
		separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(188, 83, 277, 2);
		currencyPanel.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setBounds(188, 50, 277, 2);
		currencyPanel.add(separator_1);
		
		JComboBox comboBoxCurrency = new JComboBox();
		comboBoxCurrency.setBackground(new Color(0, 0, 0));
		comboBoxCurrency.setForeground(new Color(255, 255, 255));
		comboBoxCurrency.setBounds(85, 178, 193, 33);
		currencyPanel.add(comboBoxCurrency);
		
		inputCurrency = new JTextField();
		inputCurrency.setFont(new Font("Monospaced", Font.BOLD, 12));
		inputCurrency.setBounds(327, 177, 154, 33);
		currencyPanel.add(inputCurrency);
		inputCurrency.setColumns(10);
		
		arrowIcon = new JLabel();
		arrowIcon.setIcon(new ImageIcon("C:\\Users\\JAPM_\\eclipse-workspace\\ConversorJavaChallengeONE\\src\\main\\java\\img\\arrowIcon.png"));
		arrowIcon.setBounds(286, 222, 35, 39);
		currencyPanel.add(arrowIcon);
		
		JComboBox comboBoxCurrency2 = new JComboBox();
		comboBoxCurrency2.setForeground(Color.WHITE);
		comboBoxCurrency2.setBackground(Color.BLACK);
		comboBoxCurrency2.setBounds(85, 297, 193, 33);
		currencyPanel.add(comboBoxCurrency2);
		
		outputCurrency = new JTextField();
		outputCurrency.setFont(new Font("Monospaced", Font.BOLD, 12));
		outputCurrency.setColumns(10);
		outputCurrency.setBounds(327, 296, 154, 33);
		currencyPanel.add(outputCurrency);
		
		txtSubtitle = new JLabel("Cambiar de:");
		txtSubtitle.setFont(new Font("Monospaced", Font.BOLD, 16));
		txtSubtitle.setBounds(239, 153, 118, 14);
		currencyPanel.add(txtSubtitle);
		
		txtSubtitle2 = new JLabel("Cambiar a:");
		txtSubtitle2.setFont(new Font("Monospaced", Font.BOLD, 16));
		txtSubtitle2.setBounds(239, 272, 108, 14);
		currencyPanel.add(txtSubtitle2);
		
		currencyIcon = new JLabel();
		currencyIcon.setHorizontalAlignment(SwingConstants.CENTER);
		currencyIcon.setIcon(new ImageIcon("C:\\Users\\JAPM_\\eclipse-workspace\\ConversorJavaChallengeONE\\src\\main\\java\\img\\currencyIcon.png"));
		currencyIcon.setBounds(70, 11, 108, 109);
		currencyPanel.add(currencyIcon);
		
		//////////////////////////////////////////////////////////////
		
		temperaturePanel = new JPanel();
		temperaturePanel.setBounds(229, 0, 550, 386);
		temperaturePanel.setLayout(null);
		contentPane.add(temperaturePanel);
		temperaturePanel.setVisible(false);
		
		txtTitle = new JLabel("Conversor de temperatura");
		txtTitle.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitle.setFont(new Font("Monospaced", Font.BOLD, 24));
		txtTitle.setBounds(129, 51, 351, 42);
		temperaturePanel.add(txtTitle);
		
		separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(139, 51, 341, 2);
		temperaturePanel.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setBounds(139, 91, 341, 2);
		temperaturePanel.add(separator_1);
		
		tempIcon = new JLabel();
		tempIcon.setHorizontalAlignment(SwingConstants.CENTER);
		tempIcon.setIcon(new ImageIcon("C:\\Users\\JAPM_\\eclipse-workspace\\ConversorJavaChallengeONE\\src\\main\\java\\img\\temperatureIcon.png"));
		tempIcon.setBounds(71, 30, 65, 108);
		temperaturePanel.add(tempIcon);
		
		arrowIcon = new JLabel();
		arrowIcon.setIcon(new ImageIcon("C:\\Users\\JAPM_\\eclipse-workspace\\ConversorJavaChallengeONE\\src\\main\\java\\img\\arrowIcon.png"));
		arrowIcon.setBounds(273, 232, 35, 39);
		temperaturePanel.add(arrowIcon);
		
		txtSubtitle = new JLabel("Valor en:");
		txtSubtitle.setFont(new Font("Monospaced", Font.BOLD, 16));
		txtSubtitle.setBounds(246, 200, 100, 14);
		temperaturePanel.add(txtSubtitle);
		
		txtSubtitle2 = new JLabel("Cambiar a:");
		txtSubtitle2.setFont(new Font("Monospaced", Font.BOLD, 16));
		txtSubtitle2.setBounds(246, 289, 100, 14);
		temperaturePanel.add(txtSubtitle2);
		
		JComboBox comboBoxTemp = new JComboBox();
		comboBoxTemp.setBackground(new Color(0, 0, 0));
		comboBoxTemp.setForeground(new Color(255, 255, 255));
		comboBoxTemp.setBounds(348, 193, 130, 33);
		temperaturePanel.add(comboBoxTemp);
		
		inputCurrency = new JTextField();
		inputCurrency.setFont(new Font("Monospaced", Font.BOLD, 12));
		inputCurrency.setBounds(82, 192, 154, 33);
		temperaturePanel.add(inputCurrency);
		inputCurrency.setColumns(10);
		
		JComboBox comboBoxTemp2 = new JComboBox();
		comboBoxTemp2.setForeground(Color.WHITE);
		comboBoxTemp2.setBackground(Color.BLACK);
		comboBoxTemp2.setBounds(348, 282, 130, 33);
		temperaturePanel.add(comboBoxTemp2);
		
		outputCurrency = new JTextField();
		outputCurrency.setFont(new Font("Monospaced", Font.BOLD, 12));
		outputCurrency.setColumns(10);
		outputCurrency.setBounds(82, 281, 154, 33);
		temperaturePanel.add(outputCurrency);
	}
}
