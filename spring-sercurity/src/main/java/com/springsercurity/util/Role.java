package com.springsercurity.util;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public enum Role {
    
    CUSTOMER(Arrays.asList(Permission.READ_ALL_PRODUCTS)),
    ADMINISTRATOR(Arrays.asList(Permission.SAVE_ONE_PRODUCT, Permission.READ_ALL_PRODUCTS));

    private List<Permission> permissions;

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

}
