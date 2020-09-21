package tn.JCITAZ.spring.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
//import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
//import javax.validation.constraints.Size;


@Entity
@Table(	name = "users", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
public class AppUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
 	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;
	
	@NotBlank
	@Size(max = 120)
	private String Role ;
	
	@NotBlank
	@Size(max = 120)
	private Date date_naissance ;

	@NotBlank
	@Size(max = 120)
	private String lieu_naissance ;
	
	@NotBlank
	@Size(max = 120)
	private Number num_tel ;
	
	@NotBlank
	@Size(max = 120)
	private String Description ;

	
//	@OneToMany(mappedBy="client_proprietaire_colis", cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
//	private Set<colis> coliss;
//	
//	
//	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();



	public Long getId() {
		return id;
	}

	public AppUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public AppUser(Long id, @NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, @NotBlank @Size(max = 120) String role,
			@NotBlank @Size(max = 120) Date date_naissance, @NotBlank @Size(max = 120) String lieu_naissance,
			@NotBlank @Size(max = 120) Number num_tel, @NotBlank @Size(max = 120) String description,
			Set<tn.JCITAZ.spring.entities.Role> roles) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		Role = role;
		this.date_naissance = date_naissance;
		this.lieu_naissance = lieu_naissance;
		this.num_tel = num_tel;
		Description = description;
		this.roles = roles;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}
	
	

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Date getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}

	public String getLieu_naissance() {
		return lieu_naissance;
	}

	public void setLieu_naissance(String lieu_naissance) {
		this.lieu_naissance = lieu_naissance;
	}

	public Number getNum_tel() {
		return num_tel;
	}

	public void setNum_tel(Number num_tel) {
		this.num_tel = num_tel;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	

	
}
