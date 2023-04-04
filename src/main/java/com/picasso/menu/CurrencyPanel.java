package com.picasso.menu;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.picasso.interfaces.IReset;
import com.picasso.methods.ExchangeApiRequest;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import static javax.swing.JOptionPane.WARNING_MESSAGE;

public class CurrencyPanel extends JPanel implements IReset {
	
	private static final long serialVersionUID = 1L;
	private JTextField inputCurrency, outputCurrency;
	private JSeparator separator, separator_1;
	private JLabel txtTitle, txtSubtitle, currencyIcon, txtButton;
	private JComboBox<String> cbFrom, cbTo;
	private PanelRound btnConveter;
	private List<String[]> currencySymbols;
	private String getCbFrom, getCbTo;

	public CurrencyPanel() {
		setBounds(235, 0, 544, 386);
		setLayout(null);
		setVisible(false);
		currencySymbols = ExchangeApiRequest.getSymbolsRequest();
		
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
		
		cbFrom = new JComboBox<String>();
		cbFrom.setBackground(new Color(0, 0, 0));
		cbFrom.setForeground(new Color(255, 255, 255));
		cbFrom.setBounds(77, 189, 193, 33);
		cbFrom.setModel( new DefaultComboBoxModel<>(currencySymbols.get(1)) );
		cbFrom.setSelectedIndex(7);
		add(cbFrom);
		
		inputCurrency = new JTextField();
		inputCurrency.setHorizontalAlignment(SwingConstants.CENTER);
		inputCurrency.setFont(new Font("Monospaced", Font.BOLD, 14));
		inputCurrency.setBounds(319, 188, 154, 33);
		add(inputCurrency);
		inputCurrency.setColumns(10);
		
		cbTo = new JComboBox<String>();
		cbTo.setForeground(Color.WHITE);
		cbTo.setBackground(Color.BLACK);
		cbTo.setBounds(77, 317, 193, 33);
		cbTo.setModel( new DefaultComboBoxModel<>(currencySymbols.get(1)) );
		cbTo.setSelectedIndex(50);
		add(cbTo);
		
		outputCurrency = new JTextField();
		outputCurrency.setHorizontalAlignment(SwingConstants.CENTER);
		outputCurrency.setEditable(false);
		outputCurrency.setFont(new Font("Monospaced", Font.BOLD, 14));
		outputCurrency.setColumns(10);
		outputCurrency.setBounds(319, 316, 154, 33);
		add(outputCurrency);
		
		txtSubtitle = new JLabel("Cambiar de:");
		txtSubtitle.setFont(new Font("Monospaced", Font.BOLD, 16));
		txtSubtitle.setBounds(231, 164, 118, 14);
		add(txtSubtitle);
		
		txtSubtitle = new JLabel("Cambiar a:");
		txtSubtitle.setFont(new Font("Monospaced", Font.BOLD, 16));
		txtSubtitle.setBounds(231, 292, 108, 14);
		add(txtSubtitle);
		
		currencyIcon = new JLabel();
		currencyIcon.setHorizontalAlignment(SwingConstants.CENTER);
		currencyIcon.setIcon(new ImageIcon("src/main/java/img/currencyIcon.png"));
		currencyIcon.setBounds(62, 22, 108, 109);
		add(currencyIcon);
		
		btnConveter = new PanelRound();
		btnConveter.setBackground(new Color(0, 0, 0));
		btnConveter.setBounds(213, 240, 154, 41);
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
			 * Event that is executed when clicking on the "Convert" button and performs the conversion of the amount
			 * entered in the selected currency to the target currency, and displays the result in the corresponding field.
			 * If the selected units are the same or the amount is negative, it displays an error message.
			 * @param e Mouse event when clicking on the "Convert" button
			*/
			@Override
			public void mouseClicked(MouseEvent e) {
				double amount;
				try {
					getCbFrom = currencySymbols.get(0)[cbFrom.getSelectedIndex()];
					getCbTo = currencySymbols.get(0)[cbTo.getSelectedIndex()];
					amount = Double.parseDouble(inputCurrency.getText());
					if ( getCbFrom != getCbTo && amount >= 0  ) {
						amount = ExchangeApiRequest.getCurrencyRequest(getCbFrom, getCbTo, amount);
						DecimalFormat df = new DecimalFormat("#0.00");
						outputCurrency.setText(df.format(amount) + " " + getCbTo);
					}else if( getCbFrom == getCbTo ) {
						JOptionPane.showMessageDialog(null, "Las unidades no pueden ser iguales", "Divisas iguales", WARNING_MESSAGE);
					}else if ( amount < 0 ) {
						JOptionPane.showMessageDialog(null, "La cantidad tiene que ser mayor o igual a 0", "Unidades del mismo valor", WARNING_MESSAGE);
					}
				} catch (NumberFormatException n) {
					JOptionPane.showMessageDialog( null, "Solo se admiten valores numéricos", "Solo valores numéricos", WARNING_MESSAGE);
					inputCurrency.setText("");
				}
			}
		});
	}
	
	// Class methods
	

	/**
	 * Resets the CurrencyPanel to its initial state.
	 * Sets the input and output fields to an empty string.
	 * Sets the selected items of the "From" and "To" currency comboboxes to default values.
	*/
	@Override
	public void resetPanel() {
		inputCurrency.setText("");
		outputCurrency.setText("");
		cbFrom.setSelectedIndex(7);
		cbTo.setSelectedIndex(50);
	}
	
}