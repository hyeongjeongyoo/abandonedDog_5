package ver1.panel;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import ver1.DAO.MissingBoardDAO;
import ver1.DTO.MissingBoardDTO;

public class MissingBoard extends JPanel {

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
	private List<List<MissingBoardDTO>> animalData;

	private JTextField searchText;
	private JButton searchBtn;
	private JComboBox<String> searchComboBox;

	String[] columnNames = { "접수 번호", "품종", "색깔", "나이", "무게", "보호상태", "성별", "중성화", "특이사항" };

	public MissingBoard() {
		initData();
		setInitLayout();
		addEventLayout();
		updateTable();
	}

	public void initData() {

		searchText = new JTextField();
		searchBtn = new JButton("검색");
		searchComboBox = new JComboBox<>();

		registrationBtn = new JButton("등록");
		nextPageBtn = new JButton("다음 페이지");
		prevPageBtn = new JButton("이전 페이지");
		refrashBtn = new JButton(new ImageIcon("img/refrash.png"));

		// 데이터 불러오기
		animalData = MissingBoardDAO.getMissingDTOList();

		model = new DefaultTableModel(convertToPageData(), columnNames);
		animalTable = new JTable(model);
		animalScroll = new JScrollPane(animalTable);

		searchComboBox.setModel(new DefaultComboBoxModel<>(columnNames));
	}

	public void setInitLayout() {
		setLayout(null);

		// 컬럼 헤더 이동 불가
		animalTable.getTableHeader().setReorderingAllowed(false);

		searchText.setBounds(895, 25, 200, 22);
		add(searchText);

		searchBtn.setBounds(1099, 25, 59, 20);
		add(searchBtn);

		searchComboBox.setBounds(810, 25, 80, 20);
		add(searchComboBox);

		registrationBtn.setBounds(1099, 560, 60, 30);
		add(registrationBtn);

		refrashBtn.setBounds(20, 0, 50, 50);
		refrashBtn.setBorderPainted(false);
		refrashBtn.setContentAreaFilled(false);
		refrashBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(refrashBtn);

		animalScroll.setBounds(20, 50, 1140, 503);
		add(animalScroll);

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
				} catch (Exception e2) {
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
					updateTable();
				}
			}
		});
	}

	private void updateTable() {
		DefaultTableModel newModel = new DefaultTableModel(convertToPageData(), columnNames);
		animalTable.setModel(newModel);

		// TableColumn 넓이 고정

		// 접수 번호
		column = animalTable.getColumnModel().getColumn(0);
		column.setMinWidth(65);
		column.setMaxWidth(65);
		
		// 품종
		column = animalTable.getColumnModel().getColumn(1);
		column.setMinWidth(130);
		column.setMaxWidth(130);

		// 색깔
		column = animalTable.getColumnModel().getColumn(2);
		column.setMinWidth(100);
		column.setMaxWidth(100);

		// 나이
		column = animalTable.getColumnModel().getColumn(3);
		column.setMinWidth(70);
		column.setMaxWidth(70);
		
		// 무게
		column = animalTable.getColumnModel().getColumn(4);
		column.setMinWidth(65);
		column.setMaxWidth(65);
		
		// 보호상태
		column = animalTable.getColumnModel().getColumn(5);
		column.setMinWidth(85);
		column.setMaxWidth(85);
		
		// 성별
		column = animalTable.getColumnModel().getColumn(6);
		column.setMinWidth(35);
		column.setMaxWidth(35);
		
		// 중성화
		column = animalTable.getColumnModel().getColumn(7);
		column.setMinWidth(45);
		column.setMaxWidth(45);
	}

	private Object[][] convertToPageData() {
		List<MissingBoardDTO> currentPageData = getPageData();
		Object[][] pageData = new Object[currentPageData.size()][columnNames.length];

		for (int i = 0; i < currentPageData.size(); i++) {
			MissingBoardDTO dto = currentPageData.get(i);
			pageData[i][0] = dto.getId();
			pageData[i][1] = dto.getKindCd();
			pageData[i][2] = dto.getColorCd();
			pageData[i][3] = dto.getAge();
			pageData[i][4] = dto.getWeight();
			pageData[i][5] = dto.getProcessState();
			pageData[i][6] = dto.getSexCd();
			pageData[i][7] = dto.getNeuterYn();
			pageData[i][8] = dto.getSpecialMark();
		}
		return pageData;
	}

	private List<MissingBoardDTO> getPageData() {
		int start = currentPage * rowsPerPage;
		int end = Math.min(start + rowsPerPage, animalData.size() * rowsPerPage);
		List<MissingBoardDTO> pageData = new ArrayList<>();

		for (int i = start; i < end; i++) {
			int listIndex = i / rowsPerPage;
			int dataIndex = i % rowsPerPage;
			if (listIndex < animalData.size() && dataIndex < animalData.get(listIndex).size()) {
				pageData.add(animalData.get(listIndex).get(dataIndex));
			}
		}
		return pageData;
	}
}
