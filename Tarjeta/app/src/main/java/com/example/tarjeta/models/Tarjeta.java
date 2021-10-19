package com.example.tarjeta.models;

public class Tarjeta {
    private String lastactive_eur;
    private String lastactive_int;
    private String card_europe;
    private String card_international;
    private String current_card;

    public String getLastactive_eur() {
        return lastactive_eur;
    }

    public void setLastactive_eur(String lastactive_eur) {
        this.lastactive_eur = lastactive_eur;
    }

    public String getLastactive_int() {
        return lastactive_int;
    }

    public void setLastactive_int(String lastactive_int) {
        this.lastactive_int = lastactive_int;
    }

    public String getCard_europe() {
        return card_europe;
    }

    public void setCard_europe(String card_europe) {
        this.card_europe = card_europe;
    }

    public String getCard_international() {
        return card_international;
    }

    public void setCard_international(String card_international) {
        this.card_international = card_international;
    }

    public String getCurrent_card() {
        return current_card;
    }

    public void setCurrent_card(String current_card) {
        this.current_card = current_card;
    }
}
