package com.algaworks.algamoneyapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entidade que atende a tabela TB_PERSON
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 16/09/2017 12:44:44
 */
@Entity
@Table(name = "TB_PERSON")
public class Person implements Serializable {

	/**
	 * Atributo de serialização
	 */
	private static final long serialVersionUID = 567662710616656166L;

	/**
	 * Codigo da entidade
	 */
	@Id
	@Column(name = "PK_PERSON")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;

	/**
	 * Nome da pessoa
	 */
	@NotNull
	@NotEmpty
	@Column(name = "TX_NAME")
	private String name;

	/**
	 * Representa se o usuario esta ativo
	 */
	@Column(name = "ID_ACTIVE")
	@NotNull
	private Boolean active;

	/**
	 * Representa o endereço
	 */
	@NotNull
	@Valid
	@Embedded
	private Address address;

	/**
	 * @return the code
	 */
	public Long getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(Long code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [code=" + code + ", name=" + name + ", active=" + active + ", address=" + address + "]";
	}

}
