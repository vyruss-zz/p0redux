package bank.p0redux.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="accountid")
	private int accountId;
	
	@ManyToOne
	@JoinColumn(name="customerid")
	@JsonBackReference(value="myAccount")
	private Customer myCustomer;

	@Column(name="balance")
	private double balance;

	public String toString() {
		return "Account ID: " + accountId + /*" Customer ID: " + myCustomer.getCustomerId() +*/ " Balance: $" + balance;
	}


	
}
