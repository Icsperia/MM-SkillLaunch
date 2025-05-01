package com.example.practica.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Builder
@Getter
@Setter
@Entity
@Table(name="Companie", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email_companie"}),
        @UniqueConstraint(columnNames = {"parola"}),
        @UniqueConstraint(columnNames = {"nume_companie"})
})

@NoArgsConstructor
@AllArgsConstructor
public class Companie implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;

    private String name;
    @Email
    private String email;

    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToMany(mappedBy = "companie")
    private Set<CompanieDetails> companieDetails= new HashSet<>();


    @OneToOne(mappedBy = "companie")
    private TokenCompanie companieToken;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

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



