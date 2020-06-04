import java.util.Arrays;

//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: PiggyBank
// Files: PiggyBank.java , PiggyBankTester.java
// Course: CS300 Spring 2020
//
// Author: Yeon Jae Cho
// Email: ycho226@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understood the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course
// staff must fully acknowledge and credit those sources here. If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
///////////////////////////////////////////////////////////////////////////////
public class PiggyBankTester {

    public static boolean getCoinNameTestMethod() {
        // change some coin values and names
        PiggyBank.COINS_NAMES[1] = "Two cents";
        PiggyBank.COINS_NAMES[3] = "Fifty Cents";
        PiggyBank.COINS_VALUES[1] = 2;
        PiggyBank.COINS_VALUES[3] = 50;
        System.out.println(
            PiggyBank.getCoinName(PiggyBank.COINS_VALUES[1]).equals(PiggyBank.COINS_NAMES[1]));

        // consider all coin values as input arguments
        for (int i = 0; i < PiggyBank.COINS_VALUES.length; i++)
            if (!PiggyBank.getCoinName(PiggyBank.COINS_VALUES[i]).equals(PiggyBank.COINS_NAMES[i]))

                return false;

        // consider input argument which does not correspond to a coin value
        if (!PiggyBank.getCoinName(7).equals(PiggyBank.NO_SUCH_COIN))
            return false;
        if (!PiggyBank.getCoinName(-10).equals(PiggyBank.NO_SUCH_COIN))
            return false;

        return true;

    }

    /**
    * Checks whether PiggyBank.getBalance() method works as expected.
    * @return true when this test verifies a correct functionality, and false otherwise
    */
    public static boolean getBalanceTestMethod() {
        // scenario 1 - empty piggy bank
        int[] coins = new int[10]; // array storing the coins held in a piggy bank
        int size = 0; // number of coins held in coins array
        if (PiggyBank.getBalance(coins, size) != 0) {
            System.out.println("Problem detected. Your PiggyBank.getBalance() did not "
                + "return the expected output when passed an empty piggy bank.");
            return false;
        }
        // scenario 2 - non empty piggy bank
        coins = new int[] {10, 1, 5, 25, 1, 0, 0};
        size = 5;
        if (PiggyBank.getBalance(coins, size) != 42) {
            System.out.println("Problem detected. Your PiggyBank.getBalance() did not "
                + "return the expected output when passed an piggy bank that holds "
                + "two pennies, a nickel, a dime, and a quarter.");
            return false;
        }
        // scenario 3 - another non empty piggy bank
        coins = new int[] {10, 1, 5, 25, 1, 0};
        size = 3;
        if (PiggyBank.getBalance(coins, size) != 16) {
            System.out.println("Problem detected. Your PiggyBank.getBalance() did not "
                + "return the expected output when passed an piggy bank that holds "
                + "a penny, a nickel, and a dime, only.");
            return false;
        }
        return true;
    }

    /*
     * Checks if PiggyBank.getSpecificCoinCount() method works as expected
     * 
     * @return true if test works correctly, false if not
     * 
     */
    public static boolean getSpecificCoinCountTestMethod() {
        // scenario 1 - empty piggy bank
        int[] coins = new int[5]; // array storing the coins held in a piggy bank
        int size = 0; // number of coins held in coins array
        if (PiggyBank.getSpecificCoinCount(25, coins, size) != 0) {
            System.out.println("Problem detected. Your PiggyBank.getSpecificCoinCount() did not "
                + "return the expected output when passed an empty piggy bank.");
            return false;
        }
        // scenario 2 - non empty piggy bank with restricted size
        coins = new int[] {1, 1, 10, 25, 1, 0, 0};
        size = 5;
        if (PiggyBank.getSpecificCoinCount(1, coins, size) != 3) {
            System.out.println("Problem detected. Your PiggyBank.getSpecificCoinCount() did not "
                + "return the expected output when passed an piggy bank that holds "
                + "three pennies, a dime, and a quarter.");
            return false;
        }
        // scenario 3 - another non empty piggy bank with non-restricted size
        coins = new int[] {1, 5, 10, 5, 5, 5};
        size = 6;
        if (PiggyBank.getSpecificCoinCount(5, coins, size) != 4) {
            System.out.println("Problem detected. Your PiggyBank.getSpecificCoinCOunt() did not "
                + "return the expected output when passed an piggy bank that holds "
                + "a penny, four nickels, and a dime, only.");
            return false;
        }
        return true;
    }

    public static boolean addCoinTestMethod() {
        // scenario 1 - full array
        int[] coins = new int[5];
        int size = 0;
        int coin = 1;

        if (PiggyBank.addCoin(coin, coins, size) == size) {

            return false;

        }
        // scenario 2 - non empty array with restricted size
        coins = new int[] {1, 1, 10, 25, 1, 0, 0};
        size = 7;
        coin = 5;

        if (PiggyBank.addCoin(coin, coins, size) == size) {

            return false;
        }
        // scenario 3 - non empty array with non-restricted size
        coins = new int[] {1, 5, 10, 5, 5, 5};
        size = 3;
        coin = 25;

        if (PiggyBank.addCoin(coin, coins, size) == size) {


            return false;

        }

        System.out.println("Problem detected! PiggyBank.addCoin is not working as expected!");
        return true;

    }

    public static boolean removeCoinTestMethod() {
        // scenario 1 - empty array
        int[] coins = new int[5];
        int size = 0;
        if (PiggyBank.removeCoin(coins, size) == size) {

            return false;
        }

        // scenario 2 - non empty array with non-restricted array
        coins = new int[] {1, 1, 5, 10};
        size = 4;
        if (PiggyBank.removeCoin(coins, size) == size) {

            return false;
        }
        System.out.println(coins[3]);

        // scenario 3 - non empty array with restricted array
        coins = new int[] {1, 5, 5, 5, 10};
        size = 3;
        if (PiggyBank.removeCoin(coins, size) == size) {

            return false;

        }
        System.out.println(coins[3]);
        return true;


    }

    public static boolean emptyPiggyBankTestMethod() {
        // scenario 1 - empty bag
        int[] coins = new int[5];
        int size = 0;
        if (PiggyBank.emptyPiggyBank(coins, size) == size) {
            return false;
        }

        // scenario 2 - bag of coins with restricted size
        coins = new int[] {1, 5, 5, 5, 10};
        size = 3;
        if (PiggyBank.emptyPiggyBank(coins, size) == size) {
            return false;
        }

        // scenario 3 - bag of coins with its full size
        coins = new int[] {25, 1, 10, 5, 5, 10};
        size = 6;
        if (PiggyBank.emptyPiggyBank(coins, size) == size) {
            return false;
        }
        return true;
    }

    public static boolean withdrawTestMethod() {
        // scenario 1 - not enough money to withdraw desired amount
       int[] coins = new int[5];
        int size = 0;
        int amount = 3;
        int[] expected = {0,0,0,0,0};
       
    //   if (!Arrays.equals(PiggyBank.withdraw(amount, coins, size), expected)) {
      //     return false;
       // }

        // scenario 2 - exact change
        coins = new int[] {1,1,5,5,5,10,10,25,25};
        size = 9;
        amount = 40;
        expected = new int[] {1,1,5,5,10,25};
        
        if (!Arrays.equals(PiggyBank.withdraw(amount, coins, size), expected)) {
           
           return false;
        }
    
        coins = new int[] {1,5,10,5,25};
       size = 5;
        amount = 7;
        expected = new int [] {1,5,5,25};
        
        if (!Arrays.equals(PiggyBank.withdraw(amount,coins,size) , expected)) {
            return false;
        }
        return true;
    }


    /**
    * Displays information about the content of a piggy bank
    *
    * @param coins an oversize array storing the coins held in a piggy bank
    * @param size number of coin held array coins
    */


    public static void main(String[] args) {

        int[] coins = new int[] {10, 5, 5, 25, 1, 1};
        int size = 6;
        PiggyBank.printPiggyBank(coins, size);

        System.out.println("getSpecificCoinCountTest(): " + getSpecificCoinCountTestMethod());
        System.out.println("addCoinTest(): " + addCoinTestMethod());

        System.out.println(PiggyBank.getCoinName(5));

        System.out.println("getCoinNameTest(): " + getCoinNameTestMethod());

        System.out.println("getBalanceTest(): " + getBalanceTestMethod());

        System.out.println("removeCoinTest(): " + removeCoinTestMethod());

        System.out.println("emptyPiggyBankTest(): " + emptyPiggyBankTestMethod());

        System.out.println("withdrawTestMethod(): " + withdrawTestMethod());
    }



}


