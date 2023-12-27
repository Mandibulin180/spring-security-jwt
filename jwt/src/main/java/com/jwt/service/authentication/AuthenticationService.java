package com.jwt.service.authentication;

import com.jwt.dto.AuthenticationRequest;
import com.jwt.dto.AuthenticationResponse;
import com.jwt.dto.RegisterRequest;

public interface AuthenticationService {

    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);
    
}
