

import com.techelevator.view.VendingMachine;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class VendingMachineTest {

	@Test
	public void Test_Happy_Path_For_Make_Purchase() {
		//arrange
		VendingMachine sut = new VendingMachine();
		String j = "A1";
		String b = "10.00";
		sut.feedMoney(b);
		sut.makePurchase(j);

		Assert.assertEquals("A1", sut.makePurchase(j).getSlotIdentifier());

	}

	@Test
	public void Test_Happy_Path_For_Balance() {
		//arrange
		VendingMachine sut = new VendingMachine();
		String b = "10.00";
		sut.feedMoney(b);
		sut.makePurchase("A1");
		sut.makePurchase("A1");
		sut.makePurchase("A1");
		BigDecimal x = BigDecimal.valueOf(0.85);
		Assert.assertEquals(x, sut.getBalance());

	}









	}
