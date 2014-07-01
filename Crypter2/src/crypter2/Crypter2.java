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

import crypter2.actions.CodeAction;
import crypter2.actions.DecodeAction;
import crypter2.classes.CButton;
import crypter2.classes.CComboBox;
import crypter2.classes.CLabel;

public class Crypter2 extends JFrame
{
	/*
	 * variables
	 */
	private static final long serialVersionUID = 1L;
	private static Crypter2 instance = null;
	
	public static Color schemeColor = new Color(103, 173, 203);
	
	private String[] letterList = {"A", "B", "C", "D", "E", "F", "G", "H", "I",
			"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
			"W", "X", "Y", "Z"};
	private String[] numberList = {"0", "1", "2", "3", "4", "5", "6", "7", "8",
			"9"};
	private Color[] colorList = {Color.WHITE, new Color(103, 173, 203), Color.LIGHT_GRAY, Color.PINK};
	
	/*
	 * swing components
	 */
	private JEditorPane inputArea = new JEditorPane();
	private JEditorPane outputArea = new JEditorPane();
	
	private JComboBox<String> codeLetterBox = new CComboBox(letterList);
	private JComboBox<String> codeNumberBox = new CComboBox(numberList);
	
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
		JButton codeButton = new CButton();
		codeButton.setText("Codieren");
		codeButton.addActionListener(new CodeAction());
		
		JButton decodeButton = new CButton();
		decodeButton.setText("Decodieren");
		decodeButton.addActionListener(new DecodeAction());
		
		JLabel label = new CLabel("Code:");
		
		JPanel codePanel = new JPanel();
		codePanel.setLayout(new FlowLayout());
		codePanel.setBackground(this.colorList[0]);
		codePanel.add(label);
		codePanel.add(this.codeLetterBox);
		codePanel.add(this.codeNumberBox);
		codePanel.add(codeButton);
		codePanel.add(decodeButton);
		
		this.inputArea.setBackground(this.colorList[0]);
//		this.inputArea.setBorder(BorderFactory.createLineBorder(this.colorList[0], 2));
		this.inputArea.setBorder(BorderFactory.createTitledBorder("Eingabe"));
		this.inputArea.setEditable(true);
		
		this.outputArea.setBackground(this.colorList[0]);
//		this.outputArea.setBorder(BorderFactory.createLineBorder(this.colorList[0], 2));
		this.outputArea.setBorder(BorderFactory.createTitledBorder("Ausgabe"));
		this.outputArea.setEditable(false);
		
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(1, 2));
		textPanel.setBackground(this.colorList[0]);
		textPanel.add(this.inputArea);
		textPanel.add(this.outputArea);
		
		this.add(codePanel, BorderLayout.NORTH);
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
		JFrame frame = Crypter2.getInstance();
		frame.setVisible(true);
	}
}
