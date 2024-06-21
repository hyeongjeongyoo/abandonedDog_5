package ver1.panel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import lombok.Data;
import ver1.DAO.FreeBoardDAO;
import ver1.DTO.FreeBoardDTO;
import ver1.DTO.ShelterDTO;
import ver1.frame.BoardFrame;
import ver1.use.HeaderRenderer;

@Data
public class FreeBoard extends JPanel {

	private BoardFrame mContext;

	private JButton registrationBtn;
	private JButton nextPageBtn;
	private JButton prevPageBtn;
	private JButton refrashBtn;

	private JTable freeTable;
	private JScrollPane freeScroll;
	private TableColumn column;

	private int currentPage = 0;
	private int rowsPerPage = 30; // 한 페이지에 표시할 행 수

	private DefaultTableModel model;
	private Object[][] freeData;

	String[] columnNames = { "id", "제목", "작성자", "작성일" };

	public FreeBoard(BoardFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
		addEventLayout();
		updateTable();
		addTableClickListener();
	}

	public void initData() {

		registrationBtn = new JButton(new ImageIcon("img/registerBtn.jpg"));
		nextPageBtn = new JButton(new ImageIcon("img/nextPageBtn.jpg"));
		prevPageBtn = new JButton(new ImageIcon("img/backPageBtn.jpg"));
		refrashBtn = new JButton(new ImageIcon("img/refrash.png"));

		freeData = new Object[][] { { 1, "안녕하세요 인사드리러왔습니다", "진짜개멍정", "2023-06-30" }, { 2, "인사 오지게 박습니다", "등업 신청이요~" },
				{ 3, "미안하다 이거 보여주려고 어그로끌었다 ", "우리조 코딩 싸움수준 ㄹㅇ실화냐? " }, };
//        freeData = new Object[][] {
//        	{ 1, "안녕하세요 인사드리러왔습니다", "정말 좋은 취지의 사이트네요" },
//        	{ 2, "인사 오지게 박습니다", "등업 신청이요~" },
//        	{ 3, "미안하다 이거 보여주려고 어그로끌었다 ", "우리조 코딩 싸움수준 ㄹㅇ실화냐? " },
//        };

		model = new DefaultTableModel(convertToPageData(), columnNames);
		freeTable = new JTable(model);
		freeScroll = new JScrollPane(freeTable);
		column = freeTable.getColumnModel().getColumn(2); // "contents" 컬럼
	}

	public void setInitLayout() {
		setLayout(null);
		setBackground(Color.white);

		column.setPreferredWidth(500); // 원하는 기본 너비 설정
		column.setMinWidth(300); // 최소 너비 설정
		column.setMaxWidth(800); // 최대 너비 설정

		// 컬럼 헤더 이동 불가
		freeTable.getTableHeader().setReorderingAllowed(false);
		freeTable.getTableHeader().setResizingAllowed(false);

		registrationBtn.setBounds(1099, 560, 60, 30);
		add(registrationBtn);

		refrashBtn.setBounds(20, 600, 50, 50);
		refrashBtn.setBorderPainted(false);
		refrashBtn.setContentAreaFilled(false);
		refrashBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(refrashBtn);

		freeScroll.setBounds(20, 13, 1140, 503);
		freeScroll.setBorder(new TitledBorder(new LineBorder(new Color(13, 170, 93), 3), null));
		freeScroll.getViewport().setBackground(Color.white);
		freeScroll.getViewport().setOpaque(true);
		add(freeScroll);

		prevPageBtn.setBounds(20, 560, 120, 30);
		nextPageBtn.setBounds(150, 560, 120, 30);
		add(prevPageBtn);
		add(nextPageBtn);

		// 컬럼 헤더의 배경색 설정
		JTableHeader header = freeTable.getTableHeader();
		header.setDefaultRenderer(new HeaderRenderer());
	}

	public void addEventLayout() {
		nextPageBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					currentPage++;
					updateTable();
				} catch (NegativeArraySizeException e2) {
					currentPage--;
					JOptionPane.showMessageDialog(null, "마지막 페이지 입니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		prevPageBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentPage == 0) {
					JOptionPane.showMessageDialog(null, "처음 페이지 입니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
				}

				if (currentPage > 0) {
					currentPage--;
				}
				updateTable();
			}
		});

		registrationBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CreateFreeBoard(mContext);
			}
		});
	}

	public void updateTable() {
		DefaultTableModel newModel = new DefaultTableModel(convertToPageData(),
				new String[] { "id", "제목", "작성자", "작성일" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // 모든 셀을 편집 불가능하게 설정
			}
		};
		freeTable.setModel(newModel);

		// Set column widths and other configurations
		DefaultTableCellRenderer genderRenderer = new DefaultTableCellRenderer();
		column = freeTable.getColumnModel().getColumn(0);
		column.setPreferredWidth(20);
		genderRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		column.setCellRenderer(genderRenderer);

		column = freeTable.getColumnModel().getColumn(1);
		column.setPreferredWidth(700);
		genderRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		column.setCellRenderer(genderRenderer);

		column = freeTable.getColumnModel().getColumn(2);
		column.setPreferredWidth(100);

		column = freeTable.getColumnModel().getColumn(3);
		column.setPreferredWidth(100);
	}

	private Object[][] convertToPageData() {
		List<FreeBoardDTO> currentPageData = FreeBoardDAO.getFreeBoard();
		Object[][] pageData = new Object[currentPageData.size()][columnNames.length];

		for (int i = 0; i < currentPageData.size(); i++) {
			FreeBoardDTO dto = currentPageData.get(i);
			pageData[i][0] = dto.getId();
			pageData[i][1] = dto.getTitle();
			pageData[i][2] = dto.getUsername();
			pageData[i][3] = dto.getCreate_date();
		}
		return pageData;
	}

	private void addTableClickListener() {
		freeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 마우스가 두 번 클릭되었는지 확인
				if (e.getClickCount() == 2) {
					// 클릭된 셀의 행과 열 가져오기
					int row = freeTable.rowAtPoint(e.getPoint());
					int column = freeTable.columnAtPoint(e.getPoint());

					// "접수 번호" 컬럼(첫 번째 컬럼)을 클릭했는지 확인
					if (column == 1) {
						CreateFreeBoard cfb = new CreateFreeBoard(mContext);
						FreeBoardDTO dto = FreeBoardDAO.getBoardDto(mContext.getName());
						cfb.titleField.setText(dto.getTitle());
						cfb.contentArea.setText(dto.getContent());
					}
				}
			}
		});
	}

}