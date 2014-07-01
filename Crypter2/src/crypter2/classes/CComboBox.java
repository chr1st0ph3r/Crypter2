package crypter2.classes;

import javax.swing.JComboBox;

import crypter2.Crypter2;

public class CComboBox extends JComboBox<String>
{
	private static final long serialVersionUID = 1L;

	public CComboBox(String[] items)
	{
		super(items);
		
		this.setForeground(Crypter2.schemeColor);
		this.setBackground(Crypter2.neutralColor);
		this.setFont(Crypter2.uiFont);
	}
}
