package ver1.frame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ViewFreeBoardFrame extends JFrame {

	private MainBoardFrame mContext;

	private JLabel titleLabel;
	public JTextField titleField;

	private JLabel nameLabel;
	public JTextField nameField;

	private JLabel contentLabel;
	public JTextArea contentArea;
	private JScrollPane scrollPane;

	private JLabel logoLabel;
	private ImageIcon logoIcon;

	private JPanel panel;

	private Font font;

	public ViewFreeBoardFrame(MainBoardFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
	}

	private void initData() {

		logoIcon = new ImageIcon("img/logo.png");

		panel = new JPanel();

		logoLabel = new JLabel(logoIcon);

		titleLabel = new JLabel("제목");

		titleField = new JTextField();

		nameLabel = new JLabel("작성자");

		nameField = new JTextField();

		contentLabel = new JLabel("내용");

		contentArea = new JTextArea();

		scrollPane = new JScrollPane(contentArea);

		font = new Font("Noto Sans KR", Font.BOLD, 14);
	}

	private void setInitLayout() {
		setContentPane(panel);
		setLayout(null);
		setBounds(300, 300, 600, 700);
		setVisible(true);
		setLocationRelativeTo(null);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		setTitle("님의 게시글");

		titleLabel.setFont(font);
		titleField.setFont(font);
		titleField.setEditable(false);
		nameLabel.setFont(font);
		nameField.setFont(font);
		nameField.setEditable(false);
		contentLabel.setFont(font);
		contentArea.setFont(font);
		contentArea.setEditable(false);

		logoLabel.setBounds(240, 10, 100, 100);
		panel.add(logoLabel);

		titleLabel.setBounds(100, 100, 80, 25);
		panel.add(titleLabel);

		titleField.setBounds(100, 125, 400, 25);
		titleField.setBackground(new Color(240, 240, 240));
		panel.add(titleField);

		nameLabel.setBounds(100, 150, 80, 25);
		panel.add(nameLabel);

		nameField.setBounds(100, 175, 400, 25);
		nameField.setBackground(new Color(240, 240, 240));
		panel.add(nameField);

		contentLabel.setBounds(100, 190, 80, 50);
		panel.add(contentLabel);

		contentArea.setBackground(new Color(240, 240, 240));

		scrollPane.setBounds(100, 230, 400, 400);
		panel.add(scrollPane);
	}

}