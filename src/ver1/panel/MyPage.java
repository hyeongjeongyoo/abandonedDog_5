package ver1.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
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

import lombok.Data;
import ver1.DTO.MissingBoardDTO;
import ver1.frame.BoardFrame;
import ver1.use.HeaderRenderer;

@Data
public class MyPage extends JPanel {
	
	private BoardFrame mContext;
	
	public JLabel nameField;
	public JLabel idField;
	public JLabel passwordField;
	public JLabel birthField;
	public JLabel phoneNum;
	public JLabel memberNum;
	public JLabel memberName;
	
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

		nameField = new JLabel();
		idField = new JLabel();
		passwordField = new JLabel();
		birthField = new JLabel();
		phoneNum = new JLabel();
		memberNum = new JLabel();
		memberName = new JLabel();
		
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
    myWriter = new JTable(model){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // 모든 셀을 편집 불가능하게 설정
        }
    };
    myWriterScroll = new JScrollPane(myWriter);
    column = myWriter.getColumnModel().getColumn(2); // "contents" 컬럼

	}

	private void setInitLayout() {
		setLayout(null);
		setBackground(Color.white);
		
		myWriter.getTableHeader().setReorderingAllowed(false);
		myWriter.getTableHeader().setResizingAllowed(false);
		
		Font font = new Font("Noto Sans KR", Font.BOLD, 15);
		
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
		
		nameField.setSize(100, 30);
		nameField.setLocation(400, 80);
		nameField.setBorder(new LineBorder(new Color(13, 170, 93),1));
		nameField.setFont(font);
		add(nameField);
		
		idField.setSize(100, 30);
		idField.setLocation(400, 148);
		idField.setBorder(new LineBorder(new Color(13, 170, 93),1));
		idField.setFont(font);
		add(idField);
		
		passwordField.setSize(100, 30);
		passwordField.setLocation(400, 213);
		passwordField.setBorder(new LineBorder(new Color(13, 170, 93),1));
		passwordField.setFont(font);
		add(passwordField);
		
		birthField.setSize(100, 30);
		birthField.setLocation(400, 275);
		birthField.setBorder(new LineBorder(new Color(13, 170, 93),1));
		birthField.setFont(font);
		add(birthField);
		
//		phoneNum.setSize(100, 30);
//		phoneNum.setLocation(400, 80);
//		phoneNum.setBorder(new LineBorder(new Color(13, 170, 93),1));
//		phoneNum.setFont(font);
//		add(phoneNum);
		
//		memberNum.setSize(100, 30);
//		memberNum.setLocation(400, 80);
//		memberNum.setBorder(new LineBorder(new Color(13, 170, 93),1));
//		memberNum.setFont(font);
//		add(memberNum);
//		
//		memberName.setSize(100, 30);
//		memberName.setLocation(400, 80);
//		memberName.setBorder(new LineBorder(new Color(13, 170, 93),1));
//		memberName.setFont(font);
//		add(memberName);
		
		managerLabel.setSize(103, 24);
		managerLabel.setLocation(50, 30);
		add(managerLabel);
		
		commonLabel.setSize(103, 24);
		commonLabel.setLocation(50, 30);
		add(commonLabel);
		
		commonInfo.setSize(104, 255);
		commonInfo.setLocation(245, 68);
		add(commonInfo);
		
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
        
    	DefaultTableModel newModel = new DefaultTableModel(getMyPageData(), columnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		myWriter.setModel(newModel);
	}

	private void addEventListener() {

	}
}
