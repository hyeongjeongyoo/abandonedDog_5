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

public class FreeBoard extends JPanel {

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

	public FreeBoard() {
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
		String[] columnNames = { "id", "title", "contents" };
		dogData = new Object[][] { { 1, "안녕하세요 인사드리러왔습니다", "정말 좋은 취지의 사이트네요" }, 
				{ 2, "인사 오지게 박습니다", "등업 신청이요~" },
				{ 3, "미안하다 이거 보여주려고 어그로끌었다 ", "우리조 코딩 싸움수준 ㄹㅇ실화냐? " },

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
				new String[] { "id", "title", "contents"});
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
