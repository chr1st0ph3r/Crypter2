package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class DecodeAction extends AbstractAction
{
	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Decode!");
	}

}
