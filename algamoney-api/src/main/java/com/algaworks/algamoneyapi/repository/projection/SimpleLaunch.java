package com.algaworks.algamoneyapi.repository.projection;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.algaworks.algamoneyapi.model.Launch;
import com.algaworks.algamoneyapi.model.TypeLaunch;

/**
 * Resumo da consulta que atende um {@link Launch}
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 10/12/2017 21:50:52
 */
public class SimpleLaunch {

	private Long code;
	private String description;
	private LocalDate dtDue;
	private LocalDate dtPayment;
	private BigDecimal totalAmount;
	private TypeLaunch type;
	private String category;
	private String person;

	public SimpleLaunch(Long code, String description, LocalDate dtDue, LocalDate dtPayment,
			BigDecimal totalAmount, TypeLaunch type, String category, String person) {
		super();
		this.code = code;
		this.description = description;
		this.dtDue = dtDue;
		this.dtPayment = dtPayment;
		this.totalAmount = totalAmount;
		this.type = type;
		this.category = category;
		this.person = person;
	}

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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the dtDue
	 */
	public LocalDate getDtDue() {
		return dtDue;
	}

	/**
	 * @param dtDue the dtDue to set
	 */
	public void setDtDue(LocalDate dtDue) {
		this.dtDue = dtDue;
	}

	/**
	 * @return the dtPayment
	 */
	public LocalDate getDtPayment() {
		return dtPayment;
	}

	/**
	 * @param dtPayment the dtPayment to set
	 */
	public void setDtPayment(LocalDate dtPayment) {
		this.dtPayment = dtPayment;
	}

	/**
	 * @return the totalAmount
	 */
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * @return the type
	 */
	public TypeLaunch getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(TypeLaunch type) {
		this.type = type;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the person
	 */
	public String getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(String person) {
		this.person = person;
	}

}
