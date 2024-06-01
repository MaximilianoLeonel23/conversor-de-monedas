package Modelos;

public class CurrencyConversion {
    private String baseCode;
    private String targetCode;
    private double conversionRate;
    private double inputAmount;
    private double convertedAmount;

    public CurrencyConversion(String baseCode, String targetCode, double conversionRate, double inputAmount) {
        this.baseCode = baseCode;
        this.targetCode = targetCode;
        this.conversionRate = conversionRate;
        this.inputAmount = inputAmount;
    }

    public void calculateConvertedAmount() {
        convertedAmount = conversionRate * inputAmount;
    }

    public String showConversion() {
        return String.format("El valor %.2f [%s] corresponde al valor final de =>>> %.2f [%s]", inputAmount, baseCode, convertedAmount, targetCode);
    }

    public String getBaseCode() {
        return baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public double getInputAmount() {
        return inputAmount;
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }
}
