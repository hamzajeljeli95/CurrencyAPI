package tn.hamzajeljeli.mpdamexam.Main.Controller;

import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tn.hamzajeljeli.mpdamexam.Main.Models.Currency;
import tn.hamzajeljeli.mpdamexam.Main.Models.RatesResponse;
import tn.hamzajeljeli.mpdamexam.Main.Service.CurrencyService;

import java.io.IOException;

@RestController
@RequestMapping(value = "CurrencyExchange")
public class CurrencyController {
    @Autowired
    CurrencyService service;

    @RequestMapping(value = "/ExchangeRates/{SourceCurrency}/{Amount}/", method = RequestMethod.GET, produces = "application/json")
    public RatesResponse getExchangeRatesForCommomCurrencies(@PathVariable Currency SourceCurrency, @PathVariable Float Amount) throws IOException {
        return service.getExchangeRatesForCommomCurrencies(SourceCurrency, Amount);
    }

    @RequestMapping(value = "/ExchangeRate/{SourceCurrency}/{DestinationCurrency}/{Amount}/", method = RequestMethod.GET, produces = "application/json")
    public RatesResponse getExchangeRate(@PathVariable Currency SourceCurrency, @PathVariable Currency DestinationCurrency, @PathVariable Float Amount) throws IOException {
        return service.getExchangeRate(SourceCurrency, DestinationCurrency, Amount);
    }

    @RequestMapping(value = "/Currencies/", method = RequestMethod.GET, produces = "application/json")
    public Currency[] AvailableCurrencies() {
        return service.AvailableCurrencies();
    }

    @RequestMapping(value = "/OldExchangeRates/{date}/{SourceCurrency}/{Amount}/", method = RequestMethod.GET, produces = "application/json")
    public RatesResponse getExchangeRatesForCommomCurrencies(@ApiParam(example = "YYYY-MM-DD", value = "Minimum date is 1999-01-04") @PathVariable String date, @PathVariable Currency SourceCurrency, @PathVariable Float Amount) throws IOException {
        return service.getOldExchangeRatesForCommomCurrencies(date, SourceCurrency, Amount);
    }

    @RequestMapping(value = "/OldExchangeRate/{date}/{SourceCurrency}/{DestinationCurrency}/{Amount}/", method = RequestMethod.GET, produces = "application/json")
    public RatesResponse geOldtExchangeRate(@ApiParam(example = "YYYY-MM-DD", value = "Minimum date is 1999-01-04") @PathVariable String date, @PathVariable Currency SourceCurrency, @PathVariable Currency DestinationCurrency, @PathVariable Float Amount) throws IOException {
        return service.getOldExchangeRate(date, SourceCurrency, DestinationCurrency, Amount);
    }
}
