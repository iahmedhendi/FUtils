package com.fourhcode.forhutils;

/**
 * Created by developerhendy on 9/16/16.
 * © 2016.
 */

public class NoInternetPage {
    private String noInternetText;
    private String tryAgainText;
    private int icon;
    private String backgroundColorHex;
    private String textColor;
    private String tryAgainTextColor;
    private boolean animation;
    private String fontPath;

    public String getFontPath() {
        return fontPath;
    }

    public String getBackgroundColorHex() {
        return backgroundColorHex;
    }

    public String getTextColor() {
        return textColor;
    }

    public String getTryAgainTextColor() {
        return tryAgainTextColor;
    }

    public boolean isAnimation() {
        return animation;
    }

    public int getIcon() {
        return icon;
    }

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
        private int icon;
        private String backgroundColorHex;
        private String textColor;
        private String tryAgainTextColor;
        private boolean animation;
        private String fontPath;

        public Builder setFont(String fontPath) {
            this.fontPath = fontPath;
            return this;
        }

        public Builder setAnimation(boolean pageAnimation) {
            this.animation = pageAnimation;
            return this;
        }

        public Builder setTryAgainTextColor(String colorHex) {
            this.tryAgainTextColor = colorHex;
            return this;
        }


        public Builder setTextColor(String colorHex) {
            this.textColor = colorHex;
            return this;
        }

        public Builder setBackgroundColor(String colorHex) {
            this.backgroundColorHex = colorHex;
            return this;
        }


        public Builder setText(String noInternetText) {
            this.noInternetText = noInternetText;
            return this;
        }


        public Builder setTryAgainText(String tryAgainText) {
            this.tryAgainText = tryAgainText;
            return this;
        }

        public Builder setIcon(int drawableResource) {
            this.icon = drawableResource;
            return this;
        }

        public NoInternetPage build() {
            return new NoInternetPage(this);
        }
    }


    private NoInternetPage(Builder builder) {
        noInternetText = builder.noInternetText;
        tryAgainText = builder.tryAgainText;
        icon = builder.icon;
        backgroundColorHex = builder.backgroundColorHex;
        textColor = builder.textColor;
        tryAgainTextColor = builder.tryAgainTextColor;
        animation = builder.animation;
        fontPath = builder.fontPath;

    }

}
