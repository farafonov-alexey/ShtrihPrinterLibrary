package test.librarywrapper.data;

import java.util.Date;

import test.librarywrapper.constants.DefaultReceiptInformation;

/**
 * Created by mamba on 10.08.2017.
 */

public class ReceiptInformation {
    private final String docNumber;
    private final String receiptNumber;
    private final Date dateAndTime;
    private final String inn;
    private final String pd;

    private ReceiptInformation(Builder builder) {
        this.docNumber = (builder!=null)&&(builder.docNumber!=null) ? builder.docNumber : DefaultReceiptInformation.DOCUMENT_NUMBER;
        this.receiptNumber = (builder!=null)&&(builder.receiptNumber!=null) ? builder.receiptNumber : DefaultReceiptInformation.RECEIPT_NUMBER;
        this.dateAndTime = (builder!=null)&&(builder.dateAndTime!=null) ? builder.dateAndTime : (new Date(DefaultReceiptInformation.DATE));
        this.inn = (builder!=null)&&(builder.inn!=null) ? builder.inn : DefaultReceiptInformation.INN;
        this.pd = (builder!=null)&&(builder.pd!=null) ? builder.pd : DefaultReceiptInformation.PD;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public String getInn() {
        return inn;
    }

    public String getPd() {
        return pd;
    }

    public static class Builder {

        private String docNumber;
        private String receiptNumber;
        private Date dateAndTime;
        private String inn;
        private String pd;

        public Builder setDocNumber(String docNumber) {
            this.docNumber = (docNumber!=null)&&(!docNumber.isEmpty())? docNumber : DefaultReceiptInformation.DOCUMENT_NUMBER;
            return this;
        }

        public Builder setReceiptNumber(String receiptNumber) {
            this.receiptNumber = (receiptNumber!=null)&&(!receiptNumber.isEmpty())? receiptNumber : DefaultReceiptInformation.RECEIPT_NUMBER;
            return this;
        }

        public Builder setDateAndTime(Date dateAndTime) {
            this.dateAndTime = dateAndTime != null ? dateAndTime : (new Date(DefaultReceiptInformation.DATE));
            return this;
        }

        public Builder setInn(String inn) {
            this.inn = (inn!=null)&&(!inn.isEmpty()) ? inn : DefaultReceiptInformation.INN;
            return this;
        }

        public Builder setPd(String pd) {
            this.pd = (pd!=null)&&(!pd.isEmpty()) ? pd : DefaultReceiptInformation.PD;
            return this;
        }

        public ReceiptInformation build() {
            return new ReceiptInformation(this);
        }
    }
}
