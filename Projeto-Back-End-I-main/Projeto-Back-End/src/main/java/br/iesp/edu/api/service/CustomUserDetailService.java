package br.iesp.edu.api.service;

import br.iesp.edu.api.entity.Cadastro;
import br.iesp.edu.api.entity.Login;
import br.iesp.edu.api.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomUserDetailService implements UserDetailsService {

    private final LoginRepository loginRepository;

    @Autowired
    public CustomUserDetailService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        if (email==null){
            throw new UsernameNotFoundException("Email não cadastrado");
        }
        Cadastro login = loginRepository.findByEmail(email);

        List<GrantedAuthority> authoritulstAdmin = AuthorityUtils.createAuthorityList("ROLE_USER","ROLE_ADMIN");
        List<GrantedAuthority> authoritulstUser = AuthorityUtils.createAuthorityList("ROLE_USER");

        return new User(login.getEmail(),login.getSenha(),authoritulstAdmin);


    }
}
