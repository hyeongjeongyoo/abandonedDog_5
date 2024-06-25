package ver1.frame;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lombok.Data;
import ver1.DAO.JoinDAO;

@Data
public class JoinFrame extends JFrame {

	private JPanel joinBackgroundImg;
	private JLabel logo;

	private JTextField nameField;
	private JTextField idField;
	private JTextField passwordField;
	private JTextField birthField;
	private JTextField phoneNumField;
	private JTextField memberNumField;
	private JTextField memberNameField;
	
	private JLabel nameLabel;
	private JLabel idLabel;
	private JLabel passwordLabel;
	private JLabel birthLabel;
	private JLabel phoneNumLabel;
	private JLabel memberNumLabel;
	private JLabel mamberNameLabel;

	private JCheckBox checkBox;

	private JLabel joinBtn;
	private final int BTN_WIDTH = 240;
	private final int BTN_HEIGHT = 45;

	public JoinFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		joinBackgroundImg = new JPanel();
		joinBtn = new JLabel(new ImageIcon("img/joinBtn.jpg"));
		logo = new JLabel(new ImageIcon("img/logo.png"));

		nameField = new JTextField(10);
		idField = new JTextField(10);
		passwordField = new JTextField(50);
		birthField = new JTextField(50);
		phoneNumField = new JTextField(50);
		memberNumField = new JTextField(50);
		memberNameField = new JTextField(50);
		
		nameLabel = new JLabel("이름");
		idLabel = new JLabel("아이디");
		passwordLabel = new JLabel("비밀번호");
		birthLabel = new JLabel("생년월일");
		phoneNumLabel = new JLabel("전화번호");
		memberNumLabel = new JLabel("소속번호");
		mamberNameLabel = new JLabel("소속이름");

		checkBox = new JCheckBox("관리자");
		

	}

	private void setInitLayout() {
		setTitle("어서오묘 데러가개 회원가입");
		setSize(440, 600);
		setContentPane(joinBackgroundImg);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/fav.png"));
		setLayout(null);
		setResizable(false); // 사이즈 조절 불가
		setLocationRelativeTo(null); // 가운데 배치
		setVisible(true);

		joinBackgroundImg.setBackground(Color.white);
		
		Font font = new Font("Noto Sans KR", Font.BOLD, 15);
		
		nameLabel.setBounds(95, 126, 100, 40);
		idLabel.setBounds(95, 170, 100, 40);
		passwordLabel.setBounds(95, 213, 100, 40);
		birthLabel.setBounds(95, 257, 100, 40);
		phoneNumLabel.setBounds(95, 300, 100, 40);
		memberNumLabel.setBounds(95, 345, 100, 40);
		mamberNameLabel.setBounds(95, 390, 100, 40);
		
		nameLabel.setFont(font);
		idLabel.setFont(font);
		passwordLabel.setFont(font);
		birthLabel.setFont(font);
		phoneNumLabel.setFont(font);
		memberNumLabel.setFont(font);
		mamberNameLabel.setFont(font);
		
		add(nameLabel);
		add(idLabel);
		add(passwordLabel);
		add(birthLabel);
		add(phoneNumLabel);
		add(memberNumLabel);
		add(mamberNameLabel);

		nameField.setBounds(165, 126, 170, 40);
		idField.setBounds(165, 170, 170, 40);
		passwordField.setBounds(165, 213, 170, 40);
		birthField.setBounds(165, 257, 170, 40);
		phoneNumField.setBounds(165, 300, 170, 40);
		memberNumField.setBounds(165, 345, 170, 40);
		memberNameField.setBounds(165, 390, 170, 40);

		nameField.setForeground(Color.DARK_GRAY);
		idField.setForeground(Color.DARK_GRAY);
		passwordField.setForeground(Color.DARK_GRAY);
		birthField.setForeground(Color.DARK_GRAY);
		phoneNumField.setForeground(Color.DARK_GRAY);
		memberNumField.setForeground(Color.DARK_GRAY);
		memberNameField.setForeground(Color.DARK_GRAY);
		
		nameField.setFont(font);
		idField.setFont(font);
		passwordField.setFont(font);
		birthField.setFont(font);
		phoneNumField.setFont(font);
		memberNumField.setFont(font);
		memberNameField.setFont(font);
		
		memberNumField.setEnabled(false);
		memberNameField.setEnabled(false);
		
		add(nameField);
		add(idField);
		add(passwordField);
		add(birthField);
		add(phoneNumField);
		add(memberNumField);
		add(memberNameField);

		logo.setSize(79, 79);
		logo.setLocation(170, 25);
		logo.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 마우스 커서 모양 변경
		add(logo);

		joinBtn.setSize(BTN_WIDTH, BTN_HEIGHT);
		joinBtn.setLocation(95, 450);
		joinBtn.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 마우스 커서 모양 변경
		add(joinBtn);

		checkBox.setBounds(270, 100, 65, 20);
		checkBox.setBackground(Color.white);
		add(checkBox);
	}

	private void addEventListener() {
		joinBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String enteredId = idField.getText();
				String enteredName = nameField.getText();
				String enteredPassword = passwordField.getText();
				String enteredBrith = birthField.getText();
				String enteredPhoneNum = phoneNumField.getText();
				int enteredMemberNum = 0;
				try {
					enteredMemberNum = Integer.parseInt(memberNumField.getText());
				} catch (NumberFormatException e2) {
				}
				String enteredMemberName = memberNameField.getText();

				if (memberNameField.isEnabled()) {

					boolean flag2 = JoinDAO.selectJoinMember(enteredId, enteredName, enteredPassword, enteredBrith,
							enteredPhoneNum, enteredMemberNum, enteredMemberName);

					if (flag2) {
						JOptionPane.showMessageDialog(null, "[관리자]" + enteredName + "님 회원가입 감사합니다.", "회원가입 성공",
								JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
						new LoginFrame();
					} else {
						JOptionPane.showMessageDialog(null, "정보를 확인해주세요.", "회원가입 실패", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					boolean flag = JoinDAO.booleanSelectJoin(enteredId, enteredName, enteredPassword, enteredBrith, enteredPhoneNum);
					if (flag) {
						JOptionPane.showMessageDialog(null, "[일반회원]" + enteredName + "님 회원가입 감사합니다.", "회원가입 성공",
								JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
						new LoginFrame();
					} else {
						JOptionPane.showMessageDialog(null, "정보를 확인해주세요.", "회원가입 실패", JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});

		checkBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkBox.isSelected()) {
					memberNumField.setEnabled(true);
					memberNameField.setEnabled(true);
				} else {
					memberNumField.setEnabled(false);
					memberNameField.setEnabled(false);
				}
			}
		});
	}

	public static void main(String[] args) {
		new JoinFrame();
	}

}
