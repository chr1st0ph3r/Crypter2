package crypter2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import actions.CodeAction;
import actions.DecodeAction;

public class Crypter2 extends JFrame
{
	/*
	 * variables
	 */
	private static final long serialVersionUID = 1L;
	private static Crypter2 instance = null;
	
	private String[] letterList = {"A", "B", "C", "D", "E", "F", "G", "H", "I",
			"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
			"W", "X", "Y", "Z"};
	private String[] numberList = {"0", "1", "2", "3", "4", "5", "6", "7", "8",
			"9"};
	private Color[] colorList = {new Color(103, 173, 203), Color.PINK};
	
	/*
	 * swing components
	 */
	private JEditorPane inputArea = new JEditorPane();
	private JEditorPane outputArea = new JEditorPane();
	
	private JComboBox<String> codeLetterBox = new JComboBox<String>(letterList);
	private JComboBox<String> codeNumberBox = new JComboBox<String>(numberList);
	
	/*
	 * constructor
	 */
	private Crypter2()
	{
		super();
		initGui();
	}
	
	/*
	 * functions
	 */
	private void initGui()
	{
		// behavior
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// appearance
		this.setTitle("Crypter2");
		this.setSize(500, 300);
		this.setMinimumSize(new Dimension(400, 200));
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
		// look and feel
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		// content
		JButton codeButton = new JButton("Codieren");
		codeButton.addActionListener(new CodeAction());
		
		JButton decodeButton = new JButton("Decodieren");
		decodeButton.addActionListener(new DecodeAction());
		
		JLabel label = new JLabel("Code:");
		
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		controlPanel.setBackground(this.colorList[0]);
		controlPanel.add(codeButton);
		controlPanel.add(decodeButton);
		controlPanel.add(label);
		controlPanel.add(codeLetterBox);
		controlPanel.add(codeNumberBox);
		
		inputArea.setBorder(BorderFactory.createLineBorder(this.colorList[0], 2));
		inputArea.setEditable(true);
		
		outputArea.setBorder(BorderFactory.createLineBorder(this.colorList[0], 2));
		outputArea.setEditable(false);
		
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(1, 2));
		textPanel.setBackground(this.colorList[0]);
		textPanel.add(inputArea);
		textPanel.add(outputArea);
		
		this.add(controlPanel, BorderLayout.NORTH);
		this.add(textPanel, BorderLayout.CENTER);
	}
	
	public int getCode()
	{
		int offset = ((String)codeLetterBox.getSelectedItem()).charAt(0) - ((String)codeNumberBox.getSelectedItem()).charAt(0);
		return offset;
	}
	
	public String getInputText()
	{
		return this.inputArea.getText();
	}
	
	public void setOutputText(String input)
	{
		this.outputArea.setText(input);
	}
	
	public static Crypter2 getInstance()
	{
		if (instance == null)
		{
			instance = new Crypter2();
		}
		
		return instance;
	}
	
//	@Override
//	public void paint(Graphics g)
//	{
//		super.paint(g);
//		
//		System.out.println("" + this.getSize());
//	}
	
	/*
	 * main method
	 */
	public static void main(String[] args)
	{
		Crypter2 frame = Crypter2.getInstance();
		frame.setVisible(true);
	}
}
