package com.algaworks.algamoneyapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidade que atende a tabela TB_PERMISSION
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 10/12/2017 17:11:33
 */
@Entity
@Table(name = "TB_PERMISSION")
public class Permission implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1073654251736126519L;

	@Id
	@Column(name = "PK_PERMISSION")
	private Long code;

	@Column(name = "TX_DESCRIPTION")
	private String description;

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

}
