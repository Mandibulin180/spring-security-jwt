package com.api.gestion.demo.service.impl;

import java.util.Map;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.gestion.demo.constantes.FacturaConstantes;
import com.api.gestion.demo.pojo.User;
import com.api.gestion.demo.repository.UserRepository;
import com.api.gestion.demo.service.UserService;
import com.api.gestion.demo.util.FacturaUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        log.info("REgistro interno de un usuario {}",requestMap);
        try {
            if (validateSignUpMap(requestMap)) {
                User user = userRepository.findByEmail(requestMap.get("email"));
                if (Objects.isNull(user)) {
                    userRepository.save(getuserFromMap(requestMap));
                    return FacturaUtils.getResponseEntity("Usuario registrado con exito", HttpStatus.CREATED);
                }else{
                    return FacturaUtils.getResponseEntity("El ususario con ese email ya existe", HttpStatus.BAD_REQUEST);
                }
            }else{
                return FacturaUtils.getResponseEntity(FacturaConstantes.INVALID_DATA, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return FacturaUtils.getResponseEntity(FacturaConstantes.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private boolean validateSignUpMap(Map<String, String> requestMap){
        if( requestMap.containsKey("nombre") &&
            requestMap.containsKey("numeroContacto") &&
            requestMap.containsKey("email")&&
            requestMap.containsKey("password")){
                return true;
            }
        return false;
    }

    private User getuserFromMap(Map<String, String> requestMap){
        User user = new User();
        user.setNombre(requestMap.get("nombre"));
        user.setNumeroContacto(requestMap.get("numeroContacto"));
        user.setEmail(requestMap.get("email"));
        user.setPassword(requestMap.get("password"));
        user.setStatus("false");
        user.setRole("user");
        return user;
    }
    
}
