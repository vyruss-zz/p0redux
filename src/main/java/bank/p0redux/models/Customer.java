package bank.p0redux.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customers")
public class Customer {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="customerid")
	private int customerId;
	@Column(name="firstname", nullable=false)
	private String firstName;
	@Column(name="lastname",nullable=false)
	private String lastName;
	@OneToOne
	@JsonBackReference(value="myCustomer")
	@JoinColumn(name="userid")
	private User myUser;
	@OneToMany(mappedBy="myCustomer")
//	@JoinColumn(name="accounts")
	@JsonManagedReference(value="myAccount")
	private List<Account> accounts;
	
	
	public String toString() {
		return "Name: " + firstName + " " + lastName + " User ID: ";// + myUser.getUserId();
	}
	

}
