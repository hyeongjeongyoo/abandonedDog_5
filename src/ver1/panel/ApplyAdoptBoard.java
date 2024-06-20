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

	private JComboBox<String> comboBoxAnimalType;
	private JButton btnSubmit;
	private JPanel innerPanel;

	private JTextField textFieldName;
	private JTextField textFieldAddress;
	private JTextField textFieldNumber;
	private JTextField textFieldEmail;

	private JTextField textFieldId;
	private JTextField textFieldAge;
	private JTextField textFieldSex;
	private JTextField textFieldJob;
	private JTextField textfieldMaritalStatus;
	private JTextField textfieldVisitDate;

	private JLabel labelId;
	private JLabel labelAge;
	private JLabel labelSex;
	private JLabel labelJob;
	private JLabel labelMaritalStatus;
	private JLabel labelVisitDate;

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

		////////////////

		labelAge = new JLabel("나이:");
		textFieldAge = new JTextField(20);

		labelSex = new JLabel("성별:");
		textFieldSex = new JTextField(20);

		labelJob = new JLabel("직업:");
		textFieldJob = new JTextField(20);

		labelMaritalStatus = new JLabel("결혼여부:");
		textfieldMaritalStatus = new JTextField(20);

		labelVisitDate = new JLabel("방문예정:");
		textfieldVisitDate = new JTextField(20);

		labelId = new JLabel("동물ID:");
		textFieldId = new JTextField(20);

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
		labelAge.setFont(font);
		textFieldAge.setFont(font);
		labelSex.setFont(font);
		textFieldSex.setFont(font);
		labelJob.setFont(font);
		textFieldJob.setFont(font);
		labelMaritalStatus.setFont(font);
		textfieldMaritalStatus.setFont(font);
		labelVisitDate.setFont(font);
		textfieldVisitDate.setFont(font);
		labelId.setFont(font);
		textFieldId.setFont(font);

	}

	public void setInitLayout() {
		setLayout(null);
		innerPanel.setLayout(null);
		innerPanel.setBounds(100, 50, 980, 450);

		labelName.setBounds(50, 10, 120, 100);
		textFieldName.setBounds(90, 40, 180, 35);

		labelAddress.setBounds(310, 10, 120, 100);
		textFieldAddress.setBounds(380, 40, 200, 35);

		labelNumber.setBounds(50, 60, 120, 100);
		textFieldNumber.setBounds(90, 90, 180, 35);

		labelEmail.setBounds(310, 60, 120, 100);
		textFieldEmail.setBounds(380, 90, 200, 35);

		labelAge.setBounds(50, 110, 120, 100);
		textFieldAge.setBounds(90, 140, 60, 35);

		labelSex.setBounds(310, 110, 120, 100);
		textFieldSex.setBounds(380, 140, 60, 35);

		labelJob.setBounds(50, 160, 120, 100);
		textFieldJob.setBounds(90, 190, 200, 35);

		labelMaritalStatus.setBounds(310, 160, 120, 100);
		textfieldMaritalStatus.setBounds(380, 190, 200, 35);

		labelVisitDate.setBounds(50, 210, 120, 100);
		textfieldVisitDate.setBounds(110, 240, 180, 35);

		labelId.setBounds(310, 210, 120, 100);
		textFieldId.setBounds(380, 240, 200, 35);

		labelAnimalType.setBounds(50, 260, 120, 100);
		comboBoxAnimalType.setBounds(130, 290, 180, 35);

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

		innerPanel.add(labelAge);
		innerPanel.add(textFieldAge);
		innerPanel.add(labelSex);
		innerPanel.add(textFieldSex);
		innerPanel.add(labelJob);
		innerPanel.add(textFieldJob);
		innerPanel.add(labelMaritalStatus);
		innerPanel.add(textfieldMaritalStatus);
		innerPanel.add(labelVisitDate);
		innerPanel.add(textfieldVisitDate);
		innerPanel.add(labelId);
		innerPanel.add(textFieldId);

		add(innerPanel);

		// 신청 버튼
		btnSubmit.setBounds(1000, 510, 80, 30);
		add(btnSubmit);
	}

	public void addEventLayout() {
		// 이벤트 처리기를 추가합니다.
	}

}