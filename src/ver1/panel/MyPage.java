package ver1.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import ver1.frame.BoardFrame;

public class MyPage extends JPanel {
	
	private BoardFrame mContext;

	private JPanel selfImagePanel;
	private JPanel showInfo;
	private JPanel interestPet;
	private JPanel myWriter;
	
	private Image info;

	public MyPage(BoardFrame mContext) {
		this.mContext = mContext;
		initDate();
		setInitLayout();
		addEventListener();
	}

	private void initDate() {
		
		if(mContext.manager) {
			info = new ImageIcon("img/Manager.jpg").getImage();
		} else {
			info = new ImageIcon("img/Common.jpg").getImage();
		}

		selfImagePanel = new JPanel();
		showInfo = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(info, 0, 0, getWidth(), getHeight(), this);
			}
		};
		interestPet = new JPanel();
		myWriter = new JPanel();

	}

	private void setInitLayout() {
		setLayout(null);
		setBackground(Color.white);

		selfImagePanel.setBounds(50, 70, 200, 250);
		selfImagePanel.setBackground(Color.white);
		selfImagePanel.setBorder(new TitledBorder(new LineBorder(new Color(13, 170, 93), 3), null));
		add(selfImagePanel);

		if(mContext.manager) {
			showInfo.setBounds(110, 0, 1000, 300);
		} else {
			showInfo.setBounds(110, 0, 1200, 600);
		}
		
		showInfo.setBackground(Color.white);
		add(showInfo);

		interestPet.setBounds(50, 410, 600, 330);
		interestPet.setBackground(Color.white);
		interestPet.setBorder(new TitledBorder(new LineBorder(new Color(13, 170, 93), 3), null));
		add(interestPet);

		myWriter.setBounds(730, 410, 600, 330);
		myWriter.setBackground(Color.white);
		myWriter.setBorder(new TitledBorder(new LineBorder(new Color(13, 170, 93), 3), null));
		add(myWriter);
	}

	private void addEventListener() {

	}
}
