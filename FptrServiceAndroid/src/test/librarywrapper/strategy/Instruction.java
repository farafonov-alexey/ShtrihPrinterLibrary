package test.librarywrapper.strategy;

import com.shtrih.fiscalprinter.ShtrihFiscalPrinter;

import jpos.JposException;

/**
 * Created by mamba on 12.08.2017.
 */

public abstract class Instruction {
    protected static final int PRICE_MULTIPLIER = 100;
    protected static final int QUANTITY_MULTIPLIER = 100;
    protected ShtrihFiscalPrinter printer;
    protected int printType;

    public Instruction(ShtrihFiscalPrinter printer, int printType) {
        this.printer = printer;
        this.printType = printType;
    }

    public void print() throws JposException {
    }

    public int getPrintType() {
        return printType;
    }
}
