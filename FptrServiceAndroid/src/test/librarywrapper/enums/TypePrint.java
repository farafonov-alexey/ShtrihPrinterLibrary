package test.librarywrapper.enums;

/**
 * Created by mamba on 15.08.2017.
 */

public enum TypePrint {
    X_REPORT(2), Z_REPORT(1), FISCAL_TRANSACTION(0), REPEAT_TRANSACTION(3);

    private int codeType;

    TypePrint(int codeType) {
        this.codeType = codeType;
    }

    public int getCodeType() {
        return codeType;
    }
}
