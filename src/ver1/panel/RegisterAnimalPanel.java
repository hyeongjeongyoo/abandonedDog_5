package ver1.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class RegisterAnimalPanel extends JPanel {
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
	private JTextField boxEmp1;
	private JButton search;

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
	private Font font;
	private Font font2;

	public RegisterAnimalPanel() {
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
		innerPanel.setBounds(110, 13, 900, 500);
		innerPanel.setBorder(new TitledBorder(new LineBorder(new Color(13, 170, 93), 3), null));
		innerPanel.setBackground(Color.white);
		innerPanel.setLayout(null);

		textId = new JTextField(20);
		boxKind = new JComboBox<>(new String[] { "강아지", "고양이" });
		textColor = new JTextField(20);
		textAge = new JTextField(20);
		textWeight = new JTextField(20);
		boxSex = new JComboBox<>(new String[] { "수컷", "암컷" });
		boxNeuter = new JComboBox<>(new String[] { "Y", "N", "U" });
		textSpecialMark = new JTextField(20);
		boxEmp1 = new JTextField(20);

		labelId = new JLabel("아이디");
		innerPanel.add(labelId);
		innerPanel.add(textId);
		labelId.setBounds(50, 10, 120, 100);
		textId.setBounds(120, 40, 200, 35);

		labelKind = new JLabel("품종");
		innerPanel.add(labelKind);
		innerPanel.add(boxKind);
		labelKind.setBounds(410, 10, 120, 100);
		boxKind.setBounds(480, 40, 200, 35);

		labelColor = new JLabel("색깔");
		innerPanel.add(labelColor);
		innerPanel.add(textColor);
		labelColor.setBounds(50, 60, 120, 100);
		textColor.setBounds(120, 90, 200, 35);

		labelAge = new JLabel("나이");
		innerPanel.add(labelAge);
		innerPanel.add(textAge);
		labelAge.setBounds(410, 60, 120, 100);
		textAge.setBounds(480, 90, 200, 35);

		labelWeight = new JLabel("무게");
		innerPanel.add(labelWeight);
		innerPanel.add(textWeight);
		labelWeight.setBounds(50, 110, 120, 100);
		textWeight.setBounds(120, 140, 200, 35);

		labelSex = new JLabel("성별");
		innerPanel.add(labelSex);
		innerPanel.add(boxSex);
		labelSex.setBounds(410, 110, 120, 100);
		boxSex.setBounds(480, 145, 200, 35);

		labelNeuter = new JLabel("중성화");
		innerPanel.add(labelNeuter);
		innerPanel.add(boxNeuter);
		labelNeuter.setBounds(50, 160, 120, 100);
		boxNeuter.setBounds(120, 190, 200, 35);

		labelSpecialMark = new JLabel("첨가말");
		innerPanel.add(labelSpecialMark);
		innerPanel.add(textSpecialMark);
		labelSpecialMark.setBounds(410, 160, 120, 100);
		textSpecialMark.setBounds(480, 195, 200, 35);

		labelEmp = new JLabel("소속보호소");
		innerPanel.add(labelEmp);
		innerPanel.add(boxEmp1);
		labelEmp.setBounds(50, 210, 200, 100);
		boxEmp1.setBounds(120, 245, 199, 35);
		boxEmp1.setEditable(false);
		add(innerPanel);
		add(innerPanel, BorderLayout.CENTER);
		
		search = new JButton(new ImageIcon("img/magnifier.png"));
		innerPanel.add(search);
		search.setBounds(330, 245, 34, 34);
		add(innerPanel);
		search.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 마우스 커서 모양 변경

		btn = new JButton(new ImageIcon("img/registerBtn.jpg"));
		mainPanel.add(btn);
		btn.setBounds(950, 560, 60, 30);
		add(btn);
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 마우스 커서 모양 변경

		font = new Font("Noto Sans KR", Font.BOLD, 14);
		font2 = new Font("Noto Sans KR", Font.PLAIN, 14);
		labelId.setFont(font);
		labelKind.setFont(font);
		labelColor.setFont(font);
		labelAge.setFont(font);
		labelWeight.setFont(font);
		labelSex.setFont(font);
		labelNeuter.setFont(font);
		labelSpecialMark.setFont(font);
		labelEmp.setFont(font);
		boxSex.setFont(font2);
		boxKind.setFont(font2);
		boxNeuter.setFont(font2);
		boxEmp1.setFont(font2);
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
	            String emp1 = boxEmp1.getText();
		});
		search.addActionListener(e -> {
			 String input = JOptionPane.showInputDialog("보호소 아이디를 입력하세요");
			    if (input != null) {
			        boxEmp1.setText(input);
			    }
		});
	}

	private void updateTable() {
		// 테이블 업데이트 관련 로직 추가
	}

}