package uebung_8_3;

import java.util.Random;

import javax.swing.JOptionPane;

public class StaebchenNimm {

	public static void main(String[] args) {
		String spieler1 = new String();
		String spieler2 = new String();
		String spieler1nimmt = new String();
		String spieler2nimmt = new String();
		Random computerWahl = new Random();
		Random beginner = new Random();
		int computerNimmt = 0;
		boolean revanche = true;

		int staebchen = 13;

		// Spielmenue
		int spielmodus = JOptionPane.showConfirmDialog(null, "Spielst du alleine?");

		if (spielmodus == 0) {
			JOptionPane.showMessageDialog(null, "Ok, du spielst gegen den Computer! Viel Glück.");
			spieler1 = JOptionPane.showInputDialog(null, "Wie heißt du?");
		} else {
			JOptionPane.showMessageDialog(null, "2 Spielermodus! Viel Spaß!");
			spieler1 = JOptionPane.showInputDialog(null, " Spieler 1, wie heißt du?");
			spieler2 = JOptionPane.showInputDialog(null, " Spieler 2, wie heißt du?");
		}

		// Spiel
		do {
			if (spielmodus == 0) {
				for (int i = 0; staebchen > 0; i++) {
					spieler1nimmt = JOptionPane.showInputDialog(null, spieler1
							+ ": Wie viele Staebchen moechtest du nehmen? (1-3) Es liegen noch " + staebchen + " da!");
					int genommen = Integer.parseInt(spieler1nimmt);
					if (staebchen == 1) {
						JOptionPane.showMessageDialog(null, "Du hast leider verloren!");
						break;
					} else if (genommen > 3 || genommen < 0 || staebchen < genommen) {
						JOptionPane.showMessageDialog(null, "Ungültig! Der Computer ist dran.");
					} else {
						staebchen = staebchen - genommen;
					}

					if (staebchen > 3) {
						computerNimmt = computerWahl.nextInt(2) + 1;
						staebchen = staebchen - computerNimmt;
						JOptionPane.showMessageDialog(null,
								"Der Computer hat " + computerNimmt + " Staebchen genommen.");
					} else if (staebchen < 3 && staebchen > 1) {
						computerNimmt = computerWahl.nextInt(1) + 1;
						staebchen = staebchen - computerNimmt;
						JOptionPane.showMessageDialog(null,
								"Der Computer hat " + computerNimmt + " Staebchen genommen.");
					} else if (staebchen == 0 || staebchen == 1) {
						JOptionPane.showMessageDialog(null, "Du hast gewonnen!");
						break;
					}

				}
			} else if (spielmodus == 1) {
				int beginnt = beginner.nextInt(1) + 1;
				if (beginnt == 0) {

					while (staebchen > 0) {
						spieler1nimmt = JOptionPane.showInputDialog(null,
								spieler1 + ": Wie viele Staebchen moechtest du nehmen? (1-3) Es liegen noch "
										+ staebchen + " da!");
						int genommen = Integer.parseInt(spieler1nimmt);
						if (staebchen == 1) {
							JOptionPane.showMessageDialog(null, spieler2 + " hat gewonnen!");
							break;
						} else if (genommen > 3 || genommen < 0 || staebchen < genommen) {
							JOptionPane.showMessageDialog(null, "Ungültig!");
						} else {
							staebchen = staebchen - genommen;
						}

						spieler2nimmt = JOptionPane.showInputDialog(null,
								spieler2 + ": Wie viele Staebchen moechtest du nehmen? (1-3) Es liegen noch "
										+ staebchen + " da!");
						int genommen2 = Integer.parseInt(spieler2nimmt);
						if (staebchen == 1) {
							JOptionPane.showMessageDialog(null, spieler1 + " hat gewonnen!");
							break;
						} else if (genommen2 > 3 || genommen2 < 0 || staebchen < genommen2) {
							JOptionPane.showMessageDialog(null, "Ungültig!");
						} else {
							staebchen = staebchen - genommen2;
						}
					}
				} else {
					while (staebchen > 0) {
						spieler2nimmt = JOptionPane.showInputDialog(null,
								spieler2 + ": Wie viele Staebchen moechtest du nehmen? (1-3) Es liegen noch "
										+ staebchen + " da!");
						int genommen = Integer.parseInt(spieler2nimmt);
						if (staebchen == 1) {
							JOptionPane.showMessageDialog(null, spieler1 + " hat gewonnen!");
							break;
						} else if (genommen > 3 || genommen < 0 || staebchen < genommen) {
							JOptionPane.showMessageDialog(null, "Ungültig!");
						} else {
							staebchen = staebchen - genommen;
						}

						spieler1nimmt = JOptionPane.showInputDialog(null,
								spieler1 + ": Wie viele Staebchen moechtest du nehmen? (1-3) Es liegen noch "
										+ staebchen + " da!");
						int genommen2 = Integer.parseInt(spieler1nimmt);
						if (staebchen == 1) {
							JOptionPane.showMessageDialog(null, spieler2 + " hat gewonnen!");
							break;
						} else if (genommen2 > 3 || genommen2 < 0 || staebchen < genommen2) {
							JOptionPane.showMessageDialog(null, "Ungültig!");
						} else {
							staebchen = staebchen - genommen2;
						}
					}
				}

			}
			int nochmal = JOptionPane.showConfirmDialog(null, "Nochmal?");
			if (nochmal == 0) {
				revanche = true;
				staebchen = 13;
			} else {
				revanche = false;
			}
		} while (revanche == true);
	}

}
