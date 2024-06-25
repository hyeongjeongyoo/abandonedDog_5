package ver1.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import ver1.DAO.AdoptDAO;
import ver1.DTO.AdoptDTO;
import ver1.frame.MainBoardFrame;

public class ApplyAdoptPanel extends JPanel {

	private MainBoardFrame mContext;

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

	private JLabel labelRaisedPet;
	private JLabel labelSizeFamily;

	private JCheckBox checkBoxSexMale;
	private JCheckBox checkBoxSexFemale;
	private JCheckBox checkBoxMaritalY;
	private JCheckBox checkBoxMaritalN;
	private JCheckBox checkBoxRaisedPetY;
	private JCheckBox checkBoxRaisedPetN;

	private Font font;

	public ApplyAdoptPanel(MainBoardFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
		addEventLayout();
	}

	public void initData() {

		innerPanel = new JPanel();
		innerPanel.setBorder(new TitledBorder(new LineBorder(new Color(13, 170, 93), 3), null));

		labelName = new JLabel("이름");
		textFieldName = new JTextField(20);
		textFieldName.setText(mContext.name);
		textFieldName.setEditable(false);

		labelAddress = new JLabel("주소");
		textFieldAddress = new JTextField(20);

		labelNumber = new JLabel("폰 번호");
		textFieldNumber = new JTextField(20);
		textFieldNumber.setText(mContext.phoneNum);
		textFieldNumber.setEditable(false);

		labelEmail = new JLabel("이메일");
		textFieldEmail = new JTextField(20);

		labelAge = new JLabel("나이");
		textFieldAge = new JTextField(20);

		labelSex = new JLabel("성별");
		checkBoxSexMale = new JCheckBox("남성");
		checkBoxSexFemale = new JCheckBox("여성");

		labelJob = new JLabel("직업");
		textFieldJob = new JTextField(20);

		labelMaritalStatus = new JLabel("결혼여부");
		checkBoxMaritalN = new JCheckBox("미혼");
		checkBoxMaritalY = new JCheckBox("기혼");

		labelVisitDate = new JLabel("방문예정");
		textFieldVisitDate = new JTextField(20);

		labelId = new JLabel("동물ID");
		textFieldId = new JTextField(20);

		labelRaisedPet = new JLabel("반려동물 키우신 적 있습니까?");
		checkBoxRaisedPetY = new JCheckBox("Y");
		checkBoxRaisedPetN = new JCheckBox("N");

		labelSizeFamily = new JLabel("가족 구성인원이 어떻게 됩니까?");
		textFieldSizeFamily = new JTextField(30);

		btnSubmit = new JButton(new ImageIcon("img/goBtn.jpg"));

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

		checkBoxSexMale.setBackground(Color.white);
		checkBoxSexFemale.setBackground(Color.white);
		checkBoxMaritalY.setBackground(Color.white);
		checkBoxMaritalN.setBackground(Color.white);
		checkBoxRaisedPetY.setBackground(Color.white);
		checkBoxRaisedPetN.setBackground(Color.white);

	}

	public void setInitLayout() {
		setLayout(null);
		setBackground(Color.white);

		innerPanel.setLayout(null);
		innerPanel.setBounds(110, 13, 980, 450);
		innerPanel.setBackground(Color.white);

		labelName.setBounds(50, 10, 120, 100);
		textFieldName.setBounds(120, 40, 200, 35);

		labelAddress.setBounds(410, 10, 120, 100);
		textFieldAddress.setBounds(480, 40, 200, 35);

		labelNumber.setBounds(50, 60, 120, 100);
		textFieldNumber.setBounds(120, 90, 200, 35);

		labelEmail.setBounds(410, 60, 120, 100);
		textFieldEmail.setBounds(480, 90, 200, 35);

		labelAge.setBounds(50, 110, 120, 100);
		textFieldAge.setBounds(120, 140, 200, 35);

		labelSex.setBounds(410, 110, 120, 100);
		checkBoxSexMale.setBounds(480, 145, 70, 30);
		checkBoxSexFemale.setBounds(560, 145, 70, 30);

		labelJob.setBounds(50, 160, 120, 100);
		textFieldJob.setBounds(120, 190, 200, 35);

		labelMaritalStatus.setBounds(410, 160, 120, 100);
		checkBoxMaritalN.setBounds(480, 195, 70, 30);
		checkBoxMaritalY.setBounds(560, 195, 70, 30);

		labelVisitDate.setBounds(50, 210, 120, 100);
		textFieldVisitDate.setBounds(120, 240, 200, 35);

		labelId.setBounds(410, 210, 120, 100);
		textFieldId.setBounds(480, 240, 200, 35);

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
		checkBoxMaritalN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkBoxMaritalN.isSelected()) {
					checkBoxMaritalY.setSelected(false);
				}
			}
		});

		checkBoxMaritalY.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkBoxMaritalY.isSelected()) {
					checkBoxMaritalN.setSelected(false);
				}
			}
		});

		checkBoxRaisedPetN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkBoxRaisedPetN.isSelected()) {
					checkBoxRaisedPetY.setSelected(false);
				}

			}
		});

		checkBoxRaisedPetY.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkBoxRaisedPetY.isSelected()) {
					checkBoxRaisedPetN.setSelected(false);
				}

			}
		});

		checkBoxSexFemale.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkBoxSexFemale.isSelected()) {
					checkBoxSexMale.setSelected(false);
				}

			}
		});

		checkBoxSexMale.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkBoxSexMale.isSelected()) {
					checkBoxSexFemale.setSelected(false);
				}

			}
		});

		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					AdoptDAO.insertApplyAdopt(sendAdopt(Integer.parseInt(textFieldId.getText())));
					JOptionPane.showMessageDialog(null, "신청이 완료되었습니다.", "Success", JOptionPane.INFORMATION_MESSAGE);
					mContext.getMyPage().updateMyAdopt();
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "나이와 동물 ID는 숫자만 입력이 가능합니다.", "Fail", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}

	public AdoptDTO sendAdopt(int careId) {
		AdoptDTO dto = new AdoptDTO();
		dto.setName(textFieldName.getText());
		dto.setAddress(textFieldAddress.getText());
		dto.setNumber(textFieldNumber.getText());
		dto.setEmail(textFieldEmail.getText());
		dto.setAge(textFieldAge.getText());

		if (checkBoxSexMale.isSelected()) {
			dto.setSex("남성");
		} else if (checkBoxSexFemale.isSelected()) {
			dto.setSex("여성");
		}

		dto.setJob(textFieldJob.getText());

		if (checkBoxMaritalY.isSelected()) {
			dto.setMaritalStatus("기혼");
		} else if (checkBoxMaritalN.isSelected()) {
			dto.setMaritalStatus("미혼");
		}

		dto.setVisitDate(textFieldVisitDate.getText());
		dto.setAnimalId(textFieldId.getText());

		if (checkBoxRaisedPetY.isSelected()) {
			dto.setRaisedPet("Y");
		} else if (checkBoxRaisedPetN.isSelected()) {
			dto.setRaisedPet("N");
		}

		dto.setSizeFamily(textFieldSizeFamily.getText());
		dto.setPermission("승인대기");
		dto.setCareId(careId);

		return dto;
	}

}