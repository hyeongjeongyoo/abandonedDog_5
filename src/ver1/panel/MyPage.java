package ver1.panel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class MyPage extends JPanel {

	private JPanel selfImagePanel;
	private JPanel interestPat;
	private JPanel myWriter;
	
	public MyPage() {
		initDate();
		setInitLayout();
		addEventListener();
	}
	
	private void initDate() {
		
		selfImagePanel = new JPanel();
		interestPat = new JPanel();
		myWriter = new JPanel();
		
	}
	
	private void setInitLayout() {
		setLayout(null);
		setBackground(Color.white);
		
		selfImagePanel.setBounds(50, 30, 200, 250);
		selfImagePanel.setBackground(Color.white);
		selfImagePanel.setBorder(new TitledBorder(new LineBorder(new Color(13, 170, 93), 3), null));
		add(selfImagePanel);
		
		interestPat.setBounds(50, 330, 600, 390);
		interestPat.setBackground(Color.white);
		interestPat.setBorder(new TitledBorder(new LineBorder(new Color(13, 170, 93), 3), null));
		add(interestPat);
		
		myWriter.setBounds(730, 330, 600, 390);
		myWriter.setBackground(Color.white);
		myWriter.setBorder(new TitledBorder(new LineBorder(new Color(13, 170, 93), 3), null));
		add(myWriter);
	}
	
	private void addEventListener() {
		
	}
}
