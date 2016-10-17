package fractal.code.financial;

import fractal.code.calendar.CalendarUtils;
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

    private final FinancialValue monthlyValue;

    private final DateTime start;

    private final Optional<DateTime> end;

    public Contract(Company beneficiary,
                    Company contractor,
                    FinancialValue monthlyValue,
                    DateTime start,
                    Optional<DateTime> end) {
        this.beneficiary = beneficiary;
        this.contractor = contractor;
        this.monthlyValue = monthlyValue;
        this.start = start;
        this.end = end;
    }

    public Company getBeneficiary() {
        return beneficiary;
    }

    public Invoice calculateInvoice(Month month, Long workedDays) {
        Long numberOfWeekDays = CalendarUtils.getNumberOfWeekDays(month);
        Double invoiceNumericValue = Math.getThe4thProportional(numberOfWeekDays, monthlyValue.getNumericValue(), workedDays);
        FinancialValue invoiceValue = new FinancialValue(invoiceNumericValue, monthlyValue.getCurrency());

        Invoice invoice = new Invoice(invoiceValue, getDailyValue(month));
        return invoice;
    }

    private FinancialValue getDailyValue(Month month) {
        return monthlyValue.divide(CalendarUtils.getNumberOfWeekDays(month));
    }

}
