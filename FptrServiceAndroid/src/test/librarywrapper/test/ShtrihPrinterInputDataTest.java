package test.librarywrapper.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import test.librarywrapper.constants.OperationType;
import test.librarywrapper.data.GoodsData;
import test.librarywrapper.data.ReceiptInformation;
import test.librarywrapper.data.ShtrihPrinterInputData;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by mamba on 10.08.2017.
 */

@RunWith(JUnit4.class)
public class ShtrihPrinterInputDataTest {
    private ShtrihPrinterInputData testData1, testData2;
    private List<GoodsData> goodsDataList;
    private ReceiptInformation information;

    @Before
    public void beforeTest(){
        GoodsData data1 = new GoodsData(15D, "Hamburger", 2);
        GoodsData data2 = new GoodsData(10D, "Cheeseburger", 3);
        GoodsData data3 = new GoodsData(0D, "", 10);
        goodsDataList = new ArrayList<>();
        goodsDataList.add(data1);
        goodsDataList.add(data2);
        goodsDataList.add(data3);
        information = new ReceiptInformation.Builder().build();
        testData1 = new ShtrihPrinterInputData(OperationType.REVERSAL,
                goodsDataList,
                false,
                information);
        testData2 = new ShtrihPrinterInputData(20,
                null,
                true,
                information);
    }

    @Test
    public void initializationTest(){
        Assert.assertEquals(OperationType.REVERSAL, testData1.getOperationType());
        Assert.assertEquals(goodsDataList, testData1.getGoodsData());
        Assert.assertEquals(false, testData1.isCash());
        Assert.assertEquals(information, testData1.getReceiptInformation());

        Assert.assertEquals(OperationType.PAYMENT, testData2.getOperationType());
        Assert.assertNotNull(testData2.getGoodsData());
        Assert.assertEquals(true, testData2.isCash());
        Assert.assertEquals(information, testData2.getReceiptInformation());
    }
}
