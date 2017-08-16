/*
 * FiscalPrinterFilter113.java
 *
 * Created on 13 Январь 2011 г., 12:58
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package com.shtrih.jpos.fiscalprinter;

/**
 *
 * @author V.Kravtsov
 */

import com.shtrih.jpos.fiscalprinter.request.PrintRecItemAdjustmentRequest;
import com.shtrih.jpos.fiscalprinter.request.PrintRecItemVoidRequest;

public interface FiscalPrinterFilter113 {

    void beginFiscalDocument(int documentAmount) throws Exception;

    void beginFiscalReceipt(boolean printHeader) throws Exception;

    void beginFixedOutput(int station, int documentType)
            throws Exception;

    void beginInsertion(int timeout) throws Exception;

    void beginItemList(int vatID) throws Exception;

    void beginNonFiscal() throws Exception;

    void beginRemoval(int timeout) throws Exception;

    void beginTraining() throws Exception;

    void clearError() throws Exception;

    void clearOutput() throws Exception;

    void endFiscalDocument() throws Exception;

    void endFiscalReceipt(boolean printHeader) throws Exception;

    void endFixedOutput() throws Exception;

    void endInsertion() throws Exception;

    void endItemList() throws Exception;

    void endNonFiscal() throws Exception;

    void endRemoval() throws Exception;

    void endTraining() throws Exception;

    void getData(int dataItem, int[] optArgs, String[] data)
            throws Exception;

    void getDate(String[] Date) throws Exception;

    void getTotalizer(int vatID, int optArgs, String[] data)
            throws Exception;

    void getVatEntry(int vatID, int optArgs, int[] vatRate)
            throws Exception;

    void printDuplicateReceipt() throws Exception;

    void printFiscalDocumentLine(String documentLine) throws Exception;

    void printFixedOutput(int documentType, int lineNumber, String data)
            throws Exception;

    void printNormal(int station, String data) throws Exception;

    void printPeriodicTotalsReport(String date1, String date2)
            throws Exception;

    void printPowerLossReport() throws Exception;

    void printRecItem(String description, long price, int quantity,
                      int vatInfo, long unitPrice, String unitName) throws Exception;

    void printRecMessage(String message) throws Exception;

    void printRecNotPaid(String description, long amount)
            throws Exception;

    void printRecRefund(String description, long amount, int vatInfo)
            throws Exception;

    void printRecSubtotal(long amount) throws Exception;

    void printRecSubtotalAdjustment(int adjustmentType,
                                    String description, long amount) throws Exception;

    void printRecTotal(long total, long payment, String description)
            throws Exception;

    void printRecVoid(String description) throws Exception;

    void printRecVoidItem(String description, long amount, int quantity,
                          int adjustmentType, long adjustment, int vatInfo) throws Exception;

    void printReport(int reportType, String startNum, String endNum)
            throws Exception;

    void printXReport() throws Exception;

    void printZReport() throws Exception;

    void resetPrinter() throws Exception;

    void setDate(String date) throws Exception;

    void setHeaderLine(int lineNumber, String text, boolean doubleWidth)
            throws Exception;

    void setPOSID(String POSID, String cashierID) throws Exception;

    void setStoreFiscalID(String ID) throws Exception;

    void setTrailerLine(int lineNumber, String text, boolean doubleWidth)
            throws Exception;

    void setVatTable() throws Exception;

    void setVatValue(int vatID, String vatValue) throws Exception;

    void verifyItem(String itemName, int vatID) throws Exception;

    void setCurrency(int newCurrency) throws Exception;

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

    void resetStatistics(String statisticsBuffer) throws Exception;

    void retrieveStatistics(String[] statisticsBuffer) throws Exception;

    void updateStatistics(String statisticsBuffer) throws Exception;

    void compareFirmwareVersion(String firmwareFileName, int[] result)
            throws Exception;

    void updateFirmware(String firmwareFileName) throws Exception;

    PrintRecItemVoidRequest printRecItemVoid(
            PrintRecItemVoidRequest request) throws Exception;

    PrintRecItemAdjustmentRequest printRecItemAdjustment(
            PrintRecItemAdjustmentRequest request) throws Exception;

    void printRecItemAdjustmentVoid(int adjustmentType,
                                    String description, long amount, int vatInfo) throws Exception;

    void printRecItemRefund(String description, long amount,
                            int quantity, int vatInfo, long unitAmount, String unitName)
            throws Exception;

    void printRecItemRefundVoid(String description, long amount,
                                int quantity, int vatInfo, long unitAmount, String unitName)
            throws Exception;
}
