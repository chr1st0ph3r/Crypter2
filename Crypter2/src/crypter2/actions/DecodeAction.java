package crypter2.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import crypter2.Crypter2;

public class DecodeAction extends AbstractAction
{
	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String text = Crypter2.getInstance().getInputText();
		int code = Crypter2.getInstance().getCode();
		
		String decoded = "";
		for (int i = 0; i < text.length(); ++i)
		{
			int token = (int)text.charAt(i) - code;
			if (token < 33)
			{
				token += 95;
			}
			decoded += (char)token;
		}
		Crypter2.getInstance().setOutputText(decoded);
	}

}
