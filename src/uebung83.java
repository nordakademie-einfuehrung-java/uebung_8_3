import java.util.*;


public class uebung83 {

	//ENTSCHEIDUNGSBAUM
	public static int entscheiden(int staebchen) {
		//Sichere Niederlageposition
		switch (staebchen) {
		case 1: return 1;
		}
		
		//Unsichere Niederlageposition
		switch (staebchen) {
		case 5: return 1;
		
		case 9: return 1;
		}
		
		//Sichere Siegposition
		switch (staebchen) {
		//Endsieg
		case 2: return 1;
		case 3: return 2;
		case 4: return 3;
		
		//Sieg bei Idealstrategie
		case 6: return 1;
		case 7: return 2;
		case 8: return 3;
		}
		
		if (staebchen >= 10) {
			if ((staebchen - 9) > 3) {
				return 1;
			} else {
				return (staebchen - 9);
			}
			
		}
		
		return 0;
		
		
		
		
	}
	
	//EINGABE
	public static int eingabe(int id, int staebchen) {
		if (id == 1) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Spieler " + id + ", bitte geben sie ihre Wahl ein:");
			int i = sc.nextInt();
			
			while (i != 1 && i != 2 && i != 3) {
				System.out.println("Sie haben sie keine Zahl zwischen 1 und 3 eingegeben. Versuchen sie es erneut:");
				i = sc.nextInt();
			}
			
			return i;
		} else {
			int decision = entscheiden(staebchen);
			System.out.println("Bot nimmt " + decision + " Staebchen.");
			
			return decision;
		}
		
		
	}
	
	public static void siegtest(int staebchen, int id) {
		
		if (staebchen <= 0) {
			System.out.println("Spieler " + id + ", sie haben verloren!");
		}
		
		
	}
	
	//MAIN
	public static void main(String[] args) {
		
		int staebchen = 13;
		System.out.println("Das Spiel beginnt!");
		System.out.println("Spieler 1 beginnt!");
		
		while (staebchen >= 0) {
			
			if (staebchen > 0) {
				System.out.println("Es liegen noch " + staebchen + " Staebchen auf dem Stapel.");
				staebchen = staebchen - eingabe(1, staebchen);
				siegtest(staebchen, 1);
			}
			
			if (staebchen > 0) {
				System.out.println("Es liegen noch " + staebchen + " Staebchen auf dem Stapel.");
				staebchen = staebchen - eingabe(2, staebchen);
				siegtest(staebchen, 2);
			}
			
		}

		
		
	}

}
