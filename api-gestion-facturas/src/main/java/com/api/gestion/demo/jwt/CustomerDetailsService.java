package com.api.gestion.demo.jwt;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.gestion.demo.pojo.User;
import com.api.gestion.demo.repository.UserRepository;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerDetailsService implements UserDetailsService {

    private User user;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("DEntro de loaduserByusername {}",username);
        user = userRepository.findByEmail(username);
        if(!Objects.isNull(user)){
            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
        }else{
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }

    public User getUserDetails(){
        return user;
    }

    
    
    
}
