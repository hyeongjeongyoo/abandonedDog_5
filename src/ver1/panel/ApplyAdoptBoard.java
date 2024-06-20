package ver1.panel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ApplyAdoptBoard extends JPanel {

	private JTextField textFieldName;
	private JTextField textFieldAddress;
	private JComboBox<String> comboBoxAnimalType;
	private JButton btnSubmit;

	public ApplyAdoptBoard() {
		initData();
		setInitLayout();
		addEventLayout();
	}

	public void initData() {

		JPanel infoPanel = new JPanel(new BorderLayout());
		infoPanel.setBorder(BorderFactory.createTitledBorder("입양자 정보"));

		JPanel inputPanel = new JPanel(new BorderLayout());
		JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel textFieldPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

		JLabel labelName = new JLabel("이름:");
		labelName.setFont(new Font("Noto Sans KR", Font.PLAIN, 14));
		textFieldName = new JTextField(20);
		textFieldName.setFont(new Font("Noto Sans KR", Font.PLAIN, 14));
		labelPanel.add(labelName);
		textFieldPanel.add(textFieldName);

		JLabel labelAddress = new JLabel("주소:");
		labelAddress.setFont(new Font("Noto Sans KR", Font.PLAIN, 14));
		textFieldAddress = new JTextField(20);
		textFieldAddress.setFont(new Font("Noto Sans KR", Font.PLAIN, 14));
		labelPanel.add(labelAddress);
		textFieldPanel.add(textFieldAddress);

		inputPanel.add(labelPanel, BorderLayout.WEST);
		inputPanel.add(textFieldPanel, BorderLayout.CENTER);

		infoPanel.add(inputPanel, BorderLayout.CENTER);

		// 동물 정보 선택 패널
		JPanel animalPanel = new JPanel(new BorderLayout());
		animalPanel.setBorder(BorderFactory.createTitledBorder("입양할 동물 정보"));

		String[] animalTypes = { "고양이", "개", "기타" };
		comboBoxAnimalType = new JComboBox<>(animalTypes);
		comboBoxAnimalType.setFont(new Font("Noto Sans KR", Font.PLAIN, 14));

		animalPanel.add(comboBoxAnimalType, BorderLayout.CENTER);

		// 제출 버튼 패널
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnSubmit = new JButton("신청 제출");
		btnSubmit.setFont(new Font("Noto Sans KR", Font.BOLD, 14));
		buttonPanel.add(btnSubmit);

		// 전체 패널에 추가
		add(infoPanel, BorderLayout.NORTH);
		add(animalPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);

	}

	public void setInitLayout() {

	}

	public void addEventLayout() {

	}

}
