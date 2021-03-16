package no.dnb.reskill.onlineretailer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class VatPolicy {
    public static final double NO_UPPER_LIMIT = -1;

    private double fromPrice;
    private double toPrice;
    private int vatPercentage;

}
