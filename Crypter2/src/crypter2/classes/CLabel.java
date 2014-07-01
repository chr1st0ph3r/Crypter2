package crypter2.classes;

import javax.swing.JLabel;

import crypter2.Crypter2;

public class CLabel extends JLabel
{
	private static final long serialVersionUID = 1L;
	
	public CLabel(String text)
	{
		super(text);
		
		this.setForeground(Crypter2.schemeColor);
		this.setBackground(Crypter2.neutralColor);
		this.setFont(Crypter2.uiFont);
	}

}
