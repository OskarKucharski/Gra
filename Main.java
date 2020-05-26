package obiektowosc;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void ruch(int wybor, Pies p1, Plansza plansza) {

		switch (wybor) {

		case 0:

			p1.ruch_G();
			break;

		case 1:

			p1.ruch_D();
			break;

		case 2:

			p1.ruch_L();
			break;

		case 3:

			p1.ruch_P();
			break;
		}

	}

	public static void ruchB(int wybor, Bot p1) {

		switch (wybor) {

		case 0:
			p1.ruch_G();
			break;
		case 1:
			p1.ruch_D();
			break;
		case 2:
			p1.ruch_L();
			break;
		case 3:
			p1.ruch_P();
			break;
		}

	}

	public static void main(String[] args) {
		System.out.println("0 - ruch do gory 1 ruch w dol\n2 - ruch w prawo 3 - ruch w lewo");
		
		int xK = 0, yK = 0;
		int xB = 5, yB = 5;
		int xN = 9, yN = 9;

		int xS = 0;
		int yS = 0;
		
		
		Sciana[] sciany = new Sciana[10];
		
		for(int i=0; i<10; i++) {
			
			xS = (int) (Math.random() * 10);
			yS = (int) (Math.random() * 10);
			
			Sciana s1 = new Sciana(xS, yS);
			
			sciany[i] = s1;
		}
		
		Owoc[] owoce = new Owoc[2];

		int xO = 0;
		int yO = 0;

		for (int i = 0; i < 2; i++) {

			xO = (int) (Math.random() * 10);
			yO = (int) (Math.random() * 10);

			Owoc o1 = new Owoc(xO, yO);

			owoce[i] = o1;
		}

		int ruchK = 0;
		int ruch_bota = 0;
		Plansza plansza = new Plansza();
		Bot b1 = new Bot(xB, yB);
		
		Pies p1 = new Pies(xK, yK, plansza);
		Napastnik n1 = new Napastnik(xN, yN);

		plansza.ustaw(p1, b1, sciany, owoce, n1);
		plansza.wyswietl();
//		plansza.wyswietlOwoc();

		Scanner ruch = new Scanner(System.in);

		int licznik = 0;

		while (plansza.gra) {
			ruch_bota = (int) (Math.random() * 3);
			ruchK = ruch.nextInt();

			plansza.kolizja();

			ruch(ruchK, p1, plansza);
			ruchB(ruch_bota, b1);

			if(licznik%3==0)
				plansza.sledzenie();

			plansza.zjedzenie();
			plansza.zbicie();

			if (plansza.zjadl == true) {
				plansza.wyswietl();
				for (int i = 0; i < 4; i++) {

					if (plansza.warunekO0 == false) {

						xO = (int) (Math.random() * 10);
						yO = (int) (Math.random() * 10);
						owoce[0] = new Owoc(xO, yO);

					}

					if (plansza.warunekO1 == false) {

						xO = (int) (Math.random() * 10);
						yO = (int) (Math.random() * 10);
						owoce[1] = new Owoc(xO, yO);

					}

					ruchK = ruch.nextInt();

					ruch(ruchK, p1, plansza);
					plansza.zjedzenie();
					plansza.zbicie();
					plansza.wyswietl();
					plansza.wygrana();
					plansza.smierc();
					System.out.println();
				}

				plansza.zjadl = false;
				plansza.warunekO1 = true;
				plansza.warunekO0 = true;

				plansza.ustaw(p1, b1, sciany, owoce, n1);

			}
			
			plansza.uderzenie = false;
			plansza.wygrana();
			plansza.smierc();
			plansza.wyswietl();
			System.out.println();
			licznik++;
		}

	}

}

//ArrayList<Pies> psy = new ArrayList<Pies>();
//Scanner x = new Scanner(System.in);
//
//
//for(int i=0; i<3; i++) {
//	
//	
//	System.out.println("Podaj rase");
//	
//	String rasa = x.nextLine();
//	
//	System.out.println("Podaj wiek");
//	
//	String wiek = x.nextLine();
//	
//	System.out.println("Podaj wage");
//	
//	String waga = x.nextLine();
//	
//	int w = Integer.parseInt(wiek);
//	double wg = Double.parseDouble(waga);
//	
//	Pies p1 = new Pies(rasa, w, wg);
//	
//	psy.add(p1);
//}
//Pies px = psy.get(0);
//double najw=0;
//double waga=0;
//
//for(int i=0; i<psy.size(); i++) {
//	
//	Pies p = psy.get(i);
//	
//	waga = p.waga;
//
//	if(waga>najw) {
//		najw = waga;
//		px = p;
//	}
//		
//}
//
//System.out.println("Najciezszy pies:");
//System.out.println(px.rasa + " wazy " + najw);