package ver1.frame;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

import ver1.panel.FreeBoard;
import ver1.panel.MissingBoard;
import ver1.panel.RegisterAdoptBoard;
import ver1.panel.ReviewAdopt;
import ver1.panel.VisitAnimal;

public class BoardFrame extends JFrame {

	private Font font;

	private JTabbedPane main;

	private JTabbedPane board;
	private JTabbedPane missing;
	private JTabbedPane abandonment;

	private RegisterAdoptBoard registerAdoptBoard;
	private VisitAnimal visitAnimal;
	private ReviewAdopt adoptReviewBoard;
	private FreeBoard freeBoard;
	private MissingBoard missingBoard;
	private JPanel registerAdopt;
	private JPanel abanAnimalList;
	private JPanel registerAnimal;
	private JPanel searchShelter;

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

		board = new JTabbedPane();
		missing = new JTabbedPane();
		abandonment = new JTabbedPane();

		registerAdoptBoard = new RegisterAdoptBoard();
		visitAnimal = new VisitAnimal();
		adoptReviewBoard = new ReviewAdopt();
		freeBoard = new FreeBoard();
		missingBoard = new MissingBoard();
		registerAdopt = new JPanel();
		abanAnimalList = new JPanel();
		registerAnimal = new JPanel();
		searchShelter = new JPanel();
	}

	private void setInitLayout() {
		setSize(1200, 700);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		main.setFont(font);
		board.setFont(font);
		missing.setFont(font);
		abandonment.setFont(font);

		main.addTab("홈", visitAnimal);

		main.addTab("게시판", board);
		board.addTab("자유게시판", freeBoard);
		board.addTab("실종게시판", missingBoard);

		main.addTab("입양", missing);
		missing.addTab("입양 신청", registerAdoptBoard);
		missing.addTab("입양 후기", adoptReviewBoard);

		main.addTab("보호소", abandonment);
		abandonment.addTab("유기 동물 목록", abanAnimalList);
		abandonment.addTab("유기 동물 등록", registerAnimal);
		abandonment.addTab("보호소 찾기", searchShelter);

		main.setUI(emptyTap());

		add(main);
	}

	private void addEventListener() {

	}

	public static BasicTabbedPaneUI emptyTap() {
		BasicTabbedPaneUI emptyTap = new BasicTabbedPaneUI() {
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
		};
		return emptyTap;
	}

	public static void main(String[] args) {
		new BoardFrame();
	}
}
