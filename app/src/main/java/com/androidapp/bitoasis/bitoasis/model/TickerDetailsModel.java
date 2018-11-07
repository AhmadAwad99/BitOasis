package com.androidapp.bitoasis.bitoasis.model;

/**
 * Created by Ahmad  awad on 06/11/2018.
 */
public class TickerDetailsModel {

    private String currencyId;
    private String lastTradePrice;
    private String lowestAsk;
    private String highestPid;
    private String percentChangeInLast;
    private String baseCurrencyVolume;
    private String quoteCurrencyVolume;
    private String isFrozen;
    private String highestTradePrice;
    private String lowestTradePrice;


    public String getIsFrozen() {
        return isFrozen;
    }

    public void setIsFrozen(String isFrozen) {
        this.isFrozen = isFrozen;
    }


    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public String getLastTradePrice() {
        return lastTradePrice;
    }

    public void setLastTradePrice(String lastTradePrice) {
        this.lastTradePrice = lastTradePrice;
    }

    public String getHighestPid() {
        return highestPid;
    }

    public void setHighestPid(String highestPid) {
        this.highestPid = highestPid;
    }

    public String getLowestAsk() {
        return lowestAsk;
    }

    public void setLowestAsk(String lowestAsk) {
        this.lowestAsk = lowestAsk;
    }

    public String getPercentChangeInLast() {
        return percentChangeInLast;
    }

    public void setPercentChangeInLast(String percentChangeInLast) {
        this.percentChangeInLast = percentChangeInLast;
    }

    public String getBaseCurrencyVolume() {
        return baseCurrencyVolume;
    }

    public void setBaseCurrencyVolume(String baseCurrencyVolume) {
        this.baseCurrencyVolume = baseCurrencyVolume;
    }

    public String getQuoteCurrencyVolume() {
        return quoteCurrencyVolume;
    }

    public void setQuoteCurrencyVolume(String quoteCurrencyVolume) {
        this.quoteCurrencyVolume = quoteCurrencyVolume;
    }

    public String getHighestTradePrice() {
        return highestTradePrice;
    }

    public void setHighestTradePrice(String highestTradePrice) {
        this.highestTradePrice = highestTradePrice;
    }

    public String getLowestTradePrice() {
        return lowestTradePrice;
    }

    public void setLowestTradePrice(String lowestTradePrice) {
        this.lowestTradePrice = lowestTradePrice;
    }


}
