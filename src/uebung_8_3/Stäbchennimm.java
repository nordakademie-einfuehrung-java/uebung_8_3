package uebung_8_3;

import javax.swing.*;
import java.util.Random;

public class Stäbchennimm {
	private static int stapel = 13;
	private static String player1;
	private static String player2;
	private static Random zufall = new Random();
	private static int choice;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		introducegame();

		if (choice == JOptionPane.YES_OPTION) {

			for (int i = 0; i <= 1000; i++) {

				play(player1);
				if (stapel == 0) {
					JOptionPane.showMessageDialog(null,
							(player1 + ", Sie haben das Spiel verloren."));
					i = 1000;
				} else {
					playComputer();
					if (prüfeGewinner(player1) == true) {
						i = 1000;
					}
				}
			}
		}

		else {
			for (int i = 0; i <= 1000; i++) {
				play(player1);
				if (prüfeGewinner(player2) == true) {
					i = 1000;
				} else {
					play(player2);
					if (prüfeGewinner(player1) == true) {
						i = 1000;
					}
				}
			}
		}
	}

	public static void playComputer() {
		int nehme = 0;
		for (int i = 0; i <= 1000; i++) {
			nehme = zufall.nextInt(3);
			if (nehme != 0) {

				if (stapel - nehme >= 0) {
					i = 1000;
				}
			}

		}
		stapel = stapel - nehme;
		JOptionPane.showMessageDialog(null, "Der Computer hat " + nehme
				+ " Stäbchen gezogen.");

	}

	public static boolean prüfeGewinner(String player) {
		if (stapel == 0) {
			JOptionPane.showMessageDialog(null, "Glückwunsch " + player + ""
					+ ", Sie haben gewonnen!");
			return true;
		} else {
			return false;
		}

	}

	public static void play(String player) {
		int a = 0;
		for (int i = 0; i <= 1000; i++) {
			a = Integer
					.parseInt(JOptionPane
							.showInputDialog("Stapel: "
									+ stapel
									+ " Stäbchen. "
									+ player
									+ ", bitte entscheiden Sie, ob Sie 1, 2 oder 3 Stäbchen vom Stapel nehmen möchten."));
			if (a == 1 || a == 2 || a == 3) {
				if (stapel - a >= 0) {
					i = 1000;
				} else {
					JOptionPane
							.showMessageDialog(null,
									"Das war keine gültige Zahl, bitte versuchen Sie es erneut.");
				}
			} else {
				JOptionPane
						.showMessageDialog(null,
								"Das war keine gültige Zahl, bitte versuchen Sie es erneut.");
			}
		}

		stapel = stapel - a;
	}

	public static void introducegame() {
		player1 = JOptionPane
				.showInputDialog("Willkommen, wie lautet ihr Spielername?");
		choice = JOptionPane.showOptionDialog(null, "Spielen sie alleine?",
				"Wählen Sie eine Option", JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, null, null);
		if (choice == JOptionPane.NO_OPTION) {
			player2 = JOptionPane.showInputDialog("Wie ist heißt ihr Gegner?");
		}

		JOptionPane
				.showMessageDialog(
						null,
						"Der Stapel besteht aus 13 Stäbchen. Sie müssen abwechselnd 1, 2 oder 3 Stäbchen ziehen. Wer das letzte Stäbchen zieht, hat verloren. "
								+ player1 + ", Sie beginnen die Partie.");

	}
}
