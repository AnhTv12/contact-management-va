package org.alicoder.spring.contactmanagement.service.impl;

import org.alicoder.spring.contactmanagement.payload.LoginPayload;
import org.alicoder.spring.contactmanagement.repository.UserRepository;
import org.alicoder.spring.contactmanagement.service.AuthenticationService;
import org.alicoder.spring.contactmanagement.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired UserRepository userRepository;

    @Override
    public boolean login(LoginPayload payload) throws NoSuchAlgorithmException {
        return userRepository.existsByEmailAndPassword(payload.getEmail(), MD5Util.encrypt(payload.getPassword()));
    }
}
