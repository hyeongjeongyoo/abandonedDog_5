package ver1.panel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
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
	private JTextField textFieldJob;
	private JTextField textFieldVisitDate;
	private JTextField textFieldSizeFamily;

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

	private JLabel labelRaisedPet;
	private JLabel labelSizeFamily;

	private JCheckBox checkBoxSexMale;
	private JCheckBox checkBoxSexFemale;
	private JCheckBox checkBoxMaritalY;
	private JCheckBox checkBoxMaritalN;
	private JCheckBox checkBoxRaisedPetY;
	private JCheckBox checkBoxRaisedPetN;

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
		checkBoxSexMale = new JCheckBox("남성");
		checkBoxSexFemale = new JCheckBox("여성");

		labelJob = new JLabel("직업:");
		textFieldJob = new JTextField(20);

		labelMaritalStatus = new JLabel("결혼여부:");
		checkBoxMaritalN = new JCheckBox("미혼");
		checkBoxMaritalY = new JCheckBox("기혼");

		labelVisitDate = new JLabel("방문예정:");
		textFieldVisitDate = new JTextField(20);

		labelId = new JLabel("동물ID:");
		textFieldId = new JTextField(20);

		labelRaisedPet = new JLabel("반려동물 키우신 적 있습니까?");
		checkBoxRaisedPetY = new JCheckBox("Y");
		checkBoxRaisedPetN = new JCheckBox("N");

		labelSizeFamily = new JLabel("가족 구성인원이 어떻게 됩니까?");
		textFieldSizeFamily = new JTextField(30);

		btnSubmit = new JButton("신청");

		// Font 설정
		font = new Font("Noto Sans KR", Font.PLAIN, 14);
		labelName.setFont(font);
		textFieldName.setFont(font);
		labelAddress.setFont(font);
		labelNumber.setFont(font);
		labelEmail.setFont(font);
		textFieldAddress.setFont(font);
		textFieldNumber.setFont(font);
		textFieldEmail.setFont(font);
		labelAge.setFont(font);
		textFieldAge.setFont(font);
		labelSex.setFont(font);
		labelJob.setFont(font);
		textFieldJob.setFont(font);
		labelMaritalStatus.setFont(font);
		labelVisitDate.setFont(font);
		textFieldVisitDate.setFont(font);
		labelId.setFont(font);
		textFieldId.setFont(font);
		checkBoxMaritalY.setFont(font);
		checkBoxMaritalN.setFont(font);
		checkBoxSexFemale.setFont(font);
		checkBoxSexMale.setFont(font);
		checkBoxRaisedPetN.setFont(font);
		checkBoxRaisedPetY.setFont(font);
		textFieldSizeFamily.setFont(font);
		labelRaisedPet.setFont(font);
		labelSizeFamily.setFont(font);
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
		checkBoxSexMale.setBounds(380, 145, 70, 30);
		checkBoxSexFemale.setBounds(460, 145, 70, 30);

		labelJob.setBounds(50, 160, 120, 100);
		textFieldJob.setBounds(90, 190, 200, 35);

		labelMaritalStatus.setBounds(310, 160, 120, 100);
		checkBoxMaritalN.setBounds(380, 195, 70, 30);
		checkBoxMaritalY.setBounds(460, 195, 70, 30);

		labelVisitDate.setBounds(50, 210, 120, 100);
		textFieldVisitDate.setBounds(110, 240, 180, 35);

		labelId.setBounds(310, 210, 120, 100);
		textFieldId.setBounds(380, 240, 200, 35);

		labelRaisedPet.setBounds(50, 260, 200, 100);
		checkBoxRaisedPetY.setBounds(300, 290, 50, 35);
		checkBoxRaisedPetN.setBounds(360, 290, 50, 35);

		labelSizeFamily.setBounds(50, 320, 220, 100);
		textFieldSizeFamily.setBounds(290, 350, 290, 35);

		innerPanel.add(labelName);
		innerPanel.add(textFieldName);
		innerPanel.add(labelAddress);
		innerPanel.add(textFieldAddress);
		innerPanel.add(labelNumber);
		innerPanel.add(textFieldNumber);
		innerPanel.add(labelEmail);
		innerPanel.add(textFieldEmail);
		innerPanel.add(checkBoxSexFemale);
		innerPanel.add(checkBoxSexMale);
		innerPanel.add(checkBoxMaritalY);
		innerPanel.add(checkBoxMaritalN);
		innerPanel.add(checkBoxRaisedPetN);
		innerPanel.add(checkBoxRaisedPetY);

		innerPanel.add(labelAge);
		innerPanel.add(textFieldAge);
		innerPanel.add(labelSex);
		innerPanel.add(labelJob);
		innerPanel.add(textFieldJob);
		innerPanel.add(labelMaritalStatus);
		innerPanel.add(labelVisitDate);
		innerPanel.add(textFieldVisitDate);
		innerPanel.add(labelId);
		innerPanel.add(textFieldId);
		innerPanel.add(textFieldSizeFamily);
		innerPanel.add(labelSizeFamily);
		innerPanel.add(labelRaisedPet);

		add(innerPanel);

		// 신청 버튼
		btnSubmit.setBounds(1000, 510, 80, 30);
		add(btnSubmit);
	}

	public void addEventLayout() {
		// 이벤트 처리기를 추가합니다.
	}

}