package test.librarywrapper.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Date;

import test.librarywrapper.constants.DefaultReceiptInformation;
import test.librarywrapper.data.ReceiptInformation;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by mamba on 10.08.2017.
 */

@RunWith(JUnit4.class)
public class ReceiptInformationTest {
    ReceiptInformation.Builder nullBuilder;
    ReceiptInformation.Builder correctBuilder;
    ReceiptInformation nullInformation;
    ReceiptInformation correctInformation;

    @Before
    public void beforeTest(){
        nullBuilder = new ReceiptInformation.Builder();
        correctBuilder = new ReceiptInformation.Builder();
        correctBuilder
                .setDateAndTime(new Date(10))
                .setDocNumber("#15")
                .setInn("6449013711")
                .setPd("387908")
                .setReceiptNumber("10");
        nullInformation = nullBuilder.build();
        correctInformation = correctBuilder.build();
    }

    @Test
    public void testInitialization(){
        assertEquals(new Date(10).getTime(), correctInformation.getDateAndTime().getTime());
        assertEquals("#15", correctInformation.getDocNumber());
        assertEquals("6449013711", correctInformation.getInn());
        assertEquals("387908", correctInformation.getPd());
        assertEquals("10", correctInformation.getReceiptNumber());

        assertEquals(new Date(DefaultReceiptInformation.DATE), nullInformation.getDateAndTime());
        assertEquals(DefaultReceiptInformation.DOCUMENT_NUMBER, nullInformation.getDocNumber());
        assertEquals(DefaultReceiptInformation.INN, nullInformation.getInn());
        assertEquals(DefaultReceiptInformation.PD, nullInformation.getPd());
        assertEquals(DefaultReceiptInformation.RECEIPT_NUMBER, nullInformation.getReceiptNumber());
    }
}
