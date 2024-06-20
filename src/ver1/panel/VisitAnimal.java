package ver1.panel;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import ver1.SandAnimation;

public class VisitAnimal extends JPanel{
	
	SandAnimation animation;
	JPanel innerP;
	
	private JLabel imgBox;
	
	public VisitAnimal() {
		initData();
		setInitLayout();
		addEventListener();
	}
	
	private void initData() {
		animation = new SandAnimation();
		innerP = new JPanel();
		imgBox = new JLabel(new ImageIcon("img/dog.jpg"));
	}
	
	private void setInitLayout() {
		setLayout(null);
		innerP.setBounds(50, 50, 400, 100);
		innerP.add(animation);
		add(innerP);
		
		imgBox.setBounds(270, 150, 609, 450);
		imgBox.setBorder(new LineBorder(Color.GRAY, 2));
		add(imgBox);
	}
	
	private void addEventListener() {
		
	}
	
}
