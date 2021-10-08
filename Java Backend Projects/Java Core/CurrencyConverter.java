package variables;

/*
 * Author: Jumanazar Saidov
 * Perform all major operations available such as addition, subtraction, multiplication, division, and modulo division for two numbers received from user input
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class CurrencyConverter {
    static double rate, inputVolume, outputVolume;
    static Map<String, Double> rates = new HashMap<>();
    static int currency = -1; // 0 - USD, 1 - EUR, 2 - CNY, 3 - UZS
    static String currencyStr = "", sign = "";
    public static void main(String[] args) throws IOException {
        rate = 1200;
        rates.put("USD_EUR", 0.86);
        rates.put("USD_CNY", 6.45);
        rates.put("USD_UZS", 10700.47);

        rates.put("EUR_USD", 1.16);
        rates.put("EUR_CNY", 7.48);
        rates.put("EUR_UZS", 12408.85);

        rates.put("CNY_USD", 0.16);
        rates.put("CNY_EUR", 0.13);
        rates.put("CNY_UZS", 1659.84);

        BufferedReader bf = new BufferedReader((new InputStreamReader((System.in))));
        Scanner scanner = new Scanner(System.in);

            while(currency != 0 && currency != 1 && currency != 2 && currency != 3) {
                System.out.println("Please, choose the currency you want to exchange:\n Enter\n 0 for US Dollars (USD)\n 1 for Euro (EUR)\n 2 for Chinese Yuan (CNY)\n 3 for Uzbek Soums (UZS)");
                currency = scanner.nextInt();
                currencyStr = currency == 0 ? "US Dollars (USD) " : (currency == 1 ? "Euro" : (currency ==2 ? "Chinese Yuan" : (currency == 3 ? "Uzbek Soums (UZS)" : "Not a valid input")));
            }
            sign = currency == 0 ? "USD" : (currency == 1 ? "EUR" : (currency == 2 ? "CNY" : "UZS"));
            System.out.print("You have chosen " + currencyStr + ". Please, input your currency: " + sign + " ");
            inputVolume = scanner.nextDouble();
            //System.out.println("Please, wait while I am checking the rates...");

            outputVolume = doTheMath(currency, inputVolume, rates);

            System.out.println(inputVolume + " " + sign + " equals " + outputVolume);

    }

    /*
    Calculate the currency exchange and return the output
     */
    private static double doTheMath(int currency, double inputVolume, Map<String, Double> rates) {
        double outputVolume;
        AtomicReference<Double> rate = new AtomicReference<>((double) 0);
                rates.forEach((key,val) ->{
            if(key.startsWith(sign + "_")){
                rate.set(val);
            }
        });
        if (currency == 0) {
            outputVolume = rate.get() * inputVolume;
        } else {
            outputVolume = inputVolume / rate.get();
        }
        return outputVolume;
    }
}

