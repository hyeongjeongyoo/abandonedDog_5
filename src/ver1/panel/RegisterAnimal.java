package ver1.panel;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

public class RegisterAnimal extends JPanel {
	private JPanel mainPanel;
	private JPanel innerPanel;

	private JTextField textId;
	private JComboBox<String> boxKind;
	private JTextField textColor;
	private JTextField textAge;
	private JTextField textWeight;
	private JComboBox<String> boxSex;
	private JComboBox<String> boxNeuter;
	private JTextField textSpecialMark;
	private JRadioButton boxEmp1;
	private JRadioButton boxEmp2;

	private JLabel labelId;
	private JLabel labelKind;
	private JLabel labelColor;
	private JLabel labelAge;
	private JLabel labelWeight;
	private JLabel labelSex;
	private JLabel labelNeuter;
	private JLabel labelSpecialMark;
	private JLabel labelEmp;

	private JButton btn;

	
	public RegisterAnimal() {
		initData();
		addEventListener();
		updateTable();
		
	}

	private void initData() {
		setLayout(null);
		setBackground(Color.white);
	    
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		innerPanel = new JPanel();
		innerPanel.setBounds(100, 50, 900, 500);
		innerPanel.setBorder(new LineBorder(Color.BLACK));
		
		innerPanel.setLayout(null);

		
		textId = new JTextField(20);
		boxKind = new JComboBox<>(new String[]{"강아지", "고양이"});
		textColor = new JTextField(20);
		textAge = new JTextField(20);
		textWeight = new JTextField(20);
		boxSex = new JComboBox<>(new String[]{"수컷", "암컷"});
		boxNeuter = new JComboBox<>(new String[] {"Y", "N", "U"});
		textSpecialMark = new JTextField(20);
		boxEmp1 = new JRadioButton("선택1");
		boxEmp2 = new JRadioButton("선택2");

		labelId = new JLabel("아이디");
		innerPanel.add(labelId);
		innerPanel.add(textId);
		labelId.setBounds(50, 10, 50, 40);
		textId.setBounds(100, 10, 100, 30);

		labelKind = new JLabel("품종");
		innerPanel.add(labelKind);
		innerPanel.add(boxKind);
		labelKind.setBounds(50, 60, 500, 40);
		boxKind.setBounds(100, 60, 500, 30);
		

		labelColor = new JLabel("색깔");
		innerPanel.add(labelColor);
		innerPanel.add(textColor);
		labelColor.setBounds(50, 110, 500, 40);
		textColor.setBounds(100, 110, 500, 30);

		labelAge = new JLabel("나이");
		innerPanel.add(labelAge);
		innerPanel.add(textAge);
		labelAge.setBounds(50, 160, 500, 40);
		textAge.setBounds(100, 160, 500, 30);

		labelWeight = new JLabel("무게");
		innerPanel.add(labelWeight);
		innerPanel.add(textWeight);
		labelWeight.setBounds(50, 210, 500, 40);
		textWeight.setBounds(100, 210, 500, 30);

		labelSex = new JLabel("성별");
		innerPanel.add(labelSex);
		innerPanel.add(boxSex);
		labelSex.setBounds(50, 260, 500, 40);
		boxSex.setBounds(100, 260, 500, 30);

		labelNeuter = new JLabel("중성화");
		innerPanel.add(labelNeuter);
		innerPanel.add(boxNeuter);
		labelNeuter.setBounds(50, 310, 500, 40);
		boxNeuter.setBounds(100, 310, 500, 30);

		labelSpecialMark = new JLabel("첨가말");
		innerPanel.add(labelSpecialMark);
		innerPanel.add(textSpecialMark);
		labelSpecialMark.setBounds(50, 360, 500, 40);
		textSpecialMark.setBounds(100, 360, 500, 30);

		labelEmp = new JLabel("소속보호소");
		innerPanel.add(labelEmp);
		innerPanel.add(boxEmp1);
		innerPanel.add(boxEmp2);
		labelEmp.setBounds(50, 410, 500, 40);
		boxEmp1.setBounds(130, 415, 70, 30);
		boxEmp2.setBounds(200, 415, 70, 30);

		add(innerPanel);
		add(innerPanel, BorderLayout.CENTER);

		btn = new JButton("등록");
		mainPanel.add(btn);
		btn.setBounds(1099, 550, 60, 30);
		add(btn);
	
	}

	private void addEventListener() {
		btn.addActionListener(e -> {
			 String id = textId.getText();
	            String kind = (String) boxKind.getSelectedItem();
	            String color = textColor.getText();
	            String age = textAge.getText();
	            String weight = textWeight.getText();
	            String sex = (String) boxSex.getSelectedItem();
	            String neuter = (String) boxNeuter.getSelectedItem();
	            String specialMark = textSpecialMark.getText();
	            String emp1 = boxEmp1.isSelected() ? "사용함" : "사용안함";
	            String emp2 = boxEmp2.isSelected() ? "사용함" : "사용안함";
		});
	}

	private void updateTable() {
		// 테이블 업데이트 관련 로직 추가
	}

}