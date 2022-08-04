package com.improving.tddair;

public class SpyCas implements CAS {
    private int chargedAmount = 0;
    public final static String VALID_CC = "999999999999999";
    public final static String INVALID_CC = "00000000000000";

    public int getChargedAmount() {
        return chargedAmount;
    }

    @Override
    public boolean authorize(String ccNum, int amount) {
        boolean isAuthorized = false;

        if (ccNum.equals(VALID_CC)) {
            chargedAmount = amount;
            isAuthorized = true;
        }

        return isAuthorized;
    }
}
