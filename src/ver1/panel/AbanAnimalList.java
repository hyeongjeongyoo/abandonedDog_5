package ver1.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import ver1.DAO.PhotoDAO;
import ver1.DTO.PhotoDTO;

public class AbanAnimalList extends JPanel {

	private JTextField searchText;
	private JButton searchBtn;

	private JPanel petImage;
	private JPanel myWriter;

	private JTextField textFieldID;
	private JTextField textFieldKind;
	private JTextField textFieldColor;
	private JTextField textFieldAge;
	private JTextField textFieldWeight;
	private JTextField textFieldSex;
	private JTextField textFieldNeuter;
	private JTextArea textFieldSpecialMark;
	private JTextField textFieldShelter;

	private JScrollPane scrollPane;

	private JLabel labelID;
	private JLabel labelKind;
	private JLabel labelColor;
	private JLabel labelAge;
	private JLabel labelWeight;
	private JLabel labelSex;
	private JLabel labelNeuter;
	private JLabel labelSpecialMark;
	private JLabel labelShelter;

	private Font font;
	private Image image;

	public AbanAnimalList() {
		initData();
		setInitLayout();
		addEventLayout();
	}

	public void initData() {

		searchText = new JTextField();
		searchBtn = new JButton(new ImageIcon("img/serchBtn.jpg"));

		petImage = new JPanel();
		myWriter = new JPanel();

		labelID = new JLabel("아이디");
		textFieldID = new JTextField(20);

		labelKind = new JLabel("품종");
		textFieldKind = new JTextField(20);

		labelColor = new JLabel("색깔");
		textFieldColor = new JTextField(20);

		labelAge = new JLabel("나이");
		textFieldAge = new JTextField(20);

		labelWeight = new JLabel("무게");
		textFieldWeight = new JTextField(20);

		labelSex = new JLabel("성별");
		textFieldSex = new JTextField(20);

		labelNeuter = new JLabel("중성화");
		textFieldNeuter = new JTextField(20);

		labelSpecialMark = new JLabel("상세정보");
		textFieldSpecialMark = new JTextArea(5, 20);

		labelShelter = new JLabel("소속 보호소");
		textFieldShelter = new JTextField(20);

		scrollPane = new JScrollPane(textFieldSpecialMark); // Add JScrollPane

	}

	public void setInitLayout() {

		petImage = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (image != null) {
					g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
				}
			}
		};

		setLayout(null);
		setBackground(Color.white);

		myWriter.setLayout(null);

		searchText.setBounds(895, 700, 200, 22);
		add(searchText);

		searchBtn.setBounds(1099, 700, 59, 20);
		add(searchBtn);

		petImage.setBounds(30, 13, 400, 600);
		petImage.setBackground(Color.white);
		petImage.setBorder(new TitledBorder(new LineBorder(new Color(13, 170, 93), 3), null));
		add(petImage);

		myWriter.setBounds(450, 13, 700, 600);
		myWriter.setBackground(Color.white);
		myWriter.setBorder(new TitledBorder(new LineBorder(new Color(13, 170, 93), 3), null));
		add(myWriter);

		labelID.setBounds(20, 50, 120, 100);
		textFieldID.setBounds(80, 80, 180, 35);
		textFieldID.setEditable(false);

		labelKind.setBounds(20, 110, 120, 100);
		textFieldKind.setBounds(80, 140, 180, 35);
		textFieldKind.setEditable(false);

		labelColor.setBounds(20, 170, 120, 100);
		textFieldColor.setBounds(80, 200, 180, 35);
		textFieldColor.setEditable(false);

		labelAge.setBounds(20, 230, 120, 100);
		textFieldAge.setBounds(80, 260, 180, 35);
		textFieldAge.setEditable(false);

		labelWeight.setBounds(20, 290, 120, 100);
		textFieldWeight.setBounds(80, 320, 180, 35);
		textFieldWeight.setEditable(false);

		labelSex.setBounds(20, 350, 120, 100);
		textFieldSex.setBounds(80, 380, 180, 35);
		textFieldSex.setEditable(false);

		labelNeuter.setBounds(20, 410, 120, 100);
		textFieldNeuter.setBounds(80, 440, 180, 35);
		textFieldNeuter.setEditable(false);

		labelShelter.setBounds(300, 50, 120, 100);
		textFieldShelter.setBounds(410, 80, 230, 35);
		textFieldShelter.setEditable(false);

		labelSpecialMark.setBounds(300, 110, 120, 100);
		scrollPane.setBounds(410, 140, 230, 150);
		scrollPane.setEnabled(false);
		textFieldSpecialMark.setLineWrap(true); // Enable line wrap
		textFieldSpecialMark.setWrapStyleWord(true);

		myWriter.add(labelID);
		myWriter.add(labelKind);
		myWriter.add(labelColor);
		myWriter.add(labelAge);
		myWriter.add(labelWeight);
		myWriter.add(labelSex);
		myWriter.add(labelNeuter);
		myWriter.add(labelShelter);
		myWriter.add(labelSpecialMark);

		myWriter.add(textFieldID);
		myWriter.add(textFieldKind);
		myWriter.add(textFieldColor);
		myWriter.add(textFieldAge);
		myWriter.add(textFieldWeight);
		myWriter.add(textFieldSex);
		myWriter.add(textFieldNeuter);
		myWriter.add(textFieldShelter);
		myWriter.add(scrollPane);

		// Font 설정
		font = new Font("Noto Sans KR", Font.PLAIN, 17);
		labelID.setFont(font);
		textFieldID.setFont(font);
		labelKind.setFont(font);
		textFieldKind.setFont(font);
		labelColor.setFont(font);
		textFieldColor.setFont(font);
		labelAge.setFont(font);
		textFieldAge.setFont(font);
		labelWeight.setFont(font);
		textFieldWeight.setFont(font);
		labelSex.setFont(font);
		textFieldSex.setFont(font);
		labelNeuter.setFont(font);
		textFieldNeuter.setFont(font);
		labelSpecialMark.setFont(font);
		textFieldSpecialMark.setFont(font);
		labelShelter.setFont(font);
		textFieldShelter.setFont(font);
	}

	public void addEventLayout() {
		searchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String keyword = searchText.getText();
				if (!keyword.isEmpty()) {
					searchCareAnimal(Integer.parseInt(keyword));
				}
			}
		});

		searchText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String keyword = searchText.getText();
					if (!keyword.isEmpty()) {
						searchCareAnimal(Integer.parseInt(keyword));
					}
				}
			}
		});
	}

	public void searchCareAnimal(int value) {
		try {
			PhotoDTO dao = PhotoDAO.searchPhoto(value);
			String imagePath = dao.getPopfile().replaceFirst("http", "https");

			if (imagePath != null) {
				try {
					image = ImageIO.read(new URL(imagePath.trim()));
					textFieldShelter.setText(dao.getCareNm());
					textFieldID.setText(String.valueOf(dao.getId()));
					textFieldKind.setText(dao.getKindCd());
					textFieldColor.setText(dao.getColorCd());
					textFieldAge.setText(dao.getAge());
					textFieldWeight.setText(dao.getWeight());
					textFieldSex.setText(dao.getSexCd());
					textFieldNeuter.setText(dao.getNeuterYn());
					textFieldSpecialMark.setText(dao.getSpecialMark());
					petImage.repaint();
					searchText.setText(null);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}

		} catch (NumberFormatException e2) {
			JOptionPane.showMessageDialog(null, "숫자만 입력해주세요.", "조회 실패", JOptionPane.ERROR_MESSAGE);
		}
	}
}