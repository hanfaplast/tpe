package imb.SS14.tpegr01.cinema;

import java.util.Comparator;

/**
 * Klasse <code>Hall</code> erzeugt und verwaltet die Saele.
 */

public class Hall {
	private String name;
	private int seats;

	/**
	 * Konstruktor erzeugt Saal mit Name und Anzahl
	 * 
	 * @param name
	 *            Name des Saals
	 * @param seats
	 *            Anzahl der Plaetze
	 */
	public Hall(String name, int seats) {
		this.setName(name);
		this.setSeats(seats);
	}

	public int getSeats() {
		return seats;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Hall) {
			Hall hallToCompare = (Hall) o;
			if (hallToCompare.name.equals(this.name)) {
				if (hallToCompare.seats == this.seats) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return ("Saal '" + getName() + "' (" + getSeats() + ((getSeats() == 1) ? " Platz)"
				: " Plaetze)"));
	}

	private void setName(String name) {
		this.name = name;
	}

	private void setSeats(int seats) {
		this.seats = seats;
	}

	/**
	 * Comparator zur Klasse Hall sortiert Säle nach Name und bei gleichem Namen
	 * nach der Anzahl der Sitze
	 * 
	 * @author Philipp Siebert
	 * 
	 */
	public static class HallComparator implements Comparator<Hall> {

		@Override
		public int compare(Hall o, Hall o2) {
			int titelVergleich = o.name.compareTo(o2.name);

			if (titelVergleich == 0) {
				if (o.seats < o2.seats) {
					return 1;
				} else {
					return -1;
				}
			}
			return titelVergleich;
		}
	}
}
