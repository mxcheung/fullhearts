package com.maxcheung.demo.company;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents an user permissions.
 */
public class CompanyPreference implements Serializable {
	private static final long serialVersionUID = -1514493789095594313L;

	@JsonIgnore
	private String preferenceIdentifier;

	private String ruleIdentifier;
	private String code;
	private String label;
	private String desc;

	public CompanyPreference() {
	}

	public CompanyPreference(String ruleIdentifier, String code, String label, String desc) {
		this.ruleIdentifier = ruleIdentifier;
		this.code = code;
		this.label = label;
		this.desc = desc;
	}

	public String getRuleIdentifier() {
		return ruleIdentifier;
	}

	public void setRuleIdentifier(String ruleIdentifier) {
		this.ruleIdentifier = ruleIdentifier;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * Returns the unique identifier of the permission. Permission code is required
	 * to be unique within the same rule identifier.
	 * 
	 * @return permission identifier.
	 */
	@JsonProperty("preferenceIdentifier")
	public String getPreferenceIdentifier() {
		preferenceIdentifier = ruleIdentifier + "." + code;
		return preferenceIdentifier;
	}

	@JsonIgnore
	public void setPreferenceIdentifier(String preferenceIdentifier) {
		this.preferenceIdentifier = preferenceIdentifier;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		CompanyPreference rhs = (CompanyPreference) obj;
		return new EqualsBuilder().append(this.ruleIdentifier, rhs.ruleIdentifier).append(this.code, rhs.code)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(ruleIdentifier).append(code).toHashCode();
	}
}
