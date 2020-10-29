package co.com.masivian.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Data
@Entity
@Table(name = "Roulette")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Roulette {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRoulette;
	
	
	@Column
	private Integer number;
	
	@Column
	private String colour;
	
	@Column
	private boolean estado;
	
}
