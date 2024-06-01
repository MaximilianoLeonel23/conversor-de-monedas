import Modelos.ConversionRate;
import Modelos.ConversionRecorder;
import Modelos.CurrencyConversion;
import Modelos.CurrencyConverter;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int option;
        double inputAmount;
        CurrencyConverter converter = new CurrencyConverter();
        ConversionRecorder recorder = new ConversionRecorder();

        do {

            System.out.println("""
                    *******************************************
                    Sea bienvenido/a al Conversor de Moneda =]
                    
                    1) Dólar =>> Peso argentino
                    2) Peso argentino =>> Dólar
                    3) Dólar =>> Real brasileño
                    4) Real brasileño =>> Dólar
                    5) Dólar =>> Peso colombiano
                    6) Peso colombiano =>> Dólar
                    7) Dólar =>> Boliviano boliviano
                    8) Boliviano boliviano =>> Dólar
                    9) Dólar =>> Peso chileno
                    10) Peso chileno =>> Dólar
                    11) Historial de conversiones
                    12) Salir
                    Elija una opción válida:
                    *******************************************
                    """);
            option = sc.nextInt();
            if (option >= 1 && option <= 10) {
                        System.out.println("Ingrese el valor que desea convertir:");
                        inputAmount = sc.nextDouble();
                        ConversionRate conversionRate = null;
                        CurrencyConversion currencyConversion = null;
                   switch (option) {
                        case 1 -> conversionRate = converter.getConversionRate("USD", "ARS");
                        case 2 -> conversionRate = converter.getConversionRate("ARS", "USD");
                        case 3 -> conversionRate = converter.getConversionRate("USD", "BRL");
                        case 4 -> conversionRate = converter.getConversionRate("BRL", "USD");
                        case 5 -> conversionRate = converter.getConversionRate("USD", "COP");
                        case 6 -> conversionRate = converter.getConversionRate("COP", "USD");
                        case 7 -> conversionRate = converter.getConversionRate("USD", "BOB");
                        case 8 -> conversionRate = converter.getConversionRate("BOB", "USD");
                        case 9 -> conversionRate = converter.getConversionRate("USD", "CLP");
                        case 10 -> conversionRate = converter.getConversionRate("CLP", "USD");
                    };

                    currencyConversion = new CurrencyConversion(conversionRate.base_code(), conversionRate.target_code(), conversionRate.conversion_rate(), inputAmount);
                    currencyConversion.calculateConvertedAmount();
                    System.out.println(currencyConversion.showConversion());
                    recorder.addNewConversionRecord(currencyConversion);
            } else if (option == 11) {
                recorder.readConversionHistory();
            } else if (option != 12) {
                    System.out.println("Ingrese una opción válida");
            }
             recorder.recordConversions();
        } while (option != 12);

    }
}