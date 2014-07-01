package crypter2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import crypter2.actions.CodeAction;
import crypter2.actions.DecodeAction;
import crypter2.classes.CTitledBorder;

public class Crypter2 extends JFrame
{
	/*
	 * variables
	 */
	private static final long serialVersionUID = 1L;
	private static Crypter2 instance = null;
	
	public static Color schemeColor = new Color(16, 78, 139);
	public static Color backgroundColor = Color.WHITE; // new Color(104, 177, 237);
	public static Color neutralColor = Color.WHITE;
	
	public static Font uiFont = new Font("SansSerif", Font.BOLD, 13);
	public static Font uiFontSmall = new Font("SansSerif", Font.PLAIN, 12);
	
	private String[] letterList = {"A", "B", "C", "D", "E", "F", "G", "H", "I",
			"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
			"W", "X", "Y", "Z"};
	private String[] numberList = {"0", "1", "2", "3", "4", "5", "6", "7", "8",
			"9"};
	
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
		this.setMinimumSize(new Dimension(420, 210));
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
		// look and feel
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		// content
		codeLetterBox.setForeground(Crypter2.schemeColor);
		codeLetterBox.setFont(Crypter2.uiFont);
		
		codeNumberBox.setForeground(Crypter2.schemeColor);
		codeNumberBox.setFont(Crypter2.uiFont);
		
		JButton codeButton = new JButton();
		codeButton.setBorder(BorderFactory.createEmptyBorder());
		codeButton.setForeground(Crypter2.schemeColor);
//		codeButton.setBackground(Crypter2.backgroundColor);
		codeButton.setFont(Crypter2.uiFont);
//		codeButton.setText("Codieren");
		codeButton.setIcon(new ImageIcon(getClass().getResource("/crypter2/resources/lock-32.gif")));
		codeButton.addActionListener(new CodeAction());
		
		JButton decodeButton = new JButton();
		decodeButton.setBorder(BorderFactory.createEmptyBorder());
		decodeButton.setForeground(Crypter2.schemeColor);
//		decodeButton.setBackground(Crypter2.backgroundColor);
		decodeButton.setFont(Crypter2.uiFont);
//		decodeButton.setText("Decodieren");
		decodeButton.setIcon(new ImageIcon(getClass().getResource("/crypter2/resources/unlock-32.gif")));
		decodeButton.addActionListener(new DecodeAction());
		
		JLabel label = new JLabel("Code");
		label.setForeground(Crypter2.schemeColor);
//		label.setBackground(Crypter2.neutralColor);
		label.setFont(Crypter2.uiFont);
		
		JPanel codePanel = new JPanel();
		codePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		codePanel.setBackground(Crypter2.backgroundColor);
//		codePanel.add(label);
		codePanel.add(this.codeLetterBox);
		codePanel.add(this.codeNumberBox);
		codePanel.add(codeButton);
		codePanel.add(decodeButton);
		
//		this.inputArea.setBackground(neutralColor);
		this.inputArea.setBorder(new CTitledBorder("Eingabe"));
		this.inputArea.setEditable(true);
		
//		this.outputArea.setBackground(neutralColor);
		this.outputArea.setBorder(new CTitledBorder("Ausgabe"));
		this.outputArea.setEditable(false);
		
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(1, 2));
//		textPanel.setBackground(Crypter2.backgroundColor);
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
