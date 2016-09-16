package com.fourhcode.forhutils;

/**
 * Created by developerhendy on 9/16/16.
 * © 2016.
 */

public class NoInternetPage {
    private String noInternetText;
    private String tryAgainText;

    public String getNoInternetText() {
        return noInternetText;
    }

    public void setNoInternetText(String noInternetText) {
        this.noInternetText = noInternetText;
    }

    public String getTryAgainText() {
        return tryAgainText;
    }

    public void setTryAgainText(String tryAgainText) {
        this.tryAgainText = tryAgainText;
    }

    public static class Builder {
        private String noInternetText;
        private String tryAgainText;

        public Builder setText(String noInternetText) {
            this.noInternetText = noInternetText;
            return this;
        }


        public Builder setTryAgainText(String tryAgainText) {
            this.tryAgainText = tryAgainText;
            return this;
        }


        public NoInternetPage build() {
            return new NoInternetPage(this);
        }
    }


    private NoInternetPage(Builder builder) {
        noInternetText = builder.noInternetText;
        tryAgainText = builder.tryAgainText;
    }

}
