package bank.p0redux.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class User {
	@Column(name="username",nullable=false,unique=true)
	private String username;
	@Column(name="password",nullable=false)
	private String password;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="userid")
	private int userId;

	@OneToOne(mappedBy="myUser")
//	@JoinColumn(name="myCustomer")
	@JsonManagedReference(value="myCustomer")
	private Customer myCustomer;
	
	@OneToOne(mappedBy="myUser")
//	@JoinColumn(name="myEmployee")
	@JsonManagedReference(value="myEmployee")
	private Employee myEmployee;
//	

	
	@Override
	public String toString() {
		return "User ID: " + userId + " username: " + username + " password: " + password + "\n";
	}

	

}
