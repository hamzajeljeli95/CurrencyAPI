package tn.hamzajeljeli.mpdamexam.Main.Service;

import org.springframework.stereotype.Service;
import tn.hamzajeljeli.mpdamexam.Main.Models.Currency;
import tn.hamzajeljeli.mpdamexam.Main.Models.RatesResponse;
import tn.hamzajeljeli.mpdamexam.Main.Utils.Util;

import java.io.IOException;

@Service
public class CurrencyService {

    private static final String ServiceURI = "https://theforexapi.com/api/";

    public RatesResponse getExchangeRatesForCommomCurrencies(Currency sourceCurrency, Float amount) throws IOException {
        RatesResponse R = Util.HttpGetRequest(ServiceURI + "latest?base=" + sourceCurrency, RatesResponse.class);
        R.amount = amount;
        Util.MultiplyAmount(R);
        return R;
    }

    public RatesResponse getExchangeRate(Currency sourceCurrency, Currency destinationCurrency, Float amount) throws IOException {
        RatesResponse R = Util.HttpGetRequest(ServiceURI + "latest?base=" + sourceCurrency + "&symbols=" + destinationCurrency, RatesResponse.class);
        R.amount = amount;
        Util.MultiplyAmount(R);
        return R;
    }

    public RatesResponse getOldExchangeRatesForCommomCurrencies(String d, Currency sourceCurrency, Float amount) throws IOException {
        RatesResponse R = Util.HttpGetRequest(ServiceURI + d + "/?base=" + sourceCurrency, RatesResponse.class);
        R.amount = amount;
        Util.MultiplyAmount(R);
        return R;
    }

    public RatesResponse getOldExchangeRate(String d, Currency sourceCurrency, Currency destinationCurrency, Float amount) throws IOException {
        RatesResponse R = Util.HttpGetRequest(ServiceURI + d + "/?base=" + sourceCurrency + "&symbols=" + destinationCurrency, RatesResponse.class);
        R.amount = amount;
        Util.MultiplyAmount(R);
        return R;
    }

    public Currency[] AvailableCurrencies() {
        return Currency.values();
    }
}
