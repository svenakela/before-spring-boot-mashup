package com.trustly.robocops.model;

public class Robocop {

    public static enum Language {JAVA, PYTHON, DB, UNKNOWN};
    private String developer = "";
    private String bank = "";
    private Language language = Language.UNKNOWN;

    public Robocop() {
        // Just default, do nothing.
    }

    public Robocop(final String developerName, final String bankName, final Language lang) {
        setDeveloper(developerName);
        setBank(bankName);
        setLanguage(lang);
    }

    public final static String getId(final Robocop cop) {
        return cop.getDeveloper();
    }

    public String getDeveloper() {
        return developer;
    }

    public String getBank() {
        return bank;
    }

    public Language getLanguage() {
        return language;
    }

    public void setDeveloper(final String developer) {
        this.developer = developer;
    }

    public void setBank(final String bank) {
        this.bank = bank;
    }

    public void setLanguage(final Language language) {
        this.language = language;
    }

}
