package juliandbs.gradle_junit_example;

import juliandbs.gradle_junit_example.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.NullPointerException;

@DisplayName("Product Class Test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductTest {

	@Test
	@Order(1)
	@DisplayName("Instace Not Null Using Empty Constructor Test")
	public void instanceNotNullUsingEmptyConstructorTest() {
		Product classUnderTest = new Product();
		assertNotNull(classUnderTest);
	}

	@Test
	@Order(2)
	@DisplayName("Empty Constructor Test")
	public void emptyConstructorTest() {
		Product classUnderTest = new Product();
		assertAll(
			() -> assertNotNull(classUnderTest.getId()),
			() -> assertEquals(Long.valueOf(-1), classUnderTest.getId()),
			() -> assertNotNull(classUnderTest.getName()),
			() -> assertEquals("none", classUnderTest.getName()),
			() -> assertNotNull(classUnderTest.getPrice()),
			() -> assertEquals(Float.valueOf(-1), classUnderTest.getPrice()),
			() -> assertFalse(classUnderTest.isValid()),
			() -> assertTrue(classUnderTest.compareTo(new Product()) == 0),
			() -> assertTrue(classUnderTest.equals(new Product())),
			() -> assertTrue(classUnderTest.hashCode() == -1078743240),
			() -> assertTrue(classUnderTest.toString().equals("-1 none -1.0"))
		);
	}

	@Test
	@Order(3)
	@DisplayName("Instance Throws NullPointerException Using Constructor With Parameters")
	public void instanceThrowsNullPointerExceptionTest() {
		assertThrowsExactly(NullPointerException.class, () -> {
			Product classUnderTest = new Product(null, "none", Float.valueOf(7.99f));
		});
	}

	@Test
	@Order(4)
	@DisplayName("Instance Does Not Throw Any Kind Of Exception Using Constructor With Parameters")
	public void instanceDoesNotThrowsNullPointerException() {
		assertDoesNotThrow( () -> {
			Product classUnderTest = new Product(Long.valueOf(123456), "Book", Float.valueOf(7.99f));
		});
	}

	@Test
	@Order(5)
	@DisplayName("Instace Not Null Using Constructor With Parameters")
	public void instanceNotNullUsingConstructorWithParametersTest() {
		Product classUnderTest = new Product(Long.valueOf(123456789), "Book", Float.valueOf(7.99f));
		assertNotNull(classUnderTest);
	}

	@Test
	@Order(6)
	@DisplayName("Constructor With Parameters Test")
	public void constructorWithParametersTest() {
		Product classUnderTest = new Product(Long.valueOf(123456), "Book", Float.valueOf(7.99f));
		assertAll(
			() -> assertNotNull(classUnderTest.getId()),
			() -> assertEquals(Long.valueOf(123456), classUnderTest.getId()),
			() -> assertNotNull(classUnderTest.getName()),
			() -> assertEquals("Book", classUnderTest.getName()),
			() -> assertNotNull(classUnderTest.getPrice()),
			() -> assertEquals(Float.valueOf(7.99f), classUnderTest.getPrice()),
			() -> assertTrue(classUnderTest.isValid()),
			() -> assertTrue(classUnderTest.compareTo(new Product(Long.valueOf(123456), "Book", Float.valueOf(7.99f))) == 0),
			() -> assertTrue(classUnderTest.equals(new Product(Long.valueOf(123456), "Book", Float.valueOf(7.99f)))),
			() -> assertTrue(classUnderTest.hashCode() == 1092697949),
			() -> assertTrue(classUnderTest.toString().equals("123456 Book 7.99"))
		);
	}
}
