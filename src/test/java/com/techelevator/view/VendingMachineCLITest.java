package com.techelevator.view;
import com.techelevator.view.VendingMachineCLI;
import com.techelevator.view.VendingMachine;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class VendingMachineCLITest {

    @Test
    public void Test_Happy_Path_For_CLI_Get_Change() {
        //arrange
        VendingMachine sut = new VendingMachine();
        String j = "A1";
        String b = "10.00";
        sut.feedMoney(b);
        sut.makePurchase(j);
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("Dimes",2);
        map.put("Quarters",27);
       // Assert.assertEquals("A1", sut.makePurchase(j).getSlotIdentifier());
        Assert.assertEquals(map, sut.getChange());
    }

    @Test
    public void Test_Happy_Path_For_Handle_Purchase() {
        //arrange
        VendingMachine sut = new VendingMachine();
        String j = "A1";
        String b = "10.00";
        sut.feedMoney(b);
        sut.makePurchase(j);
        BigDecimal x = BigDecimal.valueOf(6.95);
        Assert.assertEquals(x, sut.getBalance());

    }


}
