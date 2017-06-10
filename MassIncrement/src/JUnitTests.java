import org.junit.Assert;
import org.junit.Test;

public class JUnitTests {

	@Test
	public void IncrementLastTest() throws CellExc {
		int[] testArray = IncMass.incrementArray(new int[]{3,5,6,7});
		int[] afterTestArray = {3,5,6,8};
		Assert.assertArrayEquals(afterTestArray, testArray);	
	}
	
	@Test
	public void AllNineTest() throws CellExc{
		int[] testArray = IncMass.incrementArray(new int[]{9,9,9,9});
		int[] afterTestArray = {1,0,0,0,0};
		Assert.assertArrayEquals(afterTestArray, testArray);
	}
	
	public void OneNineTest() throws CellExc{
		int[] testArray = IncMass.incrementArray(new int[]{5,6,7,9});
		int[] afterTestArray = {5,6,8,0};
		Assert.assertArrayEquals(afterTestArray, testArray);
	}
	
	@Test
	public void FirstCellNullTest() throws CellExc{
		int[] testArray = IncMass.incrementArray(new int[]{0});
		int[] afterTestArray = {1};
		Assert.assertArrayEquals(afterTestArray, testArray);
	}
	
	@Test
	public void SomeMoreNineTest() throws CellExc{
		int[] testArray = IncMass.incrementArray(new int[]{5,6,9,9});
		int[] afterTestArray = {5,7,0,0};
		Assert.assertArrayEquals(afterTestArray, testArray);
	}
	
	@Test(expected = CellExc.class)
	public void FirstNullTestManyEl()throws CellExc{
		IncMass.incrementArray(new int[]{0,5,6,7});
	}
	
	@Test(expected = CellExc.class)
	public void ElementsFrom0To9Test()throws CellExc{
		IncMass.incrementArray(new int[]{10,5,6,7});
	}
	
	@Test(expected = CellExc.class)
	public void ElementsBelow0Test()throws CellExc{
		IncMass.incrementArray(new int[]{-10,5,6,7});
	}
	
	@Test(expected = CellExc.class)
	public void NullArrayTest()throws CellExc{
		IncMass.incrementArray(null);
	}
	
	@Test(expected = CellExc.class)
	public void EmptyArrayTest()throws CellExc{
		IncMass.incrementArray(new int[]{});
	}
	
	
}
