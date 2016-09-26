package fractal.code.financial;

import fractal.code.commons.math.Math;
import org.joda.time.DateTime;

import java.time.Month;
import java.util.Optional;

/**
 * Created by sorin.nica in September 2016
 */
public class Contract {

    private final Company beneficiary;

    private final Company contractor;

    private final FinancialValue sum;

    private final DateTime start;

    private final Optional<DateTime> end;

    public Contract(Company beneficiary,
                    Company contractor,
                    FinancialValue sum,
                    DateTime start,
                    Optional<DateTime> end) {
        this.beneficiary = beneficiary;
        this.contractor = contractor;
        this.sum = sum;
        this.start = start;
        this.end = end;
    }

    public Company getBeneficiary() {
        return beneficiary;
    }

    public void getBill(Month month, Long workedDays, Exchange exchange) {
        Long numberOfWeekDays = 21L;

        Double billValue = Math.getThe4thProportional(numberOfWeekDays, sum.getNumericValue(), workedDays);

        FinancialValue billSum = new FinancialValue(billValue, sum.getCurrency());
        System.out.println(billSum);
    }
}
