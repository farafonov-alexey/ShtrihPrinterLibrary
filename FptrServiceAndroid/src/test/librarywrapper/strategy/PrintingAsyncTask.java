package test.librarywrapper.strategy;

import android.os.AsyncTask;

import jpos.JposException;
import test.librarywrapper.ShtrihPrinterCallbackReceiver;

/**
 * Created by mamba on 14.08.2017.
 */

public class PrintingAsyncTask extends AsyncTask<Void, JposException, Boolean> {
    private Instruction instruction;
    private ShtrihPrinterCallbackReceiver callbackReceiver;

    public PrintingAsyncTask(Instruction instruction, ShtrihPrinterCallbackReceiver callbackReceiver) {
        this.instruction = instruction;
        this.callbackReceiver = callbackReceiver;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        try {
            instruction.print();
        } catch (JposException e) {
            publishProgress(e);
            return false;
        }
        return true;
    }

    @Override
    protected void onProgressUpdate(JposException... values) {
        if(values == null || values.length == 0)
            return;
        callbackReceiver.onErrorPrinting(instruction.getPrintType(), values[0].getMessage());
    }

    @Override
    protected void onPostExecute(Boolean complete) {
        if(complete){
            callbackReceiver.onCompletePrinting(instruction.getPrintType());
        }
    }
}
