package ver1.panel;

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
import javax.swing.JPanel;
import javax.swing.JTextField;

import lombok.Data;

@Data
public class Join extends JFrame {
	
	Join join;
	Login login;

	private JPanel joinBackgroundImg;

	private JLabel logo;

	private JTextField nameField;
	private JTextField passwordField;
	private JTextField brithField;
	private JTextField phoneNum;
	private JTextField memberNum;
	private JTextField memberName;

	private JLabel joinBtn;
	private final int BTN_WIDTH = 240;
	private final int BTN_HEIGHT = 45;

	private JButton joinGo;

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
		passwordField = new JTextField("PASSWORD", 50);
		brithField = new JTextField("생년월일", 50);
		phoneNum = new JTextField("전화번호", 50);
		memberNum = new JTextField("소속번호", 50);
		memberName = new JTextField("소속이름", 50);

		nameField.setFont(font);
		passwordField.setFont(font);
		brithField.setFont(font);
		phoneNum.setFont(font);
		memberNum.setFont(font);
		memberName.setFont(font);
		nameField.setForeground(Color.DARK_GRAY);
		passwordField.setForeground(Color.DARK_GRAY);
		brithField.setForeground(Color.DARK_GRAY);
		phoneNum.setForeground(Color.DARK_GRAY);
		memberNum.setForeground(Color.DARK_GRAY);
		memberName.setForeground(Color.DARK_GRAY);

		setTitle("어서오묘 데러가개 회원가입");
		setSize(440, 550);
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
		passwordField.setBounds(95, 170, 240, 40);
		brithField.setBounds(95, 213, 240, 40);
		phoneNum.setBounds(95, 257, 240, 40);
		memberNum.setBounds(95, 300, 240, 40);
		memberName.setBounds(95, 345, 240, 40);

		logo.setSize(79, 79);
		logo.setLocation(170, 25);
		logo.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 마우스 커서 모양 변경

		joinBtn.setSize(BTN_WIDTH, BTN_HEIGHT);
		joinBtn.setLocation(95, 400);
		joinBtn.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 마우스 커서 모양 변경

		add(logo);
		add(nameField);
		add(passwordField);
		add(brithField);
		add(phoneNum);
		add(brithField);
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
		passwordField.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mousePressed(MouseEvent e) {
    			passwordField.setText("");
    		}
    	});
		brithField.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mousePressed(MouseEvent e) {
    			brithField.setText("");
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
//		joinGo.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
//            	 String enteredId = nameField.getText();
//                 String enteredPassword = passwordField.getText();
//
//
//                 if(enteredId.equals(nameField) == enteredId.equals(nameField)) {
//                 	 //JOptionPane.showMessageDialog(null, "아이디 중복입니다.", "로그인 실패", JOptionPane.ERROR_MESSAGE);
//                  } 
//                	 
//            }
//    	});
		

    }
	
	
	public static void main(String[] args) {
		new Join();
	}

}
