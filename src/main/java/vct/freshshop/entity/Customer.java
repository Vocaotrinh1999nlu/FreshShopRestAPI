package vct.freshshop.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.persistence.JoinColumn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter 
@Setter 
@NoArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "Customer name is not empty")
	@NotNull(message = "Customer name is not null")
	private String name;
	
	@NotEmpty(message = "Customer address is not empty")
	@NotNull(message = "Customer address is not null")
	private String address;
	
	@NotEmpty(message = "Customer phone number is not empty")
	private String phone;
	 
	private boolean isActive;
	
	private String userName;
	
	private String password;
	
	private String email;
	
	private int yearOfBirth;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	  @JoinTable(name = "customer_role", 
	    joinColumns = { @JoinColumn(name = "customer_id") }, 
	    inverseJoinColumns = {@JoinColumn(name = "role_id") })
	private List<Role> roles;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private List<Oder> oders;
	

}
