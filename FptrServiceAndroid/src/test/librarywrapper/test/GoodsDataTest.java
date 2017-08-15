package test.librarywrapper.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import test.librarywrapper.data.GoodsData;
import test.librarywrapper.constants.ReceiptTemplateText;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by mamba on 10.08.2017.
 */

@RunWith(JUnit4.class)
public class GoodsDataTest {

    @Test
    public void testClassConstructor(){
        GoodsData goodsData = new GoodsData(0, null, -10);
        assertEquals((double)ReceiptTemplateText.QUANTITY, goodsData.getPrice());
        assertEquals(ReceiptTemplateText.SERVICE, goodsData.getName());
        assertEquals(ReceiptTemplateText.QUANTITY, goodsData.getQuantity());

        GoodsData goodsData2 = new GoodsData(-10, "", 1);
        assertEquals((double)ReceiptTemplateText.QUANTITY, goodsData2.getPrice());
        assertEquals(ReceiptTemplateText.SERVICE, goodsData2.getName());
        assertEquals(1, goodsData2.getQuantity());

        GoodsData goodsData3 = new GoodsData(1_000_000_000, "LOL", 1_000_000_000);
        assertEquals((double)ReceiptTemplateText.QUANTITY, goodsData3.getPrice());
        assertEquals("LOL", goodsData3.getName());
        assertEquals(ReceiptTemplateText.QUANTITY, goodsData3.getQuantity());
    }
}
