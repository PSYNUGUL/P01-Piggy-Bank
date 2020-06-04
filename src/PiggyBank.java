import java.util.Random;

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
public class PiggyBank {
    public final static int[] COINS_VALUES = {1, 5, 10, 25}; // coins values in cents
    // coins names
    public final static String[] COINS_NAMES = {"PENNY", "NICKEL", "DIME", "QUARTER"};

    public final static String NO_SUCH_COIN = "N/A"; // N/A string
    private final static Random RAND_GEN = new Random(100); // generator of random integer


    public static void printPiggyBank(int[] coins, int size) {
        System.out.println("QUARTERS: " + getSpecificCoinCount(25, coins, size));
        System.out.println("DIMES: " + getSpecificCoinCount(10, coins, size));
        System.out.println("NICKELS: " + getSpecificCoinCount(5, coins, size));
        System.out.println("PENNIES: " + getSpecificCoinCount(1, coins, size));
        System.out.println("Balance: $" + getBalance(coins, size) * 0.01);
    }

    /**
    * Returns the total number of coins of a specific coin value held in a piggy bank
    *
    * @param coinValue the value of a specific coin
    * @param coins an oversize array which contains all the coins held in a piggy
    * bank
    * @param size the total number of coins stored in coins array
    * @return the number of coins of value coinValue stored in the array coins
    */
    public static int getSpecificCoinCount(int coinValue, int[] coins, int size) {
        int pennyAmounts = 0;
        int nickelAmounts = 0;
        int dimeAmounts = 0;
        int quarterAmounts = 0;

        int selectedAmounts = 0;


        for (int i = 0; i < size; i++) {
            if (coins[i] == COINS_VALUES[0]) {
                pennyAmounts += 1;
            } else if (coins[i] == COINS_VALUES[1]) {
                nickelAmounts += 1;

            }

            if (coins[i] == COINS_VALUES[2]) {
                dimeAmounts += 1;
            }
            if (coins[i] == COINS_VALUES[3]) {
                quarterAmounts += 1;
            }

        }



        if (coinValue == COINS_VALUES[0]) {
            selectedAmounts = pennyAmounts;
        } else if (coinValue == COINS_VALUES[1]) {
            selectedAmounts = nickelAmounts;
        } else if (coinValue == COINS_VALUES[2]) {
            selectedAmounts = dimeAmounts;
        } else if (coinValue == COINS_VALUES[3]) {
            selectedAmounts = quarterAmounts;
        }

        return selectedAmounts;
    }

    /**
    * Returns the name of a specified coin value
    * @param coin represents a coin value in cents.
    * @return the String name of a specified coin value if it is valid and N/A if the
    * coin value is not valid
    */
    public static String getCoinName(int coin) {
        String coinMatch = null;
        if (COINS_VALUES[0] == coin) {
            coinMatch = COINS_NAMES[0];
        } else if (COINS_VALUES[1] == coin) {
            coinMatch = COINS_NAMES[1];
        } else if (COINS_VALUES[2] == coin) {
            coinMatch = COINS_NAMES[2];
        } else if (COINS_VALUES[3] == coin) {
            coinMatch = COINS_NAMES[3];
        } else {
            coinMatch = NO_SUCH_COIN;

        }

        return coinMatch;

    }

    /**
    * Returns the balance of a piggy bank in cents
    * @param coins an oversize array which contains all the coins held in a piggy bank
    * @param size the total number of coins stored in coins array
    * @return the total value of the coins held in a piggy bank in cents
    */
    public static int getBalance(int[] coins, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += coins[i];
        }
        return sum;

    }

    /**
    * Adds a given coin to a piggy bank. This operation can terminate
    * successfully or unsuccessfully. For either cases, this method
    * displays a descriptive message for either cases.
    *
    * @param coin the coin value in cents to be added to the array coins
    * @param coins an oversize array storing the coins held in a piggy bank
    * @param size the total number of coins contained in the array coins
    * before this addCoin method is called.
    * @return the new size of the coins array after trying to add coin.
    */
    public static int addCoin(int coin, int[] coins, int size) {

        if (coins.length > size) {
            if (coin == COINS_VALUES[0] || coin == COINS_VALUES[1] || coin == COINS_VALUES[2]
                || coin == COINS_VALUES[3]) {
                coins[size] = coin;
                size++;
            } else {
                System.out.println(coin + " cents is not a valid US currency coin.");
            }
            switch (coin) {
                case 1:
                    System.out.println("Added a " + COINS_NAMES[0] + ".");
                    break;
                case 5:
                    System.out.println("Added a " + COINS_NAMES[1] + ".");
                    break;
                case 10:
                    System.out.println("Added a " + COINS_NAMES[2] + ".");
                    break;
                case 25:
                    System.out.println("Added a " + COINS_NAMES[3] + ".");
                    break;
            }
        } else {
            switch (coin) {
                case 1:
                    System.out.println("Tried to add a " + COINS_NAMES[0]
                        + ", but could not because the piggy bank is full.");
                    break;
                case 5:
                    System.out.println("Tried to add a " + COINS_NAMES[1]
                        + ", but could not because the piggy bank is full.");
                    break;
                case 10:
                    System.out.println("Tried to add a " + COINS_NAMES[2]
                        + ", but could not because the piggy bank is full.");
                    break;
                case 25:
                    System.out.println("Tried to add a " + COINS_NAMES[3]
                        + ", but could not because the piggy bank is full.");
                    break;
            }
        }
        return size;
    }

    /**
    * Removes an arbitrary coin from a piggy bank. This method may terminate
    * successfully or unsuccessfully. In either cases, a descriptive message
    * is displayed.
    *
    * @param coins an oversize array which contains the coins held in a piggy bank
    * @param size the number of coins held in the coins array before this method
    * is called
    * @return the size of coins array after this method returns successfully
    */
    public static int removeCoin(int[] coins, int size) {

        if (size == 0 || coins.length == 0) {
            System.out
                .println("Tried to remove a coin, but could not because the piggy bank is empty.");
            return size;
        }

        int coin_to_remove = RAND_GEN.nextInt(size);
        size--;

        for (int i = coin_to_remove; i < size; i++) {
            coins[i] = coins[i++];
        }

        switch (COINS_VALUES[coin_to_remove]) {
            case 1:
                System.out.println("Removed a " + COINS_NAMES[0] + ".");
                break;
            case 5:
                System.out.println("Removed a " + COINS_NAMES[1] + ".");
                break;
            case 10:
                System.out.println("Removed a " + COINS_NAMES[2] + ".");
                break;
            case 25:
                System.out.println("Removed a " + COINS_NAMES[3] + ".");
                break;
        }
        return size;
    }

    /**
    * Removes all the coins in a piggy bank. It also displays the total value
    * of the removed coins
    *
    * @param coins an oversize array storing the coins held in a piggy bank application
    * @param size number of coins held in coins array before this method is called
    * @return the new size of the piggy bank after removing all its coins.
    */
    public static int emptyPiggyBank(int[] coins, int size) {
        if (size == 0 || coins.length == 0) {
            System.out.println("Zero coin removed. The piggy bank is already empty.");
            return size;
        }
        size = 0;
        return size;
    }

    /**
    * Removes the least number of coins needed to fulfill a withdrawal request
    *
    * @param amount amount to withdraw given in cents
    * @param coins an oversize array storing the coins held in a piggy bank
    * @param size number of coins stored in coins array before this method is called
    * @return perfect size array of 5 elements, index 0 stores the new size of
    * the piggy bank after this method returns. Indexes 1, 2, 3, and 4
    * store respectively the number of removed quarters, dimes,
    * nickels, and pennies.
    */


    public static int[] withdraw(int amount, int[] coins, int size) {
        // coin counts for each type
        int penny = getSpecificCoinCount(COINS_VALUES[0], coins, size);
        int nickel = getSpecificCoinCount(COINS_VALUES[1], coins, size);
        int dime = getSpecificCoinCount(COINS_VALUES[2], coins, size);
        int quarter = getSpecificCoinCount(COINS_VALUES[3], coins, size);
        int quarterCnt = 0;
        int dimeCnt = 0;
        int nickelCnt = 0;
        int pennyCnt = 0;


        int total = getBalance(coins, size);
        // temporary integer value to store data


        // array to return
        int[] withdrawnArray = new int[5];

        // no coin removed when balance < amount)
        if (amount > total) {
            System.out.println(
                "Unable to withdraw " + amount + " cents. NOT enough money in the piggy bank.");
            return withdrawnArray;
        }


        else {

            while (amount >= 25 && quarter > 0) {
                amount = amount - 25;
                quarter--;
                quarterCnt++;
                size--;
                withdrawnArray[0] = size;

            }


            while (amount >= 10 && dime > 0) {
                amount = amount - 10;
                dime--;
                dimeCnt++;
                size--;
                withdrawnArray[1] = quarterCnt;
            }


            while (amount >= 5 && nickel > 0) {
                amount = amount - 5;
                nickel--;
                nickelCnt++;
                size--;
                withdrawnArray[2] = dimeCnt;
            }



            while (amount >= 1 && penny > 0) {
                amount = amount - 1;
                penny--;
                pennyCnt++;
                size--;
                withdrawnArray[3] = pennyCnt;

            }

        }


        return withdrawnArray;

    }
}


