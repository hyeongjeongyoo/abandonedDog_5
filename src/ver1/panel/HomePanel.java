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

	private ImageIcon backgroundImageIcon;
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

		backgroundImageIcon = new ImageIcon("img/backgroundBg.gif");

	}

	private void setInitLayout() {
		setLayout(null);
		setBackground(Color.white);

		imgBox.setBounds(404, 260, 609, 450);
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
				Thread.sleep(4000); // 이미지 변경 간격을 2초로 설정
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (backgroundImageIcon != null) {
			backgroundImageIcon.paintIcon(this, g, 0, 0);
		}
	}
}
