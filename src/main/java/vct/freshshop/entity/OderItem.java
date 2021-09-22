package vct.freshshop.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vct.freshshop.validation.in.CheckCategoryNameExist;
import vct.freshshop.validation.in.CheckOderExist;

@Entity
@Getter 
@Setter 
@NoArgsConstructor
@AllArgsConstructor
public class OderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int quantity;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
	@NotNull
	@CheckCategoryNameExist
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "oder_id", nullable = false)
	@NotNull
	@CheckOderExist
	private Oder oder;
	
	public OderItem(Product p) {
		product = p;
        quantity = 1;
	}
	public void incrementQuantity() {
        quantity++;
    }

    public void decrementQuantity() {
        quantity--;
    }
    
    public double getItemTotal() {
    	return roundOff(quantity*product.getPrice());
    }
    
    private double roundOff(double x) {
		long val = Math.round(x * 100); // cents
		return val / 100.0;
	}
}
