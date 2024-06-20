package ver1.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

import ver1.panel.ApplyAdoptBoard;
import ver1.panel.FreeBoard;
import ver1.panel.MissingBoard;
import ver1.panel.RegisterAnimal;
import ver1.panel.ReviewAdopt;
import ver1.panel.ShelterSearch;
import ver1.panel.VisitAnimal;
import ver1.panel.abanAnimalList;

public class BoardFrame extends JFrame {

	private Font font;

	private JTabbedPane main;

	private JTabbedPane board;
	private JTabbedPane missing;
	private JTabbedPane abandonment;
	private JTabbedPane myPage;

	private ApplyAdoptBoard applyAdoptBoard;
	private abanAnimalList abanAnimalListboard;
	private VisitAnimal visitAnimal;
	private ReviewAdopt adoptReviewBoard;
	private FreeBoard freeBoard;
	private MissingBoard missingBoard;
	private RegisterAnimal registerAnimal;
	private ShelterSearch searchShelter;

	private JPanel emptyPanel;

	public BoardFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/fav.png")); // 파비콘
		setTitle("어서오묘 데러가개");

		font = new Font("Noto Sans KR", Font.BOLD, 15);

		main = new JTabbedPane();

		board = new JTabbedPane(JTabbedPane.LEFT);
		missing = new JTabbedPane(JTabbedPane.LEFT);
		abandonment = new JTabbedPane(JTabbedPane.LEFT);
		myPage = new JTabbedPane(JTabbedPane.LEFT);

		applyAdoptBoard = new ApplyAdoptBoard();
		abanAnimalListboard = new abanAnimalList();
		visitAnimal = new VisitAnimal();

		// TODO 프레임 작업 중지
//		Thread thread = new Thread(visitAnimal);
//		thread.start();

		adoptReviewBoard = new ReviewAdopt();
		freeBoard = new FreeBoard();
		missingBoard = new MissingBoard();
		registerAnimal = new RegisterAnimal();
		searchShelter = new ShelterSearch();

		emptyPanel = new JPanel();
	}

	private void setInitLayout() {
		setSize(1400, 900);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		main.setFont(font);
		board.setFont(font);
		missing.setFont(font);
		abandonment.setFont(font);
		
		UIManager.put("TabbedPane.contentAreaColor", Color.white);
		UIManager.put("TabbedPane.selected", Color.white);
		UIManager.put("TabbedPane.background", Color.white);
		UIManager.put("TabbedPane.tabInsets", new Insets(50, 10, 0, 10));

		main.setOpaque(true);
		board.setOpaque(true);
		missing.setOpaque(true);
		abandonment.setOpaque(true);
		myPage.setOpaque(true);
		
	    main.setBackground(Color.white);
	    board.setBackground(Color.white);
	    missing.setBackground(Color.white);
	    abandonment.setBackground(Color.white);

		main.addTab(null, new ImageIcon("img/Home.png"), visitAnimal, null);

		main.addTab(null, new ImageIcon("img/Board.png"), board, null);
		board.addTab("자유게시판", freeBoard);
		board.addTab("보호게시판", missingBoard);
		board.setBackground(Color.white);

		main.addTab(null, new ImageIcon("img/Adopt.png"), missing, null);
		main.add(emptyPanel, 0);
		missing.addTab("입양 신청", applyAdoptBoard);
		missing.addTab("입양 후기", adoptReviewBoard);

		main.addTab(null, new ImageIcon("img/Shelter.png"), abandonment, null);
		abandonment.addTab("보호 동물 조회", abanAnimalListboard);
		abandonment.addTab("보호 동물 등록", registerAnimal);
		abandonment.addTab("보호소 찾기", searchShelter);
		
		main.addTab(null, new ImageIcon("img/MyPage.png"), myPage, null);

		main.setUI(new BasicTabbedPaneUI() {
			@Override
			protected void installDefaults() {
				super.installDefaults();
				tabAreaInsets.left = 0;
			}

			@Override
			protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h,
					boolean isSelected) {
			}

			@Override
			protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h,
					boolean isSelected) {
			}
		});

		main.setFocusable(false);
		add(main);
	}

	private void addEventListener() {

	}
	
	public static void main(String[] args) {
		new BoardFrame();
	}
}
