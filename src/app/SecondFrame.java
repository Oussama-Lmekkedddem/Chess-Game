package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class SecondFrame extends JFrame {

	public static String str = "";
	public static JTextPane records = new JTextPane();

	public SecondFrame() {
		setTitle("Board of Dou Shou Qi");
		setSize(370, 600);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Icon.png")));

		// Charger l'image du fichier
		BufferedImage backgroundImage = null;
		try {
			backgroundImage = ImageIO.read(new File("C:\\Users\\hp\\Downloads\\Animal-Chess-Dou-Shou-Qi-main\\Animal-Chess-Dou-Shou-Qi-main\\src\\app\\gameboard.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Utiliser l'image comme arrière-plan de la fenêtre
		setContentPane(new BackgroundPanel(backgroundImage));

		// Centrer la fenêtre au milieu de l'écran
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);

		str += "-------------------------------------\n";
		str += "   J U N G L E  G A M E  B O A R D\n";
		str += "-------------------------------------\n";
		str += "-------------------------\n";
		str += "Score - YELLOW: " + Main.redWin + "\n";
		str += "        BLUE: " + Main.blueWin + "\n";
		str += "-------------------------\n";

		Font font = new Font("Courier", Font.BOLD, 16);

		records.setBackground(Color.decode("#212121"));
		records.setForeground(Color.WHITE);
		records.setFont(font);

		records.setText(str);

		records.setEditable(false);

		JScrollPane sp = new JScrollPane(records, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setBorder(BorderFactory.createEmptyBorder());
		sp.getViewport().setBackground(Color.decode("#212121"));

		add(sp);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}


}
