package test.librarywrapper.strategy;

import com.shtrih.fiscalprinter.ShtrihFiscalPrinter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import test.librarywrapper.data.ShtrihPrinterInputData;
import test.librarywrapper.enums.TypePrint;

/**
 * Created by mamba on 12.08.2017.
 */

public class InstructionFactory {
    public static Instruction getInstruction(@NotNull ShtrihFiscalPrinter printer, @Nullable ShtrihPrinterInputData inputData, TypePrint typePrint){
        switch(typePrint){
            case FISCAL_TRANSACTION:{
                return new TransactionInstruction(printer, inputData, typePrint);
            }
            case REPEAT_TRANSACTION:{
                return new RepeatTransactionInstruction(printer, typePrint);
            }
            case X_REPORT:{
                return new XReportInstruction(printer, typePrint);
            }
            case Z_REPORT:{
                return new ZReportInstruction(printer, typePrint);
            }
            default:
                return null;
        }
    }
}
