package com.example.practica.Service;

import com.example.practica.Repo.CompanieRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanieServiceUDS implements UserDetailsService {
    private final CompanieRepo companieRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return this.companieRepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Nope"));
    }
}
