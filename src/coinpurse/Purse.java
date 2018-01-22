package coinpurse;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 *  A coin purse contains coins.
 *  You can insert coins, withdraw money, check the balance,
 *  and check if the purse is full.
 *  
 *  @author Pannapat Panpakdee
 */
public class Purse {
	/** Collection of objects in the purse. */
	List<Coin> money;

	/** Capacity is maximum number of items the purse can hold.
	 *  Capacity is set when the purse is created and cannot be changed.
	 */
	private final int capacity;

	/** 
	 *  Create a purse with a specified capacity.
	 *  @param capacity is maximum number of coins you can put in purse.
	 */
	public Purse( int capacity ) {
		money = new ArrayList<Coin>( capacity );
		this.capacity = capacity;
	}

	/**
	 * Count and return the number of coins in the purse.
	 * This is the number of coins, not their value.
	 * @return the number of coins in the purse
	 */
	public int count() { 
		return money.size(); 
	}

	/** 
	 *  Get the total value of all items in the purse.
	 *  @return the total value of items in the purse.
	 */
	public double getBalance() {
		double sum = 0;
		for(int i=0; i<count(); i++){
			sum = sum + money.get(i).getValue();
		}
		return sum;
	}

	/**
	 * Return the capacity of the coin purse.
	 * @return the capacity
	 */
	public int getCapacity() { 
		return this.capacity; 
	}

	/** 
	 *  Test whether the purse is full.
	 *  The purse is full if number of items in purse equals
	 *  or greater than the purse capacity.
	 *  @return true if purse is full.
	 */
	public boolean isFull() {   
		if(count() >= this.capacity){
			return true;
		}
		return false;
	}

	/** 
	 * Insert a coin into the purse.
	 * The coin is only inserted if the purse has space for it
	 * and the coin has positive value.  No worthless coins!
	 * @param coin is a Coin object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert( Coin coin ) {
		// if the purse is already full then can't insert anything.

		if (!isFull()) {
			if (coin.getValue() <= 0) {
				return false;
			} else {
				money.add(coin);
				return true;
			}
		}
		return false;
	}

	/**  
	 *  Withdraw the requested amount of money.
	 *  Return an array of Coins withdrawn from purse,
	 *  or return null if cannot withdraw the amount requested.
	 *  @param amount is the amount to withdraw
	 *  @return array of Coin objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
	 */
	public Coin[] withdraw( double amount ) {
		List<Double> templist = new ArrayList<Double>();
		MoneyUtil.sortCoins(this.money);

		if ( amount != 0 ) {	
			//Arrays.sort(money.toArray());

			for (int i=0; i<money.size(); i++) {
				if (money.get(i).getValue() <= amount) {
					amount = amount - money.get(i).getValue();
					templist.add(money.get(i).getValue());

				}
				if (amount > getBalance()) {
					return null;
				}
			}
			
			if (amount == 0) {
				for (Double c1 : templist) {
					money.remove(c1);
				}
			}
			
			Coin []  array = new Coin[ templist.size() ];
			templist.toArray(array);
			return array;
		}

		return null;
	}

	/** 
	 * toString returns a string description of the purse contents.
	 * It can return whatever is a useful description.
	 */
	public String toString() {
		return count() + " coins with value " + getBalance();	

	}

	public static void main(String[] args) {
		Purse purse = new Purse(5);
		purse.insert(new Coin(5, "THB"));
		purse.insert(new Coin(10, "THB"));
		purse.insert(new Coin(0, "THB"));
		purse.insert(new Coin(1, "THB"));
		purse.insert(new Coin(5, "THB"));
		System.out.println(purse.toString());
		System.out.println(purse.toString());
	}

}
