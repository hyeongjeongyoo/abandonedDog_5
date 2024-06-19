package ver1.frame;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class tab1 extends JFrame {
	JLabel l = new JLabel(BorderLayout.NORTH);
	JPanel p = new JPanel();

	JTabbedPane t = new JTabbedPane();

	Font font = new Font("Noto Sans KR", Font.BOLD, 15);
	
	
	JPanel p1 = new JPanel();
//	JPanel p2 = new JPanel();
//	JPanel p3 = new JPanel();
//	JPanel p4 = new JPanel();
//	JPanel p5 = new JPanel();
//	JPanel p6 = new JPanel();
//	JPanel p7 = new JPanel();

	JButton btn = new JButton("HOME");
	
	JButton btn1 = new JButton("로그인");
//	JButton btn2 = new JButton("등록");
//	JButton btn3 = new JButton("검색");
//	JButton btn4 = new JButton("신청");
//	JButton btn5 = new JButton("찾기");
//	JButton btn6 = new JButton("등록");
//	JButton btn7 = new JButton("제보");
	JButton btn8 = new JButton("회원가입");

	JLabel jLabel1 = new JLabel("ID");
	JTextField txt_1 = new JTextField(null, 25);
	JLabel jLabel2 = new JLabel("PASSWORD");
	JTextField txt_2 = new JTextField(null, 25);

//	JTextField txt_3 = new JTextField(" ", 25);
//	JTextField txt_4 = new JTextField("특징", 25);
//	JTextField txt_5 = new JTextField("지역", 25);
//	JTextField txt_6 = new JTextField(" ", 25);

	public tab1() {

		super("유기견 보호소");
		jLabel1.setFont(font);
		jLabel2.setFont(font);
		// btn.setBounds(30, 30, 30, 30);

		
		
		
		// 로그인
		
		p1.add(jLabel1);
		p1.add(txt_1);
		p1.add(jLabel2);
		p1.add(txt_2);
		p1.add(btn1);
		p1.add(btn8);
		
		
		// 유기동물 등록
//		p2.add(btn2);
//		p2.add(btn3);
//		p2.add(txt_3);

		// 임시보호 신청
//		p3.add(btn4);
//		p3.add(txt_4);

		// 보호소 찾기
//		p4.add(btn5);
//		p4.add(txt_5);

		// 실종등록/제보
//		p5.add(btn6);
//		p5.add(btn7);
//		p5.add(txt_6);
		
		// 상태확인

		// 동물병원찾기
		
		t.add("로그인", p1);
//		t.add("유기동물 등록", p2);
//		t.add("임시보호 신청", p3);
//		t.add("보호소찾기", p4);
//		t.add("실종등록 / 제보", p5);
//		t.add("상태확인", p6);
//		t.add("동물병원찾기", p7);

		add(t);

		btn8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame registerFrame = new JFrame("회원가입");
				JPanel registerPanel = new JPanel();
				

				JLabel name = new JLabel("ID");
				JTextField nameField = new JTextField(20);
				
				JTextField passwordField = new JTextField(20);
				JLabel password = new JLabel("PASSWORD");
				JButton submit = new JButton("회원가입");
				registerPanel.setFont(font);
				registerPanel.add(name);
				registerPanel.add(nameField);
				registerPanel.add(password);
				registerPanel.add(passwordField);
				registerPanel.add(submit);

				registerFrame.add(registerPanel);

				registerFrame.setSize(700, 100);
				registerFrame.setLocationRelativeTo(null);
				registerFrame.setVisible(true);
				registerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			}
		});

		setSize(1000, 120);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new tab1();

	}
}
