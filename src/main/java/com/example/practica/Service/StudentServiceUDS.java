
package com.example.practica.Service;

import com.example.practica.Entity.Role;
import com.example.practica.Repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor

public class StudentServiceUDS implements UserDetailsService {

    private final StudentRepo studentRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return this.studentRepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Nope"));
    }
}
