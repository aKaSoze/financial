package fractal.code.financial;

/**
 * Created by sorin.nica in September 2016
 */
public class Company {

    private final String name;

    private final String cui;

    public Company(String name, String cui) {
        this.name = name;
        this.cui = cui;
    }

    public String getName() {
        return name;
    }

    public String getCui() {
        return cui;
    }
}
