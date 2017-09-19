package pe.camm.springhibernatecrud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRY")
public class Country {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "countryName")
	private String countryName;

	@Column(name = "population")
	private Long population;

	public Country() {
		super();
	}

	public Country(Integer id, String countryName, Long population) {
		super();
		this.id = id;
		this.countryName = countryName;
		this.population = population;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Country [id=");
		builder.append(id);
		builder.append(", countryName=");
		builder.append(countryName);
		builder.append(", population=");
		builder.append(population);
		builder.append("]");
		return builder.toString();
	}

}
