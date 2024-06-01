import Modelos.ConversionRate;
import Modelos.CurrencyConversion;
import Modelos.CurrencyConverter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;
        double inputAmount;
        CurrencyConverter converter = new CurrencyConverter();

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
                    7) Salir
                    Elija una opción válida:
                    *******************************************
                    """);
            option = sc.nextInt();
            if (option >= 1 && option <= 6) {
                    System.out.println("Ingrese el valor que desea convertir:");
                    inputAmount = sc.nextDouble();
                    ConversionRate conversionRate = null;
                    CurrencyConversion currencyConversion = null;
                conversionRate = switch (option) {
                    case 1 -> converter.getConversionRate("USD", "ARS");
                    case 2 -> converter.getConversionRate("ARS", "USD");
                    case 3 -> converter.getConversionRate("USD", "BRL");
                    case 4 -> converter.getConversionRate("BRL", "USD");
                    case 5 -> converter.getConversionRate("USD", "COP");
                    case 6 -> converter.getConversionRate("COP", "USD");
                    default -> conversionRate;
                };
                currencyConversion = new CurrencyConversion(conversionRate.base_code(), conversionRate.target_code(), conversionRate.conversion_rate(), inputAmount);
                currencyConversion.calculateConvertedAmount();
                System.out.println(currencyConversion.showConversion());
            } else if (option != 7) {
                System.out.println("Ingrese una opción válida");
            }
        } while (option != 7);

    }
}