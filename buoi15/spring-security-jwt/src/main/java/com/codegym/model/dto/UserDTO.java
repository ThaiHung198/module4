package com.codegym.model.dto;

import java.util.Set;

public class UserDTO {
    private Long id;
    private String name;
    private Set<String> roles;

    public UserDTO() {
    }

    public UserDTO(Long id, String name, Set<String> roles) {
        this.id = id;
        this.name = name;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
