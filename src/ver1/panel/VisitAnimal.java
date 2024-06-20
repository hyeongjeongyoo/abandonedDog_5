package ver1.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import ver1.SandAnimation;
import ver1.DAO.PhotoDAO;

public class VisitAnimal extends JPanel implements Runnable {

	SandAnimation animation;

	private JPanel imgBox;

	String imagePath1 = "https://www.animal.go.kr/files/shelter/2024/06/202406181506269.jpg";
	String imagePath2 = "https://www.animal.go.kr/files/shelter/2024/06/202406181006750.jpg";
	String imagePath3 = "https://www.animal.go.kr/files/shelter/2024/06/202406181006546.jpg";
	Image image;

	public VisitAnimal() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		animation = new SandAnimation();
	}

	private void setInitLayout() {
		setLayout(null);
		setBackground(Color.white);
		animation.setBounds(480, 50, 500, 100);
		add(animation);

		imgBox = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (image != null) {
					g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
				}
			}
		};

		imgBox.setBounds(396, 150, 609, 450);
		imgBox.setBorder(new LineBorder(Color.GRAY, 2));
		imgBox.setBackground(Color.orange);
		add(imgBox);
	}

	private void addEventListener() {
		// 이벤트 리스너 추가
	}

	@Override
	public void run() {
		// TODO 프레임 작업 중지
//		int temp = 0;
//		while (true) {
//			String imagePath = PhotoDAO.randomPhoto();
//			try {
//				image = ImageIO.read(new URL(imagePath.trim()));
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			repaint();
//			temp++;
//			try {
//				Thread.sleep(2000); // 이미지 변경 간격을 1초로 설정
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
	}
}
