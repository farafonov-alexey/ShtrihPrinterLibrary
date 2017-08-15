package test.librarywrapper.strategy;

import com.shtrih.fiscalprinter.ShtrihFiscalPrinter;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import test.librarywrapper.constants.PrintType;
import test.librarywrapper.data.ShtrihPrinterInputData;

/**
 * Created by mamba on 12.08.2017.
 */

public class InstructionFactory {
    public static Instruction getInstruction(@NotNull ShtrihFiscalPrinter printer, @Nullable ShtrihPrinterInputData inputData, int printType){
        switch(printType){
            case PrintType.FISCAL_TRANSACTION:{
                return new TransactionInstruction(printer, inputData, printType);
            }
            case PrintType.REPEAT_TRANSACTION:{
                return new RepeatTransactionInstruction(printer, printType);
            }
            case PrintType.X_REPORT:
            case PrintType.Z_REPORT:{
                return new ZReportInstruction(printer, printType);
            }
            default:
                return null;
        }
    }
}
