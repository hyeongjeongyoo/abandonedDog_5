package ver1.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class abanAnimalList extends JPanel {

	private JList<String> infoList;

	private JTable table; // 인스턴스 변수로 선언

	public abanAnimalList() {
		initData();
		setInitLayout();
		addEventLayout();
	}

	public void initData() {
		Object[][] data = { { "묘종 / 견종", "삽", "나이", "2개월령" }, { "성별", "남아", "특이사항", "-" },
				{ "접종유무", "미완료", "중성화유무", "미완료" }, { "보호소로 오게 된 이유", "케어불가", "맡겨지기 전 가정 환경", "-" },
				{ "좋아하는 것", "-", "싫어하는 것", "-" } };

		// 테이블 컬럼 이름
		String[] columnNames = { "", "", "", "" };

		// 테이블 모델 생성 및 설정
		DefaultTableModel model = new DefaultTableModel(data, columnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // 모든 셀을 수정 불가능하게 설정
			}
		};

		// 인스턴스 변수로 선언된 table 초기화
		table = new JTable(model);
		table.setFont(new Font("Noto Sans KR", Font.PLAIN, 12));
		table.setBackground(Color.WHITE);
		table.setGridColor(Color.LIGHT_GRAY);
		table.setRowHeight(30); // 행 높이 설정

		// 테이블 헤더 커스터마이징
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Noto Sans KR", Font.BOLD, 12));
		header.setBackground(Color.DARK_GRAY);
		header.setForeground(Color.WHITE);

		// 컬럼 너비 조정
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);

		DefaultListModel<String> listModel = new DefaultListModel<>();
		listModel.addElement("유기견 1 토랑이");
		listModel.addElement("유기묘 2 카키");

		infoList = new JList<>(listModel);
		infoList.setFont(new Font("Noto Sans KR", Font.PLAIN, 12));
		infoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	}

	public void setInitLayout() {
		// GridBagLayout 설정
		setLayout(new GridBagLayout());

		// 테이블을 JScrollPane에 넣어서 패널에 추가
		JScrollPane scrollPaneTable = new JScrollPane(table);
		GridBagConstraints gbcTable = new GridBagConstraints();
		gbcTable.gridx = 0;
		gbcTable.gridy = 0;
		gbcTable.gridwidth = 1;
		gbcTable.gridheight = 1;
		gbcTable.weightx = 1.0;
		gbcTable.weighty = 1.0;
		gbcTable.fill = GridBagConstraints.BOTH;
		add(scrollPaneTable, gbcTable);

		// JList를 JScrollPane에 넣어서 패널에 추가 (특정 위치)
		JScrollPane scrollPaneList = new JScrollPane(infoList);
		GridBagConstraints gbcList = new GridBagConstraints();
		gbcList.gridx = 0;
		gbcList.gridy = 1;
		gbcList.gridwidth = 1;
		gbcList.gridheight = 1;
		gbcList.weightx = 1.0;
		gbcList.weighty = 0.2; // JList가 차지하는 세로 공간 비율 조정
		gbcList.fill = GridBagConstraints.BOTH;
		add(scrollPaneList, gbcList);
	}

	public void addEventLayout() {
		// 필요한 경우 이벤트 처리 코드 추가
	}
}