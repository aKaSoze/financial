package fractal.code.financial;

/**
 * Created by sorin.nica in September 2016
 */
public class FinancialValue {

    private final Number numericValue;

    private final Currency currency;

    public FinancialValue(Number numericValue, Currency currency) {
        this.numericValue = numericValue;
        this.currency = currency;
    }

    public FinancialValue convertTo(Currency otherCurrency, Exchange exchange) {
        if (otherCurrency == currency) return this;
        else return exchange.convert(this, otherCurrency);
    }

    public Number getNumericValue() {
        return numericValue;
    }

    public Currency getCurrency() {
        return currency;
    }

    public FinancialValue divide(Number divider) {
        return new FinancialValue(numericValue.doubleValue() / divider.doubleValue(), currency);
    }

    @Override
    public String toString() {
        return String.format("%.4f", numericValue) + " " + currency;
    }

}
