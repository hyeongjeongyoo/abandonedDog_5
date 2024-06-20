package ver1.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class ApplyAdoptBoard extends JPanel {

	private JPanel innerPanel;
	private JTextField textFieldName;
	private JTextField textFieldAddress;
	private JTextField textFieldNumber;
	private JTextField textFieldEmail;
	private JComboBox<String> comboBoxAnimalType;
	private JButton btnSubmit;

	private JLabel labelName;
	private JLabel labelAddress;
	private JLabel labelNumber;
	private JLabel labelEmail;
	private JLabel labelAnimalType;

	private Font font;

	public ApplyAdoptBoard() {
		initData();
		setInitLayout();
		addEventLayout();
	}

	public void initData() {

		innerPanel = new JPanel();
		innerPanel.setBorder(new LineBorder(Color.black));

		labelName = new JLabel("이름:");
		textFieldName = new JTextField(20);

		labelAddress = new JLabel("주소:");
		textFieldAddress = new JTextField(20);

		labelNumber = new JLabel("번호:");
		textFieldNumber = new JTextField(20);

		labelEmail = new JLabel("이메일:");
		textFieldEmail = new JTextField(20);

		// 동물 정보 선택 콤보박스 추가
		labelAnimalType = new JLabel("동물 타입:");
		String[] animalTypes = { "고양이", "개", "기타" };
		comboBoxAnimalType = new JComboBox<>(animalTypes);

		btnSubmit = new JButton("신청");

		// Font 설정
		font = new Font("Noto Sans KR", Font.PLAIN, 14);
		labelName.setFont(font);
		textFieldName.setFont(font);
		labelAddress.setFont(font);
		labelNumber.setFont(font);
		labelEmail.setFont(font);
		labelAnimalType.setFont(font);
		textFieldAddress.setFont(font);
		textFieldNumber.setFont(font);
		textFieldEmail.setFont(font);
		comboBoxAnimalType.setFont(font);
	}

	public void setInitLayout() {
		setLayout(null);
		innerPanel.setLayout(null);
		innerPanel.setBounds(100, 50, 980, 450);

		labelName.setBounds(50, 10, 120, 100);
		textFieldName.setBounds(90, 40, 180, 35);

		labelAddress.setBounds(290, 10, 120, 100);
		textFieldAddress.setBounds(360, 40, 200, 35);

		labelNumber.setBounds(50, 60, 120, 100);
		textFieldNumber.setBounds(90, 90, 180, 35);

		labelEmail.setBounds(290, 60, 120, 100);
		textFieldEmail.setBounds(360, 90, 200, 35);

		innerPanel.add(labelName);
		innerPanel.add(textFieldName);
		innerPanel.add(labelAddress);
		innerPanel.add(textFieldAddress);
		innerPanel.add(labelNumber);
		innerPanel.add(textFieldNumber);
		innerPanel.add(labelEmail);
		innerPanel.add(textFieldEmail);
		innerPanel.add(labelAnimalType);
		innerPanel.add(comboBoxAnimalType);

		add(innerPanel);

		// 신청 버튼
		btnSubmit.setBounds(1000, 510, 80, 30);
		add(btnSubmit);
	}

	public void addEventLayout() {
		// 이벤트 처리기를 추가합니다.
	}

}