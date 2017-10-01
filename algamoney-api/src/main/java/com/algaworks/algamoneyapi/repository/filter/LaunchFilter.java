package com.algaworks.algamoneyapi.repository.filter;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.algaworks.algamoneyapi.model.Launch;

/**
 * Classe de filtro que atende a entidade {@link Launch}
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 23/09/2017 14:08:39
 */
public class LaunchFilter {

	/**
	 * descrição
	 */
	private String description;

	/**
	 * intervalo de
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDtDue;

	/**
	 * intervalo até
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate endDtDue;

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
	 * @return the startDtDue
	 */
	public LocalDate getStartDtDue() {
		return startDtDue;
	}

	/**
	 * @param startDtDue the startDtDue to set
	 */
	public void setStartDtDue(LocalDate startDtDue) {
		this.startDtDue = startDtDue;
	}

	/**
	 * @return the endDtDue
	 */
	public LocalDate getEndDtDue() {
		return endDtDue;
	}

	/**
	 * @param endDtDue the endDtDue to set
	 */
	public void setEndDtDue(LocalDate endDtDue) {
		this.endDtDue = endDtDue;
	}

}
