package test.librarywrapper.strategy;

import com.shtrih.fiscalprinter.ShtrihFiscalPrinter;

import jpos.JposException;
import test.librarywrapper.enums.TypePrint;

/**
 * Created by mamba on 12.08.2017.
 */

public class ZReportInstruction extends Instruction {

    public ZReportInstruction(ShtrihFiscalPrinter printer, TypePrint typePrint) {
        super(printer, typePrint);
    }

    @Override
    public void print() throws JposException {
        super.print();
        printer.printZReport();
    }
}
