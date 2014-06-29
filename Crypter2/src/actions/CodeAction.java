package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import crypter2.Crypter2;

public class CodeAction extends AbstractAction
{
	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String text = Crypter2.getInstance().getInputText();
		Crypter2.getInstance().setOutputText(text);
		
		System.out.println("CodeAction");
	}
}
