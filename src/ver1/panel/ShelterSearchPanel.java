package ver1.panel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import ver1.DAO.ShelterDAO;
import ver1.DAO.SidoDAO;
import ver1.DAO.SigunguDAO;
import ver1.DTO.ShelterDTO;
import ver1.use.HeaderRenderer;

public class ShelterSearchPanel extends JPanel {

	private JButton magnifierBtn;

	private JPanel innerPanel1;

	private JLabel siDo;
	private JLabel siGunGu;

	private JTable careTable;
	private JScrollPane careScroll;
	private TableColumn column;

	private DefaultTableModel model;
	private JComboBox<String> siDoComboBox;
	private JComboBox<String> siGunGuComboBox;

	String[] columnNames = { "보호소명", "전화번호", "주소" };

	private Font font;
	private Font font2;

	public ShelterSearchPanel() {
		initData();
		setInitLayout();
		addEventLayout();
	}

	public void initData() {

		magnifierBtn = new JButton(new ImageIcon("img/magnifier.png"));
		innerPanel1 = new JPanel();

		// 각 패널에 JTable 생성 및 샘플 데이터 추가
		model = new DefaultTableModel(null, columnNames);
		careTable = new JTable(model);
		careScroll = new JScrollPane(careTable);

		font = new Font("Noto Sans KR", Font.BOLD, 15);
		font2 = new Font("Noto Sans KR", Font.PLAIN, 13);

		siDoComboBox = new JComboBox<>();
		siGunGuComboBox = new JComboBox<>();

		siDo = new JLabel("시, 도 ");
		siGunGu = new JLabel("시, 군, 구 ");

		siDoComboBox.setFont(font2);
		siGunGuComboBox.setFont(font2);
	}

	public void setInitLayout() {
		setLayout(null);
		setBackground(Color.white);

		innerPanel1.setBounds(200, 13, 800, 500);
		innerPanel1.setLayout(null);
		innerPanel1.setBackground(new Color(250, 250, 250, 0));
		innerPanel1.setVisible(true);
		innerPanel1.setBorder(new TitledBorder(new LineBorder(new Color(13, 170, 93), 3), null));

		careTable.getTableHeader().setReorderingAllowed(false);

		magnifierBtn.setBounds(600, 60, 45, 45);
		magnifierBtn.setBorderPainted(false);
		magnifierBtn.setBackground(Color.white);
		magnifierBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		innerPanel1.add(magnifierBtn);

		careScroll.setBounds(80, 150, 643, 280);
		careScroll.setBorder(new TitledBorder(new LineBorder(new Color(13, 170, 93), 3), null));
		careScroll.getViewport().setBackground(Color.white);
		careScroll.getViewport().setOpaque(true);
		innerPanel1.add(careScroll);

		JTableHeader header = careTable.getTableHeader();
		header.setDefaultRenderer(new HeaderRenderer());

		UIManager.put("ComboBox.background", Color.white);

		siDoComboBox.setBounds(150, 70, 150, 30);
		siDoComboBox.setBackground(Color.white);
		siDoComboBox.setOpaque(false);
		siDoComboBox.setModel(new DefaultComboBoxModel<>(SidoDAO.getSido()));
		innerPanel1.add(siDoComboBox);

		siGunGuComboBox.setBounds(390, 70, 150, 30);
		siGunGuComboBox.setBackground(Color.white);
		innerPanel1.add(siGunGuComboBox);

		siDo.setBounds(100, 60, 50, 50);
		siDo.setFont(font);
		siGunGu.setBounds(320, 60, 70, 50);
		siGunGu.setFont(font);
		innerPanel1.add(siDo);
		innerPanel1.add(siGunGu);

		add(innerPanel1);

	}

	public void addEventLayout() {
		siDoComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedItem = (String) siDoComboBox.getSelectedItem();
				siGunGuComboBox.removeAllItems();

				if ("전국".equals(selectedItem)) {
					siGunGuComboBox.setModel(new DefaultComboBoxModel<>(SigunguDAO.getSigungu(selectedItem)));
				} else if ("세종특별자치시".equals(selectedItem)) {
					siGunGuComboBox.setModel(new DefaultComboBoxModel<>(SigunguDAO.getSigungu(selectedItem)));
				} else if ("서울특별시".equals(selectedItem)) {
					siGunGuComboBox.setModel(new DefaultComboBoxModel<>(SigunguDAO.getSigungu(selectedItem)));
				} else if ("부산광역시".equals(selectedItem)) {
					siGunGuComboBox.setModel(new DefaultComboBoxModel<>(SigunguDAO.getSigungu(selectedItem)));
				} else if ("대구광역시".equals(selectedItem)) {
					siGunGuComboBox.setModel(new DefaultComboBoxModel<>(SigunguDAO.getSigungu(selectedItem)));
				} else if ("인천광역시".equals(selectedItem)) {
					siGunGuComboBox.setModel(new DefaultComboBoxModel<>(SigunguDAO.getSigungu(selectedItem)));
				} else if ("광주광역시".equals(selectedItem)) {
					siGunGuComboBox.setModel(new DefaultComboBoxModel<>(SigunguDAO.getSigungu(selectedItem)));
				} else if ("대전광역시".equals(selectedItem)) {
					siGunGuComboBox.setModel(new DefaultComboBoxModel<>(SigunguDAO.getSigungu(selectedItem)));
				} else if ("울산광역시".equals(selectedItem)) {
					siGunGuComboBox.setModel(new DefaultComboBoxModel<>(SigunguDAO.getSigungu(selectedItem)));
				} else if ("경기도".equals(selectedItem)) {
					siGunGuComboBox.setModel(new DefaultComboBoxModel<>(SigunguDAO.getSigungu(selectedItem)));
				} else if ("충청북도".equals(selectedItem)) {
					siGunGuComboBox.setModel(new DefaultComboBoxModel<>(SigunguDAO.getSigungu(selectedItem)));
				} else if ("충청남도".equals(selectedItem)) {
					siGunGuComboBox.setModel(new DefaultComboBoxModel<>(SigunguDAO.getSigungu(selectedItem)));
				} else if ("전라남도".equals(selectedItem)) {
					siGunGuComboBox.setModel(new DefaultComboBoxModel<>(SigunguDAO.getSigungu(selectedItem)));
				} else if ("경상북도".equals(selectedItem)) {
					siGunGuComboBox.setModel(new DefaultComboBoxModel<>(SigunguDAO.getSigungu(selectedItem)));
				} else if ("경상남도".equals(selectedItem)) {
					siGunGuComboBox.setModel(new DefaultComboBoxModel<>(SigunguDAO.getSigungu(selectedItem)));
				} else if ("제주특별자치도".equals(selectedItem)) {
					siGunGuComboBox.setModel(new DefaultComboBoxModel<>(SigunguDAO.getSigungu(selectedItem)));
				} else if ("강원특별자치도".equals(selectedItem)) {
					siGunGuComboBox.setModel(new DefaultComboBoxModel<>(SigunguDAO.getSigungu(selectedItem)));
				} else if ("전북특별자치도".equals(selectedItem)) {
					siGunGuComboBox.setModel(new DefaultComboBoxModel<>(SigunguDAO.getSigungu(selectedItem)));
				}
			}
		});

		magnifierBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedItemSido = (String) siDoComboBox.getSelectedItem();
				String selectedItemSigungu = (String) siGunGuComboBox.getSelectedItem();
				updateTable(selectedItemSido, selectedItemSigungu);
			}
		});

	}

	private Object[][] convertToPageData(String sido, String sigungu) {
		List<ShelterDTO> currentPageData = ShelterDAO.getShelter(sido, sigungu);
		Object[][] pageData = new Object[currentPageData.size()][columnNames.length];

		for (int i = 0; i < currentPageData.size(); i++) {
			ShelterDTO dto = currentPageData.get(i);
			pageData[i][0] = dto.getCareNm();
			pageData[i][1] = dto.getCareTel();
			pageData[i][2] = dto.getCareAddr();
		}
		return pageData;
	}

	private void updateTable(String sido, String sigungu) {
		DefaultTableModel newModel = new DefaultTableModel(convertToPageData(sido, sigungu), columnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		careTable.setModel(newModel);
		column = careTable.getColumnModel().getColumn(0);
		column.setMinWidth(120);
		column.setMaxWidth(120);

		column = careTable.getColumnModel().getColumn(1);
		column.setMinWidth(100);
		column.setMaxWidth(100);
	}

}
