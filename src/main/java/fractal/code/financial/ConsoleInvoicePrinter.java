package fractal.code.financial;

/**
 * Created by sorin.nica in October 2016
 */
public class ConsoleInvoicePrinter implements InvoicePrinter {

    @Override
    public void print(Invoice invoice) {
        System.out.println("Value = " + invoice.getValue());
        System.out.println("Daily value = " + invoice.getDailyValue());
    }

}
