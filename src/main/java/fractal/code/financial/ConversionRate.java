package fractal.code.financial;

/**
 * Created by sorin.nica in September 2016
 */
public class ConversionRate {

    private final Currency referenceCurrency;

    private final Currency dependentCurrency;

    private final Number rate;

    public ConversionRate(Currency referenceCurrency, Currency dependentCurrency, Number rate) {
        this.referenceCurrency = referenceCurrency;
        this.dependentCurrency = dependentCurrency;
        this.rate = rate;
    }

}
