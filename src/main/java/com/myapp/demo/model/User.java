package com.myapp.demo.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    public String password;

    //why do we do this empty constructor again
    public User(){
    }

    public User(String username,String password){
        this.username = username;
        this.password = password;

    }

    public Long getId(){
        return id;
    }

    //why do we use override
    @Override
    public String getUsername(){return username;}

    @Override
    public String getPassword(){return password;}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return List.of();
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }

}
