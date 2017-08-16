package test.librarywrapper.data;

import java.util.Date;

/**
 * Created by mamba on 15.08.2017.
 */

class InformationCheckData {
    private final String docNumber;
    private final String checkNumber;
    private final Date dateAndTime;
    private final String inn;
    private final String pd;

    private InformationCheckData(Builder builder) {
        this.docNumber = builder.docNumber;
        this.checkNumber = builder.checkNumber;
        this.dateAndTime = builder.dateAndTime;
        this.inn = builder.inn;
        this.pd = builder.pd;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public String getCheckNumber() {
        return checkNumber;
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
        private String checkNumber;
        private Date dateAndTime;
        private String inn;
        private String pd;

        public Builder setDocNumber(String docNumber) {
            this.docNumber = docNumber;
            return this;
        }

        public Builder setCheckNumber(String checkNumber) {
            this.checkNumber = checkNumber;
            return this;
        }

        public Builder setDateAndTime(Date dateAndTime) {
            this.dateAndTime = dateAndTime;
            return this;
        }

        public Builder setInn(String inn) {
            this.inn = inn;
            return this;
        }

        public Builder setPd(String pd) {
            this.pd = pd;
            return this;
        }

        public InformationCheckData build() {
            return new InformationCheckData(this);
        }
    }
}
