package ver1.panel;

import javax.swing.JPanel;

import ver1.SandAnimation;

public class VisitAnimal extends JPanel{

	SandAnimation animation;
	JPanel innerP;
	
	public VisitAnimal() {
		initData();
		setInitLayout();
		addEventListener();
	}
	
	private void initData() {
		animation = new SandAnimation();
		innerP = new JPanel();
	}
	
	private void setInitLayout() {
		setLayout(null);
		innerP.setBounds(50, 50, 400, 100);
		innerP.add(animation);
		add(innerP);
	}
	
	private void addEventListener() {
		
	}
	
}
