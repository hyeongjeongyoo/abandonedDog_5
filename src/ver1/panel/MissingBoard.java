package ver1.panel;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private Object[][] dogData;
    
    private JTextField searchText;
    private JButton searchBtn;
    private JComboBox<String> searchComboBox;
    
    String[] columnNames = {"id", "kindCd", "colorCd", "age", "sexCd", "specialMark"};

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

        // 강아지와 고양이의 샘플 데이터
        dogData = new Object[][] {
                {1, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {2, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {3, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {4, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {5, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {6, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {7, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {8, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {9, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {10, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {11, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {12,"[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {13, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {2, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {2, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {2, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {2, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {2, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {2, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {2, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {2, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {2, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {2, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {2, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {2, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {2, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {2, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {2, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {2, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {30, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {31, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {2, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {2, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {2, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {2, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {2, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {2, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {2, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {2, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {2, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                {45, "[개] 비숑 프리제", "흰색", "2016년생", "F", "많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"}
        };

        // 각 패널에 JTable 생성 및 샘플 데이터 추가
        model = new DefaultTableModel(dogData, columnNames);
        animalTable = new JTable(model);
        animalScroll = new JScrollPane(animalTable);
        column = animalTable.getColumnModel().getColumn(5); // "specialMark" 컬럼
    }

    public void setInitLayout() {
        setLayout(null);

        //
        column.setPreferredWidth(500); // 원하는 기본 너비 설정
        column.setMinWidth(300); // 최소 너비 설정
        column.setMaxWidth(800); // 최대 너비 설정
        
        // 컬럼 헤더 이동 불가
        animalTable.getTableHeader().setReorderingAllowed(false);
        
        searchText.setBounds(895, 25, 200, 22);
        add(searchText);
        
        searchBtn.setBounds(1099, 25, 59, 20);
        add(searchBtn);
        
        searchComboBox.setBounds(810, 25, 80, 20);
        searchComboBox.setModel(new DefaultComboBoxModel<String>(columnNames));
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
				} catch (NegativeArraySizeException e2) {
					currentPage--;
					JOptionPane.showMessageDialog(null, "마지막 페이지 입니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
				}
            }
        });

        prevPageBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	if(currentPage == 0) {
            		JOptionPane.showMessageDialog(null, "처음 페이지 입니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
            	}
            	
                if (currentPage > 0) {
                    currentPage--;
                }
                updateTable();
            }
        });
    }

    private void updateTable() {
        DefaultTableModel newModel = new DefaultTableModel(getPageData(), new String[]{"id", "kindCd", "colorCd", "age", "sexCd", "specialMark"});
        animalTable.setModel(newModel);

        column = animalTable.getColumnModel().getColumn(5); // "specialMark" 컬럼
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
