package tn.hamzajeljeli.mpdamexam.Service;

import org.springframework.stereotype.Service;
import tn.hamzajeljeli.mpdamexam.Models.Currency;
import tn.hamzajeljeli.mpdamexam.Models.RatesResponse;
import tn.hamzajeljeli.mpdamexam.Utils.Util;

import java.io.IOException;

@Service
public class CurrencyService {

    private static final String ServiceURI = "https://theforexapi.com/api/latest?base=";

    public RatesResponse getExchangeRatesForCommomCurrencies(Currency sourceCurrency, Float amount) throws IOException {
        RatesResponse R = Util.HttpGetRequest(ServiceURI + sourceCurrency, RatesResponse.class);
        R.amount = amount;
        Util.MultiplyAmount(R);
        return R;
    }

    public RatesResponse getExchangeRate(Currency sourceCurrency, Currency destinationCurrency, Float amount) throws IOException {
        RatesResponse R = Util.HttpGetRequest(ServiceURI + sourceCurrency + "&symbols=" + destinationCurrency, RatesResponse.class);
        R.amount = amount;
        Util.MultiplyAmount(R);
        return R;
    }

    public Currency[] AvailableCurrencies() {
        return Currency.values();
    }
}
