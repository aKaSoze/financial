package fractal.code.financial;

import fractal.code.data.structures.Tuple;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sorin.nica in September 2016
 */
public class Exchange {

    private final Map<Tuple<Currency, Currency>, Number> rates = new HashMap<>();

    public void registerRate(Currency fromCurrency, Currency toCurrency, Number rate) {
        rates.put(new Tuple<>(fromCurrency, toCurrency), rate);
        rates.put(new Tuple<>(toCurrency, fromCurrency), 1 / rate.doubleValue());
    }

    public Double convert(Number value, Currency fromCurrency, Currency toCurrency) {
        return rates.get(new Tuple<>(fromCurrency, toCurrency)).doubleValue() * value.doubleValue();
    }

}
