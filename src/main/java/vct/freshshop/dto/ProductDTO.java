package vct.freshshop.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vct.freshshop.entity.Category;

@Getter 
@Setter 
@NoArgsConstructor
public class ProductDTO {

	private int id;

	private String name;
	
	private String description;
	
	private String image;
	
	private double price;
	
	private boolean isActive;
	
	
}
