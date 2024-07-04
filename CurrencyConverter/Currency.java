package CurrencyConverter;

public class Currency {
    private String name;
    private String symbol;
    private String shortname;
    public Currency(String name, String symbol,String shortname) {
        this.name = name;
        this.symbol = symbol;
        this.shortname = shortname;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getShortname(){ return shortname; }
}
