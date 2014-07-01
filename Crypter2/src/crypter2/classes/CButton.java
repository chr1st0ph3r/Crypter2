package crypter2.classes;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import crypter2.Crypter2;

public class CButton extends JButton
{
	private static final long serialVersionUID = 1L;

	public CButton()
	{
		super();
		
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setForeground(Crypter2.schemeColor);
		this.setBackground(Crypter2.backgroundColor);
		this.setFont(Crypter2.uiFont);
	}
}
