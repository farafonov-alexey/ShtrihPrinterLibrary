package test.librarywrapper;

import android.content.Context;

import com.shtrih.fiscalprinter.ShtrihFiscalPrinter;

import org.jetbrains.annotations.Nullable;

import java.lang.ref.WeakReference;

import test.librarywrapper.data.ShtrihPrinterInputData;
import test.librarywrapper.strategy.Instruction;
import test.librarywrapper.strategy.InstructionFactory;

/**
 * Created by mamba on 14.08.2017.
 */

public class ShtrihPrinterController {
    private ShtrihPrinterCallbackReceiver callbackReceiver;
    private WeakReference<Context> weakContext;
    private ShtrihFiscalPrinter printer;

    public ShtrihPrinterController(ShtrihPrinterCallbackReceiver callbackReceiver, ShtrihFiscalPrinter printer) {
        this.callbackReceiver = callbackReceiver;
        this.printer = printer;
    }

    public void print(int printType, @Nullable ShtrihPrinterInputData inputData){
        Instruction instruction = InstructionFactory.getInstruction(printer, inputData, printType);
        PrintingAsyncTask asyncTask = new PrintingAsyncTask(instruction, callbackReceiver);
        asyncTask.execute();
    }
}
