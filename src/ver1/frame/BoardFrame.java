package ver1.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

import ver1.panel.ApplyAdoptBoard;
import ver1.panel.FreeBoard;
import ver1.panel.InterestPat;
import ver1.panel.MissingBoard;
import ver1.panel.MyWriter;
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
	private InterestPat interestPat;
	private MyWriter myWriter;

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
		interestPat = new InterestPat();
		myWriter = new MyWriter();

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
		myPage.setFont(font);

		UIManager.put("TabbedPane.contentAreaColor", Color.white);
		UIManager.put("TabbedPane.selected", Color.white);
		UIManager.put("TabbedPane.background", Color.white);
		UIManager.put("TabbedPane.tabInsets", new Insets(50, 5, 0, 0));

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
		board.addTab("", null, null, null);
		board.addTab(null, new ImageIcon("img/FreeBoard.png"), freeBoard, null);
		board.addTab(null, new ImageIcon("img/MissingBoard.png"), missingBoard, null);

		main.addTab(null, new ImageIcon("img/Adopt.png"), missing, null);
		main.add(emptyPanel, 0);
		missing.addTab("입양 신청", applyAdoptBoard);
		missing.addTab("입양 후기", adoptReviewBoard);

		main.addTab(null, new ImageIcon("img/Shelter.png"), abandonment, null);
		abandonment.addTab("보호 동물 조회", abanAnimalListboard);
		abandonment.addTab("보호 동물 등록", registerAnimal);
		abandonment.addTab("보호소 찾기", searchShelter);

		main.addTab(null, new ImageIcon("img/MyPage.png"), myPage, null);
		myPage.addTab("관심있는 동물", interestPat);
		myPage.addTab("내가 쓴 게시글", myWriter);

		main.setUI(new BasicTabbedPaneUI() {
			@Override
			protected void installDefaults() {
				super.installDefaults();
				tabAreaInsets.left = -10;
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

		board.setUI(new BasicTabbedPaneUI() {
		    @Override
		    protected void installDefaults() {
		        super.installDefaults();
		        tabInsets = new Insets(0, 10, 0, 10); // 탭의 내부 여백 설정
		    }

		    @Override
		    protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
		        // 탭의 배경을 그리는 부분
		    }
		});

		board.setFocusable(false);
		main.setFocusable(false);
		add(main);
	}

	private void addEventListener() {

	}

	public static void main(String[] args) {
		new BoardFrame();
	}
}
