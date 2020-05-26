package obiektowosc;

public class Plansza {

	String[][] plansza = new String[10][10];

	
	Pies pies;
	Bot bot;
	Napastnik napastnik;
	Sciana sciany[];
	Owoc[] owoce;

	boolean warunek = true;
	boolean warunekO0 = true;
	boolean warunekO1 = true;
	boolean uderzenie = false;
	boolean gra = true;
	boolean zjadl = false;

	public void ustaw(Pies pies, Bot bot, Sciana[] sciany, Owoc[] owoce, Napastnik napastnik) {
		this.pies = pies;
		this.bot = bot;
		this.sciany = sciany;
		this.owoce = owoce;
		this.napastnik = napastnik;
	}

	public void wyswietl() {
		
		for(int v=0; v<plansza.length; v++) 
			for(int w=0; w<plansza.length; w++) 		
				for(int k=0; k<sciany.length; k++) 				
					if(v == sciany[k].x && w == sciany[k].y) 
						plansza[v][w] = " * ";
						

		int licznik=0;
		
		for (int i = 0; i < plansza.length; i++) {
			
			for (int j = 0; j < plansza.length; j++) {

				if(plansza[i][j] != " * ") {
					
					if (i == pies.x && j == pies.y)
						System.out.print(" X ");
					else if (i == bot.x && j == bot.y && warunek == true)
						System.out.print(" K ");
					else if(i == owoce[0].x && j == owoce[0].y && warunekO0 == true || i == owoce[1].x && j == owoce[1].y && warunekO1 == true)
						System.out.print(" O ");
					else if(i == napastnik.x && j == napastnik.y)
						System.out.print(" N ");
					
					else
						System.out.print(" - ");
				}
				else
					System.out.print(plansza[i][j]);
			}
			licznik++;
			System.out.println();
		}

	}

	public void zbicie() {

		if ((pies.x == bot.x) && (pies.y == bot.y)) {
			warunek = false;
		}

	}

	public void zjedzenie() {

		if ((pies.x == owoce[0].x) && (pies.y == owoce[0].y)) {
			zjadl = true;
			warunekO0 = false;
		}	
		if((pies.x == owoce[1].x) && (pies.y == owoce[1].y)) {
			zjadl = true;
			warunekO1 = false;
		}	
		
	}
	public void uderzenie() {

	}
	
	public void sledzenie() {
		
		if(pies.x > napastnik.x)
			napastnik.ruch_D();
		else if(pies.x < napastnik.x)
			napastnik.ruch_G();
		if(pies.y > napastnik.y)
			napastnik.ruch_P();
		else if(pies.y < napastnik.y)
			napastnik.ruch_L();
		
	}
	public void smierc() {
		
		if(pies.x == napastnik.x && pies.y == napastnik.y) {
			
			System.out.println("Game over. Napastnik Cie dopadl!");
			gra = false;
			
		}
		
	}
	
	public void wygrana() {
		
		if(pies.x == bot.x && pies.y == bot.y) {
			
			System.out.println("Wygrales!");
			gra = false;
			
		}
		
	}
	
	public boolean kolizja() {
		for(int i=0; i<sciany.length; i++)
			if(pies.x == sciany[i].x && pies.y == sciany[i].y) 
				return true;
		return false;
	}


}
