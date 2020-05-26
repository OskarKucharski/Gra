package obiektowosc;

public class Pies {
	
	int x, y;
	Plansza plansza;
	

	public Pies(int x, int y, Plansza plansza) {
		this.x = x;
		this.y = y;
		this.plansza = plansza;
	}

	public void ruch_G() {

		x -= 1;
		
		if(plansza.kolizja())
			x++;
		
		if (x < 0)
			x = 9;

	}

	public void ruch_D() {
		
		x += 1;
		if(plansza.kolizja())
			x--;
		if (x >= 10)
			x = 0;

	}

	public void ruch_L() {

		y -= 1;
		if(plansza.kolizja())
			y++;
		if (y < 0)
			y = 9;
			

	}

	public void ruch_P() {

		y += 1;
		if(plansza.kolizja())
			y--;
		if (y >= 10)
			y = 0;

	}

}
