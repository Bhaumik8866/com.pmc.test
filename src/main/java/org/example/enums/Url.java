package org.example.enums;

public enum Url {
 DEV("https://gateway-dev.carousel.eu/"),UAT("NA"),TEST("NA");
 String url;

    Url(String url) {
        this.url=url;
    }

    public String getUrl()
    {
        return url;
    }
}
