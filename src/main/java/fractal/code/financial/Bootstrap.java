package fractal.code.financial;

import fractal.code.calendar.CalendarUtils;
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
        exchange.registerRate(Currency.Euro, Currency.RomanianLeu,  4.5113);

        Invoice invoice = contract.calculateInvoice(Month.SEPTEMBER, CalendarUtils.getNumberOfWeekDays(Month.SEPTEMBER) - 7);

        InvoicePrinter invoicePrinter = new ConsoleInvoicePrinter();
        invoicePrinter.print(invoice);
        invoicePrinter.print(invoice.switchCurrency(Currency.RomanianLeu, exchange));

        invoice = contract.calculateInvoice(Month.OCTOBER, CalendarUtils.getNumberOfWeekDays(Month.OCTOBER));
        invoicePrinter.print(invoice);
        invoicePrinter.print(invoice.switchCurrency(Currency.RomanianLeu, exchange));

        System.out.println(CalendarUtils.getNumberOfWeekDays(Month.SEPTEMBER));
    }
}
