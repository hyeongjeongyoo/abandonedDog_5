package ver1.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CreateFreeBoard extends JFrame {

	private JLabel titleLabel;
	private JTextField titleField;
	private JLabel contentLabel;
	private JTextArea contentArea;
	private JButton submitButton;

	public CreateFreeBoard() {
		initData();
		setLayout(null);
		setBounds(300, 300, 400, 300);
		setVisible(true);
	}

	private void initData() {
		titleLabel = new JLabel("Title:");
		titleLabel.setBounds(10, 10, 80, 25);
		add(titleLabel);

		titleField = new JTextField();
		titleField.setBounds(100, 10, 260, 25);
		add(titleField);

		contentLabel = new JLabel("Content:");
		contentLabel.setBounds(10, 45, 80, 25);
		add(contentLabel);

		contentArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(contentArea);
		scrollPane.setBounds(100, 45, 260, 150);
		add(scrollPane);

		submitButton = new JButton("Submit");
		submitButton.setBounds(150, 210, 100, 30);
		add(submitButton);

		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String title = titleField.getText();
				String content = contentArea.getText();

				if (title.isEmpty() || content.isEmpty()) {
					JOptionPane.showMessageDialog(null, "제목과 내용 모두 작성해주세요", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				JOptionPane.showMessageDialog(null, "게시글이 작성되었습니다.", "Success", JOptionPane.INFORMATION_MESSAGE);
				dispose(); // 폼 닫기
			}
		});
	}

}
