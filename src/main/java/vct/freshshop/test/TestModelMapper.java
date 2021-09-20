package vct.freshshop.test;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import vct.freshshop.entity.Product;

public class TestModelMapper {

	
	
	
	public void mapper(Product product, Product newProduct) {// p is new product
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.map(newProduct, product);
		System.out.println(product.toString());
		System.out.println(newProduct.toString());
	}
	
	public static void main(String[] args) {
		TestModelMapper t = new TestModelMapper();
		Product p1 = new Product();
		p1.setName("a");
		p1.setImage("a1");
		p1.setId(1);
		p1.setDescription("a2");
		p1.setPrice(10);
		Product p2 = new Product();
		p2.setName("b");
		p2.setImage("b1");
		p2.setId(2);
		p2.setDescription("b2");
		p2.setPrice(12);
		t.mapper(p1, p2);
	}
}
