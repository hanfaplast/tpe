package imb.SS14.tpegr01.racewars.wesen;

public abstract class Wesen {

	private String rasse;
	private int kosten;
	private double lebenspunkte;
	private double ruestung;
	private double schaden;
	private double geschwindigkeit;
	private double spezialattribut;

	public Wesen(String rasse, int kosten, double lebenspunkte,
			double ruestung, double schaden, double geschwindigkeit,
			double spezialattribut) {
		this.rasse = rasse;
		this.kosten = kosten;
		this.lebenspunkte = lebenspunkte;
		this.geschwindigkeit = geschwindigkeit;
		this.ruestung = ruestung;
		this.schaden = schaden;
		this.spezialattribut = spezialattribut;
	}

	public boolean isLebendig() {
		if (this.lebenspunkte > 0) {
			return true;
		} else {
			return false; // todo remove from squad
		}
	}

	public String toString() {
		String details = "";
		return details;
	}

}