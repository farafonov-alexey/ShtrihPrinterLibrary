package test.librarywrapper.strategy;

import com.shtrih.fiscalprinter.ShtrihFiscalPrinter;
import com.shtrih.jpos.fiscalprinter.SmFptrConst;

import java.util.List;

import jpos.FiscalPrinterConst;
import jpos.JposException;
import test.librarywrapper.constants.ReceiptTemplateText;
import test.librarywrapper.data.GoodsData;
import test.librarywrapper.data.ShtrihPrinterInputData;
import test.librarywrapper.enums.PrinterOperationType;
import test.librarywrapper.enums.TypePrint;

/**
 * Created by mamba on 12.08.2017.
 */

public class TransactionInstruction extends Instruction {
    private ShtrihPrinterInputData inputData;

    public TransactionInstruction(ShtrihFiscalPrinter printer, ShtrihPrinterInputData inputData, TypePrint typePrint) {
        super(printer, typePrint);
        this.inputData = inputData;
    }

    public void print() throws JposException {
        super.print();
        if (printer == null) {
            return;
        }
        long payment = 0;
        List<GoodsData> goodsDataList = inputData.getGoodsData();
        printer.resetPrinter();
        if(inputData.getOperationType().equals(PrinterOperationType.REFUND)){
            printer.setFiscalReceiptType(SmFptrConst.SMFPTR_RT_RETSALE);
        } else{
            printer.setFiscalReceiptType(SmFptrConst.SMFPTR_RT_SALE);
        }
        printer.beginFiscalReceipt(true);
        printer.setHeaderLine(1, "", false);
        printer.setHeaderLine(2, "", false);
        printer.setHeaderLine(3, "", false);
        int overallQuantity = 0;
        for (GoodsData item: goodsDataList) {
            long price = (long) (PRICE_MULTIPLIER*item.getPrice());
            int quantity = QUANTITY_MULTIPLIER*item.getQuantity();
            payment += price;
            overallQuantity +=quantity;
            String itemName = item.getName();
            printer.printRecItem(itemName, 0, quantity, 0, price, "");
        }
        printer.printRecSubtotal(0);
        if(inputData.isCash())
            printer.printRecTotal(0, overallQuantity, "2"); // 2 - нал
        else
            printer.printRecTotal(0, overallQuantity, "1"); // 1 - безнал
        printer.endFiscalReceipt(false);
    }
}

