package crypter2.classes;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;

import crypter2.Crypter2;

public class CTitledBorder extends TitledBorder
{
	private static final long serialVersionUID = 1L;

	public CTitledBorder(String title)
	{
		super(title);
		
		this.setTitleFont(Crypter2.uiFontSmall);
		this.setTitleColor(Crypter2.schemeColor);
		this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
	}

}
