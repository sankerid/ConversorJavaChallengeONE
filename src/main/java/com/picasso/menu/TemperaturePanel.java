package com.picasso.menu;

import java.awt.Color;
import java.awt.Font;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.picasso.methods.TemperatureConverter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class TemperaturePanel extends JPanel {
	private JLabel txtTitle, tempIcon, txtSubtitle, txtButton;
	private JSeparator separator, separator_1;
	private JTextField inputTemperature, outputTemperature;
	private JComboBox<String> cbFrom, cbTo;
	private String getCbFrom, getCbTo;
	private String[] temperatureUnits;
	private PanelRound btnConveter;

	/**
	 * Create the panel.
	 */
	public TemperaturePanel() {
		setBounds(229, 0, 534, 386);
		setLayout(null);
		setVisible(false);
		temperatureUnits = TemperatureConverter.getTempUnits();
		
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
		
		txtSubtitle = new JLabel("Valor en:");
		txtSubtitle.setFont(new Font("Monospaced", Font.BOLD, 16));
		txtSubtitle.setBounds(224, 158, 100, 14);
		add(txtSubtitle);
		
		txtSubtitle = new JLabel("Cambiar a:");
		txtSubtitle.setFont(new Font("Monospaced", Font.BOLD, 16));
		txtSubtitle.setBounds(224, 306, 100, 14);
		add(txtSubtitle);
		
		cbFrom = new JComboBox<String>();
		cbFrom.setBackground(new Color(0, 0, 0));
		cbFrom.setForeground(new Color(255, 255, 255));
		cbFrom.setBounds(110, 183, 130, 33);
		cbFrom.setModel( new DefaultComboBoxModel<String>( temperatureUnits ) );
		cbFrom.setSelectedIndex(0);
		add(cbFrom);
		
		inputTemperature = new JTextField();
		inputTemperature.setHorizontalAlignment(SwingConstants.CENTER);
		inputTemperature.setFont(new Font("Monospaced", Font.BOLD, 14));
		inputTemperature.setBounds(301, 182, 135, 33);
		add(inputTemperature);
		inputTemperature.setColumns(10);
		
		cbTo = new JComboBox<String>();
		cbTo.setForeground(Color.WHITE);
		cbTo.setBackground(Color.BLACK);
		cbTo.setBounds(107, 331, 130, 33);
		cbTo.setModel( new DefaultComboBoxModel<String>( temperatureUnits ) );
		cbTo.setSelectedIndex(1);
		add(cbTo);
		
		outputTemperature = new JTextField();
		outputTemperature.setEditable(false);
		outputTemperature.setHorizontalAlignment(SwingConstants.CENTER);
		outputTemperature.setFont(new Font("Monospaced", Font.BOLD, 14));
		outputTemperature.setColumns(10);
		outputTemperature.setBounds(301, 330, 135, 33);
		add(outputTemperature);
		
		btnConveter = new PanelRound();
		btnConveter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double getInput;
				try {
					getInput = Double.parseDouble(inputTemperature.getText());
					getCbFrom = temperatureUnits[ cbFrom.getSelectedIndex() ];
					getCbTo = temperatureUnits[ cbTo.getSelectedIndex() ];
					if ( getCbFrom != getCbTo ) {
						outputTemperature.setText(TemperatureConverter.convertTemperature(getCbFrom, getCbTo, getInput) + " " + getCbTo);	
					}else {
						JOptionPane.showMessageDialog(null, "Las unidades no pueden ser iguales", "Unidades iguales", WARNING_MESSAGE);
						inputTemperature.setText("");
						outputTemperature.setText("");
					}
				} catch (NumberFormatException n) {
					JOptionPane.showMessageDialog(null, "Solo se admiten valores numéricos", "Solo valores numéricos", WARNING_MESSAGE);
					inputTemperature.setText("");
				}
			}
		});
		btnConveter.setBackground(new Color(0, 0, 0));
		btnConveter.setBounds(190, 242, 154, 41);
		btnConveter.setRoundBottomLeft(25);
		btnConveter.setRoundBottomRight(25);
		btnConveter.setRoundTopLeft(25);
		btnConveter.setRoundTopRight(25);
		add(btnConveter);
		btnConveter.setLayout(null);
		
		
		txtButton = new JLabel("Convertir");
		txtButton.setBounds(33, 11, 90, 19);
		txtButton.setFont(new Font("Monospaced", Font.BOLD, 16));
		txtButton.setHorizontalAlignment(SwingConstants.CENTER);
		txtButton.setForeground(new Color(255, 255, 255));
		btnConveter.add(txtButton);
	}
	
	public void resetTemperaturePanel() {
		inputTemperature.setText("");
		outputTemperature.setText("");
		cbFrom.setSelectedIndex(0);
		cbTo.setSelectedIndex(1);
	}
	
}
