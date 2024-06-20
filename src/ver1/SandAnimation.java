package ver1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SandAnimation extends JPanel implements Runnable {
    private String text = "뭐라고 적을까요?";
    private int charIndex = 0;
    private int[] yPositions;
    private Random random = new Random();
    private boolean running = true;

    public SandAnimation() {
        setPreferredSize(new Dimension(500, 600));
        yPositions = new int[text.length() * 100];

        Thread thread = new Thread(this);
        thread.start();
    }

    private void resetAnimation() {
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        charIndex = 0;
        yPositions = new int[text.length() * 100];
        running = true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(13, 170, 93));
        g.setFont(new Font("Noto Sans KR", Font.BOLD, 40));

        int x = 50;
        int baseY = 40;
        for (int i = 0; i < charIndex; i++) {
            g.drawString(String.valueOf(text.charAt(i)), x, baseY);
            x += g.getFontMetrics().charWidth(text.charAt(i));
        }

        if (charIndex < text.length()) {
            x = 50 + g.getFontMetrics().stringWidth(text.substring(0, charIndex));
            for (int i = 0; i < 100; i++) {
                int particleX = x + random.nextInt(g.getFontMetrics().charWidth(text.charAt(charIndex)));
                int particleY = baseY + yPositions[charIndex * 100 + i];
                g.drawString(".", particleX, particleY);
            }
        }
    }

    @Override
    public void run() {
        while (true) {  // Infinite loop for continuous animation
            while (running) {
                if (charIndex < text.length()) {
                    for (int i = 0; i < 100; i++) {
                        yPositions[charIndex * 100 + i] += random.nextInt(3);
                    }
                    repaint();
                    if (yPositions[charIndex * 100 + 99] > 30) { // If most particles have settled
                        charIndex++;
                    }
                } else {
                    running = false;
                }

                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            // Reset and restart animation
            resetAnimation();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sand Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SandAnimation());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
