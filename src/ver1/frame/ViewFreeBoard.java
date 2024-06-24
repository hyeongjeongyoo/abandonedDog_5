package ver1.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ver1.DAO.FreeBoardDAO;
import ver1.frame.BoardFrame;

public class ViewFreeBoard extends JFrame {

	private BoardFrame mContext;

	private JLabel titleLabel;
	public JTextField titleField;
	private JLabel nameLabel;
	public JTextField nameField;
	private JLabel contentLabel;
	public JTextArea contentArea;
	private JLabel logoLabel;
	private JPanel panel;

	private Font font;

	public ViewFreeBoard(BoardFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
	}

	private void initData() {

		ImageIcon logoIcon = new ImageIcon("img/logo.png");
		panel = new JPanel();

		logoLabel = new JLabel(logoIcon);
		logoLabel.setBounds(240, 10, 100, 100);
		panel.add(logoLabel);

		titleLabel = new JLabel("제목");
		titleLabel.setBounds(100, 100, 80, 25);
		panel.add(titleLabel);

		titleField = new JTextField();
		titleField.setBounds(100, 125, 400, 25);
		titleField.setBackground(new Color(240, 240, 240));
		panel.add(titleField);
		
		nameLabel = new JLabel("작성자");
		nameLabel.setBounds(100, 150, 80, 25);
		panel.add(nameLabel);
		
		nameField = new JTextField();
		nameField.setBounds(100, 175, 400, 25);
		nameField.setBackground(new Color(240, 240, 240));
		panel.add(nameField);
		
		contentLabel = new JLabel("내용");
		contentLabel.setBounds(100, 190, 80, 50);
		panel.add(contentLabel);

		contentArea = new JTextArea();
		contentArea.setBackground(new Color(240, 240, 240));
		JScrollPane scrollPane = new JScrollPane(contentArea);
		scrollPane.setBounds(100, 230, 400, 400);
		panel.add(scrollPane);

		font = new Font("Noto Sans KR", Font.BOLD, 14);
		titleLabel.setFont(font);
		titleField.setFont(font);
		titleField.setEditable(false);
		nameLabel.setFont(font);
		nameField.setFont(font);
		nameField.setEditable(false);
		contentLabel.setFont(font);
		contentArea.setFont(font);
		contentArea.setEditable(false);

		// 패널을 프레임의 콘텐츠 패널로 설정
		setContentPane(panel);
	}

	private void setInitLayout() {
		setLayout(null);
		setBounds(300, 300, 600, 700);
		setVisible(true);
		setLocationRelativeTo(null);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		setTitle("님의 게시글");
	}

	public static void main(String[] args) {
		new ViewFreeBoard(null);
	}
}