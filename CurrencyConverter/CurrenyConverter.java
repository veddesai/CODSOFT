package CurrencyConverter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class CurrenyConverter {
    private static final String API_KEY = "6e0abcc57e0040fd9847e5c0feab41cb"; // Replace with your API key
    private static final String API_URL = "https://openexchangerates.org/api/latest.json?app_id="+API_KEY+"&base=";

    public static double convert(double amount, Currency from, Currency to) throws IOException, ParseException {
        JSONObject jsonObject = getJsonObject(from);

        if (!jsonObject.containsKey("rates")) {
            throw new ParseException(0, "Missing 'rates' object in JSON response");
        }

        JSONObject ratesObject = (JSONObject) jsonObject.get("rates");
        double rate;
        if (!ratesObject.containsKey(to.getShortname())) {
            throw new ParseException(0, "Missing exchange rate for currency: " + to.getShortname());
        }
        rate = (Double) ratesObject.get(to.getShortname());
        return amount * rate;
    }

    private static JSONObject getJsonObject(Currency from) throws IOException, ParseException {
        String url = API_URL + from.getShortname();
        URL urlObject = new URL(url);
        URLConnection connection = urlObject.openConnection();

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder json = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            json.append(line);
        }
        reader.close();

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(json.toString());
        return jsonObject;
    }
}
