package coinpurse;

import java.util.List;
import java.util.Collections;

/**
 * MoneyUtil is to sort a coin
 * 
 * @author Pannapa Panpakdee
 *
 */
public class MoneyUtil {
	/**
	 * Return the sorted value of money and currency
	 * 
	 * @param coins is the money in purse that you want to sort
	 * @param currency is the unit of money in purse that you want to sort
	 * @return list of coin that already sorted
	 */
	public static List<Coin> filterByCurrency (List<Coin> coins, String currency) {
		for (Coin c: coins) {
			if (c.getCurrency() == currency)
				coins.add(c);
		}
		return coins;
	}
	
	/**
	 * Sort the coins in purse
	 * @param coins is the list of money that you sort
	 */
	public static void sortCoins(List<Coin> coins) {
		Collections.sort(coins);
	}
}
