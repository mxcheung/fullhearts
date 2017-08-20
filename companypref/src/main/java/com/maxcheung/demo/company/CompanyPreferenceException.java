package com.maxcheung.demo.company;

/**
 * Exception to be thrown when there was an error while managing {@link au.com.superchoice.epm.rest.user.model.UserAuthPermission}s.
 */
public class CompanyPreferenceException extends RuntimeException {

    public CompanyPreferenceException(String message) {
        super(message);
    }

    public CompanyPreferenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
