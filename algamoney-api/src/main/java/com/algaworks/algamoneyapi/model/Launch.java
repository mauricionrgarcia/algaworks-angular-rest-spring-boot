package com.algaworks.algamoneyapi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Entidade que atende a tabela TB_LAUNCH
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 22/09/2017 00:03:43
 */
@Entity
@Table(name = "TB_LAUNCH")
public class Launch implements Serializable {

	/**
	 * Atributo de serialização
	 */
	private static final long serialVersionUID = -8778249936073982997L;

	/**
	 * codigo
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_LAUNCH")
	private Long code;

	/**
	 * descrição
	 */
	@NotNull
	@Column(name = "TX_DESCRIPTION")
	private String description;

	/**
	 * vencimento
	 */
	@NotNull
	@Column(name = "DT_DUE")
	private LocalDate dtDue;

	/**
	 * pagamento
	 */
	@Column(name = "DT_PAYMENT")
	private LocalDate dtPayment;

	/**
	 * valor
	 */
	@NotNull
	@Column(name = "VL_TOTAL_AMOUNT")
	private BigDecimal totalAmount;

	/**
	 * observação
	 */
	@Column(name = "TX_NOTE")
	private String note;

	/**
	 * tipo de lançamento
	 */
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "ID_TYPE")
	private TypeLaunch type;

	/**
	 * categoria
	 */
	@NotNull
	@ManyToOne()
	@JoinColumn(name = "FK_CATEGORY")
	private Category category;

	/**
	 * pessoa
	 */
	@NotNull
	@ManyToOne()
	@JoinColumn(name = "FK_PERSON")
	private Person person;

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
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
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
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Launch other = (Launch) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

}
