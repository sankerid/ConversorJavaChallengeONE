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

@SuppressWarnings("serial")
public class JMenu extends JFrame {

	private JPanel contentPane;

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
		
		JPanel navPanel = new JPanel();
		navPanel.setBackground(new Color(0, 0, 0));
		navPanel.setBounds(0, 0, 247, 386);
		contentPane.add(navPanel);
		navPanel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(63, 63, 63));
		panel_1.setBounds(0, 195, 247, 43);
		navPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Conversor de temperatura");
		lblNewLabel_1.setBounds(30, 11, 207, 21);
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Conversor Alura");
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(28, 30, 197, 43);
		navPanel.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(28, 70, 179, 2);
		navPanel.add(separator);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(63, 63, 63));
		panel_1_1.setBounds(0, 128, 247, 43);
		navPanel.add(panel_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Conversor de divisas");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(39, 11, 168, 21);
		panel_1_1.add(lblNewLabel_1_1);
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setLayout(null);
		panel_1_2_1.setBackground(new Color(63, 63, 63));
		panel_1_2_1.setBounds(0, 267, 247, 43);
		navPanel.add(panel_1_2_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Salir");
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(95, 11, 63, 21);
		panel_1_2_1.add(lblNewLabel_1_2_1);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(new Color(255, 255, 255));
		infoPanel.setBounds(235, 0, 544, 386);
		contentPane.add(infoPanel);
		
		JPanel currencyPanel = new JPanel();
		currencyPanel.setBounds(235, 0, 544, 386);
		contentPane.add(currencyPanel);
	}
}
