package br.iesp.edu.api.service;

import br.iesp.edu.api.entity.Login;
import br.iesp.edu.api.repository.LoginRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class DetalheUsuárioServiceImpl implements UserDetailsService {

    private final LoginRepository repository;

    public DetalheUsuárioServiceImpl(LoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Login> usuario  = repository.findById(username);
        return null;
    }
}
