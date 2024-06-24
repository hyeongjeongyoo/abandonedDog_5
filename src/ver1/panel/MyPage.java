package ver1.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import ver1.DAO.FreeBoardDAO;
import ver1.DAO.MyPageDAO;
import ver1.DTO.FreeBoardDTO;
import ver1.DTO.InterestDTO;
import ver1.frame.BoardFrame;
import ver1.frame.ViewFreeBoard;
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

	private List<List<FreeBoard>> myPageNum;

	private TableColumn column;

	private DefaultTableModel petModel;
	String[] petColumnNames = { "동물 번호", "품종", "추가 날짜" };
	private Object[][] myPageData;
	private JTable interestAnimal;
	private JScrollPane animalScroll;

	private DefaultTableModel writeModel;
	String[] columnNames = { "id", "제목", "작성일" };
	private Object[][] myWriteData;
	private JTable myWriter;
	private JScrollPane myWriterScroll;

	private DefaultTableModel commonModel;
	String[] permissionCommon = { "id", "승인상태" };
	private Object[][] applyData;
	private JTable permissionCommonTable;
	private JScrollPane permissionCommonPane;

	private DefaultTableModel managerModel;
	String[] permissionManager = { "Id", "신청자명" };
	private Object[][] permissionData;
	private JTable permissionManagerTable;
	private JScrollPane permissionManagerPane;

	private ImageIcon info;

	private JLabel managerLabel;
	private JLabel commonLabel;

	private JTableHeader header;

	public MyPage(BoardFrame mContext) {
		this.mContext = mContext;
		initDate();
		setInitLayout();
		addEventListener();
	}

	private void initDate() {

		if (mContext.manager) {
			info = new ImageIcon("img/managerBtn.png");
			memberNum = new JLabel();
			memberName = new JLabel();
		} else {
			info = new ImageIcon("img/common.png");
		}

		changeName = new JButton(new ImageIcon("img/editBtn.jpg"));
		changePassword = new JButton(new ImageIcon("img/editBtn.jpg"));
		changeBirth = new JButton(new ImageIcon("img/editBtn.jpg"));
		changePhoneNum = new JButton(new ImageIcon("img/editBtn.jpg"));

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

		myWriteData = myWriteConvertToPageData(mContext.name);
		writeModel = new DefaultTableModel(myWriteData, columnNames);
		myWriter = new JTable(writeModel) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // 모든 셀을 편집 불가능하게 설정
			}
		};
		myWriterScroll = new JScrollPane(myWriter);

		myPageData = interestConvertToPageData(mContext.name);
		petModel = new DefaultTableModel(myPageData, petColumnNames);
		interestAnimal = new JTable(petModel) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // 모든 셀을 편집 불가능하게 설정
			}
		};
		animalScroll = new JScrollPane(interestAnimal);

		commonModel = new DefaultTableModel(applyData, permissionCommon);
		permissionCommonTable = new JTable(commonModel) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // 모든 셀을 편집 불가능하게 설정
			}
		};
		permissionCommonPane = new JScrollPane(permissionCommonTable);

		managerModel = new DefaultTableModel(permissionData, permissionManager);
		permissionManagerTable = new JTable(managerModel) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // 모든 셀을 편집 불가능하게 설정
			}
		};
		permissionManagerPane = new JScrollPane(permissionManagerTable);

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

		Font font = new Font("Noto Sans KR", Font.BOLD, 15);

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

		if (mContext.manager) {
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
			memberNum.setText(mContext.userDepartmentNo);
			memberName.setText(mContext.userDepartmentName);

			permissionManagerPane.setBounds(1125, 80, 200, 200);
			permissionManagerPane.setBorder(new TitledBorder(new LineBorder(new Color(13, 170, 93), 3), null));
			permissionManagerPane.getViewport().setBackground(Color.white);
			permissionManagerPane.getViewport().setOpaque(true);
			permissionManagerTable.getTableHeader().setReorderingAllowed(false);
			permissionManagerTable.getTableHeader().setResizingAllowed(false);
			header = permissionManagerTable.getTableHeader();
			header.setDefaultRenderer(new HeaderRenderer());
			add(permissionManagerPane);
		} else {
			add(commonLabel);
			permissionCommonPane.setBounds(1125, 80, 200, 200);
			permissionCommonPane.setBorder(new TitledBorder(new LineBorder(new Color(13, 170, 93), 3), null));
			permissionCommonPane.getViewport().setBackground(Color.white);
			permissionCommonPane.getViewport().setOpaque(true);
			permissionCommonTable.getTableHeader().setReorderingAllowed(false);
			permissionCommonTable.getTableHeader().setResizingAllowed(false);
			header = permissionCommonTable.getTableHeader();
			header.setDefaultRenderer(new HeaderRenderer());
			add(permissionCommonPane);
		}

		animalScroll.setBounds(50, 410, 600, 330);
		animalScroll.setBorder(new TitledBorder(new LineBorder(new Color(13, 170, 93), 3), null));
		animalScroll.getViewport().setBackground(Color.white);
		animalScroll.getViewport().setOpaque(true);
		interestAnimal.getTableHeader().setReorderingAllowed(false);
		interestAnimal.getTableHeader().setResizingAllowed(false);
		header = interestAnimal.getTableHeader();
		header.setDefaultRenderer(new HeaderRenderer());
		add(animalScroll);

		myWriterScroll.setBounds(730, 410, 600, 330);
		myWriterScroll.setBorder(new TitledBorder(new LineBorder(new Color(13, 170, 93), 3), null));
		myWriterScroll.getViewport().setBackground(Color.white);
		myWriterScroll.getViewport().setOpaque(true);
		myWriter.getTableHeader().setReorderingAllowed(false);
		myWriter.getTableHeader().setResizingAllowed(false);
		header = myWriter.getTableHeader();
		header.setDefaultRenderer(new HeaderRenderer());
		add(myWriterScroll);

		nameField.setText(mContext.name);
		idField.setText(mContext.id);
		passwordField.setText(mContext.password);
		birthField.setText(mContext.birthDay);
		phoneNum.setText(mContext.phoneNum);

	}

	private void addEventListener() {

		interestAnimal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 마우스가 두 번 클릭되었는지 확인
				if (e.getClickCount() == 2) {
					// 클릭된 셀의 행과 열 가져오기
					int row = interestAnimal.rowAtPoint(e.getPoint());
					int column = interestAnimal.columnAtPoint(e.getPoint());

					// "접수 번호" 컬럼(첫 번째 컬럼)을 클릭했는지 확인
					if (column == 0) {
						mContext.getMain().setSelectedIndex(3);
						mContext.getAbandonment().setSelectedIndex(1);
						mContext.getAbanAnimalListboard()
								.searchCareAnimal((Integer) interestAnimal.getValueAt(row, column));
					}
				}
			}
		});

		myWriter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 마우스가 두 번 클릭되었는지 확인
				if (e.getClickCount() == 2) {
					// 클릭된 셀의 행과 열 가져오기
					int row = myWriter.rowAtPoint(e.getPoint());
					int column = myWriter.columnAtPoint(e.getPoint());

					// "접수 번호" 컬럼(첫 번째 컬럼)을 클릭했는지 확인
					if (column == 1) {
						ViewFreeBoard viewBoard = new ViewFreeBoard(mContext);
						List<FreeBoardDTO> dtos = FreeBoardDAO.getBoardDtos(mContext.name);
						String title = (String) myWriter.getValueAt(row, column);
						for (FreeBoardDTO dto : dtos) {
							if (title.equals(dto.getTitle())) {
								viewBoard.setTitle(dto.getUsername() + "님의 게시물");
								viewBoard.titleField.setText(dto.getTitle());
								viewBoard.nameField.setText(dto.getUsername());
								viewBoard.contentArea.setText(dto.getContent());
							}
						}
					}
				}
			}
		});

	}

	public void updateMyWrite() {
		DefaultTableModel newModel = new DefaultTableModel(myWriteConvertToPageData(mContext.name), petColumnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		myWriter.setModel(newModel);
		column = myWriter.getColumnModel().getColumn(0);
		column.setMaxWidth(50);
		column.setMinWidth(50);
	}

	public void updateMyAdopt() {

	}

	public void updateManagerAdopt() {

	}

	public void updateInterestAnimal(Object[][] data) {
		DefaultTableModel newModel = new DefaultTableModel(data, petColumnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		interestAnimal.setModel(newModel);
		column = interestAnimal.getColumnModel().getColumn(0);
		column.setMaxWidth(80);
		column.setMinWidth(80);
	}

	public Object[][] interestConvertToPageData(String userName) {
		List<InterestDTO> currentPageData = MyPageDAO.addInterestAnimal(userName);
		Object[][] pageData = new Object[currentPageData.size()][petColumnNames.length];

		for (int i = 0; i < currentPageData.size(); i++) {
			InterestDTO dto = currentPageData.get(i);
			pageData[i][0] = dto.getId();
			pageData[i][1] = dto.getKindCd();
			pageData[i][2] = dto.getAddDate();
		}
		return pageData;
	}

	public Object[][] myWriteConvertToPageData(String userName) {
		List<FreeBoardDTO> currentPageData = MyPageDAO.addMyWrite(mContext.name);
		Object[][] pageData = new Object[currentPageData.size()][petColumnNames.length];

		for (int i = 0; i < currentPageData.size(); i++) {
			FreeBoardDTO dto = currentPageData.get(i);
			pageData[i][0] = dto.getId();
			pageData[i][1] = dto.getTitle();
			pageData[i][2] = dto.getCreate_date();
		}
		return pageData;
	}

	public static void main(String[] args) {

		JFrame frame = new JFrame("Sand Animation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new MyPage(new BoardFrame(false, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY,
				TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY)));
		frame.setSize(1400, 900);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}
}
