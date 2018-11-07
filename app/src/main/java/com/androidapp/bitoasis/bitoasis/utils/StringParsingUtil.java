package com.androidapp.bitoasis.bitoasis.utils;

import com.androidapp.bitoasis.bitoasis.model.TickerDetailsModel;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ahmad  awad on 06/11/2018.
 */
public class StringParsingUtil {

    public TickerDetailsModel getModelFromText(String txt) {

        TickerDetailsModel tickerDetailsModel = new TickerDetailsModel();
        String stringSplit = txt.replace("]", "");
        stringSplit = stringSplit.replace("[", "");
        stringSplit = stringSplit.replace("\"", "");

        List<String> stringsSplitted = Arrays.asList(stringSplit.split(","));
        if (stringsSplitted.size() > 10) {
            tickerDetailsModel.setCurrencyId(stringsSplitted.get(2));
            tickerDetailsModel.setLastTradePrice(stringsSplitted.get(3));
            tickerDetailsModel.setLowestAsk(stringsSplitted.get(4));
            tickerDetailsModel.setHighestPid(stringsSplitted.get(5));
            tickerDetailsModel.setPercentChangeInLast(stringsSplitted.get(6));
            tickerDetailsModel.setBaseCurrencyVolume(stringsSplitted.get(7));
            tickerDetailsModel.setQuoteCurrencyVolume(stringsSplitted.get(8));
            tickerDetailsModel.setIsFrozen(stringsSplitted.get(9));
            tickerDetailsModel.setHighestTradePrice(stringsSplitted.get(10));
            tickerDetailsModel.setLowestTradePrice(stringsSplitted.get(11));
        }
        return tickerDetailsModel;
    }

}
