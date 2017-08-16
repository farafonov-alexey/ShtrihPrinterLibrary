/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shtrih.fiscalprinter.receipt;

/**
 *
 * @author V.Kravtsov
 */

import com.shtrih.fiscalprinter.SMFiscalPrinter;

public interface ReceiptItem 
{
    int RECEIPT_ITEM_SALE = 0;
    int RECEIPT_ITEM_VOID_SALE = 1;
    int RECEIPT_ITEM_REFUND = 2;
    int RECEIPT_ITEM_VOID_REFUND = 3;
    int RECEIPT_ITEM_DISCOUNT = 4;
    int RECEIPT_ITEM_CHARGE = 5;

    int getId();

    long getAmount();

    long getDiscount();

    String getDescription();

    void addDiscount(long amount);

    void print(SMFiscalPrinter printer) throws Exception;
}
