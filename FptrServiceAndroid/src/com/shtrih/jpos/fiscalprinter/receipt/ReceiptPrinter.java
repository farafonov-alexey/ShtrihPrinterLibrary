/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shtrih.jpos.fiscalprinter.receipt;

/**
 *
 * @author V.Kravtsov
 */

import com.shtrih.fiscalprinter.FontNumber;
import com.shtrih.fiscalprinter.SMFiscalPrinter;

public interface ReceiptPrinter {

    void waitForPrinting() throws Exception;

    void printPreLine() throws Exception;

    void printPostLine() throws Exception;

    long getSubtotal() throws Exception;

    void openReceipt(int receiptType) throws Exception;

    String printDescription(String description) throws Exception;

    void printText(String line) throws Exception;

    void printText(int station, String text, FontNumber font)
            throws Exception;

    void printStrings(String line1, String line2) throws Exception;

    SMFiscalPrinter getPrinter() throws Exception;

    int getTextLength() throws Exception;

    void printSeparator(int separatorType, int height) throws Exception;

    int getStation(int station) throws Exception;

    void checkZeroReceipt() throws Exception;
}
