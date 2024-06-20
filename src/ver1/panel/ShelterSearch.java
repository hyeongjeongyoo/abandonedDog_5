package ver1.panel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ShelterSearch extends JPanel {

    private JButton magnifierBtn;
    
    private JPanel innerPanel1; 
    
    private JTable careTable;
    private JScrollPane careScroll;
    private TableColumn column;
    
    private int currentPage = 0;
    private int rowsPerPage = 20; // 한 페이지에 표시할 행 수
    
    private DefaultTableModel model;
    private Object[][] careData;
    
    private JTextField searchText;
    
    String[] columnNames = {"careId", "careNm", "careTel", "careAddr"};
    
    public ShelterSearch() {
        initData();
        setInitLayout();
        addEventLayout();
        updateTable();
    }
    
    public void initData() {
        searchText = new JTextField();
        
        magnifierBtn = new JButton(new ImageIcon("img/magnifier.png"));
        innerPanel1 = new JPanel();
        
        // 보호소 샘플데이터
        careData = new Object[][] {
            {1, "창원유기동물보호소", "055-225-5701", "경상남도 창원시 의창구 창이대로 71 (명서동, 창원시농업기술센터) 축산과"},
            {2, "태민동물병원", "010-2868-2108", "경상남도 합천군 합천읍 옥산로 16 (합천읍, 까치빌라) 태민동물병원"},
            {3, "거창유기동물보호센터", "010-2868-2108", "경상남도 거창군 남상면 수남로 1934-12"},
            {4, "하동군유기동물보호소", "055-880-2677", "경상남도 하동군 적량면 한옥정길 90 (적량면) 유기동물보호소"},
            {5, "남해군유기동물보호소", "055-862-5041", "경상남도 남해군 이동면 무림로 33-13 (이동면)"},
            {6, "거제시유기동물보호소", "055-639-6368", "경상남도 거제시 사등면 두동로1길 109 (사등면, 한국자원재생공사폐비닐적재장) 거제시유기동물보호소"},
            {7, "사천시 동물보호센터", "055-831-3768", "경상남도 사천시 용현면 진삼로 902  사천시유기동물보호소"},
            {8, "통영시동물보호센터", "055-650-6253", "경상남도 통영시 광도면 전두1길 9-8"},
            {9, "고령군 임시보호소", "010-4419-4135", "경상북도 고령군 운수면 하법길 37 (운수면)"},
            {10, "경산시유기동물보호소", "010-2536-0955", "경상북도 경산시 용성면 사양지길 95 (용성면)"},
            {11, "경주동물사랑보호센터", "010-8889-2883", "경상북도 경주시 천북면 천북로 8-4  경주시 동물사랑보호센터"},
            {12, "(사)영일동물플러스", "054-262-8295", "경상북도 포항시 북구 흥해읍 덕장길 224 (흥해읍) "},
            {13, "화순군유기동물보호소", "010-2663-6907", "전라남도 화순군 한천면 덕음로 115 (한천면) "},
            {14, "구례군동물보호센터", "061-781-2022", "전라남도 구례군 용방면 용방로 64-11  "},
            {15, "푸른곡성21동물보호소", "061-360-8372", "전라남도 곡성군 곡성읍 군청로 50  보호소 주소 : 전남 곡성군 곡성읍 구원리 888"},
            {16, "담양군 동물보호센터", "010-3604-1338", "전라남도 담양군 용면 시암골로 280-57 (용면) :용면 두장리 21번지"},
            {17, "유기동물보호소", "061-659-2474", "전라남도 여수시 주동1길 32 (주삼동, 여수시농업기술센터) 여수시 유기동물보호소"},
            {18, "더나은동물병원", "063-560-2629", "전라북도 고창군 무장면 신촌농장길 98  "}
        };
        
        // 각 패널에 JTable 생성 및 샘플 데이터 추가
        model = new DefaultTableModel(careData, columnNames);
        careTable = new JTable(model);
        careScroll = new JScrollPane(careTable);
    }
    
    public void setInitLayout() {
        setLayout(null);
        setBackground(Color.white);
        
        innerPanel1.setBounds(50, 50, 0, 0);
        innerPanel1.setLayout(null);
        innerPanel1.setBackground(new Color(250, 250, 250, 0));
        innerPanel1.setSize(1060, 500);
        innerPanel1.setVisible(true);
        innerPanel1.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 3), "보호소 찾기"));
        
        add(innerPanel1);
        careTable.getTableHeader().setReorderingAllowed(false); 
        searchText.setBounds(350, 70, 400, 30);
        innerPanel1.add(searchText);
        
        magnifierBtn.setBounds(760, 60, 45, 45);
        magnifierBtn.setBorderPainted(false);
        magnifierBtn.setBackground(new Color(238, 238, 238));
        magnifierBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        innerPanel1.add(magnifierBtn);
        
        careScroll.setBounds(160, 150, 800, 280);
        innerPanel1.add(careScroll);
        
        
    }
    
    public void addEventLayout() {
    }
    
    private void updateTable() {
        DefaultTableModel newModel = new DefaultTableModel(getPageData(), new String[]{"careId", "careNm", "careTel", "careAddr"});
        careTable.setModel(newModel);
        
        column = careTable.getColumnModel().getColumn(0);
        column.setMinWidth(40);
        column.setMaxWidth(40);
        
        column = careTable.getColumnModel().getColumn(1);
        column.setMinWidth(100);
        column.setMaxWidth(100);
        
        column = careTable.getColumnModel().getColumn(2);
        column.setMinWidth(100);
        column.setMaxWidth(100);
        
        column = careTable.getColumnModel().getColumn(3);
        column.setPreferredWidth(400); // 원하는 기본 너비 설정
        column.setMinWidth(300); // 최소 너비 설정
        column.setMaxWidth(800); // 최대 너비 설정
    }
    
    private Object[][] getPageData() {
        int start = currentPage * rowsPerPage;
        int end = Math.min(start + rowsPerPage, careData.length);
        Object[][] pageData = new Object[end - start][];
        for (int i = start; i < end; i++) {
            pageData[i - start] = careData[i];
        }
        return pageData;
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 600);
    }
    
    
}

