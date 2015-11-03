package com.toostinc.primegame;


import android.util.Log;
import android.widget.TextView;

/**
 * Class containing all the methods required to interpret {@link PrimeGame}
 * output and interact with the user.
 *
 * <p>
 * This subclass contains all the methods necessary for the user to
 * interact with {@link PrimeGame} methods and play the game.
 * @see PrimeGame
 * </p>
 *
 * @author  Joost Bremmer
 * @version 1.0
 * @since   2015
 */
public class PrimeGameAndroid extends PrimeGame {

   /**
   * Makes preperations for the next turn
   * Ressets the next number,
   * Increases the turn timer,
   * @see PrimeGame#getNewNumber
   * @see PrimeGame#increaseLevel
   */

  public void nextTurn(TextView primeView, TextView scoreView, TextView turnView) {

      turns++;
      getNewNumber(getCurrRange());
      Log.v("number", String.valueOf(getCurrNum()));
      Log.v("isprime", String.valueOf(checkPrime(getCurrNum())));
      primeView.setText(String.valueOf(getCurrNum()));
      scoreView.setText(String.valueOf(score));
      turnView.setText(String.valueOf(turns));

  }

    /**
     * Increase score by any amount
     * @param n amount to add to the current score
     */
    public void increaseScore(int n) {score += n;}

    /**
     * Decrease score by any amount
     * @param n amount to detract from current score
     */
    public void decreaseScore(int n) {score -= n;}
}
