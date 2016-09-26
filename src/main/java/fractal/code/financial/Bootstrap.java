package fractal.code.financial;

import org.joda.time.DateTime;

import java.time.Month;
import java.util.Optional;

/**
 * Created by sorin.nica in September 2016
 */
public class Bootstrap {

    public static void main(String[] args) {

        Company fractalCode = new Company("fractal-code", "12312345");
        Company adsWizz = new Company("AdsWizz", "1231245435");

        Contract contract = new Contract(
                adsWizz,
                fractalCode,
                new FinancialValue(3900, Currency.Euro),
                new DateTime(2016, 3, 1, 0, 0),
                Optional.<DateTime>empty());

        Exchange exchange = new Exchange();
        exchange.registerRate(Currency.Euro, Currency.RomanianLeu, 4.46);

        contract.getBill(Month.AUGUST, 21L, exchange);

    }
}
