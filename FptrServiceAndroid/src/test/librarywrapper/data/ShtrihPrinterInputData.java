package test.librarywrapper.data;

import java.util.ArrayList;
import java.util.List;

import test.librarywrapper.constants.OperationType;

/**
 * Created by mamba on 10.08.2017.
 */

public class ShtrihPrinterInputData {
    private int operationType;
    private List<GoodsData> goodsData;
    private boolean cash;
    private ReceiptInformation receiptInformation;

    private ShtrihPrinterInputData() {
    }

    public ShtrihPrinterInputData(int operationType, List<GoodsData> goodsData, boolean cash, ReceiptInformation receiptInformation) {
        this.operationType = (operationType>3)||(operationType<1) ? OperationType.PAYMENT : operationType;
        this.goodsData = (goodsData==null) ? new ArrayList<GoodsData>() : goodsData;
        this.cash = cash;
        this.receiptInformation = (receiptInformation!=null) ? receiptInformation : new ReceiptInformation.Builder().build();
    }

    public int getOperationType() {
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

    public void setOperationType(int operationType) {
        this.operationType = (operationType>3)||(operationType<1) ? OperationType.PAYMENT : operationType;
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
