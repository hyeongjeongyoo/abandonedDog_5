package ver1.frame;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import lombok.Data;
import ver1.DAO.LoginDAO;
import ver1.DTO.LoginDTO;

@Data
public class LoginFrame extends JFrame {

	public String name;

	private JPanel loginBackgroundImg;
	private JLabel logo;

	private JTextField idField;
	private JPasswordField passwordField;

	private JLabel idLabel;
	private JLabel passwordLabel;

	private JLabel loginBtn;
	private final int BTN_WIDTH = 240;
	private final int BTN_HEIGHT = 45;

	private JButton join;

	Font font = new Font("Noto Sans KR", Font.BOLD, 15);
	Font font2 = new Font("Noto Sans KR", Font.BOLD, 12);

	public LoginFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		loginBackgroundImg = new JPanel();
		loginBtn = new JLabel(new ImageIcon("img/loginBtn.jpg"));
		logo = new JLabel(new ImageIcon("img/logo.png"));

		idField = new JTextField(10);
		passwordField = new JPasswordField(50);

		idLabel = new JLabel("아이디");
		passwordLabel = new JLabel("비밀번호");

		join = new JButton("회원가입");

		idField.setFont(font);
		passwordField.setFont(font);
		idField.setForeground(Color.DARK_GRAY);
		passwordField.setForeground(Color.DARK_GRAY);
		join.setForeground(Color.DARK_GRAY);

		setTitle("어서오묘 데러가개 로그인");
		setSize(440, 360);
		setContentPane(loginBackgroundImg);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setIconImage(Toolkit.getDefaultToolkit().getImage("img/fav.png"));
	}

	private void setInitLayout() {
		setLayout(null);
		setResizable(false); // 사이즈 조절 불가
		setLocationRelativeTo(null); // 가운데 배치
		setVisible(true);

		Font font = new Font("Noto Sans KR", Font.BOLD, 15);
		UIManager.put("OptionPane.messageFont", new Font("Noto Sans KR", Font.PLAIN, 12));

		idLabel.setBounds(95, 126, 100, 40);
		idLabel.setFont(font);
		passwordLabel.setBounds(95, 170, 100, 40);
		passwordLabel.setFont(font);

		add(idLabel);
		add(passwordLabel);

		idField.setBounds(165, 126, 171, 40);
		passwordField.setBounds(165, 170, 171, 40);

		loginBackgroundImg.setBackground(Color.white);

		logo.setSize(79, 79);
		logo.setLocation(170, 25);
		logo.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 마우스 커서 모양 변경

		loginBtn.setSize(BTN_WIDTH, BTN_HEIGHT);
		loginBtn.setLocation(95, 220);
		loginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 마우스 커서 모양 변경

		join.setSize(110, 15);
		join.setLocation(256, 280);
		join.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 마우스 커서 모양 변경
		join.setBorder(null);
		join.setContentAreaFilled(false);
		join.setFont(font2);

		add(logo);
		add(idField);
		add(passwordField);
		add(loginBtn);
		add(join);
	}

	private void addEventListener() {
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
		join.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				JoinFrame join = new JoinFrame();
			}
		});
		loginBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				if (idField.getText().length() > 1) {
					String enteredId = idField.getText();
					String enteredPassword = passwordField.getText();

					LoginDTO dto = LoginDAO.selectLogin(enteredId);

					if (dto != null) {

						if (enteredId.equals(dto.getUserName()) && enteredPassword.equals(dto.getUserPassWord())) {
							JOptionPane.showMessageDialog(null, "로그인 성공", "로그인", JOptionPane.INFORMATION_MESSAGE);
							setVisible(false);
							if (dto.getAuthority().equals("common")) {
								new MainBoardFrame(false, dto.getName(), dto.getUserName(), dto.getUserPassWord(),
										dto.getUserBirth(), dto.getAuthority(), dto.getUserTel());
							} else {
								new MainBoardFrame(true, dto.getName(), dto.getUserName(), dto.getUserPassWord(),
										dto.getUserBirth(), dto.getAuthority(), dto.getUserTel(),
										dto.getUserDepartmentNo(), dto.getUserDepartmentName());
							}
						} else {
							JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 잘못되었습니다.", "로그인 실패",
									JOptionPane.ERROR_MESSAGE);
						}

					} else {
						JOptionPane.showMessageDialog(null, "존재하지 않는 아이디입니다.", "로그인", JOptionPane.INFORMATION_MESSAGE);
					}

				}
			}
		});

		passwordField.addActionListener(e -> {
			if (idField.getText().length() > 1) {
				String enteredId = idField.getText();
				String enteredPassword = passwordField.getText();

				LoginDTO dto = LoginDAO.selectLogin(enteredId);

				if (dto != null) {

					if (enteredId.equals(dto.getUserName()) && enteredPassword.equals(dto.getUserPassWord())) {
						JOptionPane.showMessageDialog(null, "로그인 성공", "로그인", JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
						if (dto.getAuthority().equals("common")) {
							new MainBoardFrame(false, dto.getName(), dto.getUserName(), dto.getUserPassWord(),
									dto.getUserBirth(), dto.getAuthority(), dto.getUserTel());
						} else {
							new MainBoardFrame(true, dto.getName(), dto.getUserName(), dto.getUserPassWord(),
									dto.getUserBirth(), dto.getAuthority(), dto.getUserTel(), dto.getUserDepartmentNo(),
									dto.getUserDepartmentName());
						}
					} else {
						JOptionPane.showMessageDialog(null, "비밀번호가 잘못되었습니다.", "로그인 실패", JOptionPane.ERROR_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(null, "존재하지 않는 아이디입니다.", "로그인", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

	}

	public JTextField getIdField() {
		return idField;
	}

	public void setIdField(JTextField idField) {
		this.idField = idField;
	}

	public JTextField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

}
