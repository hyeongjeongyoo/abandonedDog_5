package ver1.panel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class AbanAnimalList extends JPanel {

	private JTextField searchText;
	private JButton searchBtn;
	
	private JPanel petImage;
	private JPanel myWriter;

	public AbanAnimalList() {
		initData();
		setInitLayout();
		addEventLayout();
	}

	public void initData() {
		searchText = new JTextField();
		searchBtn = new JButton("검색");
		
		petImage = new JPanel();
		myWriter = new JPanel();
	}

	public void setInitLayout() {
		setLayout(null);
		setBackground(Color.white);
		
		searchText.setBounds(895, 700, 200, 22);
		add(searchText);

		searchBtn.setBounds(1099, 700, 59, 20);
		add(searchBtn);
		
		petImage.setBounds(30, 13, 400, 600);
		petImage.setBackground(Color.white);
		petImage.setBorder(new TitledBorder(new LineBorder(new Color(13, 170, 93), 3), null));
		add(petImage);
		
		myWriter.setBounds(400, 13, 790, 600);
		myWriter.setBackground(Color.white);
		myWriter.setBorder(new TitledBorder(new LineBorder(new Color(13, 170, 93), 3), null));
		add(myWriter);
	}

	public void addEventLayout() {
		
	}
}