package com.maxcheung.demo.company;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = CompanyPreferenceController.BASE_CONTEXT)
public class CompanyPreferenceController {

	static final String BASE_CONTEXT = "/v1/companypreference";
	static final String TEST_MAPPING = "/test";

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	CompanyPreferenceFileRepo userAuthPreferenceFileRepo;

	@RequestMapping(value = TEST_MAPPING, method = GET)
	@ResponseStatus(OK)
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") final String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@RequestMapping(value = "/testprefByKey", method = GET)
	@ResponseStatus(OK)
	public ResponseEntity<Map<String, CompanyPreferenceGroup>> greetingPrefAvailByKey(
			@RequestParam(value = "key", defaultValue = "ALL") final String key) {
		Map<String, CompanyPreferenceGroup> data = userAuthPreferenceFileRepo.getAllUserAuthPermissionsByKey(key);
		if (data == null) {
			return new ResponseEntity<Map<String, CompanyPreferenceGroup>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>((data), HttpStatus.OK);
	}

	@RequestMapping(value = "/testprefByKeyAndRuleId", method = GET)
	@ResponseStatus(OK)
	public ResponseEntity<CompanyPreferenceGroup> greetingPrefAvailByKeyAndRuleId(
			@RequestParam(value = "key", defaultValue = "LR") final String key,
			@RequestParam(value = "ruleIdentifier", defaultValue = "General") final String ruleIdentifier) {
		CompanyPreferenceGroup data = userAuthPreferenceFileRepo.getAllUserAuthPermissionsByKeyAndRuleId(key,
				ruleIdentifier);
		if (data == null) {
			return new ResponseEntity<CompanyPreferenceGroup>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>((data), HttpStatus.OK);
	}

	@RequestMapping(value = "/testprefByKeyAndRuleIdAndCode", method = GET)
	@ResponseStatus(OK)
	public ResponseEntity<CompanyPreference> getAllUserAuthPermissionsByKeyAndRuleAndCode(
			@RequestParam(value = "key", defaultValue = "LR") final String key,
			@RequestParam(value = "ruleIdentifier", defaultValue = "General") final String ruleIdentifier,
			@RequestParam(value = "code", defaultValue = "SaleforceEnabled") final String code) {

		CompanyPreference data = userAuthPreferenceFileRepo.getAllUserAuthPermissionsByKeyAndRuleAndCode(key,
				ruleIdentifier, code);
		if (data == null) {
			return new ResponseEntity<CompanyPreference>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>((data), HttpStatus.OK);
	}

}