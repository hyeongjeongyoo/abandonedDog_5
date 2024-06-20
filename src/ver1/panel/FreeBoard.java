package ver1.panel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import ver1.component.HeaderRenderer;

public class FreeBoard extends JPanel {

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
    private Object[][] freeData;

    private JTextField searchText;
    private JButton searchBtn;
    private JLabel title;

    String[] columnNames = { "id", "title", "contents" };

    public FreeBoard() {
        initData();
        setInitLayout();
        addEventLayout();
        updateTable();
    }

    public void initData() {
        searchText = new JTextField();
        searchBtn = new JButton("검색");
        title = new JLabel("Title");

        registrationBtn = new JButton("등록");
        nextPageBtn = new JButton("다음 페이지");
        prevPageBtn = new JButton("이전 페이지");
        refrashBtn = new JButton(new ImageIcon("img/refrash.png"));

        freeData = new Object[][] {
                { 1, "안녕하세요 인사드리러왔습니다", "정말 좋은 취지의 사이트네요" },
                { 2, "인사 오지게 박습니다", "등업 신청이요~" },
                { 3, "미안하다 이거 보여주려고 어그로끌었다 ", "우리조 코딩 싸움수준 ㄹㅇ실화냐? " },
        };

        model = new DefaultTableModel(freeData, columnNames);
        animalTable = new JTable(model);
        animalScroll = new JScrollPane(animalTable);
        column = animalTable.getColumnModel().getColumn(2); // "contents" 컬럼
    }

    public void setInitLayout() {
        setLayout(null);
        setBackground(Color.white);

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

        refrashBtn.setBounds(20, 600, 50, 50);
        refrashBtn.setBorderPainted(false);
        refrashBtn.setContentAreaFilled(false);
        refrashBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(refrashBtn);

        animalScroll.setBounds(20, 5, 1140, 503);
        animalScroll.setBorder(new TitledBorder(new LineBorder(new Color(13, 170, 93), 3), null));
        animalScroll.getViewport().setBackground(Color.white);
        animalScroll.getViewport().setOpaque(true);
        add(animalScroll);

        prevPageBtn.setBounds(20, 560, 120, 30);
        nextPageBtn.setBounds(150, 560, 120, 30);
        add(prevPageBtn);
        add(nextPageBtn);

        // 컬럼 헤더의 배경색 설정
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
                updateTable();
            }
        });

        registrationBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreateFreeBoard();
            }
        });
    }

    private void updateTable() {
        DefaultTableModel newModel = new DefaultTableModel(getPageData(), new String[] { "id", "title", "contents" });
        animalTable.setModel(newModel);

        // Set column widths and other configurations
        column = animalTable.getColumnModel().getColumn(0);
        column.setPreferredWidth(50);
        column = animalTable.getColumnModel().getColumn(1);
        column.setPreferredWidth(300);
        column = animalTable.getColumnModel().getColumn(2);
        column.setPreferredWidth(500);
    }

    private Object[][] getPageData() {
        int start = currentPage * rowsPerPage;
        int end = Math.min(start + rowsPerPage, freeData.length);
        Object[][] pageData = new Object[end - start][];
        for (int i = start; i < end; i++) {
            pageData[i - start] = freeData[i];
        }
        return pageData;
    }

}
