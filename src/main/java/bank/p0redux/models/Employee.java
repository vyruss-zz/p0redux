package bank.p0redux.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	@Column(name="employeeid")
	private int id;
	
	@Column(name="firstname", nullable=false, unique=true)
	private String firstname;
	@Column(name="lastname", nullable=false)
	private String lastname;
	@Column(name="isadmin")
	private boolean isAdmin;
	@OneToOne
	@JsonBackReference(value="myEmployee")
	@JoinColumn(name="userid")
	private User myUser;
	
}
