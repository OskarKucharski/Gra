package obiektowosc;

public class Bot {

	int x, y;

	public Bot(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void ruch_G() {

		x -= 1;

		if (x < 0)
			x = 9;

	}

	public void ruch_D() {

		x += 1;

		if (x >= 10)
			x = 0;

	}

	public void ruch_L() {

		y -= 1;

		if (y <= 0)
			y = 9;

	}

	public void ruch_P() {

		y += 1;

		if (y >= 10)
			y = 0;

	}

}
