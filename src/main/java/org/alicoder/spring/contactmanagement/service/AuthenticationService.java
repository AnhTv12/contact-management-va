package org.alicoder.spring.contactmanagement.service;

import org.alicoder.spring.contactmanagement.payload.LoginPayload;

import java.security.NoSuchAlgorithmException;

public interface AuthenticationService {

    boolean login(LoginPayload payload) throws NoSuchAlgorithmException;
}
