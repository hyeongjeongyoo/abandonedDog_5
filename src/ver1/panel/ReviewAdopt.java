package ver1.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ReviewAdopt extends JPanel {

	private JButton registrationBtn;
	private JButton nextPageBtn;
	private JButton prevPageBtn;
	private JTable dogTable;
	private JScrollPane dogScroll;
	private TableColumn column;
	private int currentPage = 0;
	private int rowsPerPage = 30; // 한 페이지에 표시할 행 수
	private DefaultTableModel model;
	private Object[][] dogData;

	public ReviewAdopt() {
		initData();
		setInitLayout();
		addEventLayout();
		updateTable();
	}

	public void initData() {
		registrationBtn = new JButton("등록");
		nextPageBtn = new JButton("다음 페이지");
		prevPageBtn = new JButton("이전 페이지");

		// 자유게시판 샘플데이터
		String[] columnNames = { "id", "title", "contents", "writer", "date" };
		dogData = new Object[][] { { 1, "우리 푸푸", "푸푸는 잘먹고 잘싸고 잘지내고있엉요", "푸푸맘", "2024-06-20" },
				{ 2, "세상에서 가장 귀여운 놈", "3개월전에 데려온 놈놈이 너무 귀여워요 ", "샤넬백", "2024-01-13" },
				{ 3, "누룽지의 성장일기 ", "누룽지는 점점 누래지고 있어용", "숭늉", "2023-12-25" },

		};

		// 각 패널에 JTable 생성 및 샘플 데이터 추가
		model = new DefaultTableModel(dogData, columnNames);
		dogTable = new JTable(model);
		dogScroll = new JScrollPane(dogTable);
		column = dogTable.getColumnModel().getColumn(2); // "specialMark" 컬럼
	}

	public void setInitLayout() {
		setLayout(null);

		//
		column.setPreferredWidth(500); // 원하는 기본 너비 설정
		column.setMinWidth(300); // 최소 너비 설정
		column.setMaxWidth(800); // 최대 너비 설정

		// 컬럼 헤더 이동 불가
		dogTable.getTableHeader().setReorderingAllowed(false);

		registrationBtn.setBounds(1040, 0, 60, 30);
		add(registrationBtn);

		dogScroll.setBounds(20, 50, 1000, 503);
		add(dogScroll); // 스크롤 가능하도록 JScrollPane으로 감싸줍니다.

		prevPageBtn.setBounds(20, 560, 120, 30);
		nextPageBtn.setBounds(150, 560, 120, 30);
		add(prevPageBtn);
		add(nextPageBtn);
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

				if (currentPage > 0) {
					currentPage--;
				}
				updateTable();
			}
		});
	}

	private void updateTable() {
		DefaultTableModel newModel = new DefaultTableModel(getPageData(),
				new String[] { "id", "title", "contents", "writer", "date" });
		dogTable.setModel(newModel);

		column = dogTable.getColumnModel().getColumn(2); // "specialMark" 컬럼
		column.setPreferredWidth(500); // 원하는 기본 너비 설정
		column.setMinWidth(300); // 최소 너비 설정
		column.setMaxWidth(800); // 최대 너비 설정
	}

	private Object[][] getPageData() {
		int start = currentPage * rowsPerPage;
		int end = Math.min(start + rowsPerPage, dogData.length);
		Object[][] pageData = new Object[end - start][];
		for (int i = start; i < end; i++) {
			pageData[i - start] = dogData[i];
		}
		return pageData;
	}
}
