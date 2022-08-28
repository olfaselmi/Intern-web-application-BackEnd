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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
//@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
@Table( name = "HistoriqueDeReparation")
public class HistoriqueDeReparation implements Serializable {
	 private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IdHistorique")
	private Long IdHistorique;
	@Enumerated(EnumType.STRING)
	TypeDePanne TypeDePanne ;
	@Column(name="DateDePanne")
	private Date DateDePanne;
	@Column(name="DateDerepartition")
	private Date DateDerepartition;
	@ManyToOne
	@JsonIgnore
	Equipements equipements;
	@ManyToOne
	@JsonIgnore
    private User user;
	
}
