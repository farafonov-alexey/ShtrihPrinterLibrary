package test.librarywrapper.strategy;

import com.shtrih.fiscalprinter.ShtrihFiscalPrinter;

import java.util.List;

import jpos.JposException;
import test.librarywrapper.constants.ReceiptTemplateText;
import test.librarywrapper.data.GoodsData;
import test.librarywrapper.data.ShtrihPrinterInputData;
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
        printer.setFiscalReceiptType(jpos.FiscalPrinterConst.FPTR_RT_SALES);
        printer.beginFiscalReceipt(false);
        printer.setHeaderLine(1, "", false);
        printer.setHeaderLine(2, "", false);
        printer.setHeaderLine(3, "", false);
        for (GoodsData item: goodsDataList) {
            long price = (long) (PRICE_MULTIPLIER*item.getPrice());
            int quantity = QUANTITY_MULTIPLIER*item.getQuantity();
            payment += price;
            String itemName = item.getName();
            printer.printRecItem(itemName, 0, quantity, 0, price, "");
        }
        printer.printRecTotal(payment, payment, ReceiptTemplateText.RESULT);
        printer.endFiscalReceipt(false);
    }
}
//TODO:
//некоректное отображение количества
