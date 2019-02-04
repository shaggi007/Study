import static org.junit.Assert.assertEquals;

public class Addition1 {

	static int sum(int num1, int num2) {
		return (num1 + num2);
	}
	public void Sum() {

		assertEquals(2, Addition1.sum(1, 1));
	}
}


