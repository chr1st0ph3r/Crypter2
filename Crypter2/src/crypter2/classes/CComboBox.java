package crypter2.classes;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;

import crypter2.Crypter2;

public class CComboBox extends JComboBox<String>
{
	private static final long serialVersionUID = 1L;

	public CComboBox(String[] items)
	{
		super(items);
		
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setForeground(Crypter2.schemeColor);
	}
}
