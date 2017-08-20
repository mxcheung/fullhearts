package com.maxcheung.demo.company;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maxcheung.demo.company.CompanyPreference;
import com.maxcheung.demo.company.CompanyPreferenceGroup;


public class CompanyPreferenceTest {

    @Test
    public void shouldBoo() throws JsonProcessingException {
        System.out.println("boo");
        ObjectMapper mapper = new ObjectMapper();
        
        
        CompanyPreference generalPreference1 = new CompanyPreference("General","SaleforceEnabled", "Salesforce Enabled", "Salesforce Enabled");
        CompanyPreference generalPreference2 = new CompanyPreference("General","LucasEnabled", "Lucas Enabled", "Lucas Enabled");
        
        
        
        CompanyPreference companyPreference1 = new CompanyPreference("Company","ViewAnalystRequired", "View Analyst Required", "View Analyst Required Section");
        CompanyPreference companyPreference2 = new CompanyPreference("Company","ViewCompanyNotes", "View Company (Notes)", "View Company Notes Section");
        CompanyPreference productPreference1 = new CompanyPreference("Product","ViewProductAssetClassifiers", "View Product (Asset Classifiers)", "View Product Asset Classifiers Section");
        CompanyPreference productPreference2 = new CompanyPreference("Product","ViewProductDataCollectionType", "View Product (Data Collection Type)", "View Product Data Collection Type Section");
        CompanyPreference productPreference3 = new CompanyPreference("Product","ViewProductAssetNotes", "View Product (Notes)", "View Product Notes Section");

        CompanyPreferenceGroup companyPreferenceGroup0 =  new CompanyPreferenceGroup();
        companyPreferenceGroup0.setRuleIdentifier("General");
        companyPreferenceGroup0.getPreferences().add(generalPreference1);
        companyPreferenceGroup0.getPreferences().add(generalPreference2);

        CompanyPreferenceGroup companyPreferenceGroup1 =  new CompanyPreferenceGroup();
        companyPreferenceGroup1.setRuleIdentifier("Company");
        companyPreferenceGroup1.getPreferences().add(companyPreference1);
        companyPreferenceGroup1.getPreferences().add(companyPreference2);
        

        CompanyPreferenceGroup companyPreferenceGroup2 =  new CompanyPreferenceGroup();
        companyPreferenceGroup2.setRuleIdentifier("Product");
        companyPreferenceGroup2.getPreferences().add(productPreference1);
        companyPreferenceGroup2.getPreferences().add(productPreference2);
        companyPreferenceGroup2.getPreferences().add(productPreference3);
        
        
        Map<String, CompanyPreferenceGroup> permissions = new HashMap<String, CompanyPreferenceGroup>();
        permissions.put("General", companyPreferenceGroup0);
        permissions.put("Company", companyPreferenceGroup1);
        permissions.put("Product", companyPreferenceGroup2);
        
        
        
        Map<String, Map<String, CompanyPreferenceGroup>> x = new HashMap<String, Map<String, CompanyPreferenceGroup>>();
        x.put("ALL", permissions);
        x.put("LR", permissions);
        x.put("SR", permissions);
        
      //Object to JSON in String
        String jsonInString = mapper.writeValueAsString(x);
        System.out.println(jsonInString);
    }
    
}
