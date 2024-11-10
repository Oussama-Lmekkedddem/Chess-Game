package app;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Setup {

	public Setup() {

		Main setup = new Main();
		StringBuilder omar = new StringBuilder();
		omar.append("------------------------------------- Bienvenue au Dou Shou Qi jeu ---------------------------------------\n");
		omar.append("------------------------------------------- Règles du jeu --------------------------------------------\n");
		omar.append("1 - Vous pouvez déplacer une pièce uniquement vers le haut, le bas, la gauche ou la droite\n");
		omar.append("2 - Les déplacements en diagonale ne sont pas autorisés\n");
		omar.append("3 - Le rat est le seul animal qui peut nager dans le lac\n");
		omar.append("4 - Pour gagner la partie, vous devez atteindre le sanctuaire\n");
		omar.append("5 - Hiérarchie des pièces : (de la plus puissante à la plus faible)\n");
		omar.append("         - E -> Éléphant (Le plus puissant)\n");
		omar.append("         - L -> Lion\n");
		omar.append("         - T -> Tigre\n");
		omar.append("         - P -> Panthère\n");
		omar.append("         - D -> Chien\n");
		omar.append("         - W -> Loup\n");
		omar.append("         - C -> Chat\n");
		omar.append("         - R -> Rat (Le plus faible)\n");
		omar.append("6 - Chaque animal peut manger un autre animal du même rang (Exemple : Un loup peut manger un autre loup)\n");
		omar.append("7 - Exception : (Le rat est le seul animal qui peut tuer l'éléphant)\n");
		omar.append("8 - Vous ne pouvez pas entrer dans votre propre sanctuaire\n");
		omar.append("9 - Le tigre et le lion peuvent sauter par-dessus le lac, mais pas s'il y a un rat sur le chemin\n");
		omar.append("10 - Si vous êtes dans un piège, n'importe quel animal peut vous tuer.\n");
		omar.append("--------------------------------------------------- Bonne chance ----------------------------------------------------\n");
		String msg = omar.toString();
		String msg1 = "- Vous pouvez déplacer la pièce en la faisant glisser.";

		ImageIcon oldIcon = new ImageIcon(getClass().getResource("/app/suduku.png"));
		Image oldImage = oldIcon.getImage();
		Image newImage1 = oldImage.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		Image newImage2 = oldImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon newIcon1 = new ImageIcon(newImage1);
		ImageIcon newIcon2 = new ImageIcon(newImage2);

		UIManager.put("OptionPane.background", Color.yellow);
		UIManager.put("Panel.background", Color.decode("#FFFFFF"));
		UIManager.put("OptionPane.messageFont", new Font(Font.MONOSPACED, Font.PLAIN, 14));

		JOptionPane.showMessageDialog(setup, msg.toUpperCase(), "Bienvenue Utilisateur !", JOptionPane.INFORMATION_MESSAGE, newIcon1);
		JOptionPane.showMessageDialog(setup, msg1.toUpperCase(), "Comment se déplacer", JOptionPane.INFORMATION_MESSAGE, newIcon2);

	}

	public static void main(String[] args) {

		new Setup();

	}

}
