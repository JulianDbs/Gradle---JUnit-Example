package juliandbs.gradle_junit_example;

import java.lang.Comparable;
import java.lang.NullPointerException;

public class Product implements Comparable<Product> {
	private final Long id;
	private final String name;
	private final Float price;

	public Product() {
		id = Long.valueOf(-1);
		name = "none";
		price = Float.valueOf(-1);
	}


	public Product(
		Long id,
		String name,
		Float price
	) throws NullPointerException {
		if (id == null || name == null || price == null)
			throw new NullPointerException();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Long getId() {return id;}

	public String getName() {return name;}

	public Float getPrice() {return price;}

	public boolean isValid() {
		return !id.equals(Long.valueOf(-1)) && !name.equals("none") && !price.equals(Float.valueOf(-1));
	}

	@Override
	public int compareTo(Product product) throws NullPointerException {
		if (product == null)
			throw new NullPointerException();
		return product.getId().compareTo(id) +
			product.getName().compareTo(name) +
			product.getPrice().compareTo(price);
	}

	@Override
	public boolean equals(Object object) throws NullPointerException {
		boolean result = false;
		if (object == null)
			throw new NullPointerException();
		if (object instanceof Product) {
			Product product = (Product) object;
			result = product.getId().equals(id) &&
				product.getName().equals(name) &&
				product.getPrice().equals(price);
		}
		return result;
	}

	@Override
	public int hashCode() {
		return id.hashCode() + name.hashCode() + price.hashCode();
	}

	@Override
	public String toString() {
		return id.toString() + " " + name + " " + price.toString();
	}
}
