package ver1.panel;

import java.awt.Color;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import lombok.Data;
import ver1.frame.BoardFrame;
import ver1.use.HeaderRenderer;

@Data
public class MyPage extends JPanel {
	
	private BoardFrame mContext;
	
	private JLabel nameField;
	private JLabel idField;
	private JTextField passwordField;
	private JTextField birthField;
	private JTextField phoneNum;
	private JTextField memberNum;
	private JTextField memberName;
	
	private JLabel selfImage;
	private JPanel showInfo;
	private JLabel commonInfo;
	private JLabel managerInfo;
	private JPanel interestPet;
	private JTable myWriter;
	private JScrollPane myWriterScroll;
	private TableColumn column;
	
	private int currentPage = 0;
	private int rowsPerPage = 15; // 한 페이지에 표시할 행 수
	
	private DefaultTableModel model;
	private List<List<FreeBoard>> myPageNum;
	private Object[][] myPageData;
	
	
	String[] columnNames = {"id", "title", "contents"};
	
	private Image info;

	private JLabel managerLabel;
	private JLabel commonLabel;


	public MyPage(BoardFrame mContext) {
		this.mContext = mContext;
		initDate();
		setInitLayout();
		addEventListener();
	}

	private void initDate() {
		
		if(mContext.manager) {
			info = new ImageIcon("img/managerBtn.png").getImage();
		} else {
			info = new ImageIcon("img/common.png").getImage();
		}

		nameField = new JLabel(mContext.getName());
		selfImage = new JLabel(new ImageIcon("img/Self.jpg"));
		managerLabel = new JLabel(new ImageIcon("img/managerBtn.png"));
		commonLabel = new JLabel(new ImageIcon("img/common.png"));
		showInfo = new JPanel();
		commonInfo = new JLabel(new ImageIcon("img/CommonData.png"));
		managerInfo = new JLabel(new ImageIcon("img/Self.jpg"));
		interestPet = new JPanel();
		myWriter = new JTable();
		
		myPageData = new Object[][] {
            { 1, "안녕하세요 인사드리러왔습니다", "정말 좋은 취지의 사이트네요" },
            { 2, "인사 오지게 박습니다", "등업 신청이요~" },
            { 3, "미안하다 이거 보여주려고 어그로끌었다 ", "우리조 코딩 싸움수준 ㄹㅇ실화냐?" },
    };
    
    model = new DefaultTableModel(myPageData, columnNames);
    myWriter = new JTable(model);
    myWriterScroll = new JScrollPane(myWriter);
    column = myWriter.getColumnModel().getColumn(2); // "contents" 컬럼

	}

	private void setInitLayout() {
		setLayout(null);
		setBackground(Color.white);
		
		myWriter.getTableHeader().setReorderingAllowed(false);
		
		JTableHeader header = myWriter.getTableHeader();
        header.setDefaultRenderer(new HeaderRenderer());
		
        column.setPreferredWidth(600); // 원하는 기본 너비 설정
        myWriter.getColumn("title").setPreferredWidth(800);
        column.setMinWidth(200); // 최소 너비 설정
        column.setMaxWidth(900); // 최대 너비 설정

		selfImage.setBounds(50, 70, 200, 250);
		selfImage.setBackground(Color.white);
		selfImage.setBorder(new TitledBorder(new LineBorder(new Color(13, 170, 93), 3), null));
		add(selfImage);

		if(mContext.manager) {
			showInfo.setBounds(110, 0, 1000, 300);
		} else {
			showInfo.setBounds(110, 10, 600, 300);
		}
		
		nameField.setSize(100, 50);
		nameField.setLocation(150, 100);
		nameField.setBorder(new LineBorder(new Color(13, 170, 93),1));
		add(nameField);
		
		managerLabel.setSize(103, 24);
		managerLabel.setLocation(50, 30);
		add(managerLabel);
		
		commonLabel.setSize(103, 24);
		commonLabel.setLocation(50, 30);
		add(commonLabel);
		
		commonInfo.setSize(104, 255);
		commonInfo.setLocation(245, 68);
		add(commonInfo);
		
		// managerInfo.setSize();
		
		// showInfo.setBorder(new TitledBorder(new LineBorder(new Color(13, 170, 93), 3), null));
		showInfo.setBackground(Color.white);
		add(showInfo);

		interestPet.setBounds(50, 410, 600, 330);
		interestPet.setBackground(Color.white);
		interestPet.setBorder(new TitledBorder(new LineBorder(new Color(13, 170, 93), 3), null));
		add(interestPet);
        
		myWriterScroll.setBounds(730, 410, 600, 330);
		myWriterScroll.setBorder(new TitledBorder(new LineBorder(new Color(13, 170, 93), 3), null));
		myWriterScroll.getViewport().setBackground(Color.white);
		myWriterScroll.getViewport().setOpaque(true);
        add(myWriterScroll);
	}

	private void addEventListener() {

	}
}
