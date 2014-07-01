package crypter2.classes;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import crypter2.Crypter2;

public class CLabel extends JLabel
{
	private static final long serialVersionUID = 1L;
	
	public CLabel(String text)
	{
		super(text);
		
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setForeground(Crypter2.schemeColor);
	}

}
