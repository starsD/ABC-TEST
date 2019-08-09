import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainUI1 extends JFrame{
	public MainUI1() {
		super("ABC Tools");
		initUI();
	}
	private void initUI() {
//		this.setBounds(320, 55, 700, 630);
		layoutUI();
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	
	private void layoutUI() {
		this.setLayout(new BorderLayout(2, 10));
		
		JPanel panelTitle = new JPanel(new GridLayout(0,3,2,50));
		JLabel empty = new JLabel(" ",JLabel.CENTER);
		JLabel labelUserid = new JLabel("USERID",JLabel.CENTER);
		JLabel labelName = new JLabel("Name",JLabel.CENTER);
		panelTitle.add(empty);
		panelTitle.add(labelUserid);
		panelTitle.add(labelName);
		
		this.add(panelTitle, BorderLayout.NORTH);


		
		JPanel panelContent = new JPanel(new GridLayout(2,3,2,50));
		JLabel labelAli = new JLabel("支付宝",JLabel.CENTER);
		JTextField textUseridAli = new JTextField(22);
		JTextField textNameAli = new JTextField(22);
		JLabel labelWx = new JLabel("微信",JLabel.CENTER);
		JTextField textUseridWx = new JTextField(22);
		JTextField textNameWx = new JTextField(22);
		panelContent.add(labelAli);
		panelContent.add(textUseridAli);
		panelContent.add(textNameAli);
		panelContent.add(labelWx);
		panelContent.add(textUseridWx);
		panelContent.add(textNameWx);

		
		this.add(panelContent, BorderLayout.CENTER);

		
		JPanel panelButton = new JPanel(new FlowLayout(FlowLayout.CENTER,50,10));
		JButton setInfo = new JButton("查询");
		JButton queryInfo = new JButton("设置");
		panelButton.add(setInfo);

		panelButton.add(queryInfo);
		
		this.add(panelButton, BorderLayout.SOUTH);


		
		
	
	}
	
	public static void main(String [] args) {
		MainUI1 ui = new MainUI1();
	}

}
