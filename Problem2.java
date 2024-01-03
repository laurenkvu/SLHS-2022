import java.util.Scanner;
public class Problem2 {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);

        // variables
        int testCases = scan.nextInt();
        int numCoins = scan.nextInt();
        int coinLength = scan.nextInt();
        int coinHeight;
        int coinChars; // number of characters per coin
        String coins = "";
        String correctCoin;
        
        // loop to count total lines for input and puts all lines into single string (to parse later)
        int numLines = 1;
        while (scan.hasNextLine()) {
            coins += scan.nextLine();
            numLines ++;
        }
        scan.close();
        // determines how many rows + chars each coin takes up
        coinHeight = numLines/numCoins;
        coinChars = coinHeight * coinLength;

        // compares first two coins; if they're the same, String correctCoin is initialized to first coin
            if (coins.substring(0, coinChars).equals(coins.substring(coinChars, coinChars*2)))  {
                correctCoin = coins.substring(0, coinChars);
                
                // compares correctCoin to the rest of the coins
                for (int i = 2; i < numCoins ; i++) {
                    if (!(correctCoin.equals(coins.substring(coinChars*i, coinChars*(i+1))))) {
                        System.out.println("Sir, coin " + (i+1) + " is a counterfeit!");

                        // to break out of loop if incorrect coin is found
                        i = numCoins;
                    }
                }
            }
            // if they're different, compare the first and third
            else {
                // if first and third are the same, second is the fake. if else, first is the fake.
                if (coins.substring(0, coinChars).equals(coins.substring(coinChars*2, coinChars*3)))
                    System.out.println("Sir, coin 2 is a counterfeit!");
                else 
                    System.out.println("Sir, coin 1 is a counterfeit!");
            }
    }
}
