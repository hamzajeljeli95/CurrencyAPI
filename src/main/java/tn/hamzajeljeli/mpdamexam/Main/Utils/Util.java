package tn.hamzajeljeli.mpdamexam.Main.Utils;

import com.google.gson.Gson;
import tn.hamzajeljeli.mpdamexam.Main.Models.RatesResponse;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class Util {
    public static <T> T HttpGetRequest(String url, Type type) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        if (con.getResponseCode() == 200) {
            Reader reader = new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8);
            return new Gson().fromJson(reader, type);
        }
        return null;
    }

    public static void MultiplyAmount(RatesResponse R) {
        for (Map.Entry<String, Double> entry : R.rates.entrySet()) {
            entry.setValue(entry.getValue() * R.amount);
        }
    }
}
