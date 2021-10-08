package variables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
* Author: Jumanazar Saidov
* Currency converter
*/
public class CurrencyExchange {
    static double rate, inputVolume, outputVolume;
    static int currency = -1; // 0 - USD, 1 - UZS
    static String currencyStr = "", sign = "";
    public static void main(String[] args) throws IOException {
        rate = 1200;
        BufferedReader bf = new BufferedReader((new InputStreamReader((System.in))));
        Scanner scanner = new Scanner(System.in);
        while(true) {
            while(currency != 0 && currency != 1) {
                System.out.println("Please, choose the currency you want to exchange:\n Enter\n 0 for US Dollars (USD)\n 1 for Uzbek Soums (UZS)");
                currency = scanner.nextInt();
                currencyStr = currency == 0 ? "US Dollars (USD) " : (currency == 1 ? "Uzbek Soums (UZS)" : "Not a valid input");
            }
            sign = currency == 0 ? "USD" : "UZS";
            System.out.print("You have chosen " + currencyStr + ". Please, input your currency: " + sign + " ");
            inputVolume = scanner.nextDouble();
            //System.out.println("Please, wait while I am checking the rates...");

            outputVolume = doTheMath(currency, inputVolume, rate);

            System.out.println(inputVolume + " " + sign + " equals " + outputVolume + " " + (currency == 0 ? "UZS" : "USD"));
            System.out.printf("Type 0 to exit or any key to continue ... ");
            String outcome = bf.readLine();
            try {
                if (Integer.parseInt(outcome) == 0) {
                    System.out.printf("Thank you for your business. Bye!");
                    break;
                }
            }
            catch(Exception ignored){
            }
            currency = -1;
        }
    }

    /*
    Calculate the currency exchange and return the output
     */
    private static double doTheMath(int currency, double inputVolume, double rate) {
        double outputVolume;
        if (currency == 0) {
            outputVolume = rate * inputVolume;
        } else {
            outputVolume = inputVolume / rate;
        }
        return outputVolume;
    }
}
