package vct.freshshop.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
public class CategoryDTO {

	private int id;
	
	private String title;
	
	private boolean isActive;
	
	private List<ProductDTOV2> products;
}
