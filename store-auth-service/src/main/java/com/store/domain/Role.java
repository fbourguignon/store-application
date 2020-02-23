package com.store.domain;


import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity(name = "tb_role")
@Getter
@Setter
public class Role implements GrantedAuthority {


    public Role(String name) {
        this.name = name;
    }
    public Role() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;


    @Override
    public String getAuthority() {
        return  this.name;
    }
}
