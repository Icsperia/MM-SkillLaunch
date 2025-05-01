package com.example.practica.Service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ComposeDetailsService implements UserDetailsService {
    @Autowired
    private final StudentServiceUDS studentServiceUDS;
    @Autowired
    private final CompanieServiceUDS companieServiceUDS;

    private List<UserDetailsService> services;


@PostConstruct
    public void setServices() {
    List<UserDetailsService> services = new ArrayList<>();
    services.add(this.studentServiceUDS);
    services.add(this.companieServiceUDS);
}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
for (UserDetailsService service : services) {
    try {
        return service.loadUserByUsername(username);
    }catch (UsernameNotFoundException e) {
        continue;
    }
}
throw new UsernameNotFoundException(username);

}


}