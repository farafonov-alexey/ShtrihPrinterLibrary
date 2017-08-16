package test.librarywrapper.enums;

/**
 * Created by mamba on 15.08.2017.
 */

public enum PrinterOperationType {
    PAYMENT(1), REFUND(2), REVERSAL(2);

    private int codeType;

    PrinterOperationType(int codeType) {
        this.codeType = codeType;
    }

    public int getCodeType() {
        return codeType;
    }

    public static PrinterOperationType getEnumCode(String enumCode) {
        PrinterOperationType printerOperationType = PAYMENT;
        for(PrinterOperationType element : values())
            if(enumCode.equals(element.name()))
                printerOperationType = element;
        return printerOperationType;
    }
}
