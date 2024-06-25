package ver1.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import ver1.DAO.PhotoDAO;

public class HomePanel extends JPanel implements Runnable {

	private JPanel imgBox;

	private Image backgroundImage;
	public Image image;

	public HomePanel() {
		initData();
		setInitLayout();
	}

	private void initData() {
		imgBox = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (image != null) {
					g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
				}
			}
		};

		backgroundImage = new ImageIcon("img/backgroundBg.png").getImage();

	}

	private void setInitLayout() {
		setLayout(null);
		setBackground(Color.white);

		imgBox.setBounds(396, 224, 609, 450);
		imgBox.setBorder(new LineBorder(Color.GRAY, 2));
		imgBox.setBackground(Color.orange);
		add(imgBox);
	}

	@Override
	public void run() {
		while (true) {
			String imagePath = PhotoDAO.randomPhoto();
			try {
				image = ImageIO.read(new URL(imagePath.trim()));
			} catch (IOException e) {
				continue;
			}
			repaint();
			try {
				Thread.sleep(2000); // 이미지 변경 간격을 2초로 설정
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (backgroundImage != null) {
			g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
		}
	}
}
