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

public class CreateFreeBoardFrame extends JFrame {

	private MainBoardFrame mContext;

	private JPanel panel;

	private JLabel logoLabel;
	private ImageIcon logoIcon;

	private JLabel titleLabel;
	public JTextField titleField;

	private JLabel contentLabel;
	public JTextArea contentArea;
	private JScrollPane scrollPane;

	private JButton submitButton;

	private Font font;

	public CreateFreeBoardFrame(MainBoardFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		panel = new JPanel();

		logoIcon = new ImageIcon("img/logo.png");
		logoLabel = new JLabel(logoIcon);

		titleLabel = new JLabel("제목");
		titleField = new JTextField();

		contentLabel = new JLabel("내용");
		contentLabel.setBounds(100, 140, 80, 50);

		contentArea = new JTextArea();
		scrollPane = new JScrollPane(contentArea);

		submitButton = new JButton(new ImageIcon("img/registerBtn.jpg"));

		font = new Font("Noto Sans KR", Font.BOLD, 14);
	}

	private void setInitLayout() {
		setLayout(null);
		setBounds(300, 300, 600, 700);
		setVisible(true);
		setLocationRelativeTo(null);
		setTitle("자유게시판 글 작성");
		setContentPane(panel);

		titleLabel.setFont(font);
		titleField.setFont(font);
		contentLabel.setFont(font);
		contentArea.setFont(font);

		panel.setBackground(Color.WHITE);
		panel.setLayout(null);

		logoLabel.setBounds(240, 10, 100, 100);
		panel.add(logoLabel);

		titleLabel.setBounds(100, 100, 80, 25);
		panel.add(titleLabel);
		titleField.setBounds(100, 125, 400, 25);
		titleField.setBackground(new Color(240, 240, 240));
		panel.add(titleField);

		panel.add(contentLabel);
		contentArea.setBackground(new Color(240, 240, 240));

		scrollPane.setBounds(100, 180, 400, 400);
		panel.add(scrollPane);

		submitButton.setBounds(250, 600, 100, 30);
		panel.add(submitButton);
	}

	private void addEventListener() {
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String title = titleField.getText();
				String content = contentArea.getText();

				if (title.isEmpty() || content.isEmpty()) {
					JOptionPane.showMessageDialog(null, "제목과 내용 모두 작성해주세요", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					FreeBoardDAO.addFreeBoardDAO(titleField.getText(), mContext.getName(), contentArea.getText());
					JOptionPane.showMessageDialog(null, "게시글이 작성되었습니다.", "Success", JOptionPane.INFORMATION_MESSAGE);
					mContext.getFreeBoard().updateTable();
					mContext.getMyPage().updateMyWrite();
					dispose(); // 폼 닫기
				}

			}
		});
	}
}