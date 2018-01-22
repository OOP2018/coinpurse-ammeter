package coinpurse;

import java.lang.Comparable;

/**
 * Coin represents coinage (money) with a fixed value and currency
 * @author Pannapat Panpakdee
 *
 */
public class Coin implements Comparable<Coin>{
	/** Value of the coin */
	private double value;
	/** The currency of coin*/
	private String currency;

	/**
	 * A coin with given value using the defalut currency
	 * @param value
	 * @param currency
	 */
	public Coin(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}
	
	/**
	 * To return the value
	 * @return value
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * To return the currency
	 * @return currency
	 */
	public String getCurrency() {
		return this.currency;
	}
	
	/**
	 * To compare that the value and the currency is match or not
	 * @return true if the value and the currency is matched
	 */
	public boolean equals(Object arg) {
		if (arg == null)
			return false;
		if(arg.getClass() != this.getClass())
			return false;
		Coin other = (Coin) arg;
		if(other.value == this.value && this.currency.equalsIgnoreCase(other.currency))
			return true;
		return false;

	}
	
	/**
	 * To compare that which value is greater that another one without currency
	 * @return the result of checking
	 */
	@Override
	public int compareTo(Coin o) {
		if (value < o.getValue()) {
			return -1;
		} else if (value > o.getValue()) {
			return 1;
		} else if (value == o.getValue()) {
			return 0;
		}
		return 0;
	}

	/**
	 * To show the value of coin with currency
	 * @return String
	 */
	@Override
	public String toString() {
		return this.value+"-"+this.currency;
	}
}
