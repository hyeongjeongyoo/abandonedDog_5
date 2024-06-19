package ver1.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class FreeBoard extends JPanel{

	public FreeBoard() {
		setLayout(new BorderLayout());
		
		JLabel title = new JLabel("자유게시판", SwingConstants.CENTER);
		title.setFont(new Font("Noto Sans KR", Font.BOLD,20));
		title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		add(title,BorderLayout.NORTH);
		
		JPanel postList = new JPanel();
		postList.setLayout(new BoxLayout(postList, BoxLayout.Y_AXIS));
		postList.setBackground(Color.WHITE);
		add(postList, BorderLayout.CENTER);
		postList.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		
		JPanel post = new JPanel();
		post.setLayout(new BorderLayout());
		post.setBorder(BorderFactory.createTitledBorder("게시물 작성하기"));
		
	
		JButton postButton = new JButton("등록");
        postButton.setFont(new Font("NotoSansKR", Font.BOLD, 14));
        post.add(postButton, BorderLayout.SOUTH);

        add(post, BorderLayout.SOUTH);
		
	}
	
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(500, 600);
//		frame.add(new FreeBoard());
//		frame.setVisible(true);
//		
//	}
}
