package CurrencyConverter;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserInterface {

    private static final Map<String, Currency> availableCurrencies = new HashMap<>();

    static {

        availableCurrencies.put("USD", new Currency("US Dollar", "$","USD"));
        availableCurrencies.put("EUR", new Currency("Euro", "€","EUR"));
        availableCurrencies.put("INR", new Currency("Indian Rupee","₹", "INR"));
    }

    public static void main(String[] args) throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Available Currencies:");
        for (Currency currency : availableCurrencies.values()) {
            System.out.println("- " + currency.getName() + " (" + currency.getSymbol() + ")");
        }

        Currency from = getCurrencyInput(scanner, "base");
        Currency to = getCurrencyInput(scanner, "target");

        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();

        double convertedAmount = CurrenyConverter.convert(amount, from, to);
        System.out.printf("%.2f %s is equal to %.2f %s\n", amount, from.getSymbol(), convertedAmount, to.getSymbol());
    }

    private static Currency getCurrencyInput(Scanner scanner, String type) {
        System.out.print("Enter " + type + " currency (from the list above): ");
        String currencyCode = scanner.nextLine().toUpperCase();

        if (!availableCurrencies.containsKey(currencyCode)) {
            System.out.println("Invalid currency code. Please try again.");
            return getCurrencyInput(scanner, type);
        }

        return availableCurrencies.get(currencyCode);
    }
}

