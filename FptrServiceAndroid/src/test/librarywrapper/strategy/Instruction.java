package test.librarywrapper.strategy;

import com.shtrih.fiscalprinter.ShtrihFiscalPrinter;

import jpos.JposException;
import test.librarywrapper.enums.TypePrint;

/**
 * Created by mamba on 12.08.2017.
 */

public abstract class Instruction {
    protected static final int PRICE_MULTIPLIER = 100;
    protected static final int QUANTITY_MULTIPLIER = 100;
    protected ShtrihFiscalPrinter printer;
    protected TypePrint typePrint;

    public Instruction(ShtrihFiscalPrinter printer, TypePrint typePrint) {
        this.printer = printer;
        this.typePrint = typePrint;
    }

    public void print() throws JposException {
    }

    public TypePrint getPrintType() {
        return typePrint;
    }
}
