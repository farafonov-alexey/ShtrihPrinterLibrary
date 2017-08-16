/*
 * PrinterConst.java
 *
 * Created on August 6 2007, 12:08
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author V.Kravtsov
 */

package com.shtrih.fiscalprinter.command;

public interface PrinterConst {
    // ///////////////////////////////////////////////////////////////////
    // Field types

    int FIELD_TYPE_INT = 0;
    int FIELD_TYPE_STR = 1;

    // ###################################################################
    // #### General SHTRIH fiscal printer constants
    // ###################################################################

    // ///////////////////////////////////////////////////////////////////
    // Minimum text length
    // ///////////////////////////////////////////////////////////////////

    int MIN_TEXT_LENGTH = 40;

    // ///////////////////////////////////////////////////////////////////
    // Model constants
    // ///////////////////////////////////////////////////////////////////

    // SHTRIH-FR-F (ver. 03 & 04)
    int PRINTER_MODEL_SHTRIH_FRF = 0;

    // SHTRIH-FR-F (Kazakhstan)
    int PRINTER_MODEL_SHTRIH_FRFKAZ = 1;

    // ELVES-MINI-FR-F
    int PRINTER_MODEL_ELVES_MINI_FRF = 2;

    // FELIX-R F
    int PRINTER_MODEL_FELIX = 3;

    // SHTRIH-FR-K
    int PRINTER_MODEL_SHTRIH_FRK = 4;

    // SHTRIH-950K
    int PRINTER_MODEL_SHTRIH_950K = 5;

    // ELVES-FR-K
    int PRINTER_MODEL_ELVES_FRK = 6;

    // SHTRIH-MINI-FR-K
    int PRINTER_MODEL_SHTRIH_MINI_FRK = 7;

    // SHTRIH-FR-F (Belorussia)
    int PRINTER_MODEL_SHTRIH_FRF_BEL = 8;

    // SHTRIH-COMBO-FR-K
    int PRINTER_MODEL_COMBO_FRK = 9;

    // Fiscal module Shtrih-POS-F
    int PRINTER_MODEL_SHTRIH_POSF = 10;

    // SHTRIH-950K
    int PRINTER_MODEL_SHTRIH_950K2 = 11;

    // SHTRIH-COMBO-FR-K (ver. 02)
    int PRINTER_MODEL_COMBO_FRK2 = 12;

    // SHTRIH-MINI-FR-K (ver 02, 57 mm)
    int PRINTER_MODEL_SHTRIH_MINI_FRK2 = 14;

    // SHTRIH-KIOSK-FR-K
    int PRINTER_MODEL_SHTRIH_KIOSK_FRK = 15;

    // NCR001
    int PRINTER_MODEL_NCR001 = 17;

    // ШТРИХ-МОБАЙЛ-Ф
    int PRINTER_MODEL_SHTRIH_MOBILE_F = 19;
        
    // РИТЕЙЛ-01Ф
    int PRINTER_MODEL_RETAIL_01F = 22;
    
    // YARUS-02K
    int PRINTER_MODEL_YARUS02K = 248;

    // YARUS-01K
    int PRINTER_MODEL_YARUS01K = 249;
    // YARUS-01K
    int PRINTER_MODEL_YARUS01K2 = 243;

    // SHTRIH-M-PTK
    int PRINTER_MODEL_SHTRIH_M_PTK = 239;

    // SHTRIH-M-FR-K
    int PRINTER_MODEL_SHTRIH_M_FRK = 250;

    // SHTRIH-LIGHT-FR-K
    int PRINTER_MODEL_SHTRIH_LIGHT_FRK = 251;
    int PRINTER_MODEL_SHTRIH_LIGHT_FRK2 = 252;

    // ///////////////////////////////////////////////////////////////////
    // "ecrMode" Constants
    // ///////////////////////////////////////////////////////////////////

    // Dump mode
    int ECRMODE_DUMPMODE = 0x01;
    // Fiscal day opened, 24 hours have not run out
    int ECRMODE_24NOTOVER = 0x02;
    // Fiscal day opened, 24 hours have run out
    int ECRMODE_24OVER = 0x03;
    // Fiscal day closed
    int ECRMODE_CLOSED = 0x04;
    // Fiscal printer blocked after wrong password of tax inspector
    int ECRMODE_LOCKED = 0x05;
    // Confirm date mode
    int ECRMODE_WAITDATE = 0x06;
    // Mode for changing decimal dot position
    int ECRMODE_POINTPOS = 0x07;
    // Opened fiscal document: sale
    int ECRMODE_RECSELL = 0x08;
    // Opened fiscal document: buy
    int ECRMODE_RECBUY = 0x18;
    // Opened fiscal document: sale return
    int ECRMODE_RECRETSELL = 0x28;
    // Opened fiscal document: buy return
    int ECRMODE_RECRETBUY = 0x38;
    // Fiscal printer reset mode
    int ECRMODE_TECH = 0x09;
    // Print selftest mode
    int ECRMODE_TEST = 0x0A;
    // Printing full fiscal report
    int ECRMODE_FULLREPORT = 0x0B;
    // Printing electronic journal report
    int ECRMODE_EJREPORT = 0x0C;
    // Opened fiscal slip document: sale
    int ECRMODE_SLPSELL = 0x0D;
    // Opened fiscal slip document: buy
    int ECRMODE_SLPBUY = 0x1D;
    // Opened fiscal slip document: return sale
    int ECRMODE_SLPRETSELL = 0x2D;
    // Opened fiscal slip document: return buy
    int ECRMODE_SLPRETBUY = 0x3D;
    // Wait for slip loaded
    int ECRMODE_SLPWAITLOAD = 0x0E;
    // Slip loading and adjusting
    int ECRMODE_SLPLOAD = 0x1E;
    // Slip adjusting
    int ECRMODE_SLPPOSITION = 0x2E;
    // Printing slip
    int ECRMODE_SLPPRINTING = 0x3E;
    // Slip printing completed
    int ECRMODE_SLPPRINTED = 0x4E;
    // Slip ejecting
    int ECRMODE_SLPEJECT = 0x5E;
    // Waiting for slip removed
    int ECRMODE_SLPWAITEJECT = 0x6E;
    // Fiscal slip ready to print
    int ECRMODE_SLPREADY = 0x0F;

    // ###################################################################
    // #### MODE constants
    // ###################################################################

    // Dump mode
    int MODE_DUMPMODE = 0x01;

    // Fiscal day opened, 24 hours have not run out
    int MODE_24NOTOVER = 0x02;

    // Fiscal day opened, 24 hours have run out
    int MODE_24OVER = 0x03;

    // Fiscal day closed
    int MODE_CLOSED = 0x04;

    // Fiscal printer blocked after wrong password of tax inspector
    int MODE_LOCKED = 0x05;

    // Confirm date mode
    int MODE_WAITDATE = 0x06;

    // Mode for changing decimal dot position
    int MODE_POINTPOS = 0x07;

    // Opened fiscal document
    int MODE_REC = 0x08;

    // Fiscal printer reset mode
    int MODE_TECH = 0x09;

    // Print selftest mode
    int MODE_TEST = 0x0A;

    // Printing full fiscal report
    int MODE_FULLREPORT = 0x0B;

    // Printing electronic journal report
    int MODE_EJREPORT = 0x0C;

    // Opened fiscal slip document
    int MODE_SLP = 0x0D;

    // Print fiscal slip mode
    int MODE_SLPPRINT = 0x0E;

    // Fiscal slip ready to print
    int MODE_SLPREADY = 0x0F;

    // ###################################################################
    // #### Printer mode constants
    // ###################################################################

    String S_MODE_DUMPMODE = "Data output mode";
    String S_MODE_24NOTOVER = "Day is opened, 24 hours are not over";
    String S_MODE_24OVER = "Day is opened, 24 hours are over";
    String S_MODE_CLOSED = "Day is closed";
    String S_MODE_LOCKED = "Locked by incorrect tax assessor password";
    String S_MODE_WAITDATE = "Wait for date confirmation";
    String S_MODE_POINTPOS = "Decimal point position mode";
    String S_MODE_REC = "Opened document";
    String S_MODE_TECH = "Technical zero mode";
    String S_MODE_TEST = "Test print mode";
    String S_MODE_FULLREPORT = "Printing full fiscal report";
    String S_MODE_EJREPORT = "Printing EJ report";
    String S_MODE_SLP = "Slip document opened";
    String S_MODE_SLPPRINT = "Waiting for slip";
    String S_MODE_SLPREADY = "Fiscal slip is ready";
    String S_MODE_UNKNOWN = "Unknown mode";

    // ###################################################################
    // #### Printer submode constants
    // ###################################################################

    // Paper is present
    int ECR_SUBMODE_IDLE = 0;
    // Out of paper: passive
    int ECR_SUBMODE_PASSIVE = 1;
    // Out of paper: active
    int ECR_SUBMODE_ACTIVE = 2;
    // After active paper out
    int ECR_SUBMODE_AFTER = 3;
    // Printing reports mode
    int ECR_SUBMODE_REPORT = 4;
    // Printing mode
    int ECR_SUBMODE_PRINT = 5;

    // ###################################################################
    // #### Printer submode text constants
    // ###################################################################

    String S_ECR_SUBMODE_IDLE = "Paper is present";
    String S_ECR_SUBMODE_PASSIVE = "Out of paper: passive";
    String S_ECR_SUBMODE_ACTIVE = "Out of paper: active";
    String S_ECR_SUBMODE_AFTER = "After active paper out";
    String S_ECR_SUBMODE_REPORT = "Printing reports mode";
    String S_ECR_SUBMODE_PRINT = "Printing mode";
    String S_ECR_SUBMODE_UNKNOWN = "Unknown advanced mode";

    // ###################################################################
    // #### Cash totalizers numbers
    // ###################################################################

    // Receipt sales total amount on department 1
    int REG_REC_SELL1 = 0;

    // Receipt buys total amount on department 1
    int REG_REC_BUY1 = 1;

    // Receipt sales return total amount on department 1
    int REG_REC_RETSELL1 = 2;

    // Receipt buys return total amount on department 1
    int REG_REC_RETBUY1 = 3;

    // Total receipt discount amount on sales
    int REG_REC_DISC_SELL = 64;

    // Total receipt discount amount on buys
    int REG_REC_DISC_BUY = 65;

    // Total receipt discount amount on sale returns
    int REG_REC_DISC_RETSELL = 66;

    // Total receipt discount amount on buy returns
    int REG_REC_DISC_RETBUY = 67;

    // Total receipt charge amount on sales
    int REG_REC_CHRG_SELL = 68;

    // Total receipt charge amount on buys
    int REG_REC_CHRG_BUY = 69;

    // Total receipt charge amount on sale returns
    int REG_REC_CHRG_RETSELL = 70;

    // Total receipt charge amount on buy returns
    int REG_REC_CHRG_RETBUY = 71;

    // Total day discount amount on sales
    int REG_DAY_DISC_SELL = 185;

    // Total day discount amount on buys
    int REG_DAY_DISC_BUY = 186;

    // Total day discount amount on sale returns
    int REG_DAY_DISC_RETSELL = 187;

    // Total day discount amount on buy returns
    int REG_DAY_DISC_RETBUY = 188;

    // Total day charge amount on sales
    int REG_DAY_CHRG_SELL = 189;

    // Total day charge amount on buys
    int REG_DAY_CHRG_BUY = 190;

    // Total day charge amount on sale returns
    int REG_DAY_CHRG_RETSELL = 191;

    // Total day charge amount on buy returns
    int REG_DAY_CHRG_RETBUY = 192;

    // Total day sale amount from electronic journal
    int REG_DAY_SELL = 245;

    // Total day buy amount from electronic journal
    int REG_DAY_BUY = 246;

    // Total day sale return amount from electronic journal
    int REG_DAY_RETSELL = 247;

    // Total day buy return amount from electronic journal
    int REG_DAY_RETBUY = 248;

    // ###################################################################
    // #### Receipt types
    // ###################################################################

    // Sale receipt
    int SMFP_RECTYPE_SALE = 0;

    // Buy receipt
    int SMFP_RECTYPE_BUY = 1;

    // Sale return receipt
    int SMFP_RECTYPE_RETSALE = 2;

    // Buy return receipt
    int SMFP_RECTYPE_RETBUY = 3;

    // ###################################################################
    // #### Fiscal printer error codes
    // ###################################################################

    // No error
    int SMFP_EFPTR_SUCCESS = 0x00;
    // Error from FM1, FM2 or real time clock (RTC)
    int SMFP_EFPTR_FM_FAILURE = 0x01;
    // Fiscal memory 1 missing
    int SMFP_EFPTR_FM1_FAILURE = 0x02;
    int SMFP_EFPTR_FS_INVALID_STATE = 0x02;
    // Fiscal memory 2 missing
    int SMFP_EFPTR_FM2_FAILURE = 0x03;
    // Incorrect command parameters
    int SMFP_EFPTR_FM_PARAMS = 0x04;
    // No data available
    int SMFP_EFPTR_FM_NODATA = 0x05;
    // Fiscal memory in dump mode
    int SMFP_EFPTR_FM_DATAMODE = 0x06;
    // Incorrect command parameters for this model
    int SMFP_EFPTR_FM_PARAMS2 = 0x07;
    // Command is not supported for this model
    int SMFP_EFPTR_FM_INVALID_CMD = 0x08;
    // Incorrect command length
    int SMFP_EFPTR_FM_CMDLENGTH = 0x09;
    // Data not in BCD format
    int SMFP_EFPTR_FM_NOTBCD = 0x0A;
    // Fiscal memory failure on save total
    int SMFP_EFPTR_FM_MEMFAIL = 0x0B;
    // License not entered
    int SMFP_EFPTR_FM_NOLICENSE = 0x11;
    // Serial number already entered
    int SMFP_EFPTR_FM_SERIAL_EXISTS = 0x12;
    // Current date is less then last fiscal memory date
    int SMFP_EFPTR_FM_INVALID_DATE = 0x13;
    // Day totals area overflow in fiscal memory
    int SMFP_EFPTR_FM_OVERFLOW = 0x14;
    // Day is already opened
    int SMFP_EFPTR_FM_DAYOPENED = 0x15;
    // Day is not opened
    int SMFP_EFPTR_FM_DAYNOTOPENED = 0x16;
    // First day number more then last day number
    int SMFP_EFPTR_FM_DAYNUMBER = 0x17;
    // First day date more then last day date
    int SMFP_EFPTR_FM_DAYDATE = 0x18;
    // Command is not supported by this version of FP
    int SMFP_EFPTR_NOT_SUPPORTED = 0x37;
    // Receipt paper is empty
    int SMFP_EFPTR_NO_REC_PAPER = 0x6B;
    // Journal paper is empty
    int SMFP_EFPTR_NO_JRN_PAPER = 0x6C;
    // Slip is empty
    int SMFP_EFPTR_NO_SLP_PAPER = 0xC6;
    // Printing previous command
    int SMFP_EFPTR_PREVCOMMAND = 0x50;
    // Waiting for repeat print command
    int SMFP_EFPTR_WAIT_PRINT_CONTINUE = 0x58;
    // Table is undefined
    int SMFP_EFPTR_INVALID_TABLE = 0x5D;
    // Incorrect parameter value
    int SMFP_EFPTR_INVALID_PARAMETER = 0x33;
    // No more EJ data available (document end reached)
    int SMFP_EFPTR_EJ_NO_MORE_DATA = 0xA9;
    // No connection to fiscal memory
    int SMFP_EFPTR_FM_CONNECT_ERROR = 0x67;
    // Command not supported in submode
    int SMFP_EFPTR_INVALID_SUBMODE = 0x72;
    // Command not supported in mode
    int SMFP_EFPTR_INVALID_MODE = 0x73;
    // No connection to electronic journal
    int SMFP_EFPTR_EJ_CONNECT_ERROR = 0xA0;
    // Electronic journal missing
    int SMFP_EFPTR_EJ_MISSING = 0xA1;
    // REceipt buffer overflow
    int SMFP_EFPTR_RECBUF_OVERFLOW = 0x4B;
    

    // ###################################################################
    // #### cut types
    // ###################################################################

    int SMFP_CUT_FULL = 0x00; // full cut
    int SMFP_CUT_PARTIAL = 0x01; // partial cut

    // ###################################################################
    // #### station types
    // ###################################################################

    /** Journal station **/
    int SMFP_STATION_JRN = 0x01;

    /** Receipt station **/
    int SMFP_STATION_REC = 0x02;

    /** Slip station **/
    int SMFP_STATION_SLP = 0x04;

    /** Receipt & journal stations **/
    int SMFP_STATION_RECJRN = 0x03;

    // ////////////////////////////////////////////////////////////////////////
    // table numbers
    // ////////////////////////////////////////////////////////////////////////

    // ECR type and mode
    int SMFP_TABLE_SETUP = 1;
    // Cashier and admin's passwords
    int SMFP_TABLE_CASHIER = 2;
    // Time conversion table
    int SMFP_TABLE_TIME = 3;
    // Text in receipt
    int SMFP_TABLE_TEXT = 4;
    // Payment type names
    int SMFP_TABLE_PAYTYPE = 5;
    // Tax rates
    int SMFP_TABLE_TAX = 6;
    // Department names
    int SMFP_TABLE_DEPARTMENT = 7;
    // Font settings
    int SMFP_TABLE_FONTS = 8;
    // Receipt format table
    int SMFP_TABLE_RECFORMAT = 9;

    // ////////////////////////////////////////////////////////////////////////
    // tables values
    // ////////////////////////////////////////////////////////////////////////

    int SMFP_TABLE_TAX_ROW_MIN = 1;
    int SMFP_TABLE_TAX_ROW_MAX = 4;

    int SMFP_TABLE_TAX_ROW_CASH = 1;
    int SMFP_TABLE_TAX_ROW_CREDIT = 2;
    int SMFP_TABLE_TAX_ROW_TARE = 3;
    int SMFP_TABLE_TAX_ROW_CARD = 4;

    int SMFP_TABLE_TAX_FIELD_CASH = 1;
    int SMFP_TABLE_TAX_FIELD_CREDIT = 1;
    int SMFP_TABLE_TAX_FIELD_TARE = 1;
    int SMFP_TABLE_TAX_FIELD_CARD = 1;

    String SMFP_TABLE_TAX_VALUE_CASH = "CASH";
    String SMFP_TABLE_TAX_VALUE_CREDIT = "CREDIT";
    String SMFP_TABLE_TAX_VALUE_TARE = "TARE";
    String SMFP_TABLE_TAX_VALUE_CARD = "CARD";

    // ////////////////////////////////////////////////////////////////////////
    // graphics limits
    // ////////////////////////////////////////////////////////////////////////

    int MAX_LINES_GRAPHICS = 255;
    int MAX_LINES_GRAPHICS2 = 65535;

    // ////////////////////////////////////////////////////////////////////////
    // report type constants
    // ////////////////////////////////////////////////////////////////////////

    int SMFP_REPORT_TYPE_SHORT = 0;
    int SMFP_REPORT_TYPE_FULL = 1;

    // ////////////////////////////////////////////////////////////////////////
    // read FM totals constants
    // ////////////////////////////////////////////////////////////////////////

    // grand totals
    int SMFP_FM_GRANDTOTALS = 0x00;
    // grand totals after the last refiscalization
    int SMFP_FM_GRANDTOTALSFISC = 0x01;

    // ////////////////////////////////////////////////////////////////////////
    // Decimal point position constants
    // ////////////////////////////////////////////////////////////////////////

    int SMFP_POINT_POSITION_0 = 0; // 0 digits
    int SMFP_POINT_POSITION_2 = 1; // 2 digits

    // ////////////////////////////////////////////////////////////////////////
    // Status command constants
    // ////////////////////////////////////////////////////////////////////////

    // Status command 10h
    int SMFP_STATUS_COMMAND_10H = 0;

    // Status command 11h
    int SMFP_STATUS_COMMAND_11H = 1;

    // Driver selection
    int SMFP_STATUS_COMMAND_DS = 2;

    int SMFP_STATUS_COMMAND_MIN = 0;
    int SMFP_STATUS_COMMAND_MAX = 2;
    
    // ////////////////////////////////////////////////////////////////////////
    // Font number constants
    // ////////////////////////////////////////////////////////////////////////

    int FONT_NUMBER_NORMAL = 1;
    int FONT_NUMBER_DOUBLE = 2;
    int FONT_NUMBER_BOLD_SMALL = 3;
    int FONT_NUMBER_BOLD = 4;
    int FONT_NUMBER_SMALL = 5;
    int FONT_NUMBER_ITALIC = 6;
    int FONT_NUMBER_TIMES = 7;

    // ////////////////////////////////////////////////////////////////////////
    // Printer parameters constants
    // ////////////////////////////////////////////////////////////////////////

    // Automatic drawer open
    String SMFP_PARAMID_DRAWER_ENABLED = "DrawerEnabled";
    // Automatic receipt cut after close
    String SMFP_PARAMID_CUT_MODE = "CutMode";
    // Line spacing
    String SMFP_PARAMID_LINE_SPACING = "LineSpacing";
    // Receipt format enabled
    String SMFP_PARAMID_RECFORMAT_ENABLED = "ReceiptFormatEnabled";
    // НАИМЕНОВАНИЕ В ОПЕРАЦИИ
    String SMFP_PARAMID_ITM_NAME_LEN = "ReceiptItemNameLength";
    // ТЕКСТ В СКИДКЕ
    String SMFP_PARAMID_DSC_TEXT_LEN = "DiscountTextLength";
    // ТЕКСТ В НАДБАВКЕ
    String SMFP_PARAMID_CHR_TEXT_LEN = "ChargeTextLength";
    // ТЕКСТ В СТОРНО СКИДКИ
    String SMFP_PARAMID_DSCVOID_TEXT_LEN = "DiscountVoidTextLength";
    // ТЕКСТ В СТОРНО НАДБАВКИ
    String SMFP_PARAMID_CHRVOID_TEXT_LEN = "ChargeVoidTextLength";
    // FDO server host
    String SMFP_PARAMID_FDO_SERVER_HOST = "FDOServerHost";
    // FDO server port
    String SMFP_PARAMID_FDO_SERVER_PORT = "FDOServerPort";
    // FDO server timeout
    String SMFP_PARAMID_FDO_SERVER_TIMEOUT = "FDOServerTimeout";
    
    // ////////////////////////////////////////////////////////////////////////
    // Model ID constants
    // ////////////////////////////////////////////////////////////////////////

    int SMFP_MODELID_DEFAULT = 0;
    int SMFP_MODELID_SHTRIH_FRFv3 = 1;
    int SMFP_MODELID_SHTRIH_FRFv4 = 2;
    int SMFP_MODELID_SHTRIH_FRFKAZ = 3;
    int SMFP_MODELID_ELVES_MINI_FRF = 4;
    int SMFP_MODELID_FELIX = 5;
    int SMFP_MODELID_SHTRIH_FRK = 6;
    int SMFP_MODELID_SHTRIH_950K = 7;
    int SMFP_MODELID_ELVES_FRK = 8;
    int SMFP_MODELID_SHTRIH_MINI_FRK = 9;
    int SMFP_MODELID_SHTRIH_MINI_FRK2 = 10;
    int SMFP_MODELID_SHTRIH_FRF_BEL = 11;
    int SMFP_MODELID_COMBO_FRK = 12;
    int SMFP_MODELID_COMBO_FRK2 = 13;
    int SMFP_MODELID_SHTRIH_POSF = 14;
    int SMFP_MODELID_SHTRIH_950K2 = 15;
    int SMFP_MODELID_SHTRIH_KIOSK_FRK = 16;
    int SMFP_MODELID_YARUS02K = 17;
    int SMFP_MODELID_YARUS01K = 18;
    int SMFP_MODELID_SHTRIH_M_PTK = 19;
    int SMFP_MODELID_SHTRIH_M_FRK = 20;
    int SMFP_MODELID_SHTRIH_LIGHT_FRK = 21;
    int SMFP_MODELID_SHTRIH_LIGHT_FRK2 = 22;
    int SMFP_MODELID_ELVES_ASPD = 23;
    int SMFP_MODELID_NCR001 = 24;
    int SMFP_MODELID_SHTRIH_MOBILE_F = 25;

    // ////////////////////////////////////////////////////////////////////////
    // Error codes

    int SMFPTR_E_READ_ANSWER = 0;
    int SMFPTR_E_WRITE_COMMAND = 1;
    int SMFPTR_E_NOCONNECTION = 2;

    // ////////////////////////////////////////////////////////////////////////
    // Tax constants

    int SMFPTR_TAX_NOTAX = 0;
    int SMFPTR_TAX_A = 1;
    int SMFPTR_TAX_B = 2;
    int SMFPTR_TAX_C = 3;
    int SMFPTR_TAX_D = 4;
    
    ///////////////////////////////////////////////////////////////////////////
    // ReceiptItemType constants
    
    // НАИМЕНОВАНИЕ В ОПЕРАЦИИ
    int SMFPTR_RECITEM_ITM_NAME         = 0;
    // КОЛИЧЕСТВО X ЦЕНУ В ОПЕРАЦИИ
    int SMFPTR_RECITEM_ITM_QUANTITY     = 1;
    // СЕКЦИЯ В ОПЕРАЦИИ
    int SMFPTR_RECITEM_ITM_DEPARTMENT   = 2;
    // СТОИМОСТЬ В ОПЕРАЦИИ
    int SMFPTR_RECITEM_ITM_AMOUNT       = 3;
    // НАДПИСЬ СТОРНО В ОПЕРАЦИИ
    int SMFPTR_RECITEM_ITM_VOIDTEXT     = 4;
    // ТЕКСТ В СКИДКЕ
    int SMFPTR_RECITEM_DSC_TEXT         = 5;
    // НАДПИСЬ СКИДКА
    int SMFPTR_RECITEM_DSC_CAPTION      = 6;
    // СУММА СКИДКИ
    int SMFPTR_RECITEM_DSC_AMOUNT       = 7;
    // ТЕКСТ В НАДБАВКЕ
    int SMFPTR_RECITEM_CHR_TEXT         = 8;
    // НАДПИСЬ НАДБАВКА
    int SMFPTR_RECITEM_CHR_CAPTION      = 9;
    // СУММА НАДБАВКИ
    int SMFPTR_RECITEM_CHR_AMOUNT       = 10;
    // ТЕКСТ В СТОРНО СКИДКИ
    int SMFPTR_RECITEM_DSCVOID_TEXT     = 11;
    // НАДПИСЬ СТОРНО СКИДКИ
    int SMFPTR_RECITEM_DSCVOID_CAPTION  = 12;
    // СУММА СТОРНО СКИДКИ
    int SMFPTR_RECITEM_DSCVOID_AMOUNT    = 13;
    // ТЕКСТ В СТОРНО НАДБАВКИ
    int SMFPTR_RECITEM_CHRVOID_TEXT      = 14;
    // НАДПИСЬ СТОРНО НАДБАВКИ
    int SMFPTR_RECITEM_CHRVOID_CAPTION   = 15;
    // СУММА СТОРНО НАДБАВКИ
    int SMFPTR_RECITEM_CHRVOID_AMOUNT    = 16;
    
    // ////////////////////////////////////////////////////////////////////////
    // Discount mode constants
    // ////////////////////////////////////////////////////////////////////////

    int SMFP_DM_CHANGE_SUBTOTAL                 = 0;
    int SMFP_DM_NOT_CHANGE_SUBTOTAL             = 1;
    int SMFP_DM_NOT_CHANGE_SUBTOTAL_SMALLDSC    = 2;

    // PRINTER_ID parameters
    int PRINTER_ID_SERIAL       = 0;
    int PRINTER_ID_FS_SERIAL    = 1;
    
    // swapGraphicsLine constants
    int SWAP_LINE_AUTO  = 0;
    int SWAP_LINE_FALSE = 1;
    int SWAP_LINE_TRUE  = 2;
    
    // subAdjustmentOrder constants
    int ADJUSTMENT_ORDER_CORRECT = 0;
    int ADJUSTMENT_ORDER_RECEND  = 1;
}
