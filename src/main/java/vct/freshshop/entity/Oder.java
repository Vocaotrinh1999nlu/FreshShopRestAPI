package vct.freshshop.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vct.freshshop.validation.in.CheckCustomerExist;

@Entity
@Getter 
@Setter 
@NoArgsConstructor
public class Oder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(mappedBy = "oder", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private List<OderItem> oderItems;
	
	private LocalDateTime oderDate;
	
	private boolean isDelivered;
	
	private LocalDateTime deliverdTime;
	
	private boolean isPay;
	
	private LocalDateTime payTime;
	
	private double total;
	
	private String shipAdress;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
	@NotNull
	//@CheckCustomerExist
	private Customer customer;

}
