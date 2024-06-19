package ver1.frame;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class tab2 extends JFrame{
	
	tab1 tab1 = new tab1();
	
	JTabbedPane t1 = new JTabbedPane();
	JTabbedPane t2 = new JTabbedPane();
	JTabbedPane t3 = new JTabbedPane();
	JTabbedPane t4 = new JTabbedPane();
	JTabbedPane t5 = new JTabbedPane();
	JTabbedPane t6 = new JTabbedPane();

	Font font = new Font("Noto Sans KR", Font.BOLD, 15);
	
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	JPanel p5 = new JPanel();
	JPanel p6 = new JPanel();
	JPanel p7 = new JPanel();
	JPanel p8 = new JPanel();
	JPanel p9 = new JPanel();
	JPanel p10 = new JPanel();
	JPanel p11 = new JPanel();
	
	JButton btn2 = new JButton("등록");
	JButton btn3 = new JButton("신청");
	JButton btn4 = new JButton("신청");
	JButton btn5 = new JButton("등록");
	JButton btn6 = new JButton("제보");
	JButton btn7 = new JButton("검색");
	JButton btn8 = new JButton("검색");
	
	JTextField txt_3 = new JTextField(" ", 25);
	JTextField txt_4 = new JTextField("신청하기", 25);
	JTextField txt_5 = new JTextField("신청하기", 25);
	JTextField txt_6 = new JTextField(" ", 25);
	JTextField txt_7 = new JTextField(" ", 25);
	JTextField txt_8 = new JTextField("시,군,구 로 검색해 주세요", 25);
	JTextField txt_9 = new JTextField("시,군,구 로 검색해 주세요", 25);

	public tab2() {
		
		// 유기동물 등록
				t1.addTab("유기동물 확인/등록", t2);
				t2.addTab("등록", p2);
				p2.add(btn2);
				p2.add(txt_3);
				t2.addTab("정보확인", p3);
				// todo 정보확인엔 뭘 넣어야하지?
			
				// 임시보호 신청
				t1.addTab("임시보호 신청", t3);
				t3.addTab("고양이", p4);
				p4.add(txt_4);
				p4.add(btn3);
				t3.addTab("강아지", p5);
				p5.add(txt_5);
				p5.add(btn4);

				// 실종등록/제보
				t1.addTab("실종등록/제보", t4);
				t4.addTab("실종등록", p6);
				t4.addTab("실종제보", p7);
				p6.add(btn5);
				p6.add(txt_6);
				p7.add(btn6);
				p7.add(txt_7);
				// 상태확인
				t1.addTab("유기동물 상태확인", t5);
				t5.addTab("보호중", p8);
				t5.addTab("보호종료", p9);
				// 보호소 찾기
				// 동물병원찾기
				t1.addTab("보호소 찾기", t6);
				t6.addTab("위치별 보호소 찾기", p10);
				t6.addTab("동물병원 찾기", p11);
				p10.add(btn7);
				p10.add(txt_8);
				p11.add(btn8);
				p11.add(txt_9);
				
				 add(t1);
				
				setSize(1200, 700);
				setLocationRelativeTo(null);
				setVisible(true);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new tab2();
	}
}
