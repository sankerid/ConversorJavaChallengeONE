package com.picasso.menu;

import java.awt.Color;
import java.awt.Font;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.picasso.interfaces.IReset;
import com.picasso.methods.TemperatureConverter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TemperaturePanel extends JPanel implements IReset {
	
	private static final long serialVersionUID = 1L;
	private JLabel txtTitle, tempIcon, txtSubtitle, txtButton;
	private JSeparator separator, separator_1;
	private JTextField inputTemperature, outputTemperature;
	private JComboBox<String> cbFrom, cbTo;
	private String getCbFrom, getCbTo;
	private String[] temperatureUnits;
	private DefaultListCellRenderer listRenderer;
	private PanelRound btnConveter;
	
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
		tempIcon.setIcon(new ImageIcon("src/main/java/img/temperatureIcon.png"));
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
		listRenderer = new DefaultListCellRenderer();
		listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		cbFrom.setRenderer(listRenderer);
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
		listRenderer = new DefaultListCellRenderer();
		listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		cbTo.setRenderer(listRenderer);
		add(cbTo);
		
		outputTemperature = new JTextField();
		outputTemperature.setEditable(false);
		outputTemperature.setHorizontalAlignment(SwingConstants.CENTER);
		outputTemperature.setFont(new Font("Monospaced", Font.BOLD, 14));
		outputTemperature.setColumns(10);
		outputTemperature.setBounds(301, 330, 135, 33);
		add(outputTemperature);
		
		btnConveter = new PanelRound();
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
		
		//  Class events
		
		btnConveter.addMouseListener(new MouseAdapter() {
			/**
			 * Adds a mouse listener to the btnConvert component, which is triggered when the mouse is clicked on the component.
			 * When triggered, it performs the following actions:
			 	* Gets the value of the inputTemperature component and converts it to a double using Double.parseDouble().
			 	* Gets the selected index values of the cbFrom and cbTo components, and uses them to retrieve the corresponding temperature units from the temperatureUnits array.
			 	* If the selected temperature units are not the same, it calls the TemperatureConverter.convertTemperature() method to convert the input temperature to the desired temperature unit and displays the result in the outputTemperature component.
			 	* If the selected temperature units are the same, it displays an error message using JOptionPane.showMessageDialog() and resets the inputTemperature and outputTemperature components to empty strings.
			 	* If the input temperature value is not a valid number, it displays an error message using JOptionPane.showMessageDialog() and resets the inputTemperature component to an empty string.
			 * @param e the MouseEvent object representing the mouse click event 
			*/
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
	}
	
	// Class methods
	
	/**
	 * Resets the TemperaturePanel to its initial state.
	 * Sets the input and output fields to an empty string.
	 * Sets the selected items of the "From" and "To" currency comboboxes to default values.
	*/
	@Override
	public void resetPanel() {
		inputTemperature.setText("");
		outputTemperature.setText("");
		cbFrom.setSelectedIndex(0);
		cbTo.setSelectedIndex(1);
	}
	
}
