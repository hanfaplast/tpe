package imb.SS14.tpegr01.racewars;

import imb.SS14.tpegr01.racewars.WesenFactory.Rasse;
import imb.SS14.tpegr01.racewars.wesen.Wesen;

public class Squad {

	private String name;
	private Wesen[] armee;
	int lebendigeWesen;

	public Squad(Spieler spieler) {
		this.name = spieler.getSquadName();
		Wesen[] truppe1 = rekrutiereArmee(spieler.getGewaehlteKlassen()[0],
				spieler.gewaehlteInvestitionen()[0]);
		Wesen[] truppe2;
		if (spieler.getGewaehlteKlassen().length == 2) {
			truppe2 = rekrutiereArmee(spieler.getGewaehlteKlassen()[1],
					spieler.gewaehlteInvestitionen()[1]);
		} else{
			truppe2=new Wesen[0];
		}
		this.armee = new Wesen[truppe1.length + truppe2.length];
		for (int i = 0; i < armee.length; i++) {
			if (i < truppe1.length) {
				this.armee[i] = truppe1[i];
			} else {
				this.armee[i] = truppe2[i - truppe1.length];
			}
		}
		this.lebendigeWesen = this.armee.length;
	}


	private Wesen[] rekrutiereArmee(Rasse rasse, int invest) {
		Wesen[] armee = WesenFactory.erschaffe(rasse, invest);
		return armee;
	}

	public void entferneWesenAusSquad(int index) {
		if (!armee[index].isLebendig()) {
			Wesen gestorbenesWesen = armee[index];
			armee[index] = armee[lebendigeWesen];
			armee[lebendigeWesen] = gestorbenesWesen;
			lebendigeWesen--;
		}
	}

	public String getName() {
		return this.name;
	}

	public int getLebendige() {
		return this.lebendigeWesen;
	}

	public String toString() {
		String info = "";
		for (int i = 0; i < armee.length; i++) {
			info += armee[i].getRasse() + "\t" + armee[i].getLebenspunkte()
					+ "\n";
		}

		return info;
	}

}
