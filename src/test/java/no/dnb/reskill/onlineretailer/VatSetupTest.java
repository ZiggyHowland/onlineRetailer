package no.dnb.reskill.onlineretailer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VatSetupTest {

    @Test
    public void creatingVatSetup_withAdditionOfPolicy_shouldWork() {
        VatSetup vs = new VatSetup();
        vs.addVatPolicy(new VatPolicy(0, 50, 25));
        assertTrue(true);
    }
}