package ver1.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import lombok.Data;
import ver1.SandAnimation;
import ver1.frame.BoardFrame;
import ver1.use.HeaderRenderer;

@Data
public class MyPage extends JPanel {

	private BoardFrame mContext;

	public JLabel nameField;
	public JLabel idField;
	public JLabel passwordField;
	public JLabel birthField;
	public JLabel phoneNum;
	public JLabel memberNum;
	public JLabel memberName;

	private JLabel selfImage;
	private JLabel commonInfo;
	private JLabel managerInfo;
	private JPanel interestPet;

	private JButton changeName;
	private JButton changePassword;
	private JButton changeBirth;
	private JButton changePhoneNum;

	private DefaultTableModel writeModel;
	private DefaultTableModel petModel;
	private List<List<FreeBoard>> myPageNum;
	private Object[][] myPageData;

	private TableColumn column;

	String[] petColumnNames = { "동물 번호", "품종", "추가 날짜" };
	private JTable interestAnimal;
	private JScrollPane animalScroll;

	String[] columnNames = { "id", "제목", "작성일" };
	private JTable myWriter;
	private JScrollPane myWriterScroll;

	private ImageIcon info;

	private JLabel managerLabel;
	private JLabel commonLabel;

	public MyPage(BoardFrame mContext) {
		this.mContext = mContext;
		initDate();
		setInitLayout();
		addEventListener();
	}

	private void initDate() {

		// TODO DB 연결 필
//		if(mContext.manager) {
		info = new ImageIcon("img/managerBtn.png");
		memberNum = new JLabel();
		memberName = new JLabel();
//		} else {
		info = new ImageIcon("img/common.png");
//		}

		changeName = new JButton("수정");
		changePassword = new JButton("수정");
		changeBirth = new JButton("수정");
		changePhoneNum = new JButton("수정");

		nameField = new JLabel();
		idField = new JLabel();
		passwordField = new JLabel();
		birthField = new JLabel();
		phoneNum = new JLabel();

		selfImage = new JLabel(new ImageIcon("img/Self.jpg"));
		managerLabel = new JLabel(info);
		commonLabel = new JLabel(info);

		commonInfo = new JLabel(new ImageIcon("img/CommonData.png"));
		managerInfo = new JLabel(new ImageIcon("img/Self.jpg"));
		interestPet = new JPanel();

		myPageData = new Object[][] { { 1, "안녕하세요 인사드리러왔습니다", "2024-10-21" }, { 2, "인사 오지게 박습니다", "2024-10-21" },
				{ 3, "미안하다 이거 보여주려고 어그로끌었다 ", "2024-10-21" }, };

		writeModel = new DefaultTableModel(myPageData, columnNames);
		myWriter = new JTable(writeModel) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // 모든 셀을 편집 불가능하게 설정
			}
		};
		myWriterScroll = new JScrollPane(myWriter);

		petModel = new DefaultTableModel(myPageData, petColumnNames);
		interestAnimal = new JTable(petModel) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // 모든 셀을 편집 불가능하게 설정
			}
		};
		animalScroll = new JScrollPane(interestAnimal);

		// TODO 컬럼쓰는 법 다시 확인 - 형정
		column = myWriter.getColumnModel().getColumn(0);
		column.setMaxWidth(50);
		column.setMinWidth(50);
		
		column = interestAnimal.getColumnModel().getColumn(0);
		column.setMaxWidth(80);
		column.setMinWidth(80);
	}

	private void setInitLayout() {
		setLayout(null);
		setBackground(Color.white);

		myWriter.getTableHeader().setReorderingAllowed(false);
		myWriter.getTableHeader().setResizingAllowed(false);

		interestAnimal.getTableHeader().setReorderingAllowed(false);
		interestAnimal.getTableHeader().setResizingAllowed(false);

		Font font = new Font("Noto Sans KR", Font.BOLD, 15);

		JTableHeader header = myWriter.getTableHeader();
		header.setDefaultRenderer(new HeaderRenderer());
		header = interestAnimal.getTableHeader();
		header.setDefaultRenderer(new HeaderRenderer());

		selfImage.setBounds(50, 70, 200, 250);
		selfImage.setBackground(Color.white);
		selfImage.setBorder(new TitledBorder(new LineBorder(new Color(13, 170, 93), 3), null));
		add(selfImage);

		nameField.setSize(130, 30);
		nameField.setLocation(400, 80);
		nameField.setBorder(new LineBorder(new Color(13, 170, 93), 1));
		nameField.setFont(font);
		add(nameField);

		idField.setSize(130, 30);
		idField.setLocation(400, 148);
		idField.setBorder(new LineBorder(new Color(13, 170, 93), 1));
		idField.setFont(font);
		add(idField);

		passwordField.setSize(130, 30);
		passwordField.setLocation(400, 213);
		passwordField.setBorder(new LineBorder(new Color(13, 170, 93), 1));
		passwordField.setFont(font);
		add(passwordField);

		birthField.setSize(130, 30);
		birthField.setLocation(400, 275);
		birthField.setBorder(new LineBorder(new Color(13, 170, 93), 1));
		birthField.setFont(font);
		add(birthField);

		phoneNum.setSize(130, 30);
		phoneNum.setLocation(800, 80);
		phoneNum.setBorder(new LineBorder(new Color(13, 170, 93), 1));
		phoneNum.setFont(font);
		add(phoneNum);

		changeName.setSize(80, 30);
		changeName.setLocation(540, 80);
		changeName.setFont(font);
		add(changeName);

		changePassword.setSize(80, 30);
		changePassword.setLocation(540, 213);
		changePassword.setFont(font);
		add(changePassword);

		changeBirth.setSize(80, 30);
		changeBirth.setLocation(540, 275);
		changeBirth.setFont(font);
		add(changeBirth);

		changePhoneNum.setSize(80, 30);
		changePhoneNum.setLocation(940, 80);
		changePhoneNum.setFont(font);
		add(changePhoneNum);

		managerLabel.setSize(103, 24);
		managerLabel.setLocation(50, 30);

		commonLabel.setSize(103, 24);
		commonLabel.setLocation(50, 30);

		// TODO DB 연결 필
//		if(mContext.manager) {
		add(managerLabel);
		memberNum.setSize(130, 30);
		memberNum.setLocation(800, 148);
		memberNum.setBorder(new LineBorder(new Color(13, 170, 93), 1));
		memberNum.setFont(font);
		add(memberNum);

		memberName.setSize(130, 30);
		memberName.setLocation(800, 213);
		memberName.setBorder(new LineBorder(new Color(13, 170, 93), 1));
		memberName.setFont(font);
		add(memberName);
//		} else {
		add(commonLabel);
//		}

		animalScroll.setBounds(50, 410, 600, 330);
		animalScroll.setBorder(new TitledBorder(new LineBorder(new Color(13, 170, 93), 3), null));
		animalScroll.getViewport().setBackground(Color.white);
		animalScroll.getViewport().setOpaque(true);
		add(animalScroll);

		myWriterScroll.setBounds(730, 410, 600, 330);
		myWriterScroll.setBorder(new TitledBorder(new LineBorder(new Color(13, 170, 93), 3), null));
		myWriterScroll.getViewport().setBackground(Color.white);
		myWriterScroll.getViewport().setOpaque(true);
		add(myWriterScroll);

//		DefaultTableModel newModel = new DefaultTableModel(getMyPageData(), columnNames) {
//			@Override
//			public boolean isCellEditable(int row, int column) {
//				return false;
//			}
//		};
//		
//		myWriter.setModel(newModel);

	}

	private void addEventListener() {

	}

	public static void main(String[] args) {

		JFrame frame = new JFrame("Sand Animation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new MyPage(null));
		frame.setSize(1400, 900);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}
}
