package ver1.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

import lombok.Data;
import ver1.panel.AbanAnimalList;
import ver1.panel.ApplyAdoptBoard;
import ver1.panel.FreeBoard;
import ver1.panel.MissingBoard;
import ver1.panel.MyPage;
import ver1.panel.RegisterAnimal;
import ver1.panel.ReviewAdoptReview;
import ver1.panel.ShelterSearch;
import ver1.panel.VisitAnimal;

public class BoardFrame extends JFrame {
	
	public boolean manager;
	public String name;
	public String id;
	public String password;
	public String birthDay;
	public String phoneNum;
	public String authority;
	public  String userDepartmentNo;
	public String userDepartmentName;

	private Font font;

	private JTabbedPane main;

	private JTabbedPane board;
	private JTabbedPane missing;
	private JTabbedPane abandonment;
	
	private Image backgroundImage;

	private VisitAnimal visitAnimal;
	
	private FreeBoard freeBoard;
	private MissingBoard missingBoard;
	
	private ApplyAdoptBoard applyAdoptBoard;
	private ReviewAdoptReview adoptReviewBoard;
	
	private AbanAnimalList abanAnimalListboard;
	private RegisterAnimal registerAnimal;
	private ShelterSearch searchShelter;
	
	private MyPage myPage;
	
	public BoardFrame(boolean manager, String name, String id, String password, String birthDay, String authority, String phoneNum) {
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
	
	public BoardFrame(boolean manager, String name, String id, String password, String birthDay, String authority, String phoneNum, String userDepartmentNo, String userDepartmentName) {
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

    private void initBackgroundImage() {
        backgroundImage = new ImageIcon("img/backgroundBg.png").getImage().getScaledInstance(1400, 900, Image.SCALE_SMOOTH);

    }
    
	
    public void paintComponent(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, this); // 배경 이미지 그리기
    }
    
	private void initData() {

		font = new Font("Noto Sans KR", Font.BOLD, 15);

		main = new JTabbedPane();

		board = new JTabbedPane(JTabbedPane.LEFT);
		missing = new JTabbedPane(JTabbedPane.LEFT);
		abandonment = new JTabbedPane(JTabbedPane.LEFT);

		applyAdoptBoard = new ApplyAdoptBoard();
		abanAnimalListboard = new AbanAnimalList(this);
		visitAnimal = new VisitAnimal();

		Thread thread = new Thread(visitAnimal);
		thread.start();

		adoptReviewBoard = new ReviewAdoptReview();
		freeBoard = new FreeBoard(this);
		missingBoard = new MissingBoard(this);
		registerAnimal = new RegisterAnimal();
		searchShelter = new ShelterSearch();
		myPage = new MyPage(this);

	}

	private void setInitLayout() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/fav.png")); // 파비콘
		setTitle("어서오묘 데려가개");
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
		missing.addTab("", null, null, null);
		missing.addTab(null, new ImageIcon("img/AdoptApply.png"), applyAdoptBoard, null);
		missing.addTab(null, new ImageIcon("img/AdoptReview.png"), adoptReviewBoard, null);

		main.addTab(null, new ImageIcon("img/Shelter.png"), abandonment, null);
		abandonment.addTab("", null, null, null);
		abandonment.addTab(null, new ImageIcon("img/CareAnimal.png"), abanAnimalListboard, null);
		abandonment.addTab(null, new ImageIcon("img/CareApply.png"), registerAnimal, null);
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
		    protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
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

	public AbanAnimalList getAbanAnimalListboard() {
		return abanAnimalListboard;
	}
	
	public FreeBoard getFreeBoard() {
		return freeBoard;
	}
	
	public MyPage getMyPage() {
		return myPage;
	}

	public static void main(String[] args) {
		new BoardFrame(false, null, null, null, null, null, null);
	}
}
