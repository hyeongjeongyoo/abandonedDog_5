package ver1.panel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lombok.Data;

@Data
public class Login extends JFrame {

	Login login;
	Join join2;

	private String id = "root";
	private String password = "asd123";

	private JPanel loginBackgroundImg;

	private JLabel logo;

	private JTextField idField;
	private JTextField passwordField;

	private JLabel loginBtn;
	private final int BTN_WIDTH = 240;
	private final int BTN_HEIGHT = 45;

	private JButton join;

	Font font = new Font("Noto Sans KR", Font.BOLD, 15);
	Font font2 = new Font("Noto Sans KR", Font.BOLD, 12);

	public Login() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		loginBackgroundImg = new JPanel();
		loginBtn = new JLabel(new ImageIcon("img/loginBtn.jpg"));
		logo = new JLabel(new ImageIcon("img/logo.png"));

		idField = new JTextField("ID", 10);
		passwordField = new JTextField("PASSWORD", 50);
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

		idField.setBounds(95, 126, 240, 40);
		passwordField.setBounds(95, 170, 240, 40);

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
				Join join = new Join();
//    	        join.setVisible(true);
			}
		});// 포커스 리스너를 사용하여 텍스트 필드에 포커스가 있을 때 기본 텍스트를 지우도록 설정
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				passwordField.setText("");
			}
		});

		// ActionListener를 사용하여 엔터 키와 마우스 클릭으로 로그인 기능을 처리
		loginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String enteredId = idField.getText();
				String enteredPassword = passwordField.getText();

				if (enteredId.equals(id) && enteredPassword.equals(password)) {
					JOptionPane.showMessageDialog(null, "로그인 성공", "로그인", JOptionPane.INFORMATION_MESSAGE);
					setVisible(false); // 로그인 성공 시 현재 창을 숨김
				} else {
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 잘못되었습니다.", "로그인 실패", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		// 엔터 키를 눌렀을 때도 동작하도록 설정
		passwordField.addActionListener(e -> {
			String enteredId = idField.getText();
			String enteredPassword = passwordField.getText();

			if (enteredId.equals(id) && enteredPassword.equals(password)) {
				JOptionPane.showMessageDialog(null, "로그인 성공", "로그인", JOptionPane.INFORMATION_MESSAGE);
				setVisible(false); // 로그인 성공 시 현재 창을 숨김
			} else {
				JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 잘못되었습니다.", "로그인 실패", JOptionPane.ERROR_MESSAGE);
			}
		});

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public void setPasswordField(JTextField passwordField) {
		this.passwordField = passwordField;
	}

	public static void main(String[] args) {
		new Login();
	}

}
