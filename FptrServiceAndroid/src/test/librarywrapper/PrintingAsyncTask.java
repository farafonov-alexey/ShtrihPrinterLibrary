package test.librarywrapper;

import android.os.AsyncTask;

import jpos.JposException;
import test.librarywrapper.strategy.Instruction;

/**
 * Created by mamba on 14.08.2017.
 */

public class PrintingAsyncTask extends AsyncTask<Void, Exception, Boolean> {
    private Instruction instruction;
    private ShtrihPrinterCallbackReceiver callbackReceiver;

    public PrintingAsyncTask(Instruction instruction, ShtrihPrinterCallbackReceiver callbackReceiver) {
        this.instruction = instruction;
        this.callbackReceiver = callbackReceiver;
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        try {
            instruction.print();
        } catch (JposException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    protected void onProgressUpdate(Exception... values) {
        if(values == null || values.length == 0)
            return;
        else if(values[0] instanceof JposException){
            JposException ex = (JposException) values[0];
            int errorCode = ex.getErrorCode();
            callbackReceiver.onErrorPrinting(instruction.getPrintType(), values[0].getMessage());
        }
    }

    @Override
    protected void onPostExecute(Boolean complete) {
        if(complete){
            callbackReceiver.onCompletePrinting(instruction.getPrintType());
        }
    }
}
