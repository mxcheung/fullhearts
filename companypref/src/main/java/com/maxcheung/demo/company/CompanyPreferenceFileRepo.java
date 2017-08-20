package com.maxcheung.demo.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyPreferenceFileRepo {

	public static final String DEFAULT_AUTH_PERMISSIONS_JSON = "classpath:definitions/AvailablePreferences.json";
	public static final String USER_AUTH_PERMISSIONS_JSON = "company.auth.permissions.json";

	@Value("${" + USER_AUTH_PERMISSIONS_JSON + ":" + DEFAULT_AUTH_PERMISSIONS_JSON + "}")
	private Resource resource;

	@Autowired
	private ObjectMapper objectMapper;

	Map<String, Map<String, CompanyPreferenceGroup>> permissions;

	@PostConstruct
	void checkResource() throws CompanyPreferenceException {
		// Try reading the resource so that it fails the server to startup if there were
		// any issues.
		getAllUserAuthPermissions();
	}

	// @Override
	public Map<String, Map<String, CompanyPreferenceGroup>> getAllUserAuthPermissions()
			throws CompanyPreferenceException {
		// Load JSON from file.
		try {
			permissions = objectMapper.readValue(resource.getInputStream(),
					new TypeReference<Map<String, Map<String, CompanyPreferenceGroup>>>() {
					});
			return permissions;
		} catch (IOException ex) {
			throw new CompanyPreferenceException("Error loading available permissions.", ex);
		}
	}

	public Map<String, CompanyPreferenceGroup> getAllUserAuthPermissionsByKey(String key){
		return permissions.get(key);
	}

	public CompanyPreferenceGroup getAllUserAuthPermissionsByKeyAndRuleId(String key, String ruleIdentifier) {
		Map<String, CompanyPreferenceGroup> x = getAllUserAuthPermissionsByKey(key);
		CompanyPreferenceGroup y = x.get(ruleIdentifier);
		return getAllUserAuthPermissionsByKey(key).get(ruleIdentifier);
	}

	public CompanyPreference getAllUserAuthPermissionsByKeyAndRuleAndCode(String key,  String ruleIdentifier, String code) {
		Map<String, CompanyPreferenceGroup> map = getAllUserAuthPermissionsByKey(key);
		CompanyPreferenceGroup companyPreferenceGroup = map.get(ruleIdentifier);
		return companyPreferenceGroup.getPermissionByRuleIdentifierAndCode(ruleIdentifier, code);
	}

}
