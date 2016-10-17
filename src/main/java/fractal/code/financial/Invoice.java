package fractal.code.financial;

/**
 * Created by sorin.nica in October 2016
 */
public class Invoice {

    private final FinancialValue value;

    private final FinancialValue dailyValue;

    public Invoice(FinancialValue value, FinancialValue dailyValue) {
        this.value = value;
        this.dailyValue = dailyValue;
    }

    public Invoice switchCurrency(Currency currency, Exchange exchange) {
        return new Invoice(value.convertTo(currency, exchange), dailyValue.convertTo(currency, exchange));
    }

    public FinancialValue getValue() {
        return value;
    }

    public FinancialValue getDailyValue() {
        return dailyValue;
    }
}
