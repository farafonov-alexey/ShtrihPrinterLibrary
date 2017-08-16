/*
 * SmFiscalPrinterInterface.java
 *
 * Created on 15 October 2010 Рі., 11:26
 *
 * To change this template, choose Tools | Template PrintVoidItemManager
 * and open the template in the editor.
 */
package com.shtrih.fiscalprinter;

/**
 * @author V.Kravtsov
 */

import java.util.Vector;

import com.shtrih.ej.EJDate;
import com.shtrih.barcode.PrinterBarcode;
import com.shtrih.fiscalprinter.command.*;
import com.shtrih.fiscalprinter.model.PrinterModel;
import com.shtrih.fiscalprinter.table.PrinterField;
import com.shtrih.fiscalprinter.table.PrinterFields;
import com.shtrih.fiscalprinter.table.PrinterTable;
import com.shtrih.fiscalprinter.table.PrinterTables;
import com.shtrih.jpos.fiscalprinter.FptrParameters;
import com.shtrih.jpos.fiscalprinter.PrinterImages;
import com.shtrih.printer.ncr7167.NCR7167Printer;
import com.shtrih.jpos.fiscalprinter.PrinterImage;
import com.shtrih.jpos.fiscalprinter.PrinterImages;
import com.shtrih.jpos.fiscalprinter.ReceiptImages;
import com.shtrih.jpos.fiscalprinter.PrintItem;

public interface SMFiscalPrinter {

    boolean getCapFSCloseReceipt();

    boolean getCapFiscalStorage();

    FptrParameters getParams();

    void addEvents(IPrinterEvents item);

    void removeEvents(IPrinterEvents item);

    void deviceExecute(PrinterCommand command) throws Exception;

    void connect() throws Exception;

    void check(int errorCode) throws Exception;

    void execute(PrinterCommand command) throws Exception;

    int getSysPassword();

    int getUsrPassword();

    int getTaxPassword();

    boolean failed(int errorCode);

    boolean succeeded(int errorCode);

    int executeCommand(PrinterCommand command) throws Exception;

    void setTaxPassword(int taxPassword);

    void setUsrPassword(int usrPassword);

    void setSysPassword(int sysPassword);

    Beep beep() throws Exception;

    int activateEJ() throws Exception;

    int printEJActivationReport() throws Exception;

    int initEJArchive() throws Exception;

    int testEJArchive() throws Exception;

    int closeEJArchive() throws Exception;

    int cancelEJDocument() throws Exception;

    int writeEJErrorCode(int errorCode) throws Exception;

    LongPrinterStatus readLongStatus() throws Exception;

    LongPrinterStatus getLongStatus() throws Exception;

    ShortPrinterStatus getShortStatus();

    ShortPrinterStatus readShortStatus() throws Exception;

    int printString(int station, String line) throws Exception;

    int printBoldString(int station, String line) throws Exception;

    void feedPaper(int station, int lineNumber) throws Exception;

    int printStringFont(int station, FontNumber font, String line)
            throws Exception;

    int printLine(int station, String line, FontNumber font)
            throws Exception;

    String[] splitText(String text, int n, boolean wrap)
            throws Exception;

    String[] splitText(String text, FontNumber font) throws Exception;

    void printText(int station, String text, FontNumber font)
            throws Exception;

    void printText(String text) throws Exception;

    int updateFieldInfo(int tableNumber, int fieldNumber)
            throws Exception;

    int writeTable(int tableNumber, int rowNumber, int fieldNumber,
                   String fieldValue) throws Exception;

    String readTable(int tableNumber, int rowNumber, int fieldNumber)
            throws Exception;

    String readTable(String tableName, String fieldName)
            throws Exception;

    int readTable(int tableNumber, int rowNumber, int fieldNumber,
                  String[] fieldValue) throws Exception;

    int readTableInfo(int tableNumber, Object[] out) throws Exception;

    ReadTableInfo readTableInfo(int tableNumber) throws Exception;

    PrintCashIn printCashIn(long sum) throws Exception;

    PrintCashOut printCashOut(long sum) throws Exception;

    ContinuePrint continuePrint() throws Exception;

    BeginTest startTest(int runningPeriod) throws Exception;

    EndTest stopTest() throws Exception;

    VoidFiscalReceipt cancelReceipt() throws Exception;

    VoidFiscalReceipt cancelReceipt(int password) throws Exception;

    EndFiscalReceipt closeReceipt(CloseRecParams params)
            throws Exception;

    long getSubtotal() throws Exception;

    int readOperationRegister(OperationRegister register)
            throws Exception;

    int readOperationRegister(int number) throws Exception;

    int readCashRegister(CashRegister register) throws Exception;

    long readCashRegister(int number) throws Exception;

    long readCashRegisterCorrection(int number) throws Exception;

    PrintEJDayReportOnDates printEJDayReportOnDates(EJDate date1,
                                                    EJDate date2, int reportType) throws Exception;

    PrintFMReportDates printFMReportDates(PrinterDate date1,
                                          PrinterDate date2, int reportType) throws Exception;

    PrintEJDayReportOnDays printEJReportDays(int day1, int day2,
                                             int reportType) throws Exception;

    PrintFMReportDays printFMReportDays(int day1, int day2,
                                        int reportType) throws Exception;

    void printSale(PriceItem item) throws Exception;

    void printVoidSale(PriceItem item) throws Exception;

    void printRefund(PriceItem item) throws Exception;

    void printVoidRefund(PriceItem item) throws Exception;

    PrintVoidItem printVoidItem(PriceItem item) throws Exception;

    PrintDiscount printDiscount(AmountItem item) throws Exception;

    PrintVoidDiscount printVoidDiscount(AmountItem item)
            throws Exception;

    PrintCharge printCharge(AmountItem item) throws Exception;

    PrintVoidCharge printVoidCharge(AmountItem item) throws Exception;

    ReadFMLastRecordDate readFMLastRecordDate() throws Exception;

    PrintXReport printXReport() throws Exception;

    PrintZReport printZReport() throws Exception;

    int printDepartmentReport() throws Exception;

    int printTaxReport() throws Exception;

    int printTotalizers() throws Exception;

    int writeDate(PrinterDate date) throws Exception;

    int confirmDate(PrinterDate date) throws Exception;

    void writeTime(PrinterTime time) throws Exception;

    void writePortParams(int portNumber, int baudRate, int timeout)
            throws Exception;

    void printBarcode(String barcode) throws Exception;

    void duplicateReceipt() throws Exception;

    void openReceipt(int receiptType) throws Exception;

    void loadGraphics(int lineNumber, int lineCount, byte[] data)
            throws Exception;

    int loadGraphics1(int lineNumber, byte[] data) throws Exception;

    int loadGraphics2(int lineNumber, byte[] data) throws Exception;

    int printGraphics1(int line1, int line2) throws Exception;

    void endDump() throws Exception;

    int printGraphics2(int line1, int line2) throws Exception;

    int getMaxGraphicsWidth() throws Exception;

    int loadRawGraphics(byte[][] data) throws Exception;

    void printGraphics(int line1, int line2) throws Exception;

    int printGraphicLine(int height, byte[] data) throws Exception;

    int cutPaper(int cutType) throws Exception;

    void cutPaper() throws Exception;

    void openCashDrawer(int drawerNumber) throws Exception;

    boolean checkEcrMode(int mode) throws Exception;

    PrinterStatus waitForPrinting() throws Exception;

    int[] getSupportedBaudRates() throws Exception;

    boolean tryCancelReceipt(int password) throws Exception;

    void writeDecimalPoint(int position) throws Exception;

    void resetFM() throws Exception;

    void sysAdminCancelReceipt() throws Exception;

    int getBaudRateIndex(int value) throws Exception;

    void setBaudRate(int baudRate) throws Exception;

    boolean connectDevice(int baudRate, int deviceBaudRate,
                          int deviceByteTimeout) throws Exception;

    void checkBaudRate(int value) throws Exception;

    void closePort() throws Exception;

    void writeTables(PrinterTables tables) throws Exception;

    void writeFields(PrinterFields fields) throws Exception;

    PrinterTable getTable(int tableNumber) throws Exception;

    boolean isValidField(PrinterField field)
            throws Exception;

    void readTables(PrinterTables tables) throws Exception;

    PrinterStatus readShortPrinterStatus() throws Exception;

    PrinterStatus readLongPrinterStatus() throws Exception;

    PrinterStatus readPrinterStatus() throws Exception;

    int readDeviceMetrics() throws Exception;

    DeviceMetrics getDeviceMetrics();

    void initialize() throws Exception;

    boolean getWrapText();

    void setWrapText(boolean value);

    void checkPaper(PrinterStatus status) throws Exception;

    int bufferZReport() throws Exception;

    int printBufferedZReport() throws Exception;

    int printTrailer() throws Exception;

    int printHeader() throws Exception;

    int initTables() throws Exception;

    void readTable(PrinterTable table) throws Exception;

    int writeField(PrinterField field) throws Exception;

    void writeField2(PrinterField field) throws Exception;

    PrinterField readField(PrinterField field) throws Exception;

    int stopEJPrint() throws Exception;

    int printEJDocument(int macNumber) throws Exception;

    int printEJDayReport(int dayNumber) throws Exception;

    int printEJDayTotal(int dayNumber) throws Exception;

    int readEJDayReport(int dayNumber) throws Exception;

    int readEJDayTotals(int dayNumber) throws Exception;

    void writeParameter(String paramName, int value) throws Exception;

    void writeParameter(String paramName, boolean value) throws Exception;

    void writeParameter(String paramName, String value) throws Exception;

    String readParameter(String paramName) throws Exception;

    int readIntParameter(String paramName) throws Exception;

    void printBarcode(PrinterBarcode barcode) throws Exception;

    void sleep(long millis);

    PrinterImages getPrinterImages();

    String processEscCommands(String text)
            throws Exception;

    int getLineHeight(FontNumber font) throws Exception;

    int getLineSpacing() throws Exception;

    void checkImageSize(int firstLine, int imageWidth, int imageHeight)
            throws Exception;

    int readLicense(String[] license) throws Exception;

    void printSeparator(int separatorType, int height) throws Exception;

    int getPrintWidth() throws Exception;

    FlexCommands getCommands() throws Exception;

    int getCommandTimeout(int code) throws Exception;

    int getResultCode();

    String getResultText();

    ReadEJActivationReport readEJActivationReport() throws Exception;

    ReadEJStatus readEJStatus() throws Exception;

    String[] readEJActivationText(int maxCount) throws Exception;

    FMTotals readFMTotals(int mode) throws Exception;

    FMTotals readFPTotals(int mode) throws Exception;

    FMTotals readFSTotals() throws Exception;

    void setEscPrinter(NCR7167Printer escPrinter);

    int beginFiscalDay() throws Exception;

    ReceiptImages getReceiptImages();

    void printReceiptImage(int position) throws Exception;

    PrinterImage getPrinterImage(int position) throws Exception;

    void printImage(PrinterImage image) throws Exception;

    void loadImage(PrinterImage image, boolean addImage) throws Exception;

    void printBlankSpace(int height) throws Exception;

    void waitForFiscalMemory() throws Exception;

    void waitForElectronicJournal() throws Exception;

    ReadCashRegister readCashRegister2(int number) throws Exception;

    ReadOperationRegister readOperationRegister2(int number)
            throws Exception;

    String getErrorText(int code) throws Exception;

    void openFiscalDay() throws Exception;

    int fsWriteTag(int tagId, String tagValue) throws Exception;

    int fsWriteTag1162(int catId, long groupId, String itemId)
            throws Exception;

    int fsWriteTLV(byte[] tlv) throws Exception;

    byte[] getTLVData(int tagId, String tagValue) throws Exception;

    FSReadStatus fsReadStatus() throws Exception;

    FSReadDayParameters fsReadDayParameters() throws Exception;

    boolean isFiscalized() throws Exception;

    int readDayNumber() throws Exception;

    int readDocNumber() throws Exception;

    void writeCasierName(String name) throws Exception;

    void writeAdminName(String name) throws Exception;

    void disablePrint() throws Exception;

    FSReadFiscalization fsReadFiscalization() throws Exception;

    FSReadCommStatus fsReadCommStatus() throws Exception;

    void startSaveCommands();

    void stopSaveCommands();

    void clearReceiptCommands();

    int printReceiptCommands() throws Exception;

    int fsReceiptDiscount(FSReceiptDiscount command) throws Exception;

    String getDepartmentName(int number) throws Exception;

    String getTaxName(int number) throws Exception;

    int getTaxRate(int number) throws Exception;

    int getDiscountMode() throws Exception;

    int printDocHeader(String title, int number) throws Exception;

    void printLines(String line1, String line2) throws Exception;

    void printItems(Vector<PrintItem> items) throws Exception;

    void printFSHeader() throws Exception;

    PrinterModel getModel() throws Exception;

    boolean getCapOpenReceipt() throws Exception;

    FSReadSerial fsReadSerial() throws Exception;

    String readFullSerial() throws Exception;

    FSReadExpDate fsReadExpDate() throws Exception;

    void checkDiscountMode(int mode) throws Exception;

    void printReceiptHeader(String docName) throws Exception;

    String getReceiptName(int receiptType);

    byte[] fsReadBlockData() throws Exception;

    void fsWriteBlockData(byte[] data) throws Exception;

    Vector<FSTicket> fsReadTickets(int[] fsDocumentNumbers) throws Exception;

    Vector<FSTicket> fsReadTickets(int firstFSDocumentNumber, int documentCount) throws Exception;

    int fsPrintCorrectionReceipt(FSPrintCorrectionReceipt command) throws Exception;

    int fsPrintCorrectionReceipt2(FSPrintCorrectionReceipt2 command) throws Exception;

    boolean getCapDisableDiscountText();

    int getMessageLength() throws Exception;

    int getMessageLength(FontNumber font) throws Exception;

    boolean isSubtotalInHeader();

    boolean isDiscountInHeader();

    int reboot() throws Exception;

    FDOParameters readFDOParameters() throws Exception;

    String ReadRnm() throws Exception;

    int getHeaderHeight() throws Exception;

    boolean getCapDiscount();

    FSFindDocument fsFindDocument(long docNumber) throws Exception;

    boolean capReadFSBuffer() throws Exception;

    int getMaxGraphicsLineWidth() throws Exception;
}
