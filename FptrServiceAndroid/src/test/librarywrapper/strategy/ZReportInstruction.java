package test.librarywrapper.strategy;

import com.shtrih.fiscalprinter.ShtrihFiscalPrinter;

import jpos.JposException;

/**
 * Created by mamba on 12.08.2017.
 */

public class ZReportInstruction extends Instruction {

    public ZReportInstruction(ShtrihFiscalPrinter printer, int printType) {
        super(printer, printType);
    }

    @Override
    public void print() throws JposException {
        super.print();
        printer.printZReport();
    }
}
