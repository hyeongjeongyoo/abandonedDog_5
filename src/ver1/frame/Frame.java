package ver1.frame;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import ver1.panel.FreeBoard;

public class Frame extends JFrame {

	private Font font;
	
	private JTabbedPane main;
	
	private JTabbedPane home;
	private JTabbedPane board;
	private JTabbedPane missing;
	private JTabbedPane abandonment;
	private JTabbedPane login;

	private FreeBoard freeBoard;
	private JPanel missingBoard;
	private JPanel registerAdopt;
	private JPanel reviewAdopt;
	private JPanel abanAnimalList;
	private JPanel registerAnimal;
	private JPanel searchShelter;

	public Frame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		font = new Font("Noto Sans KR", Font.BOLD, 15);

		main = new JTabbedPane();
		
		home = new JTabbedPane();
		board = new JTabbedPane();
		missing = new JTabbedPane();
		abandonment = new JTabbedPane();
		login = new JTabbedPane();

		freeBoard = new FreeBoard();
		missingBoard = new JPanel();
		registerAdopt = new JPanel();
		reviewAdopt = new JPanel();
		abanAnimalList = new JPanel();
		registerAnimal = new JPanel();
		searchShelter = new JPanel();

	}

	private void setInitLayout() {
		setSize(1200, 700);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		main.addTab("홈", home);
		main.setFont(font);
		home.setFont(font);
		board.setFont(font);
		missing.setFont(font);
		abandonment.setFont(font);

		main.addTab("게시판", board);
		board.addTab("자유게시판", freeBoard);
		board.addTab("실종게시판", missingBoard);

		main.addTab("입양", missing);
		missing.addTab("입양 신청", registerAdopt);
		missing.addTab("입양 후기", reviewAdopt);
		
		main.addTab("보호소", abandonment);
		abandonment.addTab("유기 동물 목록", abanAnimalList);
		abandonment.addTab("유기 동물 등록", registerAnimal);
		abandonment.addTab("보호소 찾기", searchShelter);
		
		// 보호소 찾기
		// 동물병원찾기
		main.addTab("로그인", login);

		add(main);
	}

	private void addEventListener() {

	}

	public static void main(String[] args) {
		new Frame();
	}
}
