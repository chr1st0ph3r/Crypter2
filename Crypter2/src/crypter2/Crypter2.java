package crypter2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
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
	
	private Color background = new Color(103, 173, 203);
	
	private String[] letterList = {"A", "B", "C", "D", "E", "F", "G", "H", "I",
			"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
			"W", "X", "Y", "Z"};
	private String[] numberList = {"0", "1", "2", "3", "4", "5", "6", "7", "8",
			"9"};
	
	/*
	 * swing components
	 */
	private JTextPane inputArea = new JTextPane();
	private JTextPane outputArea = new JTextPane();
	
	/*
	 * constructor
	 */
	private Crypter2()
	{
		super();
		initGui();
	}
	
	/*
	 * functoins
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
		
		JLabel label = new JLabel("Codierung:");
		JComboBox<String> codeLetter = new JComboBox<String>(letterList);
		JComboBox<String> codeNumber = new JComboBox<String>(numberList);
		
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		controlPanel.setBackground(this.background);
		controlPanel.add(codeButton);
		controlPanel.add(decodeButton);
		controlPanel.add(label);
		controlPanel.add(codeLetter);
		controlPanel.add(codeNumber);
		
		inputArea.setBorder(BorderFactory.createLineBorder(this.background, 2));
		inputArea.setEditable(true);
		
		outputArea.setBorder(BorderFactory.createLineBorder(this.background, 2));
		outputArea.setEditable(false);
		
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(1, 2));
		textPanel.setBackground(this.background);
		textPanel.add(inputArea);
		textPanel.add(outputArea);
		
		this.add(controlPanel, BorderLayout.NORTH);
		this.add(textPanel, BorderLayout.CENTER);
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
