package ver1.panel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.table.DefaultTableModel;

public class MissingBoard extends JPanel {

    private JPanel dogPanel;
    private JPanel catPanel;
    private JTabbedPane pane;

    private JButton registrationBtn;

    public MissingBoard() {
        initData();
        setInitLayout();
        addEventLayout();
    }

    public void initData() {
        dogPanel = new JPanel();
        catPanel = new JPanel();
        registrationBtn = new JButton("등록");
        pane = new JTabbedPane();

        // 강아지와 고양이의 샘플 데이터
        String[] columnNames = {"id", "kindCd", "colorCd", "age", "sexCd", "specialMark","1111111111","1111111111","1111111111","1111111111"};
        Object[][] dogData = {
                {1, "[개] 비숑 프리제", "흰색", "2016년생", "F", "24-6-1-17 많이 활발해요~사람도 엄청 좋아해요~근처에 사는아이 같아요~~"},
                // 필요에 따라 더 많은 행 추가 가능
        };
        Object[][] catData = {
                {"위스커스", "시암 고양이", 3},
                // 필요에 따라 더 많은 행 추가 가능
        };

        // 각 패널에 JTable 생성 및 샘플 데이터 추가
        JTable dogTable = new JTable(new DefaultTableModel(dogData, columnNames));
        JTable catTable = new JTable(new DefaultTableModel(catData, columnNames));

        // 패널에 JTable 추가
        JScrollPane dogScroll = new JScrollPane(dogTable);
        dogScroll.setSize(1000,600);
        dogPanel.add(dogScroll);  // 스크롤 가능하도록 JScrollPane으로 감싸줍니다.
        catPanel.add(new JScrollPane(catTable));  // 스크롤 가능하도록 JScrollPane으로 감싸줍니다.

        pane.setUI(new BasicTabbedPaneUI() {
            @Override
            protected void installDefaults() {
                super.installDefaults();
                tabAreaInsets.left = 0;
            }
            
            @Override
            protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
            }
            
            @Override
            protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
            }
        });
        
        
    }

    public void setInitLayout() {
        setLayout(null);

        registrationBtn.setBounds(1040, 0, 60, 30);
        add(registrationBtn);

        dogPanel.setBackground(Color.orange);
        catPanel.setBackground(Color.BLUE);

        pane.setBounds(75, 10, 1025, 580);
        pane.add("강아지", dogPanel);
        pane.add("고양이", catPanel);

        
        add(pane);
    }

    public void addEventLayout() {
        // Add event handling code here if needed
    }
}