package ver1.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

import ver1.panel.ApplyAdoptPanel;
import ver1.panel.FreeBoardPanel;
import ver1.panel.HomePanel;
import ver1.panel.MissingBoardPanel;
import ver1.panel.MyPagePanel;
import ver1.panel.RegisterAnimalPanel;
import ver1.panel.ReviewBoardPanel;
import ver1.panel.ShelterSearchPanel;
import ver1.panel.ViewAnimalPanel;

public class MainBoardFrame extends JFrame {

	public boolean manager;
	public String name;
	public String id;
	public String password;
	public String birthDay;
	public String phoneNum;
	public String authority;
	public String userDepartmentNo;
	public String userDepartmentName;

	private Font font;

	private JTabbedPane main;

	private JTabbedPane board;
	private JTabbedPane missing;
	private JTabbedPane abandonment;

	private HomePanel homePanel;

	private FreeBoardPanel freeBoard;
	private MissingBoardPanel missingBoard;

	private ApplyAdoptPanel applyAdoptBoard;
	private ReviewBoardPanel adoptReviewBoard;

	private ViewAnimalPanel abanAnimalListboard;
	private RegisterAnimalPanel registerAnimal;
	private ShelterSearchPanel searchShelter;

	private MyPagePanel myPage;

	public MainBoardFrame(boolean manager, String name, String id, String password, String birthDay, String authority,
			String phoneNum) {
		this.manager = manager;
		this.name = name;
		this.id = id;
		this.password = password;
		this.birthDay = birthDay;
		this.authority = authority;
		this.phoneNum = phoneNum;
		initData();
		setInitLayout();
	}

	public MainBoardFrame(boolean manager, String name, String id, String password, String birthDay, String authority,
			String phoneNum, String userDepartmentNo, String userDepartmentName) {
		this.manager = manager;
		this.name = name;
		this.id = id;
		this.password = password;
		this.birthDay = birthDay;
		this.authority = authority;
		this.phoneNum = phoneNum;
		this.userDepartmentNo = userDepartmentNo;
		this.userDepartmentName = userDepartmentName;
		initData();
		setInitLayout();
	}

	private void initData() {

		font = new Font("Noto Sans KR", Font.BOLD, 15);

		main = new JTabbedPane();

		board = new JTabbedPane(JTabbedPane.LEFT);
		missing = new JTabbedPane(JTabbedPane.LEFT);
		abandonment = new JTabbedPane(JTabbedPane.LEFT);

		applyAdoptBoard = new ApplyAdoptPanel(this);
		abanAnimalListboard = new ViewAnimalPanel(this);
		homePanel = new HomePanel();

		Thread thread = new Thread(homePanel);
		thread.start();

		adoptReviewBoard = new ReviewBoardPanel(this);
		freeBoard = new FreeBoardPanel(this);
		missingBoard = new MissingBoardPanel(this);
		registerAnimal = new RegisterAnimalPanel(this);
		searchShelter = new ShelterSearchPanel();
		myPage = new MyPagePanel(this);

	}

	private void setInitLayout() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/fav.png")); // 파비콘
		setTitle("어서오묘 데려가개");
		setSize(1400, 900);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		UIManager.put("TabbedPane.contentAreaColor", Color.white);
		UIManager.put("TabbedPane.selected", Color.white);
		UIManager.put("TabbedPane.background", Color.white);
		UIManager.put("TabbedPane.tabInsets", new Insets(50, 5, 0, 0));

		main.setFont(font);
		board.setFont(font);
		missing.setFont(font);
		abandonment.setFont(font);
		myPage.setFont(font);

		main.setOpaque(true);
		board.setOpaque(true);
		missing.setOpaque(true);
		abandonment.setOpaque(true);
		myPage.setOpaque(true);

		main.setBackground(Color.white);
		board.setBackground(Color.white);
		missing.setBackground(Color.white);
		abandonment.setBackground(Color.white);

		main.addTab(null, new ImageIcon("img/Home.png"), homePanel, null);

		main.addTab(null, new ImageIcon("img/Board.png"), board, null);
		board.addTab("", null, null, null);
		board.addTab(null, new ImageIcon("img/FreeBoard.png"), freeBoard, null);
		board.addTab(null, new ImageIcon("img/MissingBoard.png"), missingBoard, null);

		main.addTab(null, new ImageIcon("img/Adopt.png"), missing, null);
		missing.addTab("", null, null, null);
		missing.addTab(null, new ImageIcon("img/AdoptApply.png"), applyAdoptBoard, null);
		if(!manager) {
			missing.addTab(null, new ImageIcon("img/AdoptReview.png"), adoptReviewBoard, null);
		}

		main.addTab(null, new ImageIcon("img/Shelter.png"), abandonment, null);
		abandonment.addTab("", null, null, null);
		abandonment.addTab(null, new ImageIcon("img/CareAnimal.png"), abanAnimalListboard, null);
		if(manager) {
			abandonment.addTab(null, new ImageIcon("img/CareApply.png"), registerAnimal, null);
		}
		abandonment.addTab(null, new ImageIcon("img/CareSearch.png"), searchShelter, null);

		main.addTab(null, new ImageIcon("img/MyPage.png"), myPage, null);

		main.setUI(new BasicTabbedPaneUI() {
			@Override
			protected void installDefaults() {
				super.installDefaults();
				tabAreaInsets.left = -3;
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

		board.setUI(addUI());
		missing.setUI(addUI());
		abandonment.setUI(addUI());

		board.setSelectedIndex(1);
		missing.setSelectedIndex(1);
		abandonment.setSelectedIndex(1);

		board.setFocusable(false);
		missing.setFocusable(false);
		abandonment.setFocusable(false);
		main.setFocusable(false);
		add(main);
	}

	private BasicTabbedPaneUI addUI() {

		return new BasicTabbedPaneUI() {
			@Override
			protected void installDefaults() {
				super.installDefaults();
				tabInsets = new Insets(0, 10, 0, 10); // 탭의 내부 여백 설정
			}

			@Override
			protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h,
					boolean isSelected) {
				// 탭의 배경을 그리는 부분
			}
		};
	}

	public JTabbedPane getMain() {
		return main;
	}

	public String getName() {
		return name;
	}

	public JTabbedPane getAbandonment() {
		return abandonment;
	}

	public ViewAnimalPanel getAbanAnimalListboard() {
		return abanAnimalListboard;
	}

	public FreeBoardPanel getFreeBoard() {
		return freeBoard;
	}

	public MyPagePanel getMyPage() {
		return myPage;
	}

	public ReviewBoardPanel getAdoptReviewBoard() {
		return adoptReviewBoard;
	}

	public MissingBoardPanel getMissingBoard() {
		return missingBoard;
	}

}
