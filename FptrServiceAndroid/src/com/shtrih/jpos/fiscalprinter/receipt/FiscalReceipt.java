/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shtrih.jpos.fiscalprinter.receipt;

/**
 * @author V.Kravtsov
 */

import com.shtrih.barcode.PrinterBarcode;
import com.shtrih.fiscalprinter.FontNumber;
import com.shtrih.fiscalprinter.PrinterGraphics;
import com.shtrih.fiscalprinter.command.TextLine;
import java.util.Vector;

public interface FiscalReceipt {

    boolean getCapAutoCut() throws Exception;

    boolean isPayed() throws Exception;

    boolean isOpened();

    boolean isCancelled();

    void beginFiscalReceipt(boolean printHeader) throws Exception;

    void endFiscalReceipt(boolean printHeader) throws Exception;

    void printRecItem(String description, long price, int quantity,
                      int vatInfo, long unitPrice, String unitName) throws Exception;

    void printRecItemAdjustment(int adjustmentType, String description,
                                long amount, int vatInfo) throws Exception;

    void printRecMessage(int station, FontNumber font, String message)
            throws Exception;

    void printRecNotPaid(String description, long amount)
            throws Exception;

    void printRecRefund(String description, long amount, int vatInfo)
            throws Exception;

    void printRecSubtotal(long amount) throws Exception;

    void printRecSubtotalAdjustment(int adjustmentType,
                                    String description, long amount) throws Exception;

    void printRecTotal(long total, long payment, long payType,
                       String description) throws Exception;

    void printRecVoid(String description) throws Exception;

    void printRecVoidItem(String description, long amount, int quantity,
                          int adjustmentType, long adjustment, int vatInfo) throws Exception;

    void printRecCash(long amount) throws Exception;

    void printRecItemFuel(String description, long price, int quantity,
                          int vatInfo, long unitPrice, String unitName, long specialTax,
                          String specialTaxName) throws Exception;

    void printRecItemFuelVoid(String description, long price,
                              int vatInfo, long specialTax) throws Exception;

    void printRecPackageAdjustment(int adjustmentType,
                                   String description, String vatAdjustment) throws Exception;

    void printRecPackageAdjustVoid(int adjustmentType,
                                   String vatAdjustment) throws Exception;

    void printRecRefundVoid(String description, long amount, int vatInfo)
            throws Exception;

    void printRecSubtotalAdjustVoid(int adjustmentType, long amount)
            throws Exception;

    void printRecTaxID(String taxID) throws Exception;

    void printRecItemVoid(String description, long price, int quantity,
                          int vatInfo, long unitPrice, String unitName) throws Exception;

    void printRecItemAdjustmentVoid(int adjustmentType,
                                    String description, long amount, int vatInfo) throws Exception;

    void printRecItemRefund(String description, long amount,
                            int quantity, int vatInfo, long unitAmount, String unitName)
            throws Exception;

    void printRecItemRefundVoid(String description, long amount,
                                int quantity, int vatInfo, long unitAmount, String unitName)
            throws Exception;

    void printNormal(int station, String data) throws Exception;

    void fsWriteTLV(byte[] data) throws Exception;

    void fsWriteTag(int tagId, String tagValue) throws Exception;

    void disablePrint() throws Exception;

    boolean getDisablePrint();

    void fsWriteCustomerEmail(String text) throws Exception;

    void fsWriteCustomerPhone(String text) throws Exception;

    void setDiscountAmount(int amount) throws Exception;

    void printBarcode(PrinterBarcode barcode) throws Exception;

    void printGraphics(PrinterGraphics graphics) throws Exception;
    
}