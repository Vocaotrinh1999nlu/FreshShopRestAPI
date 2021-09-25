package vct.freshshop.dto;

import lombok.Data;

@Data
public class ProductDTOV2 {

	private int id;

	private String name;
	
	private String description;
	
	private String image;
	
	private double price;
	
	private boolean isActive;

	public ProductDTOV2(int id, String name, String description, String image, double price, boolean isActive) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.image = image;
		this.price = price;
		this.isActive = isActive;
	}
	
}
