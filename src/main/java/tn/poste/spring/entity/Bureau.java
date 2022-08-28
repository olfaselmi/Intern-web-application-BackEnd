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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
@Table( name = "Bureau")
public class Bureau implements Serializable {

	@Id
	
	


	@Column(name="CodePostale")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long CodePostale;
	@Column(name="NomAgence")
	private String NomAgence;
	@Column(name="Adresse")
	private String Adresse;
	@Column(name="PositionGPS")
	private String PositionGPS;
	@Enumerated(EnumType.STRING)
	TypeDeStructure TypeDeStructure ;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="Bureau")
	@JsonIgnore
	private Set<Equipements> Equipements;

	@ManyToOne
	@JsonIgnore

    private User user;


}
