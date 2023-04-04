package com.picasso.menu;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Desktop.Action;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class JMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, navPanel, infoPanel, btnExit, btnCurrency, btnTemp;
	private JSeparator separator, separator_1;
	private JLabel txtSubtitle, txtTitle, tempIcon, currencyIcon, txtBtnCurrency, txtBtnExit, txtBtnTemp, gitIcon, linkIcon;
	private Image icon;
	private TemperaturePanel temperaturePanel;
	private CurrencyPanel currencyPanel;

	
	public JMenu() {
		icon = new ImageIcon(getClass().getResource("/img/logoAlura.png")).getImage();
		setIconImage(icon);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 425);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		temperaturePanel = new TemperaturePanel();
		temperaturePanel.setBounds(247, 0, 532, 386);
		contentPane.add(temperaturePanel);
		currencyPanel = new CurrencyPanel();
		currencyPanel.setBounds(247, 0, 532, 386);
		contentPane.add(currencyPanel);
		
		// Navigation panel
		
		navPanel = new JPanel();
		navPanel.setBackground(new Color(0, 0, 0));
		navPanel.setBounds(0, 0, 247, 386);
		navPanel.setLayout(null);
		contentPane.add(navPanel);
		
		btnTemp = new JPanel();
		btnTemp.setBackground(new Color(63, 63, 63));
		btnTemp.setBounds(0, 195, 247, 43);
		navPanel.add(btnTemp);
		btnTemp.setLayout(null);
		
		txtBtnTemp = new JLabel("Conversor de temperatura");
		txtBtnTemp.setBounds(30, 11, 207, 21);
		txtBtnTemp.setFont(new Font("Monospaced", Font.BOLD, 14));
		txtBtnTemp.setForeground(new Color(255, 255, 255));
		btnTemp.add(txtBtnTemp);
		
		txtTitle = new JLabel("Conversor Alura");
		txtTitle.setFont(new Font("Monospaced", Font.BOLD, 20));
		txtTitle.setForeground(new Color(255, 255, 255));
		txtTitle.setBounds(28, 30, 197, 43);
		navPanel.add(txtTitle);
		
		separator = new JSeparator();
		separator.setBounds(28, 70, 179, 2);
		navPanel.add(separator);
		
		btnCurrency = new JPanel();
		btnCurrency.setLayout(null);
		btnCurrency.setBackground(new Color(63, 63, 63));
		btnCurrency.setBounds(0, 128, 247, 43);
		navPanel.add(btnCurrency);
		
		txtBtnCurrency = new JLabel("Conversor de divisas");
		txtBtnCurrency.setForeground(Color.WHITE);
		txtBtnCurrency.setFont(new Font("Monospaced", Font.BOLD, 14));
		txtBtnCurrency.setBounds(39, 11, 168, 21);
		btnCurrency.add(txtBtnCurrency);
		
		btnExit = new JPanel();
		btnExit.setLayout(null);
		btnExit.setBackground(new Color(63, 63, 63));
		btnExit.setBounds(0, 267, 247, 43);
		navPanel.add(btnExit);
		
		txtBtnExit = new JLabel("Salir");
		txtBtnExit.setForeground(Color.WHITE);
		txtBtnExit.setFont(new Font("Monospaced", Font.BOLD, 14));
		txtBtnExit.setBounds(102, 11, 51, 21);
		btnExit.add(txtBtnExit);
		
		// Information panel
		
		infoPanel = new JPanel();
		infoPanel.setBackground(new Color(255, 255, 255));
		infoPanel.setBounds(245, 0, 534, 386);
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
		
		gitIcon = new JLabel();
		gitIcon.setIcon(new ImageIcon("src/main/java/img/githubIcon.png"));
		gitIcon.setHorizontalAlignment(SwingConstants.CENTER);
		gitIcon.setBounds(235, 304, 32, 33);
		infoPanel.add(gitIcon);
		
		linkIcon = new JLabel();
		linkIcon.setIcon(new ImageIcon("src/main/java/img/linkedinIcon.png"));
		linkIcon.setHorizontalAlignment(SwingConstants.CENTER);
		linkIcon.setBounds(296, 307, 32, 30);
		infoPanel.add(linkIcon);
		
		//  Class events
		
		btnTemp.addMouseListener(new MouseAdapter() {
			/**
			* Adds a mouse listener to the btnTemp component, which is triggered when the mouse is clicked on the component.
			* When triggered, it sets the visibility of the temperaturePanel to true, and the visibility of the infoPanel and currencyPanel to false.
			* It also sets the background color of btnTemp to white and the foreground color of txtBtnTem to black.
			* Additionally, it sets the background color of btnExit to a dark gray and the foreground color of txtBtnExit to a light gray.
			* Finally, it sets the background color of btnCurrency to a dark gray and the foreground color of txtBtnCurrency to a light gray,
			* and resets the currencyPanel to its initial state.
			* @param e the MouseEvent object representing the mouse click event
			*/
			@Override
			public void mouseClicked(MouseEvent e) {
				temperaturePanel.setVisible(true);
				currencyPanel.setVisible(false);
				infoPanel.setVisible(false);
				btnTemp.setBackground(Color.WHITE);
				txtBtnTemp.setForeground(Color.BLACK);
				btnExit.setBackground(new Color(63,63,63));
				txtBtnExit.setForeground(new Color(240,240,240));
				btnCurrency.setBackground(new Color(63,63,63));
				txtBtnCurrency.setForeground(new Color(240,240,240));
				currencyPanel.resetPanel();
			}
		});
		
		
		btnCurrency.addMouseListener(new MouseAdapter() {
			/**
			* Adds a mouse listener to the btnCurrency component, which is triggered when the mouse is clicked on the component.
			* When triggered, it sets the visibility of the currencyPanel to true, and the visibility of the infoPanel and temperaturePanel to false.
			* It also sets the background color of btnCurrency to white and the foreground color of txtBtnCurrency to black.
			* Additionally, it sets the background color of btnExit to a dark gray and the foreground color of txtBtnExit to a light gray.
			* Finally, it sets the background color of btnTemp to a dark gray and the foreground color of txtBtnTemp to a light gray,
			* and resets the temperaturePanel to its initial state.
			* @param e the MouseEvent object representing the mouse click event
			*/
			@Override
			public void mouseClicked(MouseEvent e) {
				currencyPanel.setVisible(true);
				infoPanel.setVisible(false);
				temperaturePanel.setVisible(false);
				btnCurrency.setBackground(Color.WHITE);
				txtBtnCurrency.setForeground(Color.BLACK);
				btnExit.setBackground(new Color(63,63,63));
				txtBtnExit.setForeground(new Color(240,240,240));
				btnTemp.setBackground(new Color(63,63,63));
				txtBtnTemp.setForeground(new Color(240,240,240));
				temperaturePanel.resetPanel();
			}
		});
		
		
		btnExit.addMouseListener(new MouseAdapter() {
			/**
			* Adds a mouse listener to the btnExit component, which is triggered when the mouse is clicked or pressed on the component.
			* When triggered by a mouse click, it exits the application with a status code of 0.
			* When triggered by a mouse press, it sets the background color of btnExit to white and the foreground color of txtBtnExit to black.
			* Additionally, it sets the background color of btnTemp and btnCurrency to a dark gray and the foreground color of txtBtnTemp and txtBtnCurrency to a light gray.
			* @param e the MouseEvent object representing the mouse event
			*/
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btnExit.setBackground(Color.WHITE);
				txtBtnExit.setForeground(Color.BLACK);
				btnTemp.setBackground(new Color(63,63,63));
				txtBtnTemp.setForeground(new Color(240,240,240));
				btnCurrency.setBackground(new Color(63,63,63));
				txtBtnCurrency.setForeground(new Color(240,240,240));
			}
		});
		
		
		gitIcon.addMouseListener(new MouseAdapter() {
			/**
			* Adds a mouse listener to the gitIcon component, which is triggered when the mouse is clicked on the component.
			* When triggered, it opens the specified URL, "https://github.com/A-Picasso", in the default web browser using the goToURL() method.
			* @param e the MouseEvent object representing the mouse click event
			*/
			@Override
			public void mouseClicked(MouseEvent e) {
				goToURL("https://github.com/A-Picasso");
			}
		});
		
		
		linkIcon.addMouseListener(new MouseAdapter() {
			/**
			* Adds a mouse listener to the linkIcon component, which is triggered when the mouse is clicked on the component.
			* When triggered, it opens the specified URL, "https://www.linkedin.com/in/jose-alberto-picasso-mtz/", in the default web browser using the goToURL() method.
			* @param e the MouseEvent object representing the mouse click event
			*/
			@Override
			public void mouseClicked(MouseEvent e) {
				goToURL("https://www.linkedin.com/in/jose-alberto-picasso-mtz/");
			}
		});
		
	}
	
	
	
	// Class methods
	
	
	/**
	 * Opens the specified URL in the default web browser on the user's system, if the Desktop API is supported.
	 * If the Desktop API is not supported or the BROWSE action is not supported, nothing happens.
	 * @param url the URL to open in the default web browser.
	*/
	public void goToURL( String url ) {
		if ( Desktop.isDesktopSupported() ) {
			Desktop desktop = Desktop.getDesktop();
			if ( desktop.isSupported(Action.BROWSE)) {
				try {
					URI uri = new URI(url);
					desktop.browse(uri);
				} catch (URISyntaxException | IOException ex) {
					JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
				}
			}
		}
	}

	
}
