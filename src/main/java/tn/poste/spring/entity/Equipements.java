package tn.poste.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


//@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
@Table( name = "Equipements")
public class Equipements  implements Serializable {
	 private static final long serialVersionUID = 1L;

	
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="idEq")
	private long idEq;
		@Column(name="Nature")
		private String Nature;
		@Column(name="Marque")
		private String Marque;
	@Column(name="Codeabarre")
	private String Codeabarre;
	@Column(name="Diagnostic")
	private String Diagnostic;
	@Column(name="Date_Affectation")
	@Temporal(TemporalType.DATE)
	private Date Date_Affectation;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="equipements")
	@JsonIgnore
	private Set<HistoriqueDeReparation> HistoriqueDeReparation;
	@ManyToOne
	@JsonIgnore
	Bureau Bureau;
	@JsonIgnore
    @ManyToOne
    private User user;
}
