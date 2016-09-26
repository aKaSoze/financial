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
        else return new FinancialValue(exchange.convert(numericValue, currency, otherCurrency), otherCurrency);
    }

    public Number getNumericValue() {
        return numericValue;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return numericValue + " " + currency;
    }
}
