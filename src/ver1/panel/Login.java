package ver1.panel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lombok.Data;


@Data
public class Login extends JFrame{
	
	Login login;
	Join join2;
	
	private JPanel loginBackgroundImg;
	
	private JLabel logo;

    private JTextField idField;
    private JTextField passwordField;

    private JLabel loginBtn;
    private final int BTN_WIDTH = 240;
    private final int BTN_HEIGHT = 45;
    
    private JButton join;

    Font font = new Font("Noto Sans KR", Font.BOLD, 15);
    Font font2 = new Font("Noto Sans KR", Font.BOLD, 12);
    public Login() {
        initData();
        setInitLayout();
        addEventListener();
    }

    private void initData() {
        loginBackgroundImg = new JPanel();
        loginBtn = new JLabel(new ImageIcon("img/loginBtn.jpg"));
        logo = new JLabel(new ImageIcon("img/logo.png"));

        idField = new JTextField("ID", 10);
        passwordField = new JTextField("PASSWORD", 50);
        join = new JButton("회원가입");


        idField.setFont(font);
        passwordField.setFont(font);
        idField.setForeground(Color.DARK_GRAY);
        passwordField.setForeground(Color.DARK_GRAY);
        join.setForeground(Color.DARK_GRAY);
        
        setTitle("어서오묘 데러가개 로그인");
        setSize(440, 360);
        setContentPane(loginBackgroundImg);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/fav.png"));
    }

    private void setInitLayout() {
        setLayout(null);
        setResizable(false);            // 사이즈 조절 불가
        setLocationRelativeTo(null);    // 가운데 배치
        setVisible(true);

        idField.setBounds(95, 126, 240, 40);
        passwordField.setBounds(95, 170, 240, 40);

        logo.setSize(79, 79);
        logo.setLocation(170, 25);
        logo.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 마우스 커서 모양 변경
        
        loginBtn.setSize(BTN_WIDTH, BTN_HEIGHT);
        loginBtn.setLocation(95, 220);
        loginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 마우스 커서 모양 변경
        
        join.setSize(110, 15);
        join.setLocation(256, 280);
        join.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 마우스 커서 모양 변경
        join.setBorder(null);
        join.setContentAreaFilled(false);
        join.setFont(font2);
        
        add(logo);
        add(idField);
        add(passwordField);
        add(loginBtn);
        add(join);
    }

    private void addEventListener() {
        // 이벤트 리스너 추가할 부분
    	idField.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mousePressed(MouseEvent e) {
    			idField.setText("");
    		}
    	});
    	passwordField.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mousePressed(MouseEvent e) {
    			passwordField.setText("");
    		}
    	});
    	join.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mousePressed(MouseEvent e) {
    	        setVisible(false);
    	        Join join = new Join();
//    	        join.setVisible(true);
    		}
    	});
    }

    public static void main(String[] args) {
        new Login();
    }

}