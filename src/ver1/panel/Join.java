package ver1.panel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
public class Join extends JFrame {

	Join join;
	Login login;

	private JPanel joinBackgroundImg;

	private JLabel logo;

	private JTextField nameField;
	private JTextField idField;
	private JTextField passwordField;
	private JTextField birthField;
	private JTextField phoneNum;
	private JTextField memberNum;
	private JTextField memberName;

	private JCheckBox checkBox;

	private JLabel joinBtn;
	private final int BTN_WIDTH = 240;
	private final int BTN_HEIGHT = 45;

	Font font = new Font("Noto Sans KR", Font.BOLD, 15);
	Font font2 = new Font("Noto Sans KR", Font.BOLD, 12);

	public Join() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		joinBackgroundImg = new JPanel();
		joinBtn = new JLabel(new ImageIcon("img/joinBtn.jpg"));
		logo = new JLabel(new ImageIcon("img/logo.png"));

		nameField = new JTextField("이름", 10);
		idField = new JTextField("아이디", 10);
		passwordField = new JTextField("PASSWORD", 50);
		birthField = new JTextField("생년월일", 50);
		phoneNum = new JTextField("전화번호", 50);
		memberNum = new JTextField("소속번호", 50);
		memberName = new JTextField("소속이름", 50);

		checkBox = new JCheckBox("관리자");

		nameField.setFont(font);
		idField.setFont(font);
		passwordField.setFont(font);
		birthField.setFont(font);
		phoneNum.setFont(font);
		memberNum.setFont(font);
		memberName.setFont(font);
		nameField.setForeground(Color.DARK_GRAY);
		idField.setForeground(Color.DARK_GRAY);
		passwordField.setForeground(Color.DARK_GRAY);
		birthField.setForeground(Color.DARK_GRAY);
		phoneNum.setForeground(Color.DARK_GRAY);
		memberNum.setForeground(Color.DARK_GRAY);
		memberName.setForeground(Color.DARK_GRAY);

		setTitle("어서오묘 데러가개 회원가입");
		setSize(440, 600);
		setContentPane(joinBackgroundImg);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setIconImage(Toolkit.getDefaultToolkit().getImage("img/fav.png"));
	}

	private void setInitLayout() {
		setLayout(null);
		setResizable(false); // 사이즈 조절 불가
		setLocationRelativeTo(null); // 가운데 배치
		setVisible(true);

		joinBackgroundImg.setBackground(Color.white);

		nameField.setBounds(95, 126, 240, 40);
		idField.setBounds(95, 170, 240, 40);
		passwordField.setBounds(95, 213, 240, 40);
		birthField.setBounds(95, 257, 240, 40);
		phoneNum.setBounds(95, 300, 240, 40);
		memberNum.setBounds(95, 345, 240, 40);
		memberName.setBounds(95, 390, 240, 40);

		memberNum.setEnabled(false);
		memberName.setEnabled(false);

		logo.setSize(79, 79);
		logo.setLocation(170, 25);
		logo.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 마우스 커서 모양 변경

		joinBtn.setSize(BTN_WIDTH, BTN_HEIGHT);
		joinBtn.setLocation(95, 450);
		joinBtn.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 마우스 커서 모양 변경

		checkBox.setBounds(270, 100, 70, 20);
		add(checkBox);

		add(logo);
		add(nameField);
		add(idField);
		add(passwordField);
		add(birthField);
		add(phoneNum);
		add(memberNum);
		add(memberName);
		add(joinBtn);
	}

	private void addEventListener() {
		nameField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				nameField.setText("");
			}
		});
		idField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				idField.setText("");
			}
		});
		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				passwordField.setText("");
			}
		});
		birthField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				birthField.setText("");
			}
		});
		phoneNum.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				phoneNum.setText("");
			}
		});
		memberNum.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				memberNum.setText("");
			}
		});
		memberName.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				memberName.setText("");
			}
		});
		nameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				nameField.setText("");
			}
		});
		idField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				idField.setText("");
			}
		});
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				passwordField.setText("");
			}
		});
		birthField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				birthField.setText("");
			}
		});
		phoneNum.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				phoneNum.setText("");
			}
		});
		memberNum.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				memberNum.setText("");
			}
		});
		memberName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				memberName.setText("");
			}
		});
		joinBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String enteredName = nameField.getText();
				String enteredId = idField.getText();
				String enteredPassword = passwordField.getText();
				String enteredBrith = birthField.getText();
				String enteredPhoneNum = phoneNum.getText();
				int enteredMemberNum = Integer.parseInt(memberNum.getText());
				String enteredMemberName = memberName.getText();

				if (!memberNum.getText().equals(null) && !memberNum.getText().equals("소속번호")
						&& !memberName.getText().equals(null) && !memberName.getText().equals("소속이름")) {

					boolean flag2 = JoinDAO.selectJoinMember(enteredName, enteredPassword, enteredBrith,
							enteredPhoneNum, enteredMemberNum, enteredMemberName);

					if (flag2) {
						JOptionPane.showMessageDialog(null, "[관리자]" + enteredName + "님 회원가입 감사합니다.", "회원가입 성공",
								JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
						new Login();
					} else {
						JOptionPane.showMessageDialog(null, "정보를 확인해주세요.", "회원가입 실패", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					boolean flag = JoinDAO.bSelectJoin(enteredName, enteredPassword, enteredBrith, enteredPhoneNum);
					if (flag) {
						JOptionPane.showMessageDialog(null, "[일반회원]" + enteredName + "님 회원가입 감사합니다.", "회원가입 성공",
								JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
						new Login();
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
					memberNum.setEnabled(true);
					memberName.setEnabled(true);
				} else {
					memberNum.setEnabled(false);
					memberName.setEnabled(false);
				}
			}
		});
	}

	public static void main(String[] args) {
		new Join();
	}

}
