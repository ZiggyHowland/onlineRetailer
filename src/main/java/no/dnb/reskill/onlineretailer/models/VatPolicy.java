package no.dnb.reskill.onlineretailer.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class VatPolicy {
    public static final double NO_UPPER_LIMIT = Double.MAX_VALUE;

    private double fromPrice;
    private double toPrice;
    private int vatPercentage;

}
