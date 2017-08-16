package test.librarywrapper.data;

import java.util.ArrayList;
import java.util.List;

import test.librarywrapper.enums.PrinterOperationType;

/**
 * Created by mamba on 10.08.2017.
 */

public class ShtrihPrinterInputData {
    private PrinterOperationType operationType;
    private List<GoodsData> goodsData;
    private boolean cash;
    private ReceiptInformation receiptInformation;

    private ShtrihPrinterInputData() {
    }

    public ShtrihPrinterInputData(PrinterOperationType operationType, List<GoodsData> goodsData, boolean cash, ReceiptInformation receiptInformation) {
        this.operationType = operationType;
        this.goodsData = (goodsData==null) ? new ArrayList<GoodsData>() : goodsData;
        this.cash = cash;
        this.receiptInformation = (receiptInformation!=null) ? receiptInformation : new ReceiptInformation.Builder().build();
    }

    public PrinterOperationType getOperationType() {
        return operationType;
    }

    public List<GoodsData> getGoodsData() {
        return goodsData;
    }

    public boolean isCash() {
        return cash;
    }

    public ReceiptInformation getReceiptInformation() {
        return receiptInformation;
    }

    public void setOperationType(PrinterOperationType operationType) {
        this.operationType = operationType;
    }

    public void setGoodsData(List<GoodsData> goodsData) {
        this.goodsData = (goodsData==null) ? new ArrayList<GoodsData>() : goodsData;
    }

    public void setCash(boolean cash) {
        this.cash = cash;
    }

    public void setReceiptInformation(ReceiptInformation receiptInformation) {
        this.receiptInformation = (receiptInformation!=null) ? receiptInformation : new ReceiptInformation.Builder().build();
    }
}
