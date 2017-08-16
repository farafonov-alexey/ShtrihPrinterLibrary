package test.librarywrapper.data;

/**
 * Created by mamba on 15.08.2017.
 */

public class FiscalPrinterResultData {
    private InformationCheckData informationCheckData;
    private boolean cash;

    public InformationCheckData getInformationCheckData() {
        return informationCheckData;
    }

    public boolean isCash() {
        return cash;
    }

    public void setInformationCheckData(InformationCheckData informationCheckData) {
        this.informationCheckData = informationCheckData;
    }

    public void setCash(boolean cash) {
        this.cash = cash;
    }
}
