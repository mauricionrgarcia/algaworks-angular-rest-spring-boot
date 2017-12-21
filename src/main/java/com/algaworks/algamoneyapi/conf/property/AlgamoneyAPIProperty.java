package com.algaworks.algamoneyapi.conf.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * system configuration properties
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 19/12/2017 23:30:08
 */
@ConfigurationProperties("algamoney")
public class AlgamoneyAPIProperty {

	private final Security security = new Security();

	/**
	 * Security properties
	 *
	 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
	 * @version
	 * @sinse 19/12/2017 23:29:55
	 */
	public static class Security {

		private Boolean enagleHttps = Boolean.FALSE;

		/**
		 * @return the enagleHttps
		 */
		public Boolean getEnagleHttps() {
			return enagleHttps;
		}

		/**
		 * @param enagleHttps the enagleHttps to set
		 */
		public void setEnagleHttps(Boolean enagleHttps) {
			this.enagleHttps = enagleHttps;
		}

	}

	/**
	 * @return the security
	 */
	public Security getSecurity() {
		return security;
	}

}
