package tn.poste.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "phoneNbr")
	private int phoneNbr;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "image")
	private String image;
	@Column(name = "sanitary_pass")
	private String sanitary_pass;
	@Column(name = "profession")
	private String profession;
	@Column(name = "domain")
	private String domain;
	@Column(name = "adress")
	private String adress;
	@Column(name = "dateNaiss")
	@Temporal(TemporalType.DATE)
	private Date dateNaiss;
	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private Role role;
	@Column(name = "blocked")
	private Boolean blocked;

	@JsonManagedReference
	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Bureau> Bureau = new ArrayList<>();
	@JsonManagedReference
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="user")
	private Set<HistoriqueDeReparation> HistoriqueDeReparation;
	
	@JsonManagedReference
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Equipements> Equipements ;
	
}
