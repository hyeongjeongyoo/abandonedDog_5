package ver1.panel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import ver1.DAO.ReviewBoardDAO;
import ver1.DTO.ReviewBoardDTO;
import ver1.frame.CreateReviewBoardFrame;
import ver1.frame.MainBoardFrame;
import ver1.use.HeaderRenderer;

public class ReviewBoardPanel extends JPanel {
	private MainBoardFrame mContext;
	private JButton registrationBtn;
	private JButton nextPageBtn;
	private JButton prevPageBtn;
	private JButton refrashBtn;

	private JTable animalTable;
	private JScrollPane animalScroll;
	private TableColumn column;

	private int currentPage = 0;
	private int rowsPerPage = 30; // 한 페이지에 표시할 행 수

	private DefaultTableModel model;
	private Object[][] reviewData;

	private JTextField searchText;
	private JButton searchBtn;
	private JLabel title;

	String[] columnNames = { "id", "제목", "내용", "작성자" };

	public ReviewBoardPanel(MainBoardFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
		addEventLayout();
		updateTable();
	}

	public void initData() {
		searchText = new JTextField();
		title = new JLabel("Title");

		searchBtn = new JButton(new ImageIcon("img/serchBtn.jpg"));
		registrationBtn = new JButton(new ImageIcon("img/registerBtn.jpg"));
		nextPageBtn = new JButton(new ImageIcon("img/nextPageBtn.jpg"));
		prevPageBtn = new JButton(new ImageIcon("img/backPageBtn.jpg"));
		refrashBtn = new JButton(new ImageIcon("img/refrash.png"));

		reviewData = getPageData();

		model = new DefaultTableModel(reviewData, columnNames);

		animalTable = new JTable(model);
		animalScroll = new JScrollPane(animalTable);
		column = animalTable.getColumnModel().getColumn(2); // "contents" 컬럼
	}

	public void setInitLayout() {
		setLayout(null);
		setBackground(Color.white);

		//
		column.setPreferredWidth(500); // 원하는 기본 너비 설정
		column.setMinWidth(300); // 최소 너비 설정
		column.setMaxWidth(800); // 최대 너비 설정

		// 컬럼 헤더 이동 불가
		animalTable.getTableHeader().setReorderingAllowed(false);

		searchText.setBounds(895, 700, 200, 22);
		add(searchText);

		searchBtn.setBounds(1099, 700, 59, 20);
		add(searchBtn);

		title.setBounds(860, 700, 80, 20);
		add(title);

		registrationBtn.setBounds(1099, 560, 60, 30);
		add(registrationBtn);

		refrashBtn.setBounds(20, 700, 50, 50);
		refrashBtn.setBorderPainted(false);
		refrashBtn.setContentAreaFilled(false);
		refrashBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(refrashBtn);

		animalScroll.setBounds(20, 13, 1140, 503);
		animalScroll.setBorder(new TitledBorder(new LineBorder(new Color(13, 170, 93), 3), null));
		animalScroll.getViewport().setBackground(Color.white);
		animalScroll.getViewport().setOpaque(true);
		add(animalScroll);

		prevPageBtn.setBounds(20, 560, 120, 30);
		nextPageBtn.setBounds(150, 560, 120, 30);
		add(prevPageBtn);
		add(nextPageBtn);

		JTableHeader header = animalTable.getTableHeader();
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
			}
		});

		registrationBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CreateReviewBoardFrame(mContext);
				updateTable();
			}
		});
	}

	public void updateTable() {
		model = new DefaultTableModel(getPageData(), columnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // 모든 셀을 편집 불가능하게 설정
			}
		};
		animalTable.setModel(model);

		column = animalTable.getColumnModel().getColumn(0);
		column.setMinWidth(40);
		column.setMaxWidth(40);

		column = animalTable.getColumnModel().getColumn(1);
		column.setMinWidth(150);
		column.setMaxWidth(150);

		column = animalTable.getColumnModel().getColumn(2);
		column.setMinWidth(800); // 최소 너비 설정
		column.setMaxWidth(800); // 최대 너비 설정
	}

	private Object[][] getPageData() {
		List<ReviewBoardDTO> currentPageData = ReviewBoardDAO.getReviewBoard();
		Object[][] pageData = new Object[currentPageData.size()][columnNames.length];

		for (int i = 0; i < currentPageData.size(); i++) {
			ReviewBoardDTO dto = currentPageData.get(i);
			pageData[i][0] = dto.getId();
			pageData[i][1] = dto.getTitle();
			pageData[i][2] = dto.getContent();
			pageData[i][3] = dto.getUsername();
		}
		return pageData;
	}
}
