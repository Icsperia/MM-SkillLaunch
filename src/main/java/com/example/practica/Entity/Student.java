package com.example.practica.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.*;

@Entity
@Builder
@RequiredArgsConstructor
@AllArgsConstructor

@Table(name = "Student", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email_institutional"}),
        @UniqueConstraint(columnNames = {"parola"})
})

public  class Student implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prenume")
    private String firstName;

    @Column(name = "nume")
    private String lastName;
    @Column(name = "email_institutional")
    private String email;

    @Column(name = "parola")
    private String password;

    @Column(name = "facultate")
    private String facultate;

    @Column(name = "universitate")
    private String universitate;

    @Enumerated(EnumType.STRING)
    private Role role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @ManyToMany(mappedBy = "student")
    private Set<StudentDetails> studentDetails = new HashSet<>();

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}