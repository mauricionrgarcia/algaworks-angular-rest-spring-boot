package com.algaworks.algamoneyapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Entidade que possui as inforações de endereço da tabela TB_PERSON
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 16/09/2017 13:08:37
 */
@Embeddable
public class Address implements Serializable {

	/**
	 * Atributo de serialização
	 */
	private static final long serialVersionUID = 7818867141894929767L;

	/**
	 * logradouro
	 */
	@NotBlank
	@Column(name = "TX_ADDRESS_STREET")
	private String street;

	/**
	 * number
	 */
	@NotNull
	@Column(name = "TX_ADDRESS_NUMBER")
	private String number;

	/**
	 * bairro
	 */
	@NotNull
	@Column(name = "TX_ADDRESS_DISTRICT")
	private String district;

	/**
	 * CEP
	 */
	@NotNull
	@Column(name = "TX_ADDRESS_ZIP_CODE")
	private String zipCode;

	/**
	 * cidade
	 */
	@NotNull
	@Column(name = "TX_ADDRESS_CITY")
	private String city;

	/**
	 * estado
	 */
	@NotNull
	@Column(name = "TX_ADDRESS_STATE")
	private String state;

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [street=" + street + ", number=" + number + ", district=" + district + ", zipCode=" + zipCode
				+ ", city=" + city + ", state=" + state + "]";
	}

}
