package com.maxcheung.demo.company;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A group of user auth permissions. It ontains a set of {@link CompanyPreference}
 */
public class CompanyPreferenceGroup implements Serializable {

    private static final long serialVersionUID = 2526456575087595474L;

    private Set<CompanyPreference> preferences = new HashSet<>();

    public CompanyPreferenceGroup() {
    }
    
    private CompanyPreferenceGroup(CompanyPreferenceGroup other) {
        this.preferences = new HashSet<>(other.getPreferences());
    }

    public Set<CompanyPreference> getPreferences() {
        return preferences;
    }

    public void setPreferences(Set<CompanyPreference> preferences) {
        this.preferences = preferences;
    }

    public Set<CompanyPreference> getPermissionsByRuleIdentifier(String ruleIdentifier) {
        Set<CompanyPreference> match = new HashSet<>();
        for (CompanyPreference preference : preferences) {
            if (preference.getRuleIdentifier().equals(ruleIdentifier)) {
                match.add(preference);
            }
        }
        return match;
    }

    public CompanyPreference getPermissionByRuleIdentifierAndCode(String ruleIdentifier, String code) {
        Set<CompanyPreference> preferences = getPermissionsByRuleIdentifier(ruleIdentifier);
        for (CompanyPreference preference : preferences) {
            if (preference.getCode().equals(code)) {
                return preference;
            }
        }
        return null;
    }



    /**
     * Updates the rule identifier of all the underlying permissions.
     * This method recreates the permissions set because by setting the rule ID, each permission's
     * hash code changes - since HashSet is backed by HashMap, we will need to recreate the
     * HashSet to make iterator.remove() to work for example.
     *
     * @param ruleId rule ID to set.
     */
    public void setRuleIdentifier(String ruleId) {
        Set<CompanyPreference> newPreferences = new HashSet<>();
        for (CompanyPreference preference : this.preferences) {
        	preference.setRuleIdentifier(ruleId);
        	newPreferences.add(preference);
        }
        this.preferences = newPreferences;

    }
}
